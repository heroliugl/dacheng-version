package com.dacheng.push.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dacheng.push.constant.ErrConstant;
import com.dacheng.push.entity.Car;
import com.dacheng.push.entity.Project;
import com.dacheng.push.entity.ProjectType;
import com.dacheng.push.entity.Record;
import com.dacheng.push.entity.User;
import com.dacheng.push.entity.UserProject;
import com.dacheng.push.entity.view.RecordView;
import com.dacheng.push.entity.view.RemindView;
import com.dacheng.push.service.CarService;
import com.dacheng.push.service.MaintainService;
import com.dacheng.push.service.UserService;
import com.dacheng.push.utils.Base64Coder;
import com.dacheng.push.utils.JsonMapper;
import com.dacheng.push.utils.ServiceConfig;

@Controller
@RequestMapping(value = "/maintainInterface")
public class MaintainController {
	//保养Biz接口
	@Resource
	private MaintainService maintainService;
	//车辆Biz接口
	@Resource
	private CarService carService;
	
	@Resource
	private UserService userService;

	//保养项目实体对象
	private Project project;
	//保养记录实体对象
	private Record record;
	//车辆实体对象
	private Car car;
	
	//保养项目实体对象集合
	private List<Project> projects;
	//保养记录实体对象集合
	private List<Record> records;
	//保养项目类型实体对象集合
	private List<ProjectType> projectTypes;
	//用户自己设置的保养项目实体对象集合
	private List<UserProject> userProjects;
	

	//保养记录View实体对象集合
	private List<RecordView> recordViews;
	
	//日志
	private Logger logger = LoggerFactory.getLogger(MaintainController.class);
	
	
	// private static final String serverIP="192.168.1.234";
	public static String serverIP = ServiceConfig.getInstance().getValue(
			"serverIP");
	
	/**
	 * 查询所有保养项目信息
	 * @return
	 */
	@RequestMapping("getProjects")
	@ResponseBody
	public String getProjectTypes(@RequestParam(value="loginname", required = true) String loginname) {
		logger.info("查询所有保养项目信息");
		try {
			User user = this.userService.findUserByLoginname(loginname);
			Map<String, String> map1 = new HashMap<String, String>();
			if(user==null||user.getUserid()<=0){
				map1.put("code", ErrConstant.CODE_USER_NOT_EXIST);
				map1.put("info", ErrConstant.MSG_USER_NOT_EXIST);
				return JsonMapper.mapToJson(map1);
			}
			int userid = user.getUserid();
			//调用《ProjectMapper》的《查询所有保养项目信息》方法
			projectTypes = this.maintainService.findProjectTypes();
			//判断用户实体对象集合是否为null，并且size是否大于0
			if (projectTypes != null && projectTypes.size() > 0){
				StringBuffer sb = new StringBuffer("{\"code\":\"200\",\"info\":\"success\",\"list\":");
				List<Object> list= new ArrayList<Object>();
				for (ProjectType projectType : projectTypes) {
					Map<String, Object> map = new HashMap<String, Object>();
					projects = new ArrayList<Project>();
					projects = this.maintainService.findProjectByTypeid(projectType.getTypeid());
					if (projects != null && projects.size() > 0) {
						//调用《maintainService》的《根据用户ID查询用户自己设置的保养项目》方法
						userProjects = this.maintainService.findUserProjectByUserid(userid);
						if (userProjects != null && userProjects.size() > 0) {
							for (int i = 0; i < userProjects.size(); i++) {
								for (int j = 0; j < projects.size(); j++) {
									if (userProjects.get(i).getProjectid() == projects.get(j).getProjectid()) {
										projects.get(j).setMileage(userProjects.get(i).getMileage());
									}
								} 
							}
						}
					}
					// JSONArray projectsJsonArray = JSONArray.fromObject(projects);
					map.put("typename", projectType.getTypename());
					map.put("projects", projects);
					list.add(map);
					// sb.append(JsonMapper.listToJsonChineseManualNamingList(projectType.getTypename(), projects));
				}
				JSONArray jsonArray = JSONArray.fromObject(list);
				sb.append(jsonArray.toString());
				sb.append("}");
				System.out.println(sb.toString());
				return sb.toString();
			}else{
				//调用《JsonMapper》的《没有查询到数据》方法
				return JsonMapper.notFindJson();
			}
		} catch (Exception e) {
			e.printStackTrace();
			//调用《JsonMapper》的《错误返回码转换成JSON》方法
			return JsonMapper.failedToJson();
		}
	}
	
	/**
	 * 查询所有保养记录信息
	 * @return
	 */
	@RequestMapping("getRecords")
	@ResponseBody
	public String getRecords(@RequestParam(value="loginname", required = true) String loginname) {
		logger.info("查询所有保养记录信息");
		try {
			User user = this.userService.findUserByLoginname(loginname);
			Map<String, String> map = new HashMap<String, String>();
			if(user==null||user.getUserid()<=0){
				map.put("code", ErrConstant.CODE_USER_NOT_EXIST);
				map.put("info", ErrConstant.MSG_USER_NOT_EXIST);
				return JsonMapper.mapToJson(map);
			}
			List<Car> tempList= this.carService.findCarByUserid(user.getUserid());
			if(tempList==null||tempList.isEmpty()){
				map.put("code", ErrConstant.CODE_NO_DATA);
				map.put("info", ErrConstant.MSG_NO_DATA);
				return JsonMapper.mapToJson(map);
			}
			int carid = tempList.get(0).getCarid();
			//调用《maintainService》的《查询所有保养记录信息》方法
			recordViews = this.maintainService.findRecords(carid);
			//判断用户实体对象集合是否为null，并且size是否大于0
			if (recordViews != null && recordViews.size() > 0){
				//调用《JsonMapper》的《把List集合转换成JSON并自动命名》方法
				System.out.println(JsonMapper.listToJsonAutoNamingList(recordViews));
				return JsonMapper.listToJsonAutoNamingList(recordViews);
			}else{
				//调用《JsonMapper》的《没有查询到数据》方法
				return JsonMapper.notFindJson();
			}
		} catch (Exception e) {
			e.printStackTrace();
			//调用《JsonMapper》的《错误返回码转换成JSON》方法
			return JsonMapper.failedToJson();
		}
	}

	/**
	 * 保存保养记录信息
	 * @return
	 */
	@RequestMapping(value = "/addMaintainRecord")
	@ResponseBody
	public String createRecord(@RequestParam(value="loginname", required = true) String loginname, 
			@RequestParam(value="projectid", required = true) int projectid, 
			@RequestParam(value="recorddate", required = true) String recorddate, 
			@RequestParam(value="mileage", required = true) String mileage, 
			@RequestParam(value="totalfee", required = true) String totalfee, 
			@RequestParam(value="workfee", required = true) String workfee,
			@RequestParam(value="other", required = false) String other) {
		logger.info("保存保养记录信息");
		try {
			User user = userService.createUserIfNoExist(loginname);
			if(user == null||user.getUserid()<=0){
				return JsonMapper.failedToJson();
			}
			Car car = carService.createCarIfNoExist(user.getUserid());
			if(car==null){
				return JsonMapper.failedToJson();
			}
			int carid = car.getCarid();
			project = new Project();
			project.setProjectid(projectid);
			record = new Record();
			record.setCarid(carid);
			record.setProject(project);
			record.setRecorddate(recorddate);
			record.setMileage(mileage);
			record.setTotalfee(totalfee);
			record.setWorkfee(workfee);
			record.setOther(other);
			//调用《maintainService》的《保存用户信息》方法
			this.maintainService.saveRecord(record);
			//判断数据库受影响行数是否大于0
			if (record.getRecordid() > 0){
				//调用《JsonMapper》的《正确返回码转换成JSON》方法
				return JsonMapper.retSuccessToJson("\"recordid\":\"" + record.getRecordid() + "\"");
			}else{
				//调用《JsonMapper》的《错误返回码转换成JSON》方法
				return JsonMapper.failedToJson();
			}
		} catch (Exception e) {
			e.printStackTrace();
			//调用《JsonMapper》的《错误返回码转换成JSON》方法
			return JsonMapper.failedToJson();
		}
	}
	
	/**
	 * 根据保养记录ID更新保养记录图片
	 * @return
	 */
	@RequestMapping(value = "/uploadRecordPhoto")
	@ResponseBody
	public String uploadRecordPhoto(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="recordid", required = true) int recordid,
			@RequestParam(value="recordphoto", required = true) String recordphoto) throws ServletException, Exception {
		//try {
			logger.info("根据保养记录ID更新保养记录图片");
			records = new ArrayList<Record>();
			StringBuffer filePath = new StringBuffer();
			StringBuffer imageName = new StringBuffer();
			if (recordid > 0){
				if (StringUtils.isNotBlank(recordphoto)){
					record = this.maintainService.findRecordByRecordid(recordid);
					if (record == null){
						return JsonMapper.notFindJson();
					}
					byte[] b = Base64Coder.decodeLines(recordphoto);
					String path = request.getSession().getServletContext().getRealPath("recordphotos");
					File file = new File(path);
					if (!file.exists()) {
						file.mkdirs();
					}  
					filePath.append(path);
					imageName.append(file.getPath()).append("/").append(record.getRecorddate()).append(record.getRecordid()).append(".jpg");
					FileOutputStream fos = new FileOutputStream(imageName.toString());
					fos.write(b);
					fos.flush();
					fos.close();
					StringBuffer recordPhotoUrl = new StringBuffer();
					//InetAddress addr = InetAddress.getLocalHost();
					// String serverIP = addr.getHostAddress(); 
					//获得外网IP地址
					recordPhotoUrl.append("http://").append(serverIP).append(":");
					//获得端口号
					recordPhotoUrl.append(request.getServerPort());
					//获得项目名  
					recordPhotoUrl.append(request.getContextPath());
					//获得目标文件夹
					recordPhotoUrl.append("/recordphotos/");
					//获得文件名
					recordPhotoUrl.append(record.getRecorddate()).append(record.getRecordid()).append(".jpg");
					record.setRecordphoto(recordPhotoUrl.toString());
					int rowNum = this.maintainService.modifyRecordPhoto(recordid, record.getRecordphoto());
					if (rowNum > 0) {
						System.out.println(JsonMapper.retSuccessToJson("\"hearurl\":\"" + record.getRecordphoto() + "\""));
						response.getWriter().write(JsonMapper.retSuccessToJson("\"hearurl\":\"" + record.getRecordphoto() + "\""));
					}else{
						response.getWriter().write(JsonMapper.failedToJson());
					}
				}else{
					response.getWriter().write(JsonMapper.nullParameterToJson());
				}
			}else{
				response.getWriter().write(JsonMapper.nullParameterToJson());
			}
		//} catch (Exception e) {
			//e.printStackTrace();
			//response.getWriter().write(JsonMapper.failedToJson());
		//}
		return null;
	}
	
	/**
	 * 保存用户自己设置的保养项目
	 * @return
	 */
	@RequestMapping(value = "/settingProject")
	@ResponseBody
	public String createProject(@RequestParam(value="userid", required = true) int userid, 
			@RequestParam(value="projectid", required = true) int projectid, 
			@RequestParam(value="mileage", required = true) String mileage) {
		logger.info("保存用户自己设置的保养项目");
		try {
			//调用《maintainService》的《保存用户信息》方法
			int rowNum = this.maintainService.saveUserProject(userid, projectid, mileage);
			//判断数据库受影响行数是否大于0
			if (rowNum > 0){
				//调用《JsonMapper》的《正确返回码转换成JSON》方法
				return JsonMapper.successToJson();
			}else{
				//调用《JsonMapper》的《错误返回码转换成JSON》方法
				return JsonMapper.failedToJson();
			}
		} catch (Exception e) {
			e.printStackTrace();
			//调用《JsonMapper》的《错误返回码转换成JSON》方法
			return JsonMapper.failedToJson();
		}
	}
	
	/**
	 * 保养提醒
	 * @return
	 */
	@RequestMapping(value = "/maintainRemind")
	@ResponseBody
	public String maintainRemind(@RequestParam(value="loginname", required = true) String loginname,
			@RequestParam(value="lang", required = true) String lang) {
		logger.info("保养提醒");
		try {
			User user = userService.createUserIfNoExist(loginname);
			if(user == null||user.getUserid()<=0){
				return JsonMapper.failedToJson();
			}
			Car car = carService.createCarIfNoExist(user.getUserid());
			if(car==null){
				return JsonMapper.failedToJson();
			}
			
			Double nextMileage = 0d;
			Double totalMileage = 0d;
			RemindView remindView = null;
			List<RemindView> remindViews = new ArrayList<RemindView>();
			StringBuffer remind = null;
			List<Project> yesProjects = this.maintainService.findProjectByYesRecord(loginname);
			List<Project> noProjects = this.maintainService.findProjectByNoRecord(loginname);
			records = this.maintainService.findRecordMaxMileageByCarid(loginname);
			car = this.carService.findCarByCarid(loginname);
			
			if (yesProjects != null && yesProjects.size() > 0
					&& records != null && records.size() > 0) {
				for (int i = 0; i < yesProjects.size(); i++) {
					for (int j = 0; j < records.size(); j++) {
						if (yesProjects.get(i).getProjectid() == records.get(j).getProject().getProjectid()) {
							totalMileage = Double.valueOf(records.get(j).getMileage()) + Double.valueOf(yesProjects.get(i).getMileage());
							nextMileage = totalMileage - Double.valueOf(car.getMileage());
							remindView = new RemindView();
							remind = new StringBuffer();
							if(StringUtils.isNotBlank(lang) && lang.equals("en")){  // 英文模式
								remind.append(nextMileage).append("KM left until next ").append(yesProjects.get(i).getEnglishname()).append(" maintenance");
							}else{   // 中文模式
								remind.append("距离下次").append(yesProjects.get(i).getProjectname()).append("保养还有");
								remind.append(nextMileage).append("公里");
							}
							remindView.setRemind(remind.toString());
							remindViews.add(remindView);
						}
					}
				}
			}
			
			for (int i = 0; i < noProjects.size(); i++) {
				nextMileage = Double.valueOf(noProjects.get(i).getMileage()) - Double.valueOf(car.getMileage());
				remindView = new RemindView();
				remind = new StringBuffer();
				if(StringUtils.isNotBlank(lang) && lang.equals("en")){  // 英文模式
					remind.append(nextMileage).append("KM left until next ").append(noProjects.get(i).getEnglishname()).append(" maintenance");
				}else{   // 中文模式
					remind.append("距离下次").append(noProjects.get(i).getProjectname()).append("保养还有");
					remind.append(nextMileage).append("公里");
				}
				remindView.setRemind(remind.toString());
				remindViews.add(remindView);
			}
			//调用《JsonMapper》的《把List集合转换成JSON并自动命名》方法
			System.out.println(JsonMapper.listToJsonAutoNamingList(remindViews));
			return JsonMapper.listToJsonAutoNamingList(remindViews);
		} catch (Exception e) {
			e.printStackTrace();
			//调用《JsonMapper》的《错误返回码转换成JSON》方法
			System.out.println(JsonMapper.failedToJson());
			return JsonMapper.failedToJson();
		}
	}
	
	/**
	 * 根据保养记录ID删除保养记录信息
	 * @param recordid 保养记录ID
	 * @return
	 */
	@RequestMapping(value = "/deleteMyRecord")
	@ResponseBody
	public String deleteMyRecord(@RequestParam(value="recordid", required = true) int recordid) {
		logger.info("根据保养记录ID删除保养记录信息");
		try {
			//调用《maintainService》的《根据保养记录ID删除保养记录信息》方法
			int rowNum = this.maintainService.removeRecordByRecordid(recordid);
			if (rowNum > 0){
				//调用《JsonMapper》的《正确返回码转换成JSON》方法
				return JsonMapper.successToJson();
			}else{
				//调用《JsonMapper》的《错误返回码转换成JSON》方法
				return JsonMapper.failedToJson();
			}
		} catch (Exception e) {
			e.printStackTrace();
			//调用《JsonMapper》的《错误返回码转换成JSON》方法
			return JsonMapper.failedToJson();
		}
	}
	
}
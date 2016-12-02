package com.dacheng.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dacheng.entity.User;
import com.dacheng.service.UserService;
import com.dacheng.utils.Base64Coder;
import com.dacheng.utils.JsonMapper;
import com.dacheng.utils.ServiceConfig;
import com.dacheng.utils.ValidateImage;
import com.dacheng.utils.mail.MailSenderInfo;
import com.dacheng.utils.mail.SimpleMailSender;

@Controller
@RequestMapping(value = "/userInterface")
public class UserController {
	//用户Biz接口
	@Resource
	private UserService userService;
	
	//用户实体对象
	private User user;
	
	//用户实体对象集合
	private List<User> users;
	
	//日志
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	// private static final String serverIP="192.168.1.234";
	
	public static String serverIP = ServiceConfig.getInstance().getValue(
			"serverIP");
	
	/**
	 * 查询所有用户信息方法
	 * @return
	 */
	@RequestMapping("getUsers")
	@ResponseBody
	public String getUsers() {
		logger.info("查询所有用户信息方法");
		try {
			//调用《userService》的《查询所有用户信息》方法
			users = this.userService.findUsers();
			//判断用户实体对象集合是否为null，并且size是否大于0
			if (users != null && users.size() > 0){
				//调用《JsonMapper》的《把List集合转换成JSON并自动命名》方法
				return JsonMapper.listToJsonAutoNamingList(users);
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
	 * 用户注册方法
	 * @return
	 */
	@RequestMapping(value = "/userRegiste")
	@ResponseBody
	public String createUser(@RequestParam(value="loginname", required = true) String loginname, 
			@RequestParam(value="nickname", required = true) String nickname, 
			@RequestParam(value="email", required = true) String email,
			@RequestParam(value="password", required = true) String password,
			@RequestParam(value="imei", required = true) String imei,
			@RequestParam(value="sex", required = true) int sex) {
		logger.info("用户注册方法");
		try {
			user = this.userService.findUserByLoginname(loginname);
			if (user != null && user.getUserid() > 0) {
				//调用《JsonMapper》的《数据已经存在转换成JSON》方法
				return JsonMapper.existToJson();
			}
			user = this.userService.findUserByLoginname(imei);
			int result = 0;
			if(user != null && user.getUserid() > 0 && user.getIsRegisterUser() <= 0){
				//imei用户已经存在，不是注册用户，把imei用户改成注册用户
				//塞入参数
				user.setLoginname(loginname);
				user.setNickname(nickname);
				user.setEmail(email);
				user.setPassword(password);
				user.setSex(sex);
				user.setIsRegisterUser(1);
				result = this.userService.updateImeiUserToRegisterUser(user);
			}else{
				//imei用户不存在，直接注册用户
				//实例化User类
				user = new User();
				//塞入参数
				user.setLoginname(loginname);
				user.setNickname(nickname);
				user.setEmail(email);
				user.setPassword(password);
				user.setSex(sex);
				user.setIsRegisterUser(1);
				//调用《userService》的《保存用户信息》方法
				result = this.userService.saveUser(user);
			}
			//判断数据库受影响行数是否大于0
			if (result > 0){
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
	 * 用户登录方法
	 * @param loginname 登录名
	 * @param password 密码
	 * @return
	 */
	@RequestMapping(value = "/userLogin")
	@ResponseBody
	public String login(@RequestParam(value="loginname", required = true) String loginname, 
			@RequestParam(value="password", required = true) String password) {
		logger.info("用户登录方法-----------------");
		try {
			//调用《userService》的《根据登录名和密码查询用户》方法
			user = this.userService.findUserByLoginnameAndPassword(loginname, password);
			if (user != null && user.getUserid() > 0){
				//调用《JsonMapper》的《把Object对象转换成JSON》方法
				logger.info("user.getUserid():"+user.getUserid());
				return JsonMapper.objectToJson(user);
			}else{
				//调用《JsonMapper》的《没有查询到数据》方法
				logger.info("调用《JsonMapper》的《没有查询到数据》方法");
				return JsonMapper.notFindJson();
			}
		} catch (Exception e) {
			e.printStackTrace();
			//调用《JsonMapper》的《错误返回码转换成JSON》方法
			logger.info("调用《JsonMapper》的《错误返回码转换成JSON》方法");
			return JsonMapper.failedToJson();
		}
	}
	
	/**
	 * 生成验证码
	 * @return
	 */
	@RequestMapping(value = "/genericVerfiyCode")
	@ResponseBody
	public String genericVerfiyCode(HttpServletRequest request,
			@RequestParam(value="simcode", required = true) String simcode) {
		try {
			StringBuffer filePath = new StringBuffer();
			StringBuffer imageName = new StringBuffer();
			StringBuffer result = new StringBuffer();
			String path = request.getSession().getServletContext().getRealPath("verfiyfile");
			File file = new File(path);
			if (!file.exists()){
				file.mkdirs();
			}
			filePath.append(path).append("//");
			imageName.append(simcode).append(".jpg");
			filePath.append(imageName);
			String random = ValidateImage.generateValidateImage(filePath.toString());
			result.append("\"verfiycode\":").append("\"").append(random).append("\",");
			result.append("\"verfiyimage\":\"");
			InetAddress addr = InetAddress.getLocalHost();
			// String serverIP = addr.getHostAddress(); 
			System.out.println("serverIP:"+serverIP);
			//获得外网IP地址
			result.append("http://").append(serverIP).append(":");
			//获得端口号
			result.append(request.getServerPort());
			//获得项目名
			result.append(request.getContextPath());
			//获得图片文件夹和图片名称
			result.append("/verfiyfile/").append(imageName).append("\"");
			return JsonMapper.retSuccessToJson(result.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 头像上传
	 * @param request
	 * @param response
	 * @param loginname
	 * @param imagefile
	 * @throws ServletException
	 * @throws IOException
	 * @return
	 */
	@RequestMapping(value = "/uploadHeadPhoto", method = RequestMethod.POST)
	public HttpServletResponse headPicUpload(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="loginname", required = true) String loginname,
			@RequestParam(value="imagefile", required = true) String imagefile) throws ServletException, IOException { 
		try {
			logger.info("头像上传");
			users = new ArrayList<User>();
			StringBuffer filePath = new StringBuffer();
			StringBuffer imageName = new StringBuffer();
			System.out.println("imagefile+----:"+imagefile);
			if (StringUtils.isNotBlank(loginname) && loginname.length() > 0){
				if (StringUtils.isNotBlank(imagefile)){
					byte[] b = Base64Coder.decodeLines(imagefile);
					String path = request.getSession().getServletContext().getRealPath("headphoto");
					File file = new File(path);
					if (!file.exists()) {
						file.mkdirs();
					}
					filePath.append(path);
					String saveImgeName=loginname+(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
					imageName.append(file.getPath()).append("/").append(saveImgeName).append(".jpg");
					logger.info("头像上传imageName"+imageName);
					
					FileOutputStream fos = new FileOutputStream(imageName.toString());
					fos.write(b);
					fos.flush();
					fos.close();
					user = this.userService.findUserByLoginname(loginname);
					if (user != null && user.getUserid() > 0){
						StringBuffer headPhotoUrl = new StringBuffer();
						// InetAddress addr = InetAddress.getLocalHost();
						// String serverIP = addr.getHostAddress(); 
						logger.info("头像上传外网IP地址"+serverIP);
						//获得外网IP地址
						headPhotoUrl.append("http://").append(serverIP).append(":");
						//获得端口号
						headPhotoUrl.append(request.getServerPort());
						//获得项目名
						headPhotoUrl.append(request.getContextPath());
						//获得目标文件夹
						headPhotoUrl.append("/headphoto/");
						//获得文件名
						headPhotoUrl.append(saveImgeName).append(".jpg");
						logger.info("头像上传headPhotoUrl"+headPhotoUrl.toString());
						user.setHeadurl(headPhotoUrl.toString());
						int rowNum = this.userService.modifyUserHeadurlByUserid(user.getUserid(), user.getHeadurl());
						if (rowNum > 0) {
							response.getWriter().write(JsonMapper.retSuccessToJson("\"hearurl\":\"" + user.getHeadurl() + "\""));
						}else{
							response.getWriter().write(JsonMapper.failedToJson());
						}
					}
				}else{
					response.getWriter().write(JsonMapper.nullParameterToJson());
				}
			}else{
				response.getWriter().write(JsonMapper.nullParameterToJson());
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().write(JsonMapper.failedToJson());
		}
		return null;
	}
	
	/**
	 * 根据用户ID查询用户
	 * @param userid 用户ID
	 * @return
	 */
//	@RequestMapping(value = "/getPersonalInformation")
	@ResponseBody
	public String getUserByUserid(@RequestParam(value="userid", required = true) int userid) {
		logger.info("根据用户ID查询用户");
		try {
			//调用《userService》的《根据用户ID查询用户》方法
			user = this.userService.findUserByUserid(userid);
			if (user != null && user.getUserid() > 0){
				//调用《JsonMapper》的《把Object对象转换成JSON》方法
				return JsonMapper.objectToJson(user);
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
	 * 根据用户ID查询用户
	 * @param userid 用户ID
	 * @return
	 */
	@RequestMapping(value = "/getPersonalInformation")
	@ResponseBody
	public String getUserByloginname(@RequestParam(value="loginname", required = true) String loginname) {
		logger.info("根据loginname查询用户");
		try {
			//调用《userService》的《根据用户ID查询用户》方法
			user = this.userService.findUserByLoginname(loginname);
			if (user != null && user.getUserid() > 0){
				//调用《JsonMapper》的《把Object对象转换成JSON》方法
				return JsonMapper.objectToJson(user);
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
	 * 根据用户ID更新油价
	 * @param userid 用户ID
	 * @param fuelprice 油价
	 * @return
	 */
	@RequestMapping(value = "/settingFuelprice")
	@ResponseBody
	public String settingFuelprice(@RequestParam(value="loginname", required = true) String loginname,
			@RequestParam(value="fuelprice", required = true) String fuelprice) {
		logger.info("根据用户ID更新油价");
		try {
			//调用《userService》的《根据用户ID更新油价》方法
			int rowNum = this.userService.modifyFuelpriceByUserid(loginname, fuelprice);
			if (rowNum > 0){
				//调用《JsonMapper》的《把Object对象转换成JSON》方法
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
	 * 生成验证码邮件
	 * @param email 电子邮件
	 * @return
	 */
	@RequestMapping(value = "/genericVerfiyCodeEmail")
	@ResponseBody
	public String settingPassword(@RequestParam(value="email", required = true) String email) {
		logger.info("生成验证码邮件");
		try {
			String random = ValidateImage.randomNumString(4);
			// 这个类主要是设置邮件
			MailSenderInfo mailInfo = new MailSenderInfo();
			mailInfo.setMailServerHost("smtp.qq.com");
			mailInfo.setMailServerPort("25");
			mailInfo.setValidate(true);
			mailInfo.setUserName("lijunlin@dachengsoftware.com");
			mailInfo.setPassword("huangdan.2597");// 您的邮箱密码
			mailInfo.setFromAddress("lijunlin@dachengsoftware.com");
			mailInfo.setToAddress(email);
			mailInfo.setSubject("OBD汽车设备APP");
			mailInfo.setContent("你的验证码为：" + random);
			// 这个类主要来发送邮件
			SimpleMailSender sms = new SimpleMailSender();
			sms.sendTextMail(mailInfo);// 发送文本格式
		} catch (Exception e) {
			e.printStackTrace();
			//调用《JsonMapper》的《错误返回码转换成JSON》方法
			return JsonMapper.failedToJson();
		}
		//调用《JsonMapper》的《把Object对象转换成JSON》方法
		return JsonMapper.successToJson();
	}
	
	/**
	 * 根据用户登录名更新密码
	 * @param loginname 登录名
	 * @param newpassword 密码
	 * @return
	 */
	@RequestMapping(value = "/editPassword")
	@ResponseBody
	public String settingPassword(@RequestParam(value="loginname", required = true) String loginname,
			@RequestParam(value="newpassword", required = true) String newpassword) {
		logger.info("根据用户登录名更新密码");
		try {
			//调用《userService》的《根据用户ID更新油价》方法
			int rowNum = this.userService.modifyPasswordByLoginname(loginname, newpassword);
			if (rowNum > 0){
				//调用《JsonMapper》的《把Object对象转换成JSON》方法
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
	 * 根据用户登录名设置邮箱
	 * @param loginname 登录名
	 * @param newpassword 密码
	 * @return
	 * */
	@RequestMapping(value = "/settingEmail")
	@ResponseBody
	public String settingEmail(@RequestParam(value="loginname", required = true) String loginname,
			@RequestParam(value="email", required = true) String email){
		logger.info("根据用户登录名设置邮箱");
		try {
			//调用《userService》的《根据用户ID更新油价》方法
			int rowNum = this.userService.settingEmail(loginname, email);
			if (rowNum > 0){
				//调用《JsonMapper》的《把Object对象转换成JSON》方法
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
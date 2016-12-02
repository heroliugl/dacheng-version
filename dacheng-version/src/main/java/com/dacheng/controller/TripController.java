package com.dacheng.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dacheng.constant.ErrConstant;
import com.dacheng.entity.Car;
import com.dacheng.entity.Trip;
import com.dacheng.entity.User;
import com.dacheng.entity.view.TripView;
import com.dacheng.service.CarService;
import com.dacheng.service.TripService;
import com.dacheng.service.UserService;
import com.dacheng.utils.JsonMapper;

@Controller
@RequestMapping(value = "/tripInterface")
public class TripController {
	//行程Biz接口
	@Resource
	private TripService tripService;
	//车辆Biz接口
	@Resource
	private CarService carService;
	@Resource
	private UserService userService;
	
	//行程实体对象
	private Trip trip;
	
	//行程实体对象集合
	private List<Trip> trips;
	
	//行程实体对象显示集合
	private TripView tripView;
	
	//日志
	private Logger logger = LoggerFactory.getLogger(TripController.class);
	
	/**
	 * 保存行程信息 
	 * @return
	 */
	@RequestMapping(value = "/addCarTrip")
	@ResponseBody
	public String createTrip(@RequestParam(value="loginname", required = true) String loginname, 
			@RequestParam(value="starttime", required = true) String starttime, 
			@RequestParam(value="endtime", required = true) String endtime,
			@RequestParam(value="mileage", required = true) String mileage,
			@RequestParam(value="triptime", required = true) String triptime,
			@RequestParam(value="averagespeed", required = true) String averagespeed,
			@RequestParam(value="averagefuel", required = true) String averagefuel,
			@RequestParam(value="tripfuel", required = true) String tripfuel,
			@RequestParam(value="topSpeed", required = true) String topSpeed,
			@RequestParam(value="topRPM", required = true) String topRPM,
			@RequestParam(value="fuelfee", required = true) String fuelfee,
			@RequestParam(value="idletime", required = true) int idletime) {
		logger.info("保存行程信息");
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
			//调用《tripService》的《保存用户信息》方法
			int rowNum = this.tripService.saveTrip(carid, starttime, endtime, 
					mileage, triptime, averagespeed, 
					averagefuel, tripfuel, topSpeed, topRPM,fuelfee,idletime);
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
	 * 根据行程ID查询行程信息
	 * @return
	 */
	@RequestMapping(value = "/getTripDetail")
	@ResponseBody
	public String getTripByTripid(@RequestParam(value="tripid", required = true) int tripid) {
		logger.info("根据行程ID查询行程信息");
		try {
			//调用《tripService》的《根据行程ID查询行程信息》方法
			trip = this.tripService.findTripByTripid(tripid);
			//判断数据库受影响行数是否大于0
			if (trip != null && trip.getTripid() > 0){
				//调用《JsonMapper》的《把Object对象转换成JSON》方法
				return JsonMapper.objectToJson(trip);
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
	 * 根据行程日期查询行程信息（日期为客户端指定）
	 * @return
	 */
	@RequestMapping(value = "/getTripByTripdate")
	@ResponseBody
	public String getTripByTripdate(@RequestParam(value="loginname", required = true) String loginname,
			@RequestParam(value="triptype", required = true) int triptype,
			@RequestParam(value="tripdate", required = true) String tripdate) {
		logger.info("根据行程日期查询行程信息（日期为客户端指定）");
		try {
			User user = this.userService.findUserByLoginname(loginname);
			Map<String, String> map = new HashMap<String, String>();
			if(user==null||user.getUserid()<=0){
//				map.put("code", ErrConstant.CODE_USER_NOT_EXIST);
//				map.put("info", ErrConstant.MSG_USER_NOT_EXIST);
//				return JsonMapper.mapToJson(map);
				user = userService.createUserIfNoExist(loginname);
				if(user == null||user.getUserid()<=0){
					return JsonMapper.failedToJson();
				}
			}
			List<Car> tempList= this.carService.findCarByUserid(user.getUserid());
			Car car = null;
			if(tempList==null||tempList.isEmpty()){
//				map.put("code", ErrConstant.CODE_NO_DATA);
//				map.put("info", ErrConstant.MSG_NO_DATA);
//				return JsonMapper.mapToJson(map);
				car = carService.createCarIfNoExist(user.getUserid());
				if(car==null){
					return JsonMapper.failedToJson();
				}
			}else{
				car = tempList.get(0);
			}
			int carid = car.getCarid();
			//调用《tripService》的《根据行程日期统计行程总数（日期为客户端指定）》方法
			trip = this.tripService.findTotalTripByTripdate(carid, triptype, tripdate);
			//调用《tripService》的《根据行程日期查询行程信息（日期为客户端指定）》方法
			trips = this.tripService.findTripByTripdate(carid, triptype, tripdate);
			//判断数据库受影响行数是否大于0
			if (trip != null && trips != null && trips.size() > 0){
				//调用《TripView》的《带参构造函数》
				tripView = new TripView(trip.getMileage(), trip.getTripfuel(), trip.getFuelfee(), trips);
				//调用《JsonMapper》的《把Object对象转换成JSON》方法
				return JsonMapper.objectToJson(tripView);
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
	 * 根据车辆ID更新里程
	 * @return
	 */
	@RequestMapping(value = "/settingMileage")
	@ResponseBody
	public String settingMileage(@RequestParam(value="loginname", required = true) String loginname,
			@RequestParam(value="mileage", required = true) String mileage) {
		logger.info("根据车辆ID更新里程");
		try {
			User user = userService.createUserIfNoExist(loginname);
			if(user == null||user.getUserid()<=0){
				return JsonMapper.failedToJson();
			}
			Car car = carService.createCarIfNoExist(user.getUserid());
			if(car==null){
				return JsonMapper.failedToJson();
			}
			int carid =	car.getCarid();
			//调用《carService》的《保存车辆信息》方法
			int rowNum = this.carService.modifyMileageByCarid(carid, mileage);
			if (rowNum > 0){
				//调用《carService》的《正确返回码转换成JSON》方法
				return JsonMapper.successToJson();
			}else{
				//调用《carService》的《错误返回码转换成JSON》方法
				return JsonMapper.failedToJson();
			}
		} catch (Exception e) {
			e.printStackTrace();
			//调用《JsonMapper》的《错误返回码转换成JSON》方法
			return JsonMapper.failedToJson();
		}
	}
	/**
	 * 根据用户名查询车辆的校准里程值
	 * @param username 用户名
	 * @return
	 */
	@RequestMapping(value = "/getSettingMileage")
	@ResponseBody
	public String getCarCorrectMileage(@RequestParam(value="username",required = true) String username){
		logger.info("获取车辆校准里程");
		try {
			User user = userService.findUserByLoginname(username);
			Map<String, String> map = new HashMap<String, String>();
			if(user==null||user.getUserid()<=0){ //用户不存在
				map.put("code", ErrConstant.CODE_USER_NOT_EXIST);
				map.put("info", ErrConstant.MSG_USER_NOT_EXIST);
				return JsonMapper.mapToJson(map);
			}
			List<Car> cars = carService.findCarByUserid(user.getUserid());
			if(cars!=null&&!cars.isEmpty()){
				String mileage = cars.get(0).getMileage();
				map.put("mileage", mileage);
				map.put("code", "200");
				map.put("info", "success");
				return JsonMapper.mapToJson(map);
			}
			return JsonMapper.notFindJson();
		} catch (Exception e) {
			e.printStackTrace();
			//调用《JsonMapper》的《错误返回码转换成JSON》方法
			return JsonMapper.failedToJson();
		}
	}
//	private User createUserIfNoExist(String loginname) throws Exception {
//		User user = this.userService.findUserByLoginname(loginname);
//		if(user==null||user.getUserid()<=0){//用户不存在 创建用户
//			user = new User();
//			user.setLoginname(loginname);
//			user.setPassword("123456");
//			user.setSex(1);
//			user.setCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.getDefault()).format(new Date()));
//			user.setStatus(1);
//			user.setIsRegisterUser(0);
//			int createUserResult = this.userService.createDefaultUser(user);
//			if(createUserResult<=0){
//				return null;
//			}
//		}
//		return user;
//	}
//	private Car createCarIfNoExist(int userId) throws Exception{
//		List<Car> tempList= this.carService.findCarByUserid(userId);
//		if(tempList==null||tempList.isEmpty()){//车辆不存在
//			int userid = userId;
//			int createCarResult = this.carService.saveCar(userid , "" , "new car" , "", "", "");
//			if(createCarResult<=0){
//				return null;
//			}
//			tempList= this.carService.findCarByUserid(userId);
//		}
//		return tempList.get(0);
//	}
	
	/**
	 * 查询当天排行榜
	 * @param rankingtype 排行榜类型 1：最低油耗，2：最长行驶距离
	 * @return
	 */
	@RequestMapping(value = "/getFuelOrMileageRanking")
	@ResponseBody
	public String getFuelOrMileageRanking(@RequestParam(value="rankingtype", required = true) int rankingtype) {
		logger.info("查询当天排行榜");
		try {
			if (rankingtype == 1) {
				//调用《tripService》的《查询最低油耗排行榜》方法
				trips = this.tripService.findFuelRanking("2015-06-18");
			}else if (rankingtype == 2) {
				//调用《tripService》的《查询最低油耗排行榜》方法
				trips = this.tripService.findMileageRanking("2015-06-18");
			}
			if (trips != null && trips.size() > 0){
				//调用《tripService》的《把List集合转换成JSON并自动命名》方法
				return JsonMapper.listToJsonAutoNamingList(trips);
			}else{
				//调用《tripService》的《没有查询到数据》方法
				return JsonMapper.notFindJson();
			}
		} catch (Exception e) {
			e.printStackTrace();
			//调用《JsonMapper》的《错误返回码转换成JSON》方法
			return JsonMapper.failedToJson();
		}
	}
}
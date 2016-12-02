package com.dacheng.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dacheng.entity.Car;
import com.dacheng.service.CarService;
import com.dacheng.service.UserService;
import com.dacheng.utils.JsonMapper;

@Controller
@RequestMapping(value = "/carInterface")
public class CarController {
	//车辆Biz接口
	@Resource
	private CarService carService;
	@Resource
	private UserService userService;
	
	//车辆实体对象
	private Car car;
	
	//车辆实体对象集合
	private List<Car> cars;
	
	//日志
	private Logger logger = LoggerFactory.getLogger(CarController.class);
	
	/**
	 * 查询所有车辆信息方法
	 * @return
	 */
	@RequestMapping("getCars")
	@ResponseBody
	public String getCars() {
		logger.info("查询所有车辆信息方法");
		try {
			//调用《userService》的《查询所有车辆信息》方法
			cars = this.carService.findCars();
			//判断车辆实体对象集合是否为null，并且size是否大于0
			if (cars != null && cars.size() > 0){
				//调用《JsonMapper》的《把List集合转换成JSON并自动命名》方法
				return JsonMapper.listToJsonAutoNamingList(cars);
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
	 * 根据用户ID查询车辆信息
	 * @param userid 用户ID
	 * @return
	 */
	@RequestMapping(value = "/getMyCar")
	@ResponseBody
	public String getCarByUserid(@RequestParam(value="userid", required = true) int userid) {
		logger.info("根据车辆ID查询车辆");
		try {
			//调用《userService》的《根据用户ID查询车辆信息》方法
			cars = this.carService.findCarByUserid(userid);
			if (cars != null && cars.size() > 0){
				//调用《JsonMapper》的《把List集合转换成JSON并自动命名》方法
				return JsonMapper.listToJsonAutoNamingList(cars);
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
	 * 保存车辆信息
	 * @return
	 */
	@RequestMapping(value = "/addMyCar")
	@ResponseBody
	public String createCar(@RequestParam(value="userid", required = true) int userid,
			@RequestParam(value="cityname", required = true) String cityname,
			@RequestParam(value="model", required = true) String model,
			@RequestParam(value="displacement", required = true) String displacement,
			@RequestParam(value="year", required = true) String year,
			@RequestParam(value="obdcode", required = true) String obdcode) {
		
		System.out.println("userid:"+userid);
		System.out.println("cityname:"+cityname);
		System.out.println("model:"+model);
		System.out.println("year:"+year);
		System.out.println("displacement:"+displacement);
		System.out.println("obdcode:"+obdcode);
		logger.info("保存车辆信息");
		try {
			//调用《carService》的《保存车辆信息》方法
			int rowNum = this.carService.saveCar(userid, cityname, model, displacement, year, obdcode);
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
	 * 根据车辆ID删除车辆信息
	 * @param userid 用户ID
	 * @return
	 */
	@RequestMapping(value = "/deleteMyCar")
	@ResponseBody
	public String deleteMyCar(@RequestParam(value="carid", required = true) int carid) {
		logger.info("根据车辆ID删除车辆信息");
		try {
			//调用《carService》的《根据车辆ID删除车辆信息》方法
			int rowNum = this.carService.removeCarByCarid(carid);
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
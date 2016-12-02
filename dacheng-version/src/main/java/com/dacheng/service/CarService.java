package com.dacheng.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dacheng.entity.Car;

public interface CarService {
	/**
	 * 查询所有车辆信息
	 * @return 车辆集合
	 */
	public List<Car> findCars() throws Exception;
	
	/**
	 * 根据用户ID查询车辆信息
	 * @param userid 用户ID
	 * @return 车辆集合
	 */
	public List<Car> findCarByUserid(@Param("userid") int userid) throws Exception;
	
	/**
	 * 保存车辆信息
	 * @return 受影响行数
	 */
	public int saveCar(@Param("userid") int userid,
			@Param("cityname") String cityname,
			@Param("model") String model,
			@Param("displacement") String displacement,
			@Param("year") String year,
			@Param("obdcode") String obdcode) throws Exception;
	
	/**
	 * 根据车辆ID更新里程
	 * @param carid 车辆ID
	 * @param mileage 里程
	 * @return
	 */
	public int modifyMileageByCarid(@Param("carid") int carid,
			@Param("mileage") String mileage) throws Exception;
	
	/**
	 * 根据车辆ID查询车辆信息
	 * @param carid 车辆ID
	 * @return 车辆实体对象
	 */
	public Car findCarByCarid(@Param("loginname") String loginname) throws Exception;
	
	/**
	 * 根据车辆ID删除车辆信息
	 * @param carid 车辆ID
	 * @return 受影响行数
	 */
	public int removeCarByCarid(@Param("carid") int carid) throws Exception;
	
	public Car createCarIfNoExist(int userId) throws Exception;
}
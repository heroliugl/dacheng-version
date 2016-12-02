package com.dacheng.push.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.dacheng.push.entity.Car;
import com.dacheng.push.mapper.CarMapper;
import com.dacheng.push.service.CarService;

@Service("carBiz")
public class CarServiceImpl implements CarService {
	//用户Dao接口
	@Resource
	private CarMapper carMapper;
	
	/**
	 * 查询所有车辆信息
	 * @return 车辆集合
	 */
	public List<Car> findCars() throws Exception {
		//调用《CarMapper》的《查询所有车辆信息》方法
		List<Car> cars = this.carMapper.queryCars();
		return cars;
	}
	
	/**
	 * 根据用户ID查询车辆信息
	 * @param userid 用户ID
	 * @return 车辆集合
	 */
	public List<Car> findCarByUserid(@Param("userid") int userid) throws Exception {
		//调用《CarMapper》的《根据用户ID查询车辆信息》方法
		List<Car> cars = this.carMapper.queryCarByUserid(userid);
		return cars;
	}
	
	/**
	 * 保存车辆信息
	 * @return 受影响行数
	 */
	public int saveCar(@Param("userid") int userid,
			@Param("cityname") String cityname,
			@Param("model") String model,
			@Param("displacement") String displacement,
			@Param("year") String year,
			@Param("obdcode") String obdcode) throws Exception {
		//调用《CarMapper》的《保存车辆信息》方法
		int rowNum = this.carMapper.insertCar(userid, cityname, model, displacement, year, obdcode);
		return rowNum;
	}
	
	/**
	 * 根据车辆ID更新里程
	 * @param carid 车辆ID
	 * @param mileage 里程
	 * @return
	 */
	public int modifyMileageByCarid(@Param("carid") int carid,
			@Param("mileage") String mileage) throws Exception {
		//调用《CarMapper》的《根据车辆ID更新里程》方法
		int rowNum = this.carMapper.updateMileageByCarid(carid, mileage);
		return rowNum;
	}
	
	/**
	 * 根据车辆ID查询车辆信息
	 * @param carid 车辆ID
	 * @return 车辆实体对象
	 */
	public Car findCarByCarid(@Param("loginname") String loginname) throws Exception {
		//调用《CarMapper》的《根据车辆ID查询车辆信息》方法
		Car car = this.carMapper.queryCarByCarid(loginname);
		return car;
	}
	
	/**
	 * 根据车辆ID删除车辆信息
	 * @param carid 车辆ID
	 * @return 受影响行数
	 */
	public int removeCarByCarid(@Param("carid") int carid) throws Exception {
		//调用《CarMapper》的《根据车辆ID删除车辆信息》方法
		int rowNum = this.carMapper.deleteCarByCarid(carid);
		return rowNum;
	}
	
	public Car createCarIfNoExist(int userId) throws Exception{
		List<Car> tempList= this.findCarByUserid(userId);
		if(tempList==null||tempList.isEmpty()){//车辆不存在
			int userid = userId;
			int createCarResult = this.saveCar(userid , "" , "new car" , "", "", "");
			if(createCarResult<=0){
				return null;
			}
			tempList= this.findCarByUserid(userId);
		}
		return tempList.get(0);
	}
}
package com.dacheng.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dacheng.entity.Trip;

public interface TripService {
	/**
	 * 保存行程信息
	 * @return 受影响行数
	 */
	public int saveTrip(@Param("carid") int carid,
			@Param("starttime") String starttime,
			@Param("endtime") String endtime,
			@Param("mileage") String mileage,
			@Param("triptime") String triptime,
			@Param("averagespeed") String averagespeed,
			@Param("averagefuel") String averagefuel,
			@Param("tripfuel") String tripfuel,
			@Param("topSpeed") String topSpeed,
			@Param("topRPM") String topRPM,
			@Param("fuelfee") String fuelfee,
			@Param("idletime") int idletime) throws Exception;
	
	/**
	 * 根据行程ID查询行程信息
	 * @return 行程信息
	 */
	public Trip findTripByTripid(@Param("tripid") int tripid) throws Exception;
	
	/**
	 * 根据行程日期统计行程总数（日期为客户端指定）
	 * @return 行程信息
	 */
	public Trip findTotalTripByTripdate(@Param("carid") int carid,
			@Param("triptype") int triptype,
			@Param("tripdate") String tripdate) throws Exception;
	
	/**
	 * 根据行程日期查询行程信息（日期为客户端指定）
	 * @return 行程信息
	 */
	public List<Trip> findTripByTripdate(@Param("carid") int carid,
			@Param("triptype") int triptype,
			@Param("tripdate") String tripdate) throws Exception;
	
	/**
	 * 查询最低油耗排行榜
	 * @return 行程信息
	 */
	public List<Trip> findFuelRanking(@Param("rankingdate") String rankingdate) throws Exception;
	
	/**
	 * 查询最长行驶距离排行榜
	 * @return 行程信息
	 */
	public List<Trip> findMileageRanking(@Param("rankingdate") String rankingdate) throws Exception;
}
package com.dacheng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dacheng.entity.Trip;

public interface TripMapper {
	/**
	 * 保存行程信息
	 * @return 受影响行数
	 */
	public int insertTrip(@Param("carid") int carid,
			@Param("starttime") String starttime,
			@Param("endtime") String endtime,
			@Param("score") String score,
			@Param("fuelclass") String fuelclass,
			@Param("driveclass") String driveclass,
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
	public Trip queryTripByTripid(@Param("tripid") int tripid) throws Exception;
	
	/**
	 * 根据行程日期统计行程总数（日期为客户端指定）
	 * @return 行程信息
	 */
	public Trip queryTotalTripByTripdate(@Param("carid") int carid,
			@Param("triptype") int triptype,
			@Param("tripdate") String tripdate) throws Exception;
	
	/**
	 * 根据行程日期查询行程信息（日期为客户端指定）
	 * @return 行程信息
	 */
	public List<Trip> queryTripByTripdate(@Param("carid") int carid,
			@Param("triptype") int triptype,
			@Param("tripdate") String tripdate) throws Exception;
	
	/**
	 * 查询最低油耗排行榜
	 * @return 行程信息
	 */
	public List<Trip> queryFuelRanking(@Param("rankingdate") String rankingdate) throws Exception;
	
	/**
	 * 查询最长行驶距离排行榜
	 * @return 行程信息
	 */
	public List<Trip> queryMileageRanking(@Param("rankingdate") String rankingdate) throws Exception;
}
package com.dacheng.push.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.dacheng.push.entity.Trip;
import com.dacheng.push.mapper.TripMapper;
import com.dacheng.push.service.TripService;

@Service("tripBiz")
public class TripServiceImpl implements TripService {
	// 行程Dao接口
	@Resource
	private TripMapper tripMapper;

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
			@Param("idletime") int idletime) throws Exception {
		String score = "67";
		String fuelclass = "77";
		String driveclass = "89";
		//调用《TripMapper》的《保存行程信息》方法
		int rowNum = this.tripMapper.insertTrip(carid, starttime, endtime,
				score, fuelclass, driveclass, mileage, triptime, averagespeed,
				averagefuel, tripfuel,topSpeed,topRPM, fuelfee,idletime);
		return rowNum;
	}
	
	/**
	 * 根据行程ID查询行程信息
	 * @return 行程信息
	 */
	public Trip findTripByTripid(@Param("tripid") int tripid) throws Exception {
		//调用《TripMapper》的《根据行程ID查询行程信息》方法
		Trip trip = this.tripMapper.queryTripByTripid(tripid);
		return trip;
	}
	
	/**
	 * 根据行程日期统计行程总数（日期为客户端指定）
	 * @return 行程信息
	 */
	public Trip findTotalTripByTripdate(@Param("carid") int carid,
			@Param("triptype") int triptype,
			@Param("tripdate") String tripdate) throws Exception {
		//调用《TripMapper》的《根据行程日期统计行程总数（日期为客户端指定）》方法
		Trip trip = this.tripMapper.queryTotalTripByTripdate(carid, triptype, tripdate);
		return trip;
	}
	
	/**
	 * 根据行程日期查询行程信息（日期为客户端指定）
	 * @return 行程信息
	 */
	public List<Trip> findTripByTripdate(@Param("carid") int carid,
			@Param("triptype") int triptype,
			@Param("tripdate") String tripdate) throws Exception {
		//调用《TripMapper》的《根据行程日期查询行程信息（日期为客户端指定）》方法
		List<Trip> trips = this.tripMapper.queryTripByTripdate(carid, triptype, tripdate);
		return trips;
	}
	
	/**
	 * 查询最低油耗排行榜
	 * @return 行程信息
	 */
	public List<Trip> findFuelRanking(@Param("rankingdate") String rankingdate) throws Exception {
		//调用《TripMapper》的《查询最低油耗排行榜》方法
		List<Trip> trips = this.tripMapper.queryFuelRanking(rankingdate);
		return trips;
	}
	
	/**
	 * 查询最长行驶距离排行榜
	 * @return 行程信息
	 */
	public List<Trip> findMileageRanking(@Param("rankingdate") String rankingdate) throws Exception {
		//调用《TripMapper》的《查询最长行驶距离排行榜》方法
		List<Trip> trips = this.tripMapper.queryMileageRanking(rankingdate);
		return trips;
	}
}
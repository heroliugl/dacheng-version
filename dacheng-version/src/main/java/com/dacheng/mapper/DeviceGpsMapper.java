package com.dacheng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dacheng.entity.DeviceGps;

public interface DeviceGpsMapper {

	/**
	 * 根据设备编号查询设备信息
	 * @param ID 设备编号
	 * @return
	 */
	public List<DeviceGps> findDeviceGpsListById(@Param("deviceId") String deviceId) throws Exception;

	
	/**
	 * 查询设备列表
	 * @param device
	 * @return
	 * @throws Exception
	 */
	public List<DeviceGps> findDeviceGpsList(DeviceGps deviceGps) throws Exception;
}
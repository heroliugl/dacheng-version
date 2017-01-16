package com.dacheng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dacheng.entity.Device;

public interface DeviceMapper {
	/**
	 * 保存设备信息
	 * @return 受影响行数
	 */
	public int saveDevice(Device device) throws Exception;

	/**
	 * 根据设备编号删除设备信息
	 * @param deviceId
	 * @return 受影响的行数
	 */
	public int deleteDeviceById(@Param("deviceId") String deviceId) throws Exception;
	

	/**
	 * 更新device信息
	 * @return 受影响的行数
	 */
	public int updateDevice(Device device) throws Exception;
	
	/**
	 * 根据设备编号查询设备信息
	 * @param ID 设备编号
	 * @return
	 */
	public Device findDeviceById(@Param("deviceId") String deviceId) throws Exception;

	/**
	 * 检查设备名称是否已经存在
	 * @return int
	 */
	public int checkDeviceIsExist(@Param("deviceId") String deviceId) throws Exception;
	
	/**
	 * 查询设备列表
	 * @param device
	 * @return
	 * @throws Exception
	 */
	public List<Device> findDeviceList(Device device) throws Exception;
}
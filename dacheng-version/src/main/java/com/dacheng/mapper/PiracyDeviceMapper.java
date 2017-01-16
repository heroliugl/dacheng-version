package com.dacheng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dacheng.entity.PiracyDevice;

public interface PiracyDeviceMapper {
	/**
	 * 保存侵权设备信息
	 * @return 受影响行数
	 */
	public int savePiracyDevice(PiracyDevice piracyDevice) throws Exception;

	/**
	 * 根据侵权设备编号删除侵权设备信息
	 * @param piracyDeviceId
	 * @return 受影响的行数
	 */
	public int deletePiracyDeviceById(@Param("deviceId") String deviceId) throws Exception;
	

	/**
	 * 更新piracyDevice信息
	 * @return 受影响的行数
	 */
	public int updatePiracyDevice(PiracyDevice piracyDevice) throws Exception;
	
	/**
	 * 根据侵权设备编号查询侵权设备信息
	 * @param ID 侵权设备编号
	 * @return
	 */
	public PiracyDevice findPiracyDeviceById(@Param("deviceId") String deviceId) throws Exception;

	/**
	 * 检查侵权设备名称是否已经存在
	 * @return int
	 */
	public int checkPiracyDeviceIsExist(@Param("deviceId") String deviceId) throws Exception;
	
	/**
	 * 查询侵权设备列表
	 * @param piracyDevice
	 * @return
	 * @throws Exception
	 */
	public List<PiracyDevice> findPiracyDeviceList(PiracyDevice piracyDevice) throws Exception;
}
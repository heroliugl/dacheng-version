package com.dacheng.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dacheng.entity.Device;
import com.dacheng.entity.view.PageView;
import com.github.pagehelper.PageInfo;
/**
 * 设备类型接口
 * @author Administrator
 *
 */
public interface DeviceService {
	/**
	 * 保存设备类型信息
	 * @return 受影响行数
	 */
	public int saveDevice(Device device) throws Exception;
	
	/**
	 * 根据设备ID查询设备信息
	 * @return 设备信息
	 */
	public int deleteDeviceById(@Param("deviceId") String deviceId) throws Exception;
	

	/**
	 * 根据设备ID查询设备信息
	 * @return 设备信息
	 */
	public int updateDevice(Device device) throws Exception;
	
	/**
	 * 根据设备类型ID查询
	 * @return 设备类型信息
	 */
	public Device findDeviceById(@Param("deviceId") String deviceId) throws Exception;

	/**
	 * 检查设备名称是否已经存在
	 * @return int
	 */
	public int checkDeviceIsExist(@Param("deviceId") String deviceId) throws Exception;
	
	/**
	 * 根据设备说明ID查询设备说明信息
	 * @return 设备说明信息
	 */
	public List<Device> findDeviceList(Device device) throws Exception;
	
	
	/**
	 * 根据设备ID查询设备信息
	 * @return 设备信息
	 */
	public PageView<Device> findPage(Integer pageNo, Integer pageSize,Device device) throws Exception;
	
	
	public PageInfo<Device> queryByPage(Integer pageNo,Integer pageSize,Device device) throws Exception;
	

	
}
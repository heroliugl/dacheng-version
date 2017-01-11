package com.dacheng.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dacheng.entity.Device;
import com.dacheng.entity.view.PageView;
import com.github.pagehelper.PageInfo;
/**
 * 产品类型接口
 * @author Administrator
 *
 */
public interface DeviceService {
	/**
	 * 保存产品类型信息
	 * @return 受影响行数
	 */
	public int saveDevice(Device device) throws Exception;
	
	/**
	 * 根据产品ID查询产品信息
	 * @return 产品信息
	 */
	public int deleteDeviceById(@Param("deviceId") String deviceId) throws Exception;
	

	/**
	 * 根据产品ID查询产品信息
	 * @return 产品信息
	 */
	public int updateDevice(Device device) throws Exception;
	
	/**
	 * 根据产品类型ID查询
	 * @return 产品类型信息
	 */
	public Device findDeviceById(@Param("deviceId") String deviceId) throws Exception;

	
	/**
	 * 根据产品说明ID查询产品说明信息
	 * @return 产品说明信息
	 */
	public List<Device> findDeviceList(Device device) throws Exception;
	
	
	/**
	 * 根据产品ID查询产品信息
	 * @return 产品信息
	 */
	public PageView<Device> findPage(Integer pageNo, Integer pageSize,Device device) throws Exception;
	
	
	public PageInfo<Device> queryByPage(Integer pageNo,Integer pageSize,Device device) throws Exception;
	

	
}
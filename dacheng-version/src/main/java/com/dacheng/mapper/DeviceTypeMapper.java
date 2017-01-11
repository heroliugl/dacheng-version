package com.dacheng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dacheng.entity.DeviceType;

public interface DeviceTypeMapper {
	/**
	 * 保存产品类型信息
	 * @return 受影响行数
	 */
	public int saveDeviceType(DeviceType deviceType) throws Exception;
	
	/**
	 * 根据产品ID查询产品信息
	 * @return 产品信息
	 */
	public int deleteDeviceTypeById(@Param("typeId") Long typeId) throws Exception;
	

	/**
	 * 根据产品ID查询产品信息
	 * @return 产品信息
	 */
	public int updateDeviceType(DeviceType deviceType) throws Exception;
	
	/**
	 * 根据产品类型ID查询
	 * @return 产品类型信息
	 */
	public DeviceType findDeviceTypeById(@Param("typeId") Long typeId) throws Exception;
	
	
	/**
	 * 根据产品类型ID查询
	 * @return 产品类型信息
	 */
	public DeviceType findDeviceTypeByTypeCode(@Param("typeCode") String typeCode) throws Exception;
	
	
	/**
	 * 检查产品名称是否已经存在
	 * @return int
	 */
	public int checkDeviceTypeNameIsExist(@Param("typeName") String typeName) throws Exception;
	
	
	/**
	 * 根据产品说明ID查询产品说明信息
	 * @return 产品说明信息
	 */
	public List<DeviceType> findDeviceTypeList(DeviceType deviceType) throws Exception;

	

}
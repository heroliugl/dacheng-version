package com.dacheng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dacheng.entity.TypePrefix;

public interface TypePrefixMapper {
	/**
	 * 保存产品类型蓝牙名称信息
	 * @return 受影响行数
	 */
	public int saveTypePrefix(TypePrefix typePrefix) throws Exception;
	
	/**
	 * 根据产品ID删除产品蓝牙信息
	 * @return  受影响行数
	 */
	public int deleteTypePrefixByTypeId(@Param("typeId") Long typeId) throws Exception;
	
	/**
	 * 根据产品ID，蓝牙名称删除产品蓝牙信息
	 * @return 受影响行数
	 */
	public int deleteTypePrefixByTypeIdAndPrefix(@Param("typeId") Long typeId,@Param("typePrefix") String typePrefix) throws Exception;
	

	/**
	 * 更新产品蓝牙信息
	 * @return 受影响行数
	 */
	public int updateTypePrefix(TypePrefix typePrefix) throws Exception;
	
	/**
	 * 根据产品类型ID和蓝牙名称查询
	 * @return 产品类型蓝牙名称信息
	 */
	public TypePrefix findTypePrefixByTypeIdAndPrefix(@Param("typeId") Long typeId,@Param("typePrefix") String typePrefix) throws Exception;
	
	
	/**
	 * 根据产品类型蓝牙名称ID查询
	 * @return 产品类型蓝牙名称信息
	 */
	public TypePrefix findTypePrefixByPrefix(@Param("typePrefix") String typePrefix) throws Exception;
	
	
	/**
	 * 检查蓝牙名称是否已经存在
	 * @return int
	 */
	public int checkTypePrefixIsExist(@Param("typePrefix") String typePrefix) throws Exception;
	
	
	/**
	 * 查询产品蓝牙信息列表
	 * @return 产品蓝牙信息
	 */
	public List<TypePrefix> findTypePrefixList(TypePrefix typePrefix) throws Exception;


}
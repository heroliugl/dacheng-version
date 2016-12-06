package com.dacheng.service;

import org.apache.ibatis.annotations.Param;

import com.dacheng.entity.Version;
import com.dacheng.entity.view.PageView;
import com.github.pagehelper.PageInfo;

public interface VersionService {
	/**
	 * 保存行程信息
	 * @return 受影响行数
	 */
	public int saveVersion(Version version) throws Exception;
	
	/**
	 * 根据行程ID查询行程信息
	 * @return 行程信息
	 */
	public Version findVersionById(@Param("id") Long id) throws Exception;
	
	/**
	 * 根据行程ID查询行程信息
	 * @return 行程信息
	 */
	public int deleteVersionById(@Param("id") Long id) throws Exception;
	

	/**
	 * 根据行程ID查询行程信息
	 * @return 行程信息
	 */
	public int UpdateVersion(Version version) throws Exception;
	
	/**
	 * 根据行程ID查询行程信息
	 * @return 行程信息
	 */
	public PageView<Version> findPage(Integer pageNo, Integer pageSize,Version version) throws Exception;
	
	
	public PageInfo<Version> queryByPage(Integer pageNo,Integer pageSize,Version version) throws Exception;
	

	
}
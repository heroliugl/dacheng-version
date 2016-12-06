package com.dacheng.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.dacheng.entity.Version;
import com.dacheng.entity.view.PageView;
import com.github.pagehelper.PageInfo;

public interface VersionMapper {
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
	public List<Version> findList(Version version) throws Exception;
	
}
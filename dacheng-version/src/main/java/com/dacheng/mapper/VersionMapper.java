package com.dacheng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dacheng.entity.Version;

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
	public Version findVersionByVersion(@Param("ptype") String ptype,@Param("vtype") String vtype,
			@Param("vm") Float vm,@Param("vflag") String vflag) throws Exception;
	
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
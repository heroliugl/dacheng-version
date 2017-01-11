package com.dacheng.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dacheng.entity.VersionLog;

public interface VersionLogService {
	/**
	 * 保存版本说明信息
	 * @return 受影响行数
	 */
	public int saveVersionLog(VersionLog versionLog) throws Exception;
	
	/**
	 * 根据版本说明ID查询版本说明信息
	 * @return 版本说明信息
	 */
	public List<VersionLog> findVersionLogById(@Param("versionId") Long versionId) throws Exception;
	
	/**
	 * 根据版本说明ID查询版本说明信息
	 * @return 版本说明信息
	 */
	public VersionLog findVersionLogByIdAndLang(@Param("versionId") Long versionId
			,@Param("lang") String lang) throws Exception;
	
	/**
	 * 根据版本说明ID查询版本说明信息
	 * @return 版本说明信息
	 */
	public int deleteVersionLogById(@Param("versionId") Long versionId) throws Exception;
	
	/**
	 * 
	 * @return 版本说明信息
	 */
	public int deleteVersionLogByIdAndLang(@Param("versionId") Long versionId,@Param("lang") String lang) throws Exception;
	

	/**
	 * 根据版本说明ID查询版本说明信息
	 * @return 版本说明信息
	 */
	public int updateVersionLog(VersionLog versionLog) throws Exception;
	
	/**
	 * 根据版本说明ID查询版本说明信息
	 * @return 版本说明信息
	 */
	/*public PageView<VersionLog> findPage(Integer pageNo, Integer pageSize,VersionLog versionLog) throws Exception;
	
	
	public PageInfo<VersionLog> queryByPage(Integer pageNo,Integer pageSize,VersionLog versionLog) throws Exception;*/
	

	
}
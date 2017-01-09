package com.dacheng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dacheng.entity.VersionLog;

public interface VersionLogMapper {
	/**
	 * 保存版本说明信息
	 * @return 受影响行数
	 */
	public int saveVersionLog(VersionLog versionLog) throws Exception;
	
	/**
	 * 根据版本ID查询版本说明信息列表(多语言)
	 * @return 版本说明信息
	 */
	public List<VersionLog> findVersionLogById(@Param("versionId") Long versionId) throws Exception;
	
	/**
	 * 根据版本ID和语言类型查询版本说明信息
	 * @param versionId
	 * @param lang
	 * @return
	 * @throws Exception
	 */
	public VersionLog findVersionLogByIdAndLang(@Param("versionId") Long versionId
			,@Param("lang") String lang) throws Exception;
	
	/**
	 * 根据版本ID删除版本说明信息
	 * @return 受影响行数
	 */
	public int deleteVersionLogById(@Param("versionId") Long versionId) throws Exception;
	
	/**
	 * 
	 * @return 版本说明信息
	 */
	public int deleteVersionLogByIdAndLang(@Param("versionId") Long versionId,@Param("lang") String lang) throws Exception;

	/**
	 * 根据版本说明对象更新版本说明信息（版本ID,lang）
	 * @return 受影响行数
	 */
	public int UpdateVersionLog(VersionLog versionLog) throws Exception;
	
	/**
	 * 查询版本说明信息(分页)
	 * @return 版本说明信息
	 */
	public List<VersionLog> findList(VersionLog versionLog) throws Exception;
	
}
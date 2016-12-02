package com.dacheng.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dacheng.entity.Project;
import com.dacheng.entity.ProjectType;
import com.dacheng.entity.Record;
import com.dacheng.entity.UserProject;
import com.dacheng.entity.view.RecordView;

public interface MaintainService {
	/**
	 * 查询所有保养项目信息
	 * @return 保养项目集合
	 */
	public List<Project> findProjects() throws Exception;
	
	/**
	 * 查询所有保养记录信息
	 * @return 保养记录集合
	 */
	public List<RecordView> findRecords(@Param("carid") int carid) throws Exception;
	
	/**
	 * 保存保养记录信息
	 */
	public void saveRecord(@Param("record") Record record) throws Exception;
	
	/**
	 * 根据保养记录ID更新保养记录图片
	 * @return 受影响行数
	 */
	public int modifyRecordPhoto(@Param("recordid") int recordid,
			@Param("recordphoto") String recordphoto) throws Exception;
	
	/**
	 * 根据保养记录ID查询保养记录信息
	 * @return 保养记录
	 */
	public Record findRecordByRecordid(@Param("recordid") int recordid) throws Exception;
	
	/**
	 * 保存用户自己设置的保养项目
	 * @return 受影响行数
	 */
	public int saveUserProject(@Param("userid") int userid,
			@Param("projectid") int projectid,
			@Param("mileage") String mileage) throws Exception;
	
	/**
	 * 根据保养项目ID查询用户自己设置的保养项目
	 * @return 用户自己设置的保养项目
	 */
	public List<UserProject> findUserProjectByProjectid(@Param("userid") int userid, 
			@Param("projectid") int projectid) throws Exception;
	
	/**
	 * 根据用户ID查询用户自己设置的保养项目
	 * @return 用户自己设置的保养项目
	 */
	public List<UserProject> findUserProjectByUserid(@Param("userid") int userid) throws Exception;
	
	/**
	 * 查询保养记录中各个保养项目的最大的里程
	 * @return 保养记录中各个保养项目的最大的里程
	 */
	public List<Record> findRecordMaxMileageByCarid(@Param("loginname") String loginname) throws Exception;
	
	/**
	 * 查询有保养记录的保养项目信息
	 * @return 保养项目集合
	 */
	public List<Project> findProjectByYesRecord(@Param("loginname") String loginname) throws Exception;
	
	/**
	 * 查询没有有保养记录的保养项目信息
	 * @return 保养项目集合
	 */
	public List<Project> findProjectByNoRecord(@Param("loginname") String loginname) throws Exception;
	
	/**
	 * 查询所有保养项目类型信息
	 * @return 保养项目类型集合
	 */
	public List<ProjectType> findProjectTypes() throws Exception;
	
	/**
	 * 根据保养项目类型ID查询保养项目信息
	 * @return 保养项目集合
	 */
	public List<Project> findProjectByTypeid(@Param("typeid") int typeid) throws Exception;
	
	/**
	 * 根据保养记录ID删除保养记录信息
	 * @param recordid 保养记录ID
	 * @return 受影响行数
	 */
	public int removeRecordByRecordid(@Param("recordid") int recordid) throws Exception;
}
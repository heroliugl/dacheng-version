package com.dacheng.push.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.dacheng.push.entity.Project;
import com.dacheng.push.entity.ProjectType;
import com.dacheng.push.entity.Record;
import com.dacheng.push.entity.UserProject;
import com.dacheng.push.entity.view.RecordView;
import com.dacheng.push.mapper.MaintainMapper;
import com.dacheng.push.service.MaintainService;

@Service("maintainBiz")
public class MaintainServiceImpl implements MaintainService {
	//保养Dao接口
	@Resource
	private MaintainMapper maintainMapper;
	
	/**
	 * 查询所有保养项目信息
	 * @return 保养项目集合
	 */
	public List<Project> findProjects() throws Exception {
		//调用《MaintainBiz》的《查询所有保养项目信息》方法
		List<Project> projects = this.maintainMapper.queryProjects();
		return projects;
	}
	
	/**
	 * 查询所有保养记录信息
	 * @return 保养记录集合
	 */
	public List<RecordView> findRecords(@Param("carid") int carid) throws Exception {
		//调用《MaintainMapper》的《查询所有保养记录信息》方法
		List<RecordView> recordViews = this.maintainMapper.queryRecords(carid);
		return recordViews;
	}

	/**
	 * 保存保养记录信息
	 */
	public void saveRecord(@Param("record") Record record) throws Exception {
		//调用《MaintainMapper》的《保存保养记录信息》方法
		this.maintainMapper.insertRecord(record);
	}
	
	/**
	 * 根据保养记录ID更新保养记录图片
	 * @return 受影响行数
	 */
	public int modifyRecordPhoto(@Param("recordid") int recordid,
			@Param("recordphoto") String recordphoto) throws Exception {
		//调用《MaintainMapper》的《根据保养记录ID更新保养记录图片》方法
		int rowNum = this.maintainMapper.updateRecordPhoto(recordid, recordphoto);
		return rowNum;
	}
	
	/**
	 * 根据保养记录ID查询保养记录信息
	 * @return 保养记录
	 */
	public Record findRecordByRecordid(@Param("recordid") int recordid) throws Exception {
		//调用《MaintainMapper》的《根据保养记录ID查询保养记录信息》方法
		Record record = this.maintainMapper.queryRecordByRecordid(recordid);
		return record;
	}
	
	/**
	 * 保存用户自己设置的保养项目
	 * @return 受影响行数
	 */
	public int saveUserProject(@Param("userid") int userid,
			@Param("projectid") int projectid,
			@Param("mileage") String mileage) throws Exception {
		//调用《MaintainMapper》的《保存用户自己设置的保养项目》方法
		int rowNum = this.maintainMapper.insertUserProject(userid, projectid, mileage);
		return rowNum;
	}
	
	/**
	 * 根据保养项目ID查询用户自己设置的保养项目
	 * @return 用户自己设置的保养项目
	 */
	public List<UserProject> findUserProjectByProjectid(@Param("userid") int userid, 
			@Param("projectid") int projectid) throws Exception {
		//调用《MaintainMapper》的《根据保养项目ID查询用户自己设置的保养项目》方法
		List<UserProject> userProjects = this.maintainMapper.queryUserProjectByProjectid(userid, projectid);
		return userProjects;
	}
	
	/**
	 * 根据用户ID查询用户自己设置的保养项目
	 * @return 用户ID查询用户自己设置的保养项目集合
	 */
	public List<UserProject> findUserProjectByUserid(@Param("userid") int userid) throws Exception {
		//调用《MaintainBiz》的《根据用户ID查询用户自己设置的保养项目》方法
		List<UserProject> userProjects = this.maintainMapper.queryUserProjectByUserid(userid);
		return userProjects;
	}
	
	/**
	 * 查询保养记录中各个保养项目的最大的里程
	 * @return 保养记录中各个保养项目的最大的里程
	 */
	public List<Record> findRecordMaxMileageByCarid(@Param("loginname") String loginname) throws Exception {
		//调用《MaintainMapper》的《查询保养记录中各个保养项目的最大的里程》方法
		List<Record> records = this.maintainMapper.queryRecordMaxMileageByCarid(loginname);
		return records;
	}
	
	/**
	 * 查询有保养记录的保养项目信息
	 * @return 保养项目集合
	 */
	public List<Project> findProjectByYesRecord(@Param("loginname") String loginname) throws Exception {
		//调用《MaintainMapper》的《查询有保养记录的保养项目信息》方法
		List<Project> projects = this.maintainMapper.queryProjectByYesRecord(loginname);
		return projects;
	}
	
	/**
	 * 查询没有有保养记录的保养项目信息
	 * @return 保养项目集合
	 */
	public List<Project> findProjectByNoRecord(@Param("loginname") String loginname) throws Exception {
		//调用《MaintainMapper》的《查询没有有保养记录的保养项目信息》方法
		List<Project> projects = this.maintainMapper.queryProjectByNoRecord(loginname);
		return projects;
	}
	
	/**
	 * 查询所有保养项目类型信息
	 * @return 保养项目类型集合
	 */
	public List<ProjectType> findProjectTypes() throws Exception {
		//调用《MaintainMapper》的《查询所有保养项目类型信息》方法
		List<ProjectType> projectTypes = this.maintainMapper.queryProjectTypes();
		return projectTypes;
	}
	
	/**
	 * 根据保养项目类型ID查询保养项目信息
	 * @return 保养项目集合
	 */
	public List<Project> findProjectByTypeid(@Param("typeid") int typeid) throws Exception {
		//调用《MaintainMapper》的《根据保养项目类型ID查询保养项目信息》方法
		List<Project> projects = this.maintainMapper.queryProjectByTypeid(typeid);
		return projects;
	}
	
	/**
	 * 根据保养记录ID删除保养记录信息
	 * @param recordid 保养记录ID
	 * @return 受影响行数
	 */
	public int removeRecordByRecordid(@Param("recordid") int recordid) throws Exception {
		//调用《MaintainMapper》的《根据保养记录ID删除保养记录信息》方法
		int rowNum = this.maintainMapper.deleteRecordByRecordid(recordid);
		return rowNum;
	}
}
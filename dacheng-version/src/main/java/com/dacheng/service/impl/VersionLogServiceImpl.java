package com.dacheng.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.dacheng.entity.VersionLog;
import com.dacheng.mapper.VersionLogMapper;
import com.dacheng.service.VersionLogService;

@Service("versionLogService")
public class VersionLogServiceImpl implements VersionLogService {
	//用户Dao接口
	@Resource
	private VersionLogMapper versionLogMapper;

	@Override
	public int saveVersionLog(VersionLog versionLog) throws Exception {
		// TODO Auto-generated method stub
		int rowNum = this.versionLogMapper.saveVersionLog(versionLog);
		return rowNum;
	}

	@Override
	public List<VersionLog> findVersionLogById(Long versionId) throws Exception {
		// TODO Auto-generated method stub
		 List<VersionLog> list = new ArrayList<VersionLog>();
		 list = this.versionLogMapper.findVersionLogById(versionId);
		return list;
	}

	@Override
	public VersionLog findVersionLogByIdAndLang(Long versionId, String lang) throws Exception {
		// TODO Auto-generated method stub
		return this.versionLogMapper.findVersionLogByIdAndLang(versionId, lang);
	}

	@Override
	public int deleteVersionLogById(Long versionId) throws Exception {
		// TODO Auto-generated method stub
		return this.versionLogMapper.deleteVersionLogById(versionId);
	}
	
	
	@Override
	public int deleteVersionLogByIdAndLang(Long versionId,String lang) throws Exception {
		// TODO Auto-generated method stub
		return this.versionLogMapper.deleteVersionLogByIdAndLang(versionId,lang);
	}

	@Override
	public int UpdateVersionLog(VersionLog versionLog) throws Exception {
		// TODO Auto-generated method stub
		return this.versionLogMapper.UpdateVersionLog(versionLog);
	}

}
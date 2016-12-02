package com.dacheng.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dacheng.entity.Version;
import com.dacheng.mapper.VersionMapper;
import com.dacheng.service.VersionService;

@Service("versionService")
public class VersionServiceImpl implements VersionService {
	//用户Dao接口
	@Resource
	private VersionMapper versionMapper;

	@Override
	public int saveVersion(Version version) throws Exception {
		// TODO Auto-generated method stub
		int rowNum = this.versionMapper.saveVersion(version);
		return rowNum;
	}

	@Override
	public Version findVersionById(Long id) throws Exception {
		// TODO Auto-generated method stub
		Version version = versionMapper.findVersionById(id);
		return version;
	}

	@Override
	public int deleteVersionById(Long id) throws Exception {
		// TODO Auto-generated method stub
		int rowNum = this.versionMapper.deleteVersionById(id);
		return rowNum;
	}
	
	@Override
	public int UpdateVersion(Version version) throws Exception {
		// TODO Auto-generated method stub
		int rowNum = this.versionMapper.UpdateVersion(version);
		return rowNum;
	}

}
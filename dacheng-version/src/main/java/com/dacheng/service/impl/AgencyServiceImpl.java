package com.dacheng.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dacheng.entity.Agency;
import com.dacheng.entity.view.PageView;
import com.dacheng.mapper.AgencyMapper;
import com.dacheng.service.AgencyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("agencyService")
public class AgencyServiceImpl implements AgencyService {
	//用户Dao接口
	@Resource
	private AgencyMapper agencyMapper;

	@Override
	public int saveAgency(Agency agency) throws Exception {
		// TODO Auto-generated method stub
		return agencyMapper.saveAgency(agency);
	}

	@Override
	public int deleteAgencyById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return agencyMapper.deleteAgencyById(id);
	}
	
	@Override
	public int updateAgency(Agency agency) throws Exception {
		// TODO Auto-generated method stub
		return agencyMapper.updateAgency(agency);
	}

	@Override
	public Agency findAgencyById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return agencyMapper.findAgencyById(id);
	}

	@Override
	public int checkAgencyNameIsExist(String agencyName) throws Exception {
		// TODO Auto-generated method stub
		return agencyMapper.checkAgencyNameIsExist(agencyName);
	}
	
	@Override
	public int checkAgencyCodeIsExist(String agencyCode) throws Exception {
		// TODO Auto-generated method stub
		return agencyMapper.checkAgencyCodeIsExist(agencyCode);
	}

	@Override
	public List<Agency> findAgencyList(Agency agency) throws Exception {
		// TODO Auto-generated method stub
		return agencyMapper.findAgencyList(agency);
	}
	
	@Override
	public PageView<Agency> findPage(Integer pageNo, Integer pageSize, Agency agency) throws Exception {
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
		PageHelper.startPage(pageNo, pageSize);
	    List<Agency> list = this.agencyMapper.findAgencyList(agency);
	    //用PageInfo对结果进行包装
	    PageInfo<Agency> page = new PageInfo<Agency>(list);
	    PageView<Agency> pageView = new PageView<Agency>();
	    pageView.setPage(pageNo);
	    pageView.setPageSize(pageSize);
	    pageView.setRowCount((int) page.getTotal());
	    pageView.setRecords(page.getList());
		return pageView;
	}

}
package com.dacheng.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dacheng.entity.PiracyDevice;
import com.dacheng.entity.view.PageView;
import com.dacheng.mapper.PiracyDeviceMapper;
import com.dacheng.service.PiracyDeviceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("piracyDeviceService")
public class PiracyDeviceServiceImpl implements PiracyDeviceService {
	//用户Dao接口
	@Resource
	private PiracyDeviceMapper piracyDeviceMapper;

	@Override
	public int savePiracyDevice(PiracyDevice piracyDevice) throws Exception {
		// TODO Auto-generated method stub
		return piracyDeviceMapper.savePiracyDevice(piracyDevice);
	}

	@Override
	public int deletePiracyDeviceById(String deviceId) throws Exception {
		// TODO Auto-generated method stub
		return piracyDeviceMapper.deletePiracyDeviceById(deviceId);
	}

	@Override
	public int updatePiracyDevice(PiracyDevice piracyDevice) throws Exception {
		// TODO Auto-generated method stub
		return piracyDeviceMapper.updatePiracyDevice(piracyDevice);
	}

	@Override
	public PiracyDevice findPiracyDeviceById(String deviceId) throws Exception {
		// TODO Auto-generated method stub
		return piracyDeviceMapper.findPiracyDeviceById(deviceId);
	}

	@Override
	public int checkPiracyDeviceIsExist(String deviceId) throws Exception {
		// TODO Auto-generated method stub
		return piracyDeviceMapper.checkPiracyDeviceIsExist(deviceId);
	}

	@Override
	public List<PiracyDevice> findPiracyDeviceList(PiracyDevice piracyDevice) throws Exception {
		// TODO Auto-generated method stub
		List<PiracyDevice> list = new ArrayList<>();
		list = piracyDeviceMapper.findPiracyDeviceList(piracyDevice);
		return list;
	}

	@Override
	public PageView<PiracyDevice> findPage(Integer pageNo, Integer pageSize, PiracyDevice piracyDevice) throws Exception {
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
		PageHelper.startPage(pageNo, pageSize);
	    List<PiracyDevice> list = this.piracyDeviceMapper.findPiracyDeviceList(piracyDevice);
	    //用PageInfo对结果进行包装
	    PageInfo<PiracyDevice> page = new PageInfo<PiracyDevice>(list);
	    PageView<PiracyDevice> pageView = new PageView<PiracyDevice>();
	    pageView.setPage(pageNo);
	    pageView.setPageSize(pageSize);
	    pageView.setRowCount((int) page.getTotal());
	    pageView.setRecords(page.getList());
		return pageView;
	}
	
	

	@Override
	public PageInfo<PiracyDevice> queryByPage(Integer pageNo, Integer pageSize, PiracyDevice piracyDevice) throws Exception {
		// TODO Auto-generated method stub
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
		PageHelper.startPage(pageNo, pageSize);
	    List<PiracyDevice> list = this.piracyDeviceMapper.findPiracyDeviceList(piracyDevice);
	    //用PageInfo对结果进行包装
	    PageInfo<PiracyDevice> page = new PageInfo<PiracyDevice>(list);
	    //测试PageInfo全部属性
/*	    System.out.println(page.getPageNum());
	    System.out.println(page.getPageSize());
	    System.out.println(page.getStartRow());
	    System.out.println(page.getEndRow());
	    System.out.println(page.getTotal());
	    System.out.println(page.getPages());
	    System.out.println(page.getFirstPage());
	    System.out.println(page.getLastPage());
	    System.out.println(page.isHasPreviousPage());
	    System.out.println(page.isHasNextPage());*/
		return page;
	}



	


}
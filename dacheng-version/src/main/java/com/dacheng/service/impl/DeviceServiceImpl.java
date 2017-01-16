package com.dacheng.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dacheng.entity.Device;
import com.dacheng.entity.view.PageView;
import com.dacheng.mapper.DeviceMapper;
import com.dacheng.service.DeviceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("deviceService")
public class DeviceServiceImpl implements DeviceService {
	//用户Dao接口
	@Resource
	private DeviceMapper deviceMapper;

	@Override
	public int saveDevice(Device device) throws Exception {
		// TODO Auto-generated method stub
		return deviceMapper.saveDevice(device);
	}

	@Override
	public int deleteDeviceById(String deviceId) throws Exception {
		// TODO Auto-generated method stub
		return deviceMapper.deleteDeviceById(deviceId);
	}

	@Override
	public int updateDevice(Device device) throws Exception {
		// TODO Auto-generated method stub
		return deviceMapper.updateDevice(device);
	}

	@Override
	public Device findDeviceById(String deviceId) throws Exception {
		// TODO Auto-generated method stub
		return deviceMapper.findDeviceById(deviceId);
	}

	@Override
	public int checkDeviceIsExist(String deviceId) throws Exception {
		// TODO Auto-generated method stub
		return deviceMapper.checkDeviceIsExist(deviceId);
	}

	@Override
	public List<Device> findDeviceList(Device device) throws Exception {
		// TODO Auto-generated method stub
		List<Device> list = new ArrayList<>();
		list = deviceMapper.findDeviceList(device);
		return list;
	}

	@Override
	public PageView<Device> findPage(Integer pageNo, Integer pageSize, Device device) throws Exception {
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
		PageHelper.startPage(pageNo, pageSize);
	    List<Device> list = this.deviceMapper.findDeviceList(device);
	    //用PageInfo对结果进行包装
	    PageInfo<Device> page = new PageInfo<Device>(list);
	    PageView<Device> pageView = new PageView<Device>();
	    pageView.setPage(pageNo);
	    pageView.setPageSize(pageSize);
	    pageView.setRowCount((int) page.getTotal());
	    pageView.setRecords(page.getList());
		return pageView;
	}
	
	

	@Override
	public PageInfo<Device> queryByPage(Integer pageNo, Integer pageSize, Device device) throws Exception {
		// TODO Auto-generated method stub
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
		PageHelper.startPage(pageNo, pageSize);
	    List<Device> list = this.deviceMapper.findDeviceList(device);
	    //用PageInfo对结果进行包装
	    PageInfo<Device> page = new PageInfo<Device>(list);
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
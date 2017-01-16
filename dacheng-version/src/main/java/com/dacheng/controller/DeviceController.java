package com.dacheng.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dacheng.entity.Device;
import com.dacheng.entity.PiracyDevice;
import com.dacheng.entity.view.PageView;
import com.dacheng.service.DeviceService;
import com.dacheng.service.PiracyDeviceService;

@Controller
@RequestMapping(value = "/device")
public class DeviceController {
	// 正版设备接口
	@Resource
	private DeviceService deviceService;
	
	// 侵权设备接口
	@Resource
	private PiracyDeviceService piracyDeviceService;
	
	/**
	 * 页面跳转
	 * @return
	 */
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public String list() {
        return "/views/device/deviceList";
    }
    
	/**
	 * 页面跳转
	 * @return
	 */
    @RequestMapping(value="/piracyList", method = RequestMethod.GET)
    public String piracyList() {
        return "/views/device/piracyList";
    }

    /**
     * 获取分页数据
     * @param currentPage
     * @param pageSize
     * @param user
     * @return
     */
    @RequestMapping(value="/list", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> list(@RequestParam(value = "currentPage", defaultValue = "0") int currentPage
            , @RequestParam(value = "pageSize", defaultValue = "50") int pageSize,Device device) {
    	 Map<String, Object> map = new HashMap<String, Object>();
    	 try {
    		 PageView<Device> pageView = deviceService.findPage(currentPage, pageSize, device);
    		 map.put("code", 0);
 			 map.put("page", pageView);
		} catch (Exception e) {
			// TODO: handle exception
			map.put("code", -1);
			map.put("page", null);
		}
        return map;
    }
    
    
    /**
     * 获取分页数据
     * @param currentPage
     * @param pageSize
     * @param user
     * @return
     */
    @RequestMapping(value="/piracyList", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> piracyList(@RequestParam(value = "currentPage", defaultValue = "0") int currentPage
            , @RequestParam(value = "pageSize", defaultValue = "50") int pageSize,PiracyDevice piracyDevice) {
    	 Map<String, Object> map = new HashMap<String, Object>();
    	 try {
    		 PageView<PiracyDevice> pageView = piracyDeviceService.findPage(currentPage, pageSize, piracyDevice);
    		 map.put("code", 0);
 			 map.put("page", pageView);
		} catch (Exception e) {
			// TODO: handle exception
			map.put("code", -1);
			map.put("page", null);
		}
        return map;
    }
}
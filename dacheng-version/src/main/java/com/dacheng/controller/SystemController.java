package com.dacheng.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dacheng.entity.Version;
import com.dacheng.entity.view.PageView;
import com.dacheng.service.VersionService;



@Controller
@RequestMapping(value = "/")
public class SystemController extends BaseController{
	
	@Autowired
	private VersionService versionService;
	
    @RequestMapping(value="/index", method = RequestMethod.GET)
    public String list() {
        return "/index";
    }
    
/*    @RequestMapping(value="/list", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> list(@RequestParam(value = "currentPage", defaultValue = "0") int currentPage
            , @RequestParam(value = "pageSize", defaultValue = "50") int pageSize,Version version) {
    	 Map<String, Object> map = new HashMap<String, Object>();
    	 try {
    		 PageView<Version> pageView = versionService.findPage(currentPage, pageSize, version);
    		 map.put("code", 0);
 			map.put("page", pageView);
		} catch (Exception e) {
			// TODO: handle exception
			map.put("code", -1);
			map.put("page", null);
		}
        return map;
    }*/
}
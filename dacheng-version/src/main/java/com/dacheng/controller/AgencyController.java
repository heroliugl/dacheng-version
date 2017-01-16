package com.dacheng.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dacheng.entity.Agency;
import com.dacheng.entity.view.PageView;
import com.dacheng.service.AgencyService;

@Controller
@RequestMapping(value = "/agency")
public class AgencyController {
	// 接口
	@Resource
	private AgencyService agencyService;
	
	/**
	 * 页面跳转
	 * @return
	 */
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public String list() {
        return "/views/agency/agencyList";
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
            , @RequestParam(value = "pageSize", defaultValue = "50") int pageSize,Agency agency) {
    	 Map<String, Object> map = new HashMap<String, Object>();
    	 try {
    		 PageView<Agency> pageView = agencyService.findPage(currentPage, pageSize, agency);
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
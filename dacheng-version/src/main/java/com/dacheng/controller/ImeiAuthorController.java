package com.dacheng.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dacheng.entity.ImeiApply;
import com.dacheng.entity.ImeiAuthor;
import com.dacheng.entity.view.PageView;
import com.dacheng.service.ImeiApplyService;
import com.dacheng.service.ImeiAuthorService;

@Controller
@RequestMapping(value = "/author")
public class ImeiAuthorController {
	//用户Biz接口
	@Resource
	private ImeiAuthorService imeiAuthorService;
	
	@Resource
	private ImeiApplyService imeiApplyService;
	
	/**
	 * 页面跳转
	 * @return
	 */
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public String list() {
        return "/views/author/imeiAuthorList";
    }
    
    /**
	 * 页面跳转
	 * @return
	 */
    @RequestMapping(value="/applyList", method = RequestMethod.GET)
    public String applyList() {
        return "/views/author/imeiApplyList";
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
            , @RequestParam(value = "pageSize", defaultValue = "50") int pageSize,ImeiAuthor imeiAuthor) {
    	 Map<String, Object> map = new HashMap<String, Object>();
    	 try {
    		 PageView<ImeiAuthor> pageView = imeiAuthorService.findPage(currentPage, pageSize, imeiAuthor);
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
    @RequestMapping(value="/applyList", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> list(@RequestParam(value = "currentPage", defaultValue = "0") int currentPage
            , @RequestParam(value = "pageSize", defaultValue = "50") int pageSize,ImeiApply imeiApply) {
    	 Map<String, Object> map = new HashMap<String, Object>();
    	 try {
    		 PageView<ImeiApply> pageView = imeiApplyService.findPage(currentPage, pageSize, imeiApply);
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
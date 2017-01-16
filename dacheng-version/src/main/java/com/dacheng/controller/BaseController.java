package com.dacheng.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dacheng.entity.User;
import com.dacheng.utils.ServiceConfig;


@Controller
public class BaseController{

	@Autowired
	protected HttpServletRequest request;
	
    protected int currentPage = 0;
    protected int pageSize = 20;
    
    protected static String versionSource=ServiceConfig.getInstance().getValue("server_version_source");
    
    public static Logger log = Logger.getLogger(BaseController.class);


    /**
     * 获取UserDto
     *
     * @param request
     * @return
     */
   protected User getUserSession() {
        User userDto = (User) request.getSession().getAttribute("user");
        return (null != userDto) ? userDto : null;
   }


	public HttpServletRequest getRequest() {
		return request;
	}


	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
}

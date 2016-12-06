package com.dacheng.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;



@Controller
public class BaseController{

    @Autowired
    private HttpServletRequest request;
    
    @Autowired
    private HttpServletResponse response;
    @Autowired
    protected HttpSession session;

    protected int currentPage = 0;
    protected int pageSize = 20;
    
    public static Logger log = Logger.getLogger(BaseController.class);

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

    /**
     * 获取UserDto
     *
     * @param request
     * @return
     */
   /* protected UserDto getUserSession() {
        UserDto userDto = (UserDto) request.getSession().getAttribute(BusinessConstant.SESSION_USER);
        return (null != userDto) ? userDto : null;
    }
*/
   
}

package com.dacheng.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping(value = "/")
public class SystemController extends BaseController{
	
    @RequestMapping(value="/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        return "/index";
    }
    
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request) {
    	request.getSession().removeAttribute("user");
        return "/login";
    }
    

}
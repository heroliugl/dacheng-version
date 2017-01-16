package com.dacheng.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dacheng.entity.User;
import com.dacheng.service.UserService;
import com.dacheng.utils.MD5;
import com.dacheng.utils.ServiceConfig;

@Controller
@RequestMapping(value = "/")
public class LoginController extends BaseController{
	
	
	@Autowired
	private UserService userService;

	private static String adminPwd=ServiceConfig.getInstance().getValue("admin_pwd");
	
  /*  @RequestMapping(value="/dologin")
    public String dologin(HttpServletRequest request, String userName,String password,Model model) {
    	 String msg = "";  
    	if(StringUtils.isNotBlank(userName) && StringUtils.isNotBlank(password)){
    		System.out.println(userName);  
    	    System.out.println(password);  
    	    UsernamePasswordToken token = new UsernamePasswordToken(userName, password);  
    	    token.setRememberMe(true);  
    	    Subject subject = SecurityUtils.getSubject();  
    	    try {  
    	        subject.login(token);  
    	        if (subject.isAuthenticated()) {  
    	            return "index";  
    	        } else {  
    	            return "login";  
    	        }  
    	    } catch (IncorrectCredentialsException e) {  
    	        msg = "登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.";  
    	        model.addAttribute("message", msg);  
    	        System.out.println(msg);  
    	    } catch (ExcessiveAttemptsException e) {  
    	        msg = "登录失败次数过多";  
    	        model.addAttribute("message", msg);  
    	        System.out.println(msg);  
    	    } catch (LockedAccountException e) {  
    	        msg = "帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.";  
    	        model.addAttribute("message", msg);  
    	        System.out.println(msg);  
    	    } catch (DisabledAccountException e) {  
    	        msg = "帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.";  
    	        model.addAttribute("message", msg);  
    	        System.out.println(msg);  
    	    } catch (ExpiredCredentialsException e) {  
    	        msg = "帐号已过期. the account for username " + token.getPrincipal() + "  was expired.";  
    	        model.addAttribute("message", msg);  
    	        System.out.println(msg);  
    	    } catch (UnknownAccountException e) {  
    	        msg = "帐号不存在. There is no user with username of " + token.getPrincipal();  
    	        model.addAttribute("message", msg);  
    	        System.out.println(msg);  
    	    } catch (UnauthorizedException e) {  
    	        msg = "您没有得到相应的授权！" + e.getMessage();  
    	        model.addAttribute("message", msg);  
    	        System.out.println(msg);  
    	    }   
    	}
    	
        return "login";
    }*/
	
	
	@RequestMapping(value="/doLogin", method = RequestMethod.POST)
	@ResponseBody
    public Map<String, Object> doLogin(HttpServletRequest request, String loginName,String password) {
		Map<String, Object> map = new HashMap<String, Object>();
    	if(StringUtils.isNotBlank(loginName) && StringUtils.isNotBlank(password)){
    		User user =new User();
			try {
				user = userService.findUserByLoginNameAndPassword(loginName, MD5.Md5(password));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		if(null != user && null != user.getId()){
    			// user.setPassword(null);
    			request.getSession().setAttribute("user", user);
    			map.put("code", 200);
      			map.put("codemsg", "请求成功");
    		}else{
    		   map.put("code", 403);
   			   map.put("codemsg", "用户名或密码错误");
    		}
    	}else{
    		 map.put("code", 400);
			 map.put("codemsg", "请求参数错误，请仔细检查");
    	}
        return map;
    }
	
	
	
}
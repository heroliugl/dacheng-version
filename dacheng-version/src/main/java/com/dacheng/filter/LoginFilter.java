package com.dacheng.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.dacheng.entity.User;

public class LoginFilter implements Filter {
	public void init(FilterConfig arg0) throws ServletException {
	}
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1; 
		// 获取当前路径
		String urlPath = request.getRequestURI(); 
		// System.out.println("urlPath === "+urlPath);
		if (!(urlPath.contains(".gif") || urlPath.contains(".css") 
				|| urlPath.contains(".jpg") || urlPath.contains(".js") 
				|| urlPath.endsWith("/") || urlPath.contains(".png"))) {
			urlPath = urlPath.replaceAll("dacheng-version", "");
			if(urlPath.contains("index") || urlPath.contains("version")){
				User currUser = (User) request.getSession().getAttribute("user");
				System.out.println("auth urlPath ===--------------------------- "+urlPath);
				if (null == currUser) {
					response.sendRedirect(request.getContextPath() + "/login");
					return;
				} 
			}
			
		}
		
		
		// 判断用户是否登陆
		/*if (!(urlPath.contains(".gif") || urlPath.contains(".css") 
				|| urlPath.contains(".jpg") || urlPath.contains(".js") 
				|| urlPath.endsWith("/") || urlPath.contains(".png")
				|| urlPath.contains("comm") || urlPath.contains("tenpay"))) {
			    //if (urlPath.lastIndexOf("/") > 7) {
				// LogUtils.info("request.getSession():"+request.getSession());
				// LogUtils.info("request.getSession().getServletContext():"+request.getSession().getServletContext());
				WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
				CommonService commonService = (CommonService) context.getBean("commonService");
				String menuUrl = "";
				if (urlPath.contains(".do")) {
					if (urlPath.contains("usercenter")) {
						menuUrl = urlPath.substring(urlPath.lastIndexOf("/")-10,urlPath.lastIndexOf(".do")+3);
					} else {
						menuUrl = urlPath.substring(urlPath.lastIndexOf("/")+1,urlPath.lastIndexOf(".do")+3);
					}
				} else {
					menuUrl = urlPath.substring(urlPath.lastIndexOf("/")+1);
				}
				// LogUtils.info("拦截的对象urlPath值为:"+urlPath);
				SysRoleMenuDTO sysRoleMenuDTO = new SysRoleMenuDTO(); 
				sysRoleMenuDTO.setMenuUrl(menuUrl);
				//后台管理拦截
				if (urlPath.contains("system") || urlPath.contains("company") ||
						urlPath.contains("dept") || urlPath.contains("adminproduct") || 
						urlPath.contains("agreement") || urlPath.contains("report") ||
						urlPath.contains("controller") || urlPath.contains("/accessory") ||
						urlPath.contains("prddefine") || "cms".equals(type)) {
					SysEmployeeDTO currUser = (SysEmployeeDTO) request.getSession().getAttribute("emp");
					// LogUtils.info("后台登录拦截判断登录用户session,currUser:"+(null != currUser?"("+currUser.getUserId()+(StringUtils.isNotBlank(currUser.getUserName())?" / "+currUser.getUserName():"")+")":currUser));
					//查询访问路径是否存在
					List<Object> sysMenuList = commonService.queryForList("system.queryMenusTree",sysRoleMenuDTO);
					// 如果没有登陆，则重新定向
					if (null == currUser) {
						response.sendRedirect(request.getContextPath() + "//alogin");
						return;
					} else if (sysMenuList.size() > 0 && null != sysMenuList) { //
						sysRoleMenuDTO.setRoleId(currUser.getRoleId());
						//查询该用户是否有访问该路径的权限
						List<Object> list = commonService.queryForList("system.queryAuthorizedMenusTree",sysRoleMenuDTO);
						if (list.size()==0 || null == list) {
							response.sendRedirect(request.getContextPath() + "//alogin");
							request.getSession().removeAttribute("emp");
							return;
						}
					}
				} else if (urlPath.contains("partner") || urlPath.contains("Task")|| 
						   urlPath.contains("firstImport") || urlPath.contains("changeImport") || 
						   urlPath.contains("specialImport") || urlPath.contains("claimsImport") || 
						   urlPath.contains("task")) {//合作方拦截
					SysEmployeeDTO currUser = (SysEmployeeDTO) request.getSession().getAttribute("emp");
					// LogUtils.info("合作用户登录拦截判断登录用户session,currUser:"+(null != currUser?"("+currUser.getUserId()+(StringUtils.isNotBlank(currUser.getUserName())?" / "+currUser.getUserName():"")+")":currUser));
					List<Object> sysMenuList = commonService.queryForList("system.queryMenusTree",sysRoleMenuDTO);
					if (currUser == null) {
						response.sendRedirect(request.getContextPath() + "//plogin");
						return;
					} 
					else if (sysMenuList.size() > 0 && null != sysMenuList) {
						sysRoleMenuDTO.setRoleId(currUser.getRoleId());
						List<Object> list = commonService.queryForList("system.queryAuthorizedMenusTree",sysRoleMenuDTO);
						if (list.size()==0 || null == list) {
							response.sendRedirect(request.getContextPath() + "//plogin");
							request.getSession().removeAttribute("emp");
							return;
						}
					}
				} else if(urlPath.contains("agentcenter")){
					SysAgentDTO sysAgentDTO = (SysAgentDTO) request.getSession().getAttribute("agent");
					// LogUtils.info("经纪客服人员登录拦截判断登录用户session,sysAgentDTO:"+(null != sysAgentDTO ? "("+sysAgentDTO.getAgentId()+(StringUtils.isNotBlank(sysAgentDTO.getAgentName())?" / "+sysAgentDTO.getAgentName():"")+")":sysAgentDTO));
					List<Object> sysMenuList = commonService.queryForList("system.queryMenusTree",sysRoleMenuDTO);
					if (sysAgentDTO == null) {
						response.sendRedirect(request.getContextPath() + "//getAgentLogin.do");
						return;
					} 
					else if (sysMenuList.size() > 0 && null != sysMenuList) {
						sysRoleMenuDTO.setRoleId(ConstantDBUtils.SYS_ROLE_AGENT_ID);
						List<Object> list = commonService.queryForList("system.queryAuthorizedMenusTree",sysRoleMenuDTO);
						if (list.size()==0 || null == list) {
							response.sendRedirect(request.getContextPath() + "//getAgentLogin.do");
							request.getSession().removeAttribute("agent");
							return;
						}
					}
				}else if (urlPath.contains("usercenter") || urlPath.contains("ChinaLife")) { //前台用户拦截
					MemberDTO memberDTO = (MemberDTO) request.getSession().getAttribute("member");
					// LogUtils.info("会员登陆拦截判断登录用户session，memberDTO:"+(null != memberDTO ?"("+memberDTO.getMemberId()+(StringUtils.isNotBlank(memberDTO.getUserName())?" / "+memberDTO.getUserName():"")+")":memberDTO));
					List<Object> sysMenuList = commonService.queryForList("system.queryMenusTree",sysRoleMenuDTO);
					if (null == memberDTO) {
						response.sendRedirect(request.getContextPath() + "//getMemberLogin.do");
						return;
					} 
					else if (sysMenuList.size() > 0 && null != sysMenuList) {
						sysRoleMenuDTO.setRoleId("ROE121212000001");
						List<Object> list = commonService.queryForList("system.queryAuthorizedMenusTree",sysRoleMenuDTO);
						if (list.size()==0 || null == list) {
							response.sendRedirect(request.getContextPath() + "//163@163.com");
							request.getSession().removeAttribute("member");
							return;
						}
					}
				}
		}*/
		arg2.doFilter(arg0, arg1);
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}

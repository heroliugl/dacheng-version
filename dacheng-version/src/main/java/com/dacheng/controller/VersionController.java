package com.dacheng.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dacheng.entity.Version;
import com.dacheng.entity.VersionLog;
import com.dacheng.entity.view.PageView;
import com.dacheng.service.VersionLogService;
import com.dacheng.service.VersionService;
import com.dacheng.utils.RandomStr;
import com.dacheng.utils.ServiceConfig;



@Controller
@RequestMapping(value = "/version")
public class VersionController extends BaseController{
	
	@Autowired
	private VersionService versionService;
	
	@Autowired
	private VersionLogService versionLogService;
	

	private static String versionSource=ServiceConfig.getInstance().getValue("server_version_source");
	
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public String list() {
        return "/views/version/versionList";
    }
    
	
    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String add() {
        return "/views/version/versionAdd";
    }
    
    @RequestMapping(value="/list", method = RequestMethod.POST)
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
    }
    
    
    @RequestMapping(value="/getVersionInfo", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getVersionInfo(HttpServletRequest request,String fileName) {
    	 Map<String, Object> map = new HashMap<String, Object>();
    	 if(StringUtils.isNotBlank(fileName)){
    		 String name = getFileNameNoEx(fileName);
 			 String[] aa = name.split("_");
 			 if(null != aa && aa.length == 4){
 				 System.out.println(aa[0]);
 	 			 System.out.println(aa[1]);
 	 			 System.out.println(aa[2].substring(1));
 	 			 System.out.println(aa[3]);
 	 			 Version version = new Version();
 	 			version.setPtype(aa[0].toLowerCase());
 	 			version.setVflag(aa[3]);
 	 			version.setVm(Float.valueOf(aa[2].substring(1)));
 	 			version.setVname(name);
 	 			map.put("code", 0);
 				 map.put("info", version);
 			 }else{
 				 map.put("code", -1);
 	 			map.put("info", null);
 			 }
 			
    	 }else{
    		 map.put("code", -1);
 			map.put("info", null);
    	 }
        return map;
    }
    
    /**
     * 
     * @param request
     * @param vname 版本名称
     * @param vm 版本号
     * @param ptype 产品类型
     * @param vtype 版本类型  1 App版本 2 固件版本
     * @param vflag 版本标识
     * @param cnlog 中文说名
     * @param enlog 英文说明
     * @param forceUpdate 是否强制升级 默认1是
     * @param file 版本文件
     * @return
     */
    @RequestMapping(value="/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> add(HttpServletRequest request,
    		@RequestParam(value ="vname") String vname,
    		@RequestParam(value ="vm",required=false) Float vm,
    		@RequestParam(value ="ptype") String ptype,
    		@RequestParam(value ="vtype") String vtype,
    		@RequestParam(value ="vflag") String vflag,
    		@RequestParam(value ="cnlog",required=false) String cnlog,
    		@RequestParam(value ="enlog",required=false) String enlog,
    		@RequestParam(value ="forceUpdate") String forceUpdate,
    		@RequestParam(value ="file") MultipartFile file) {
    	 Map<String, Object> map = new HashMap<String, Object>();
    	 
    	 if(StringUtils.isNotBlank(vname) && StringUtils.isNotBlank(ptype)
    			 && StringUtils.isNotBlank(vtype) && StringUtils.isNotBlank(vflag)
    			 && StringUtils.isNotBlank(forceUpdate) && null != file && null != vm){
    		 String originalFilename = file.getOriginalFilename();
    		 // 1、检测文件名是否匹配
    		 if(StringUtils.isNotBlank(originalFilename)){
    			 String _vname = getFileNameNoEx(originalFilename);
     			 String[] aa = _vname.split("_");
     			 if(null != aa && aa.length == 4){
     				 String _ptype = aa[0].toLowerCase();
     				 Float _vm = Float.valueOf(aa[2].substring(1));
     				 String _vflag = aa[3];
     				 if(_ptype.equalsIgnoreCase(ptype) && _vm.floatValue() == vm.floatValue() && _vflag.equalsIgnoreCase(vflag)){
     					 // 2、查询版本信息是否已经存在，依据 ptype/vtype/vm/vflag
     					 try {
     						Version version = versionService.findVersionByVersion(_ptype, vtype, _vm, _vflag);
     						if(null != version && null != version.getId()){
     							// 更新操作
     							if(StringUtils.isNotBlank(version.getStatus()) && version.getStatus().equals("0")){
     								  // 保存文件
         							String url = saveFile(file);
         							if(StringUtils.isNotBlank(url)){
         								version.setUrl(url);
         								version.setVname(_vname);
             							version.setForceUpdate(forceUpdate.equals("1")?true:false);
             							versionService.UpdateVersion(version);
             							// 版本声明处理
             							saveVersionLog(version.getId(),cnlog,enlog);
             							map.put("code", 200);
         								map.put("codemsg", "保存成功");
         							}else{
         								// 文件保存失败
         								map.put("code", 500);
         								map.put("codemsg", "服务器异常，请重试或联系管理员");
         							}
     							}else{
     								map.put("code", 403);
     								map.put("codemsg", "该版本已存在且发布，版本保存失败！");
     							}
     						  
     							
     						}else{
     							// 创建操作
     							String url = saveFile(file);
     							if(StringUtils.isNotBlank(url)){
     								Version newVersion = new Version();
         							newVersion.setVname(vname);
         							newVersion.setPtype(ptype);
         							newVersion.setVm(vm);
         							newVersion.setVtype(vtype);
         							newVersion.setVflag(vflag);
         							newVersion.setStatus("0");
         							newVersion.setTestStatus("0");
         							newVersion.setForceUpdate(forceUpdate.equals("1")?true:false);
         							newVersion.setUrl(url);
         							versionService.saveVersion(newVersion);
         							if(null != newVersion && null != newVersion.getId()){
         							    // 版本声明处理
             							saveVersionLog(newVersion.getId(),cnlog,enlog);
         							}
         							map.put("code", 200);
     								map.put("codemsg", "保存成功");
     							}else{
     								// 文件保存失败
     								map.put("code", 500);
     								map.put("codemsg", "文件上传失败，请重试");
     							}
     						}
						} catch (Exception e) {
							// TODO: handle exception
							map.put("code", 500);
							map.put("codemsg", "信息保存失败，请重试");
						}
     					 
     				 }else{
     					// 文件信息有误
     					map.put("code", 422);
						map.put("codemsg", "文件命校验失败，请重试");
     				 }
     			 }else{
     				map.put("code", 422);
					map.put("codemsg", "文件名信息校验失败，请重试");
     			 }
    		 }else{
    			 map.put("code", 422);
				 map.put("codemsg", "文件名信息校验失败，请重试");
    		 }
    	 }else{
    		 // 请求参数不完整
    		 map.put("code", 400);
			 map.put("codemsg", "请求参数错误，请仔细检查");
    	 }
        return map;
    }
    
    /**
     * 保存文件信息
     * @param file
     */
	public String saveFile(MultipartFile file) {
		if (file != null) {
			String fileName = file.getOriginalFilename();
			String saveName = RandomStr.randomString(5) +"_"+ fileName;
			String path = versionSource + saveName;
			File localFile = new File(path);
			if (!localFile.getParentFile().exists()) {
				// 如果目标文件所在的目录不存在，则创建父目录
				localFile.getParentFile().mkdirs();
				System.out.println("parent:" + localFile.getParentFile().getPath());
			}
			// 写文件到本地
			try {
				file.transferTo(localFile);
				return saveName;
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "";
	}
    
    
    /**
     * 
     * @param versionId
     * @param cnlog
     * @param enlog
     * @throws Exception
     */
    public void saveVersionLog(Long versionId,String cnlog,String enlog) throws Exception{
    	if(null != versionId){
    		// 查询中文声明
    		VersionLog cnLog = versionLogService.findVersionLogByIdAndLang(versionId, "cn");
    		if(null != cnLog){
    			if(StringUtils.isNotBlank(cnlog)){
    				// 更新
    				cnLog.setVlog(cnlog);
    				versionLogService.UpdateVersionLog(cnLog);
    			}else{
    				versionLogService.deleteVersionLogByIdAndLang(versionId, "cn");
    			}
    		}else{ // 保存
    			VersionLog newLog = new VersionLog();
    			newLog.setVersionId(versionId);
    			newLog.setLang("cn");
    			newLog.setVlog(cnlog);
    			newLog.setStatus("1");
    			versionLogService.saveVersionLog(newLog);
    		}
    		// 查询英文说明
    		VersionLog enLog = versionLogService.findVersionLogByIdAndLang(versionId, "en");
    		if(null != enLog){
    			if(StringUtils.isNotBlank(enlog)){
    				// 更新
    				enLog.setVlog(enlog);
    				versionLogService.UpdateVersionLog(enLog);
    			}else{
    				versionLogService.deleteVersionLogByIdAndLang(versionId, "en");
    			}
    		}else{ // 保存
    			VersionLog newLog = new VersionLog();
    			newLog.setVersionId(versionId);
    			newLog.setLang("en");
    			newLog.setVlog(enlog);
    			newLog.setStatus("1");
    			versionLogService.saveVersionLog(newLog);
    		}
    	}
    }
    
    /*
     * Java文件操作 获取不带扩展名的文件名
     *
     *  Created on: 2011-8-2
     *      Author: blueeagle
     */
        public static String getFileNameNoEx(String filename) { 
            if ((filename != null) && (filename.length() > 0)) { 
                int dot = filename.lastIndexOf('.'); 
                if ((dot >-1) && (dot < (filename.length()))) { 
                    return filename.substring(0, dot); 
                } 
            } 
            return filename; 
        }
        
        /**
         * 版本删除
         * @param versionId
         * @return
         */
        @RequestMapping(value="/delete/{versionId}",method = RequestMethod.POST)
        @ResponseBody
        public Map<String,Object> delete(@PathVariable Long versionId){
            Map<String,Object> map= new HashMap<String,Object>();
            if(null != versionId){
            	try {
            		Version version = versionService.findVersionById(versionId);
                	if(null != version){
                		versionService.deleteVersionById(versionId);
                		versionLogService.deleteVersionLogById(versionId);
                		// 检测本地版本文件是否存在，如果存在，删除本地版本文件
                		if(StringUtils.isNotBlank(version.getUrl()) && StringUtils.isNotBlank(versionSource)){
                			// 检测本地文件是否存在
                			File file=new File(versionSource+version.getUrl());
                			if(file.exists()){
                				file.delete(); // 删除本地版本程序
                			}
                			
                		}
                		
                		
                	}
                	map.put("code", 200);
					map.put("codemsg", "版本删除成功");
				} catch (Exception e) {
					map.put("code", 500);
					map.put("codemsg", "系统异常，版本删除失败，请重试或联系管理员");
				}
            	
            }else{
            	 // 请求参数不完整
	       		 map.put("code", 400);
	   			 map.put("codemsg", "请求参数错误，请仔细检查");
            }

            return map;
        }
        
        /**
         * 版本发布
         * @param versionId
         * @return
         */
        @RequestMapping(value="/issue/{versionId}",method = RequestMethod.POST)
        @ResponseBody
        public Map<String,Object> issue(@PathVariable Long versionId){
            Map<String,Object> map= new HashMap<String,Object>();
            if(null != versionId){
            	try {
            		Version version = versionService.findVersionById(versionId);
                	if(null != version){
                		if(version.getStatus().equals("0") && version.getTestStatus().equals("1")){
                			Version issue = new Version();
                    		issue.setStatus("1");
                    		issue.setId(versionId);
                    		versionService.UpdateVersion(issue);
                    		map.put("code", 200);
        					map.put("codemsg", "版本发布成功");
                		}else{
                			map.put("code", 403);
        					map.put("codemsg", "版本状态错误，发布失败");
                		}
                	}else{
                		map.put("code", 403);
    					map.put("codemsg", "未找到指定的版本信息");
                	}
				} catch (Exception e) {
					map.put("code", 500);
					map.put("codemsg", "系统异常，版本发布失败，请重试或联系管理员");
				}
            	
            }else{
            	 // 请求参数不完整
	       		 map.put("code", 400);
	   			 map.put("codemsg", "请求参数错误，请仔细检查");
            }
            return map;
        }
        
        
        /**
         * 版本发布
         * @param versionId
         * @return
         */
        @RequestMapping(value="/testPass/{versionId}",method = RequestMethod.POST)
        @ResponseBody
        public Map<String,Object> testPass(@PathVariable Long versionId){
            Map<String,Object> map= new HashMap<String,Object>();
            if(null != versionId){
            	try {
            		Version version = versionService.findVersionById(versionId);
                	if(null != version){
                		if(version.getStatus().equals("0") && version.getTestStatus().equals("0")){
                			Version issue = new Version();
                    		issue.setTestStatus("1");
                    		issue.setId(versionId);
                    		versionService.UpdateVersion(issue);
                    		map.put("code", 200);
        					map.put("codemsg", "版本测试状态修改成功");
                		}else{
                			map.put("code", 403);
        					map.put("codemsg", "版本状态错误，修改失败");
                		}
                	}else{
                		map.put("code", 403);
    					map.put("codemsg", "未找到指定的版本信息");
                	}
				} catch (Exception e) {
					map.put("code", 500);
					map.put("codemsg", "系统异常，版本修改失败，请重试或联系管理员");
				}
            	
            }else{
            	 // 请求参数不完整
	       		 map.put("code", 400);
	   			 map.put("codemsg", "请求参数错误，请仔细检查");
            }
            return map;
        }
        
        
        
        public static void main(String[] args) {
        	String name = "BM2_20161103_V0002_A.bin";
			System.out.println(getFileNameNoEx(name));
			 String[] aa = name.split("_");
			 System.out.println(aa[0]);
			 System.out.println(aa[1]);
			 System.out.println(aa[2].substring(1));
			 System.out.println(aa[3]);
		}
}
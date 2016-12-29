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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dacheng.entity.Version;
import com.dacheng.entity.view.PageView;
import com.dacheng.service.VersionService;
import com.dacheng.utils.RandomStr;



@Controller
@RequestMapping(value = "/version")
public class VersionController extends BaseController{
	
	@Autowired
	private VersionService versionService;
	
	@Value("${server_version_source}")
	private String versionSource;
	
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public String list() {
        return "/version/versionList";
    }
    
	
    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String add() {
        return "/version/versionAdd";
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
 			 System.out.println(aa[0]);
 			 System.out.println(aa[1]);
 			 System.out.println(aa[2].substring(1));
 			 System.out.println(aa[3]);
 			 Version version = new Version();
 			version.setVflag(aa[3]);
 			version.setVm(Float.valueOf(aa[2].substring(1)));
 			version.setVname(name);
 			map.put("code", 0);
			 map.put("info", version);
    	 }else{
    		 map.put("code", -1);
 			map.put("info", null);
    	 }
        return map;
    }
    
    @RequestMapping(value="/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> add(HttpServletRequest request,
    		@RequestParam(value ="vname") String vname,
    		@RequestParam(value ="vm",required=false) Float vm,
    		@RequestParam(value ="ptype") String ptype,
    		@RequestParam(value ="vtype") String vtype,
    		@RequestParam(value ="vflag") String vflag,
    		@RequestParam(value ="cnlog") String cnlog,
    		@RequestParam(value ="enlog") String enlog,
    		@RequestParam(value ="forceUpdate") String forceUpdate,
    		@RequestParam(value ="file") MultipartFile file) {
    	 Map<String, Object> map = new HashMap<String, Object>();
    	 String originalFilename = file.getOriginalFilename();
    	 System.out.println(originalFilename);
    	 try {
    		 // System.out.println("log : "+request.getParameter("detail"));
    		 if(file != null){  
                 String fileName = file.getOriginalFilename();  
                 String path = versionSource +RandomStr.randomString(5) +fileName;  
                 File localFile = new File(path);  
                 if(!localFile.getParentFile().exists()) {  
                      //如果目标文件所在的目录不存在，则创建父目录  
                      localFile.getParentFile().mkdirs();  
                      System.out.println("parent:"+localFile.getParentFile().getPath());  
                  }  
                 //写文件到本地  
                 try {  
                     file.transferTo(localFile);  
                 } catch (IOException e) {  
                     // TODO Auto-generated catch block  
                     e.printStackTrace();  
                    // return resMap;  
                 }  
             }  
    		 System.out.println("log : "+log);
    		 map.put("code", 0);
 			map.put("page", 0);
		} catch (Exception e) {
			// TODO: handle exception
			map.put("code", -1);
			map.put("page", null);
		}
        return map;
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
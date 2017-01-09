package com.dacheng.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomStr
{
  private static Random randGen = null;
  private static char[] numbersAndLetters = null;

  public static final String randomString(int length) {
    if (length < 1) {
      return null; 
    }
    if (randGen == null) {
      randGen = new Random();
      numbersAndLetters = "01234567890236985471458745651355666581256984136598745632159556369812659741668"
        .toCharArray();
    }

    char[] randBuffer = new char[length];
    for (int i = 0; i < randBuffer.length; i++) {
      randBuffer[i] = numbersAndLetters[randGen.nextInt(71)];
    }

    return new String(randBuffer);
  }
  
  public static String SendGET(String url,String param){
	   String result="";//访问返回结果
	   BufferedReader read=null;//读取访问结果
	    
	   try {
	    //创建url
	    URL realurl=new URL(url+"?"+param);
	    //打开连接
	    URLConnection connection=realurl.openConnection();
	     // 设置通用的请求属性
	             connection.setRequestProperty("accept", "*/*");
	             connection.setRequestProperty("connection", "Keep-Alive");
	             connection.setRequestProperty("user-agent",
	                     "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
	             //建立连接
	             connection.connect();
	          // 获取所有响应头字段
	             Map<String, List<String>> map = connection.getHeaderFields();
	             // 遍历所有的响应头字段，获取到cookies等
	             for (String key : map.keySet()) {
	                 System.out.println(key + "--->" + map.get(key));
	             }
	             // 定义 BufferedReader输入流来读取URL的响应
	             read = new BufferedReader(new InputStreamReader(
	                     connection.getInputStream(),"UTF-8"));
	             String line;//循环读取
	             while ((line = read.readLine()) != null) {
	                 result += line;
	             }
	   } catch (IOException e) {
	    e.printStackTrace();
	   }finally{
	    if(read!=null){//关闭流
	     try {
	      read.close();
	     } catch (IOException e) {
	      e.printStackTrace();
	     }
	    }
	   }
	     
	   return result; 
	 }

  public static void main(String[] args) {
    System.out.println(SendGET("https://www.obd-codes.com/p0098",null));
  }
}
package com.dacheng.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.json.Json;

import net.sf.json.JSONArray;

public class JsonMapper {
	// 正确返回码转换成JSON
	public static String successToJson(){
		return "{\"code\":\"200\",\"info\":\"success\"}";
	}
	
	// 正确返回码转换成JSON
	public static String retSuccessToJson(String parameter){
		StringBuffer sb = new StringBuffer("{\"code\":\"200\",\"info\":\"success\",");
		sb.append(parameter).append("}");
		return sb.toString();
	}
	
	// 错误返回码转换成JSON
	public static String failedToJson(){
		// return "{\"code\":\"500\",\"info\":\"程序出现异常，请重试\"}";
		return "{\"code\":\"500\",\"info\":\"The program catch exception,please try again\"}";
	}
	
	// 根据参数返回Json信息
	public static String returnToJson(String code, String info){
		return "{\"code\":\"" + code + "\",\"info\":\"" + info + "\"}";
	}
	
	// 没有查询到数据
	public static String notFindJson(){
		// return "{\"code\":\"214\",\"info\":\"没有找到指定的数据，请重试\"}";
		return "{\"code\":\"214\",\"info\":\"Could not find the specified data，please try again\"}";
	}

	// 参数值为空转换成JSON
	public static String nullParameterToJson(){
		// return "{\"code\":\"215\",\"info\":\"传递的参数值为Null，请重试\"}";
		return "{\"code\":\"215\",\"info\":\"The parameters of the transmission is Null，please try again\"}";
	}
	
	// 数据已经存在转换成JSON
	public static String existToJson(){
		// return "{\"code\":\"216\",\"info\":\"此数据已经存在，请重试\"}";
		return "{\"code\":\"215\",\"info\":\"This data already exists，please try again\"}";
	}
	
	// 随机码不正确
	public static String randomCodeFailedToJson(){
		// return "{\"code\":\"222\",\"info\":\"验证码不正确，请重试\"}";
		return "{\"code\":\"215\",\"info\":\"Verification code is not correct，please try again\"}";
	}
	
	// 把List集合转换成JSON并自动命名
	public static String listToJsonAutoNamingList(List<?> list){
		JSONArray jsonArray = JSONArray.fromObject(list);
		StringBuffer sb = new StringBuffer("{\"code\":\"200\",\"info\":\"success\",\"list\":");
		sb.append(jsonArray.toString()).append("}");
		return sb.toString();
	}
	
	// 把List集合转换成JSON并手动命名
	public static String listToJsonManualNamingList(String listName, List<?> list){
		JSONArray jsonArray = JSONArray.fromObject(list);
		StringBuffer sb = new StringBuffer("{\"code\":\"200\",\"info\":\"success\"");
		sb.append(",\"").append(listName).append("\":");
		sb.append(jsonArray.toString()).append("}");
		return sb.toString();
	}
	
	// 把List集合转换成JSON并手动命名
	public static StringBuffer listToJsonChineseManualNamingList(String listName, List<?> list){
		JSONArray jsonArray = JSONArray.fromObject(list);
		StringBuffer sb = new StringBuffer();
		sb.append(",\"").append(listName).append("\":");
		sb.append(jsonArray.toString());
		return sb;
	}
	
	// 把List集合转换成JSON
	public static String listToJson(List<?> list){
		JSONArray jsonArray = JSONArray.fromObject(list);
		String resultJosn = jsonArray.toString();
		return resultJosn;
	}
	
	// 把Object对象转换成JSON
	public static String objectToJson(String start, Object obj){
		JSONArray jsonArray = JSONArray.fromObject(obj);
		String resultJosn = start + jsonArray.toString().substring(2, jsonArray.toString().length()-1);
		return resultJosn;
	}
	
	// 把Object对象转换成JSON
	public static String objectToJson(Object obj){
		JSONArray jsonArray = JSONArray.fromObject(obj);
		String resultJosn = "{\"code\":\"200\",\"info\":\"success\"," 
				+ jsonArray.toString().substring(2, jsonArray.toString().length()-1);
		return resultJosn;
	}
	public static String mapToJson(Map<String, String> map){
		if(map==null||map.isEmpty())return null;
		StringBuilder result = new StringBuilder();
		Set set = map.entrySet();     
		Iterator i = set.iterator();  
		result.append("{");
		while(i.hasNext()){  
		    Map.Entry<String, String> entry1=(Map.Entry<String, String>)i.next(); 
		    System.out.println(entry1.getKey()+"=="+entry1.getValue()); 
		    result.append("\"" + entry1.getKey() + "\":" + "\"" + entry1.getValue() + "\"");
		    result.append(",");
		} 
		result.delete(result.length()-1, result.length());
		result.append("}");
		return result.toString();
	}
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("广州");
		list.add("深圳");
		
		List<String> list2 = new ArrayList<String>();
		list2.add("郴州");
		list2.add("岳阳");
		
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		map.put("广东", list);
		map.put("湖南", list2);
		
		JSONArray jsonArray = JSONArray.fromObject(map);
		System.out.println(jsonArray.toString());
		HashMap<String, String> temp = new HashMap<String, String>();
		temp.put("info", "succuss");
		temp.put("code", "200");
		temp.put("mileage", "3264");
		System.out.println(mapToJson(temp));
	}
}
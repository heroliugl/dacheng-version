package com.dacheng.push.mqtt.service;

/**
 * MqttCallBackService 
 * @author liugl
 *
 */
public interface MqttCallBackService {
	
	/**
	 * 
	 * @param ClickDTO
	 * @return String
	 */
	public void onDataReceive(String data); 
	
	

}

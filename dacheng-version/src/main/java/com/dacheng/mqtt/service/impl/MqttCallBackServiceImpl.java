package com.dacheng.mqtt.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dacheng.mqtt.CommandService;
import com.dacheng.mqtt.entity.Message;
import com.dacheng.mqtt.service.MqttCallBackService;

import java.io.IOException;

@Service("mqttCallBackService")
public class MqttCallBackServiceImpl implements MqttCallBackService {
	private int status;
	public void onDataReceive(String data) {
		
		System.out.println("Server DataReceive:" + data);
		/*try {
			Message msg= new Message(data);
			if(null != msg){
		    	commandService.handler(msg);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}

	@Autowired
	private CommandService commandService;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}

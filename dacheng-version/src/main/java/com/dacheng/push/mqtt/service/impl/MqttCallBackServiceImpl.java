package com.dacheng.push.mqtt.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dacheng.push.mqtt.CommandService;
import com.dacheng.push.mqtt.entity.Message;
import com.dacheng.push.mqtt.service.MqttCallBackService;

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

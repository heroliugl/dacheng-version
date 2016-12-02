package com.dacheng.push.mqtt;

/**
 * 
 * @author Hunter
 *
 */
public class MessageBean {

	// message type
	private String type;
	// message sender
	private String from;
	// message receiver
	private String to;
	// message body
	private String data;
	// message UUID
	private String uuid;
	// message DATAAWS
	private String dataaws;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getDataaws() {
		return dataaws;
	}

	public void setDataaws(String dataaws) {
		this.dataaws = dataaws;
	}
}

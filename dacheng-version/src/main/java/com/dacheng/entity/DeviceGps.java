package com.dacheng.entity;

import java.util.Date;
/**
 * 设备上传的经纬度地理信息记录
 * @author Administrator
 *
 */
public class DeviceGps {
	
	private String deviceId;   // 设备编号，默认为mac地址
	private String typeCode;   // 产品标识key
	private String osType;     //  1：android 2：IOS  3：其他
	private String ip;         // ip地址
	private Double longitude;  // 经度
	private Double latitude;   // 纬度
	private String country;    // 国家
	private String area;       // 一级行政机构
	private String region;     // 次一级行政机构
	private String address;    // 地址
	private Date createTime;   // 创建时间
	
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public String getOsType() {
		return osType;
	}
	public void setOsType(String osType) {
		this.osType = osType;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Override
	public String toString() {
		return "DeviceGps [deviceId=" + deviceId + ", typeCode=" + typeCode + ", osType=" + osType + ", ip=" + ip
				+ ", longitude=" + longitude + ", latitude=" + latitude + ", country=" + country + ", area=" + area
				+ ", region=" + region + ", address=" + address + ", createTime=" + createTime + "]";
	}
}
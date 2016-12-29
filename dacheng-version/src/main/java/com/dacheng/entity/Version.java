package com.dacheng.entity;

import java.util.Date;

public class Version {
	
	private Long id;
	private String vname;  // 版本名称，eg:OBD_A_1.0.1
	private String ptype;  // 产品类型，eg:OBD、BM
	private String vtype;  // 版本程序类型，eg:1:APP 2:固件
	private String ostype; // 使用操作系统，eg:Android / IOS
	private String vflag;  // 版本补充标记，eg:A / B
	private String vlog;   // 版本描述
	private Float vm;      // 版本号，用于版本比较
	private String vcode;  // 保留
	private Boolean forceUpdate; // 是否要求强制升级  true：是  false：否
	private String url;    // 下载URL
	private String status; // 状态
	private Integer downNum;  // 下载数量
	private Date createTime;  // 创建时间
	private Date updateTime;  // 更新时间
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	public String getVtype() {
		return vtype;
	}
	public void setVtype(String vtype) {
		this.vtype = vtype;
	}
	public String getOstype() {
		return ostype;
	}
	public void setOstype(String ostype) {
		this.ostype = ostype;
	}
	public String getVflag() {
		return vflag;
	}
	public void setVflag(String vflag) {
		this.vflag = vflag;
	}
	public String getVlog() {
		return vlog;
	}
	public void setVlog(String vlog) {
		this.vlog = vlog;
	}
	public Float getVm() {
		return vm;
	}
	public void setVm(Float vm) {
		this.vm = vm;
	}
	public String getVcode() {
		return vcode;
	}
	public void setVcode(String vcode) {
		this.vcode = vcode;
	}
	public Boolean getForceUpdate() {
		return forceUpdate;
	}
	public void setForceUpdate(Boolean forceUpdate) {
		this.forceUpdate = forceUpdate;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getDownNum() {
		return downNum;
	}
	public void setDownNum(Integer downNum) {
		this.downNum = downNum;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "Version [id=" + id + ", vname=" + vname + ", ptype=" + ptype + ", vtype=" + vtype + ", ostype=" + ostype
				+ ", vflag=" + vflag + ", vlog=" + vlog + ", vm=" + vm + ", vcode=" + vcode + ", forceUpdate="
				+ forceUpdate + ", url=" + url + ", status=" + status + ", downNum=" + downNum + ", createTime="
				+ createTime + ", updateTime=" + updateTime + "]";
	}
}
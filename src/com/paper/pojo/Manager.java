package com.paper.pojo;

public class Manager {
	private String managerId;
	private String managerName;
	private String managerPasswd;
	private String managerPhone;
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	
	public String getManagerPasswd() {
		return managerPasswd;
	}
	public void setManagerPasswd(String managerPasswd) {
		this.managerPasswd = managerPasswd;
	}
	public String getManagerPhone() {
		return managerPhone;
	}
	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}
	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", managerName=" + managerName + ", managerPasswd=" + managerPasswd
				+ ", managerPhone=" + managerPhone + "]";
	}
	
	
	
	
}

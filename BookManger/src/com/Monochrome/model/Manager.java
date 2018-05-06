package com.Monochrome.model;

public class Manager {
	private long managerId;//管理员编号
	private String name;//姓名
	private String accounts;//帐号
	private String passwords;//密码

	public Manager() {
		// TODO Auto-generated constructor stub
	}
	
	public Manager(long managerId, String name, String accounts, String passwords) {
		this.managerId = managerId;
		this.name = name;
		this.accounts = accounts;
		this.passwords = passwords;
	}

	public long getManagerId() {
		return managerId;
	}

	public void setManagerId(long managerId) {
		this.managerId = managerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccounts() {
		return accounts;
	}

	public void setAccounts(String accounts) {
		this.accounts = accounts;
	}

	public String getPasswords() {
		return passwords;
	}

	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "manager [" + managerId + "," + name + "," + accounts + "," + passwords + "]";
	}
	
}

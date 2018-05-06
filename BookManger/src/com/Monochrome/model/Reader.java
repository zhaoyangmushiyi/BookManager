package com.Monochrome.model;

import java.sql.Date;

public class Reader {
	
	private long readerId;//读者编号
	private String readerName;//读者姓名
	private String sex;//读者性别
	private String college;//学院
	private Date enrollmentDate;//入学日期
	private String phoneNumber;//电话
	private double balance;//余额
	private Date recordDate;//登记日期
	
	public Reader() {
		// TODO Auto-generated constructor stub
	}
	
	public Reader(long readerId, String readerName, String sex, String college, Date enrollmentDate, String phoneNumber,
			double balance, Date recordDate) {
		this.readerId = readerId;
		this.readerName = readerName;
		this.sex = sex;
		this.college = college;
		this.enrollmentDate = enrollmentDate;
		this.phoneNumber = phoneNumber;
		this.balance = balance;
		this.recordDate = recordDate;
	}

	public long getReaderId() {
		return readerId;
	}

	public void setReaderId(long readerId) {
		this.readerId = readerId;
	}

	public String getReaderName() {
		return readerName;
	}

	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public Date getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(Date enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Reader [" + readerId + "," + readerName + "," + sex + "," + college + "," + enrollmentDate + "," + phoneNumber + ","
				+ balance + "," + recordDate + "]";
	}
	
}

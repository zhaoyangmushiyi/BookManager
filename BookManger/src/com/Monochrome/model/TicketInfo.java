package com.Monochrome.model;

import java.sql.Date;

public class TicketInfo {
	
	private long ticketId;//罚单编号
	private long readerId;//读者编号
	private String readerName;//读者姓名
	private double ticketTotal;//罚单合计
	private long lendId;//借阅编号
	private Date transactionDate;//办理日期
	
	public TicketInfo(long ticketId, long readerId, String readerName, double ticketTotal, long lendId,
			Date transactionDate) {
		this.ticketId = ticketId;
		this.readerId = readerId;
		this.readerName = readerName;
		this.ticketTotal = ticketTotal;
		this.lendId = lendId;
		this.transactionDate = transactionDate;
	}

	public long getTicketId() {
		return ticketId;
	}

	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
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

	public double getTicketTotal() {
		return ticketTotal;
	}

	public void setTicketTotal(double ticketTotal) {
		this.ticketTotal = ticketTotal;
	}

	public long getLendId() {
		return lendId;
	}

	public void setLendId(long lendId) {
		this.lendId = lendId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ticketInfo [" + ticketId + "," + readerId + "," + readerName + "," + ticketTotal + "," + lendId + "," + transactionDate + "]";
	}

}

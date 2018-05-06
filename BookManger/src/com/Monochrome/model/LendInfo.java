package com.Monochrome.model;

import java.sql.Date;

public class LendInfo {
	
	private long lendId;//借阅编号
	private long readerId;//读者编号
	private String readerName;//读者姓名
	private long bookId;//书号
	private String bookName;
	private Date borrowDate;//借阅日期
	private Date returnDate;//归还日期
	private String lendState;//借阅状态
	private Reader reader;
	
	public LendInfo(){}
	
	public LendInfo(long lendId, long readerId, String readerName, Date borrowDate, Date returnDate, String lendState) {
		this.lendId = lendId;
		this.readerId = readerId;
		this.readerName = readerName;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
		this.lendState = lendState;
	}

	public long getLendId() {
		return lendId;
	}

	public void setLendId(long lendId) {
		this.lendId = lendId;
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

	public Date getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getLendState() {
		return lendState;
	}

	public void setLendState(String lendState) {
		this.lendState = lendState;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}
	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "lendInfo [" + lendId + "," + readerId + "," + readerName + "," + borrowDate + "," + returnDate + "," + lendState + "]";
	}
	
}

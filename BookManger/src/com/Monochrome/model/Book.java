package com.Monochrome.model;

import java.sql.Date;

/**
 * 图书实体类
 * @author Monochrome
 *
 */
public class Book {

	
	private long bookId; //编号
	private String bookName;  //图书名称
	private String bookState;  //书籍状态
	private String editor;  //主编
	private String author;  //作者
	private String press;  //出版社
	private String bookTypeName;  //图书类别名称
	private Date publishDate;	//出版日期
	private Double price;  //价格
	private Date recordDate;	//登记日期

	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public Book(long bookId, String bookName, String bookState, String editor, String author, String press,
			String bookTypeName, Date publishDate, Double price, Date recordDate) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookState = bookState;
		this.editor = editor;
		this.author = author;
		this.press = press;
		this.bookTypeName = bookTypeName;
		this.publishDate = publishDate;
		this.price = price;
		this.recordDate = recordDate;
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

	public String getBookState() {
		return bookState;
	}

	public void setBookState(String bookState) {
		this.bookState = bookState;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public String getBookTypeName() {
		return bookTypeName;
	}

	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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
		return "book: [" + bookId + "," + bookName + "," + bookState + "," + editor + "," + author + "," + press + ","
				+ bookTypeName + ","  + publishDate + "," + price + "," + recordDate + "]";
	}
}

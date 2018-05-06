package com.Monochrome.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.Monochrome.model.Book;
public class BookDao implements Dao<Book> {

	@Override
	public boolean add(Connection con, Book book) {
		// TODO Auto-generated method stub
		String sql = "insert into t_book values (?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, book.getBookId());
			ps.setString(2, book.getBookName());
			ps.setString(3, book.getBookState());
			ps.setString(4, book.getEditor());
			ps.setString(5, book.getAuthor());
			ps.setString(6, book.getPress());
			ps.setString(7, book.getBookTypeName());
			ps.setDate(8, book.getPublishDate());
			ps.setDouble(9, book.getPrice());
			ps.setDate(10, book.getRecordDate());
			if (ps.executeUpdate() != 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public Book get(Connection con, long bookId) {
		Book book = null;
		String sql = "select * from t_book where bookId = " + bookId;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				book = new Book();
				
				String bookName = rs.getString("bookName");
				String bookState = rs.getString("bookState");
				String editor = rs.getString("editor");
				String author = rs.getString("author");
				String press = rs.getString("press");
				String bookTypeName = rs.getString("bookTypeName");
				Date publishDate = rs.getDate("publishDate");
				double price = rs.getDouble("price");
				Date recordDate = rs.getDate("recordDate");
				
				book.setAuthor(author);
				book.setBookId(bookId);
				book.setBookName(bookName);
				book.setBookState(bookState);
				book.setBookTypeName(bookTypeName);
				book.setEditor(editor);
				book.setPress(press);
				book.setPrice(price);
				book.setPublishDate(publishDate);
				book.setRecordDate(recordDate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
		
	}
	
	@Override
	public boolean delete(Connection con, long id) {
		// TODO Auto-generated method stub
		String sql = "delete from t_book where bookId = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, id);
			if (ps.executeUpdate() != 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Connection con, long id, Book book) {
		// TODO Auto-generated method stub
		String sql = "update t_book set bookId=?,bookName=?,bookState=?,editor=?,author=?,press=?,bookTypeName=?,publishDate=?,price=?,recordDate=? where bookId = " + id;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, book.getBookId());
			ps.setString(2,book.getBookName());
			ps.setString(3, book.getBookState());
			ps.setString(4, book.getEditor());
			ps.setString(5, book.getAuthor());
			ps.setString(6, book.getPress());
			ps.setString(7, book.getBookTypeName());
			ps.setDate(8, book.getPublishDate());
			ps.setDouble(9, book.getPrice());
			ps.setDate(10, book.getRecordDate());
			if (ps.executeUpdate() != 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Book> list(Connection con) {
		// TODO Auto-generated method stub
		String sql = "select * from t_book";
		List<Book> books = new LinkedList<>(); 
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				long bookId = rs.getLong(1);
				String bookName = rs.getString("bookName");
				String bookState = rs.getString("bookState");
				String editor = rs.getString("editor");
				String author = rs.getString("author");
				String press = rs.getString("press");
				String bookTypeName = rs.getString("bookTypeName");
				Date publishDate = rs.getDate("publishDate");
				double price = rs.getDouble("price");
				Date recordDate = rs.getDate("recordDate");
				book.setAuthor(author);
				book.setBookId(bookId);
				book.setBookName(bookName);
				book.setBookState(bookState);
				book.setBookTypeName(bookTypeName);
				book.setEditor(editor);
				book.setPress(press);
				book.setPrice(price);
				book.setPublishDate(publishDate);
				book.setRecordDate(recordDate);
				books.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}
	
	public List<Book> searchByName(Connection con, String bookName) {
		String sql = "select * from t_book where bookName = '" + bookName + "'";
		List<Book> books = new LinkedList<>(); 
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				long bookId = rs.getLong(1);
				String bookState = rs.getString("bookState");
				String editor = rs.getString("editor");
				String author = rs.getString("author");
				String press = rs.getString("press");
				String bookTypeName = rs.getString("bookTypeName");
				Date publishDate = rs.getDate("publishDate");
				double price = rs.getDouble("price");
				Date recordDate = rs.getDate("recordDate");
				book.setAuthor(author);
				book.setBookId(bookId);
				book.setBookName(bookName);
				book.setBookState(bookState);
				book.setBookTypeName(bookTypeName);
				book.setEditor(editor);
				book.setPress(press);
				book.setPrice(price);
				book.setPublishDate(publishDate);
				book.setRecordDate(recordDate);
				books.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}
	
	public List<Book> searchByAuthor(Connection con, String author) {
		String sql = "select * from t_book where author = '" + author + "'";
		List<Book> books = new LinkedList<>(); 
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				long bookId = rs.getLong(1);
				String bookName = rs.getString("bookName");
				String bookState = rs.getString("bookState");
				String editor = rs.getString("editor");
				String press = rs.getString("press");
				String bookTypeName = rs.getString("bookTypeName");
				Date publishDate = rs.getDate("publishDate");
				double price = rs.getDouble("price");
				Date recordDate = rs.getDate("recordDate");
				book.setAuthor(author);
				book.setBookId(bookId);
				book.setBookName(bookName);
				book.setBookState(bookState);
				book.setBookTypeName(bookTypeName);
				book.setEditor(editor);
				book.setPress(press);
				book.setPrice(price);
				book.setPublishDate(publishDate);
				book.setRecordDate(recordDate);
				books.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}
	
	public Book searchByNameAndAuthor(Connection con, String bookName, String author) {
		String sql = "select * from t_book where bookName = '" + bookName + "' and author = '" + author + "'";
		Book book = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				book = new Book();
				long bookId = rs.getLong(1);
				String bookState = rs.getString("bookState");
				String editor = rs.getString("editor");
				String press = rs.getString("press");
				String bookTypeName = rs.getString("bookTypeName");
				Date publishDate = rs.getDate("publishDate");
				double price = rs.getDouble("price");
				Date recordDate = rs.getDate("recordDate");
				book.setAuthor(author);
				book.setBookId(bookId);
				book.setBookName(bookName);
				book.setBookState(bookState);
				book.setBookTypeName(bookTypeName);
				book.setEditor(editor);
				book.setPress(press);
				book.setPrice(price);
				book.setPublishDate(publishDate);
				book.setRecordDate(recordDate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}
	
}

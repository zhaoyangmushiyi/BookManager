package com.Monochrome.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.Monochrome.model.Book;
import com.Monochrome.model.LendInfo;

public class LendInfoDao implements Dao<LendInfo> {

	@Override
	public boolean add(Connection con, LendInfo t) {
		// TODO Auto-generated method stub
		String sql = "insert into t_lendInfo values (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, t.getLendId());
			ps.setLong(2, t.getReaderId());
			ps.setString(3, t.getReaderName());
			ps.setLong(4, t.getBookId());
			ps.setString(5, t.getBookName());
			ps.setDate(6, t.getBorrowDate());
			ps.setDate(7, t.getReturnDate());
			ps.setString(8, t.getLendState());
			if (ps.executeUpdate() != 0) {
				Book book = new BookDao().get(con, t.getBookId());
				book.setBookState("是");
				new BookDao().update(con, book.getBookId(), book);
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public LendInfo get(Connection con, long lendId) {
		String sql = "select * from t_lendInfo where lendID = " + lendId;
		LendInfo lendInfo = null;
		try {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			if(rs.next()) {
				lendInfo = new LendInfo();
				long readerId = rs.getLong("readerId");
				String readerName = rs.getString("readerName"); 
				long bookId = rs.getLong("bookId");
				String bookName = rs.getString("bookName");
				Date borrowDate = rs.getDate("borrowDate");
				Date returnDate = rs.getDate("returnDate");
				String lendState = rs.getString("lendState");
				
				lendInfo.setBorrowDate(borrowDate);
				lendInfo.setReturnDate(returnDate);
				lendInfo.setLendId(lendId);
				lendInfo.setReaderId(readerId);
				lendInfo.setReaderName(readerName);
				lendInfo.setBookId(bookId);
				lendInfo.setBookName(bookName);
				lendInfo.setLendState(lendState);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lendInfo;
	}
	
	@Override
	public boolean delete(Connection con, long id) {
		// TODO Auto-generated method stub
		String sql = "delete from t_lendInfo where lendId = ?";
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
	public boolean update(Connection con, long id, LendInfo t) {
		// TODO Auto-generated method stub
		String sql = "update t_lendInfo set lendID=?,readerId=?,readerName=?,bookId=?,bookName=?,borrowDate=?,returnDate=?,lendState=? where lendId = " + id;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, t.getLendId());
			ps.setLong(2, t.getReaderId());
			ps.setString(3, t.getReaderName());
			ps.setLong(4, t.getBookId());
			ps.setString(5, t.getBookName());
			ps.setDate(6, t.getBorrowDate());
			ps.setDate(7, t.getReturnDate());
			ps.setString(8, t.getLendState());
			if (ps.executeUpdate() != 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
//	public List<LendInfo> list(Connection con, int readerId) {
//		String sql = "select * from t_lendInfo where readerId = " + readerId;
//		List<LendInfo> list = new LinkedList<>();
//		try {
//			PreparedStatement ps = con.prepareStatement(sql);
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				LendInfo lendInfo = new LendInfo();
//				long lendId = rs.getLong(1);
//				String readerName = rs.getString("readerName");
//				long bookId = rs.getLong("bookId");
//				String bookName = rs.getString("bookName");
//				Date borrowDate = rs.getDate("borrowDate");
//				Date returnDate = rs.getDate("returnDate");
//				String lendState = rs.getString("lendState");
//				
//				lendInfo.setBorrowDate(borrowDate);
//				lendInfo.setReturnDate(returnDate);
//				lendInfo.setLendId(lendId);
//				lendInfo.setReaderId(readerId);
//				lendInfo.setReaderName(readerName);
//				lendInfo.setBookId(bookId);
//				lendInfo.setBookName(bookName);
//				lendInfo.setLendState(lendState);
//				
//				list.add(lendInfo);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return list;
//	}
	@Override
	public List<LendInfo> list(Connection con) {
		// TODO Auto-generated method stub
		String sql = "select * from t_lendInfo";
		List<LendInfo> list = new LinkedList<>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				LendInfo lendInfo = new LendInfo();
				long lendId = rs.getLong(1);
				long readerId = rs.getLong("readerId");
				String readerName = rs.getString("readerName");
				long bookId = rs.getLong("bookId");
				String bookName = rs.getString("bookName"); 
				Date borrowDate = rs.getDate("borrowDate");
				Date returnDate = rs.getDate("returnDate");
				String lendState = rs.getString("lendState");
				
				lendInfo.setBorrowDate(borrowDate);
				lendInfo.setReturnDate(returnDate);
				lendInfo.setLendId(lendId);
				lendInfo.setReaderId(readerId);
				lendInfo.setReaderName(readerName);
				lendInfo.setBookId(bookId);
				lendInfo.setBookName(bookName);
				lendInfo.setLendState(lendState);
				
				list.add(lendInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<LendInfo> searchByReaderName(Connection con, String readerName) {
		// TODO Auto-generated method stub
		String sql = "select * from t_lendInfo where readerName = " + readerName;
		List<LendInfo> list = new LinkedList<>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				LendInfo lendInfo = new LendInfo();
				long lendId = rs.getLong(1);
				long readerId = rs.getLong("readerId");
				long bookId = rs.getLong("bookId");
				String bookName = rs.getString("bookName"); 
				Date borrowDate = rs.getDate("borrowDate");
				Date returnDate = rs.getDate("returnDate");
				String lendState = rs.getString("lendState");
				
				lendInfo.setBorrowDate(borrowDate);
				lendInfo.setReturnDate(returnDate);
				lendInfo.setLendId(lendId);
				lendInfo.setReaderId(readerId);
				lendInfo.setReaderName(readerName);
				lendInfo.setBookId(bookId);
				lendInfo.setBookName(bookName);
				lendInfo.setLendState(lendState);
				
				list.add(lendInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<LendInfo> searchByBookName(Connection con, String bookName) {
		// TODO Auto-generated method stub
		List<LendInfo> list = new LinkedList<>();
		String sql = "select * from t_lendInfo where bookName = '" + bookName + "'";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				LendInfo lendInfo = new LendInfo();
				long lendId = rs.getLong(1);
				long readerId = rs.getLong("readerId");
				String readerName = rs.getString("readerName");
				long bookId = rs.getLong("bookId");
				Date borrowDate = rs.getDate("borrowDate");
				Date returnDate = rs.getDate("returnDate");
				String lendState = rs.getString("lendState");
				
				lendInfo.setBorrowDate(borrowDate);
				lendInfo.setReturnDate(returnDate);
				lendInfo.setLendId(lendId);
				lendInfo.setReaderId(readerId);
				lendInfo.setReaderName(readerName);
				lendInfo.setBookId(bookId);
				lendInfo.setBookName(bookName);
				lendInfo.setLendState(lendState);
				list.add(lendInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public LendInfo searchByReaderNameAndBookName(Connection con, String readerName, String bookName) {
		// TODO Auto-generated method stub
		String sql = "select * from t_lendInfo where readerName = ? and bookName = ?";
		LendInfo lendInfo = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, readerName);
			ps.setString(2, bookName);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				lendInfo = new LendInfo();
				long lendId = rs.getLong(1);
				long readerId = rs.getLong("readerId");
				long bookId = rs.getLong("bookId");
				Date borrowDate = rs.getDate("borrowDate");
				Date returnDate = rs.getDate("returnDate");
				String lendState = rs.getString("lendState");
				
				lendInfo.setBorrowDate(borrowDate);
				lendInfo.setReturnDate(returnDate);
				lendInfo.setLendId(lendId);
				lendInfo.setReaderId(readerId);
				lendInfo.setReaderName(readerName);
				lendInfo.setBookId(bookId);
				lendInfo.setBookName(bookName);
				lendInfo.setLendState(lendState);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lendInfo;
	}

}

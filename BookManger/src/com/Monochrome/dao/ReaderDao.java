package com.Monochrome.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.Monochrome.model.Reader;

public class ReaderDao implements Dao<Reader> {

	@Override
	public boolean add(Connection con, Reader reader) {
		// TODO Auto-generated method stub
		String sql = "insert into t_reader values (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, reader.getReaderId());
			ps.setString(2, reader.getReaderName());
			ps.setString(3, reader.getSex());
			ps.setString(4, reader.getCollege());
			ps.setDate(5, reader.getEnrollmentDate());
			ps.setString(6, reader.getPhoneNumber());
			ps.setDouble(7, reader.getBalance());
			ps.setDate(8, reader.getRecordDate());
			if (ps.executeUpdate() != 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public Reader get(Connection con, long readerId) {
		// TODO Auto-generated method stub
		String sql = "select * from t_reader where readerId = " + readerId;
		Reader reader = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				reader = new Reader();
				
				String readerName = rs.getString("readerName");
				String sex = rs.getString("sex");
				String college = rs.getString("college");
				Date enrollmentDate = rs.getDate("enrollmentDate");
				String phoneNumber = rs.getString("phoneNumber");
				double balance = rs.getDouble("balance");
				Date recordDate = rs.getDate("recordDate");
				
				reader.setBalance(balance);
				reader.setCollege(college);
				reader.setEnrollmentDate(enrollmentDate);
				reader.setPhoneNumber(phoneNumber);
				reader.setReaderId(readerId);
				reader.setReaderName(readerName);
				reader.setRecordDate(recordDate);
				reader.setSex(sex);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reader;
	}
	
	@Override
	public boolean delete(Connection con, long id) {
		// TODO Auto-generated method stub
		String sql = "delete from t_reader where readerId = ?";
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
	public boolean update(Connection con, long id, Reader reader) {
		// TODO Auto-generated method stub
		String sql = "update t_reader set readerId=?,readerName=?,sex=?,college=?,enrollmentDate=?,phoneNumber=?,balance=?,recordDate=? where readerId = " + id;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, reader.getReaderId());
			ps.setString(2, reader.getReaderName());
			ps.setString(3, reader.getSex());
			ps.setString(4, reader.getCollege());
			ps.setDate(5, reader.getEnrollmentDate());
			ps.setString(6, reader.getPhoneNumber());
			ps.setDouble(7, reader.getBalance());
			ps.setDate(8, reader.getRecordDate());
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
	public List<Reader> list(Connection con) {
		// TODO Auto-generated method stub
		String sql = "select * from t_reader";
		List<Reader> list = new LinkedList<>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Reader reader = new Reader();
				
				long readerId = rs.getLong(1);
				String readerName = rs.getString("readerName");
				String sex = rs.getString("sex");
				String college = rs.getString("college");
				Date enrollmentDate = rs.getDate("enrollmentDate");
				String phoneNumber = rs.getString("phoneNumber");
				double balance = rs.getDouble("balance");
				Date recordDate = rs.getDate("recordDate");
				
				reader.setBalance(balance);
				reader.setCollege(college);
				reader.setEnrollmentDate(enrollmentDate);
				reader.setPhoneNumber(phoneNumber);
				reader.setReaderId(readerId);
				reader.setReaderName(readerName);
				reader.setRecordDate(recordDate);
				reader.setSex(sex);
				
				list.add(reader);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<Reader> searchByName(Connection con, String readerName) {
		// TODO Auto-generated method stub
		String sql = "select * from t_reader where readerName = '" + readerName + "'";
		List<Reader> list = new LinkedList<>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Reader reader = new Reader();
				
				long readerId = rs.getLong(1);
				String sex = rs.getString("sex");
				String college = rs.getString("college");
				Date enrollmentDate = rs.getDate("enrollmentDate");
				String phoneNumber = rs.getString("phoneNumber");
				double balance = rs.getDouble("balance");
				Date recordDate = rs.getDate("recordDate");
				
				reader.setBalance(balance);
				reader.setCollege(college);
				reader.setEnrollmentDate(enrollmentDate);
				reader.setPhoneNumber(phoneNumber);
				reader.setReaderId(readerId);
				reader.setReaderName(readerName);
				reader.setRecordDate(recordDate);
				reader.setSex(sex);
				
				list.add(reader);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public Reader searchById(Connection con, long readerId) {
		// TODO Auto-generated method stub
		String sql = "select * from t_reader where readerId = " + readerId;
		Reader reader = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				reader = new Reader();
				
				String readerName = rs.getString("readerName");
				String sex = rs.getString("sex");
				String college = rs.getString("college");
				Date enrollmentDate = rs.getDate("enrollmentDate");
				String phoneNumber = rs.getString("phoneNumber");
				double balance = rs.getDouble("balance");
				Date recordDate = rs.getDate("recordDate");
				
				reader.setBalance(balance);
				reader.setCollege(college);
				reader.setEnrollmentDate(enrollmentDate);
				reader.setPhoneNumber(phoneNumber);
				reader.setReaderId(readerId);
				reader.setReaderName(readerName);
				reader.setRecordDate(recordDate);
				reader.setSex(sex);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reader;
	}

	public Reader searchByIdAndName(Connection con, long readerId, String readerName) {
		// TODO Auto-generated method stub
		String sql = "select * from t_reader where readerId = " + readerId + " and readerName = '" + readerName + "'";
		Reader reader = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				reader = new Reader();
				
				String sex = rs.getString("sex");
				String college = rs.getString("college");
				Date enrollmentDate = rs.getDate("enrollmentDate");
				String phoneNumber = rs.getString("phoneNumber");
				double balance = rs.getDouble("balance");
				Date recordDate = rs.getDate("recordDate");
				
				reader.setBalance(balance);
				reader.setCollege(college);
				reader.setEnrollmentDate(enrollmentDate);
				reader.setPhoneNumber(phoneNumber);
				reader.setReaderId(readerId);
				reader.setReaderName(readerName);
				reader.setRecordDate(recordDate);
				reader.setSex(sex);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reader;
	}
}

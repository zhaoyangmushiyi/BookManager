package com.Monochrome.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.Monochrome.model.TicketInfo;

public class TicketInfoDao implements Dao<TicketInfo> {

	@Override
	public boolean add(Connection con, TicketInfo ticketInfo) {
		// TODO Auto-generated method stub
		String sql = "insert into t_ticketInfo values (?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, ticketInfo.getTicketId());
			ps.setLong(2, ticketInfo.getReaderId());
			ps.setString(3, ticketInfo.getReaderName());
			ps.setDouble(4, ticketInfo.getTicketTotal());
			ps.setLong(5, ticketInfo.getLendId());
			ps.setDate(6, ticketInfo.getTransactionDate());
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
	public boolean delete(Connection con, long id) {
		// TODO Auto-generated method stub
		String sql = "delete from t_ticketInfo where ticketId = ?";
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
	public boolean update(Connection con, long id, TicketInfo ticketInfo) {
		// TODO Auto-generated method stub
		String sql = "update t_ticketInfo set ticketID=?,readerId=?,readerName=?,ticketTotal=?,lendID=?,transactionDate=? where ticketID = " + id;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, ticketInfo.getTicketId());
			ps.setLong(2, ticketInfo.getReaderId());
			ps.setString(3, ticketInfo.getReaderName());
			ps.setDouble(4, ticketInfo.getTicketTotal());
			ps.setLong(5, ticketInfo.getLendId());
			ps.setDate(6, ticketInfo.getTransactionDate());
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
	public List<TicketInfo> list(Connection con) {
		// TODO Auto-generated method stub
		String sql = "select * from t_ticketInfo";
		List<TicketInfo> list = new LinkedList<>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				TicketInfo ticketInfo = new TicketInfo(rs.getLong(1), rs.getInt(2), rs.getString(3), rs.getDouble(4), rs.getLong(5), rs.getDate(6));
				list.add(ticketInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}

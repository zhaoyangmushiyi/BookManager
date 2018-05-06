package com.Monochrome.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.Monochrome.model.Manager;

public class ManagerDao implements Dao<Manager> {

	@Override
	public boolean add(Connection con, Manager manager) {
		// TODO Auto-generated method stub
		String sql = "insert into t_manager values (?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, manager.getManagerId());
			ps.setString(2, manager.getName());
			ps.setString(3, manager.getAccounts());
			ps.setString(4, manager.getPasswords());
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
		String sql = "delete from t_manager where managerId = ?";
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
	public boolean update(Connection con, long id, Manager manager) {
		// TODO Auto-generated method stub
		String sql = "update t_manager set managerId=?,managerName=?,accounts=?,passwords=? where managerId = " + id;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, manager.getManagerId());
			ps.setString(2, manager.getName());
			ps.setString(3, manager.getAccounts());
			ps.setString(4, manager.getPasswords());
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
	public List<Manager> list(Connection con) {
		// TODO Auto-generated method stub
		String sql = "select * from t_manager";
		List<Manager> list = new LinkedList<>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Manager manager = new Manager(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4));
				list.add(manager);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean isExit(Connection con, String accounts, String passwords) {
		String sql = "select accounts,passwords from t_manager";
		try {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				if (accounts.equals(rs.getString(1))) {
					if (passwords.equals(rs.getString(2))) {
						return true;
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
}

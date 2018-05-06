package com.Monochrome.dao;

import java.sql.Connection;
import java.util.List;

public interface Dao<T> {
	public boolean add(Connection con, T t);
	public boolean delete(Connection con, long id);
	public boolean update(Connection con, long id, T t);
	public List<T> list(Connection con);
}

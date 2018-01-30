package com.frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public abstract class Biz<VO, ID> {

	protected Dao<VO, ID> dao;
	protected Connection conn;
	
	public Biz() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Not Found Exception");
		}
	}
	
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "db";
		String password = "db";
		try {
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);// commit 만날 때 까지 반영하지 마!
		} catch (SQLException e) {
			System.out.println("Connection Fail");
			throw e;
		}
		return conn;
	}
	public void close(Connection conn) throws SQLException {
		if (conn != null)
			try {conn.close();
			} catch (SQLException e) {}
	}
	
	public abstract void register(VO vo) throws Exception ;
	public abstract void modify(VO vo) throws Exception ;
	public abstract void remove(ID id) throws Exception ;
	public abstract VO get(ID id) throws Exception ;
	public abstract List<VO> get() throws Exception ;
	
}

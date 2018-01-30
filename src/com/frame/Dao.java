package com.frame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class Dao<VO, ID> {
	
	protected PreparedStatement st;
	protected int result;
	protected ResultSet rs;
	protected String sql;
	
	public void close(PreparedStatement st, ResultSet rs) {
			try {
				if(st!=null) st.close();
				if(rs!=null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public abstract void insert(VO vo, Connection conn) throws Exception ;
	public abstract void update(VO vo, Connection conn)throws Exception ;
	public abstract void delete(ID id, Connection conn)throws Exception ;
	public abstract VO select(ID id, Connection conn)throws Exception ;
	public abstract List<VO> select(Connection conn)throws Exception ;
	
}

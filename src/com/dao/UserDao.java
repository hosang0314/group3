package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sql.MovieProjectSql;
import com.vo.UserVO;

public class UserDao {
	
	protected PreparedStatement st;
	protected int result;
	protected ResultSet rs;
	protected String sql;

	public void close(PreparedStatement st, ResultSet rs) {
		try {
			if (st != null) st.close();
			if (rs != null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void insert(UserVO vo, int grade, Connection conn) throws Exception {
		try {
			st = conn.prepareStatement(MovieProjectSql.insertUser);
			st.setString(1, vo.getId());
			st.setInt(2, grade);
			result = st.executeUpdate();
			System.out.println(result + "건의 정보가 User DB에 성공적으로 등록되었습니다.");
		} catch (Exception e) {
			throw e;
		} finally {
			close(st, null);
		}
	}


	public UserVO select(String id, Connection conn) throws Exception {
		UserVO user = null;
		try {
			st = conn.prepareStatement(MovieProjectSql.selectUserById);
			st.setString(1, id);
			rs = st.executeQuery();
			rs.next();
			int grade = rs.getInt("age");
			user = new UserVO(id, grade);
		} catch (Exception e) {
			throw e;
		} finally {
			close(st, rs);
		}		
		return user;
	}

	public List<UserVO> select(Connection conn) throws Exception {
		List<UserVO> list = new ArrayList<>();
		UserVO user = null;
		try {
			st = conn.prepareStatement(MovieProjectSql.selectAllUser);
			rs = st.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				int grade = rs.getInt("grade");
				user = new UserVO(id, grade);
				list.add(user);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			close(st, rs);
		}
		return list;
	}

}

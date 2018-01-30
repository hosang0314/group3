package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.sql.MovieProjectSql;
import com.vo.TimetableVO;
import com.vo.UserVO;

public class UserTimetableDao {

	protected String sql;
	protected PreparedStatement st;
	protected ResultSet rs;
	protected int result;

	public void insert(UserVO user, TimetableVO timetable, Connection conn) throws SQLException {
		try {
			st = conn.prepareStatement(MovieProjectSql.insertUserAndMovieTime);
			st.setString(1, user.getId());
			st.setString(2, timetable.getTimetableId());
			result = st.executeUpdate();
			System.out.println(result + " ���� �����Ͱ� UserTimetable DB�� ���������� �ԷµǾ����ϴ�.");
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			close(st, null);
		}
	}

	public List<String> select(UserVO user, Connection conn) throws SQLException {
		List<String> list = new ArrayList<>(); // ����ڰ� �� ��ȭ�ð�ǥ ����Ʈ
		try {
			st = conn.prepareStatement(MovieProjectSql.selectUserAndMovieTime);
			rs = st.executeQuery();
			while (rs.next()) {
				String timetableId = rs.getString("TimetableId");
				list.add(timetableId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			close(st, rs);
		}
		return list;
	}

	public void close(PreparedStatement st, ResultSet rs) {
		try {
			if (st != null) st.close();
			if (rs != null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

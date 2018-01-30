package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import com.sql.MovieProjectSql;
import com.vo.TimetableVO;

public class TimetableDao {
	
	protected PreparedStatement st;
	protected int result;
	protected ResultSet rs;
	protected String sql;
	
	public void insert(TimetableVO tt, Connection conn) throws SQLException {
		try {
			st = conn.prepareStatement(MovieProjectSql.insertMovieTime);
			st.setString(1, tt.getTimetableId());
			st.setString(2, tt.getMovieId());
			st.setString(3, tt.getTime());
			result = st.executeUpdate();
			System.out.println(result + "건의 정보가 Timetable DB에 성공적으로 등록되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			close(st, null);
		}
		
	}
	
	public List<TimetableVO> select(String movieId, Connection conn) throws SQLException {
		List<TimetableVO> list = new ArrayList<>();
		try {
			st = conn.prepareStatement(MovieProjectSql.selectSchedule);
			st.setString(1, movieId);
			rs = st.executeQuery();
			while(rs.next()) {
				String timetableId = rs.getString("timetableId");
				String time = rs.getString("time");
				TimetableVO tt = new TimetableVO(timetableId, movieId, time);
				list.add(tt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			close(st, rs);
		}
		return list;
	}
	
	public List<TimetableVO> selectAllTimetable (Connection conn) throws SQLException {
		List<TimetableVO> list = new ArrayList<>();
		try {
			st = conn.prepareStatement(MovieProjectSql.selectSchedule);
			rs = st.executeQuery();
			while(rs.next()) {
				String timetableId = rs.getString("timetableId");
				String movieId = rs.getString("movieId");
				String time = rs.getString("time");
				TimetableVO tt = new TimetableVO(timetableId, movieId, time);
				list.add(tt);
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

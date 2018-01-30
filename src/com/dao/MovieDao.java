package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sql.MovieProjectSql;
import com.vo.MovieVO;

public class MovieDao {
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

	public void insert(MovieVO vo, Connection conn) throws Exception {
		try {
			st = conn.prepareStatement(MovieProjectSql.insertMovie);
			st.setString(1, vo.getId());
			st.setString(2, vo.getGenre());
			st.setString(3, vo.getTitle());
			st.setString(4, vo.getDirector());
			st.setInt(5, vo.getGrade());
			st.setDate(6, vo.getReleseDate());
			st.setString(7, vo.getHyperLink());
			result = st.executeUpdate();
			System.out.println(result + "건의 정보가 MOVIE DB에 성공적으로 등록되었습니다.");
		} catch (Exception e) {
			throw e;
		} finally {
			close(st, null);
		}
	}

	public List<MovieVO> selectByGenreAndGrade (MovieVO movie, Connection conn) throws Exception {
		List<MovieVO> list = null;
		try {
			st = conn.prepareStatement(MovieProjectSql.selectByGenreAndGrade);
			st.setString(1, movie.getGenre());
			st.setInt(2, movie.getGrade());
			rs = st.executeQuery();
			list = createMovieList(rs);
		} catch (Exception e) {
			throw e;
		} finally {
			close(st, rs);
		}
		return list;
	}

	public List<MovieVO> selectByGenre (MovieVO movie, Connection conn) throws Exception {
		List<MovieVO> list = null;
		try {
			st = conn.prepareStatement(MovieProjectSql.selectByGenre);
			st.setString(1, movie.getGenre());
			rs = st.executeQuery();
			list = createMovieList(rs);
		} catch (Exception e) {
			throw e;
		} finally {
			close(st, rs);
		}
		return list;
	}
	
	public List<MovieVO> selectByGrade (MovieVO movie, Connection conn) throws Exception {
		List<MovieVO> list = null;
		try {
			st = conn.prepareStatement(MovieProjectSql.selectByGrade);
			st.setInt(1, movie.getGrade());
			rs = st.executeQuery();
			list = createMovieList(rs);
		} catch (Exception e) {
			throw e;
		} finally {
			close(st, rs);
		}
		return list;
	}
	
	public List<MovieVO> selectAllMovie (Connection conn) throws Exception {
		List<MovieVO> list = null;
		try {
			st = conn.prepareStatement(MovieProjectSql.selectAllMovie);
			rs = st.executeQuery();
			list = createMovieList(rs);
		} catch (Exception e) {
			throw e;
		} finally {
			close(st, rs);
		}
		return null;
	}

	public List<MovieVO> createMovieList(ResultSet rs) throws SQLException{
		List<MovieVO> list = new ArrayList<>();
		try {
			while(rs.next()) {
				String id = rs.getString("id");
				String genre = rs.getString("genre");
				String title = rs.getString("title");
				String director = rs.getString("director");
				int grade = rs.getInt("grade");
				Date releseDate = rs.getDate("relasedate");
				String hyperLink = rs.getString("hyperlink");
				MovieVO m = new MovieVO(id, genre, title, director, grade, releseDate, hyperLink);
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return list;
	}

}

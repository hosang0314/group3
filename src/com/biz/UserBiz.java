package com.biz;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import com.dao.MovieDao ;
import com.dao.TimetableDao;
import com.dao.UserDao;
import com.sql.MovieProjectSql;
import com.vo.MovieVO;
import com.vo.TimetableVO;
import com.vo.UserVO;

public class UserBiz{

	UserDao userDao;
	MovieDao movieDao;
	TimetableDao timetableDao;
	protected Connection conn;
	
	public UserBiz() throws ClassNotFoundException, SQLException {
		userDao = new UserDao();
		movieDao = new MovieDao();
		timetableDao = new TimetableDao();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = getConnection();
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Not Found Exception");
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@70.12.111.133:1521:XE";
		String user = "mv";// db이름 바꾸기
		String password = "mv"; //db이름 바꾸기
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
	
	// USER REGISTER
	public void registerUser(String id, int age) throws Exception {
		Connection conn = getConnection();
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(MovieProjectSql.insertUser);
			pst.setString(1, id);
			pst.setInt(2, age);
			int result = pst.executeUpdate();
			System.out.println(result+"건의 데이터가 성공적으로 입력되었음");
			conn.commit();
		} catch (SQLException e) {
			//이미 있는 아이디인 경우  아이디 입력 하라고 출력해라.
			conn.rollback();
			System.out.println("입력 실패");
			throw e;
		}
	}
	
	//id 체크
	public String idCheck(String id) throws Exception {
		Connection conn = getConnection();
		userDao = new UserDao();
		UserVO userVo = null;
		String id2 = null;
		try {
			userVo = userDao.select(id, conn);
			id2 = userVo.getId();
		} catch (Exception e) {
			throw e;
		} finally {
			close(conn);
		}		
		return id2;
		
	}
	
	//장르 선택시 무비 리스트로 출력. 
	public ArrayList<MovieVO> ganreSelectMoives(String ganre) throws Exception{
		Connection conn = getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<MovieVO> movies = new ArrayList<>();
		MovieVO movie = null;
		
		try {
			pst = conn.prepareStatement(MovieProjectSql.selectByGenre);
			pst.setString(1, ganre);
			rs = pst.executeQuery();
			while (rs.next()) {
				 String id = rs.getString("id"); 
				 String genre = rs.getString("genre");
				 String title = rs.getString("title");
				 String director = rs.getString("director");
				 int grade = rs.getInt("grade");
				 Date releseDate = rs.getDate("RELEASEDATE");
				 String hyperLink = rs.getString("hyperLink");
				 movie = new MovieVO(id, genre, title, director, grade, releseDate, hyperLink);
				 movies.add(movie);
							
			}
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			throw e;
		}
		return movies;		
		
	}
	
	//영화와 아이디에 맞는 영화 시간을 출력해라.	
	public ArrayList<TimetableVO> SelectMoiveTime (String movieId) throws Exception {		
		Connection conn = getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<TimetableVO> times = new ArrayList<>();
		TimetableVO time = null;
		
		try {
			pst = conn.prepareStatement(MovieProjectSql.selectSchedule);
			pst.setString(1, movieId);
			rs = pst.executeQuery();
			while (rs.next()) {
				 String timetableId = rs.getString("TIMETABLEID");
				 String mId = rs.getString("movieId");
				 String time1 = rs.getString("time");
				 time = new TimetableVO(timetableId, mId, time1);
				 times.add(time);
			}
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			throw e;
		}return times;
		
	}
	

	

	// SELECT MOVIE LIST BY GENRE AND GRADE
	
	// SELECT TIMETABLE BY MOVIE TITLE
	
	// USERTIMETABLE REGISTER
}

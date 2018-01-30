package com.sql;

public class MovieProjectSql {

	// USER 
	public static String insertUser = 
			"INSERT INTO T_USER VALUES (?,?)"; //ID, GRADE
	public static String selectUserById = 
			"SELECT * FROM T_USER WHERE ID = ?";
	public static String selectAllUser = 
			"SELECT ID FROM T_USER";
	
	// MOVIE
	public static String insertMovie = 
			"INSERT INTO T_MOVIE VALUES(?,?,?,?,?,?,?)";
	public static String selectByGenreAndGrade = 
			"SELECT * FROM T_MOVIE WHERE GENRE = ? AND GRADE < ?";
	public static String selectByGenre = 
			"SELECT * FROM T_MOVIE WHERE GENRE = ?";
	public static String selectByGrade = 
			"SELECT * FROM T_MOVIE WHERE GRADE < ?";
	public static String selectAllMovie = 
			"SELECT * FROM T_MOVIE";
	
	// MOVIETIME
	public static String insertMovieTime = 
			"INSERT INTO T_MOVIETIME VALUES (?,?,?)";
	public static String selectSchedule = 
			"SELECT * FROM T_MOVIETIME WHERE MOVIEID = ?";
	public static String selectAllMovieTime = 
			"SELECT * FROM T_MOVIETIME ";
	
	// USERMOVIETIME
	public static String insertUserAndMovieTime = 
			"INSERT INTO T_USERMOVIETIME VALUES (?,?)";
	public static String selectUserAndMovieTime = 
			"SELECT * FROM T_USERMOVIETIME WHERE USERID = ?";
	
}

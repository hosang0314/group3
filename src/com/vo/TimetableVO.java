package com.vo;

import java.sql.Time;

public class TimetableVO {

	private String timetableId;
	private String movieId;
	private String time;
	
	public TimetableVO() {
		super();
	}
	
	public TimetableVO(String timetableId, String movieId, String time) {
		super();
		this.timetableId = timetableId;
		this.movieId = movieId;
		this.time = time;
	}
	public String getTimetableId() {
		return timetableId;
	}
	public void setTimetableId(String timetableId) {
		this.timetableId = timetableId;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "TimetableVO [timetableId=" + timetableId + ", movieId=" + movieId + ", time=" + time + "]";
	}
	
	
}

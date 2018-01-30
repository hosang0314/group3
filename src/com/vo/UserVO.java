package com.vo;

public class UserVO {
	private String id;
	private int age;
	private MovieVO movie;
	private TimetableVO timetable;
	
	public UserVO() {	}

	public UserVO(String id, int age) {
		super();
		this.id = id;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}	

	public MovieVO getMovie() {
		return movie;
	}

	public void setMovie(MovieVO movie) {
		this.movie = movie;
	}

	public TimetableVO getTimetable() {
		return timetable;
	}

	public void setTimetable(TimetableVO timetable) {
		this.timetable = timetable;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserVO [id=").append(id).append(", age=").append(age).append("]");
		return builder.toString();
	}	
	
	
	
}

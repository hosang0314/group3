package com.vo;

import java.sql.Date;

public class MovieVO {
	
	private String id;
	private String genre;
	private String title;
	private String director;
	private int grade;
	private Date releseDate;
	private String hyperLink;
	
	public MovieVO() { }
	
	public MovieVO(String id, String genre, String title, String director, int grade, Date releseDate,
			String hyperLink) {
		super();
		this.id = id;
		this.genre = genre;
		this.title = title;
		this.director = director;
		this.grade = grade;
		this.releseDate = releseDate;
		this.hyperLink = hyperLink;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Date getReleseDate() {
		return releseDate;
	}

	public void setReleseDate(Date releseDate) {
		this.releseDate = releseDate;
	}

	public String getHyperLink() {
		return hyperLink;
	}

	public void setHyperLink(String hyperLink) {
		this.hyperLink = hyperLink;
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MoveVO [id=").append(id).append(", genre=").append(genre).append(", title=").append(title)
				.append(", director=").append(director).append(", grade=").append(grade).append(", releseDate=")
				.append(releseDate).append(", hyperLink=").append(hyperLink).append("]");
		return builder.toString();
	}
	
	
	
	
	
}

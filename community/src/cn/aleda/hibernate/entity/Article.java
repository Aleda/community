package cn.aleda.hibernate.entity;

import java.sql.Timestamp;

public class Article {
	private int id;
	private int user_id;
	private String username;
	private String title;
	private String content;
	private String content_path;
	private Timestamp create_time;
	public int getId() {
		return id;
	}
	public String getContent_path() {
		return content_path;
	}
	public void setContent_path(String content_path) {
		this.content_path = content_path;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}

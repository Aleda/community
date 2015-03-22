package cn.aleda.hibernate.entity;

import java.sql.Timestamp;

public class Photo {
	private int id;
	private String user_name;
	private String small_path;
	private String photo_name;
	private Timestamp create_time;
	private String file_name;
	private String big_path;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPhoto_name() {
		return photo_name;
	}
	public void setPhoto_name(String photo_name) {
		this.photo_name = photo_name;
	}
	
	public Timestamp getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getSmall_path() {
		return small_path;
	}
	public void setSmall_path(String small_path) {
		this.small_path = small_path;
	}
	public String getBig_path() {
		return big_path;
	}
	public void setBig_path(String big_path) {
		this.big_path = big_path;
	}
	
	
}

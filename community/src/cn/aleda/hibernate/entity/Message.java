package cn.aleda.hibernate.entity;

import java.sql.Timestamp;

public class Message {
	private int id;
	private String send_name;
	private String receive_name;
	private String message;
	private Timestamp create_time;
	private int isread;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSend_name() {
		return send_name;
	}
	public void setSend_name(String send_name) {
		this.send_name = send_name;
	}
	public String getReceive_name() {
		return receive_name;
	}
	public void setReceive_name(String receive_name) {
		this.receive_name = receive_name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Timestamp getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}
	public int isIsread() {
		return isread;
	}
	public void setIsread(int isread) {
		this.isread = isread;
	}
	
}

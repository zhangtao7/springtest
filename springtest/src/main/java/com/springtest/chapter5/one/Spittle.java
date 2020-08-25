package com.springtest.chapter5.one;

import java.util.Date;

public class Spittle {

	private long id;
	private Date time;
	private String msg;
	public Spittle(int id, String msg, Date time) {
		this.id=id;
		this.msg=msg;
		this.time=time;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}

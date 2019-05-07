package com.openid.kim.dao;

import java.util.Date;
import net.spring4.chap11.guest.jdbc.GuestMessageDao;

public class GuestMessage implements GuestMessageDao{
									 
	private String name;
	private String message;
	private Date day;
	private String toUser;
	
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public String messegeInfo() {
		return message;
	}
	

	public String guestMessage() {
		return message;
	}
	

	public String logging() {
		return toString();
	}

	@Override
	public String toString() {
		return "GuestMessage [name=" + name + ", message=" + message + ", day=" + day + ", toUser=" + toUser + "]";
	}
	
	
}

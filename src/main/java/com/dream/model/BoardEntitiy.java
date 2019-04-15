package com.dream.model;

public class BoardEntitiy {

	private String id;
	private String userName;
	private String title;
	private String hashTag;
	private String content;
	private boolean checkNoti;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHashTag() {
		return hashTag;
	}
	public void setHashTag(String hashTag) {
		this.hashTag = hashTag;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public boolean isCheckNoti() {
		return checkNoti;
	}
	public void setCheckNoti(boolean checkNoti) {
		this.checkNoti = checkNoti;
	}
	
	
	
}

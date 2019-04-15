package net.spring4.chap07;

import java.util.Date;

public class EventDAO {

	private Date regdate;
	private Date expdate;
	private String title;
	private String content;
	
	public EventDAO(Date regdate, Date expdate, String title, String content) {
		super();
		this.regdate = regdate;
		this.expdate = expdate;
		this.title = title;
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Date getExpdate() {
		return expdate;
	}

	public void setExpdate(Date expdate) {
		this.expdate = expdate;
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

	@Override
	public String toString() {
		return "EventDAO [regdate=" + regdate.toString() + ", expdate=" + expdate.toString()
		+ ", title=" + title + ", content=" + content + "]";
	}
	
	
	
	
}

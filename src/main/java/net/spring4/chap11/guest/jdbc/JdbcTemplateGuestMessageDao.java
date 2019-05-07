package net.spring4.chap11.guest.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.openid.kim.connect.web.RootController;

public class JdbcTemplateGuestMessageDao implements GuestMessageDao{

	private static final Logger logger = LoggerFactory.getLogger(JdbcTemplateGuestMessageDao.class);
	
	private JdbcTemplate jdbcTemplate;
	
	
	public JdbcTemplateGuestMessageDao(JdbcTemplate jdbcTemplate) {
		
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public String messegeInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String guestMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String logging() {
		// TODO Auto-generated method stub
		return null;
	}

	
}

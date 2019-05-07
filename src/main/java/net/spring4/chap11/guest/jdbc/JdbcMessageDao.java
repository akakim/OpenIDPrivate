package net.spring4.chap11.guest.jdbc;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

//import org.springframework.j
public class JdbcMessageDao implements GuestMessageDao{

	private JdbcTemplate jdbcTemplate;
	
	public JdbcMessageDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
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

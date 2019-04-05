package com.openid.kim;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import net.spring4.chap02.OrderService;

/**
 *  환경 변수를 출력해주는 제공자. 
 * @author dream
 *
 */


public class SessionViewProvider implements EnvironmentAware {

	String userName;
	String passowrd;
	String clientID;
	
	private final Logger logger = LoggerFactory.getLogger(SessionViewProvider.class);
	@Override
	public void setEnvironment(Environment environment) {
		// TODO Auto-generated method stub
		
		String [] profiles = environment.getActiveProfiles();
		
		for( int k = 0; k < profiles.length; k++) {
			logger.info( "get Active Profiles " + profiles[k]);
		}
		

		userName = environment.getProperty("username","not initialize");
		passowrd = environment.getProperty("passowrd","not initialize");
		clientID = environment.getProperty("client_id","not initialize");
		

	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassowrd() {
		return passowrd;
	}
	public void setPassowrd(String passowrd) {
		this.passowrd = passowrd;
	}
	public String getClientID() {
		return clientID;
	}
	public void setClientID(String clientID) {
		this.clientID = clientID;
	}
	
	

}

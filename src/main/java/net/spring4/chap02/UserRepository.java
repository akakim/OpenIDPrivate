package net.spring4.chap02;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import net.spring4.chap01.impl.MavenBuilderRunner;

import java.util.HashMap;


public class UserRepository {

	
	private static final Logger logger = Logger.getLogger(UserRepository.class);
	
	
	private Map<String,User> userMap = new HashMap<>();
	private List<User> users;
	
	
	public UserRepository() {
		super();
		System.out.println(UserRepository.class.getName() + " UserRepository()");
	}
	public UserRepository(List<User> users) {
		super();
		this.users = users;
		
		System.out.println(UserRepository.class.getName() + " UserRepository() get Users... ");
	}


	public User findUserById(String id) {
		return userMap.get(id);
		
	}
	
	
	public void setUser(List<User> users) {
		for( User u : users) {
			userMap.put(u.getId(), u);
		}
	}
	
	
	public List<User> getUser(){
		return users;
	}
	
	public void loggedUserRepository() {
		
		logger.info("loggedUserRepository");
		//System.out.println(  "유저 정보 를 출력함. " +users.get(0).toString());
		users.forEach( i -> 
			System.out.println(  "유저 정보 를 출력함. " +i.toString())
		);
	}
	
	public void addUser(User user) {
		
		this.users.add( user);
	}
	
}

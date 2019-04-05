package net.spring4.chap02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	private final Logger logger = LoggerFactory.getLogger(OrderService.class);
	private UserRepository repo;
	
	@Autowired
	@Qualifier("normal")
	public void setRepository(UserRepository repo) {
		this.repo = repo;
		logger.info(" setRepository is Autowired ");
		
		if( this.repo == null) {
			logger.info(" UserRepository is not initialized ... ");
		}
	}
	
	public void addUser() {
		if( this.repo == null) {
			logger.info(" UserRepository is not Available !!!");
			
		}else {
			repo.addUser( new User( "edward","1234"));
			
			repo.loggedUserRepository();
		}
	}
}

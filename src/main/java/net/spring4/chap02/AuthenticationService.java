package net.spring4.chap02;

import javax.security.auth.message.AuthException;

public class AuthenticationService {
	
	private UserRepository userRepository;
	private AuthFailLogger failLogger;
	
	public AuthInfo authentication(String id,String password) throws AuthException, UserNotFoundException {
		User user = userRepository.findUserById( id );
		if( user == null ) {
			throw new UserNotFoundException();
		}
		
		if(!user.matchPassword(password)) {
			failLogger.insertBadPw( id , password );
			throw new AuthException();
		}
		
		return new AuthInfo(user.getId());
	}
}

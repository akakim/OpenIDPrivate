package net.spring4.chap02;

import org.apache.log4j.Logger;

public class AuthFailLogger {
	
	private static final Logger logger = Logger.getLogger(AuthFailLogger.class);
	
	private int threshold 	= 5 ;
	private int failCounts 	= 0;
	
	public void insertBadPw(String userid, String inputPw) {
		
		logger.info("user ID : " + userid + " " + "input PW " + inputPw + failCounts++);
	
		if (threshold > 0 && failCounts > threshold) {
			notifyTooManyFail();
			failCounts = 0;
		}
		
	}
	
	private void notifyTooManyFail() {
		logger.info("너무 많이 비밀번호를 틀렸습니다. ");
	}
	
	public void setThresholder(int threshold) {
		this.threshold = threshold;
	}
}

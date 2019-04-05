package net.spring4.chap02;

public class User {

	String id;
	String password;
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public User(String id, String password) {
		super();
		this.id = id;
		this.password = password;
		
		
		System.out.println( toString() ); 
	}



	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean matchPassword(String password) {
		if( password == null ) {
			return false;
		}
		
		return this.password.equals( password);
	}
	
	public void changePassword(String oldPassword , String nextPassword ) throws IliegalArgumentException {
		if (! matchPassword(oldPassword) ) {
			password = oldPassword;
			throw new IliegalArgumentException("ilegal password");
		} else { 
			password = nextPassword;
		}
			
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + "]";
	}
	
	
}

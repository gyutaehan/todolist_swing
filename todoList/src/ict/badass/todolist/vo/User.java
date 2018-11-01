package ict.badass.todolist.vo;

public class User {
	String userNo; 
	String email; 
	String userId; 
	String password;
	
	public User() {
		super();
	}
	public User(String email, String userId, String password) {
		super();
		this.email = email;
		this.userId = userId;
		this.password = password;
	}

	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [userNo=" + userNo + ", email=" + email + ", userId=" + userId + ", password=" + password + "]";
	}
	
	


}

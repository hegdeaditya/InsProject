package edu.iiitb.OnlineMovieTicketBooking.model;

public class LoginVo {

	private String username;
	private String password;
	//private String uid;
	//private String fname;
	
	//public String getUid() {
	//	return uid;
	//}
	//public void setUid(String uid) {
	//	this.uid = uid;
	//}
	//public String getFname() {
	//	return fname;
	//}
	//public void setF_name(String fname) {
	//	this.fname = fname;
	//}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public LoginVo(String userName){
		this.username = userName;
	//	this.uid=userid;
	//	this.fname=f_name;
	}
}


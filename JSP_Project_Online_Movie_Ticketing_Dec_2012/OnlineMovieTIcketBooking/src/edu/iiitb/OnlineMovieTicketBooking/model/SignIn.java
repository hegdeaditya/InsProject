package edu.iiitb.OnlineMovieTicketBooking.model;

public class SignIn {
//iSignInID ,sEmail ,sPassword
	
	private int iSignInID;
	private String sEmail;
	private String sPassword;
	public int getiSignInID() {
		return iSignInID;
	}
	public void setiSignInID(int iSignInID) {
		this.iSignInID = iSignInID;
	}
	public String getsEmail() {
		return sEmail;
	}
	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}
	public String getsPassword() {
		return sPassword;
	}
	public void setsPassword(String sPassword) {
		this.sPassword = sPassword;
	}
	
	
}

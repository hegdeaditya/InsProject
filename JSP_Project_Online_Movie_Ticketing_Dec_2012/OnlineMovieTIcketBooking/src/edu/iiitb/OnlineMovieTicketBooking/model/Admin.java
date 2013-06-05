package edu.iiitb.OnlineMovieTicketBooking.model;

public class Admin {
	private int AdminID;
	private String sAdminName ;
	private String sAdminEmail ;
	private String sAdminPassword ;
	private String sAdminPhoneNumber ;
	private String sAdminAddress ;
	
	public static Admin findOne(String selectionModifier) {
        return AdminDAO.findOne(selectionModifier);
	}
	
	public static int update(String  selectionModifier) {
		return AdminDAO.update(selectionModifier);
	}
	public int getAdminID() {
		return AdminID;
	}
	public void setAdminID(int adminID) {
		AdminID = adminID;
	}
	public String getsAdminName() {
		return sAdminName;
	}
	public void setsAdminName(String sAdminName) {
		this.sAdminName = sAdminName;
	}
	public String getsAdminEmail() {
		return sAdminEmail;
	}
	public void setsAdminEmail(String sAdminEmail) {
		this.sAdminEmail = sAdminEmail;
	}
	public String getsAdminPassword() {
		return sAdminPassword;
	}
	public void setsAdminPassword(String sAdminPassword) {
		this.sAdminPassword = sAdminPassword;
	}
	public String getsAdminPhoneNumber() {
		return sAdminPhoneNumber;
	}
	public void setsAdminPhoneNumber(String sAdminPhoneNumber) {
		this.sAdminPhoneNumber = sAdminPhoneNumber;
	}
	public String getsAdminAddress() {
		return sAdminAddress;
	}
	public void setsAdminAddress(String sAdminAddress) {
		this.sAdminAddress = sAdminAddress;
	}
	

}

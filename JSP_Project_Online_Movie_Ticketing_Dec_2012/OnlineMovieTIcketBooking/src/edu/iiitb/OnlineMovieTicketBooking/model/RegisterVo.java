package edu.iiitb.OnlineMovieTicketBooking.model;
public class RegisterVo {


	private String username;
	private String password;
	private String repassword;
	private String fname;
	private String lname;
	private String gender;
	private String email;
	private String telephone;


	public RegisterVo(String username,String password,
			String fname, String lname, String gender, String email, String telephone){
		this.username =	username;
		this.password = password  ;
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
		this.email = email;
		this.telephone = telephone;

	}



	public RegisterVo(String userName, String fName, String lName,
			String phone) {
		this.username = userName;
		this.fname = fName;
		this.lname = lName;
		this.telephone = phone;

	}



	public RegisterVo(String userName) {
		this.username=userName;
	}



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
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}

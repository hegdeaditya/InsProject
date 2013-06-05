package edu.iiitb.OnlineMovieTicketBooking.action;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ChangepasswordAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;
	List<String> cities;
	private String city;
	private String password;
	private String passwordnew;
	private String passwordold;
	private String passwordagain;


	public String getPasswordold() {
		return passwordold;
	}
	public void setPasswordold(String passwordold) {
		this.passwordold = passwordold;
	}
	public String getPasswordagain() {
		return passwordagain;
	}
	public void setPasswordagain(String passwordagain) {
		this.passwordagain = passwordagain;
	}

	public String getPasswordnew() {
		return passwordnew;
	}
	public void setPasswordnew(String passwordnew) {
		this.passwordnew = passwordnew;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) 

	{
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) 

	{
		this.password = password;
	}
	public void setCity(String city) {
		this.city = city;
	}


	public String getCity() {
		return city;
	}

	public List<String> getCities() {
		return cities;
	}


	public void setCities(List<String> cities) {
		this.cities = cities;
	}
	static final String url = "jdbc:mysql://localhost:3306/jspproject";

	public String execute() {


		//	lstUsers=new LoginDao().verifyDetails(username,password);

		if( passwordold.isEmpty() ){
			addActionError("Fields Cant be blank");
			return"error";
		}
		else if(passwordnew.isEmpty()){
			addActionError("Fields Cant be blank ");
			return"error";
		}
		else if(passwordagain.isEmpty()){
			addActionError("Fields Cant be blank ");
			return"error";
		}

		else if(! passwordagain.equals(passwordnew)){

			addActionError("Please enter the same new password in both fields");
			return "error";
		}

		else{
			Map session = ActionContext.getContext().getSession();
			username=session.get("logged-in").toString();
			password=session.get("presentpass").toString();
			System.out.println(username);
			System.out.println(password);
			System.out.println(passwordnew);

			if(passwordold.equals(password)){
				try {
					//session = ActionContext.getContext().getSession();

					Class.forName("com.mysql.jdbc.Driver");
					String query = "Update tsignupsubscriber SET spassword='" + passwordnew + "' where sname='" + username + "' and spassword='" + password + "' ";

					Connection con = DriverManager.getConnection(url, "root", "1234");

					Statement stmt = con.createStatement();
					int result = stmt.executeUpdate(query);
					System.out.println(result);

					con.close();


				} catch (Exception ex) {
					ex.printStackTrace();
				}
				addActionError("Your Password has been changed.Please login with your new password");
				return "success";

			}else{
				addActionError("Please enter the present password correctly");
				return "error";
			}

		}

	}

	public String AdminChangePassword(){

		if( passwordold.isEmpty() ){
			addActionError("Fields Cant be blank");
			return"error";
		}
		else if(passwordnew.isEmpty()){
			addActionError("Fields Cant be blank ");
			return"error";
		}
		else if(passwordagain.isEmpty()){
			addActionError("Fields Cant be blank ");
			return"error";
		}

		else if(! passwordagain.equals(passwordnew)){

			addActionError("Please enter the same new password in both fields");
			return "error";
		}

		else{
			Map session = ActionContext.getContext().getSession();
			String 	adminEmail=session.get("adminEmail").toString();
			password=session.get("adminPassword").toString();
			System.out.println("assword"+password);
			if(passwordold.equals(password)){
				try {
					//session = ActionContext.getContext().getSession();

					Class.forName("com.mysql.jdbc.Driver");
					String query = "Update tAdmin SET sAdminPassword='" + passwordnew + "' where sAdminEmail ='" + adminEmail + "' ";

					Connection con = DriverManager.getConnection(url, "root", "1234");

					Statement stmt = con.createStatement();
					int result = stmt.executeUpdate(query);
					System.out.println(result);

					con.close();


				} catch (Exception ex) {
					ex.printStackTrace();
				}
				addActionMessage("Your Password has been changed.Please login with your new password");
				return "success";

			}else{
				addActionError("Please enter the present password correctly");
				return "error";
			}

		}
	}




	public String SellerChangePassword(){
		if( passwordold.isEmpty() ){
			addActionError("Fields Cant be blank");
			return"error";
		}
		else if(passwordnew.isEmpty()){
			addActionError("Fields Cant be blank ");
			return"error";
		}
		else if(passwordagain.isEmpty()){
			addActionError("Fields Cant be blank ");
			return"error";
		}

		else if(! passwordagain.equals(passwordnew)){

			addActionError("Please enter the same new password in both fields");
			return "error";
		}

		else{
			Map session = ActionContext.getContext().getSession();
			String 	sellerEmail=session.get("sEmail").toString();
			password=session.get("sellerPassword").toString();
			if(passwordold.equals(password)){
				try {
					//session = ActionContext.getContext().getSession();

					Class.forName("com.mysql.jdbc.Driver");
					String query = "Update tSignupSeller SET spassword='" + passwordnew + "' where sEmail  ='" + sellerEmail + "' ";

					Connection con = DriverManager.getConnection(url, "root", "1234");

					Statement stmt = con.createStatement();
					int result = stmt.executeUpdate(query);
					System.out.println(result);

					con.close();


				} catch (Exception ex) {
					ex.printStackTrace();
				}
				addActionMessage("Your Password has been changed.Please login with your new password");
				return "success";

			}else{
				addActionError("Please enter the present password correctly");
				return "error";
			}

		}
	}
}
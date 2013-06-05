package edu.iiitb.OnlineMovieTicketBooking.action;

import com.opensymphony.xwork2.ActionSupport;

public class WebappSupport extends ActionSupport {
	/**
	 * Base Action class for the package.
	 */

	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

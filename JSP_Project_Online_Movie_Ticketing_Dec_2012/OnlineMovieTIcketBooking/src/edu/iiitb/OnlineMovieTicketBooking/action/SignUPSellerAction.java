package edu.iiitb.OnlineMovieTicketBooking.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.OnlineMovieTicketBooking.model.Admin;
import edu.iiitb.OnlineMovieTicketBooking.model.SignUpSeller;
import edu.iiitb.OnlineMovieTicketBooking.model.SignUpSubscriber;

public class SignUPSellerAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String name;
	private String email;
	private String password1;
	private String password2;
	private String phoneNumber;
	private String address;
	private SignUpSeller signUpSeller= new SignUpSeller();
	private int iSellerID;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String execute() throws Exception {

		signUpSeller.setsEmail(email.toString());
		signUpSeller.setsName(name.toString());
		signUpSeller.setsPassword(password1.toString());
		signUpSeller.setsPhoneNumber(phoneNumber.toString());
		signUpSeller.setsAddress(address.toString());
		signUpSeller.setiRegistrationStatus(-1);
		iSellerID= signUpSeller.insert();
		System.out.println("i am in signupseller1");
		if(iSellerID!=0){
			System.out.println("i am in signupseller2");
			return SUCCESS;
		}
		else{
			System.out.println("i am in signupseller3");
			return ERROR;
		}
			
	}




	public void validate() {
		try{
			if ( name.length() == 0 ){	

				addFieldError( "name", "name  is required." );
			}
			if ( email.length() == 0 ){	

				addFieldError( "email", "email  is required." );
			}

			else {

				try {

					ArrayList<SignUpSeller> signUpSeller= new ArrayList<SignUpSeller>();
					ArrayList<SignUpSubscriber> signUpSubscriber= new ArrayList<SignUpSubscriber>();
					Admin adminCandidate=null;
					
					
					String selectionModifier="where sEmail = '"+email.toString()+"';";
					signUpSeller=SignUpSeller.find(selectionModifier);
					
					selectionModifier="where sEmail = '"+email.toString()+"';";
					signUpSubscriber=SignUpSubscriber.find(selectionModifier);
					
					
					selectionModifier=" where sAdminEmail = '"+email.toString()+"';";
					adminCandidate=Admin.findOne(selectionModifier);
					
					
					
					if((!signUpSeller.isEmpty()) || (!signUpSubscriber.isEmpty()) || (adminCandidate!=null)){
						addFieldError( "email", "Email already in use.Please choose some other email" );

					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
			}

			if ( password1.length() == 0 ){	

				addFieldError( "password1", "Password1 is required." );

			}
			if ( password2.length() == 0 ){	

				addFieldError( "password2", "Password2 is required." );

			}
			if(password1.length() != 0 && password2.length() != 0){
				if(!password1.equals(password2)){
					addFieldError( "password2", "Password2 is not same as passoword1." );

				}
			}


			if ( phoneNumber.length() == 0 ){	

				addFieldError( "phoneNumber", "phoneNumber is required." );

			}
			if ( address.length() == 0 ){	

				addFieldError( "address", "address is required." );

			}


		}catch(Exception e){

		}
	}
}

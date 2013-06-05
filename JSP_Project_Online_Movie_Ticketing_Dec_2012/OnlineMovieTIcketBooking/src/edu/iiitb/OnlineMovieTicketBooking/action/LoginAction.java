package edu.iiitb.OnlineMovieTicketBooking.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.OnlineMovieTicketBooking.model.Theatre;

import edu.iiitb.OnlineMovieTicketBooking.service.LoginService;
public class LoginAction extends ActionSupport implements SessionAware  {

	private static final long serialVersionUID = 1L;
	private String iSignInID="" ;
	private String Email ;
	private String Password;
	private String city;
	private List lstcities;
	private ArrayList<String> cityNames;

	private String commandButton;
	private Map<String, Object> session;
	private List<String> cities;

	public List<String> getCities() {
		return cities;
	}
	public void setCities(List<String> cities) {
		this.cities = cities;
	}
	private ArrayList<Theatre> theatres= new ArrayList<Theatre>(); 


	public String getiSignInID() {
		return iSignInID;
	}
	public void setiSignInID(String iSignInID) {
		this.iSignInID = iSignInID;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public List getLstcities() {
		return lstcities;
	}
	public void setLstcities(List lstcities) {
		this.lstcities = lstcities;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getCommandButton() {
		return commandButton;
	}
	public void setCommandButton(String commandButton) {
		this.commandButton = commandButton;
	}

	public ArrayList<Theatre> getTheatres() {
		return theatres;
	}
	public void setTheatres(ArrayList<Theatre> theatres) {
		this.theatres = theatres;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String execute() throws Exception {
		int iSellerID ,iSubscriberID,iStatus=1,iAdminID;

		LoginService login=new LoginService();
		System.out.println("email="+this.getEmail());

		String usertype =login.AuthenticateUser(Email, Password);

		System.out.println("i am 3 usertype="+usertype);

		if (usertype!=null) {

			//System.out.println("i am 4");

			session = ActionContext.getContext().getSession();

			if(usertype.equalsIgnoreCase("seller")){
				iSellerID=login.getSignUpSellerID(Email,Password);
				iStatus=login.getRegstatusidOfSeller(Email,Password);
				if(iStatus==-1){
					addActionError(getText("Your Registration is Pending for Approval please contact Admin!"));
					return "waitingForApproval";
				}
				if(iStatus==-2){
					addActionError(getText("Your Registration is Deactivated please contact Admin!"));
					return "registrationDeactivated";
				}
				session.put("usertype", usertype);
				session.put("login","true");
				session.put("sEmail",Email);
				session.put("sellerPassword",Password);


				this.setTheatres(Theatre.find(" where iSellerID="+iSellerID));
				session.put("iSellerID",iSellerID);
				//		System.out.println("theatre1="+theatres.get(1).getsName());
				//System.out.println("theatre1="+theatres.get(0).getsName());
				session.put("theatres", theatres);	
				String sr= (String) session.get("sEmail");

				return "seller";
			}
			else if(usertype.equalsIgnoreCase("admin")){
				session.put("login","true");
				session.put("adminEmail",Email);
				session.put("adminPassword",Password);
				System.out.println("i am in admin blcok of login action");
				iAdminID=login.getAdminid(Email, Password);
				//session.put("identityOfAdmin",iAdminID);
				return "admin" ;
			}

			else if(usertype.equalsIgnoreCase("subscriber")){
				session.put("login","true");
				session.put("subscriberEmail",Email);
				session.put("presentpass",Password);
				iSubscriberID=login.getSignUpSubscriberID(Email, Password);
				iStatus=login.getRegstatusidOfSubscriber(Email,Password);
				System.out.println("iStatus="+iStatus);
				if(iStatus==-2){
					System.out.println("iStatus="+iStatus);
					addActionError(getText("Your Registration is Deactivated please contact Admin!"));
					return "registrationDeactivated";
				}
				session.put("iSubscriberID", iSubscriberID);
				String subscriberName=login.getSubscriberName(Email, Password);
				session.put("logged-in",subscriberName);
				cities = new ArrayList<String>();

				lstcities=new citiesAction().lists();
				cityNames=citiesAction.getCityNames();
				session.put("cityNamesArrayList",cityNames );
				if(cityNames==null){
					
					//addActionMessage(getText("No Cities added!! Please visit us sometime later:)"));
					return "subscriber";
				}
				
			
					cities.addAll(lstcities);
					city = "Select a city";
					return "subscriber";
			
				
			}


			else return ERROR;
		}
		else {

			addActionError(getText("Incorrect user id and / or password!"));
			return ERROR;
		}
	}


	public String setParametersForSubscriberHome(){

		cities = new ArrayList<String>();

		lstcities=new citiesAction().lists();
		cities.addAll(lstcities);
		city = "Select a city";



		return SUCCESS;
	}

	public void validate() {
		try{
			if ( Password.length() == 0 ){	

				addFieldError( "Password", "Password is required." );

			}
			if ( Email.length() == 0 ){	

				addFieldError( "Email", "sEmail  is required." );


			}

			if(Password.length() != 0 &&  Email.length() != 0)  {

				try {
					LoginService login=new LoginService();;
					String usertype =login.AuthenticateUser(Email, Password);
					if(usertype==null){
						addFieldError( "Email", "Email/Password is incorrect." );
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}


		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub

	}


}
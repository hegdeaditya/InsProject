package edu.iiitb.OnlineMovieTicketBooking.action;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.OnlineMovieTicketBooking.service.LoginDao;

public class subscriberLoginAction extends ActionSupport{
	

    private String username;
    List<String> cities;
    private String city;
 //   private String user_id;
 //   private String fname;
    
 //   public String getFname() {
//		return fname;
//	}


//	public void setFname(String fname) {
//		this.fname = fname;
//	}


//	public String getUser_id() {
//		return user_id;
//	}


//	public void setUser_id(String user_id) {
//		this.user_id = user_id;
//	}


	public List getLstUsers() {
		return lstUsers;
	}
	
	private String password;
	
    private List lstUsers;
    private List lstcities;

	public List getLstcities() {
		return lstcities;
	}
	public void setLstcities(List lstcities) {
		this.lstcities = lstcities;
	}
	public void setLstUsers(List lstUsers) {
		this.lstUsers = lstUsers;
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
	
    public String execute() {
 
    	lstUsers=new LoginDao().verifyDetails(username,password);
    	
         	if(lstUsers.isEmpty()){
    		addActionError(getText("error.login"));
    		return"error";
    	}
    	
    	
    	
  //      if (this.username.equals("a2")
   //             && this.password.equals("a2")) {
   //         return "success";
   //     } else {
  //          addActionError(getText("error.login"));
   //         return "error";
  //      }
        
        
        
    	else{
    		
    		Map session = ActionContext.getContext().getSession();
    		session.put("logged-in", username);
    		session.put("presentpass",password);
    		
    		
    		int iSubscriberID = new LoginDao().fetchsubscrid(username,password);
    		session.put("iSubscriberID",iSubscriberID);
    		
    	
    		//session.put("uid", user_id);
    		cities = new ArrayList<String>();
        	//call database and populate cities here
    		lstcities=new citiesAction().lists();
        	cities.addAll(lstcities);
        	city = "Select a city";
    		
    		return "success";
    	}
    }
    
    
    /*public String logout() throws Exception{
    	Map session = ActionContext.getContext

().getSession();
		session.remove("logged-in");
		return "success";
    }*/
 
   
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

}

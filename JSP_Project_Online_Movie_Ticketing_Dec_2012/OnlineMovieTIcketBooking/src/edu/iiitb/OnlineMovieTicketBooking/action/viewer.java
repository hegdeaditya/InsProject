package edu.iiitb.OnlineMovieTicketBooking.action;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class viewer extends ActionSupport{
	

    private String username;
    List<String> cities;
    private String city;
 

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
    	Map<String, Object> session=ActionContext.getContext().getSession();
    	ArrayList<String> cityNames;
    	cities = new ArrayList<String>();

		lstcities=new citiesAction().lists();
		cityNames=citiesAction.getCityNames();
		session.put("cityNamesArrayList",cityNames );
		if(cityNames==null){
			
			//addActionMessage(getText("No Cities added!! Please visit us sometime later:)"));
			return "success";
		}
		
	
			cities.addAll(lstcities);
			city = "Select a city";
			return "success";
    	
    		
    	
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

}

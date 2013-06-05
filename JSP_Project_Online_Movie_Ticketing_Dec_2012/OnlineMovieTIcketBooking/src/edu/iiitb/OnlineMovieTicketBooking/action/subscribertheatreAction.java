package edu.iiitb.OnlineMovieTicketBooking.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.OnlineMovieTicketBooking.model.Theatre;

public class subscribertheatreAction extends ActionSupport{

	private String city;
	private String theatre;
	private String movie;
	//private String movieSel;
	private String moviedate;
	private String dayofweek;

	java.sql.Date sqlDate;
	private ArrayList<String> cities;
	private ArrayList<String> theaters;
	private ArrayList<Theatre> th;

	private List lsttheatres;




	public List getLsttheatres() {
		return lsttheatres;
	}

	public void setLsttheatres(List lsttheatres) {
		this.lsttheatres = lsttheatres;
	}

	public ArrayList<String> getCities() {
		return cities;
	}

	public void setCities(ArrayList<String> cities) {
		this.cities = cities;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTheatre() {
		return theatre;
	}

	public void setTheatre(String theatre) {
		this.theatre = theatre;
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public String getMoviedate() {
		return moviedate;
	}

	public void setMoviedate(String moviedate) {
		this.moviedate = moviedate;
	}

	public String getDayofweek() {
		return dayofweek;
	}

	public void setDayofweek(String dayofweek) {
		this.dayofweek = dayofweek;
	}

	public String execute() {
		Map<String, Object> session=ActionContext.getContext().getSession();
		
		if(city.isEmpty()){
			session.put("cityNameSelected", city);	
		
		}
		
		lsttheatres=new theatresAction().selecttheatres(city);

			theaters = new ArrayList<String>();
    		theaters.addAll(lsttheatres);
    		theatre = "theatre";
    		//Map session= ActionContext.getContext().getSession();
    		session.put("sCity",city);
    		session.put("namesOfTheater",theaters);
    		return "success";
		
		        	
		        	
		        

	}

	public void setTheaters(ArrayList<String> theaters) {
		this.theaters = theaters;
	}

	public ArrayList<String> getTheaters() {
		return theaters;
	}

}

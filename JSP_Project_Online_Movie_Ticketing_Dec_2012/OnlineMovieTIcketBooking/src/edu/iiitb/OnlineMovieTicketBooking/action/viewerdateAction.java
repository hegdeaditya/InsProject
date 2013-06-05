package edu.iiitb.OnlineMovieTicketBooking.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class viewerdateAction {

	private String city;
	
	public List getLstclass() {
		return lstclass;
	}

	public void setLstclass(List lstclass) {
		this.lstclass = lstclass;
	}

	private String theatre;
	private String movie;
	private String classy;
	//private String movieSel;
	private String moviedate;
	private String dayofweek;
	private String date;
	private String theatreclass;
	private List lstclass;
	private List lstdate;
	
	public String getCity() {
		return city;
	}

	public List getLstdate() {
		return lstdate;
	}

	public void setLstdate(List lstdate) {
		this.lstdate = lstdate;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTheatreclass() {
		return theatreclass;
	}

	public void setTheatreclass(String theatreclass) {
		this.theatreclass = theatreclass;
	}

	java.sql.Date sqlDate;
//	private ArrayList<String> cities;
	private ArrayList<String> theaters;
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public ArrayList<String> getDates() {
		return dates;
	}

	public void setDates(ArrayList<String> dates) {
		this.dates = dates;
	}

	private ArrayList<String> movies;
	private ArrayList<String> classes;
	private ArrayList<String> dates;
//	public ArrayList<String> getCities() {
//		return cities;
//	}

//	public void setCities(ArrayList<String> cities) {
//		this.cities = cities;
//	}

//	public String getCity() {
//		return city;
//	}

//	public void setCity(String city) {
//		this.city = city;
//	}

	public ArrayList<String> getClasses() {
		return classes;
	}

	public void setClasses(ArrayList<String> classes) {
		this.classes = classes;
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
	//	theatre = this.getTheatre();
	//	city = this.getCity();
	//	System.out.println(city);
	//	System.out.println(movie);
	//	System.out.println(theatre);
	//	String classSel;
	//	if(theatreclass.equals("1"))
	//		{
	//			classSel = "Gold";
	//			System.out.println(classSel);	
	//		}
	//		if(theatreclass.equals("2"))
	//		{
	//			classSel = "Silver";
	//			System.out.println(classSel);	
	//		}
	//		if(theatreclass.equals("3"))
	//		{
	//			classSel = "Economy";
	//			System.out.println(classSel);	
	//		

		classy=this.getClassy();
		Map session = ActionContext.getContext().getSession();
		session.put("classy",classy);
		session.put("sClass",classy);
		movie=session.get("moviessession").toString();
		System.out.println(movie);
		lstdate=new datesAction().selectdates(classy,movie);
		System.out.println(lstdate);
		//get the theaters names from the database
		dates = new ArrayList<String>();
		dates.addAll(lstdate);
		date = "date";
		return "success";

	}

	public String getClassy() {
		return classy;
	}

	public void setClassy(String classy) {
		this.classy = classy;
	}

	public ArrayList<String> getMovies() {
		return movies;
	}

	public void setMovies(ArrayList<String> movies) {
		this.movies = movies;
	}

	public void setTheaters(ArrayList<String> theaters) {
		this.theaters = theaters;
	}

	public ArrayList<String> getTheaters() {
		return theaters;
	}

}

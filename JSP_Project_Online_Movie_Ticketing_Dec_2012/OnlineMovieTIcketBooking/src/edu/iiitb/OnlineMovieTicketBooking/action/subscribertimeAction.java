package edu.iiitb.OnlineMovieTicketBooking.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class subscribertimeAction extends ActionSupport{

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
	private String time;
	private String theatreclass;
	private List lstclass;
	private List lstdate;
	
	private List lsttime;
	public List getLsttime() {
		return lsttime;
	}

	public void setLsttime(List lsttime) {
		this.lsttime = lsttime;
	}

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
	private ArrayList<String> times;
	
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
		
	//	classy=this.getClassy();
	//	movie=this.getMovie();
	//	lstdate=new dates().selectdates(classy,movie);
	//	System.out.println(lstdate);
	//	//get the theaters names from the database
	//	dates = new ArrayList<String>();
	//	dates.addAll(lstdate);
	//	date = "date";

		date=this.getDate();
		Map session = ActionContext.getContext().getSession();
		classy=session.get("classy").toString();
		movie=session.get("moviessession").toString();
		
		
		session.put("dDate",date);
		
		
		System.out.println(movie);

lsttime=new timesAction().selecttimes(classy,movie,date);
		
		
		
			System.out.println(lstdate);
			//get the theaters names from the database
			times = new ArrayList<String>();
			times.addAll(lsttime);
			time = "time";
					
			
			
		String sname = session.get("logged-in").toString();
		//	String spassword = session.get("presentpass").toString();
			String sCity=session.get("sCity").toString();
			String sTheatre=session.get("sTheatre").toString();
			String sMovie=session.get("sMovie").toString();
			String sClass=session.get("sClass").toString();
			String dDate=session.get("dDate").toString();
			//String tTime=session.get("tTime").toString();
			//System.out.println(sname);
			//System.out.println(spassword);
			System.out.println(sCity);
	    	System.out.println(sTheatre);
			System.out.println(sMovie);
			System.out.println(sClass);
			System.out.println(dDate);
			
			
			return "success";
		
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public ArrayList<String> getTimes() {
		return times;
	}

	public void setTimes(ArrayList<String> times) {
		this.times = times;
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

package edu.iiitb.OnlineMovieTicketBooking.action;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import edu.iiitb.OnlineMovieTicketBooking.model.MovieTimings;
import edu.iiitb.OnlineMovieTicketBooking.service.testService;

public class Ctm6 {

	private String city;
	ArrayList<String> seats=new ArrayList<String>();
	
	public ArrayList<String> getSeats() {
		return seats;
	}

	public void setSeats(ArrayList<String> seats) {
		this.seats = seats;
	}

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
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
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
		time=this.getTime();
		
		String seatsLeftOfClassTypeSelected;
		int classType;
		Map session = ActionContext.getContext().getSession();
//		classy=session.get("classy").toString();
//		movie=session.get("moviessession").toString();
		
		session.put("tTime",time);
		
		String sname = session.get("logged-in").toString();
//		String spassword = session.get("presentpass").toString();
		String sCity=session.get("sCity").toString();
		String sTheatre=session.get("sTheatre").toString();
		String sMovie=session.get("sMovie").toString();
		String sClass=session.get("sClass").toString();
		String dDate=(String) session.get("dDate");
		
		//CONVERSION OF STRING TYPE DATE INTO java.sql.date
		java.sql.Date realDate = java.sql.Date.valueOf(dDate);
		System.out.println("Real Date:  "+realDate);
		
		session.put("realDate", realDate);
		
		//FETCH THE CURRENT DATE
		try {
	    	SimpleDateFormat oSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");      
			java.util.Date dateWithoutTime = oSimpleDateFormat.parse(oSimpleDateFormat.format(new java.util.Date()));
			
			long dateConversion;
			dateConversion = dateWithoutTime.getTime();
			java.sql.Date dCurrentDate= new java.sql.Date(dateConversion);
			
			session.put("dCurrentDate", dCurrentDate);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		
		//java.sql.Date bookedShowDate = (Date) session.get("dDate");
		
		//System.out.println("Date in the Date format: ... " + bookedShowDate);
		
		
//		String tTime=session.get("tTime").toString();
		System.out.println(session.get("logged-in"));
		System.out.println(session.get("presentpass"));
		System.out.println(sCity);
    	System.out.println(sTheatre);
		System.out.println(sMovie);
		System.out.println(sClass);
		System.out.println(dDate);
//		System.out.println(tTime);
		int iMovieID=(Integer) session.get("iMovieID");
		MovieTimings movieTimings;
		System.out.println("imovieid"+iMovieID+"time="+time);
		String selectionModifier=" where iMovieID="+iMovieID+" and dDate='"+dDate+"' and tTime='"+time+"'";
		
		movieTimings=MovieTimings.findOne(selectionModifier);
		session.put("iMovieTimingID", movieTimings.getiMovieTimingID());
		
		

		//CREATE OBJECT OF RESPECTIVE SERVICE CLASS
		testService otestService = new testService();
		
		//CHECK WHICH CLASS TYPE USER WISHES
		if( session.get( "sClass" ).toString().equalsIgnoreCase("Gold" ))
			classType = 1;
		else if( session.get( "sClass" ).toString().equalsIgnoreCase("silver" ))
			classType = 2;
		else if( session.get( "sClass" ).toString().equalsIgnoreCase("economy" ))
			classType = 3;
		else 
			classType = 0;
		
		//GET THE AVAILABLE SEATS
		seatsLeftOfClassTypeSelected = otestService.getSeatsAvailable((Integer) session.get("iMovieTimingID"), classType);
		
		//CHECK IF SEATS ARE AVAILABLE OR NOT (SEATS LEFT COLUMN IS NOT NULL)
				if( seatsLeftOfClassTypeSelected != null ){
					
					//GET THE NUMBER OF SEATS AVAILABLE
					//GET THE TOTAL NUMBER OF SEATS AVAILABLE
					
					//PUT EVERYTHING IN SESSION VARIABLES
					session.put("seatsAvailable", seatsLeftOfClassTypeSelected);
					
					//---SEE THE SPLITTED STRING IN ARRAY FORM: (DONE IN reserveSeatAction.java)---
					String columns[] = seatsLeftOfClassTypeSelected.split(";");
					//int i;
					
					for( int i = 0 ; i < columns.length ; i++){
						seats.add(columns[i]);
					}
					
					session.put("seats", seats);
					
					return "success";
				}
				else{
					return "error";
				}
	}



}

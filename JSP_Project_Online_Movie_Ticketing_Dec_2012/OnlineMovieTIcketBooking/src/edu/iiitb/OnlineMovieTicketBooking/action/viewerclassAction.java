package edu.iiitb.OnlineMovieTicketBooking.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import edu.iiitb.OnlineMovieTicketBooking.model.Movies;
import edu.iiitb.OnlineMovieTicketBooking.model.Theatre;

public class viewerclassAction {

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
	private String theatreclass;
	private List lstclass;
	public String getCity() {
		return city;
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
	private ArrayList<String> movies;
	private ArrayList<String> classes;



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
	

		Map session = ActionContext.getContext().getSession();
		movie=this.getMovie();
		int theaterID,iMovieID;
		
		String city=(String)session.get("sCity");
		String theatreName=(String) session.get("sTheatre");
		
		System.out.println("movie name="+movie+"theatreName="+theatreName+"city="+city);
	
		Theatre theatre= new Theatre();
		String selectionModifier=" where sCity='"+city+"' and sName='"+theatreName+"'";
		
		theatre=Theatre.findOne(selectionModifier);
		String selectionModifier1=" where iTheaterID="+theatre.getiTheatreID()+" and sName='"+movie+"';";
		Movies movie2=Movies.findOne(selectionModifier1);
		
		session.put("iTheaterID", theatre.getiTheatreID());
		session.put("iMovieID", movie2.getImovieID());
		
		lstclass=new classesAction().selectclass(movie, theatre.getiTheatreID(),movie2.getImovieID());
		System.out.println(lstclass);
		//get the theaters names from the database
		classes = new ArrayList<String>();
		classes.addAll(lstclass);
		classy = "classy";
		
		session.put("moviessession",movie);
		session.put("sMovie",movie);
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

package edu.iiitb.OnlineMovieTicketBooking.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class viewermovieAction extends ActionSupport{

//	private String city;
	private String theatre;
	private String movie;
	//private String movieSel;
	private String moviedate;
	private String dayofweek;

	java.sql.Date sqlDate;
//	private ArrayList<String> cities;
	private ArrayList<String> theaters;
	private ArrayList<String> movies;
	
	private List lstmovies;
	



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
	public List getLstmovies() {
		return lstmovies;
	}

	public void setLstmovies(List lstmovies) {
		this.lstmovies = lstmovies;
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
	@SuppressWarnings("unchecked")
	public String execute() {
	
		Map session = ActionContext.getContext().getSession();
		String city=(String)session.get("sCity");
		theatre = this.getTheatre();
		lstmovies=null;
		lstmovies=(List<String>)moviesAction.selectmovies(theatre,city);//new moviesAction().selectmovies(theatre,city);
		System.out.println(lstmovies);
	
		
			movies = new ArrayList<String>();
			//movies.addAll(lstmovies);
			session.put("sTheatre",theatre);
			session.put("moviesnames",lstmovies);
			movie = "movie";
			return SUCCESS;
		

	}



}

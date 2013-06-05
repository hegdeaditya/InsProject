package edu.iiitb.OnlineMovieTicketBooking.action;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.OnlineMovieTicketBooking.model.Movies;
import edu.iiitb.OnlineMovieTicketBooking.model.MoviesDAO;

public class ListMoviesAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int theatreID;
	private ArrayList<Movies> movies;
	Map<String,Object> session;
	
	public int getTheatreID() {
		return theatreID;
	}


	public void setTheatreID(int theatreID) {
		this.theatreID = theatreID;
	}


	public ArrayList<Movies> getMovies() {
		return movies;
	}


	public void setMovies(ArrayList<Movies> movies) {
		this.movies = movies;
	}


	public String execute() throws Exception {
		 session= ActionContext.getContext().getSession();
		String selectionModifier=" where iTheaterID="+this.getTheatreID()+";";
		movies=MoviesDAO.find(selectionModifier);
		session.put("theatreID", this.getTheatreID());
		if(movies.size()==0){
			
			return "noMoviesAvailable";
		}
		
		System.out.println();
		
		return SUCCESS;
		
		}
	}
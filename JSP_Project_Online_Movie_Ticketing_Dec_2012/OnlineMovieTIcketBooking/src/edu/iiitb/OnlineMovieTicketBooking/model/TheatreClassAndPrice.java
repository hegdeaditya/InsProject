package edu.iiitb.OnlineMovieTicketBooking.model;

import java.util.ArrayList;

public class TheatreClassAndPrice {
	
	//sClass  ,iPrice  ,iNumberOfSeatesPerClass ,iTheaterID 
	private int iTheatreClassID;
	private String sClass;
	private int iPrice;
	private int iNimberOfSeatsPerClass;
	private int iTheatreID;
	
	public int getiTheatreClassID() {
		return iTheatreClassID;
	}
	public void setiTheatreClassID(int iTheatreClassID) {
		this.iTheatreClassID = iTheatreClassID;
	}
	public String getsClass() {
		return sClass;
	}
	public void setsClass(String sClass) {
		this.sClass = sClass;
	}
	public int getiPrice() {
		return iPrice;
	}
	public void setiPrice(int iPrice) {
		this.iPrice = iPrice;
	}
	public int getiNimberOfSeatsPerClass() {
		return iNimberOfSeatsPerClass;
	}
	public void setiNimberOfSeatsPerClass(int iNimberOfSeatsPerClass) {
		this.iNimberOfSeatsPerClass = iNimberOfSeatsPerClass;
	}
	public int getiTheatreID() {
		return iTheatreID;
	}
	public void setiTheatreID(int iTheatreID) {
		this.iTheatreID = iTheatreID;
	}
	
	
	public static ArrayList<TheatreClassAndPrice> find(String selectionModifier) {
		return TheatreClassAndPriceDAO.find(selectionModifier);
	}

	
}

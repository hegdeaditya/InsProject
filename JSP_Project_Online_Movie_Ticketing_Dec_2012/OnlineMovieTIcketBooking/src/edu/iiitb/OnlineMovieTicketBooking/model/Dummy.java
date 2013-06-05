package edu.iiitb.OnlineMovieTicketBooking.model;

import java.sql.Time;
import java.util.Date;

public class Dummy {

	private int iDummyID;
	private int iSubscriberID;
	private String sCity;
	private String sTheatre;
	private String sMovie;
	private String sClass;
	private Date dDate;
	private Time tTime;
	
	
	public int getiDummyID() {
		return iDummyID;
	}
	public void setiDummyID(int iDummyID) {
		this.iDummyID = iDummyID;
	}
	public int getiSubscriberID() {
		return iSubscriberID;
	}
	public void setiSubscriberID(int iSubscriberID) {
		this.iSubscriberID = iSubscriberID;
	}
	public String getsCity() {
		return sCity;
	}
	public void setsCity(String sCity) {
		this.sCity = sCity;
	}
	public String getsTheatre() {
		return sTheatre;
	}
	public void setsTheatre(String sTheatre) {
		this.sTheatre = sTheatre;
	}
	public String getsMovie() {
		return sMovie;
	}
	public void setsMovie(String sMovie) {
		this.sMovie = sMovie;
	}
	public String getsClass() {
		return sClass;
	}
	public void setsClass(String sClass) {
		this.sClass = sClass;
	}
	public Date getdDate() {
		return dDate;
	}
	public void setdDate(Date dDate) {
		this.dDate = dDate;
	}
	public Time gettTime() {
		return tTime;
	}
	public void settTime(Time tTime) {
		this.tTime = tTime;
	}
	
	
}

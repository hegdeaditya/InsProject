package edu.iiitb.OnlineMovieTicketBooking.model;

import java.security.Timestamp;
import java.util.Date;

public class SeatBooked {

	private int iSeatBookedID;
	private int iSeatNumber;
	private Timestamp dShowTime;
	private int iTicketID;
	public int getiSeatBookedID() {
		return iSeatBookedID;
	}
	public void setiSeatBookedID(int iSeatBookedID) {
		this.iSeatBookedID = iSeatBookedID;
	}
	public int getiSeatNumber() {
		return iSeatNumber;
	}
	public void setiSeatNumber(int iSeatNumber) {
		this.iSeatNumber = iSeatNumber;
	}
	public Timestamp getdShowTime() {
		return dShowTime;
	}
	public void setdShowTime(Timestamp dShowTime) {
		this.dShowTime = dShowTime;
	}
	public int getiTicketID() {
		return iTicketID;
	}
	public void setiTicketID(int iTicketID) {
		this.iTicketID = iTicketID;
	}
	
	
	
}

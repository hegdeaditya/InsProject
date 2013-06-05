package edu.iiitb.OnlineMovieTicketBooking.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class Ticket {

	private int iTicketID;
	private int iAmountPaid;
	private int iNumberOfTicketsBought;
	private String sClass;
	private String sSeatNumber;
	private java.sql.Date dDate;
	private String sTime;
	private int iSubscriberID;
	private int iMovieTimingID;
	public int getiTicketID() {
		return iTicketID;
	}
	public void setiTicketID(int iTicketID) {
		this.iTicketID = iTicketID;
	}
	public int getiAmountPaid() {
		return iAmountPaid;
	}
	public String getsSeatNumber() {
		return sSeatNumber;
	}
	public void setsSeatNumber(String sSeatNumber) {
		this.sSeatNumber = sSeatNumber;
	}
	public String getsClass() {
		return sClass;
	}
	public void setsClass(String sClass) {
		this.sClass = sClass;
	}
	public java.sql.Date getdDate() {
		return dDate;
	}
	public void setdDate(java.sql.Date dDate) {
		this.dDate = dDate;
	}
	public String getsTime() {
		return sTime;
	}
	public void setsTime(String sTime) {
		this.sTime = sTime;
	}
	public void setiAmountPaid(int iAmountPaid) {
		this.iAmountPaid = iAmountPaid;
	}
	public int getiNumberOfTicketsBought() {
		return iNumberOfTicketsBought;
	}
	public void setiNumberOfTicketsBought(int iNumberOfTicketsBought) {
		this.iNumberOfTicketsBought = iNumberOfTicketsBought;
	}
	public int getiSubscriberID() {
		return iSubscriberID;
	}
	public void setiSubscriberID(int iSubscriberID) {
		this.iSubscriberID = iSubscriberID;
	}
	public int getiMovieTimingID() {
		return iMovieTimingID;
	}
	public void setiMovieTimingID(int iMovieTimingID) {
		this.iMovieTimingID = iMovieTimingID;
	}
	
	
	
	
	//FUNCTION CALL WHICH ARE DEFINED IN TicketDAO.java
	
	public static ArrayList<Ticket> find(String selectionModifier) {
		return TicketDAO.find(selectionModifier);
	}
	
	
}

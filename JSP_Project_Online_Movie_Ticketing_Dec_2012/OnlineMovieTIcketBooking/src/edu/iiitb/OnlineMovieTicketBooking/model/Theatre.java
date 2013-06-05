package edu.iiitb.OnlineMovieTicketBooking.model;

import java.io.Serializable;
import java.util.ArrayList;


public class Theatre implements Serializable{
	//iTheatreID ,sName ,sPhoneNumber ,sAddress ,sCity ,sState ,iNumberOfSeates, iSellerID 

	private int iTheatreID;
	private String  sName;
	private String  sPhoneNumber ;
	private String sAddress ;
	private String sCity ;
	private String sState ;
	private int iNumberOfSeates;
	private int iSellerID;
	
	public int update() {
		return TheatreDAO.update(this);
	}

	public int insert() {
		return TheatreDAO.insert(this);
	}

	public static ArrayList<Theatre> find(String selectionModifier) {
		return TheatreDAO.find(selectionModifier);
	}
	
	

	public static Theatre findOne(String selectionModifier) {
        return TheatreDAO.findOne(selectionModifier);
	}
	
	
	public int getiTheatreID() {
		return iTheatreID;
	}
	public void setiTheatreID(int iTheatreID) {
		this.iTheatreID = iTheatreID;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsPhoneNumber() {
		return sPhoneNumber;
	}
	public void setsPhoneNumber(String sPhoneNumber) {
		this.sPhoneNumber = sPhoneNumber;
	}
	public String getsAddress() {
		return sAddress;
	}
	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}
	public String getsCity() {
		return sCity;
	}
	public void setsCity(String sCity) {
		this.sCity = sCity;
	}
	public String getsState() {
		return sState;
	}
	public void setsState(String sState) {
		this.sState = sState;
	}
	public int getiNumberOfSeates() {
		return iNumberOfSeates;
	}
	public void setiNumberOfSeates(int iNumberOfSeates) {
		this.iNumberOfSeates = iNumberOfSeates;
	}
	public int getiSellerID() {
		return iSellerID;
	}
	public void setiSellerID(int iSellerID) {
		this.iSellerID = iSellerID;
	}
	
	
}

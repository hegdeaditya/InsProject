package edu.iiitb.OnlineMovieTicketBooking.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class MovieTimings {
	

	private int iMovieTimingID;
	private Date dDate;
	private Time ttime;
	private int iSeatsLeft;
	private String sClass1;
    private String sClass2;
    private String sClass3;
	private int iSeatsLeftType1;
	private String sSeatsLeftOfType1;
	private int iPriceOfType1;
	private int iSeatsLeftType2;
	private String sSeatsLeftOfType2;
	private int iPriceOfType2;
	private int iSeatsLeftType3;
	private String sSeatsLeftOfType3;
	private int iPriceOfType3;
	private int iMovieID;
	
	
	public int insert() {
		return MovieTimingsDAO.insert(this);
	}
	
	public static ArrayList<MovieTimings> findForOverlappingOfMovieTimings(String selectionModifier) {
		return MovieTimingsDAO.findForOverlappingOfMovieTimings(selectionModifier);
	}
public static MovieTimings findOne(String selectionModifier){
	return(MovieTimingsDAO.findOne(selectionModifier));
	
}



public void settTime(Time tTime) {
	this.ttime = tTime;
}

	
	
	public int getiMovieTimingID() {
		return iMovieTimingID;
	}
	public void setiMovieTimingID(int iMovieTimingID) {
		this.iMovieTimingID = iMovieTimingID;
	}
	public Date getdDate() {
		return dDate;
	}
	public void setdDate(Date dDate) {
		this.dDate = dDate;
	}
	public Time getTtime() {
		return ttime;
	}
	public Time gettTime() {
		return ttime;
	}
	public void setTtime(Time ttime) {
		this.ttime = ttime;
	}
	public int getiSeatsLeft() {
		return iSeatsLeft;
	}
	public void setiSeatsLeft(int iSeatsLeft) {
		this.iSeatsLeft = iSeatsLeft;
	}
	public String getsClass1() {
		return sClass1;
	}
	public void setsClass1(String sClass1) {
		this.sClass1 = sClass1;
	}
	public String getsClass2() {
		return sClass2;
	}
	public void setsClass2(String sClass2) {
		this.sClass2 = sClass2;
	}
	public String getsClass3() {
		return sClass3;
	}
	public void setsClass3(String sClass3) {
		this.sClass3 = sClass3;
	}
	public int getiSeatsLeftType1() {
		return iSeatsLeftType1;
	}
	public void setiSeatsLeftType1(int iSeatsLeftType1) {
		this.iSeatsLeftType1 = iSeatsLeftType1;
	}
	public String getsSeatsLeftOfType1() {
		return sSeatsLeftOfType1;
	}
	public void setsSeatsLeftOfType1(String sSeatsLeftOfType1) {
		this.sSeatsLeftOfType1 = sSeatsLeftOfType1;
	}
	public int getiPriceOfType1() {
		return iPriceOfType1;
	}
	public void setiPriceOfType1(int iPriceOfType1) {
		this.iPriceOfType1 = iPriceOfType1;
	}
	public int getiSeatsLeftType2() {
		return iSeatsLeftType2;
	}
	public void setiSeatsLeftType2(int iSeatsLeftType2) {
		this.iSeatsLeftType2 = iSeatsLeftType2;
	}
	public String getsSeatsLeftOfType2() {
		return sSeatsLeftOfType2;
	}
	public void setsSeatsLeftOfType2(String sSeatsLeftOfType2) {
		this.sSeatsLeftOfType2 = sSeatsLeftOfType2;
	}
	public int getiPriceOfType2() {
		return iPriceOfType2;
	}
	public void setiPriceOfType2(int iPriceOfType2) {
		this.iPriceOfType2 = iPriceOfType2;
	}
	public int getiSeatsLeftType3() {
		return iSeatsLeftType3;
	}
	public void setiSeatsLeftType3(int iSeatsLeftType3) {
		this.iSeatsLeftType3 = iSeatsLeftType3;
	}
	public String getsSeatsLeftOfType3() {
		return sSeatsLeftOfType3;
	}
	public void setsSeatsLeftOfType3(String sSeatsLeftOfType3) {
		this.sSeatsLeftOfType3 = sSeatsLeftOfType3;
	}
	public int getiPriceOfType3() {
		return iPriceOfType3;
	}
	public void setiPriceOfType3(int iPriceOfType3) {
		this.iPriceOfType3 = iPriceOfType3;
	}
	public int getiMovieID() {
		return iMovieID;
	}
	public void setiMovieID(int iMovieID) {
		this.iMovieID = iMovieID;
	}
	
	
	
}

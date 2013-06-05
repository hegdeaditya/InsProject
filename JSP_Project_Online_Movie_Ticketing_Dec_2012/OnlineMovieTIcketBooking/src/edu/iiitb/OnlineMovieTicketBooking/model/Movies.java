package edu.iiitb.OnlineMovieTicketBooking.model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Movies {
	
	//imovieID,sName ,iRating ,dScreeningStartDate ,dScreeningEndDate ,tShowTiming1 ,tShowTiming2,tShowTiming3,tShowTiming4,iTheatreID 

private int imovieID;
private String sName ;
private int iRating;
private Date dScreeningStartDate;
public Date getdScreeningStartDate() {
	return dScreeningStartDate;
}


public void setdScreeningStartDate(Date dScreeningStartDate) {
	this.dScreeningStartDate = dScreeningStartDate;
}


public Date getdScreeningEndDate() {
	return dScreeningEndDate;
}


public void setdScreeningEndDate(Date dScreeningEndDate) {
	this.dScreeningEndDate = dScreeningEndDate;
}
private Date dScreeningEndDate;
private Time tShowTiming1;
private Time tShowTiming2;
private Time tShowTiming3;
private Time tShowTiming4;
private int iTheatreID;


public static Movies findOne(String selectionModifier) {
    return MoviesDAO.findOne(selectionModifier);
}

public int update() {
	return MoviesDAO.update(this);
}

public int insert() {
	return MoviesDAO.insert(this);
}

public static ArrayList<Movies> find(String selectionModifier) {
	return MoviesDAO.find(selectionModifier);
}

public static int DeleteOne(String selectionModifier) {
	return MoviesDAO.DeleteOne(selectionModifier);
}
public int getImovieID() {
	return imovieID;
}
public void setImovieID(int imovieID) {
	this.imovieID = imovieID;
}
public String getsName() {
	return sName;
}
public void setsName(String sName) {
	this.sName = sName;
}
public int getiRating() {
	return iRating;
}
public void setiRating(int iRating) {
	this.iRating = iRating;
}

public Time gettShowTiming1() {
	return tShowTiming1;
}
public void settShowTiming1(Time tShowTiming1) {
	this.tShowTiming1 = tShowTiming1;
}
public Time gettShowTiming2() {
	return tShowTiming2;
}
public void settShowTiming2(Time tShowTiming2) {
	this.tShowTiming2 = tShowTiming2;
}
public Time gettShowTiming3() {
	return tShowTiming3;
}
public void settShowTiming3(Time tShowTiming3) {
	this.tShowTiming3 = tShowTiming3;
}
public Time gettShowTiming4() {
	return tShowTiming4;
}
public void settShowTiming4(Time tShowTiming4) {
	this.tShowTiming4 = tShowTiming4;
}
public int getiTheatreID() {
	return iTheatreID;
}
public void setiTheatreID(int iTheatreID) {
	this.iTheatreID = iTheatreID;
}




	
	
	
}

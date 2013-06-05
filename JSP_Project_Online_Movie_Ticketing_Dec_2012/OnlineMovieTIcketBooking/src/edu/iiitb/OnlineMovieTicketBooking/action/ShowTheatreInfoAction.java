package edu.iiitb.OnlineMovieTicketBooking.action;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.OnlineMovieTicketBooking.model.Theatre;
import edu.iiitb.OnlineMovieTicketBooking.model.TheatreClassAndPrice;

public class ShowTheatreInfoAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private int theatreID;
	Theatre theatre;

	private int iTheatreID;
	private String  sNamesuhas;
	private String  sPhoneNumber ;
	private String sAddress ;
	private String sCity ;
	private String sState ;
	private int iNumberOfSeates;
	private int iSellerID;
	ArrayList<TheatreClassAndPrice> arrTheatreClassAndPrice;
	
	private String suhas;
	private String theaterName;
	
	public String getTheaterName() {
		return theaterName;
	}


	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}


	public String getsNamesuhas() {
		return sNamesuhas;
	}


	public void setsNamesuhas(String sNamesuhas) {
		this.sNamesuhas = sNamesuhas;
	}


	public String getSuhas() {
		return suhas;
	}


	public void setSuhas(String suhas) {
		this.suhas = suhas;
	}


	


	public int getTheatreID() {
		return theatreID;
	}


	public void setTheatreID(int theatreID) {
		this.theatreID = theatreID;
	}


	public int getiTheatreID() {
		return iTheatreID;
	}


	public void setiTheatreID(int iTheatreID) {
		this.iTheatreID = iTheatreID;
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


	public ArrayList<TheatreClassAndPrice> getArrTheatreClassAndPrice() {
		return arrTheatreClassAndPrice;
	}


	public void setArrTheatreClassAndPrice(
			ArrayList<TheatreClassAndPrice> arrTheatreClassAndPrice) {
		this.arrTheatreClassAndPrice = arrTheatreClassAndPrice;
	}


	
	public String execute() throws Exception {
		Map<String,Object> session1 = ActionContext.getContext().getSession();
		session1.put("theatreID", iTheatreID);
		String selectionModifier=" where iTheaterID="+this.theatreID+";";

		theatre=Theatre.findOne(selectionModifier);

		//if(!theatre.equals(null)){

			iTheatreID=theatre.getiTheatreID();
			this.sNamesuhas=theatre.getsName();
			sPhoneNumber=theatre.getsPhoneNumber();
			sAddress=theatre.getsAddress();
			sCity=theatre.getsCity();
			sState=theatre.getsState();
			iNumberOfSeates=theatre.getiNumberOfSeates();
			iSellerID=theatre.getiSellerID();
			selectionModifier=" where iTheaterID="+this.theatreID+";";

			arrTheatreClassAndPrice=TheatreClassAndPrice.find(selectionModifier);
			
			if(arrTheatreClassAndPrice.isEmpty()) return ERROR;

			for(TheatreClassAndPrice tcp :arrTheatreClassAndPrice){
				
				
				
			}
			
			
			theaterName=theatre.getsName();
			iNumberOfSeates=50;
			suhas=theatre.getsName();
			return SUCCESS;

		//}
		//else return ERROR;



	}

}

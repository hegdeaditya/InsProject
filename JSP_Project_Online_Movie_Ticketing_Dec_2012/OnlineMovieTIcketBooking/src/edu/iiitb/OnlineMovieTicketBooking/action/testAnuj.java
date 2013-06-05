package edu.iiitb.OnlineMovieTicketBooking.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class testAnuj {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	    try {
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");      
			Date dateWithoutTime = sdf.parse(sdf.format(new Date()));
			System.out.println(dateWithoutTime);
			
			long t= dateWithoutTime.getTime();
			java.sql.Date hh= new java.sql.Date(t);
			System.out.println(hh);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
	}

}

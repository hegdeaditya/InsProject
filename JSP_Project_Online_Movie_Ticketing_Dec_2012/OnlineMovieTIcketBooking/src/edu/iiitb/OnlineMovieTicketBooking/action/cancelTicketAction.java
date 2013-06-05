package edu.iiitb.OnlineMovieTicketBooking.action;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.omg.CORBA.Request;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.OnlineMovieTicketBooking.service.bookingSummaryService;
import edu.iiitb.OnlineMovieTicketBooking.service.cancelTicketService;
import edu.iiitb.OnlineMovieTicketBooking.service.reserveSeatService;

public class cancelTicketAction extends ActionSupport{


	private int ticketID;
	private int movietimingID;
	//private String dateFromQueryString;
	
	
	
/*
	public String getDateFromQueryString() {
		return dateFromQueryString;
	}

	public void setDateFromQueryString(String dateFromQueryString) {
		this.dateFromQueryString = dateFromQueryString;
	}



	private Date bookedDate;


	public Date getBookedDate() {
		return bookedDate;
	}

	public void setBookedDate(Date bookedDate) {
		this.bookedDate = bookedDate;
	}

*/
	
	public int getTicketID() {
		return ticketID;
	}

	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}

	public int getMovietimingID() {
		return movietimingID;
	}

	public void setMovietimingID(int movietimingID) {
		this.movietimingID = movietimingID;
	}



	public String execute() throws Exception {

		/*System.out.println("Date from query string:  "+dateFromQueryString);
		Date bookedDate;
		bookedDate = java.sql.Date.valueOf(dateFromQueryString);
		*/
		
		
	//	System.out.println("Date from query string:  "+bookedDate);
		
	//	System.out.println("Converted into jqvq.sql.date:  "+bookedDate);
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		java.sql.Date dCurrentDate;
		
		//FETCH THE CURRENT DATE
		/*try {
			SimpleDateFormat oSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");      
			java.util.Date dateWithoutTime = oSimpleDateFormat.parse(oSimpleDateFormat.format(new java.util.Date()));

			long dateConversion;
			dateConversion = dateWithoutTime.getTime();
			dCurrentDate= new java.sql.Date(dateConversion);
			
			if(bookedDate == dCurrentDate){
				addActionError(getText("Cannot cancel today's tickets."));
				return "cannotCancel";
			}

			//session.put("dCurrentDate", dCurrentDate);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		
		
		
		System.out.println("working--");
*/
		

		//GET THE DETAILS FROM tTicket AS PER THE ticketID
		//GET THE DETAILS FROM tMovieTimings AS PER THE movietimingID
		//UPDATE THE TABLE tMovieTimings WITH UPDATED SEAT NUMBERS ( TOTAL SEATS LEFT, NUMBER OF SEATS LEFT OF THAT TYPE, SEAT NUMBERS LEFT )
		//UPDATE THE BALANCE IN tSignUpSubscriber
		//DELETE ENTRY FROM tTicket

		cancelTicketService ocancelTicketService = new cancelTicketService();
		reserveSeatService oreserveSeatService = new reserveSeatService(); 
		bookingSummaryService obookingSummaryService = new bookingSummaryService();


		//GET THE DETAILS FROM tTicket AS PER THE ticketID
		int iStatusFetchDetails = ocancelTicketService.fetchDetails(ticketID);

		System.out.println("afer fetch status");

		if(iStatusFetchDetails == 1){

			//SUCCESSFULLY INITIALIZED SESSION VARIABLES RELATED TO tTicket IN cancelTicketService.java


			//GET THE DETAILS FROM tMovieTimings AS PER THE movietimingID
			int iStatusFetchDetailsFromtMovieTimings = ocancelTicketService.fetchDetailsFromtMovieTimings(movietimingID, (String) session.get("cancelsClass") );


			if(iStatusFetchDetailsFromtMovieTimings == 1 ){

				//SUCCESSFULLY FETCHED THE SESSION VARIABLES RELATED TO tMovieTimings IN cancelTicketService.java

				int updatediSeatsLeft ;

				//UPDATE THE FOLLOWING CORRESPONDING TO THE cancelsClass IN SESION VARIABLE 
				int updatediSeatsLeftType;
				String updatedsSeatsLeftOfType;

				String sSeatsAvailable=null;
				String sSeatsBought;

				// ---UPDATING updatedsSeatsLeftOfType---
				sSeatsAvailable = String.valueOf(session.get("updatesSeatsLeftOfType"));
				sSeatsBought = (String) session.get("cancelsSeatNumber");

				//SPLITTING BOTH THE STRINGS
				String sSeatsAvailablePieces[] ;
				String sSeatsBoughtPieces[];

				String newString;
				newString = null;

				System.out.println("sSeatsAvailable is -------------->>...  "+ sSeatsAvailable);

				//CHECK IF SEATS WERE AVAILABLE IN THE tMovieTimings
				if (sSeatsAvailable.equals("No Seats")){

					//DON'T SPLIT
					newString=sSeatsBought;

				}
				else{
					System.out.println("I am inside");

					//DO NORMAL PLITTING OF BOTH THE PIECES


					sSeatsAvailablePieces = sSeatsAvailable.split(";");
					sSeatsBoughtPieces = sSeatsBought.split(";");

					//SORTING THE SEAT NUMBERS
					int i, j, k, l;
					int count;

					count = 0;
					k = 0;
					l = 0;

					i = sSeatsAvailablePieces.length;
					j = sSeatsBoughtPieces.length;


					System.out.println("i = "+i+"j : "+j);



					newString = "No Seats";


					if( i == 0 ){

						//NO SEATS WERE AVAILABLE IN THAT THEATRE FOR THAT PARTICULAR CLASS
						//DIRECTLY TAKE THE SEATS BOOKED BY THE SUBSCRIBER AND UPDATE THEM TO tMovieTimings
						newString = sSeatsBought;
					}
					else if ( i >= j ){

						for ( k = 0 ; k < i ; k++ ){

							if ( l < j ){

								if ( Integer.parseInt(sSeatsAvailablePieces[k]) < Integer.parseInt(sSeatsBoughtPieces[l]) ){

									if(count != 0)
										newString = newString + ";" + sSeatsAvailablePieces[k] ;
									else
										newString = sSeatsAvailablePieces[k] ;

									count++ ;
								}
								else{

									if(count == 0){

										newString = sSeatsBoughtPieces[l] ;
										l++;
										k--;
									}

									else{

										newString = newString + ";" + sSeatsBoughtPieces[l] ;
										if(l<j)
											l++;
										k--;
									}

									count++ ;
								}
							}
							else{

								//COPY REST OF THE SEAT NUMBERS AS IT IS
								newString = newString + ";" + sSeatsAvailablePieces[k];
							}
						}

						if ( l <= ( j - 1 ) ){

							//SOME SEATS ARE STILL LEFT IN THE sSeatsBoughtPieces[]
							while ( l < j ){
								newString = newString + ";" + sSeatsBoughtPieces[l];
								l++;
							}
						}
					}
					else{
						try{

							for ( l = 0 ; l < j ; l++ ){

								if ( k < i ){

									if ( Integer.parseInt(sSeatsBoughtPieces[l]) < Integer.parseInt(sSeatsAvailablePieces[k]) ){

										if(count != 0)
											newString = newString + ";" + sSeatsBoughtPieces[l] ;
										else
											newString = sSeatsBoughtPieces[l] ;

										count++ ;
									}
									else{

										if(count == 0){

											newString = sSeatsAvailablePieces[k] ;
											k++;
											l--;
										}
										else{

											newString = newString + ";" + sSeatsAvailablePieces[k] ;
											if(k<i)
												k++;
											l--;
										}								
									}
								}
								else{

									//COPY REST OF THE SEATS IN sSeatsBoughtPieces[]
									newString = newString + ";" + sSeatsBoughtPieces[l];
								}
							}

							if ( k <= ( i - 1 ) ) {

								//SOME SEATS ARE STILL LEFT IN sSeatsAvailablePieces[]
								while ( k < i ) {
									newString = newString + ";" + sSeatsAvailablePieces[k];
									k++;
								}
							}
						}
						catch(Exception e){
							e.printStackTrace();

						}
					}
				}


				//UPDATED sSeatsLeftOfType

				updatediSeatsLeft = (Integer) session.get("updateiSeatsLeft") + (Integer) session.get("canceliNumberOfTicketsBought");
				updatediSeatsLeftType = (Integer) session.get("updateiSeatsLeftType") + (Integer) session.get("canceliNumberOfTicketsBought");
				updatedsSeatsLeftOfType = newString;

				System.out.println("--->>TESTING--->>>   newString is:  "+newString);


				int iStatusUpdateDetailsIntMovieTimings;

				iStatusUpdateDetailsIntMovieTimings = ocancelTicketService.updateDetailsIntMovieTimings(updatediSeatsLeft, updatediSeatsLeftType, updatedsSeatsLeftOfType, (String)session.get("cancelsClass"), movietimingID);

				if(iStatusUpdateDetailsIntMovieTimings == 1){

					//SUCCESSFUL IN UPDATING tMovieTimings

					//UPDATE THE BALANCE IN tSignUpSubscriber
					int iBalance;
					int updatediBalance;

					iBalance = oreserveSeatService.getBalance( ( Integer )session.get("iSubscriberID"));

					updatediBalance = iBalance + (Integer) session.get("canceliAmount") ;

					int iStatusUpdatetSignUpSubscriber;

					iStatusUpdatetSignUpSubscriber = obookingSummaryService.updateBalance( (Integer) session.get("iSubscriberID"), updatediBalance );

					if ( iStatusUpdatetSignUpSubscriber == 1 ){

						//SUCCESSFULLY UPDATED tSignUpSubscriber

						//DELETE ENTRY FROM TABLE tTicket OR UPADTE THE STATUS TO 'cancelled'

						int iStatusUpdatetTicket;

						iStatusUpdatetTicket = ocancelTicketService.updatesPaidStatus(ticketID);

						if( iStatusUpdatetTicket == 1 ){

							//SUCCESSFULLY DONE ALL OPERATIONS
							return "TicketCancelled";

						}
						else
							return "FAILURE";
					}
					else
						return "FAILURE";
				}
				else
					return "FAILURE";
			}
			else
				return "FAILURE";
		}
		else
			return "FAILURE";
	}
}

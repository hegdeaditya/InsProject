package edu.iiitb.OnlineMovieTicketBooking.action;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.OnlineMovieTicketBooking.service.reserveSeatService;

public class reserveSeatAction extends ActionSupport{

	private String textBoxInput;
	private String commandButton;
	private String seatstring;
	ArrayList<String> seats=new ArrayList<String>();

	public ArrayList<String> getSeats() {
		return seats;
	}

	public void setSeats(ArrayList<String> seats) {
		this.seats = seats;
	}


	public String getSeatstring() {
		return seatstring;
	}

	public void setSeatstring(String seatstring) {
		this.seatstring = seatstring;
	}

	public String getTextBoxInput() {
		return textBoxInput;
	}

	public void setTextBoxInput(String textBoxInput) {
		this.textBoxInput = textBoxInput;
	}

	public String getCommandButton() {
		return commandButton;
	}

	public void setCommandButton(String commandButton) {
		this.commandButton = commandButton;
	}



	//---EXECUTE METHOD---
	public String execute() throws Exception {


		Map<String, Object> session = ActionContext.getContext().getSession();
		String seatsAvailable = (String) session.get("seatsAvailable");
		int i, j;

		reserveSeatService oreserveSeatService = new reserveSeatService();


		//SPLIT THE SEATS LAYOUT INTO AN ARRAY
		String columns[] = seatsAvailable.split(";");

		//NUMBER OF SEATS AVAILABLE OF THE TYPE SUBSCRIBER SELECTED ( iNumberOfSeatsLeftOfTypeSelected )
		session.put("iNumberOfSeatsLeftOfTypeSelected", columns.length);

		String arr[]=seatstring.split(", ");
		seats=(ArrayList<String>)session.get("seats");

		//CHECK IF SOME SEATS ARE SELECTED (IF NOT SELECTED, DO NOT ALLOW THE SUBSCRIBER TO CONTINUE)
		if(seatstring.isEmpty() || seatstring.equals(null) || seatstring.equals(" ")){

			return "NoSelection";
		}

		//SPLIT THE TEXT BOX INPUT IN AN ARRAY
		textBoxInput=seatstring;
		String textBoxSplitted[] = textBoxInput.split(", ");

		String sortedTextBox;
		String temp;
		int countForSorting;

		countForSorting = 0;
		sortedTextBox = "No Seats";

		int index;

		//add for one seat only

		if(textBoxSplitted.length == 1){

			//BOOKING ONLY ONE SEAT
			sortedTextBox = textBoxInput;
		}
		else{

			//BOOKING MORE THAN ONE SEAT

			//SORT THE INPUT RECEIVED FROM THE TEXTBOX
			for(index = 0 ; index < textBoxSplitted.length ; index++){

				if ( Integer.parseInt(textBoxSplitted[index]) > Integer.parseInt(textBoxSplitted[index + 1]) ){

					//SWAP
					temp = textBoxSplitted[index] ; 
					textBoxSplitted[index ] = textBoxSplitted[index + 1];
					textBoxSplitted[index + 1] = temp;
				}

				if ( index == ( textBoxSplitted.length - 2 ) ){
					index = -1;
				}

				countForSorting++ ;

				if(countForSorting == ( textBoxSplitted.length ) * ( textBoxSplitted.length ) ){
					break;
				}
			}

			//INITIALIZE ANOTHER STRING BASED ON THE SORTED SEAT NUMBERS OBTAINED
			countForSorting = 0;
			for(index = 0; index < textBoxSplitted.length ; index++){

				if(countForSorting == 0)
					sortedTextBox = textBoxSplitted[index];
				else
					sortedTextBox = sortedTextBox + ";" + textBoxSplitted[index];

				countForSorting++ ;
			}
		}

		countForSorting=0;
		for(index = 0; index < arr.length ; index++){

			if(countForSorting == 0)
				sortedTextBox = arr[index];
			else
				sortedTextBox = sortedTextBox + ";" + arr[index];

			countForSorting++ ;
		}


		//sortesTextBox is a String which contains Seat Numbers Booked


		//---APPLY SOME VALIDATIONS IF APPLICABLE---		


		//CALCULATE THE TOTAL MONEY THE SUBSCIBER HAS TO PAY FOR THE TIKETS HE IS BOOKING
		//SEE IF THE SUBSCRBER HAS THAT MUCH AMOUNT TO PAY IN HIS BALANCE
		//NUMBER OF TICKETS BOOKED
		int numberOfTicketsBuyed = textBoxSplitted.length;

		int classType;

		if( session.get( "sClass" ).toString().equalsIgnoreCase("Gold") )
			classType = 1;
		else if( session.get( "sClass" ).toString().equalsIgnoreCase("Silver") )
			classType = 2;
		else if( session.get( "sClass" ).toString().equalsIgnoreCase("Economy") )
			classType = 3;
		else
			classType = 0; //WHICH WILL NEVER HAPPEN

		System.out.println("Class of ticket: " +classType);
		System.out.println("MovieTimingID:  "+ (Integer) session.get("iMovieTimingID"));
		
		//GET PRICE OF EACH TICKET
		int priceOfEachTicket = oreserveSeatService.getPriceOfTicket( (Integer) session.get("iMovieTimingID"), classType);
		System.out.println("--->>>  Price of Ticket: "+priceOfEachTicket);
		
		
		//CALCULATE TOTAL AMOUNT TO BE PAID
		int totalAmount = numberOfTicketsBuyed * priceOfEachTicket ;
		System.out.println("---->>> Total Amount is: "+totalAmount);
		
		//GET THE AVAILABLE BALANCE IN THE USER'S ACCOUNT
		int balance = oreserveSeatService.getBalance((Integer) session.get("iSubscriberID"));

		//CURRENT BALANCE
		session.put("currentBalance", balance);

		//CHECK IF THE AMOUNT EXCEEDS THE SUBSCIBER'S BALANCE
		if(balance >= totalAmount){

			//USER CAN BUY THE TICKET
			System.out.println("--->TESTING---> You buy " + textBoxSplitted.length + " tickets for Rs. " + totalAmount + " !");

			//---INTIALIZING SESSION VARIABLES---

			//AMOUNT TO BE PAID
			session.put("totalAmount", totalAmount);

			//SEATS SELECTED

			session.put("seatsSelected", sortedTextBox);

			//NUMBER OF SEATS SELECTED
			session.put("iNumberOfSeatsSelected", textBoxSplitted.length);

			//UPDATED (NEW) BALANCE
			session.put("newBalance", balance - totalAmount);

			//SEE EACH INDEX'S VALUE ON CONSOLE (FOR TESTING PURPOSES)
			for( i = 0 ; i < columns.length ; i++){
				System.out.println(columns[i]);
			}

			//RECEIVE THE USER SEAT NUMBERS INPUT FROM THE TEXTBOX ON BUTTON CLICK, AND PROCESS:
			//1. UPDATE THE STRING "seatsAvailable" TO THE NEW VALUES (REMOVE THE SEAT NUMBER WHAT USER HAS SELECTED) IN THE DATABASE TABLE "tMovieTimings"
			//2. UPDATE THE NUMBER OF SEATS LEFT IN THAT PARTICULAR TYPE IN THE TABLE "tMovieTimings"
			//3. UPDATE THE TOTAL NUMBER OF SEATS LEFT IN THE THEATRE FOR THAT PARTICULAR MOVIE


			int iTotalSeatsLeft = oreserveSeatService.getTotalSeatsLeft((Integer) session.get("iMovieTimingID"));

			System.out.println("-->> TESTING -->> Total number of seats left were:  "+ iTotalSeatsLeft);

			session.put("iTotalSeatsLeft", iTotalSeatsLeft);

			System.out.println("--->TESTING--->>> splitted text box is: ");
			for ( i=0; i<textBoxSplitted.length;i++){
				System.out.println(textBoxSplitted[i]);
			}

			for( i = 0; i < columns.length ; i++ ){

				for( j = 0 ; j < textBoxSplitted.length ; j++ ){

					if ( columns[i].equals(textBoxSplitted[j]) ){
						columns[i] = null;
						break;
					}
				}
			}

			for( i = 0 ; i < columns.length ; i++){
				System.out.println(columns[i]);
			}

			//---UPDATING THE "newSeatsAvailable" STRING---

			String newSeatsAvailable="No Seats";

			int count = 0;

			for ( i = 0 ; i < columns.length ; i++ ){

				if ( columns[i] != null ){

					if ( count == 0 ){
						newSeatsAvailable = columns[i] ;
					}
					else{
						newSeatsAvailable = newSeatsAvailable + ";" ;
						newSeatsAvailable = newSeatsAvailable + columns[i] ;
					}

					count ++;
				}
			}

			session.put("newSeatsAvailable", newSeatsAvailable);

			//SEE THE UPDATED SEATS AVAILABLE
			System.out.println( "Available Seats before were: " + seatsAvailable );
			System.out.println ( "Available Seats after user confirms will be:  " + newSeatsAvailable ) ;

			//RETURNS EITHER SUCCESS OR FAILURE
			return "SUCCESS";	
		}
		else{
			//USER CANNOT BUY THE TICKET
			return "exceed";
		}

	}
}

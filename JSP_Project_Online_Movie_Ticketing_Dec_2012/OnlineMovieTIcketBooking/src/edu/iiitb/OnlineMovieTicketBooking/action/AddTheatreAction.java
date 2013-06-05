package edu.iiitb.OnlineMovieTicketBooking.action;
import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.OnlineMovieTicketBooking.model.Theatre;
import edu.iiitb.OnlineMovieTicketBooking.model.TheatreClassAndPrice;
import edu.iiitb.OnlineMovieTicketBooking.service.AddTheatreService;



public class AddTheatreAction  extends ActionSupport{



	private static final long serialVersionUID = 1L;
	private String name;
	private String phoneNumber;
	private String address;
	private String city;
	private String state;
	private String numberOfSeates;

	private Theatre theatrebean= new Theatre();
	private TheatreClassAndPrice theatreClassAndPricebean= new TheatreClassAndPrice();
	private Map<String, Object> session1;
	private int iTheatreID; 
	private int iSellerID; 
	private String className1="Gold";
	private String classPrice1;
	private String seatsPerClass1;
	private String className2="Silver";
	private String classPrice2;
	private String seatsPerClass2;
	private String className3="Economy";
	private String classPrice3;
	private String seatsPerClass3;
	public String getClassName1() {
		return className1;
	}

	public void setClassName1(String className1) {
		this.className1 = className1;
	}

	public String getClassPrice1() {
		return classPrice1;
	}

	public void setClassPrice1(String classPrice1) {
		this.classPrice1 = classPrice1;
	}

	public String getSeatsPerClass1() {
		return seatsPerClass1;
	}

	public void setSeatsPerClass1(String seatsPerClass1) {
		this.seatsPerClass1 = seatsPerClass1;
	}

	public String getClassName2() {
		return className2;
	}

	public void setClassName2(String className2) {
		this.className2 = className2;
	}

	public String getClassPrice2() {
		return classPrice2;
	}

	public void setClassPrice2(String classPrice2) {
		this.classPrice2 = classPrice2;
	}

	public String getSeatsPerClass2() {
		return seatsPerClass2;
	}

	public void setSeatsPerClass2(String seatsPerClass2) {
		this.seatsPerClass2 = seatsPerClass2;
	}

	public String getClassName3() {
		return className3;
	}

	public void setClassName3(String className3) {
		this.className3 = className3;
	}

	public String getClassPrice3() {
		return classPrice3;
	}

	public void setClassPrice3(String classPrice3) {
		this.classPrice3 = classPrice3;
	}

	public String getSeatsPerClass3() {
		return seatsPerClass3;
	}

	public void setSeatsPerClass3(String seatsPerClass3) {
		this.seatsPerClass3 = seatsPerClass3;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getNumberOfSeates() {
		return numberOfSeates;
	}

	public void setNumberOfSeates(String numberOfSeates) {
		this.numberOfSeates = numberOfSeates;
	}

	public Theatre getTheatrebean() {
		return theatrebean;
	}

	public void setTheatrebean(Theatre theatrebean) {
		this.theatrebean = theatrebean;
	}

	public String execute() throws Exception {
		//call Service class to store personBean's state in database

		int numberOfSeats1;
		int classPrice;
		int iTheatreClassID ;
		AddTheatreService addService=new AddTheatreService();

		session1= ActionContext.getContext().getSession();
		iSellerID=(Integer) session1.get("iSellerID");
		//System.out.println("iSeller id from add theatre "+iSellerID);

		theatrebean.setsName(name);
		theatrebean.setsPhoneNumber(phoneNumber);
		theatrebean.setsCity(city);
		theatrebean.setsAddress(address);
		theatrebean.setsState(state);
		theatrebean.setiSellerID(iSellerID);
		try {
			
			System.out.println(numberOfSeates);
			
			numberOfSeats1=Integer.parseInt(numberOfSeates);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			addActionError(getText("class Price of Gold class should be a number."));
			return ERROR;
			//e.printStackTrace();
		}
		theatrebean.setiNumberOfSeates(numberOfSeats1);

		iTheatreID= addService.addTheatre(theatrebean);
		if(iTheatreID==0){

			return ERROR;
		}

		//adding theatre class and price
		System.out.println();

		if(!className1.isEmpty()|| !classPrice1.isEmpty() ||!seatsPerClass1.isEmpty()){
			
			
			try {
				theatreClassAndPricebean.setsClass(className1);
				classPrice=Integer.parseInt(classPrice1);
				theatreClassAndPricebean.setiPrice(classPrice);
				numberOfSeats1=Integer.parseInt(seatsPerClass1);
				theatreClassAndPricebean.setiNimberOfSeatsPerClass(numberOfSeats1);
				theatreClassAndPricebean.setiTheatreID(iTheatreID);
				//insert into database
				iTheatreClassID=addService.addTheatreClassAndPrice(theatreClassAndPricebean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}

		if(!className2.isEmpty() && !classPrice2.isEmpty() &&!seatsPerClass2.isEmpty()){
			try {
				theatreClassAndPricebean.setsClass(className2);
				classPrice=Integer.parseInt(classPrice2);
				theatreClassAndPricebean.setiPrice(classPrice);
				numberOfSeats1=Integer.parseInt(seatsPerClass2);
				theatreClassAndPricebean.setiNimberOfSeatsPerClass(numberOfSeats1);
				theatreClassAndPricebean.setiTheatreID(iTheatreID);
				//insert into database
				iTheatreClassID=addService.addTheatreClassAndPrice(theatreClassAndPricebean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if(!className3.isEmpty()&& !classPrice3.isEmpty() && !seatsPerClass3.isEmpty()){

			try {
				theatreClassAndPricebean.setsClass(className3);
				classPrice=Integer.parseInt(classPrice3);
				theatreClassAndPricebean.setiPrice(classPrice);
				numberOfSeats1=Integer.parseInt(seatsPerClass3);
				theatreClassAndPricebean.setiNimberOfSeatsPerClass(numberOfSeats1);
				theatreClassAndPricebean.setiTheatreID(iTheatreID);
				//insert into database
				iTheatreClassID=addService.addTheatreClassAndPrice(theatreClassAndPricebean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if(iSellerID!=0){

			return SUCCESS;
		}
		else 
			return ERROR;

		//return SUCCESS;
	}



	public void validate() {
		//mandatory field validation
		int flag1=1,flag2=1,flag3=1,flag4=1;
		
		
		try{
			if ( name.length() == 0 ){	
				addFieldError( "name", "Theatre Name is required." );
				return;
				//System.out.println("zoomba");
			}
			if ( phoneNumber.length() == 0 ){	
				addFieldError( "phoneNumber", "address is required." );
				return;
				//System.out.println("zoomba");
			}
			if ( address.length() == 0 ){	
				addFieldError( "address", "Theatre Name is required." );
				return;
				//System.out.println("zoomba");
			}
			if ( city.length() == 0 ){	
				addFieldError( "city", "city is required." );
				return;
				//System.out.println("zoomba");
			}
			if ( state.length() == 0 ){	
				addFieldError( "state", "state is required." );
				return;
				//System.out.println("zoomba");
			}
			
			if ( numberOfSeates.length() == 0 ){	
				addFieldError( "numberOfSeates", "numberOfSeates is required." );
				//System.out.println("zoomba");
				return;
			}
			else{

				try {
					
					int i=Integer.parseInt(numberOfSeates);
					if(i>30) {
						addFieldError( "numberOfSeates", "numberOfSeates should be less than 30." );
						return;
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					flag1=0;
					addFieldError( "numberOfSeates", "numberOfSeates should be a number." );
					return;
				}
			}

			if ( classPrice1.length() == 0 ){	
				//classPrice1=null;

			}
			else{
				try {
					int i=Integer.parseInt(classPrice1);
				} catch (Exception e) {

					addActionError(getText("class Price of Gold class should be a number."));
					return;
				}

			}
			if ( seatsPerClass1.length() == 0 ){	
			//	seatsPerClass1=null;
			}
			else{
				try {
					int i=Integer.parseInt(seatsPerClass1);
					if(i> 10){
						addActionError(getText("seats Per Gold Class should be a <10."));
						
					}
				} catch (Exception e) {

					//addFieldError( "seatsPerClass1", "seatsPerClass1 should be a number." );
					flag2=0;
					addActionError(getText("seats Per Gold Class should be a number."));
					return;
				}

			}

			if ( classPrice2.length() == 0 ){	

				//classPrice2=null;
			}
			else{
				try {
					int i=Integer.parseInt(classPrice2);
					
				} catch (Exception e) {

					addActionError(getText("class Price of Silver class should be a number."));
					return;
				}

			}
			if ( seatsPerClass2.length() == 0 ){	
				//seatsPerClass2=null;
			}
			else{
				try {
					int i=Integer.parseInt(seatsPerClass2);
					if(i> 10){
						addActionError(getText("seats Per Silver Class should be a <10."));
						
					}
				} catch (Exception e) {

					//addFieldError( "seatsPerClass1", "seatsPerClass1 should be a number." );
					flag3=0;
					addActionError(getText("seats Per Silver Class should be a number."));
					return;

				}

			}

			if ( classPrice3.length() == 0 ){	
				//classPrice3=null;

			}
			else{
				try {
					int i=Integer.parseInt(classPrice3);
				} catch (Exception e) {

					addActionError(getText(" Price of Economy class should be a number."));
					return;
				}

			}
			if ( seatsPerClass3.length() == 0 ){	

			}
			else{
				try {
					int i=Integer.parseInt(seatsPerClass3);
					if(i> 10){
						addActionError(getText("seats Per Economy Class should be a <10."));
						
					}
				} catch (Exception e) {

					//addFieldError( "seatsPerClass1", "seatsPerClass1 should be a number." );
					flag4=0;
					addActionError(getText("seats Per Economy Class should be a number."));
					return;
				}

			}


			int count=0;
			if((classPrice1.length() == 0 &&  seatsPerClass1.length() != 0) || (classPrice1.length() != 0 &&  seatsPerClass1.length() == 0)){
				addActionError(getText("Fill Either both 1.seats Per Gold Class and 2.Price of Gold class."));
				return;
			}

			if((classPrice2.length() == 0 &&  seatsPerClass2.length() != 0) || (classPrice2.length() != 0 &&  seatsPerClass2.length() == 0)){
				addActionError(getText("Fill Either both 1.seats Per Silver Class and 2.Price of Silver class."));
				return;
			}

			if((classPrice3.length() == 0 &&  seatsPerClass3.length() != 0) || (classPrice3.length() != 0 &&  seatsPerClass3.length() == 0)){
				addActionError(getText("Fill Either both 1.seats Per Economy Class and 2.Price of Economy class."));
				return;
			}

			if(classPrice3.length() == 0 &&  seatsPerClass3.length() == 0 && classPrice2.length() == 0 &&  seatsPerClass2.length() == 0 && classPrice1.length() == 0 &&  seatsPerClass1.length() == 0){
				addActionError(getText("Must Fill Atleast one class Price and Number of seats corresponding to that class"));
				return;
			}
			ArrayList<Theatre> arr=null;
			String selectionModifier=" where sName='"+name.toString()+"' and sCity='"+city.toString()+"';";
			arr= Theatre.find(selectionModifier);
			if(arr.size()!=0){
				addActionError(getText("You cannot have multiple Theatres with same name in same city"));
				return;
			}

			int total_seats=0,seats1=0,seats2=0,seats3=0,selseats=0;

			if( flag1!=0 && flag2!=0 && flag3!=0 && flag4!=0 ){
				
				try {
					selseats=Integer.parseInt(numberOfSeates);

					if(!seatsPerClass1.isEmpty())
						seats1=Integer.parseInt(seatsPerClass1);

					if(!seatsPerClass2.isEmpty())
						seats2=Integer.parseInt(seatsPerClass2);

					if(!seatsPerClass3.isEmpty())
						seats3=Integer.parseInt(seatsPerClass3);

					total_seats=seats1+seats2+seats3;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if(selseats != total_seats){
					addFieldError( "numberOfSeates", "TotalnumberOfSeates should be a equal to sum of seats per class." );
				}
			}

		}catch(Exception e){
			System.out.println("iiiiiiiiiiiiiii"+e.getStackTrace());
			//e.printStackTrace();
		}

	}
}




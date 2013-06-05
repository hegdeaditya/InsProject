package edu.iiitb.OnlineMovieTicketBooking.action;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.OnlineMovieTicketBooking.model.MovieTimings;
import edu.iiitb.OnlineMovieTicketBooking.model.Movies;
import edu.iiitb.OnlineMovieTicketBooking.model.Theatre;
import edu.iiitb.OnlineMovieTicketBooking.model.TheatreClassAndPrice;
import edu.iiitb.OnlineMovieTicketBooking.service.AddMovieService;
import edu.iiitb.OnlineMovieTicketBooking.service.AddTheatreService;

public class AddMovieAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String rating;
	private Date screeningStartDate;
	private Date screeningEndDate;
	private Boolean showTiming1;
	private Boolean showTiming2;
	private Boolean showTiming3;
	private Boolean showTiming4;
	private int theatreID;
	private Movies movie ;
	ArrayList<Movies> arrayListMovies=null;
	ArrayList<MovieTimings> arrayListMovieTimings=null;
	MovieTimings movieTiming= new MovieTimings();


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public Date getScreeningStartDate() {
		return screeningStartDate;
	}
	public void setScreeningStartDate(Date screeningStartDate) {
		this.screeningStartDate = screeningStartDate;
	}
	public Date getScreeningEndDate() {
		return screeningEndDate;
	}
	public void setScreeningEndDate(Date screeningEndDate) {
		this.screeningEndDate = screeningEndDate;
	}

	public Boolean getShowTiming1() {
		return showTiming1;
	}
	public void setShowTiming1(Boolean showTiming1) {
		this.showTiming1 = showTiming1;
	}
	public Boolean getShowTiming2() {
		return showTiming2;
	}
	public void setShowTiming2(Boolean showTiming2) {
		this.showTiming2 = showTiming2;
	}
	public Boolean getShowTiming3() {
		return showTiming3;
	}
	public void setShowTiming3(Boolean showTiming3) {
		this.showTiming3 = showTiming3;
	}
	public Boolean getShowTiming4() {
		return showTiming4;
	}
	public void setShowTiming4(Boolean showTiming4) {
		this.showTiming4 = showTiming4;
	}
	public int getTheatreID() {
		return theatreID;
	}
	public void setTheatreID(int theatreID) {
		this.theatreID = theatreID;
	}

	@SuppressWarnings("deprecation")
	public String execute() throws Exception {

		java.sql.Date dScreeningStartDate;
		java.sql.Date dScreeningEndDate;
		java.sql.Time tShowTiming1= null;
		java.sql.Time tShowTiming2=null;
		java.sql.Time tShowTiming3=null;
		java.sql.Time tShowTiming4=null;
		Map<String,Object> session1 = ActionContext.getContext().getSession();
		int iTheatreID=(Integer) session1.get("theatreID");;//theatreID
		long t;
		int ret=0;
		AddMovieService addService=new AddMovieService();
		int dd,mm,yy;


		movie= new Movies();

		movie.setsName(name);
		movie.setiRating(Integer.parseInt(rating));

		t=screeningStartDate.getTime();
		dScreeningStartDate=new java.sql.Date(t);
		movie.setdScreeningStartDate(dScreeningStartDate);


		t=screeningEndDate.getTime();
		dScreeningEndDate=new java.sql.Date(t);
		movie.setdScreeningEndDate(dScreeningEndDate);

		if(showTiming1==true){
			tShowTiming1=new Time(12, 0, 0);
		}
		else{

			tShowTiming1=new Time(0, 0, 0);
		}
		if(showTiming2==true){
			tShowTiming2=new Time(15, 0, 0);
		}
		else{

			tShowTiming2=new Time(0, 0, 0);
		}
		if(showTiming3==true){
			tShowTiming3=new Time(18, 0, 0);
		}
		else{

			tShowTiming3=new Time(0, 0, 0);
		}

		if(showTiming4==true){
			tShowTiming4=new Time(21, 0, 0);
		}
		else{

			tShowTiming4=new Time(0, 0, 0);
		}

		movie.settShowTiming1(tShowTiming1);
		movie.settShowTiming2(tShowTiming2);
		movie.settShowTiming3(tShowTiming3);
		movie.settShowTiming4(tShowTiming4);

		movie.setiTheatreID(iTheatreID);


		String selectionModifier="  where t.itheaterid="+iTheatreID+" and t.iMovieID=tm.iMovieID and (tm.dDate >='"+dScreeningStartDate+"' and  tm.dDate <='"+dScreeningEndDate+"') and (tm.tTime  ='"+tShowTiming1+"' or tm.tTime  ='"+tShowTiming2+"' or tm.tTime  ='"+tShowTiming3+"' or tm.tTime  ='"+tShowTiming4+"');";


		//arrayListMovies=Movies.find(selectionModifier);
		arrayListMovieTimings=MovieTimings.findForOverlappingOfMovieTimings(selectionModifier);
		if(arrayListMovieTimings.isEmpty()){
			System.out.println("I am not empty");
			ret=addService.addMovie(movie);
			System.out.println("ret="+ret);
		}
		else {

			addActionError(getText("Please Change starting date or end date /Movie timings as they are already overlapping with previously added movies"));
			return ERROR;
		}

		if(ret!=0){
			//update the table movie timing 
			java.sql.Date dDate;
			java.sql.Time tTime;
			int [] iSeatsLeftType= new int[3];
			int [] iPriceOfType= new int[3];
			int iSeatsLeft=0;
			String[] sClass= new String[3];
			String [] sSeatsLeftOfType=new String[3]; 
			ArrayList<TheatreClassAndPrice> arrayListTheatreClassAndPrice=null;
			// Thing common to  each insert statement or before it know sclass1 to sclass3 and sseatsleftoftype 1 to 3 iseatsleftoftype 1 to 3

			System.out.println("itheatreid="+iTheatreID);
			selectionModifier=" where iTheaterID ="+iTheatreID+";";
			System.out.println("selectionModifier="+selectionModifier);

			arrayListTheatreClassAndPrice=TheatreClassAndPrice.find(selectionModifier);
			int size=0;
			int flag0=-1,flag1=-1,flag2=-1;
			int i=0;
			if(arrayListTheatreClassAndPrice !=null){
				size=arrayListTheatreClassAndPrice.size();
				for(TheatreClassAndPrice  tc :arrayListTheatreClassAndPrice){

					if(tc.getsClass().equalsIgnoreCase("gold")){
						sClass[0]=tc.getsClass();
						iSeatsLeftType[0]=tc.getiNimberOfSeatsPerClass();
						iPriceOfType[0]=tc.getiPrice();
						flag0=0;

					}
					else if(tc.getsClass().equalsIgnoreCase("silver")){
						sClass[1]=tc.getsClass();
						iSeatsLeftType[1]=tc.getiNimberOfSeatsPerClass();
						iPriceOfType[1]=tc.getiPrice();
						flag1=1;
					}
					else if(tc.getsClass().equalsIgnoreCase("Economy")){
						sClass[2]=tc.getsClass();
						iSeatsLeftType[2]=tc.getiNimberOfSeatsPerClass();
						iPriceOfType[2]=tc.getiPrice();
						flag2=2;
					}
					//sClass[i]=tc.getsClass();
					//iSeatsLeftType[i]=tc.getiNimberOfSeatsPerClass();
					//iPriceOfType[i]=tc.getiPrice();
					//i++;

				}	
				//loop to update the sseats left of type

				String stt=" ";
				String stt1=" ";


			//	for(i=0;i<size;i++){

					if(flag0!=-1){


						for (int j=1;j<=iSeatsLeftType[flag0];j++){
							stt=null;
							if(j==1){
								sSeatsLeftOfType[flag0]=j+";";
							}
							else{
								if(j!=iSeatsLeftType[flag0]){
									stt=j+";";
									sSeatsLeftOfType[flag0]+=stt;
								}

								else sSeatsLeftOfType[flag0]=sSeatsLeftOfType[flag0]+j;
							}
						}
						sSeatsLeftOfType[flag0]=sSeatsLeftOfType[flag0].trim();
						iSeatsLeft+=iSeatsLeftType[flag0];

						System.out.println("sClass["+flag0+"]="+sClass[flag0]);
						System.out.println("sSeatsLeftOfType["+flag0+"]="+sSeatsLeftOfType[flag0]);
						System.out.println("iSeatsLeftType["+flag0+"]="+iSeatsLeftType[flag0]);
					}
					else {
						
						sSeatsLeftOfType[0]="No Seats";
					}


					 if(flag1!=-1){


						for (int j=1;j<=iSeatsLeftType[flag1];j++){
							stt=null;
							if(j==1){
								sSeatsLeftOfType[flag1]=j+";";
							}
							else{
								if(j!=iSeatsLeftType[flag1]){
									stt=j+";";
									sSeatsLeftOfType[flag1]+=stt;
								}

								else sSeatsLeftOfType[flag1]=sSeatsLeftOfType[flag1]+j;
							}
						}
						sSeatsLeftOfType[flag1]=sSeatsLeftOfType[flag1].trim();
						iSeatsLeft+=iSeatsLeftType[flag1];

						System.out.println("sClass["+flag1+"]="+sClass[flag1]);
						System.out.println("sSeatsLeftOfType["+flag1+"]="+sSeatsLeftOfType[flag1]);
						System.out.println("iSeatsLeftType["+flag1+"]="+iSeatsLeftType[flag1]);
					}
					 else {
							
							sSeatsLeftOfType[1]="No Seats";
						}

				 if(flag2!=-1){



						for (int j=1;j<=iSeatsLeftType[flag2];j++){
							stt=null;
							if(j==1){
								sSeatsLeftOfType[flag2]=j+";";
							}
							else{
								if(j!=iSeatsLeftType[flag2]){
									stt=j+";";
									sSeatsLeftOfType[flag2]+=stt;
								}

								else sSeatsLeftOfType[flag2]=sSeatsLeftOfType[flag2]+j;
							}
						}
						sSeatsLeftOfType[flag2]=sSeatsLeftOfType[flag2].trim();
						iSeatsLeft+=iSeatsLeftType[flag2];

						System.out.println("sClass["+flag2+"]="+sClass[flag2]);
						System.out.println("sSeatsLeftOfType["+flag2+"]="+sSeatsLeftOfType[flag2]);
						System.out.println("iSeatsLeftType["+flag2+"]="+iSeatsLeftType[flag2]);

					}

				 else {
						
						sSeatsLeftOfType[2]="No Seats";
					}
			//	}
				System.out.println("iSeatsLeft"+iSeatsLeft+"");

				//for each date starting to end
				// do insert statements as many times as show timings of that movie


				//count the number of show timings
				int countOfTimings=0;
				if(showTiming1==true) countOfTimings++;
				if(showTiming2==true) countOfTimings++;
				if(showTiming3==true) countOfTimings++;
				if(showTiming4==true) countOfTimings++;

				java.sql.Date d1;
				int days;
				days=AddMovieAction.DifferenceInDays(dScreeningStartDate, dScreeningEndDate);
				days=days+1;

				t=screeningStartDate.getTime();
				d1=new java.sql.Date(t);
				String na="na";
				movieTiming.setiSeatsLeft(iSeatsLeft);
				if(flag0!=-1){
					movieTiming.setsClass1(sClass[0]);
				}
				else{

					movieTiming.setsClass1(na);
				}

				if(flag1!=-1){
					movieTiming.setsClass2(sClass[1]);
				}
				else{

					movieTiming.setsClass2(na);
				}


				if(flag2!=-1){
					movieTiming.setsClass3(sClass[2]);
				}
				else{

					movieTiming.setsClass3(na);
				}


				//	movieTiming.setsClass2(sClass[1]);
				//movieTiming.setsClass3(sClass[2]);
				movieTiming.setiSeatsLeftType1(iSeatsLeftType[0]);
				movieTiming.setiSeatsLeftType2(iSeatsLeftType[1]);
				movieTiming.setiSeatsLeftType3(iSeatsLeftType[2]);
				movieTiming.setsSeatsLeftOfType1(sSeatsLeftOfType[0]);
				movieTiming.setsSeatsLeftOfType2(sSeatsLeftOfType[1]);
				movieTiming.setsSeatsLeftOfType3(sSeatsLeftOfType[2]);
				movieTiming.setiPriceOfType1(iPriceOfType[0]);
				movieTiming.setiPriceOfType2(iPriceOfType[1]);
				movieTiming.setiPriceOfType3(iPriceOfType[2]);
				movieTiming.setiMovieID(ret);

				//for each date starting to end
				for(int index=1;index<=days;index++){
					// do insert statements as many times as show timings of that movie
					//for(int index2=1;index2<=countOfTimings;index2++){
					//call the insert statements
					if(showTiming1==true){

						movieTiming.setdDate(d1);
						movieTiming.settTime(tShowTiming1);
						//call the insert statement
						movieTiming.insert();
					}

					if(showTiming2==true){

						movieTiming.setdDate(d1);
						movieTiming.settTime(tShowTiming2);
						//call the insert statement
						movieTiming.insert();

					}
					if(showTiming3==true){

						movieTiming.setdDate(d1);
						movieTiming.settTime(tShowTiming3);
						//call the insert statement
						movieTiming.insert();

					}

					if(showTiming4==true){

						movieTiming.setdDate(d1);
						movieTiming.settTime(tShowTiming4);
						//call the insert statement
						movieTiming.insert();
					}

					t=t+MILLISECONDS_IN_DAY;
					d1=new java.sql.Date(t);

				}
				System.out.println(d1);
				//t=t+MILLISECONDS_IN_DAY;
				//d1=new java.sql.Date(t);


				//}

				System.out.println("days"+days);

				System.out.println("i am 1"+stt1);

				return SUCCESS;
			}
			else{
				return ERROR;
			}

		}
		else return ERROR;



	}


	public String insertSessionInfo() throws Exception{
		Map<String,Object> session1 = ActionContext.getContext().getSession();
		session1.put("theatreID",theatreID);
		return SUCCESS;
	}


	public final static long MILLISECONDS_IN_DAY = 24 * 60 * 60 * 1000;

	public static int DifferenceInDays(Date from, Date to) {
		return (int)((to.getTime() - from.getTime()) / MILLISECONDS_IN_DAY);
	}
	public void validate() {

		java.sql.Date dummyStartDate=null;
		java.sql.Date dummyEndDate=null;

		//mandatory field validation
		try{

			if ( name.length() == 0 ){	
				addFieldError( "name", "name is required." );
				return;

			}
			if ( rating.length() == 0 ){	
				addFieldError( "rating", "rating is required." );
				return;
			}
			else{

				try {
					int ret=0;

					ret=Integer.parseInt(rating);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					addFieldError( "rating", "rating has to be a number." );
					e.printStackTrace();
					return;
				}


			}

			if(screeningStartDate==null){
				addFieldError( "screeningStartDate", "screeningStartDate is mandatory." );
				return;
			}
			else{


				try {

					long m=screeningStartDate.getTime();

					dummyStartDate=new java.sql.Date(m);

					java.util.Date today = new java.util.Date();
					java.sql.Date sqlToday = new java.sql.Date(today.getTime());
					long m2=sqlToday.getTime();

					if(m2>m){
						addFieldError( "screeningStartDate", "screeningStartDate cannot be old date." );	
						return;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					addFieldError( "screeningStartDate", "screeningStartDate is not in valid format." );
					e.printStackTrace();
					return;
				}


			}

			if(screeningEndDate==null){
				addFieldError( "screeningEndDate", "screeningEndDate is mandatory." );
				return;
			}
			else{
				try {
					long n=screeningEndDate.getTime();
					dummyEndDate=new java.sql.Date(n);



					java.util.Date today = new java.util.Date();
					java.sql.Date sqlToday = new java.sql.Date(today.getTime());
					long m2=sqlToday.getTime();

					if(m2>n){
						addFieldError( "screeningEndDate", "screeningEndDate cannot be old date." );	
						return;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					addFieldError( "screeningEndDate", "screeningEndDate is not in valid format." );
					e.printStackTrace();
					return;
				}


			}



			int days;
			days=AddMovieAction.DifferenceInDays(dummyStartDate, dummyEndDate);

			if(days<0){
				addFieldError( "screeningStartDate", "screeningStartDate should not  be a Older date than screeningEndDate." );
				return;

			}

			if(showTiming1==false && showTiming2==false && showTiming3==false && showTiming4==false){
				addFieldError( "showTiming1", "Must select atleast one timing checkbox." );

			}

		}
		catch(Exception e){
			e.printStackTrace();

		}	

	}


}

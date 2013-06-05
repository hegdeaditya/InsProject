package edu.iiitb.OnlineMovieTicketBooking.action;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.OnlineMovieTicketBooking.model.Ticket;

public class ViewTicketsAction extends ActionSupport{
	
	private ArrayList <Ticket> tc= new ArrayList <Ticket>();

	public ArrayList<Ticket> getTc() {
		return tc;
	}

	public void setTc(ArrayList<Ticket> tc) {
		this.tc = tc;
	}
	
	
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		
		tc= (ArrayList<Ticket>) Ticket.find(" where iSubscriberID="+  (Integer) session.get("iSubscriberID") + " AND sPaidStatus = \"paid\" AND dDate > '"+ session.get("dCurrentDate") +"';");
		
		for(int i=0;i<tc.size();i++){
			
			System.out.println(tc.get(i).getsClass());
			
		}
		
		
		return "success";
	}
	
	
	

}

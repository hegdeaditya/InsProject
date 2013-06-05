<%@page import="java.util.Date"%>
<%@page import="java.text.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Movie Ticketing - View Tickets</title>



<!-- Movies Slider -->
<script type="text/javascript" src="jquery/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="jquery/jquery.slidertron-0.1.js"></script>
<link href="css/styleWelcome.css" rel="stylesheet" type="text/css"
	media="screen" />
<style type="text/css">
@import "css/slidertron.css";
</style>
<!-- Movies Slider ends -->

<!-- styleIndex.css -->
<link href="css/styleIndex.css" rel="stylesheet" type="text/css"
	media="screen" />
</head>
<body>
	<div id="wrapper">
		<div id="menu">
			<ul>
				<li><span> <a
						href="<s:url action='subscriberHome.action' />">Home</a> </span>
				</li>
				<li class="current_page_item"><a>View Tickets</a>
				</li>
				<li><a href="changepassword">Change Password</a>
				</li>
				<li><a href="logout.action">Log Out</a>
				</li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li>You are logged in as: <s:property
						value="#session['logged-in']" /> <!-- <li class="current_page_item"><a>Select City</a></li>  -->
			</ul>
		</div>
		<!-- end #menu -->
		<div id="header">
			<div id="logo">
				<h1>
					<a href="#">Your Tickets</a>
				</h1>
			</div>

		</div>
		<div id="splashTickets">



			<!--Main part starts here -->




			<s:if test="#session.login != 'true'">
				<jsp:forward page="index.jsp" />
			</s:if>

			<div id="pageD">
				<div id="contentD">
					<s:if test="hasActionErrors()">
						<div class="errors">
							<s:actionerror />
						</div>
					</s:if>


					<table cellpadding="2" cellspacing="1" border="2" align="center"
						background="images/img_table_bg2.jpg" rules="rows" frame="hsides" width="800px" style="font-variant: normal;color: black;">
						<tr align="center">
							<th align="center" width="10%">Ticket ID</th>
							<th align="center" width="20%">Date Of Show</th>
							<th align="center" width="20%">Show Time</th>
							<th align="center" width="10%">Class</th>
							<th align="center" width="10%">Number Of Seats</th>
							<th align="center" width="25%">Seat Number</th>
							<th align="center" width="20%">Total Amount</th>
							<th align="center" width="30%">Ticket Status</th>
						</tr>
						<%@ page
							import="java.util.ArrayList,edu.iiitb.OnlineMovieTicketBooking.model.*,java.sql.DriverManager,java.sql.ResultSet,java.util.Map,com.opensymphony.xwork2.ActionContext,org.apache.struts2.interceptor.SessionAware"%>

						<%
							Map<String, Object> session1 = ActionContext.getContext()
									.getSession();

							ArrayList<Ticket> tc = (ArrayList<Ticket>) Ticket
									.find(" where iSubscriberID="
											+ (Integer) session1.get("iSubscriberID")
											+ " AND sPaidStatus = \"paid\" AND dDate >= '"
											+ session1.get("dCurrentDate") + "';");

							for (int i = 0; i < tc.size(); i++) {
								Ticket ticket = tc.get(i);
						%>
						<tr align="center">
							<td align="center"><%=ticket.getiTicketID()%></td>
							<td align="center"><%=ticket.getdDate()%></td>
							<td align="center"><%=ticket.getsTime()%></td>
							<td align="center"><%=ticket.getsClass()%></td>
							<td align="center"><%=ticket.getiNumberOfTicketsBought()%></td>
							<td align="center"><%=ticket.getsSeatNumber()%></td>
							<td align="center"><%=ticket.getiAmountPaid()%></td>
							<td style="color: red;">
								<%
									Date curr = new Date();

										SimpleDateFormat oSimpleDateFormat = new SimpleDateFormat(
												"yyyy-MM-dd");
										java.util.Date dateWithoutTime = oSimpleDateFormat
												.parse(oSimpleDateFormat.format(new java.util.Date()));

										long dateConversion;
										dateConversion = dateWithoutTime.getTime();
										curr = new java.sql.Date(dateConversion);

										if (ticket.getdDate().equals(curr)) {
								%> Screening Today <%
									} else {
								%> <a
								href="cancelTicket.action?ticketID=<%=ticket.getiTicketID()%>&movietimingID=<%=ticket.getiMovieTimingID()%>" style="color: red;" >Cancel
									Ticket</a></td>
						</tr>
						<%
							}
						%>
						<%
							}
						%>
					</table>
					<s:if test="hasActionErrors()">
						<div class="errors">
							-
							<s:actionerror />
						</div>
					</s:if>
				</div>
			</div>


			<!-- Main part ends here -->




			&nbsp;
		</div>




		<!-- end Image Slider -->
		<!-- end #header -->

		<div id="page">
			<div id="page-bgtop">
				<div id="page-bgbtm">
					<div id="content">



						<div class="post">
							<h2 class="title">
								<a href="#">Welcome to Movie Ticketing </a>
							</h2>
							<div class="entry">



								<!-- need to copy here -->

								
								</div>

						</div>

						<div style="clear: both;">&nbsp;</div>
					</div>
					<!-- end #content -->

					<!-- end #sidebar -->
					<div style="clear: both;">&nbsp;</div>
				</div>
			</div>
		</div>
		<!-- end #page -->
	</div>
	<div id="footer-wrapper">
	<div id="three-columns">
		<div id="column1">
			<h2>Team Members</h2>
			<ul>
				<li><a href="#">Abhilash (MT2012003)</a></li>
				<li><a href="#">Anuj Duggal (MT2012024)</a></li>
				<li><a href="#">Vijay Huddar (MT2012161)</a></li>				
			</ul>
		</div>
		<div id="column2">
			<h2>Supporters</h2>
			<ul>
				<li><a href="#">Prof. Abbas S</a></li>
				<li><a href="#">Mr. Jatin Chaudhary</a></li>
				<li><a href="#">Ms. Deeksha Bhatt</a></li>
				<li><a href="#">Ms. Shweta</a></li>				
			</ul>
		</div>
		<div id="column3">
			<h2>References</h2>
			<ul>
				<li><a href="#">Online css tutorials</a></li>
				<li><a href="#">www.viralpatel.com</a></li>
			</ul>
		</div>
	</div>
	<div id="footer">
		<p>Copyright (c) 2013 onlinemovieticketing.com. All rights reserved. Designed by <a>IIITBians</a>.</p>
	</div>
	<!-- end #footer -->
</div>
</body>
</html>
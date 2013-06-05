<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Movie Ticketing</title>

<!-- Used for some tables -->

<link href="css/default.css" rel="stylesheet" type="text/css" />

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
				<li><span><a href="<s:url action='adminHome.action'/> ">Home</a> </span></li>
				<li><a href="<s:url action='manageSeller.action' />">Manage
						Sellers</a></li>
				<li  class="current_page_item"><a href="<s:url action='manageSubscriber.action'/>" />Manage
					Subscribers</a></li>
				<li><a href="<s:url action='changepasswordAdmin.action'/>" />Change Password</a></li>
				<li><a href="<s:url action='logout.action' />">Log Out</a></li>
				<!-- <li><a>Welcome <s:property value="#session['sEmail']" /></a></li>  -->
			</ul>
		</div>
		<!-- end #menu -->
		<div id="header">
			<div id="logo">
				<h1>
					<a href="#">Subscriber Management</a>
				</h1>
			</div>

		</div>
		<div id="splash">

			<!-- Main part starts Here -->



			<s:if test="hasActionMessages()">
				<div class="errors">
					<s:actionmessage />
				</div>
			</s:if>

			
					<s:if test="#session.login != 'true'">
						<jsp:forward page="index.jsp" />
					</s:if>

					<table border="1" cellpadding="7" align="center">
						<tr>
							<th>Subscriber Name</th>
							<th>Email ID</th>
							<th>Phone Number</th>
							<th>Address</th>
							<th>Date Of Birth</th>
							<th>Current Status</th>
							<th>Action</th>

						</tr>
						<%@ page
							import="java.util.ArrayList,edu.iiitb.OnlineMovieTicketBooking.model.*,java.sql.DriverManager,java.sql.ResultSet,java.util.Map,com.opensymphony.xwork2.ActionContext,org.apache.struts2.interceptor.SessionAware"%>
						<%
							Map<String, Object> session1 = ActionContext.getContext()
									.getSession();
							int regStatus1 = 1, regStatus2 = -2;
							ArrayList<SignUpSubscriber> subscribers = SignUpSubscriber
									.find("where iRegistrationStatus =" + regStatus1
											+ " or iRegistrationStatus=" + regStatus2);

							//session1.put("theatres",theatres);
							for (int i = 0; i < subscribers.size(); i++) {
								SignUpSubscriber subscriber = subscribers.get(i);
						%>
						<tr>
							<td><%=subscriber.getsName()%></td>
							<td><%=subscriber.getsEmail()%></td>
							<td><%=subscriber.getsPhoneNumber()%></td>
							<td><%=subscriber.getsAddress()%></td>
							<td><%=subscriber.getiDOB()%></td>
							<%
								if (subscriber.getiRegistrationStatus() == 1) {
							%>
							<td>Active</td>
							<td><a
								href="deactivateSubscriber.action?subscriberID=<%=subscriber.getiSubscriberID()%>">Deactivate</a>
							</td>

							<%
								}

									else {
							%>
							<td>Deactivated</td>
							<td><a
								href="activateSubscriber.action?subscriberID=<%=subscriber.getiSubscriberID()%>">Activate</a>
							</td>
							<%
								}
							%>
						</tr>
						<%
							}
						%>
					</table>


			<!-- Main part ends here -->

			&nbsp;
		</div>
		<div class="increaseHeight">&nbsp;</div>

		<!-- end Image Slider -->
		<!-- end #header -->
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
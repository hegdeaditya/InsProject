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
				<li class="current_page_item"><span><a href="<s:url action='adminHome.action'/> ">Home</a> </span></li>
				<li><a href="<s:url action='manageSeller.action' />">Manage Sellers</a></li>
				<li><a href="<s:url action='manageSubscriber.action'/>" />Manage Subscribers</a></li>
				<li><a href="<s:url action='changepasswordAdmin.action'/>" />Change Password</a></li>
				<li><a href="<s:url action='logout.action' />">Log Out</a></li>
				<!-- <li><a>Welcome <s:property value="#session['sEmail']" /></a></li>  -->
			</ul>
		</div>
		<!-- end #menu -->
		<div id="header">
			<div id="logo">
				<h1>
					<a href="#">Approval Of Regitration Requests</a>
				</h1>
			</div>

		</div>
		<div id="splash">

			<!-- Main part starts Here -->

		
					<s:if test="#session.login != 'true'">
						<jsp:forward page="index.jsp" />
					</s:if>

					<s:if test="hasActionMessages()">
						<div class="errors">
							<s:actionmessage />
						</div>
					</s:if>

					<table border="1" cellpadding="7" align="center">
						<tr>
							<th>Theater Owner</th>
							<th>Email ID</th>
							<th>Phone Number</th>
							<th>Address</th>
							<th>Status</th>

						</tr>
						<%@ page
							import="java.util.ArrayList,edu.iiitb.OnlineMovieTicketBooking.model.*,java.sql.DriverManager,java.sql.ResultSet,java.util.Map,com.opensymphony.xwork2.ActionContext,org.apache.struts2.interceptor.SessionAware"%>
						<%
							Map<String, Object> session1 = ActionContext.getContext()
									.getSession();
							int regStatus = -1;
							ArrayList<SignUpSeller> sellers = SignUpSeller
									.find(" where iRegistrationStatus =" + regStatus);

							//session1.put("theatres",theatres);
							for (int i = 0; i < sellers.size(); i++) {
								SignUpSeller seller = sellers.get(i);
								System.out.println(seller.getsPhoneNumber());
								System.out.println(seller.getsAddress());
						%>
						<tr>
							<td><%=seller.getsName()%></td>
							<td><%=seller.getsEmail()%></td>
							<td><%=seller.getsPhoneNumber()%></td>
							<td><%=seller.getsAddress()%></td>
							<td><a
								href="conformSeller.action?sellerID=<%=seller.getiSellerID()%>">Confirm</a>
							</td>
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
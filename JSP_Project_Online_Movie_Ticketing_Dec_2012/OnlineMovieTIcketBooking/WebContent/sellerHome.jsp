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
<link href="css/screen.css" rel="stylesheet" type="text/css" media="screens"/>
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
				<li class="current_page_item"><span><a
						href="sellerHome.action">Home</a>
				</span>
				</li>
				<li><a href="<s:url action='addTheatre.action' />">Add
						Theatre</a>
				</li>
				<li><a href="changepasswordSeller.action">Change Password</a>
				</li>
				<li><a href="<s:url action='logout.action' />">Log Out</a>
				</li>
				<li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li>You are logged in as:  <s:property value="#session['sEmail']" /> 
				</li>
			</ul>
		</div>
		<!-- end #menu -->
		<div id="header">
			<div id="logo">
				<h1>
					<a href="#">Current Data</a>
				</h1>
			</div>

		</div>
		<div id="splash">

			<!-- Main part starts Here -->

			<div id="pageD">
				<div id="contentD">
					<s:if test="#session.login != 'true'">
						<jsp:forward page="index.jsp" />
					</s:if>
					
					<s:if test="hasActionErrors()">
						<div class="errors">
							<s:actionerror/>
						</div>
					</s:if>
						
					
					<table width="130%" cellpadding="2" cellspacing="1" border="2"
						align="center"  style="font-variant: normal;color: black;">
						<tr align="center">

							<th align="center"><span class="bg">Name Of Theatres</span>
							</th>
							<th align="center"><span class="bg">Add Movie</span>
							</th>
							<th align="center"><span class="bg">Delete Movie</span>
							</th>
							<th align="center"><span class="bg">List Movies</span>
							</th>
						</tr>
						<%@ page
							import="java.util.ArrayList,edu.iiitb.OnlineMovieTicketBooking.model.*,java.sql.DriverManager,java.sql.ResultSet,java.util.Map,com.opensymphony.xwork2.ActionContext,org.apache.struts2.interceptor.SessionAware"%>
						<%
							Map<String, Object> session1 = ActionContext.getContext()
									.getSession();
							int iSellerID = (Integer) session1.get("iSellerID");
							ArrayList<Theatre> theatres = Theatre.find(" where iSellerID="
									+ iSellerID);
							session1.put("theatres", theatres);
							for (int i = 0; i < theatres.size(); i++) {
								Theatre theatre = theatres.get(i);
						%>
						<tr align="center" style="font-size: 15px;">
							<td align="center"><h3 align="center">
									<a>
										<%=theatre.getsName()%> </a>
								</h3></td>
							<td align="center"><a
								href="addMovie.action?theatreID=<%=theatre.getiTheatreID()%>">Add
									Movie</a></td>
							<td align="center"><a
								href="showdeleteMovie.action?theatreID=<%=theatre.getiTheatreID()%>">Delete
									Movie</a></td>
							<td align="center"><a
								href="listMoviesProcessing.action?theatreID=<%=theatre.getiTheatreID()%>">List
									Movies</a></td>


						</tr>

						<%
							}
						%>
					</table>									

				</div>
			</div>

			<!-- ends here -->			
			&nbsp;
		</div>

	</div>
		<div class="increaseHeight">&nbsp;
		</div>
		</div>
		<div class="increaseHeight">&nbsp;
		</div>
		</div>
		<div class="increaseHeightBy250">&nbsp;
		</div>
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
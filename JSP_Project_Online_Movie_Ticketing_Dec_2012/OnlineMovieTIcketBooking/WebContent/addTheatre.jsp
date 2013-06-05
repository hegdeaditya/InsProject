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
				<li><span><a href="sellerHome.action">Home</a> </span>
				</li>
				<li class="current_page_item"><a
					href="<s:url action='addTheatre.action' />">Add Theatre</a>
				</li>
				<li><a href="changepasswordSeller.action">Change Password</a>
				</li>
				<li><a href="<s:url action='logout.action' />">Log Out</a>
				</li>
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
					<a href="#">Add Theatre</a>
				</h1>
			</div>

		</div>
		<div id="splashRegister">

			<!-- Main part starts Here -->


			<s:if test="#session.login != 'true'">
				<jsp:forward page="index.jsp" />
			</s:if>
			<s:form action="addTheatreProcessing.action" method="post"
				validate="true" onsubmit="return validateForm()">


				<table align="center">

					<tr>
						<td><s:textfield name="name" label="Theatre Name *	" /></td>
					</tr>
					<tr>
						<td><s:textfield name="phoneNumber" label="PhoneNumber *	" />
						</td>
					</tr>
					<tr>
						<td><s:textfield name="address" label="Address *	" /></td>
					</tr>
					<tr>
						<td><s:textfield name="city" label="City *	" /></td>
					</tr>
					<tr>
						<td><s:textfield name="state" label="State *	" /></td>
					</tr>
					<tr>
						<td><s:textfield name="numberOfSeates"
								label="Number Of Seates(<= 30 only) *	" /></td>
					</tr>
					<tr>
						<td><s:set name="theme" value="'simple'" scope="page" /></td>
					</tr>
					<tr align="center">
						<table border="1" cellpadding="7" align="center" width="100%">
							<tr>
								<th>Class Name</th>
								<th>Class Price</th>
								<th>Number of Seats(<= 10 per Class)</th>
							</tr>

							<tr>
								<td><s:label name="className1" value="Gold" /></td>
								<td><s:textfield name="classPrice1" /></td>
								<td><s:textfield name="seatsPerClass1" /></td>
							</tr>
							<tr>
								<td><s:label name="className2" value="Silver" /></td>
								<td><s:textfield name="classPrice2" /></td>
								<td><s:textfield name="seatsPerClass2" /></td>
							</tr>
							<tr>
								<td><s:label name="className3" value="Economy" /></td>
								<td><s:textfield name="classPrice3" /></td>
								<td><s:textfield name="seatsPerClass3" /></td>
							</tr>

						</table>
					</tr>
					<tr>
						<s:if test="hasActionErrors()">
							<div class="errors">
								<s:actionerror />
							</div>
						</s:if>
					</tr>
					<tr align="right">
						<td>
							<s:submit value="Submit" />
						</td>
					</tr>
				</table>

			</s:form>

			<!-- ends here -->

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
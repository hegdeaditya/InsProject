<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Movie Ticketing - Change Pasword</title>

<!-- Used for some tables -->

<link href="css/default.css" rel="stylesheet" type="text/css" />

<!-- Movies Slider -->
<script type="text/javascript" src="jquery/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="jquery/jquery.slidertron-0.1.js"></script>
<link href="css/styleWelcome.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="css/screen.css" rel="stylesheet" type="text/css"
	media="screens" />
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
				<li><span><a
						href="sellerHome.action">Home</a> </span>
				</li>
				<li><a href="<s:url action='addTheatre.action' />">Add
						Theatre</a>
				</li>
				<li  class="current_page_item"><a href="changepasswordSeller.action">Change Password</a>
				</li>
				<li><a href="<s:url action='logout.action' />">Log Out</a>
				</li>
				<li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li>You are logged in as: <s:property
						value="#session['sEmail']" />
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
		<div id="splashRegister">

			<!-- Main part starts Here -->


			<s:if test="#session.login != 'true'">
				<jsp:forward page="index.jsp" />
			</s:if>


			<s:actionerror />
			<s:form action="chpwdSeller.action" method="post">

				<table cellspacing="10">
					<tr>
						<td>
							<s:password label="Enter present password" name="passwordold"
							id="myinput" size="20" />
						</td>
					</tr>
					<tr>
						<td>
							<s:password label="Enter new password" name="passwordnew"
							id="myinput" size="20" />
						</td>
					</tr>
					<tr>
						<td>
							<s:password label="Reenter new password" name="passwordagain"
							id="myinput" size="20" />
						</td>
					</tr>
					<tr>
						<td>
							<s:submit name="commandButton" value="Change!" id="myinput"
							align="center" />
						</td>
					</tr>
				</table>
			</s:form>

			<!-- ends here -->
			&nbsp;
		</div>

	</div>
	<div class="increaseHeight">&nbsp;</div>
	</div>
	<div class="increaseHeight">&nbsp;</div>
	</div>
	<div class="increaseHeightBy250">&nbsp;</div>
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
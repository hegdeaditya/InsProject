<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Movie Ticketing - List Movies</title>

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
				<li><a
					href="<s:url action='addTheatre.action' />">Add Theatre</a>
				</li>
				<li class="current_page_item"><a>List Movies</a></li>
				<li><a href="changepasswordSeller.action">Change Password</a>
				</li>
				<li><a href="<s:url action='logout.action' />">Log Out</a>
				</li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li>You are logged in as : <s:property value="#session['sEmail']" />
				</li>
			</ul>
		</div>
		<!-- end #menu -->
		<div id="header">
			<div id="logo">
				<h1>
					<a href="#">Movies List</a>
				</h1>
			</div>

		</div>
		<div id="splashRegister">

			<!-- Main part starts Here -->
			<div>
			
			<table align="center">
				<tr>
					<td>
						<p>	Sorry! No Movies were added for this theatre. </p>
					</td>
				</tr>
				<tr align="center">
					<td align="center">
						<s:form action="addMovieDefault.action">
			
							<s:submit  value="Add Movie" align="center"/>
			
						</s:form>
					</td>
				</tr>
			</table>
			
			</div>

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
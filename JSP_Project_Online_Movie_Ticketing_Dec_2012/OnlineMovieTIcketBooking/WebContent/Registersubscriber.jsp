<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Movie Ticketing</title>



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
				<li><span><span><a href="home.action">Home</a> </span></li>				
				<li class="current_page_item"><a href="newRegistersubscriber.action">Sign Up as Subscriber&nbsp;&nbsp;&nbsp;</a></li>
				<li><a href="newRegisterseller.action">Sign Up Theatre Owner</a></li>
				<li><a href="home.action">Cancel</a></li>				
			</ul>
		</div>
		<!-- end #menu -->
		<div id="header">
			<div id="logo">
				<h1>
					<a href="#">Sign Up</a>
				</h1>
			</div>

		</div>
		<div id="splashRegister">



			<!-- Main Part starts here -->
			
		
		<s:form action="regsub.action" method="post"> 
		<s:if test="hasActionErrors()">
  	 							<div class="errors">
     									 <s:actionerror/>
   									</div>
						</s:if>
		<table width="100%" rules="none" frame="void" >
			<tr>
				<td>
					<s:textfield name="email" label="Email" id="myinput" size="20" />
				</td>				
			</tr>
			<tr>
				<td>
					<s:password name="password" label="Enter Password" id="myinput" size="20" />
				</td>
				
			</tr>
			<tr>
				<td>
					<s:password name="reenterpassword" label="Re-enter Password" id="myinput" size="20" />
				</td>
				
			</tr>
		    <tr>
		    	<td>
					<s:textfield  name="subscribername" label="Subscriber Name" id="myinput" size="20" />
				</td>
		    	
		    </tr>
		    <tr>
		    	<td>
					<s:textfield name="phonenumber" label="Phone number" id="myinput" size="20" />
				</td>
		    	
		    </tr>
		    <tr>
		    	<td>
					<s:textfield name="address" label="Address" id="myinput" size="20" />
				</td>
		    	
		    </tr>
		    <tr>
		    	<td>
					
				</td>
		    	
		    </tr>
		    <tr>
		    	<td>
					&nbsp;<s:submit name="commandButton" value="submit" id="myinput" align="center" />	
				</td>
		    
		    </tr>
		</table>
		
		</s:form>

			<!-- ends here -->

			&nbsp;
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
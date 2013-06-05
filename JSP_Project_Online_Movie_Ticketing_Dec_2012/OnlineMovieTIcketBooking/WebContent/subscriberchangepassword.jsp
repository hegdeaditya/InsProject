<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Movie Ticketing - Change Password</title>



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
						href="<s:url action='subscriberHome.action' />">Home</a> </span></li>
				<li><a href="viewTickets.action">View Tickets</a></li>
				<li class="current_page_item"><a>Change Password</a></li>
				<li><a href="logout.action">Log Out</a></li>
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
					<a href="#">Change Password</a>
				</h1>
			</div>

		</div>
		<div id="splashRegister">



			<!--Main part starts here -->



			<s:if test="#session.login != 'true'">
				<jsp:forward page="index.jsp" />
			</s:if>


			<s:actionerror />
			<s:form action="chpwdSubscriber.action" method="post">
			
				<table cellspacing="10" align="center">
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


					<!-- Main part ends here -->




						&nbsp;</div>
					



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

											<p>
												<img src="images/film-reel2.jpg" width="143" height="143"
										alt="" class="alignleft border" />
											</p>


											<!-- completed here -->




											<p>Sed lacus. Donec lectus. Nullam pretium nibh ut
												turpis. Nam bibendum. In nulla tortor, elementum ipsum.
												Proin imperdiet est. Phasellus dapibus semper urna.
												Pellentesque ornare, orci in felis. Donec ut ante. In id
												eros. Suspendisse lacus turpis, cursus egestas at sem.</p>
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
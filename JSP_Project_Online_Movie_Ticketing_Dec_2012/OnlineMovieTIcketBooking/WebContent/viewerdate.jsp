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
				<li class="current_page_item"><span> <a
						href="<s:url action='home.action' />">Home</a> </span></li>
					
				
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li>You are welcome Guest! 
				</li>
			</ul>
		</div>
		<!-- end #menu -->
		<div id="header">
			<div id="logo">
				<h1>
					<a href="#">Select Date </a>
				</h1>
			</div>

		</div>
		<div id="splashRegister">






			<!--Main part starts here -->

	

			<s:form action="viewerdates.action" method="post">
				
				
				<table cellspacing="10" align="center">
					<tr>
						<td>
							Selected city :
						<s:property value="#session['sCity']" />
						</td>
						
					</tr>
					<tr>
						<td>
							Selected theatre :
						<s:property value="#session['sTheatre']" />
						</td>
						
					</tr>
					<tr>
						<td>
						Selected movie :
						<s:property value="#session['sMovie']" />
						</td>
						
					</tr>
					<tr>
						<td>
							Selected class :
						<s:property value="#session['sClass']" />
						</td>
						
					</tr>
					<tr>
					<td>
							<s:select label="Select date" headerKey="-1" list="dates"
							name="date" />
					</td>
						
					
					</tr>
						<td>
							<s:submit value="Next" onchange="submit()"></s:submit>
						</td>
						
					</tr>
				</table>

			</s:form>



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

								<p>
									<img src="images/film-reel2.jpg" width="143" height="143"
										alt="" class="alignleft border" />
								</p>


								<!-- completed here -->




								<p>Sed lacus. Donec lectus. Nullam pretium nibh ut turpis.
									Nam bibendum. In nulla tortor, elementum ipsum. Proin imperdiet
									est. Phasellus dapibus semper urna. Pellentesque ornare, orci
									in felis. Donec ut ante. In id eros. Suspendisse lacus turpis,
									cursus egestas at sem.</p>
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
					<li><a href="#">Abhilash (MT2012003)</a>
					</li>
					<li><a href="#">Anuj Duggal (MT2012024)</a>
					</li>
					<li><a href="#">Vijay Huddar (MT2012161)</a>
					</li>
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
			<p>
				Copyright (c) 2013 onlinemovieticketing.com. All rights reserved.
				Designed by <a href="http://www.freecsstemplates.org/">IIITBians</a>.
			</p>
		</div>
		<!-- end #footer -->
	</div>
</body>
</html>
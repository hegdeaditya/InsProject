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
<link href="css/styleWelcome.css" rel="stylesheet" type="text/css" media="screen" />
<style type="text/css">
@import "css/slidertron.css";
</style>
<!-- Movies Slider ends -->

<!-- styleIndex.css -->
<link href="css/styleIndex.css" rel="stylesheet" type="text/css" media="screen" />

</head>
<body>
<div id="wrapper">
	<div id="menu">
		<ul>
			<li class="current_page_item"><span><a href="home.action">Home</a></span></li>
			<li><a href="viewer.action">Just Browse</a></li>
			<li><a href="<s:url action='newRegistersubscriber'/> ">Sign Up</a></li>
			
		</ul>
	</div>
	<!-- end #menu -->
	<div id="header">
		<div id="logo">
			<h1><a href="#">Online Movie Ticketing</a></h1>
		</div>
		
	</div>
<div id="splash">
&nbsp;
<!-- Image Slider -->
<!-- Check for its css also -->
<div id="wrapperImage">
	<!-- end #logo -->
	
	<table>
		<tr>
			
			<td>
					<div id="two-columns2">
		<div class="col11">
			<div id="foobar">
				<div class="navigation"> <a href="#" class="first">[ &lt;&lt; ]</a> &nbsp; <a href="#" class="previous">[ &lt; ]</a> &nbsp; <a href="#" class="next">[ &gt; ]</a> &nbsp; <a href="#" class="last">[ &gt;&gt; ]</a> </div>
				<div class="viewer">
					<div class="reel">
						<div class="slide"> <img src="images/1.jpg" alt="" width="1000" height="430"> <span><p> <a href="movie1Trailer">Click here</a> to see Trailer</p></span> </div>
						<div class="slide"> <img src="images/2.jpg" alt="" width="1000" height="430"> <span><p> <a href="movie2Trailer">Click here</a> to see Trailer</p></span></div>
						<div class="slide"> <img src="images/3.jpg" alt="" width="1000" height="430"> <span><p> <a href="movie3Trailer">Click here</a> to see Trailer</p></span> </div>
					</div>
				</div>
			</div>
			<script type="text/javascript">

						$('#foobar').slidertron({
							viewerSelector:			'.viewer',
							reelSelector:			'.viewer .reel',
							slidesSelector:			'.viewer .reel .slide',
							navPreviousSelector:	'.previous',
							navNextSelector:		'.next',
							navFirstSelector:		'.first',
							navLastSelector:		'.last'
						});
						
					</script>
		</div>
		
	</div>
			</td>
			<td></td>
		</tr>
	</table>
	
	

</div>

&nbsp;</div>



<!-- end Image Slider -->
	<!-- end #header -->
	
	<div id="page">	
		<div id="page-bgtop">
			<div id="page-bgbtm">
				<div id="content">
				
				
				
<div class="post">
						<h2 class="title"><a href="#">Welcome to Movie Ticketing </a></h2>
						<div class="entry">



<!-- need to copy here -->

<p><img src="images/film-reel2.jpg" width="143" height="143" alt="" class="alignleft border" /></p>


<!-- completed here -->




<p>The Best place to book movie tickets online. Visit regularly for great offers with discounts.</p>
						</div>

					</div>
					
					<div style="clear: both;">&nbsp;</div>
				</div>
				<!-- end #content -->
				<div id="sidebar">
					
							<h2>Login</h2>
							
							<table align="center">
								<tr>
									<td>
										<s:form action="login.action" method="post" validate="true">
											<s:textfield name="Email" id="Email" label="Email Id" />
											<br>
											<s:password name="Password" id="Password" label="Password" />
											<br>
													<s:if test="hasActionErrors()">
							  	 							<div class="errors">
							     									 <s:actionerror/>
							   									</div>
													</s:if>
							
											<s:submit   value="Submit" align="center" />	 									
										</s:form>	
									
									</td>																		
								</tr>
								<tr align="right">
									<td >
										<a href="forgotpassword.action">Forgot Password?</a>
									</td>
								</tr>
							</table>
						
				</div>
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
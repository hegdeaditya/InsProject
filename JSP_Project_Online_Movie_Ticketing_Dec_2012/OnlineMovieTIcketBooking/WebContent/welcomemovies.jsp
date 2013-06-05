<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by Free CSS Templates
http://www.freecsstemplates.org
-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd"> -->
   <%@taglib uri="/struts-tags" prefix="s" %>
   
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
      
<title>Welcome</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<script type="text/javascript" src="jquery/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="jquery/jquery.slidertron-0.1.js"></script>
<link href="css/styleWelcome.css" rel="stylesheet" type="text/css" media="screen" />
<style type="text/css">
@import "css/slidertron.css";
</style>

<script language="JavaScript" type="text/javascript">

var d=new Date();
var monthname=new Array("January","February","March","April","May","June","July","August","September","October","November","December");

var TODAY = monthname[d.getMonth()] + " " + d.getDate() + ", " + d.getFullYear();



function StartClock12() {
   Time12 = new Date();
   Cur12Hour = Time12.getHours();
   Cur12Mins = Time12.getMinutes();
   Cur12Secs = Time12.getSeconds();
   The12Time = (Cur12Hour > 12) ? Cur12Hour - 12 : Cur12Hour;
   The12Time += ((Cur12Mins < 10) ? ':0' : ':') + Cur12Mins;
   The12Time += ((Cur12Secs < 10) ? ':0' : ':') + Cur12Secs;
   The12Time += (Cur12Hour > 12) ? ' PM': ' AM';
   document.CForm.Clock12.value = The12Time;
   window.status = The12Time;
   setTimeout('StartClock12()',1000);
   }

function StartDate() {
   TDay = new Array('Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday');
   TMonth = new Array('January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December');
   TDate = new Date();
   CurYear = TDate.getYear();
   CurMonth = TDate.getMonth();
   CurDayOw = TDate.getDay();
   CurDay= TDate.getDate();
   TheDate = TDay[CurDayOw] + ', ';
   TheDate += TMonth[CurMonth] + ' ';
   TheDate += CurDay + ', ';
   TheDate += ((CurYear%1900)+1900);
   document.CForm.CDate.value = TheDate;
   }


</script>







<!-- me -->
<script type="text/javascript" src="WebContent/jquery/jquery-1.2.6.min.js"></script>

<style type="text/css">
body {
margin: 0;
font-size:16px;
color: #000000;
font-family:Arial, Helvetica, sans-serif;
}
#sliderWrap {
margin: 0 auto;
width: 300px;
}
#slider {

position: absolute;
background-image:url(images/slider.png);
background-repeat:no-repeat;
background-position: bottom;
width: 300px;
height: 159px;
margin-top: -141px;
}
#slider img {
border: 0;
}
#sliderContent {
margin: 50px 0 0 50px;
position: absolute;
text-align:center;
background-color:#FFFFCC;
color:#333333;
font-weight:bold;
padding: 10px;
}
#header {
margin: 0 auto;
width: 600px;
background-color: #F0F0F0;
height: 200px;
padding: 10px;
}
#openCloseWrap {
position:absolute;
margin: 143px 0 0 120px;
font-size:12px;
font-weight:bold;
}
</style>



</head>
<body    onload="StartClock12(); StartDate();";>

<!-- me  for slide wrap -->

	<script type="text/javascript">
	$(document).ready(function() {
		$(".topMenuAction").click( function() {
			if ($("#openCloseIdentifier").is(":hidden")) {
				$("#slider").animate({ 
					marginTop: "-141px"
					}, 500 );
				$("#topMenuImage").html('<img src="images/open.png" alt="open" />');
				$("#openCloseIdentifier").show();
			} else {
				$("#slider").animate({ 
					marginTop: "0px"
					}, 500 );
				$("#topMenuImage").html('<img src="images/close.png" alt="close" />');
				$("#openCloseIdentifier").hide();
			}
		});  
	});
	</script>
	
	
	
	<div id="sliderWrap">
		<div id="openCloseIdentifier"></div>
		<div id="slider">
			<div id="sliderContent">
				Toll Free : +91-9980962767
			</div>
			<div id="openCloseWrap">
				<a href="#" class="topMenuAction" id="topMenuImage">
					<img src="images/open.png" alt="open" />
				</a>
			</div>
		</div>
	</div>
















<!-- end #header-wrapper -->
<div id="header">
	<div id="logo">
		<h2><marquee behavior="alternate" scrollamount="10" loop="11" width="300"> Cinemaaaas</marquee></h2>
		</div>
	<div id="menu">
			<font align="right" size=5>
					<form name="CForm">
    	 Date : &nbsp;<script language="JavaScript" type="text/javascript">
      document.write(TODAY);	</script>	
			&nbsp;&nbsp;
    		Time :&nbsp;
			<input type="text" name="Clock12" size="12"></h5>
			</form></font>	
			
	
	</div>
	<!-- end #menu -->
</div>
<!-- end #header -->
<hr />
<div id="wrapper">
	<!-- end #logo -->
	<div id="two-columns">
		<div class="col1">
			<div id="foobar">
				<div class="navigation"> <a href="#" class="first">[ &lt;&lt; ]</a> &nbsp; <a href="#" class="previous">[ &lt; ]</a> &nbsp; <a href="#" class="next">[ &gt; ]</a> &nbsp; <a href="#" class="last">[ &gt;&gt; ]</a> </div>
				<div class="viewer">
					<div class="reel">
						<div class="slide"> <img src="images/1.jpg" alt=""> <span><p>Movies1 </p></span> </div>
						<div class="slide"> <img src="images/2.jpg" alt=""> <span><p>Movies2</p></span></div>
						<div class="slide"> <img src="images/3.jpg" alt=""> <span><p>Movies3</p></span> </div>
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
		<div class="col2">
			
			&nbsp;&nbsp;<td > <a href="userlogin" />Login Here !</a> </td>
			<blockquote>&#8220;&nbsp;Movies --- <U>Masthi</u> &nbsp;&#8221;</blockquote>
			&nbsp; &nbsp;&nbsp; &nbsp;<td > <a href="viewerlogin" />Just Browse !</a> </td>
		</div>
	</div>
</div>
<div id="page">
	<div id="page-bgtop">
		<div id="content">
			<div class="post">
				 
				<div class="entry">
 
 
<!.....................................................................................>
<!add the code here>
<iframe width="560" height="315" src="http://www.youtube.com/embed/nEWp0dTrqlk" frameborder="0" allowfullscreen></iframe>

	
	<br />
	
	


<!.......................................................................................>					
				</div>
			</div>
			
		</div>
		<!-- end #content -->
		<div id="sidebar">
			<ul>

				<li>
					<h2>Useful Links </h2>
					<ul>
						
					
	<li>					 
&nbsp; &nbsp;&nbsp; &nbsp;<td > <a href="adminlogin" />Admin Login</a> </td>
</li>
<li>
&nbsp; &nbsp;&nbsp; &nbsp;<td > <a href="sellerlogin" />Seller Login</a> </td>
</li>
					</ul>
				</li>
				
			</ul>
		</div>
		<!-- end #sidebar -->
		<div style="clear: both;">&nbsp;</div>
	</div>
	<!-- end #page -->
	
</div>

<div id="footer">

	<p>Copyright (c) 2011 <i>www.movies.co.in</i> All rights reserved. Best Viewed in IE 6.0 & above </a>.</p>
</div>
<!-- end #footer -->

</body>
</html>



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

<title>Customer Form</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<script type="text/javascript" src="jquery/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="jquery/jquery.slidertron-0.1.js"></script>
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
<style type="text/css">
@import "slidertron.css";
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


</head>
<body    onload="StartClock12(); StartDate();";>
<!-- end #header-wrapper -->
<div id="header">
	<div id="logo">
		<h2><marquee behavior="alternate" scrollamount="10" loop="11" width="300">Movies</marquee></h2>
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
						<div class="slide"> <img src="images/2.jpg" alt=""> <span><p>movie1 </p></span> </div>
						<div class="slide"> <img src="images/1.jpg" alt=""> <span><p>movie2</p></span></div>
						<div class="slide"> <img src="images/3.jpg" alt=""> <span><p>movie3</p></span> </div>
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
			<blockquote>&#8220;&nbsp;Movies --- <U>Magic</u> &nbsp;&#8221;</blockquote>
		</div>
	</div>
</div>
<div id="page">
	<div id="page-bgtop">
		<div id="content">
			<div class="post">
				<h2 class="title" align="center">Register</h2>
				<div class="entry">
 
 
<!.....................................................................................>
<!add the code here>

<s:actionerror />
<s:form action="regsel.action" method="post"> <table cellspacing="10">
	<tr><s:textfield  name="sellername" label="Seller Name" id="myinput" size="20" /></tr>
    <tr><s:password name="password" label="Seller Password" id="myinput" size="20" /></tr>
    <tr><s:textfield name="email" label="Email" id="myinput" size="20" /></tr>
    <tr><s:textfield name="phonenumber" label="Phone number" id="myinput" size="20" /></tr>
    <tr><s:textfield name="address" label="Address" id="myinput" size="20" /></tr>
    <tr><s:submit name="commandButton" value="submit" id="myinput" align="center" />
    
    </table>
   
 <form>

 </form>
</s:form>


<!.......................................................................................>					
				</div>
			</div>
			
		</div>
		<!-- end #content -->
		<div id="sidebar">
			<ul>

				<li>
					
					<ul>
						
					<!-- 	
						<li><a href="newRegister.action?username">New User( Register )</a></li>
						
						 -->
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

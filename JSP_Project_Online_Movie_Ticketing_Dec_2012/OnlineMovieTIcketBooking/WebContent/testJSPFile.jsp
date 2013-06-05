
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by Free CSS Templates
http://www.freecsstemplates.org
Released for free under a Creative Commons Attribution 2.5 License

Name       : Orange Flower  
Description: A two-column, fixed-width design with dark color scheme.
Version    : 1.0
Released   : 20110227

-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<!-- Sticky Note -->

<script type="text/javascript" src="http://code.jquery.com/jquery-latest.pack.js"></script>
<script>

$(document).ready(function() {	

	//select all the a tag with name equal to modal
	$('a[name=modal]').click(function(e) {
		//Cancel the link behavior
		e.preventDefault();
		
		//Get the A tag
		var id = $(this).attr('href');
	
		//Get the screen height and width
		var maskHeight = $(document).height();
		var maskWidth = $(window).width();
	
		//Set heigth and width to mask to fill up the whole screen
		$('#mask').css({'width':maskWidth,'height':maskHeight});
		
		//transition effect		
		$('#mask').fadeIn(1000);	
		$('#mask').fadeTo("slow",0.8);	
	
		//Get the window height and width
		var winH = $(window).height();
		var winW = $(window).width();
              
		//Set the popup window to center
		$(id).css('top',  winH/2-$(id).height()/2);
		$(id).css('left', winW/2-$(id).width()/2);
	
		//transition effect
		$(id).fadeIn(2000); 
	
	});
	
	//if close button is clicked
	$('.window .close').click(function (e) {
		//Cancel the link behavior
		e.preventDefault();
		
		$('#mask').hide();
		$('.window').hide();
	});		
	
	//if mask is clicked
	$('#mask').click(function () {
		$(this).hide();
		$('.window').hide();
	});			
	
});

</script>
<style>
body {
font-family:verdana;
font-size:15px;
}

a {color:#333; text-decoration:none}
a:hover {color:#ccc; text-decoration:none}

#mask {
  position:absolute;
  left:0;
  top:0;
  z-index:9000;
  background-color:#000;
  display:none;
}
  
#boxes .window {
  position:absolute;
  left:0;
  top:0;
  width:440px;
  height:200px;
  display:none;
  z-index:9999;
  padding:20px;
}

#boxes #dialog {
  width:375px; 
  height:203px;
  padding:10px;
  background-color:#ffffff;
}

#boxes #dialog1 {
  width:375px; 
  height:203px;
}

#dialog1 .d-header {
  background:url(images/login-header.png) no-repeat 0 0 transparent; 
  width:375px; 
  height:150px;
}

#dialog1 .d-header input {
  position:relative;
  top:60px;
  left:100px;
  border:3px solid #cccccc;
  height:22px;
  width:200px;
  font-size:15px;
  padding:5px;
  margin-top:4px;
}

#dialog1 .d-blank {
  float:left;
  background:url(images/login-blank.png) no-repeat 0 0 transparent; 
  width:267px; 
  height:53px;
}

#dialog1 .d-login {
  float:left;
  width:108px; 
  height:53px;
}

#boxes #dialog2 {
  background:url(images/notice.png) no-repeat 0 0 transparent; 
  width:326px; 
  height:229px;
  padding:50px 0 20px 25px;
}
</style>



<!-- V Slider -->
<link rel="stylesheet" href="css/styleVSlider.css" />
<link rel="stylesheet" href="css/vslider.css" />
<script type="text/javascript" src="jquery/jquery.js" ></script>
<script type="text/javascript" src="jquery/jquery.vslider.js" ></script>
<script type="text/javascript">
$(function(){

	$("#test").vSlider();
	
	});
</script>




<!-- Welcome Movies Slider -->
<script type="text/javascript" src="jquery/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="jquery/jquery.slidertron-0.1.js"></script>
<link href="css/styleWelcome.css" rel="stylesheet" type="text/css" media="screen" />
<style type="text/css">
@import "css/slidertron.css";
</style>



<!-- Normal -->
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Online Movie Ticketing</title>
<link href="css/styleFinal.css" rel="stylesheet" type="text/css" media="screen" />

</head>


<body>
<div id="wrapper">
	<div id="menu">
		<ul>
			<li class="current_page_item"><span><a href="takeToHome">Home</a></span></li>
			<li><a href="#">Movies</a></li>
			<li><a href="#">About Us</a></li>
			<li><a href="#">Just Browse</a></li>
			<li><a href="takeToWhoWeAre">Who We Are</a></li>
			<li><a href="#dialog2" name="modal">Queries</a></li>
		</ul>
	</div>
	<!-- end #menu -->
	
	<div id="header">
		<div id="logo">
			<h1><a href="#">Movie Ticketing</a></h1>
		</div>
		<div id="search">
			<form method="get" action="">
				<fieldset>
					<!-- <input type="text" name="s" id="search-text" size="15" value="enter keywords here..." />
					<input type="submit" id="search-submit" value="GO" />
					 -->
				</fieldset>
			</form>
		</div>
	</div>
	
	
	<div id="splash">
	<div id="two-columns">
	<div class="col1">
			<div id="foobar">
				<div class="navigation"> <a href="#" class="first">[ &lt;&lt; ]</a> &nbsp; <a href="#" class="previous">[ &lt; ]</a> &nbsp; <a href="#" class="next">[ &gt; ]</a> &nbsp; <a href="#" class="last">[ &gt;&gt; ]</a> </div>
				<div class="viewer">
					<div class="reel">
						<div class="slide"> <a href="trailer1"> <img src="images/1.jpg" alt=""></a> <span><p>Movies1 </p></span> </div>
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
	</div>
		
	
	
	<!-- 
	
	
<ul id="test">
    <li><a href="http://http://vandelaydesign.com/blog/weekly-newsletter/"><img src="images/image_1.jpg" alt="" width="100%"/></a> <span>Pro-Combo</span> </li>
    <li><a href="http://vandelaydesign.com/blog/weekly-newsletter/"><img src="images/image_2.jpg" alt="" width="100%"/></a> <span> Releases Jan 31 </span></li>
    <li><a href="http://vandelaydesign.com/blog/weekly-newsletter/"><img src="images/image_3.jpg" alt="" width="100%"/></a></li>
    <li><a href="http://vandelaydesign.com/blog/weekly-newsletter/"><img src="images/image_4.jpg" alt="" width="100%"/></a></li>
  <!--   <li><a href="http://vandelaydesign.com/blog/weekly-newsletter/"><img src="images/image_5.jpg" alt="" /></a></li>
    <li><a href="http://vandelaydesign.com/blog/weekly-newsletter/"><img src="images/image_6.jpg" alt="" /></a></li>
  
</ul>
 -->
	
	&nbsp;</div>
	<!-- end #header -->
	<div id="page">
		<div id="page-bgtop">
			<div id="page-bgbtm">
				<div id="content">
					<div class="post">
						<h2 class="title"><a href="#">Welcome to Online Movie Ticketing </a></h2>
						<div class="entry">
							<p><img src="images/film-reel2.jpg" width="143" height="143" alt="" class="alignleft border" />This is <strong>Movie Ticketing </strong>, a free, fully standards-compliant, authorized ticket booking website. You can now enjoy the combo offers with discount on tickets this Valentine.</p>
							<p>Online Movie Ticketing takes care of your interests. Make your experience realistic with our service.</p>
						</div>
						
						<!-- 
						<p class="meta">Posted by <a href="#">Someone</a> on March 10, 2008
							&nbsp;&bull;&nbsp; <a href="#" class="comments">Comments (64)</a> &nbsp;&bull;&nbsp; <a href="#" class="permalink">Full article</a></p>
						 -->
					</div>
					<!-- 
					<div class="post">
						<h2 class="title"><a href="#">Lorem ipsum sed aliquam</a></h2>
						<div class="entry">
							<p><img src="images/img07.jpg" width="143" height="143" alt="" class="alignleft border" />Sed lacus. Donec lectus. Nullam pretium nibh ut turpis. Nam bibendum. In nulla tortor, elementum vel, tempor at, varius non, purus. Mauris vitae nisl nec metus placerat consectetuer. Donec ipsum. Proin imperdiet est. Phasellus <a href="#">dapibus semper urna</a>. Pellentesque ornare, consectetuer nisl felis ac diam.</p>
						</div>
						<p class="meta">Posted by <a href="#">Someone</a> on March 8, 2008
							&nbsp;&bull;&nbsp; <a href="#" class="comments">Comments (64)</a> &nbsp;&bull;&nbsp; <a href="#" class="permalink">Full article</a></p>
					</div>
					<div class="post">
						<h2 class="title"><a href="#">Phasellus pellentesque turpis </a></h2>
						<div class="entry">
							<p><img src="images/img08.jpg" width="143" height="143" alt="" class="alignleft border" />Sed lacus. Donec lectus. Nullam pretium nibh ut turpis. Nam bibendum. In nulla tortor, elementum vel, tempor at, varius non, purus. Mauris vitae nisl nec metus placerat consectetuer. Donec ipsum. Proin imperdiet est. Pellentesque ornare, orci in consectetuer hendrerit, urna elit eleifend nunc.</p>
						</div>
						<p class="meta">Posted by <a href="#">Someone</a> on March 8, 2008
							&nbsp;&bull;&nbsp; <a href="#" class="comments">Comments (64)</a> &nbsp;&bull;&nbsp; <a href="#" class="permalink">Full article</a></p>
					</div>
					
					-->
					<div style="clear: both;">&nbsp;</div>
				</div>
				<!-- end #content -->
				<div id="sidebar">
					<ul>
						<li>
							<h2>Login</h2>
							<div class="post">
								<p>    login credentials here</p>
							</div>
							<p>Mauris vitae nisl nec metus placerat perdiet est. Phasellus dapibus semper consectetuer hendrerit.</p>
						</li>
						<!-- <li>
							<h2>Categories</h2>
							<ul>
								<li><a href="#">Aliquam libero</a></li>
								<li><a href="#">Consectetuer adipiscing elit</a></li>
								<li><a href="#">Metus aliquam pellentesque</a></li>
								<li><a href="#">Suspendisse iaculis mauris</a></li>
								<li><a href="#">Urnanet non molestie semper</a></li>
								<li><a href="#">Proin gravida orci porttitor</a></li>
							</ul>
						</li>
						<li>
							<h2>Blogroll</h2>
							<ul>
								<li><a href="#">Aliquam libero</a></li>
								<li><a href="#">Consectetuer adipiscing elit</a></li>
								<li><a href="#">Metus aliquam pellentesque</a></li>
								<li><a href="#">Suspendisse iaculis mauris</a></li>
								<li><a href="#">Urnanet non molestie semper</a></li>
								<li><a href="#">Proin gravida orci porttitor</a></li>
							</ul>
						</li>
						<li>
							<h2>Archives</h2>
							<ul>
								<li><a href="#">Aliquam libero</a></li>
								<li><a href="#">Consectetuer adipiscing elit</a></li>
								<li><a href="#">Metus aliquam pellentesque</a></li>
								<li><a href="#">Suspendisse iaculis mauris</a></li>
								<li><a href="#">Urnanet non molestie semper</a></li>
								<li><a href="#">Proin gravida orci porttitor</a></li>
							</ul>
						</li>
						 -->
					</ul>
				</div>
				<!-- end #sidebar -->
				
					<div id="boxes">
			
					<!-- Start of Sticky Note -->
					<div id="dialog2" class="window" style="color: black" align="center">
					<br/>
					<br/>	  For any queries, please call <b>1800-22003300</b>. It can also be used to confirm the status of your ticket.  <br/><br/>
					<p align="centre"><input type="button"  value="Close it" class="close" align="centre"/></p>
					</div>
				<!-- End of Sticky Note -->



<!-- Mask to cover the whole screen -->
  <div id="mask"></div>
</div>
				
				
				<div style="clear: both;">&nbsp;</div>
			</div>
		</div>
	</div>
	<!-- end #page -->
</div>
<div id="footer-wrapper">
	<div id="three-columns">
		<div id="column1">
			<h2>Our Partners</h2>
			<ul>
				<li><a href="#">Team1</a></li>
				<li><a href="#">Team2</a></li>
			</ul>
		</div>
		<div id="column2">
			<h2>Sponsors</h2>
			<ul>
				<li><a href="#">Aliquam libero</a></li>
				<li><a href="#">Consectetuer adipiscing elit</a></li>
			</ul>
		</div>
		<div id="column3">
			<h2>Achievers</h2>
			<ul>
				<li><a href="#">Aliquam libero</a></li>
				<li><a href="#">Consectetuer adipiscing elit</a></li>
			</ul>
		</div>
	</div>
	<div id="footer">
		<p>Copyright (c) 2012 OnlineMovieTicketing.com. All rights reserved. Design by <a href="http://www.freecsstemplates.org/">JSP Students ( Team - 1 )</a>.</p>
	</div>
	<!-- end #footer -->
</div>
</body>
</html>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Online Movie Ticketing</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="default.css" rel="stylesheet" type="text/css" />
<style type="text/css">
.style1 {
	color: #FFFFFF;
}
</style>
<STYLE TYPE="text/css">
<!--
a:hover{background-color:#BAF27E;}
-->
</STYLE>


</head>
<body>
<div id="header">
	<div id="logo">
		<h1 class="style1">Movie Ticketing</h1>
		<h2>perfect place to book tickets</h2>
	</div>
	<div id="search">
	</div>
</div>

<div id="menu">
	<ul>
        <li><a href="<s:url action='sellerHome.action' />" >Home</a></li>
		<li><a href="<s:url action='logout.action' />" >Logout</a></li>		
	</ul>
</div>
<hr />
<div id="page">
	<div id="content">
		<div>
			<h1 class="title">Movie Added Successfully!!!</h1>
			
<s:form action="addMovieDefault.action">

<s:submit  value="Click To add  more Movies" align="center"/>

</s:form>
		</div>
	</div>
</div>
<hr />
<div id="footer">
	<p id="legal">Copyright © 2011 OnlineMovieTicketing.com All Rights Reserved | Designed by <a href="http://www.freecsstemplates.org/">Free CSS Templates</a></p>
</div>	
</body>
</html>
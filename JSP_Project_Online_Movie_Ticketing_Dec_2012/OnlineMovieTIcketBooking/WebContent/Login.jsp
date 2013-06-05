<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Sanjeevani</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="default.css" rel="stylesheet" type="text/css" />
<style type="text/css">
.style1 {
	color: #FFFFFF;
}
</style>
</head>
<body>
<div id="header">
	<div id="logo">
		<h1 class="style1">Movie Ticketing</h1>
		<h2>perfect place to book tickets</h2>
	</div>
	<div id="search">
		<form id="searchform" method="get" action="">
			<fieldset>
			<legend>Search</legend>
			&nbsp;
			</fieldset>
		</form>
	</div>
</div>
<div id="menu">
	<ul>
	<li ><a href="<s:url action='signUpSeller.action' />" >Sign Up</a></li>
	</ul>
</div>
<hr />
<div id="page">
	<div id="content">
		<div>
			<h1 class="title">Login</h1>
			
				<p>
				
			
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
				
				
				
				
				
				
				
				
				</p>
		</div>
		
	</div>
</div>
<hr />
<div id="footer">
	<p id="legal">Copyright © 2011 OnlineMovieTicketing.com All Rights Reserved | Designed by <a href="http://www.freecsstemplates.org/">Free CSS Templates</a></p>
</div>		
</body>
</html>





<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Tickets</title>
<link href="default.css" rel="stylesheet" type="text/css" />
<style type="text/css">
.style1 {
	color: #FFFFFF;
}
</style>
<STYLE TYPE="text/css">
<!--
a:hover {
	background-color: #BAF27E;
}
-->
</STYLE>
</head>
<body>
	<div id="header">
		<div id="logo">The tickets booked by you are:</div>
	</div>


	<div id="page">
		<div id="content">
			<table border="1" cellpadding="7">
				<tr>
					<th>TicketID</th>
					<th>Date</th>
					<th>Show Time</th>
					<th>Total Money Paid</th>
					<th>Cancel Booking</th>
				</tr>
				<%@ page
					import="java.util.ArrayList,edu.iiitb.OnlineMovieTicketBooking.model.*"%>
				<%
					ArrayList<Theatre> theatres = (ArrayList<Theatre>) request
							.getAttribute("theatres");
					for (int i = 0; i < theatres.size(); i++) {
						Theatre theatre = theatres.get(i);
				%>
				<tr>
					<td><%=theatre.getsName()%></td>
					<td><a
						href="edit.action?theatreID=<%=theatre.getiTheatreID()%>">Edit
							Theatre</a>
					</td>
					<td><a
						href="addMovie.action?theatreID=<%=theatre.getiTheatreID()%>">Add
							Movie</a>
					</td>
					<td><a
						href="deleteMovie.action?theatreID=<%=theatre.getiTheatreID()%>">Delete
							Movie</a>
					</td>
					<td><a
						href="listMovies.action?theatreID=<%=theatre.getiTheatreID()%>">List
							Movies</a>
					</td>
					<td>
				</tr>

				<%
					}
				%>
			</table>
		</div>
	</div>
</body>
</html>
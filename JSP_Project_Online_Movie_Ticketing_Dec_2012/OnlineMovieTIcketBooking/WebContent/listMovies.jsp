<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Movie Ticketing</title>

<!-- Used for some tables -->

<link href="css/default.css" rel="stylesheet" type="text/css" />

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
				<li><span><a href="sellerHome.action">Home</a> </span>
				</li>
				<li><a
					href="<s:url action='addTheatre.action' />">Add Theatre</a>
				</li>
				<li class="current_page_item"><a>List Movies</a></li>
				<li><a href="changepasswordSeller.action">Change Password</a>
				</li>
				<li><a href="<s:url action='logout.action' />">Log Out</a>
				</li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li>You are logged in as : <s:property value="#session['sEmail']" />
				</li>
			</ul>
		</div>
		<!-- end #menu -->
		<div id="header">
			<div id="logo">
				<h1>
					<a href="#">Movies List</a>
				</h1>
			</div>

		</div>
		<div id="splash">

			<!-- Main part starts Here -->




			<div id="pageD">
				<div id="contentD">
					<s:if test="#session.login != 'true'">
						<jsp:forward page="Login.jsp" />
					</s:if>

					<table border="1" cellpadding="7">
						<tr>
							<th>Movie Name</th>
							<th>ScreeningStartDate</th>
							<th>ScreeningEndDate</th>
							<th>ShowTiming1</th>
							<th>ShowTiming2</th>
							<th>ShowTiming3</th>
							<th>ShowTiming4</th>
						</tr>
						<%@ page
							import="java.util.ArrayList,edu.iiitb.OnlineMovieTicketBooking.model.*,java.sql.DriverManager,java.sql.ResultSet,java.util.Map,com.opensymphony.xwork2.ActionContext,org.apache.struts2.interceptor.SessionAware"%>
						<%
							Map<String, Object> session1 = ActionContext.getContext()
									.getSession();
							int iTheatreID = (Integer) session1.get("theatreID");

							String selectionModifier = " where iTheaterID=" + iTheatreID + ";";
							ArrayList<Movies> movies = MoviesDAO.find(selectionModifier);
							session1.put("movies", movies);
							for (int i = 0; i < movies.size(); i++) {
								Movies movie = movies.get(i);
						%>
						<tr>
							<td><%=movie.getsName()%></td>
							<td><%=movie.getdScreeningStartDate()%></td>
							<td><%=movie.getdScreeningEndDate()%></td>
							<td><%=movie.gettShowTiming1()%></td>
							<td><%=movie.gettShowTiming2()%></td>
							<td><%=movie.gettShowTiming3()%></td>
							<td><%=movie.gettShowTiming4()%></td>
							<td><a
								href="deleteMovie.action?IDnew=<%=movie.getImovieID()%>">Delete
									Movie</a></td>
							<td>
						</tr>

						<%
							}
						%>
					</table>

				</div>
			</div>




			<!-- ends here -->

			<!-- Just Trying 
			
			<table class="corner">
			<tr>

			<td width="34" align="left" valign="top"><img src="images/trans.png" width="34" height="1" alt="" /></td>
            <td align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="50" align="left" valign="top" class="trebuchet36N704416">Upload Sound Clip<br />                  <img src="images/img_headdingborderbottom.gif" width="709" height="2" alt="" /></td>
              </tr>
              <tr>
                <td align="right" valign="top" style="padding-top:35px"><table width="731" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="731" align="left" valign="top"><img src="images/img_grid_top.gif" width="100%" height="7" alt="" /></td>
                  </tr>
                  <tr>
                    <td align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0" class="grid">
                      <tr class="headercolor">
                        <td width="195" align="left" valign="top"><a href="#">Clip upload By</a></td>
                        <td width="251" align="left" valign="top"><a href="#">Upload Clip</a></td>
                        <td width="148" align="left" valign="top"><a href="#">Country</a></td>
                        <td width="98" align="center" valign="top">Delete</td>
                      </tr>
                      <tr>
                        <td align="left" valign="top">kamal Kishore</td>
                        <td align="left" valign="top"><a href="#">Sound Clip286970859690.caf</a></td>
                        <td align="left" valign="top">India</td>
                        <td align="center" valign="middle"><a href="#">Delete</a></td>
                      </tr>
                      <tr class="row">
                        <td align="left" valign="top">kamal Kishore</td>
                        <td align="left" valign="top"><a href="#">Sound Clip286970859690.caf</a></td>
                        <td align="left" valign="top">India</td>
                        <td align="center" valign="middle"><a href="#">Delete</a></td>
                      </tr>
                      <tr>
                        <td align="left" valign="bottom">kamal Kishore</td>
                        <td align="left" valign="top"><a href="#">Sound Clip286970859690.caf</a></td>
                        <td align="left" valign="top">India</td>
                        <td align="center" valign="middle"><a href="#">Delete</a></td>
                      </tr>
                       <tr class="row">
                        <td align="left" valign="top">kamal Kishore</td>
                        <td align="left" valign="top"><a href="#">Sound Clip286970859690.caf</a></td>
                        <td align="left" valign="top">India</td>
                        <td align="center" valign="middle"><a href="#">Delete</a></td>
                      </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td align="left" valign="top"><img src="images/img_grid_bottom.gif" width="100%" height="6" alt="" /></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table>
        
        -->
			<!-- Just Trying ends -->



			<!-- Just TRying begins 2 
			<table>
				<tr>
					<td height="50" align="left" valign="top"
						class="trebuchet36N704416">Upload Sound Clip<br /> <img
						src="images/img_headdingborderbottom.gif" width="709" height="2"
						alt="" />
					</td>
				</tr>
				<tr>
					<td align="right" valign="top" style="padding-top: 35px"><table
							width="731" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="731" align="left" valign="top"><img
									src="images/img_grid_top.gif" width="100%" height="7" alt="" />
								</td>
							</tr>
							<tr>
								<td align="left" valign="top"><table width="100%"
										border="0" cellspacing="0" cellpadding="0" class="grid">
										<tr class="headercolor">
											<td width="195" align="left" valign="top"><a href="#">Clip
													upload By</a>
											</td>
											<td width="251" align="left" valign="top"><a href="#">Upload
													Clip</a>
											</td>
											<td width="148" align="left" valign="top"><a href="#">Country</a>
											</td>
											<td width="98" align="center" valign="top">Delete</td>
										</tr>
										<tr>
											<td align="left" valign="top">kamal Kishore</td>
											<td align="left" valign="top"><a href="#">Sound
													Clip286970859690.caf</a>
											</td>
											<td align="left" valign="top">India</td>
											<td align="center" valign="middle"><a href="#">Delete</a>
											</td>
										</tr>
										<tr class="row">
											<td align="left" valign="top">kamal Kishore</td>
											<td align="left" valign="top"><a href="#">Sound
													Clip286970859690.caf</a>
											</td>
											<td align="left" valign="top">India</td>
											<td align="center" valign="middle"><a href="#">Delete</a>
											</td>
										</tr>
										<tr>
											<td align="left" valign="bottom">kamal Kishore</td>
											<td align="left" valign="top"><a href="#">Sound
													Clip286970859690.caf</a>
											</td>
											<td align="left" valign="top">India</td>
											<td align="center" valign="middle"><a href="#">Delete</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td align="left" valign="top"><img
									src="images/img_grid_bottom.gif" width="100%" height="6" alt="" />
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
-->
			<!-- Just TRying 2 ends -->


			&nbsp;
		</div>
		<div class="increaseHeight">&nbsp;</div>

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
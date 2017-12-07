<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="yeohangout.mysql.MyUtils"%>
<%@ page import="yeohangout.javabeans.UserAccount"%>
<%@ page import="yeohangout.javabeans.Reservation" %>
<%@ page import="yeohangout.mysql.MySQLAccess" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="yeohangout.mysql.ReservationUtils" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="yeohangout.javabeans.IncludeAndLeg"%>
<%@ page import="yeohangout.mysql.MyUtils"%>
	
	<!-- HEADER -->
	<%@ include file="../dashboard-customer/customer_header.jsp"%>
	
	
	<%
		UserAccount loginedEmployee = MyUtils.getLoginedUser(MyUtils.getSession());
	%>
	
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
		
				<ul class="nav nav-sidebar">
					<li><a data-toggle="modal" href="${pageContext.request.contextPath}/dashboard-customer/customer_mypage.jsp" >Overview</a></li>
					<li><a data-toggle="modal" href="${pageContext.request.contextPath}/currentReservationServlet?userID=<%= loginedEmployee.getAccountNo() %>" >Current Reservation</a></li>
        				<li class="active"><a data-toggle="modal" href="${pageContext.request.contextPath}/everyReservationServlet?userID=<%= loginedEmployee.getAccountNo() %>" >All of Reservations History</a></li>
					<li><a data-toggle="modal" href="${pageContext.request.contextPath}/flightSuggestion?userID=<%= loginedEmployee.getAccountNo() %>">View Flight Suggestion</a></li>
					<li><a href="${pageContext.request.contextPath}/get-customer-auction?userID=<%= loginedEmployee.getAccountNo() %>">View Auction</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="container-fluid bg-gray text-center">
	
				<h2> <%= loginedEmployee.getUserID()%>'s Reservation</h2>
					<table class="table">
						<thead class="table-inverse">
							<tr>
								<td>Reservation No.</td>
								<td>Reservation Date</td>
								<td>Booking Fee </td>
								<td>Total Fare </td>
								<td>Itinerary</td>
							</tr>
						</thead>
						
						<tbody>
							<%
								ArrayList<Reservation> reservationList = (ArrayList<Reservation>)request.getAttribute("cu_every_reservations"); 
							
								
								for (int i=0; i<reservationList.size(); i++){
									int resrNo = reservationList.get(i).getResrNo();
									
									ArrayList<IncludeAndLeg> itineraries = reservationList.get(i).getItineraries();
										
							%>
							<tr>
								<td> <%= resrNo %> </td>
								<td> <%= reservationList.get(i).getResrDate() %> </td>
								<td> <%= reservationList.get(i).getBookingFee() %> </td>
								<td> <%= reservationList.get(i).getTotalFare() %> </td>
								<td>
								<%
											session.setAttribute("iter_count", i);
											session.setAttribute("itineryList", itineraries);
				        			%>
								<a data-toggle="modal" data-target="#viewItinerary-<%= i %>" tabindex=i>View Itinery</a>
								<% System.out.println(resrNo); %>
								<%@ include file="../dashboard-customer/ViewItinerary.jsp" %>
								</td>
							</tr>
							 <%
								
								}
							 %>
						 
					 	</tbody>
					 </table>
				 </div>
	 		</div>
		</div>
	</div>
	
	
					
	<!-- Footer -->
<%@ include file="../dashboard-customer/customer_footer.jsp"%>
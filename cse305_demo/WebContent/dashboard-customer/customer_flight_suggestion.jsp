<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="yeohangout.javabeans.UserAccount" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="yeohangout.javabeans.Leg" %>
<%@ page import="yeohangout.javabeans.Flight" %>
<%@ page import="yeohangout.mysql.MyUtils"%>
	
<!-- HEADER -->
<%@ include file="../dashboard-customer/customer_header.jsp"%>



<!-- 
Computing the best selling flights and then listing those flights from them which the customer has not yet taken, 
or the best selling flights that corresponds to the cities customers visit often/last visited etc.
You have to come up with a certain heuristic based on customer's past reservations and then list the best flights for them. 
-->

<%
		UserAccount loginedUser = MyUtils.getLoginedUser(MyUtils.getSession());
%>
					

<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li><a data-toggle="modal" href="${pageContext.request.contextPath}/dashboard-customer/customer_mypage.jsp" >Overview</a></li>
					<li><a data-toggle="modal" href="${pageContext.request.contextPath}/currentReservationServlet?userID=<%= loginedUser.getAccountNo() %>" >Current Reservation</a></li>
					<li><a data-toggle="modal" href="${pageContext.request.contextPath}/everyReservationServlet?userID=<%= loginedUser.getAccountNo() %>" >All of Reservations History</a></li>
        				<li class="active"><a data-toggle="modal" href="${pageContext.request.contextPath}/flightSuggestion?userID=<%= loginedUser.getAccountNo() %>">View Flight Suggestion</a></li>
				</ul>
			</div>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="container-fluid bg-gray text-center">
					
					<h1> Flight Suggestion for <%=loginedUser.getUserID()%></h1>
					
					<h2> SUGGESTED LEG BASED ON YOUR ARRIVAL DATA</h2>
					<table class="table">
						<thead>
							<tr>
								<td>Airline ID</td>
								<td>Flight No</td>
								<td>Depart Airport</td>
								<td>Depart Time</td>
								<td>Arrive Airport</td>
								<td>Arrival Time</td>
							</tr>
						</thead>
						<tbody>
						<% ArrayList<Leg> legs = (ArrayList<Leg>)request.getAttribute("legs"); 
							for(Leg leg : legs){
						%>
								<tr>
									<td> <%=leg.getAirlineID() %> </td>
									<td> <%=leg.getFlightNo() %> </td>
									<td> <%=leg.getDepAirportID() %></td>
									<td> <%=leg.getDepDate() %></td>
									<td> <%=leg.getArrAirportID() %></td>
									<td> <%=leg.getArrDate() %> </td>
									<td> <button>Make a Reservation</button></td>
								</tr>
						<%
							}
						%>
						
						</tbody>
					</table>
					
					<h2> SUGGESTED FLIGHT FROM BEST FLIGHT, BUT YOU HAVE NEVER TAKEN</h2>
					<table class="table">
						<thead>
							<tr>
								<td>Airline ID</td>
								<td>Flight No</td>
							</tr>
						</thead>
						<tbody>
						<% ArrayList<Flight> flights = (ArrayList<Flight>)request.getAttribute("flights"); 
							for(Flight flight : flights){
						%>
								<tr>
									<td> <%=flight.getAirlineID() %> </td>
									<td> <%=flight.getFlightNumber() %> </td>
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



<!-- FOOTER -->
<%@ include file="../dashboard-customer/customer_footer.jsp"%>

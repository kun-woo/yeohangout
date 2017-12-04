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

	<!-- HEADER -->
	<%@ include file="../header.jsp"%>
	
	
	<div class="container-fluid bg-gray text-center">
	<%
		UserAccount loginedUser = MyUtils.getLoginedUser(MyUtils.getSession());
	%>
	
	<h2> <%= loginedUser.getUserID()%>'s Reservation</h2>
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
			
			<% ArrayList<Reservation> reservationList = (ArrayList<Reservation>)request.getAttribute("cu_reservations"); 
	
				for (int i=0; i<reservationList.size(); i++){
					int resrNo = reservationList.get(i).getResrNo();
					
					/* ArrayList<IncludeAndLeg> itineraries = IncludeUtils.searchIncludesAndLegByResrNo(request.getCon, resrNo, true);
					 */
					ArrayList<IncludeAndLeg> itineraries = reservationList.get(i).getItineraries();
					if(itineraries.size()!=0){
					
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
					<a data-toggle="modal" data-target="#viewCurrentItinerary-<%= i %>" tabindex=i><span class="glyphicon glyphicon-user"></span>View Itinery</a>
					
					
					<%@ include file="../viewCurrentItinerary.jsp" %>
					</td>
				</tr>
			 <%
				}
				}
			 %>
		 
		 	</tbody>
		 </table>
	 </div>
	 
	
					
	<!-- Footer -->
	<%@ include file="../footer.jsp"%>
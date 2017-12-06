<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="yeohangout.javabeans.IncludeAndLeg"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="yeohangout.mysql.IncludeUtils"%>
<%@ page import="java.sql.Connection" %>


<div class="modal fade" id="viewItinerary-<%= session.getAttribute("iter_count") %>" role="dialog">
		<div class="modal-dialog modal-lg">
			<!-- Modal content-->
			
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4> Itinerary </h4>
				</div>
				<div class="modal-body">
					<div class="container-fluid bg-gray text-center">
						
						
						<h2> Itinerary</h2>
							<table class="table">
								<thead class="table-inverse">
									<tr>
										<td>Airline ID</td>
										<td>Flight No </td>
										<td>LegNo</td>
										<td>Resrv Date</td>
										<td>Departure</td>
										<td>Departure Time</td>
										<td>Arrival</td>
										<td>Arrival Time</td>
									</tr>
								</thead>
								
								<tbody>
								<%
									
									ArrayList<IncludeAndLeg> itineraryList = (ArrayList<IncludeAndLeg>)session.getAttribute("itineryList");
									
									for(int j=0; j<itineraryList.size(); j++){
										
								%>
								
									<tr>
										<td> <%= itineraryList.get(j).getInclude().getAirlineID() %> </td>
										<td> <%= itineraryList.get(j).getInclude().getFlightNo() %> </td>
										<td> <%= itineraryList.get(j).getInclude().getLegNo() %> </td>
										<td> <%= itineraryList.get(j).getInclude().getDate() %> </td>
										<td> <%= itineraryList.get(j).getLeg().getDepAirportID()  %> </td>
										<td> <%= itineraryList.get(j).getLeg().getDepDate()  %> </td>
										<td> <%= itineraryList.get(j).getLeg().getArrAirportID()  %> </td>
										<td> <%= itineraryList.get(j).getLeg().getArrDate()  %> </td>
									</tr>
									
								 <%
									}
								 %>
							 
							 	</tbody>
							 </table>
					</div>
				<div class="modal-footer">
				</div>
			</div>
		</div>
	</div>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal fade" id="addFlight" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4> ADD FLIGHT </h4>
				</div>
				<div class="modal-body">
					<div class="container-fluid bg-gray text-center">
						<form role="form" action="addFlight" method="POST">
							<div class="form-group">
								<div class="input-group">
									<input type="text" class="form-control" id="airline_id" name = "airlineID"
										placeholder="Airline ID"> <span class="input-group-addon">
										<span class="glyphicon glyphicon-user"></span>
									</span>
								</div>
							</div>
							
							<!-- Flight No -->
							<div class="form-group">
								<div class="input-group">
									<input type="number" class="form-control" id="flight_no" name = "flightNo"
										placeholder="Flight Number"> <span class="input-group-addon">
										<span class="glyphicon glyphicon-lock"></span>
									</span>
								</div>
							</div>
							<!-- Number of Seat -->
							<div class="form-group">
								<div class="input-group">
									<input type="number" class="form-control" id="number_of_seats" name = "numberOfSeats"
										placeholder="Number of Seats"> <span class="input-group-addon">
										<span class="glyphicon glyphicon-lock"></span>
									</span>
								</div>
							</div>
							<!-- Days Operating -->
							<!--  I will change this section to check boxes -->
							<div class="form-group">
								<div class="input-group">
									<input type="text" class="form-control" id="days_op" name = "daysOp"
										placeholder="Days Operating  [7 digits - work : 1, rest : 0 ex) 0100110]"> <span class="input-group-addon">
										<span class="glyphicon glyphicon-lock"></span>
									</span>
								</div>
							</div>
							
							
							<button type="submit" class="btn btn-block">
								ADD Flight<span class="glyphicon glyphicon-log-in"></span>
							</button>
							
						</form>
					</div>
				<div class="modal-footer">
				<button type="submit" class="btn btn-default pull-left">
					<span class="glyphicon glyphicon-remove"></span> Cancel
				</button>

				</div>
			</div>
		</div>
	</div>
</div>
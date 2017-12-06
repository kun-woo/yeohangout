<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="modal fade" id="addAirline" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4> Add Airline </h4>
				</div>
				<div class="modal-body">
					<div class="container-fluid bg-gray text-center">
						<form role="form" action="addAirline" method="POST">
							<!-- Airline ID -->
							<div class="form-group">
								<div class="input-group">
									<input type="text" class="form-control" id="airline_id" name = "airlineID"
										placeholder="Airline ID"> <span class="input-group-addon">
										<span class="glyphicon glyphicon-user"></span>
									</span>
								</div>
							</div>
							<!-- Airline Name -->
							<div class="form-group">
								<div class="input-group">
									<input type="text" class="form-control" id="airline_name" name = "airlineName"
										placeholder="Airline Name"> <span class="input-group-addon">
										<span class="glyphicon glyphicon-lock"></span>
									</span>
								</div>
							</div>
							
							<button type="submit" class="btn btn-block">
								ADD Airline<span class="glyphicon glyphicon-log-in"></span>
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

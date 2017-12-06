<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal fade" id="addAirport" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4> Add Airport </h4>
				</div>
				<div class="modal-body">
					<div class="container-fluid bg-gray text-center">
						<form role="form" action="addAirport" method="POST">
							<!-- Airport ID -->
							<div class="form-group">
								<div class="input-group">
									<input type="text" class="form-control" id="airport_id" name = "airportID"
										placeholder="Airport ID"> <span class="input-group-addon">
										<span class="glyphicon glyphicon-user"></span>
									</span>
								</div>
							</div>
							<!-- Airport Name -->
							<div class="form-group">
								<div class="input-group">
									<input type="text" class="form-control" id="airport_name" name = "airportName"
										placeholder="Airport Name"> <span class="input-group-addon">
										<span class="glyphicon glyphicon-lock"></span>
									</span>
								</div>
							</div>
							
							<!-- City -->
							<div class="form-group">
								<div class="input-group">
									<input type="text" class="form-control" id="airport_city" name = "airportCity"
										placeholder="City"> <span class="input-group-addon">
										<span class="glyphicon glyphicon-lock"></span>
									</span>
								</div>
							</div>
							
							<!-- Country -->
							<div class="form-group">
								<div class="input-group">
									<input type="text" class="form-control" id="airport_country" name = "airportCountry"
										placeholder="Country"> <span class="input-group-addon">
										<span class="glyphicon glyphicon-lock"></span>
									</span>
								</div>
							</div>
							
							<button type="submit" class="btn btn-block">
								ADD Airport<span class="glyphicon glyphicon-log-in"></span>
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
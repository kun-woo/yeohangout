<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <div class="modal fade" id="myLogIn" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4> Yeo Hang Out </h4>
				</div>
				<div class="modal-body">
					<form role="form" action="login" method="POST">
						<div class="form-group">
							<div class="input-group">
								<input type="text" class="form-control" id="id" name = "userID"
									placeholder="Username"> <span class="input-group-addon">
									<span class="glyphicon glyphicon-user"></span>
								</span>
							</div>
						</div>
						<div class="form-group">
							<div class="input-group">
								<input type="password" class="form-control" id="pwd" name = "password"
									placeholder="Password"> <span class="input-group-addon">
									<span class="glyphicon glyphicon-lock"></span>
								</span>
							</div>
						</div>
						<button type="submit" class="btn btn-block log-in-button">
							Log In<span class="glyphicon glyphicon-log-in"></span>
						</button>
					</form>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-default pull-left">
						<span class="glyphicon glyphicon-remove"></span> Cancel
					</button>
					<p>
						Forgot <a >ID or Password?</a>
					</p>
				</div>
			</div>
		</div>
	</div>
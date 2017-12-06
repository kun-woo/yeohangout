<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="search" class="container-fluid text-center">

	<br>
	<div class="row">
		<form action="#" method="post">
			<div class="side-form col-xs-12 bg-primary">
				<div class="side-form-input">
					<div class="dropdown">
						<label for="button">Flying from</label>
						<button class="btn btn-default btn-block dropdown-toggle"
							type="button" data-toggle="dropdown">
							City or Airport <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<li class=><a href="#">JFK</a></li>
							<li><a href="#">ICN</a></li>
							<li><a href="#">LGA</a></li>
						</ul>
					</div>
					<div class="dropdown">
						<label for="button">Flying to</label>
						<button class="btn btn-default btn-block dropdown-toggle"
							type="button" data-toggle="dropdown">
							City or Airport <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<li class=><a href="#">JFK</a></li>
							<li><a href="#">ICN</a></li>
							<li><a href="#">LGA</a></li>
						</ul>
					</div>
					<div class="bg-default" style="overflow:visible;">
						<label class="control-label" for="text">Departing</label>
						<div class='input-group date' id='datetimepicker1'>
							<input type="text" class="form-control" name="deptTime"
								placeholder="mm/dd/yyyy"> <span
								class="input-group-addon"> <span
								class="glyphicon glyphicon-calendar"></span>
							</span>
						</div>
					</div>
					<br>
					<button class="btn btn-success btn-block" type="submit">Search</button>
					<br>
				</div>
			</div>
		</form>
	</div>
</div>
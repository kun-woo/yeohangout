<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id=contact class="container-fluid bg-gray">
		<h2 class="text-center">Contact</h2>
		<br>
		<div class="row">
			<div class="col-sm-5">
				<p>Contact us and we'll get back to you within 24 hours.</p>
				<p>
					<span class="glyphicon glyphicon-map-marker"></span> Stony Brook, US
				</p>
				<p>
					<span class="glyphicon glyphicon-phone"></span> +1 631-2345-6789
				</p>
				<p>
					<span class="glyphicon glyphicon-envelope"></span>
					no-reply@noreply.com
				</p>
			</div>
			<div class="col-sm-7">
				<div class="row">
					<div class="col-sm-6 form-group">
						<input class="form-control" id="name" name="name"
							placeholder="Name" type="text" required>
					</div>
					<div class="col-sm-6 form-group">
						<input class="form-control" id="email" name="email"
							placeholder="Email" type="email" required>
					</div>
				</div>
				<textarea class="form-control" id="comments" name="comments"
					placeholder="Comment" rows="5"></textarea>
				<br>
				<div class="row">
					<div class="col-sm-12 form-group">
						<button class="btn btn-default pull-right" type="submit">Send</button>
					</div>
				</div>
			</div>
		</div>
	</div>
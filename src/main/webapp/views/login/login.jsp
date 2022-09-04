<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Login</title>
</head>
<body>

	<div class="container">
		<div class="d-flex justify-content-center h-100">
			<div class="card">
				<div class="card-header">
					<h3>Login</h3>
					<!-- 
				<div class="d-flex justify-content-end social_icon">
					<span><i class="fab fa-facebook-square"></i></span>
					<span><i class="fab fa-google-plus-square"></i></span>
					<span><i class="fab fa-twitter-square"></i></span>
				</div>
				-->
				</div>
				<div class="card-body">
					<form method="post" action="<%=request.getContextPath()%>/auth"
						id="frmAction"> 
						<div class="input-group form-group w-100">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<input type="email" class="form-control " placeholder="email"
								id="email" name="email">

						</div>
						<did id="err"></did>
						<div class="input-group form-group w-100">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<input type="password" class="form-control"
								placeholder="password" id="password" name="password">
						</div>
						<!--  <div class="row align-items-center remember">
							<input type="checkbox">Remember Me
						</div>-->

						<div class="form-group text-center">
							<input type="submit" value="Login"
								class="btn float-right login_btn">
						</div>
					</form>
				</div>

				<div class="card-footer">
					<div class="d-flex justify-content-center links">Don't have
						an account?</div>
					<div class="d-flex justify-content-center links text-primary">
						Please contact hotline (083) 8888 3333</div>
					<!-- 
			<div class="d-flex justify-content-center links">
					Don't have an account?<a href="#">Sign Up</a>
				</div>
				<div class="d-flex justify-content-center">
					<a href="">Forgot your password?</a>
				</div>
			 -->
				</div>
			</div>
		</div>
	</div>

	<!-- hiện thông báo dùng thư viện toastr -->
	<input type="hidden" id="toastrResult"
		value="<%=request.getParameter("result")%>" />
</body>
</html>


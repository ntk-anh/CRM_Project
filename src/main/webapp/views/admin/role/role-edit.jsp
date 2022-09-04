<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.Role"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cập nhật role</title>
</head>
<body>
	<!-- /row -->
	<div class="container-fluid">
		<div class="row bg-title">
			<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
				<h4 class="page-title">Cập nhật role</h4>
			</div>
		</div>
		<!-- /.row -->
		<!-- .row -->
		<div class="row">
			<div class="col-md-2 col-12"></div>
			<div class="col-md-8 col-xs-12">
				<div class="white-box">
					<%
					Role role = (Role) request.getAttribute("role");
					%>
					
					<form class="form-horizontal form-material"
						action="<%=request.getContextPath()%>/admin-role-edit" method="post">
						
						<div class="form-group hidden">
							<label class="col-md-12">Id</label>
							<div class="col-md-12">
								<input type="text" class="form-control form-control-line"
									id="id" name="id" value="<%=role.getId()%>" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-12">Tên role</label>
							<div class="col-md-12">
								<input type="text" class="form-control form-control-line"
									id="ten_role" name="ten_role" value="<%= role.getTenRole() %>" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-12">Mô tả</label>
							<div class="col-md-12">
								<input type="text" class="form-control form-control-line"
									id="mo_ta" name="mo_ta" value="<%= role.getMoTa() %>" />
							</div>
						</div> 
						<div class="form-group">
							<div class="col-sm-12">
								<button type="submit" class="btn btn-success btn-edit-user">
								Lưu lại</button>
								<a href="<%=request.getContextPath()%>/role"
									class="btn btn-primary">Quay lại</a>
							</div>
						</div>
					</form>
					
				</div>
			</div>
			<div class="col-md-2 col-12"></div>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container-fluid -->
	<!-- /.row -->
	</div>
</body>
</html>
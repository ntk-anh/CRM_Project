<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cập nhật thành viên</title>
</head>
<body>
	<!-- /row -->
	<div class="container-fluid">
		<div class="row bg-title">
			<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
				<h4 class="page-title">Cập nhật thành viên</h4>
			</div>
		</div>
		<!-- /.row -->
		<!-- .row -->
		<div class="row">
			<div class="col-md-2 col-12"></div>
			<div class="col-md-8 col-xs-12">
				<div class="white-box">
					<%
					User user = (User) request.getAttribute("user");
					%>

					<form class="form-horizontal form-material"
						action="<%=request.getContextPath()%>/admin-user-edit" method="post">

						<div class="form-group hidden">
							<label class="col-md-12">Id</label>
							<div class="col-md-12">
								<input type="text" class="form-control form-control-line"
									id="id" name="id" value="<%=user.getId()%>" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-12">Họ tên</label>
							<div class="col-md-12">
								<input type="text" class="form-control form-control-line"
									id="ho_ten" name="ho_ten" value="<%=user.getHoTen()%>" />
							</div>
						</div>
						<div class="form-group">
							<label for="example-email" class="col-md-12">Email</label>
							<div class="col-md-12">
								<input type="email" value="<%=user.getEmail()%>"
									class="form-control form-control-line" name="email" id="email">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-12">Địa chỉ</label>
							<div class="col-md-12">
								<input type="text" value="<%=user.getDiaChi()%>"
									class="form-control form-control-line" id="dia_chi"
									name="dia_chi">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-12">Số điện thoại</label>
							<div class="col-md-12">
								<input type="text" value="<%=user.getSoDienThoai()%>"
									class="form-control form-control-line" id="so_dien_thoai"
									name="so_dien_thoai">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-12">Tên quyền</label>
							<div class="col-md-12">
								<select class="form-control form-control-line" id="id_role"
									name="id_role">
									<%if (user.getId_role() == 1) {%>
									 <option  selected  value="1">Admin</option>  
									 <option     value="2">Leader</option>
									 <option     value="3">Member</option>
									 <%}%>
									 <%if (user.getId_role() == 2) {%>
									 <option    value="1">Admin</option>  
									 <option   selected  value="2">Leader</option>
									 <option     value="3">Member</option>
									 <%}%>
									 <%if (user.getId_role() == 3) {%>
									 <option    value="1">Admin</option>  
									 <option     value="2">Leader</option>
									 <option   selected  value="3">Member</option>
									 <%}%>
								</select>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-12">
								<button type="submit" class="btn btn-success btn-edit-user">
									Lưu lại</button>
								<a href="<%=request.getContextPath()%>/admin-user-list"
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
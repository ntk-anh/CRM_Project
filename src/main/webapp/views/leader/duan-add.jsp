<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Thêm dự án</title>
</head>
<body>
	<!-- /row -->
	<div class="container-fluid">
		<div class="row bg-title">
			<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
				<h4 class="page-title">Thêm mới dự án</h4>
			</div>
		</div>
		<!-- /.row -->
		<!-- .row -->
		<div class="row">
			<div class="col-md-2 col-12"></div>
			<div class="col-md-8 col-xs-12">
				<div class="white-box">
					<form class="form-horizontal form-material"
						action="<%=request.getContextPath()%>/leader-duan-add" method="post">
						<div class="form-group">
							<label class="col-md-12">Tên dự án</label>
							<div class="col-md-12">
								<input type="text" placeholder="Dự án Elearning"
									class="form-control form-control-line" id="ten_du_an" name="ten_du_an">
							</div>
						</div>
						<div class="form-group">
							<label for="example-email" class="col-md-12">Mô tả</label>
							<div class="col-md-12">
								<input type="text" placeholder="Xây dựng hệ thống học lập trình web"
									class="form-control form-control-line" name="mo_ta"
									id="mo_ta">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-12">Ngày bắt đầu</label>
							<div class="col-md-12">
								<input type="text"  placeholder="MM/dd/yyyy"
									class="form-control form-control-line" id="ngay_bat_dau" name="ngay_bat_dau">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-12">Ngày kết thúc</label>
							<div class="col-md-12">
								<input type="text"  placeholder="MM/dd/yyyy"
									class="form-control form-control-line" id="ngay_ket_thuc" name="ngay_ket_thuc">
							</div>
						</div> 
						<% User leader =(User) request.getAttribute("leader"); %>
						<div class="form-group">
							<label class="col-md-12">Tên Leader</label>
							<div class="col-md-12">
								<input type="text" disabled  class="form-control form-control-line" id="ten_role" name="ten_role" value="<%= leader.getHoTen()  %>">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-12">
								<button type="submit" class="btn btn-success">Lưu lại</button>
								<a href="<%= request.getContextPath() %>/leader-duan-list" class="btn btn-primary">Quay lại</a>
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
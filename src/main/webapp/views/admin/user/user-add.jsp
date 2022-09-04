<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Thêm thành viên</title>
</head>
<body>
	<!-- /row -->
	<div class="container-fluid">
		<div class="row bg-title">
			<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
				<h4 class="page-title">Thêm mới thành viên</h4>
			</div>
		</div>
		<!-- /.row -->
		<!-- .row -->
		<div class="row">
			<div class="col-md-2 col-12"></div>
			<div class="col-md-8 col-xs-12">
				<div class="white-box">
					<form class="form-horizontal form-material"
						action="<%=request.getContextPath()%>/admin-user-add" method="post">
						<div class="form-group">
							<label class="col-md-12">Họ tên</label>
							<div class="col-md-12">
								<input type="text" placeholder="Trần Văn B"
									class="form-control form-control-line" id="ho_ten"
									name="ho_ten">
							</div>
						</div>
						<div class="form-group">
							<label for="example-email" class="col-md-12">Email</label>
							<div class="col-md-12">
								<input type="email" placeholder="tranvanb@gmail.com"
									class="form-control form-control-line" name="email" id="email">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-12">Password</label>
							<div class="col-md-12">
								<input type="password" value="password"
									class="form-control form-control-line" id="password"
									name="password">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-12">Nhập lại Password</label>
							<div class="col-md-12">
								<input type="password" value="password"
									class="form-control form-control-line" id="password2"
									name="password2">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-12">Địa chỉ</label>
							<div class="col-md-12">
								<input type="text"
									placeholder="Phường 5 - TP.Mỹ Tho - Tiền Giang"
									class="form-control form-control-line" id="dia_chi"
									name="dia_chi">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-12">Số điện thoại</label>
							<div class="col-md-12">
								<input type="text" placeholder="0971 438 134"
									class="form-control form-control-line" id="so_dien_thoai"
									name="so_dien_thoai">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-12">Tên quyền</label>
							<div class="col-md-12">
								<select class="form-control form-control-line"
									id="id_role" name="id_role"> 
										<option value="1">Admin</option>  
										<option value="2">Leader</option>
									<option selected value="3">Member</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-12">
								<button type="submit" class="btn btn-success">Lưu lại</button>
								<a href="<%=request.getContextPath()%>/admin"
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
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Thêm quyền</title>
</head>
<body>
	<!-- /row -->
	<div class="container-fluid">
		<div class="row bg-title">
			<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
				<h4 class="page-title">Thêm mới quyền</h4>
			</div>
		</div>
		<!-- /.row -->
		<!-- .row -->
		<div class="row">
			<div class="col-md-2 col-12"></div>
			<div class="col-md-8 col-xs-12">
				<div class="white-box">
					<form class="form-horizontal form-material"
						action="<%=request.getContextPath()%>/admin-role-add" method="post">
						<div class="form-group">
							<label class="col-md-12">Tên quyền</label>
							<div class="col-md-12">
								<input type="text" placeholder="Admin"
									class="form-control form-control-line" id="ten_quyen" name="ten_quyen">
							</div>
						</div>
						<div class="form-group">
							<label for="example-email" class="col-md-12">Mô tả</label>
							<div class="col-md-12">
								<input type="text" placeholder="Quản trị hệ thống"
									class="form-control form-control-line" name="mo_ta"
									id="mo_ta">
							</div>
						</div> 
						<div class="form-group">
							<div class="col-sm-12">
								<button type="submit" class="btn btn-success">Lưu lại</button>
								<a href="<%= request.getContextPath() %>/admin-role-list" class="btn btn-primary">Quay lại</a>
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
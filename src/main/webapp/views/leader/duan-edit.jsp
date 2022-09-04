<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.DuAn"%>
<%@ page import="model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cập nhật dự án</title>
</head>
<body>
	<!-- /row -->
	<div class="container-fluid">
		<div class="row bg-title">
			<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
				<h4 class="page-title">Cập nhật dự án</h4>
			</div>
		</div>
		<!-- /.row -->
		<!-- .row -->
		<div class="row">
			<div class="col-md-2 col-12"></div>
			<div class="col-md-8 col-xs-12">
				<div class="white-box">
					<%
					DuAn duAn = (DuAn) request.getAttribute("duAn");
					ArrayList<User> users = (ArrayList<User>) request.getAttribute("users");
					%>

					<form class="form-horizontal form-material"
						action="<%=request.getContextPath()%>/leader-duan-edit"
						method="post">

						<div class="form-group hidden">
							<label class="col-md-12">Id</label>
							<div class="col-md-12">
								<input type="text" class="form-control form-control-line"
									id="id" name="id" value="<%=duAn.getId()%>" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-12">Tên dự án</label>
							<div class="col-md-12">
								<input type="text" class="form-control form-control-line"
									id="ten_du_an" name="ten_du_an" value="<%=duAn.getTenDuAn()%>" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-12">Mô tả</label>
							<div class="col-md-12">
								<input type="text" class="form-control form-control-line"
									id="mo_ta" name="mo_ta" value="<%=duAn.getMoTa()%>" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-12">Ngày bắt đầu</label>
							<div class="col-md-12">
								<input type="text" value="<%=duAn.getNgayBatDau()%>"
									class="form-control form-control-line" id="ngay_bat_dau"
									name="ngay_bat_dau">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-12">Ngày kết thúc</label>
							<div class="col-md-12">
								<input type="text" value="<%=duAn.getNgayKetThuc()%>"
									class="form-control form-control-line" id="ngay_ket_thuc"
									name="ngay_ket_thuc">
							</div>
						</div>
						<input type="hidden" id="id_Leader" name="id_Leader" value="<%= duAn.getIdLeader() %>" />
							 
									 
						<div class="form-group">
							<label class="col-md-12">Tên leader</label>
							<div class="col-md-12">
								<select disabled class="form-control form-control-line"
									id="id_leader" name="id_leader">
									<%
									for (User item : users) {
										if (duAn.getIdLeader() == item.getId()) {
									%>
									<option selected value="<%=item.getId()%>"><%=item.getHoTen()%></option>
									<%
									} else {
									%><option value="<%=item.getId()%>"><%=item.getHoTen()%></option>
									<%
									}
									}
									%>
								</select>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-12">
								<button type="submit" class="btn btn-success btn-edit-user">
									Lưu lại</button>
								<a href="<%=request.getContextPath()%>/leader-duan-list"
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
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.awt.event.ItemEvent"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.TrangThaiCV"%>
<%@page import="model.CongViec"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.CongViec"%>
<%@ page import="model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cập nhật công việc</title>
</head>
<body>
	<!-- /row -->
	<div class="container-fluid">
		<div class="row bg-title">
			<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
				<h4 class="page-title">Cập nhật công việc</h4>
			</div>
		</div>
		<!-- /.row -->
		<!-- .row -->
		<div class="row">
			<div class="col-md-2 col-12"></div>
			<div class="col-md-8 col-xs-12">
				<div class="white-box">
					<% 
					CongViec congViec = (CongViec) request.getAttribute("congViec");
					ArrayList<TrangThaiCV> trangThaiCVs = (ArrayList<TrangThaiCV>) request.getAttribute("trangThaiCVs");
					ArrayList<User> users = (ArrayList<User>) request.getAttribute("users");
					%>
					<form class="form-horizontal form-material"
						action="<%=request.getContextPath()%>/admin-congviec-edit" method="post">
						<div class="form-group hidden">
							<label class="col-md-12">Id</label>
							<div class="col-md-12">
								<input type="text" id="id" name="id" value="<%=congViec.getId()%>"
									class="form-control form-control-line">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-12">Tên dự án</label>
							<div class="col-md-12">
								<input type="hidden" id="id_duAn" name="id_duAn" value="<%=congViec.getIdDuAn()%>" />
								<select  disabled class="form-control form-control-line">
									<option value="<%=congViec.getIdDuAn()%>"><%=congViec.getTenDuAn()%></option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-12">Tên công việc</label>
							<div class="col-md-12">
								<input type="text" placeholder="Tên công việc"
									class="form-control form-control-line" id="ten_cong_viec"
									name="ten_cong_viec" value="<%=congViec.getTenCongViec()%>" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-12">Người thực hiện</label>
							<div class="col-md-12">
								<select class="form-control form-control-line" id="id_user"
									name="id_user">
									<%
									for (User item : users) {
										if (congViec.getIdUser() == item.getId()) {
									%>
									<option selected="selected" value="<%=item.getId()%>"><%=item.getHoTen()%></option>
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
							<label class="col-md-12">Ngày bắt đầu</label>
							<div class="col-md-12">
								<input type="text" placeholder="dd/MM/yyyy"
									class="form-control form-control-line" id="ngay_bat_dau"
									name="ngay_bat_dau" value="<%=congViec.getNgayBatDau()%>">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-12">Ngày kết thúc</label>
							<div class="col-md-12">
								<input type="text" placeholder="dd/MM/yyyy"
									class="form-control form-control-line" id="ngay_ket_thuc"
									name="ngay_ket_thuc" value="<%=congViec.getNgayKetThuc()%>">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-12">Trạng thái công việc</label>
							<div class="col-md-12">
								<select class="form-control form-control-line"
									id="id_trangThaiCV" name="id_trangThaiCV">
	
									<%
									for (TrangThaiCV item : trangThaiCVs) {
										if (congViec.getIdTrangThaiCV() == item.getId()) {
									%>
									<option selected="selected" value="<%=item.getId()%>"><%=item.getTenTrangThaiCV()%></option>
									<%
									} else {
									%><option value="<%=item.getId()%>"><%=item.getTenTrangThaiCV()%></option>
									<%
									}
									}
									%>
								</select>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-12">
								<button type="submit" class="btn btn-success">Lưu lại</button>
								<a href="<%=request.getContextPath()%>/admin-congviec-list"
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
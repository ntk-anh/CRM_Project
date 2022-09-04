<%@page import="model.User_ListCongViec"%>
<%@page import="model.CongViec"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.CongViec"%>
<%@ page import="model.User_ListCongViec"%>
<%@ page import="model.TrangThaiCV_SoLuong"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Chi tiết công việc</title>
</head>
<body>
	<div class="container-fluid">

		<!-- BEGIN DANH SÁCH CÔNG VIỆC -->
		<div class="row">
			<div class="container-fluid">
				<div class="row bg-title">
					<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
						<h4 class="page-title">Chi tiết công việc</h4>
					</div>
					<div class="col-lg-9 col-sm-8 col-md-8 col-xs-12"></div>
					<!-- /.col-lg-12 -->
				</div>
				<%
				ArrayList<TrangThaiCV_SoLuong> trangThaiCV_SoLuongs = (ArrayList<TrangThaiCV_SoLuong>) request
						.getAttribute("trangThaiCV_SoLuongs");
				Integer tong = (Integer) request.getAttribute("tong");
				%>
				<!-- BEGIN THỐNG KÊ -->
				<div class="row">
					<!--col -->
					<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
						<div class="white-box">
							<div class="col-in row">
								<div class="col-md-6 col-sm-6 col-xs-6">
									<i data-icon="E" class="linea-icon linea-basic"></i>
									<h5 class="text-muted vb">CHƯA BẮT ĐẦU</h5>
								</div>
								<%
								for (TrangThaiCV_SoLuong trangThaiCV_SoLuong : trangThaiCV_SoLuongs) {
								%>
								<%
								if (trangThaiCV_SoLuong.getIdTrangThai() == 1) {
								%>
								<%
								int soPhanTram = (trangThaiCV_SoLuong.getSoLuongCV() * 100) / tong;
								%>
								<div class="col-md-6 col-sm-6 col-xs-6">
									<h3 class="counter text-right m-t-15 text-danger"><%=soPhanTram%>
										%
									</h3>
								</div>
								<div class="col-md-12 col-sm-12 col-xs-12">
									<div class="progress">
										<div class="progress-bar progress-bar-danger"
											role="progressbar" aria-valuenow="40" aria-valuemin="0"
											aria-valuemax="100" style="width: 20%"></div>
									</div>
								</div>
								<%
								}
								%>
								<%
								}
								%>
							</div>
						</div>
					</div>
					<!-- /.col -->
					<!--col -->
					<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
						<div class="white-box">
							<div class="col-in row">
								<div class="col-md-6 col-sm-6 col-xs-6">
									<i class="linea-icon linea-basic" data-icon="&#xe01b;"></i>
									<h5 class="text-muted vb">ĐANG THỰC HIỆN</h5>
								</div>
								<%
								for (TrangThaiCV_SoLuong trangThaiCV_SoLuong : trangThaiCV_SoLuongs) {
								%>
								<%
								if (trangThaiCV_SoLuong.getIdTrangThai() == 2) {
								%>
								<%
								int soPhanTram = (trangThaiCV_SoLuong.getSoLuongCV() * 100) / tong;
								%>
								<div class="col-md-6 col-sm-6 col-xs-6">
									<h3 class="counter text-right m-t-15 text-danger"><%=soPhanTram%>
										%
									</h3>
								</div>
								<div class="col-md-12 col-sm-12 col-xs-12">
									<div class="progress">
										<div class="progress-bar progress-bar-danger"
											role="progressbar" aria-valuenow="40" aria-valuemin="0"
											aria-valuemax="100" style="width: 20%"></div>
									</div>
								</div>
								<%
								}
								%>
								<%
								}
								%>

							</div>
						</div>
					</div>
					<!-- /.col -->
					<!--col -->
					<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
						<div class="white-box">
							<div class="col-in row">
								<div class="col-md-6 col-sm-6 col-xs-6">
									<i class="linea-icon linea-basic" data-icon="&#xe00b;"></i>
									<h5 class="text-muted vb">HOÀN THÀNH</h5>
								</div>
								<%
								for (TrangThaiCV_SoLuong trangThaiCV_SoLuong : trangThaiCV_SoLuongs) {
								%>
								<%
								if (trangThaiCV_SoLuong.getIdTrangThai() == 3) {
								%>
								<%
								int soPhanTram =  (trangThaiCV_SoLuong.getSoLuongCV() * 100) / tong;
								%>
								<div class="col-md-6 col-sm-6 col-xs-6">
									<h3 class="counter text-right m-t-15 text-danger"><%=soPhanTram%>
										%
									</h3> 
								</div>
								<div class="col-md-12 col-sm-12 col-xs-12">
									<div class="progress">
										<div class="progress-bar progress-bar-danger"
											role="progressbar" aria-valuenow="40" aria-valuemin="0"
											aria-valuemax="100" style="width: <%=soPhanTram%>%"></div>
									</div>
								</div>
								<%
								}
								%>
								<%
								}
								%>
							</div>
						</div>
					</div>
					<!-- /.col -->
				</div>
				<!-- END THỐNG KÊ -->

				<!-- BEGIN DANH SÁCH CÔNG VIỆC -->
				<%
				ArrayList<User_ListCongViec> user_ListCongViecs = (ArrayList<User_ListCongViec>) request
						.getAttribute("user_ListCongViecs");
				%>
				<%
				for (User_ListCongViec item : user_ListCongViecs) {
				%>
				<div class="row">
					<div class="col-xs-12">
						<a href="#" class="group-title"> <img width="30"
							src="assets/plugins/images/users/pawandeep.jpg"
							class="img-circle" /> <span> <%=item.getHoTen()%></span>
						</a>
					</div>
					<div class="col-md-4">
						<div class="white-box">
							<h3 class="box-title bg-danger">Chưa thực hiện</h3>

							<div class="message-center">
								<a href="#">
									<div class="mail-contnet">
										<%
										for (CongViec i : item.getCongViecs()) {
										%>
										<%
										if (i.getIdTrangThaiCV() == 1) {
										%>
										<h5><%=i.getTenCongViec()%></h5>
										<span class="mail-desc">Hạn chót: <%=i.getNgayKetThuc()%></span>
										<%
										}
										%>
										<%
										}
										%>
									</div>
								</a>
							</div>

						</div>
					</div>
					<div class="col-md-4 ">
						<div class="white-box ">
							<h3 class="box-title bg-success">Đang thực hiện</h3>

							<div class="message-center">
								<a href="#">
									<div class="mail-contnet">
										<%
										for (CongViec i : item.getCongViecs()) {
										%>
										<%
										if (i.getIdTrangThaiCV() == 2) {
										%>
										<h5><%=i.getTenCongViec()%></h5>
										<span class="mail-desc">Hạn chót: <%=i.getNgayKetThuc()%></span>
										<%
										}
										%>
										<%
										}
										%>
									</div>
								</a>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="white-box">
							<h3 class="box-title bg-info">Đã hoàn thành</h3>
							<div class="message-center">
								<a href="#">
									<div class="mail-contnet">
										<%
										for (CongViec i : item.getCongViecs()) {
										%>
										<%
										if (i.getIdTrangThaiCV() == 3) {
										%>
										<h5><%=i.getTenCongViec()%></h5>
										<span class="mail-desc">Hạn chót: <%=i.getNgayKetThuc()%></span>
										<%
										}
										%>
										<%
										}
										%>
									</div>
								</a>
							</div>
						</div>
					</div>

				</div>
				<%
				}
				%>
				<!-- END DANH SÁCH CÔNG VIỆC -->
			</div>
			<!-- /.container-fluid -->

		</div>
		<!-- END DANH SÁCH CÔNG VIỆC -->
	</div>
	<!-- /.container-fluid -->
</body>
</html>
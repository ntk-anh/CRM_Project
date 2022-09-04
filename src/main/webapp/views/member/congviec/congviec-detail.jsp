<%@page import="model.ThongKeCV1Member"%>
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
<title>Thống Kê</title>
</head>
<body>
	<div class="container-fluid">

		<!-- BEGIN DANH SÁCH CÔNG VIỆC -->
		<div class="row">
			<div class="container-fluid">
				<div class="row bg-title">
					<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
						<h4 class="page-title">Thống Kê</h4>
					</div>
					<div class="col-lg-9 col-sm-8 col-md-8 col-xs-12"></div>
					<!-- /.col-lg-12 -->
				</div>
				<%
				ArrayList<ThongKeCV1Member> thongKeCV1Members = (ArrayList<ThongKeCV1Member>) request
						.getAttribute("thongKeCV1Members");
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
								for (ThongKeCV1Member o : thongKeCV1Members) {
								%>
								<%
								if (o.getIdTrangThaiCV()  == 1) {
								%>
								<%
								int soPhanTram = (o.getSoLuong() * 100) / tong;
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
								for (ThongKeCV1Member o : thongKeCV1Members) {
								%>
								<%
								if (o.getIdTrangThaiCV()  == 2) {
								%>
								<%
								int soPhanTram = (o.getSoLuong() * 100) / tong;
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
								for (ThongKeCV1Member o : thongKeCV1Members) {
								%>
								<%
								if (o.getIdTrangThaiCV()  == 3) {
								%>
								<%
								int soPhanTram = (o.getSoLuong() * 100) / tong;
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

				
			</div>
			<!-- /.container-fluid -->

		</div>
		<!-- END DANH SÁCH CÔNG VIỆC -->
	</div>
	<!-- /.container-fluid -->
</body>
</html>
<%@page import="org.apache.tomcat.util.http.RequestUtil"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Danh sách công việc</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row bg-title">
			<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
				<h4 class="page-title">Danh sách công việc</h4>
			</div> 
			<!-- /.col-lg-12 -->
		</div>
		
		<!-- /row -->
		<div class="row">
			<div class="col-sm-12">
				<div class="white-box">
					<div class="table-responsive">
						<table class="table" id="example">
							<thead>
								<tr>
									<th>STT</th>
									<th>Tên công việc</th> 
									<th>Tên dự án</th>
									<th>Người thực hiện</th>
									<th>Ngày Bắt Đầu</th>
									<th>Ngày Kết Thúc</th>
									<th>Trạng thái</th>
									<th>#</th>
								</tr>
							</thead>
							<tbody> 
								<%
								int i = 1;
								%>
								<c:forEach items="${congViecs}" var="item">
									<tr>
										<td><%= i++ %></td>
										<td>${item.getTenCongViec()}</td>
										<td>${item.getTenDuAn()}</td>
										<td>${item.getTenUser()}</td>
										<td>${item.getNgayBatDau()}</td>
										<td>${item.getNgayKetThuc()}</td>  
										<td>${item.getTenTrangThai()}</td>
										<td><a href="<%= request.getContextPath() %>/member-congviec-edit?id=${item.getId()}" class="btn btn-sm btn-primary">Cập Nhật Trạng Thái</a>   
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<!-- /.row -->
	</div>
</body>
</html>
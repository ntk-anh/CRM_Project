<%@page import="org.apache.tomcat.util.http.RequestUtil"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Danh sách dự án</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row bg-title">
			<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
				<h4 class="page-title">Danh sách dự án</h4>
			</div> 
			<div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
				<a href="<%= request.getContextPath() %>/leader-duan-add" class="btn btn-sm btn-success">Thêm mới</a>
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
									<th>Tên Dự Án</th>
									<th>Mô Tả</th>
									<th>Ngày Bắt Đầu</th>
									<th>Ngày Kết Thúc</th>
									<th>Tên Leader</th>
									<th>#</th>
								</tr>
							</thead>
							<tbody> 
								<%
								int i = 1;
								%>
								<c:forEach items="${duans}" var="item">
									<tr>
										<td><%= i++ %></td>
										<td>${item.getTenDuAn()}</td>
										<td>${item.getMoTa()}</td>
										<td>${item.getNgayBatDau()}</td>
										<td>${item.getNgayKetThuc()}</td>  
										<td>${item.getTenLeader()}</td>  
										<td><a href="<%= request.getContextPath() %>/leader-duan-edit?id=${item.getId()}" class="btn btn-sm btn-primary">Sửa</a> <a
											href="<%= request.getContextPath() %>/leader-duan-delete?id=${item.getId()}" class="btn btn-sm btn-danger">Xóa</a> <a
											href="<%= request.getContextPath() %>/leader-congviec-detail?id=${item.getId()}" class="btn btn-sm btn-info">Xem chi tiết</a>
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
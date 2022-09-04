<%@page import="org.apache.tomcat.util.http.RequestUtil"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Danh sách quyền</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row bg-title">
			<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
				<h4 class="page-title">Danh sách quyền</h4>
			</div>
			<div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
				<a href="<%= request.getContextPath() %>/admin-role-add" class="btn btn-sm btn-success">Thêm mới</a>
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
									<th>Tên quyền</th>
									<th>Mô tả</th> 
									<th>#</th>
								</tr>
							</thead>
							<tbody> 
								<%
								int i = 1;
								%>
								<c:forEach items="${roles}" var="item">
									<tr>
										<td><%= i++ %></td>
										<td>${item.getTenRole()}</td>
										<td>${item.getMoTa()}</td>  
										<td><a href="<%= request.getContextPath() %>/admin-role-edit?id=${item.getId()}" class="btn btn-sm btn-primary">Sửa</a> <a
											href="<%= request.getContextPath() %>/admin-role-delete?id=${item.getId()}" class="btn btn-sm btn-danger">Xóa</a>  
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
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Thêm công việc</title>
</head>
<body>
	<!-- /row -->
	<div class="container-fluid">
		<div class="row bg-title">
			<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
				<h4 class="page-title">Thêm mới công việc</h4>
			</div>
		</div>
		<!-- /.row -->
		 <!-- .row -->
                <div class="row">
                    <div class="col-md-2 col-12"></div>
                    <div class="col-md-8 col-xs-12">
                        <div class="white-box">
                            <form class="form-horizontal form-material" action="<%=request.getContextPath()%>/admin-congviec-add" method="post">
                                <div class="form-group hidden">
                                    <label class="col-md-12">Id</label>
                                    <div class="col-md-12">
                                        <input type="text" id="id" name="id"
                                            class="form-control form-control-line">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Tên dự án</label>
                                    <div class="col-md-12">
                                        <select class="form-control form-control-line" id="id_duAn" name="id_duAn">
	                                        <c:forEach var="item" items="${duan}"> 
	                                        	<option value="${item.getId()}">${item.getTenDuAn()}</option> 
	                                        </c:forEach> 
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Tên công việc</label>
                                    <div class="col-md-12">
                                        <input type="text" placeholder="Tên công việc"
                                            class="form-control form-control-line"
                                            id="ten_cong_viec" name="ten_cong_viec">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Người thực hiện</label>
                                    <div class="col-md-12">
                                        <select class="form-control form-control-line" id = "id_user" name = "id_user">
                                        	<c:forEach var="item" items="${user}">
                                        		<option value="${item.getId()}" >${item.getHoTen()}</option>
                                        	</c:forEach> 
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Ngày bắt đầu</label>
                                    <div class="col-md-12">
                                        <input type="text" placeholder="dd/MM/yyyy"
                                            class="form-control form-control-line"
                                            id="ngay_bat_dau" name="ngay_bat_dau"> 
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Ngày kết thúc</label>
                                    <div class="col-md-12">
                                        <input type="text" placeholder="dd/MM/yyyy"
                                            class="form-control form-control-line"
                                            id="ngay_ket_thuc" name="ngay_ket_thuc"> 
                                    </div>
                                </div>
                                 <div class="form-group">
                                    <label class="col-md-12">Trạng thái công việc</label>
                                    <div class="col-md-12">
                                        <select class="form-control form-control-line" id="id_trangThaiCV" name="id_trangThaiCV"> 
	                                        <c:forEach var="item" items="${trangThaiCV}"> 
                                        		<option value="${item.getId()}">${item.getTenTrangThaiCV()}</option>
                                        	</c:forEach> 
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <button type="submit" class="btn btn-success">Lưu lại</button>
                                        <a href="<%= request.getContextPath()%>/admin-congviec-list" class="btn btn-primary">Quay lại</a>
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
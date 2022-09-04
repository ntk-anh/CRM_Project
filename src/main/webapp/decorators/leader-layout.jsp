<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" type="image/png" sizes="16x16"
	href="assets/plugins/images/favicon.png">

<title><decorator:title /></title>

<!-- Bootstrap Core CSS -->
<link href="assets/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Menu CSS -->
<link
	href="assets/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">

<!-- animation CSS -->
<link href="assets/css/animate.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="assets/css/style.css" rel="stylesheet">

<!-- color CSS -->
<link href="assets/css/colors/blue-dark.css" id="theme" rel="stylesheet">
<link rel="stylesheet" href="assets/css/custom.css">
<!--  
<style type="text/css">
*{
font-family: 'Roboto', sans-serif;
}
</style>
-->
<!-- font roboto (chưa áp chỉ để đây) -->
<link
	href="https://fonts.googleapis.com/css2?family=Roboto&display=swap"
	rel="stylesheet">

<!-- thư viện toast -->
<link rel="stylesheet" href="assets/plugins/toastr/toastr.min.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>
<body>


	<!-- HEADER -->
	<jsp:include page="/views/layout/header.jsp"></jsp:include>
	<div id="wrapper">
		<!-- SIDE BAR -->
		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top m-b-0 ">
			<div class="navbar-header">
				<a class="navbar-toggle hidden-sm hidden-md hidden-lg "
					href="javascript:void(0)" data-toggle="collapse"
					data-target=".navbar-collapse"> <i class="fa fa-bars"></i>
				</a>
				<div class="top-left-part">
					<a class="logo"
						href="<%=request.getContextPath()%>/leader-user-list"> <b>
							<img src="assets/plugins/images/pixeladmin-logo.png" alt="home" />
					</b> <span class="hidden-xs"> <img
							src="assets/plugins/images/pixeladmin-text.png" alt="home" />
					</span>
					</a>
				</div>

				<!--  
		<ul class="nav navbar-top-links navbar-left m-l-20 hidden-xs">
			<li>
				<form role="search" class="app-search hidden-xs">
					<input type="text" placeholder="Search..." class="form-control">
					<a href=""> <i class="fa fa-search"></i>
					</a>
				</form>
			</li>
		</ul>
		-->
				<ul class="nav navbar-top-links navbar-right pull-right">
					<li>
						<div class="dropdown">
							<a class="profile-pic dropdown-toggle" data-toggle="dropdown"
								href="#"> <img src="assets/plugins/images/users/varun.jpg"
								alt="user-img" width="36" class="img-circle" /> <b
								class="hidden-xs">Cybersoft</b>
							</a>
							<ul class="dropdown-menu">
								<!--<li><a href="<%=request.getContextPath()%>/leader-profile">Thông tin cá nhân</a></li>
								<li class="divider"></li>  -->
								<li><a
									href="<%=request.getContextPath()%>/auth?action=logout">Đăng
										xuất</a></li>
							</ul>
						</div>
					</li>
				</ul>
			</div>
		</nav>
		<!-- Left navbar-header -->
		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse slimscrollsidebar">
				<ul class="nav" id="side-menu">
					<li><a href="<%=request.getContextPath()%>/leader-user-list"
						class="waves-effect"><i class="fa fa-user fa-fw"
							aria-hidden="true"></i><span class="hide-menu">Thành viên</span></a></li>
					<li><a href="<%=request.getContextPath()%>/leader-duan-list"
						class="waves-effect"><i class="fa fa-table fa-fw"
							aria-hidden="true"></i><span class="hide-menu">Dự án</span></a></li>
					<li><a
						href="<%=request.getContextPath()%>/leader-congviec-list"
						class="waves-effect"><i class="fa fa-table fa-fw"
							aria-hidden="true"></i><span class="hide-menu">Công việc</span></a></li>
				</ul>
			</div>
		</div>

		<!-- Left navbar-header end -->

		<div id="page-wrapper">
			<!-- body -->
			<decorator:body />
			<!-- end body -->
			<!-- FOOTER -->
			<jsp:include page="/views/layout/footer.jsp"></jsp:include>

		</div>
	</div>



	<!-- jQuery -->
	<script src="assets/plugins/bower_components/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="assets/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- Menu Plugin JavaScript -->
	<script
		src="assets/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js"></script>
	<!--slimscroll JavaScript -->
	<script src="assets/js/jquery.slimscroll.js"></script>
	<script src="assets/js/jquery.dataTables.js"></script>
	<!--Wave Effects -->
	<script src="assets/js/waves.js"></script>
	<!-- Custom Theme JavaScript -->
	<script src="assets/js/custom.min.js"></script>

	<!-- thư viện toast -->
	<script src="assets/plugins/toastr/toastr.min.js"></script>

	<script src="assets/js/custom.js"></script>

	<script>
		$(document).ready(function() {
			$('#example').DataTable();
		});
	</script>
</body>
</html>
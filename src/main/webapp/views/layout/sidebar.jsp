<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!-- Navigation -->
<nav class="navbar navbar-default navbar-static-top m-b-0 ">
	<div class="navbar-header">
		<a class="navbar-toggle hidden-sm hidden-md hidden-lg "
			href="javascript:void(0)" data-toggle="collapse"
			data-target=".navbar-collapse"> <i class="fa fa-bars"></i>
		</a> 
		<div class="top-left-part">
			<a class="logo" href="index.html"> <b> <img
					src="assets/plugins/images/pixeladmin-logo.png" alt="home" />
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
						<!-- <li><a href="">Thông tin cá nhân</a></li> 
						<li class="divider"></li> -->
						<li><a href="<%= request.getContextPath() %>/auth?action=logout">Đăng xuất</a></li>
					</ul>
				</div>
			</li>
		</ul>
	</div>
	<!-- /.navbar-header -->
	<!-- /.navbar-top-links -->
	<!-- /.navbar-static-side -->
</nav>
<!-- Left navbar-header 
<div class="navbar-default sidebar" role="navigation">
	<div class="sidebar-nav navbar-collapse slimscrollsidebar">
		<ul class="nav" id="side-menu">
			<li style="padding: 10px 0 0;"><a href="index.html"
				class="waves-effect"><i class="fa fa-clock-o fa-fw"
					aria-hidden="true"></i><span class="hide-menu">Dashboard</span></a></li>
			<li><a href="user-table.html" class="waves-effect"><i
					class="fa fa-user fa-fw" aria-hidden="true"></i><span
					class="hide-menu">Thành viên</span></a></li>
			<li><a href="role-table.html" class="waves-effect"><i
					class="fa fa-modx fa-fw" aria-hidden="true"></i><span
					class="hide-menu">Quyền</span></a></li>
			<li><a href="groupwork.html" class="waves-effect"><i
					class="fa fa-table fa-fw" aria-hidden="true"></i><span
					class="hide-menu">Dự án</span></a></li>
			<li><a href="task.html" class="waves-effect"><i
					class="fa fa-table fa-fw" aria-hidden="true"></i><span
					class="hide-menu">Công việc</span></a></li>
		</ul>
	</div>
</div>
Left navbar-header end -->
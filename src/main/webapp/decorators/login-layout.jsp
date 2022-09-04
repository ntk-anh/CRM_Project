<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title><decorator:title /></title>
<!--Bootsrap 4 CDN-->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<!--Fontawesome CDN-->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">

<!--Custom styles-->
<link rel="stylesheet" type="text/css" href="assets/css/login.css">

<!-- thư viện toast -->
<link rel="stylesheet" href="assets/plugins/toastr/toastr.min.css">
</head>
<body>

	<decorator:body />

	
	<!-- thư viện jquery-->
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

	<!-- validate jquery -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"
		integrity="sha512-rstIgDs0xPgmG6RX1Aba4KV5cWJbAMcvRCVmglpam9SoHZiUCyQVDdH2LPlxoHtrv17XWblE/V/PP+Tr04hbtA=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script type="text/javascript">
		//$(document).ready(function() {
		$(function() {
			//Khi bàn phím được nhấn và thả ra thì sẽ chạy phương thức này
			$("#frmAction").validate({
				rules : {
					email : {
						required : true,
						minlength : 6,
						email : true
					},
					password : {
						required : true
					}
				},
				messages : {
					email : {
						required : "Vui lòng nhập email!",
						email : "Email không đúng định dạng"
					},
					password : {
						required : "Vui lòng nhập mật khẩu"
					}
				}
			});
		});
	</script>
	<!-- thư viện toast -->
	<script src="assets/plugins/toastr/toastr.min.js"></script>
	<script src="assets/js/custom.js"></script>
	
</body>
</html>
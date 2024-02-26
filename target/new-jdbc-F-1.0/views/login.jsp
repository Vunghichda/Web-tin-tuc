<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng nhập</title>
</head>
<body>
	<div class="container">
		<div class="login-form">
			<div class="main-div">
				<div class="panel">
					<h2>Đăng Nhập</h2>
				</div>
				<form action="<c:url value = '/dang-nhap'/>" id = "formLogin" method = "post">

					<div class="form-group">
						<input type="text" class="form-control" id="userName" name="userName"
							placeholder="Tên đăng nhập">
					</div>

					<div class="form-group">
						<input type="password" class="form-control" id="passWord"
							name="passWord" placeholder="Mật khẩu">
					</div>
					<div class="forgot">
						<a href="reset.html">Quên mật khẩu?</a>
					</div>
					<button type="submit" class="btn btn-primary">Đăng nhập</button>
					<input type="hidden" value="login" id="action" name="action">
				</form>
			</div>
		</div>
	</div>
</body>
</html>
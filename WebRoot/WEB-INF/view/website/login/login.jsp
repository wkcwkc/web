<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/inc/tag.jsp"%>
<!doctype html>
<html lang="zh-CN">
<head>
<c:import url="/inc/website/link.jsp"></c:import>
<script src="${_PATH}/js/website/login/login.js"></script>
</head>
<body>
	<c:import url="/inc/website/head.jsp"></c:import>
	<!-- Main content starts -->
	<div>
		前台登陆	
	</div>
	<div>
		<form id="login_form">
			<div >
				<label for="inputName" >用户名</label>
				<div>
					<input type="text" id="inputName" placeholder="用户名">
				</div>
			</div>
			<div>
				<label for="inputPassword">密码</label>
				<div >
					<input type="password" id="inputPassword" placeholder="密码">
				</div>
			</div>
			<div>
				<div>
					<div class="checkbox">
						<label> <input type="checkbox" id="remer" value="1"/> 记住帐号
						</label>
					</div>
				</div>
			</div>
			<div>
				<div>
					<button type="button" id="login">登录</button>
				</div>
			</div>				
		</form>
	</div>
	
	<a href="/login/register">没有账号？点此注册</a>
	
	<!-- Content ends -->
	<c:import url="/inc/website/footer.jsp"></c:import>

</body>
</html>
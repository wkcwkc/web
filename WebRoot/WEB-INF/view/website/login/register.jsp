<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/inc/tag.jsp"%>
<!doctype html>
<html lang="zh-CN">
<head>
<c:import url="/inc/website/link.jsp"></c:import>
<script type="text/javascript" src="${_PATH}/js/xheditor/xheditor-1.2.2.min.js"></script>
<script type="text/javascript" src="${_PATH}/js/xheditor/xheditor_lang/zh-cn.js"></script>
<script src="${_PATH}/js/website/login/register.js"></script>
</head>
<body>
	<c:import url="/inc/website/head.jsp"></c:import>
	<!-- Main content starts -->
	<div class="container">
		用户注册	
	</div>
	<div class="container">
		<form id="register_form">
			<div >
				<label for="inputName" >用户名</label>
				<div>
					<input type="text" id="name" name="name" placeholder="">
				</div>
				<div id="error-name"></div>
			</div>
			<div>
				<label for="inputPassword">密码</label>
				<div >
					<input type="password" id="password" name="password" placeholder="">
				</div>
				<div id="error-password"></div>
			</div>
			<div>
				<label for="reinputPassword">再次输入密码</label>
				<div >
					<input type="password" id="repassword" placeholder="">
				</div>
			</div>
			<div>
				<label for="nickName" >昵称</label>
				<div>
					<input type="text" id="nickName" name="nickName" placeholder="">
				</div>
			</div>
			<div>
				<label for="realName" >真实姓名</label>
				<div>
					<input type="text" id="realName" name="realName" placeholder="">
				</div>
				<div id="error-realName"></div>
			</div>
			<div>
				<label for="age" >年龄</label>
				<div>
					<input type="text" id="age" name="age" placeholder="">
				</div>
				<div id="error-age"></div>
			</div>
			<div>
				<label for="sex" >性别</label>
				<div>
					<select id="sex" name="sex">
						<option value="男">男</option>
						<option value="女">女</option>
						<option value="秀吉">秀吉</option>
						<option value=扶她">扶她</option>					
					</select>
				</div>
			</div>
			<div>
				<label for="phone" >电话</label>
				<div>
					<input type="text" id="phone" name="phone" placeholder="">
				</div>
				<div id="error-phone"></div>
			</div>
			<div>
				<label for="descript" >个人说明</label>
				<div>
					<textarea class="xheditor" id="descript" name="descript" rows="12" cols="80" style="width: 80%"></textarea>
				</div>
				<div id="error-descript"></div>
			</div>
			
			<div>
				<div>
					<button type="button" id="save_register">注册</button>
				</div>
			</div>				
		</form>
	</div>
	
	
	<!-- Content ends -->
	<c:import url="/inc/website/footer.jsp"></c:import>

</body>
</html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/inc/tag.jsp"%>
<!doctype html>
<html lang="en">
<head>
<c:import url="/inc/website/link.jsp"></c:import>
</head>
<body>
	<c:import url="/inc/website/head.jsp"></c:import>
	<!-- Main content starts -->
	<div>
		前台首页	
	</div>
	${user.name}
	<a href="/login/">用户登陆</a>
	
	<!-- Content ends -->
	<c:import url="/inc/website/footer.jsp"></c:import>

</body>
</html>
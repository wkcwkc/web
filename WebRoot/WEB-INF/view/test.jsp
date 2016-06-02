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
		test页面	
	</div>
	${user.name} ${user.nickName}
	${videoImg.id} ${videoImg.videoId}
	${video.name} ${video.videoImg.videoId}
	${userComment.id} ${userComment.word} ${userComment.video.name}
	
	<!-- Content ends -->
	<c:import url="/inc/website/footer.jsp"></c:import>

</body>
</html>
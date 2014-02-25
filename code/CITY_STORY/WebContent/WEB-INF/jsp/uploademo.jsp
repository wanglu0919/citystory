<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html lang="en">
<head>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>大城小事管理后台</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.css"
	type="text/css" media="screen" title="no title" charset="utf-8" />


<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="bootstrap/js/bootstrap.min.js"></script>

<script>
	$(document).ready(
			function() {
				$("#btn_add_province").click(
						function() {
							$("#mainFrame", parent.document.body).attr("src",
									"./admin/to_add_province")

						});

			});
</script>

<style>
</style>

</head>
<body>


	<div class="container-fluid">

		<form class="form-inline" action="./admin/add_province" method="post" enctype="multipart/form-data">
		
			<input type="file" name="file" />
			
			
			

			<button type="submit" class="btn">上传 </button>

		</form>
	</div>


</body>
</html>


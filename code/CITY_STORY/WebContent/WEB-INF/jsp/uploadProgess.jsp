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

var index;
	$(document).ready(function() {

		progess();

	});

	function progess() {
		index++;
		$.ajax({
			type : 'GET',
			url : "./admin/progess.json",
			success : function(data) {

				var p=parseInt(data);
				if (p < 100) {

					setTimeout("progess()", 500);
					$(".label").empty();
					$(".label").html(data.progess);
					
					
				} else {
					$(".label").empty();
					$(".label").html(data.progess);
				}

			},
			dataType : "json"
		});

	}
</script>

<style>
</style>

</head>
<body>

	<span class="label label-warning">d</span>
<br/>
<span class="label2 label-warning">d</span>
</body>
</html>


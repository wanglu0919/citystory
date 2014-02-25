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
	
	$(document).ready(function(){
		
		$("#war").hide();
		$("form").submit(function(){
			
			var provinceName=$("input[name='provinceName']").val();
			if(provinceName==""){
				$("#war").show();
				return false;
			}else{
				$("#war").hide();
				return true;
			}
			
			
			
		});
		
	});
	
	
</script>

<style>
</style>

</head>
<body>


	<div class="container-fluid">

		<ul class="breadcrumb">
			<li><a href="./admin/provinces">列表</a> <span class="divider">/</span></li>
			<li class="active">添加</li>

		</ul>

		<form class="form-inline" action="./admin/add_province" method="post">
			<input type="text" placeholder="请输入城市名称" name="provinceName">

			<button type="submit" class="btn">添加</button>
			<span class="label label-warning" id="war">城市名不能为空</span>
			
			<span class="label label-warning" >${requestScope.result}</span>
		</form>

	</div>



</body>
</html>


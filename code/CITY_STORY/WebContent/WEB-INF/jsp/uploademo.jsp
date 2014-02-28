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
	$(document).ready(function() {
		$("#submit").click(function() {
			//mprogess();
			
		});
		
		$("form").submit(function (){
			return true;
		});

	});

	var p = 0;
	function mprogess() {
		
		$.ajax({
			type : 'GET',
			url : "./admin/progess2",
			success : function(data) {

			
				
				var progess = parseInt(data);
				 
				if (progess < 100) {
				
					
					$(".label").empty();
					$(".label").html(data);
					mprogess();
					

					
				} else {
					
					$(".label").empty();
					$(".label").html(data);
				}

			},
			dataType : "text"
		});

	}

	
</script>

<style>
</style>

</head>
<body>


	<div class="container-fluid">

		<form class="form-inline" action="./admin/upload" method="post"
			enctype="multipart/form-data">

			<input type="file" name="file1" /> <br /> <input type="file"
				name="file2" /> <br /> <input type="text" name="text1"> <br />
			<input type="text" name="text2"> <br />
			<button type="submit" class="btn" id="submit">提交</button>



		</form>

		<span class="label label-warning">sss</span> <br /> <span
			class="label2 label-warning">sss</span>
	</div>


</body>
</html>


<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		$("#btn_add_province").click(function(){
			$("#mainFrame",parent.document.body).attr("src","./admin/to_add_province")
			
			
		});
		
		
		
		
	});
	
</script>

<style>

</style>

</head>
<body>
	

<div class="container-fluid">

<div class="btn-toolbar">
 <button class="btn btn-primary" id="btn_add_province"><i class="icon-plus"></i>添加省份</button>
  
</div>
<div class="well">
<table class="table table-striped  table-hover">
  	<thead>
  	<tr>
  	<th>序号</th>
  	<th>省份 </th>
  	<th style="width:2px"></th>
  	</tr>
  	</thead>
  	</tbody>
  	
  	<c:forEach items="${provinces}" var="province" varStatus="status">
  	<tr>
  	<td>${status.index+1 }</td>
  	<td>${province.name }</td>
  	<td>
  		<a href="#"><i class="icon-pencil"></i></a>
  	</td>
  	</tr>
  	
  	</c:forEach>
  	</tbody>
</table>
</div>
</div>


</body>
</html>


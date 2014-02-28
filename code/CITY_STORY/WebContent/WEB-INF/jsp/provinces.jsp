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


<link rel="stylesheet" href="css/style.css" />



<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="bootstrap/js/bootstrap.min.js"></script>

<script>
	var proviceId;
	$(document).ready(
			function() {
				$("#btn_add_province").click(
						function() {
							$("#mainFrame", parent.document.body).attr("src",
									"./admin/view/add/province")

						});

				$("#btn_delete").click(
						function() {//删除

							$.ajax({
								type : 'GET',
								url : "./admin/delete/province/" + proviceId
										+ ".json",

								success : function(data) {

									$("#mainFrame", parent.document.body).attr(
											"src", "./admin/view/provinces");

									alert(data.result);

								},
								dataType : "json"
							});

						});

			});

	function deleteP(pId) {

		$('#deleteDialog').modal('show');
		proviceId = pId;

	}
</script>

<style>
</style>

</head>
<body>


	<div class="container-fluid">

		<div class="btn-toolbar">
			<button class="btn btn-primary" id="btn_add_province">
				<i class="icon-plus"></i>添加省份
			</button>

		</div>
		<div class="well">
			<table class="table table-striped  table-hover">
				<thead>
					<tr>
						<th>序号</th>
						<th>省份</th>
						<th style="width: 50px;"></th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${provinces}" var="province" varStatus="status">
						<tr>
							<td>${status.index+1 }</td>
							<td>${province.name }</td>
							<td><a href="./admin/view/update/province/${province.id}"><i
									class="icon-pencil"></i></a> <a
								href="javascript:deleteP('${province.id}')"><i
									class="icon-remove"></i></a></td>
						</tr>

					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>


	<div class="modal small hide fade" id="deleteDialog" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3 id="myModalLabel">删除提示!</h3>
		</div>
		<div class="modal-body">
			<p class="error-text">
				<i class="icon-warning-sign modal-icon"></i> 确认要删除该信息吗?
			</p>
		</div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
			<button class="btn btn-danger" data-dismiss="modal" id="btn_delete">删除</button>
		</div>
	</div>



</body>
</html>


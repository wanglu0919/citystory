<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

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

		$("div .alert").hide();
		$("form").submit(function() {
			return false;
		});

		$(".btn").click(function() {

			
			if(checkInput()){
				$("div .alert").hide();
				
				
				var username = $("input[name='username']").val();
				var password = $("input[name='password']").val();
				
				var data="username="+username+"&password="+password;
				
				$.ajax({
					  type: 'POST',
					  url: "./ajaxLodin2.json",
					  data: data,
					  success: function(data){
						  
						  if(data.success){
							  
							  $("div .alert strong").empty();
								$("div .alert").hide();
								
								window.location=data.url;
								
								//alert(data.url);
						  }else{
							  
							  showWarring(data.msg);
						  }
						 
						  
					  },
					  dataType: "json"
					});
				
				
				
				
				
				
			}
			

		
		});
	});

	function showWarring(tip) {/*显示提示信息*/

		$("div .alert strong").empty();

		$("div .alert strong").append(tip);

		$("div .alert").show();

	}
	
	function checkInput(){/*检查输入*/
		var username = $("input[name='username']").val();
		var password = $("input[name='password']").val();

		var tip = "";
		if (username == "") {
			tip = "用户名不能为空";
			showWarring(tip);
			return false;

		} else if (password == "") {

			tip = "密码不能为空";
			showWarring(tip);
			return false;

		}
		
		return true;

		
		
		
	}
</script>

<style>
body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #f5f5f5;
}

.form-signin {
	max-width: 300px;
	padding: 19px 29px 29px;
	margin: 0 auto 20px;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

.form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin input[type="text"],.form-signin input[type="password"] {
	font-size: 16px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}
</style>

</style>
</head>
<body>

	<div class="login">
		<div class="alert">

			<strong>提示 !</strong>
		</div>

		<form class="form-signin">
			<h2 class="form-signin-heading">大城小事后台管理</h2>
			<span></span> <input type="text" class="input-block-level"
				placeholder="usename" name="username"> <input
				type="password" class="input-block-level" placeholder="Password"
				name="password"> <label class="checkbox"> <input
				type="checkbox" value="remember-me"> 记住我
			</label>
			<button class="btn btn-large btn-primary" type="submit">登录</button>
		</form>

	</div>

</body>
</html>


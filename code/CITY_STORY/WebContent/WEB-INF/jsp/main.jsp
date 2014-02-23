<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>

<html  lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>大城小事管理后台 </title>

		<link rel="stylesheet" href="bootstrap/css/bootstrap.css" type="text/css" media="screen" title="no title" charset="utf-8"/>
		<link rel="stylesheet" href="css/style.css" type="text/css" media="screen" title="no title" charset="utf-8"/>

		<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
		<script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>

		<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
		<script src="bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>

		<div id="navigation">

			<div class="container-fluid">
				<div class="user">
					<div class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" style="line-height: 27px;">
						<nobr><span class="use_name">wanglu</span>
						</nobr><span class="caret"></span></a>
						<ul class="dropdown-menu pull-right">
							<li>
								<a href="http://www.aftvc.com" target="mainFrame">管理帐号</a>
							</li>
							<li>
								<a href="./logout" target="_self">退出</a>
							</li>
						</ul>
					</div>
				</div>

			</div>

		</div>

		<div class="container-fluid" id="content">

			<!--左侧导航-->
			<div id="left" style="overflow: hidden;outline: none;" tabindex="5000">

				<div class="accordion" id="accordion2">
					<div class="accordion-group">
						<div class="accordion-heading">
							<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne"> 用户管理 </a>
						</div>
						<div id="collapseOne" class="accordion-body collapse in">
							<div class="accordion-inner">
								<li>
									<a href="http://www.865171.cn" target="main">添加用户</a>
								</li>
								<li>
									<a href="http://www.865171.cn" target="main">查询用户</a>
								</li>

							</div>
						</div>
					</div>
					<div class="accordion-group">
						<div class="accordion-heading">
							<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo">语录管理</a>
						</div>
						<div id="collapseTwo" class="accordion-body collapse">
							<div class="accordion-inner">
								语录增加
							</div>
						</div>
					</div>
				</div>

			</div>

			<!--right-->
			<div class="right">

				<div class="main">

					<iframe frameborder="0" id="mainFrame" name="mainFrame" src="http://www.baidu.com"></iframe>

				</div>

			</div>

		</div>
	</body>
</html>


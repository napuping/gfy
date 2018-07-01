<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath =
            request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<title>error</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- font files -->
<link href="//fonts.googleapis.com/css?family=Wallpoet" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Hind" rel="stylesheet">
<!-- /font files -->
<!-- css files -->
<link href="/static/error_template/css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- /css files -->
<!-- 浏览器标签显示的图标-->
<link rel="Shortcut Icon" href="/static/images/backtitle.png" />
<body>
	<div class="w3layouts-bg">
		<h1 class="header-w3ls">服务器开小差了！</h1>
		<div class="agileits-content" >
			<h2><span>5</span><span>0</span><span>0</span></h2>
		</div>
		
		<div class="w3layouts-right">
			<div class="w3ls-text">
				<h3>好紧张呀！</h3>
				<h4 class="w3-agileits2">赶紧去维修了！</h4>
				<p>你可以先去 <a href="home/list">这里</a> 看一下</p>
			</div>
				
		</div>
		<div class="clearfix"></div>
	</div>
</body>
</html>
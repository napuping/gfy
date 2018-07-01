<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath =
            request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<!-- 引入jquery -->
<script type="text/javascript"
	src="../../../static/jquery/jquery-3.1.1.min.js"></script>
<!-- 引入bootrap -->
<link rel="stylesheet"
	href="../../../static/bootstrap/cssjs/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="../../../static/bootstrap/cssjs/bootstrap.min.css">
<script type="text/javascript"
	src="../../../static/bootstrap/cssjs/bootstrap.min.js"></script>
<!-- 浏览器标签栏图片 -->
<link rel="Shortcut Icon" href="static/images/title.png" />

<!-- 通用js-->
<script type="text/javascript" src="../../../static/js/base/util.js"></script>
<style type="text/css">
body {
	background: #F5F6F7;
	padding-top:50px;
	cursor: pointer;
}

</style>
</head>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">

<!-- 模板需要的css js -->
<link href="../../../static/backtemplate/css/bootstrap.css"
	rel="stylesheet">
<link href="../../../static/backtemplate/css/theme.css" rel="stylesheet">
<link rel="shortcut icon"
	href="../../../static/backtemplate/ico/favicon.html">
<link href="../../../static/backtemplate/css/theme.css" rel="stylesheet">
<link href="../../../static/backtemplate/css/font-awesome.min.css"
	rel="stylesheet">

<script type="text/javascript"
	src="../../../static/backtemplate/js/jquery.min.js"></script>
<script type="text/javascript"
	src="../../../static/backtemplate/js/bootstrap.js"></script>

<!-- <link rel="stylesheet"
	href="../../../static/bootstrap/cssjs/bootstrap-select.min.css" />
<script type="text/javascript"
	src="../../../static/bootstrap/cssjs/bootstrap-select.min.js"></script> -->

<!-- pjax插件 无刷新请求 -->
<script type="text/javascript" src="../../../static/pjax/jquery.pjax.js"></script>

<!-- 引入util js -->
<script type="text/javascript" src="../../../static/js/base/util.js"></script>

<!-- 浏览器标签显示的图标-->
<link rel="Shortcut Icon" href="/static/images/backtitle.png"  />

</head>
<script type="text/javascript">
	//封装点击对应按钮 按钮变色
	function changeBg(obj) {
		$(".a_pjax").css("background", "none");
		obj.css("background", "red");
	}
	//注销
	function logout(username) {
		var f = window.confirm("用户[" + username + "]确定退出？");
		if (f) {
			var jumpurl = "/home/list";
			window.location.href = "login/logout?url=" + jumpurl;
		}
	}
</script>

</html>

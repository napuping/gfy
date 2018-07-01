<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<style type="text/css">

/*调整注册 登录按钮 居右位置*/
.nh {
	margin-left: 25px;
	font-size: 20px;
}

.nr {
	margin-right: 3px;
}

/*登录框样式*/
.form-horizontal {
	background: #fff;
	padding-bottom: 40px;
	border-radius: 15px;
	text-align: center;
	width: 500px;
	margin: 10 auto;
}

.form-horizontal .heading {
	display: block;
	font-size: 35px;
	font-weight: 700;
	padding: 35px 0;
	border-bottom: 1px solid #f0f0f0;
	margin-bottom: 30px;
}

.form-horizontal .form-group {
	padding: 0 40px;
	margin: 0 0 25px 0;
	position: relative;
}

.form-horizontal .form-control {
	background: #f0f0f0;
	border: none;
	border-radius: 20px;
	box-shadow: none;
	padding: 0 20px 0 45px;
	height: 40px;
	transition: all 0.3s ease 0s;
}

.form-horizontal .form-control:focus {
	background: #e0e0e0;
	box-shadow: none;
	outline: 0 none;
}

.form-horizontal .form-group i {
	position: absolute;
	top: 12px;
	left: 60px;
	font-size: 17px;
	color: #c8c8c8;
	transition: all 0.5s ease 0s;
}

.form-horizontal .form-control:focus+i {
	color: #00b4ef;
}

.form-horizontal .fa-question-circle {
	display: inline-block;
	position: absolute;
	top: 12px;
	right: 60px;
	font-size: 20px;
	color: #808080;
	transition: all 0.5s ease 0s;
}

.form-horizontal .fa-question-circle:hover {
	color: #000;
}

.form-horizontal .main-checkbox {
	float: left;
	width: 20px;
	height: 20px;
	background: #11a3fc;
	border-radius: 50%;
	position: relative;
	margin: 5px 0 0 5px;
	border: 1px solid #11a3fc;
}

.form-horizontal .main-checkbox label {
	width: 20px;
	height: 20px;
	position: absolute;
	top: 0;
	left: 0;
	cursor: pointer;
}

.form-horizontal .main-checkbox label:after {
	content: "";
	width: 10px;
	height: 5px;
	position: absolute;
	top: 5px;
	left: 4px;
	border: 3px solid #fff;
	border-top: none;
	border-right: none;
	background: transparent;
	opacity: 0;
	-webkit-transform: rotate(-45deg);
	transform: rotate(-45deg);
}

.form-horizontal .main-checkbox input[type=checkbox] {
	visibility: hidden;
}

.form-horizontal .main-checkbox input[type=checkbox]:checked+label:after
	{
	opacity: 1;
}

.form-horizontal .text {
	float: left;
	margin-left: 7px;
	line-height: 20px;
	padding-top: 5px;
	text-transform: capitalize;
}

.form-horizontal .btn {
	float: right;
	font-size: 14px;
	color: #fff;
	background: #00b4ef;
	border-radius: 30px;
	padding: 10px 25px;
	border: none;
	text-transform: capitalize;
	transition: all 0.5s ease 0s;
}

@media only screen and (max-width: 479px) {
	.form-horizontal .form-group {
		padding: 0 25px;
	}
	.form-horizontal .form-group i {
		left: 45px;
	}
	.form-horizontal .btn {
		padding: 10px 20px;
	}
}
</style>

</head>

<body>

	<!-- 顶部导航 -->
	<nav class="navbar navbar-default navbar-fixed-top" style="z-index:10;">
	<div class="navbar-header nh">
		<a href="/" class="navbar-brand headernav" style="color:#4BB9DA">
			<font style="color:red;font-size:20px;font-weight:bold;">I I A
				I</font>
		</a>
	</div>
	<!--向导航条里添加表单时，要添加类为 导航里的表单“navbar-form” -->
	<div class="navbar-form navbar-right nr">
		<c:choose>
			<c:when test="${not empty user }">
				<div class="btn-group">

					<button type="button" class="btn btn-default dropdown-toggle"
						data-toggle="dropdown">
						<c:choose>
							<c:when test="${not empty user.hpath }">
								<img src="${user.hpath}" alt="Odinn god of Thunder" width="30"
									style="border-radius:10px;" />
							</c:when>
							<c:otherwise>
								<img src="/static/images/header.jpg" alt="Odinn god of Thunder"
									width="30" style="border-radius:10px;" />
							</c:otherwise>
						</c:choose>

						${user.username }<span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu" style="min-width:100px;">
						<li><a href="user/mine/explain.html">个人中心</a></li>
						<li><a href="javascript:logout('${user.username }')">退出</a></li>
					</ul>
				</div>
			</c:when>

			<c:otherwise>
				<button class="btn btn-default btn-sm" id="loginshowbtn"
					data-toggle="modal">登录</button>
			</c:otherwise>

		</c:choose>
	</div>
	<!--向导航条里添加文本时，要添加类为 导航里的表单“navbar-text” -->
	<p class="navbar-text"></p>
		
	</nav>

	<!-- 登录框 -->
	<div class="modal fade" id="logindiv" data-dismiss="modal"
		aria-hidden="true">
		<form class="form-horizontal" id="loginform">
			<span class="heading">用户登录</span>
			<div class="form-group">
				<input type="email" class="form-control" id="loginusername"
					placeholder="用户名" name="username"> <i class="fa fa-user"></i>
			</div>
			<div class="form-group help">
				<input type="password" class="form-control" id="loginpassword"
					placeholder="密　码" name="password"> <i class="fa fa-lock"></i>
				<a href="#" class="fa fa-question-circle"></a>
			</div>
			<div class="form-group">
				<div class="main-checkbox">
					<input type="checkbox" value="1" id="checkbox1" name="isSave" /> <label
						for="checkbox1"></label>
				</div>
				<span class="text">自动登录</span>
				<button class="btn btn-default"
					style="outline: none;margin-left:5px;" id="loginbtn">登录</button>
				<a class="btn btn-default" style="outline: none;"
					href="javascript:register()">注册</a>
			</div>
		</form>
	</div>
	<!-- 提示框 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">提示信息</h4>
				</div>
				<div class="modal-body" id="m_text"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<script type="text/javascript">
		//注销
		function logout(username) {
			var f = window.confirm("用户[" + username + "]确定退出？");
			if (f) {
				var jumpurl = window.location.href;
				window.location.href = "login/logout?url=" + jumpurl;
			}
		}
		//注册处理
		function register() {
			var registerurl = "login/register.html";
			var urlhidden = "";
			if ($("#logindiv #urlhidden").length > 0)
				urlhidden = $("#logindiv #urlhidden").val();
			if (urlhidden != "")
				window.location.href = registerurl + "?jumpurl=" + urlhidden;
			else
				window.location.href = registerurl;
		}
		$(function() {
			//显示提示框
			$("#loginshowbtn").click(function() {
				//显示之前清除 可能因为点击实名申请按钮而添加的urlhidden
				$("#logindiv #urlhidden").remove();
				$("#logindiv").modal("show");
			});
			$("#loginbtn").click(function() {
				//验证
				if ($("#loginusername").val() == "" || $("#loginpassword").val() == "") {
					$("#myModal #m_text").html("<font color='red'>用户名、密码为空!</font>");
					$("#myModal").modal("show");
					return false;
				}
	
				var dataForm = new FormData($("#loginform")[0]);
	
				var url = "login/handLogin";
	
				util.ajaxSepical(url, dataForm, callbacks);
	
				function callbacks(data) {
					if (data.code == "200") {
						var urlhidden = "";
						if ($("#logindiv #urlhidden").length > 0)
							urlhidden = $("#logindiv #urlhidden").val();
						else
							urlhidden = window.location.href;
						window.location.href = urlhidden;
					} else if (data.code == "300") {
						$("#myModal #m_text").html("<font color='red'>" + data.message + "</font>");
						$("#myModal").modal("show");
					}
				}
				return false;
			});
		});
	</script>
</body>
</html>

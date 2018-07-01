<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="navbar navbar-fixed-top" style="margin-top:1px;">
			<div class="navbar-inner">
				<div class="container-fluid">
					<div class="logo">
						<!-- <img src="/static/backtemplate/img/logo.png"
							alt="Realm Admin Template"> -->
							<font style="color:red;font-size:18px;font-weight:bold;">I I A I</font>
					</div>
					<a class="btn btn-navbar visible-phone" data-toggle="collapse"
						data-target=".nav-collapse"> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
					</a> <a class="btn btn-navbar slide_menu_left visible-tablet"> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
					</a>

					<div class="top-menu visible-desktop">

						<ul class="pull-right">
							<li><a href="javascript:logout('${user.username }')"><i class="icon-off"></i>退出</a></li>
						</ul>
					</div>

					<div class="top-menu visible-phone visible-tablet">
						<ul class="pull-right">
							<li><a
								title="link to View all Messages page, no popover in phone view or tablet"
								href="#"><i class="icon-envelope"></i></a></li>
							<li><a
								title="link to View all Notifications page, no popover in phone view or tablet"
								href="#"><i class="icon-globe"></i></a></li>
							<li><a href="login.html"><i class="icon-off"></i></a></li>
						</ul>
					</div>

				</div>
			</div>
		</div>
	<script type="text/javascript">
		//注销
		function logout(username){
			if(username == ""){
				alert("会话已过期，请重新登录");
				window.location.href = "home/list";
				return;
			}
			var f = window.confirm("用户["+username+"]确定退出？");
			if(f){
				var jumpurl = "/home/list";
				window.location.href = "login/logout?url=" + jumpurl;
			}
		}
	</script>

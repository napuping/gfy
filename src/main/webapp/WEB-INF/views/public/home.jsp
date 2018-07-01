<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../base/base.jsp"%>
<%@include file="../base/process.jsp"%>
<%@include file="../base/header.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
<head>

<title>主页</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="项目，设计，代理，服务">
<meta http-equiv="description" content="项目信息列表，项目详细信息">
<meta name="robots" content="follow">
<!-- pjax插件 无刷新请求 -->
<script type="text/javascript" src="../../../static/pjax/jquery.pjax.js"></script>
<script type="text/javascript" src="/static/js/base/third.js"></script>

<style type="text/css">
body {
	background: #F5F6F7;
}

.panel {
	padding: 5 5;
	margin-bottom: -10px;
}
/*此属性是在后台生成分页按钮时设置，用于使当前页按钮变色*/
.activepbtn {
	background: gray;
}

.panel-heading {
	font-size: 16px;
}

.panel-body {
	font-size: 14px;
}

.p_content {
	background: white;
	padding: 5 5;
	padding-bottom: 0px;
	box-shadow: 0px 0px 1px 1px white;
	border-radius: 5px;
	box-shadow: 0px 0px 1px 1px white;
}

.p_heading {
	box-shadow: 0px 0px 1px 1px white;
	background: white;
	padding-left: 5px;
	padding-right: 5px;
	border-radius: 5px;
	padding-top: 15px;
	margin-bottom: 15px;
	padding-bottom: 15px;
}

.p_pagebtn {
	text-align: center;
	font-size: 10px;
}

.p_content_item {
	font-size: 10px;
}

.glyphicon {
	font-size: 10px;
}

.p_pross {
	border: 1px solid red;
	position: absolute;
	top: 0px;
	width: 0px;
	display: none;
}

#applybtndiv {
	position: absolute;
	right: 15px;
	top: 300px;
	text-align: center;
}
</style>
</head>

<body onload="load()">

	<!-- 提交申请 选项 -->
	<div id="applybtndiv">
		<a class="btn btn-info" href="user/anonymous/apply.html">匿名申请</a><br />
		<br /> <a class="btn btn-success" id="usernameapplybtn">实名申请</a><br />
		<br /> <a data-toggle="popover"
			data-placement="left" data-trigger="hover" class="btn btn-default"
			id="share">分享</a>
	</div>
	<!-- 进度条 -->
	<div class="p_pross" id="p_pross" style="z-index:900;"></div>

	<div id="pjax_content"
		style="width:900px;margin: 10 auto;font-size:16px;font-family:'宋体'">

		<div class="p_heading">

			<div id="typediv">
				<a href="${alltypeurl }"
					class="alltype btn btn-default btn-xs pjax_a">全部类型</a>
				<c:forEach items="${types }" var="t">
					<a href="${t.url }"
						class="${t.tcode } btn btn-default btn-xs pjax_a">${t.showtext }</a>
				</c:forEach>
			</div>
			<hr />
			<div id="landiv">
				<a href="${alllanurl }" class="alllan btn btn-default btn-xs pjax_a">全部语言</a>
				<c:forEach items="${lans }" var="l">
					<a href="${l.url }"
						class="${l.tcode } btn btn-default btn-xs pjax_a">${l.showtext }</a>
				</c:forEach>
			</div>
			<hr />
			<div id="orderdiv">
				<span class="allorder btn btn-default btn-xs">排序</span> <a
					href="${time }" class="committime btn btn-default btn-xs pjax_a">时间</a>
				<a href="${comment }" class="comments btn btn-default btn-xs pjax_a">评论</a>
				<a href="${look }" class="look btn btn-default btn-xs pjax_a">浏览</a>
			</div>

		</div>
		<div class="p_content">
			
			<c:choose>
				<c:when test="${page.data != null and page.data.size()>0 }">
					<c:forEach items="${page.data }" var="p">
						<div class="p_content_detail panel panel-info">
							<div class="panel-heading"
								style="height:30px;line-height: 30px;padding:0 0;">
								<a class="adetail" href="/project/${p.projectId }.html">${p.projectname}</a>
							</div>
							<div class="panel-body">${p.projectdesc }</div>
							<div class="panel-footer">
								<span class="glyphicon glyphicon-comment"></span> <span
									class="p_content_item">${p.comments }</span> <span
									class="glyphicon glyphicon-eye-open"></span> <span
									class="p_content_item">${p.look }</span> <span
									class="glyphicon glyphicon-user"></span> <span
									class="p_content_item"> <c:choose>
										<c:when test="${empty p.username }">匿名</c:when>
										<c:otherwise>${p.username }</c:otherwise>
									</c:choose>
								</span> <span class="glyphicon glyphicon-time"></span> <span
									class="p_content_item"><fmt:formatDate
										value="${p.committime }" pattern="yyyy/MM/dd HH:mm:ss" /></span>
							</div>
						</div>
						<br />
					</c:forEach>
				</c:when>
				<c:otherwise>
					<div class="panel panel-info">
						<font color="red">资源干涸中。。。</font>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="p_pagebtn">
			<ul class="pagination">${btns }
		</div>
	</div>


	<script type="text/javascript">
	
		$(function() {
			//初始化 applybtndiv位置
			$("#applybtndiv").css("top", (window.screen.height - 100) / 2);
			//滑动鼠标时 固定applybtndiv位置
			/* $(window).resize(function(){
				$("#applybtndiv").css("top",(window.screen.height-100) /2);
			}); */
			$(window).scroll(function() {
				$("#applybtndiv").css({
					"position" : "absolute",
					"top" : $(this).scrollTop() + (window.screen.height - 100) / 2,
					"z-index" : "1"
				});
			});
	
			var home = {
				color : "#4BB9DA",
				changeBg : function(divid, clazz, all, color) {
					if (clazz == "")
						$("#" + divid).find("." + all).css("background", home.color);
					else
						$("#" + divid).find("." + clazz).css("background", home.color);
				}
			};
			//选中的参数按钮变色
			var activetype = "${activetype}";
			home.changeBg("typediv", activetype, "alltype", "");
			var activelan = "${activelan}";
			home.changeBg("landiv", activelan, "alllan", "");
			var acriveorder = "${activeorder}";
			home.changeBg("orderdiv", acriveorder, "allorder", "");
			//pjax
			$(".pjax_a").click(function() {
				var urls = $(this).attr("href");
				/* if(urls.indexOf("?") != -1)
					urls += "&c=" + new Date().getTime();
				else
					urls += "?c=" + new Date().getTime(); */
				$.pjax({
					url : urls,
					container : "#pjax_content",
					cache : false,
				});
				return false;
			});
			//pjax 预加载事件
			var i = 0; //进度条增长基数
			var s; //定时器变量
			$(document).on("pjax:send", function() {
				$("#p_pross").show();
				s = setInterval(function() {
					i += 5;
					$("#p_pross").animate("width", i);
				}, 1000)
			});
	
			//pjax 加载完成之后事件
			$(document).on("pjax:complete", function() {
				clearInterval(s);
				var width = $(window).width();
				//$("#p_pross").css("width",width)
				$("#p_pross").animate({
					width : width
				});
	
				$("#p_pross").animate({
					"width" : 0
				}, 1, function() {
					$("#p_pross").hide();
				});
	
			});
			//实名申请处理
			$("#usernameapplybtn").click(function() {
				var user = "${user}";
				if (user == "") {
					//如果用户为登录 则需要让用户先登录 然后在自动跳转到 申请页面
					var urlhidden = "<input type='hidden' value='user/mine/project/apply.html' id='urlhidden'>";
					if ($("#logindiv #urlhidden").length == 0)
						$("#logindiv").append(urlhidden);
	
					$("#logindiv").modal("show");
				} else
					window.location.href = "user/mine/project/apply.html";
				return false;
			});
			
			//分享弹出框事件
			$("#share").popover({
				html : true,
				title : title(),
				delay : {
					show : 200,
					hide : 1000
				},
				content : function() {
					return content();
				}
			});
			
			function title() {
				return "";
			}
			function content() {
				var data = "<div style='text-align:center;'><a class='btn btn-default btn-sm' onclick='javascript:qqsharebtn(this)' version='1.0' target='_blank'>QQ分享</a><br/>"+
				"<a class='btn btn-default btn-sm' style='margin-top:5px;' target='_blank' onclick='javascript:weibosharebtn(this)'>微博分享</a></div>";
				return data;
			}
			
		});
		//qq分享按钮click事件
		function qqsharebtn(obj){
			var url = "http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?" + qqshare();
			$(obj).attr("href", url);
		}
		//微博分享click事件
		function weibosharebtn(obj){
			var url = "http://service.weibo.com/share/share.php?" + weiboshare();
			$(obj).attr("href", url);
		}
	</script>
</body>
</html>

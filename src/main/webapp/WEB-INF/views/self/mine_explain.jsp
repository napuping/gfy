<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- 页面加载进度条 -->
<%@include file="../base/process.jsp" %>
<!-- 后台模板css js 以及改变pjax按钮颜色方法 -->
<%@include file="../base/backbase.jsp" %>
<!-- pjax及进度pjax进度条  请求封装 -->
<%@ include file="../base/pjax_process.jsp" %>
<html>
<head>

<title>说明</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!-- 引入pjax 效果 封装函数 为内容单独做pjax效果 -->
<script type="text/javascript" src="../../../static/js/base/pjax.js"></script>

<style type="text/css">
	.a_explain{
		background: red;
	}

</style>

</head>

<body onload="load()">

	<div id="wrap" >
		
		<!-- 引入头部 -->
		<%@include file="../base/backheader.jsp" %>
		
		<div class="container-fluid">
			<!-- 引入左侧菜单 -->
			<%@include file="../base/backleft.jsp" %>

			<!-- Main window -->
			<!-- 主窗体 -->
			<div class="main_container" id="p_content">
				<div class="row-fluid">
					<ul class="breadcrumb">
						<li><span class="divider">/</span></li>
						<li>说明 <span class="divider">/</span></li>
					</ul>
					<h2 class="heading">有些话</h2>
				</div>
				<!-- /row-fluid -->

				<div class="row-fluid">
					<div class="widget widget-padding span12">
						<div class="widget-header">
							<i class="icon-group"></i>
							<h5>${notify.notifytitle }</h5>
						</div>
						<div class="widget-body" style="border:1px solid red">
							<%
								request.setAttribute("backs", "\n");
							 %>
							${fn:replace(notify.notifycontent,backs,"<br/>") }
						</div>
						<!-- /widget-body -->
					</div>
					<!-- /widget -->
				</div>
				<!-- /row-fluid -->

			</div>
			<!-- /Main window -->
		</div>
		<!--/.fluid-container-->
	</div>
	
	
	<script type="text/javascript">
		$(function(){
			$("#paybtn").click(function(){
				//准备参数 /{orderNumber}/{type}/{totalAmount}
				var orderNumber = "201852821519750";
				var type = "4";//传入将要改变的类型
				var totalAmount = "5.00";
				var url = "pay/" + orderNumber + "/" + type + "/" + totalAmount;
				function callbacks(data){
					if(data.code == "300"){
						alert(data.message);
					}else{
						$("#paymodal").modal("show");
						$("#alipaycode").attr("src",data.data);
					}
				}
				util.ajaxNormal(url, "", callbacks);
			});
		
		});
		
		
		
		
		
		
		
		
	</script>
</body>
</html>

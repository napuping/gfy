<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- 页面加载进度条 -->
<%@include file="../base/process.jsp"%>
<!-- 后台模板css js 以及改变pjax按钮颜色方法 -->
<%@include file="../base/backbase.jsp"%>
<!-- pjax及进度pjax进度条  请求封装 -->
<%@ include file="../base/pjax_process.jsp"%>
<html>
<head>

<title>意见【${user.username }】</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!-- 引入pjax 效果 封装函数 为内容单独做pjax效果 -->
<script type="text/javascript" src="../../../static/js/base/pjax.js"></script>


<style type="text/css">
.a_advice{
	background: red;
}
</style>




</head>

<body onload="load()">
	<div id="wrap">

		<!-- 引入头部 -->
		<%@include file="../base/backheader.jsp"%>

		<div class="container-fluid">

			<!-- 引入左侧菜单 -->
			<%@include file="../base/backleft.jsp"%>


			<!-- Main window -->
			<div class="main_container" id="p_content">

				<div class="row-fluid">
					<ul class="breadcrumb">
						<li><span class="divider">/</span></li>
						<li>其他<span class="divider">/</span></li>
						<li>提点意见 <span class="divider">/</span></li>

					</ul>
					<h3 class="heading">意见</h3>
				</div>
				<!-- /row-fluid -->

				<div class="row-fluid">
					<div class="widget widget-padding span12">
						<div class="widget-header">
							<i class="icon-group"></i>
							<h5>提点意见</h5>
							<div class="widget-buttons">
								<a href="javascript:void(0)" onclick="commitadvice(this)"
									style="color:black">提交</a>
							</div>
						</div>
						<div class="widget-body" style="">
							<form id="adviceform">
								<table class="table"> 
									<tr >
										<td><span style="font-weight: bold">建议描述</span></td>
										<td>
											<input placeholder="请输入建议描述" type="text" name="advicedesc" style="width:330px;height:35px;" /> 
										</td>
									</tr>
									
									<tr >
										<td ><span style="font-weight: bold">建议内容</span></td>
										<td>
											<textarea placeholder="请输入建议内容" style="width:330px;height:180px;" name="advicecontent"></textarea>
										</td>
									</tr>
									<tr>
										<td colspan="2"></td>
									</tr>
								</table>
							</form>

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
	<!-- wrap ends-->
	<script type="text/javascript">
		function commitadvice(){
			var f = confirm("确定提交？");
			if(f){
				//验证
				var desc = $("#adviceform").find("input[name=advicedesc]").val();
				if(desc == ""){
					alert("描述不能为空");
					return;
				}
				var content = $("#adviceform").find("input[name=advicecontent]").val();
				if(content == ""){
					alert("内容不能为空");
					return;
				}
				var datas = new FormData($("#adviceform")[0]);
				var url = "user/mine/commitAdvice";
				function callbacks(data){
					if(data.code == '200')
						alert(data.message);
					else if(data.code == "300")
						alert(data.message)
				}
				util.ajaxSepical(url, datas, callbacks);
			}
		}
	</script>
</body>
</html>

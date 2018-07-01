<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../base/base.jsp"%>
<%@include file="../base/header.jsp"%>
<%@include file="../base/process.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>匿名申请</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<style>
#m_content {
	width: 730px;
	margin: 10 auto;
	padding: 8 5;
	padding-bottom: 2px;
}

hr {
	margin-top: 0px;
	margin-bottom: 4px;
}
</style>
</head>

<body onload="load()">

	<div id="m_content" class="panel panel-default">
		<span style="font-weight: bold ;font-size:18px;">项目申请</span>
		<a href="tencent://message/?uin=1841456435&Site=Sambow&Menu=yes" style="margin-left:580px;">
			<font color="#82B9F7">联系我</font>
		</a>
		<hr />
		<form role="form" style="border:0px solid gray;padding:5 5;"
			id="projectform">
			<!-- 匿名 标识 字段 -->
			<input type="hidden" name="isanonymous" value="0" />
			<div class="form-group">
				<label for="name">项目名称</label> <input type="text"
					id="projectnameinput" name="projectname" style="width:300px;"
					class="form-control" placeholder="请输入项目名称">
			</div>
			<div class="form-group">
				<label for="name">项目描述</label>
				<textarea class="form-control" rows="10" name="projectdesc"
					placeholder="请输入项目描述" style="width:300px;height:100px;"></textarea>
			</div>
			<div class="form-group">
				<label for="name">联系方式</label> <input type="text"
					id="contactwayinput" name="contactway" style="width:300px;"
					class="form-control" placeholder="请留下qq号或手机号">
			</div>
			<div class="form-group" style="width:300px;">
				<label for="name">选择类型</label> <select class="form-control"
					name="typecode">
					<option disabled>--选择类型--</option>
					<c:forEach items="${types }" var="t">
						<option value="${t.tcode }"
							<c:if test="${t.tcode == 'web' }">selected</c:if>
							<c:if test="${t.tcode != 'web' }">disabled</c:if>>${t.showtext }</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group" style="width:300px;">
				<label for="name">选择语言</label> <select class="form-control"
					name="lancode">
					<option disabled>--选择语言--</option>
					<c:forEach items="${lans }" var="l">
						<option value="${l.tcode }"
							<c:if test="${l.tcode == 'java' }">selected</c:if>
							<c:if test="${l.tcode != 'java' }">disabled</c:if>>${l.showtext }</option>
					</c:forEach>
				</select>
			</div>
			<label for="name">查看对象</label>
			<div>
				<input type="radio" name="pflag" id="optionsRadios3" value="0"
					checked>所有人 <input type="radio" disabled name="pflag"
					id="optionsRadios4" value="1"> 个人
			</div>
			<br />
			<div class="form-group">
				<div class="">
					<button type="submit" title="上传需求文档"
						onmouseover="$(this).tooltip('show')" class="btn btn-default"
						id="filebtn">文档上传</button>
					<span id="showfile"></span>
					<div id="realfilediv">
						<input type="file" id="fileinput" name="file"
							style="display: none;">
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="">
					<button type="submit" class="btn btn-success" id="applybtn">申请</button>
				</div>
			</div>

		</form>
	</div>

	<script type="text/javascript">
		$(function() {
			//是否绑定改变事件标志
			var changeflag = false;
			$("#filebtn").click(function() {
				$("#fileinput").trigger("click");
				if (!changeflag) {
					$("#fileinput").change(function() {
						var file = $(this)[0].files[0];
						if (file.type.indexOf("text") != -1 || file.type.indexOf("document") != -1) {
							$("#showfile").text(file.name);
						} else {
							alert("上传文件格式不合格！");
							$(this).val('');
							$("#showfile").text('');
						}
					});
				}
				changeflag = true;
				return false;
			});
			//申请
			$("#applybtn").click(function() {
				//校验
				if ($("#projectnameinput").val() == "") {
					alert("项目名称不能为空！");
					return false;
				}
				if ($("#contactwayinput").val() == "") {
					alert("请留下联系方式，便于联系！");
					return false;
				}
				var url = "project/apply";
				var data = new FormData($("#projectform")[0]);
				function callbacks(data) {
					if (data.code == '200') {
						alert("申请成功！请等待消息！");
						window.location.href = "home/list";
					} else {
						alert(data.message);
					}
				}
				util.ajaxSepical(url, data, callbacks);
				return false;
			});
	
		});
	</script>
</body>
</html>

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

<title>个人中心【${user.username }】</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!-- 引入pjax 效果 封装函数 为内容单独做pjax效果 -->
<script type="text/javascript" src="../../../static/js/base/pjax.js"></script>


<style type="text/css">
.a_info {
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
						<li>个人设置 <span class="divider">/</span></li>
						<li>个人信息 <span class="divider">/</span></li>

					</ul>
					<h3 class="heading">个人信息</h3>
				</div>
				<!-- /row-fluid -->

				<div class="row-fluid">
					<div class="widget widget-padding span12">
						<div class="widget-header">
							<i class="icon-group"></i>
							<h5>个人信息</h5>
							<div class="widget-buttons">
								<a href="javascript:void(0)" onclick="update(this)"
									style="color:black">修改</a>
							</div>
						</div>
						<div class="widget-body" style="">

							<div style="padding-left:10px;">
								<img alt="header" src="${empty user.hpath ? '/static/images/header.jpg' : user.hpath  }" title="点击更换头像"
									onmouseover="$(this).tooltip('show')"
									onclick="changeheader(this)"	style="border-radius:8px;width:80" />&nbsp;&nbsp;&nbsp; <span>${user.username }</span>
									<input type="file" id="headerfile"  style="display: none;"/>
							</div>
							<hr style="margin:4 4;"/>
							<div style="padding-left:10px;">
							<form id="updateform">
								<input type="hidden" name="userId" value="${user.userId }" />
								<table class="table table-striped" id="infotable">

									<tr>
										<td>用户名</td>
										<td><input
											disabled="disabled" type="text" value="${user.username }" /></td>
									</tr>
									<tr>
										<td>密码</td>
										<td><input disabled="disabled" type="text" value="******" /></td>
									</tr>
									<tr>
										<td>状态</td>
										<td><input type="text" disabled="disabled"
											value="${user.sflag == '0'? '启用' : '禁用' }" /></td>
									</tr>
									<tr>
										<td>年龄</td>
										<td><input class="nupdate" name="age" disabled="disabled" id="ageinput"
											type="text"
											placeholder="${empty user.age ? '未填写' : '' }" value="${empty user.age ? '' : user.age }" /></td>
									</tr>
									<tr>
										<td>性别</td>
										<td><c:choose>
												<c:when test="${empty user.sex }">
													<input id="sexwei" type="text" disabled="disabled" value="未填写" />
													<div style="display: none;" id="sexdiv">
														<input type="radio" name="sex" checked="checked" value="0">男
														<input type="radio" name="sex" value="1">女
													</div>
												</c:when>
												<c:otherwise>
													<input class="nupdate" disabled="disabled" type='radio' name="sex" ${user.sex == '0'? 'checked' : '' } value="0" />男
													<input class="nupdate" disabled="disabled" type='radio' name="sex"  ${user.sex == '1'? 'checked' : '' } value="1" />女
												</c:otherwise>
											</c:choose></td>
									</tr>
									<tr>
										<td>qq</td>
										<td><input class="nupdate" name="qq" disabled="disabled"  id="qqinput"
										placeholder="${empty user.qq ? '未填写' : '' }" value="${empty user.qq ? '' : user.qq }"
											type="text" /></td>
									</tr>
									<tr>
										<td>学校</td>
										<td><input class="nupdate" name="school" id="schoolinput"
											disabled="disabled" type="text" 
											placeholder="${empty user.school ? '未填写' : '' }"
												 value="${empty user.school ? '' : user.school }"/></td>
									</tr>
									<tr>
										<td>电话</td>
										<td><input 
											disabled="disabled" type="text" placeholder="${user.phone}" /></td>
									</tr>
									<tr>
										<td>注册时间</td>
										<td><input
											disabled="disabled" type="text"
											value="<fmt:formatDate value='${user.registertime }' pattern='yyyy/MM/dd HH:mm'/>" />
										</td>
									</tr>
									<tr>
										<td>自我介绍</td>
										<td><textarea class="nupdate" name="selfsay" id="selfinput"
											placeholder="${empty user.selfsay ? '未填写' : '' }" 
												disabled="disabled" style="width:300px;height:40px;">${empty user.selfsay ? '' : user.selfsay }</textarea>
										</td>
									</tr>
								</table>
							</form>
							</div>

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
		function update(obj){
			$(".nupdate").removeAttr("disabled");
			//处理性别单选按钮
			$("#sexdiv").show();
			$("#sexwei").hide();
			//将当前按钮改为取消修改
			$(obj).text("取消修改").attr("onclick","updatecancle(this)");
			//并添加修改按钮
			var tr = "<tr id='surebtn'><td colspan='2'><a class='btn btn-default' href='javacript:void()' onclick='updatesure()'>修改</a></td></tr>";
			$("#infotable").append(tr);
		}
		function updatecancle(obj){
			$(".nupdate").attr("disabled","disabled");
			$("#surebtn").remove();
			$(obj).text("修改").attr("onclick","update(this)");
			//处理性别单选按钮
			$("#sexdiv").hide();
			$("#sexwei").show();
		}
		function updatesure(){
			var f = confirm("确定更新？")
			if(f){
				//做验证
				//验证年龄
				var val = $("#ageinput").val();
				var par = /^[1-9]\d{1,2}$/;
				if(!(par.test(val)) || parseInt(val) > 200){
					alert("年龄不合法！");
					return;
				}
				//验证qq
				val = $("#qqinput").val();
				par = /^[1-9]\d{5,11}\d$/;
				if(val != ""  && !(par.test(val))){
					alert("qq不合法！");
					return;
				}
				
				var url = "/user/mine/updateSelf";
				var datas = new FormData($("#updateform")[0]);
				function callbacks(data){
					if(data.code == '200'){
						alert("更新成功！");
						//做处理
						location.href = location.href;
					}else if(data.code == '300')
						alert(data.message);
				}
				util.ajaxSepical(url, datas, callbacks);
			}
		}
		//更改头像
		function changeheader(obj){
			var img = $(obj);
			$("#headerfile").trigger("click");
			$("#headerfile").unbind("change");
			$("#headerfile").change(function(){
				var file = $(this)[0].files[0];
				if(file.type.indexOf("image") == -1){
					alert("选择的不是图片！");
					$(this).val('');
					return;
				}else{
					//上传图片
					var userId = "${user.userId}"
					var url = "user/mine/changeHeader";
					var datas = new FormData();
					datas.append("header", file);
					datas.append("userId",userId);
					function callbacks(data){
						if(data.code == "200"){
							alert(data.message);
							img.attr("src",data.data);
						}else if(data.code == "300")
							alert(data.message);
					}
					util.ajaxSepical(url, datas, callbacks, function(data) {
					})
				}
			});
		}
	</script>
</body>
</html>

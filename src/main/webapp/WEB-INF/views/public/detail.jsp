<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../base/base.jsp"%>
<%@include file="../base/header.jsp"%>
<%@include file="../base/process.jsp"%>
<!-- 分享jsp -->
<%@include file="../base/baseshare.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>详情页面-${project.projectname }</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="项目，设计，代理，服务">
<meta http-equiv="description" content="项目信息列表，项目详细信息">
<meta name="robots" content="follow">

<link rel="stylesheet"
	href="../../../static/kindeditor/themes/default/default.css" />
<link rel="stylesheet"
	href="../../../static/kindeditor/themes/example1/example1.css" />

<script charset="utf-8"
	src="../../../static/kindeditor/kindeditor-all.js"></script>
<script charset="utf-8" src="../../../static/kindeditor/lang/zh-CN.js"></script>

<style>
</style>
</head>

<body onload="load()">

	<div class="detailarea panel panel-default"
		style="width:900px;margin:10 auto;padding:10 10;">
		<label><font size="4px;">项目信息</font></label>
		<hr style="margin-top:5px;margin-bottom:4px;" />
		<table class="table table-striped table-bordered dataTable">
			<tbody>
				<tr>
					<td>项目名称</td>
					<td>${project.projectname }</td>
				</tr>
				<tr>
					<td>项目描述</td>
					<td>${project.projectdesc }</td>
				</tr>
				<tr>
					<td>项目类型</td>
					<td>${project.typetext }</td>
				</tr>
				<tr>
					<td>项目语言</td>
					<td>${project.lantext }</td>
				</tr>
				<tr>
					<td>项目状态</td>
					<td>${project.statustext }</td>
				</tr>
				<tr>
					<td>项目总额</td>
					<td><input type="hidden" value="${project.totalmoney }" />
						***</td>
				</tr>
				<tr>
					<td>申请人</td>
					<td>${project.username == null ? '匿名' : project.username }</td>
				</tr>
				<tr>
					<td>申请时间</td>
					<td><fmt:formatDate value="${project.committime }"
							pattern="yyyy/MM/dd HH:mm:ss" /></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- 记录参数 传后台 -->
	<input type="hidden" value="${project.projectId }" id="projectIdHidden" />

	<!-- 评论框 -->
	<div class="modal fade" id="commentmodal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content" style="width:900px;">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">评论</h4>
				</div>
				<div class="modal-body" style="padding-left:50px;">
					<textarea style="width:800px;height:400px;" class="form-control"
						id="commenteditor"></textarea>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" id="commentbtn">评论</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>

	<div class="commentarea panel panel-default"
		style="width:900px;margin:10 auto;padding:5 5;">
		<label><font size="4px;">评论</font>(${count })</label>

		<button class="btn btn-info btn-xs pull-right" id="commentshowbtn"
			style="margin-top:4px;">评论</button>

		<hr style="margin-bottom:4px;margin-top:5px;" />
		<c:if test="${page.data.size()==0 }">
			<div>
				<font color="red">暂无评论！</font>
			</div>
		</c:if>
		<c:if test="${page.data.size()>0 }">
			<c:forEach items="${page.data }" var="p">
				<div class="panel panel-default commentdiv"
					style="border:1px solid #DDDDDD;padding:5 5;border-radius:5px;">

					<span style="color:#5BC0DE;font-size:18px;">${ p.username}</span> : ${p.content}
					
					<button class="btn btn-default btn-xs replyshowbtn replyshowbtnexp">回复</button>
					<div style="width:600px;margin-top:5px;padding:5 5;display: none;">
						<textarea class="form-control" style="width:500px;height:150px;"></textarea>
						<input type="hidden" name="commentIdHidden"
							value="${p.commentId }" />
						<button style="margin-top:5px;"
							class="btn btn-info btn-sm replybtn replybtnexp">回复</button>
					</div>
					<hr style="margin-top:5px;" />
					<!-- 此div存放ajax动态加载的分页数据 -->
					<div class="loaddiv">
						<c:if test="${p.subPage.data.size()>0 }">
							<div
								style="border:1px solid #DDDDDD;padding:5 5;
									margin-left:20px;margin-top:5px;border-radius:5px;">
								<c:forEach items="${p.subPage.data }" var="s">
									<c:choose>
										<c:when test="${s.parentId == p.commentId }">
											${s.username} ： ${s.content}
											<button class="btn btn-default btn-xs replyshowbtn">回复</button>
											<div
												style="width:600px;margin-top:5px;padding:5 5;display: none;">
												<textarea class="form-control"
													style="width:500px;height:150px;"></textarea>
												<input type="hidden" value="${s.commentId }">
												<button style="margin-top:5px;"
													class="btn btn-info btn-sm replybtn">回复</button>
											</div>
											<hr />
										</c:when>
										<c:otherwise>
											${s.username}@${s.username2 } ： ${s.content }
											<button
												class="btn btn-default btn-xs replyshowbtn replyshowbtn">回复</button>
											<div
												style="width:600px;margin-top:5px;padding:5 5;display: none;">
												<textarea class="form-control"
													style="width:500px;height:150px;"></textarea>
												<input type="hidden" value="${s.commentId }">
												<button style="margin-top:5px;"
													class="btn btn-info btn-sm replybtn">回复</button>
											</div>
											<hr />
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</div>
						</c:if>
						<!-- 子评论分页 -->
						<div style="margin-left:20px;">
							<ul class="pagination" style="margin-top:5px;margin-bottom:5px;">${p.subPage.generateButton('')}</ul>
						</div>

					</div>
					<!-- loaddiv -->
				</div>
			</c:forEach>
		</c:if>
		<div class="p_pagebtn" style="text-align: center;">
			<ul class="pagination" style="margin-top:5px;margin-bottom:5px;">${btns }</ul>
		</div>
	</div>

	<br>

	<!-- ajax动态数据区使用的js -->
	<script type="text/javascript">
		$(function() {
			$(".commentdiv .a_pjax").click(function() {
				var commentdiv = getObj($(this), 5);
				var curPage = $(this).attr("href");
				var parentId = commentdiv.find("input[name=commentIdHidden]").val();
				var loaddiv = commentdiv.find(".loaddiv");
				loaddiv.load("project/subPage", {
					curPage : curPage,
					parentId : parentId
				});
				return false;
			});
			function getObj(clazz, num) {
				var res = clazz;
				for (var i = 1; i <= num; i++) {
					res = getObjProcess(res);
				}
				return res;
			}
			function getObjProcess(clazz) {
				return clazz.parent();
			}
			//显示回复框
			$(".replyshowbtn").click(function() {
				$(this).next().toggle(250);
			});
			$(".replybtn").click(function() {
				//回复
				var projectId = $("#projectIdHidden").val();
				var parentId = $(this).prev().val();
				var content = $(this).prev().prev().val();
				var url = "comment/reply";
				function callbacks(data) {
					if (data.code == "200") {
						alert(data.message);
						window.location.href = window.location.href;
					} else
						alert(data.message);
				}
				util.ajaxNormal(url, {
					projectId : projectId,
					parentId : parentId,
					content : content
				}, callbacks);
	
			});
		});
	</script>
	<!-- 全局使用 的js-->
	<script type="text/javascript">
		// 关闭过滤模式，保留所有标签
		KindEditor.options.filterMode = false;
		var options = {
			resizeType : 0,
			filePostName : "imgFile",
			uploadJson : "comment/upload",
			extraFileUploadParams : {
				"csrfmiddlewaretoken" : "{{ csrf_token }}"
			},
			dir : "image",
			themeType : 'example1',
			allowImageUpload:true,
		};
		KindEditor.ready(function(K) {
			var editor = K.create('#commenteditor',options);
	
			$("#commentshowbtn").click(function() {
				//	editor.sync();
				//	var projectId = $("#projectIdHidden").val();
				//一级评论 parentId为空
				//alert($("#commenteditor").val())
				//验证是否是登录用户且是否该信息是否是本人发表
				var userIdL = "${user.userId}";
				var userId = "${project.userId}";
				var status = "${project.status}";
				if (userIdL == "" || userId == "" || userIdL != userId) {
					alert("没有权限评论！");
				} else if (status == '2' || status == '0')
					alert("当前状态无法评论");else {
					$("#commentmodal").modal("show");
				}
			});
			$("#commentbtn").click(function() {
				editor.sync();
				var projectId = $("#projectIdHidden").val();
				var content = $("#commenteditor").val();
				if (content == "") {
					alert("内容不能为空！");
					return;
				}
				var url = "comment/comment";
				function callbacks(data) {
					if (data.code == "200") {
						alert(data.message);
						window.location.href = window.location.href;
					} else {
						alert(data.message);
					}
				}
				util.ajaxNormal(url, {
					projectId : projectId,
					content : content
				}, callbacks);
			});
	
	
	
	
		});
	</script>
</body>
</html>

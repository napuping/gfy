<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row-fluid">
	<ul class="breadcrumb">
		<li><span class="divider">/</span></li>
		<li>我的项目 <span class="divider">/</span></li>
		<li>项目列表 <span class="divider">/</span></li>
		<li>项目更新 <span class="divider">/</span></li>
	</ul>
	<h3 class="heading">项目更新</h3>
</div>
<!-- /row-fluid -->

<div class="row-fluid">
	<div class="widget widget-padding span12">
		<div class="widget-header">
			<i class="icon-group"></i>
			<h5>项目信息</h5>
			<div class="widget-buttons">
				<a href="javascript:void(0)" onclick="backPrev()">返回</a>
			</div>
		</div>
		<div class="widget-body" style="border:1px solid red">
			<div id="m_content" class="panel panel-default">
				<form role="form" style="border:0px solid gray;padding:5 5;"
					id="updateform">
					<input type="hidden" name="projectId" value="${project.projectId }" />
					<div class="form-group">
						<label for="name">项目名称</label> <input type="text"
							value="${project.projectname }" id="projectnameinput"
							name="projectname" style="width:300px;" class="form-control"
							placeholder="请输入项目名称">
					</div>
					<div class="form-group">
						<label for="name">项目描述</label>
						<textarea class="form-control" rows="10" name="projectdesc"
							placeholder="请输入项目描述" style="width:300px;height:100px;">${project.projectdesc }</textarea>
					</div>
					<div class="form-group">
						<label for="name">联系方式</label> <input type="text"
							value="${project.contactway }" id="contactwayinput"
							name="contactway" style="width:300px;" class="form-control"
							placeholder="请留下qq号或手机号">
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
						<c:if test="${not empty project.filename }">
							<input type="hidden" name="filepath" value="${project.filepath }"
								id="oldfilepath" />
							<a class="btn btn-default" id="lookoldfile">查看原文档</a>
						</c:if>
						<button type="submit" title="更新需求文档"
							onmouseover="$(this).tooltip('show')" class="btn btn-default"
							id="filebtn">更新文档</button>
						| <span id="showfile"> <c:choose>
								<c:when test="${not empty project.getFilename()}">
													${project.getFilename() }
												</c:when>
								<c:otherwise>
													暂无文档
												</c:otherwise>
							</c:choose>
						</span>|
						<div id="realfilediv">
							<input type="file" id="fileinput" name="file"
								style="display: none;">
						</div>

					</div>

					<br />
					<div class="form-group">
						<div class="">
							<button type="submit" class="btn btn-success" id="updatebtn">更新</button>
						</div>
					</div>
				</form>
			</div>
			<!-- 需求提示框 -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title" id="myModalLabel">需求信息</h4>
						</div>
						<div class="modal-body" id="m_text" style="overflow: auto;"></div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal -->
			</div>

		</div>
		<!-- /widget-body -->
	</div>
	<!-- /widget -->
</div>
<!-- /row-fluid -->
<script>
	function backPrev() {
		history.back();
	}

	$(function() {
		$("#lookoldfile").click(function() {
			var path = $("#oldfilepath").val();
			util.ajaxNormal("user/mine/checkFile", {
				filepath : path
			}, function(data) {
				//alert(data.data);
				$("#myModal #m_text").html("<font color='red'>" + data.data.replace(/[\n\r]/g, "<br/>") + "</font>");
				$("#myModal").modal("show");
			});
			return false;
		});
		//是否绑定改变事件标志
		var changeflag = false;
		$("#filebtn").click(function() {
			$("#fileinput").trigger("click");
			if (!changeflag) {
				$("#fileinput").change(function() {
					if ($("#changeFlag").length == 0) {
						var changeflag = "<input type='hidden' id='changeFlag' name='changeFlag' value='0' />";
						$("#updateform").append(changeflag);
					}
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

		//更新
		$("#updatebtn").click(function() {
			//校验
			if ($("#projectnameinput").val() == "") {
				alert("项目名称不能为空！");
				return false;
			}
			var url = "user/mine/update";
			var data = new FormData($("#updateform")[0]);
			function callbacks(data) {
				if (data.code == '200') {
					alert("更新成功！");
					window.location.href = "user/mine/project";
				} else {
					alert(data.message);
				}
			}
			util.ajaxSepical(url, data, callbacks);
			return false;
		});

	});
</script>
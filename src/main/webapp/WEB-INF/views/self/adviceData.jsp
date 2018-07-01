<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- 后台模板css js 以及改变pjax按钮颜色方法 -->
<%@include file="../base/backbase.jsp"%>
<!-- 页面加载进度条 -->
<%@include file="../base/process.jsp"%>
<!-- pjax及进度pjax进度条  请求封装 -->
<%@include file="../base/pjax_process.jsp"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>项目列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<!-- 引入pjax 效果 封装函数 为内容单独做pjax效果 -->
<script type="text/javascript" src="../../../static/js/base/pjax.js"></script>
<style type="text/css">
.a_plist {
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

			
				<!-- 详细提示框 -->
				<div class="modal fade" id="detailmodal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title" id="myModalLabel">详细信息</h4>
							</div>
							<div class="modal-body" id="m_text" style="overflow: auto;">
								<div>
									<span>项目名称：</span><span id="pnamespan">two</span>
									<hr />
									<span>项目描述：</span><span id="pdescspan">two</span>
									<hr />
									<span>项目类型：</span><span id="ptypespan">two</span>
									<hr />
									<span>项目语言：</span><span id="planspan">two</span>
									<hr />
									<span>项目状态：</span><span id="pstatusspan">two</span>
									<hr />
									<span>项目总额：</span><span id="ptotalspan">two</span>
									<hr />
									<span>项目定金：</span><span id="ppremoneyspan">two</span>
									<hr />
									<span>项目余款：</span><span id="premainspan">two</span>
									<hr />
									<span>项目评论数：</span><span id="pcommentsspan">two</span>
									<hr />
									<span>项目查看数：</span><span id="plooksspan">two</span>
									<hr />
									<span>查看对象：</span><span id="plookobjspan">two</span>
									<hr />
									<span>项目单号：</span><span id="pordernumspan" style="color:red;">two</span>
									<hr />
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">关闭</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal -->
				</div>
				
				<!-- 付款提示框 -->
				<div class="modal fade" id="paymodal" tabindex="-1" role="dialog"
					aria-labelledby="payModalLabel" aria-hidden="true"
					style="overflow: hidden;">
					<div class="modal-dialog">
						<div class="modal-content" style="height:500px;">
							<div class="modal-body">
								<ul class="nav nav-tabs" role="tablist">
									<li role="presentation" class="active"><a
										href="#alipaydiv" role="tab" data-toggle="tab">支付宝</a></li>
									<li role="presentation"><a href="#weidiv" role="tab"
										data-toggle="tab">微信</a></li>
								</ul>
								<div class="tab-content">

									<div role="tabpanel" class="tab-pane active" id="alipaydiv"
										style="text-align: center;">
										<img width="180" alt="qcode" src="static/images/header.jpg" id="alipaycode" style="display: none">
										<label id="showmoneylb"></label>
										<label>
											<font color="green" style="font-size:2px;">tip:付款完成后请截图和复制单号，发送给我</font>
										</label>
									 	 	<!--<a class="btn btn-default"
											href="user/mine/project.html">付款后请刷新页面</a> -->
									</div>

									<div role="tabpanel" class="tab-pane" id="weidiv">努力开发中。。。</div>

								</div>

							</div>

						</div>
					</div>
				</div>
				
				
				<div class="row-fluid">
					<ul class="breadcrumb">
						<li><span class="divider">/</span></li>
						<li>我的项目 <span class="divider">/</span></li>
						<li>项目列表<span class="divider">/</span></li>
					</ul>
					<h3 class="heading">项目列表</h3>
				</div>
				<!-- /row-fluid -->

				<div class="row-fluid">
					<div class="widget widget-padding span12" style="overflow:visible;">
						<div class="widget-header">
							<i class="icon-group"></i>
							<h5>项目列表</h5>
							<div class="widget-buttons">
								<a 
									href="tencent://message/?uin=1841456435&Site=Sambow&Menu=yes">
									<font color="#82B9F7">联系我</font> </a>
							</div>
						</div>
						<div class="widget-body" style="border:1px solid red;">
							<div class="filtersdiv">

								<div id="typediv" style="display:inline-block;">
									<div class="btn-group">
										<a class="btn btn-small dropdown-toggle"
											data-toggle="dropdown" href="#">项目类型 <span class="caret"></span>
										</a>
										<ul class="dropdown-menu pull-right">
											<li class="alltype"><a href="${alltypeurl }"
												class="pjax_a">全部类型</a></li>
											<c:forEach items="${types }" var="t">
												<li class="${t.tcode }"><a href="${t.url }"
													class="pjax_a">${t.showtext }</a></li>
											</c:forEach>
										</ul>
									</div>
								</div>
								<!-- typediv -->

								<div id="landiv" style="display: inline-block;">
									<div class="btn-group">
										<a class="btn btn-small dropdown-toggle"
											data-toggle="dropdown" href="#">项目语言<span class="caret"></span>
										</a>
										<ul class="dropdown-menu pull-right">
											<li class="alllan"><a href="${alllanurl}" class='pjax_a'>全部语言</a></li>
											<c:forEach items="${lans }" var="l">
												<li class="${l.tcode }"><a class="pjax_a"
													href="${l.url }">${l.showtext }</a></li>
											</c:forEach>
										</ul>
									</div>
								</div>
								<!-- landiv -->

							</div>
							<!-- filtersdiv -->
							<!-- ******** -->
							<style>
.table th, .table td {
	text-align: center;
}

.dropdown-menu {
	text-align: left;
}

.table tr {
	font-size: 10px;
}
</style>
							<!-- ******** -->
							<table id="users" style="margin-top:8px;"
								class="table table-striped table-bordered dataTable">
								<thead>
									<tr>
										<th>项目名称</th>
										<th>项目描述</th>
										<th>项目类型</th>
										<th>项目语言</th>
										<th>需求文档</th>
										<th>项目状态</th>
										<th>项目总额</th>
										<th>项目定金</th>
										<th>项目余款</th>
										<th>提交时间</th>
										<th>操作</th>
										<th>动作</th>
									</tr>
								</thead>
								<tbody>
									<c:choose>
										<c:when test="${page.data != null and page.data.size() == 0 }">
											<tr>
												<td colspan="11">暂无资源哦</td>
												<td><a href="user/mine/project/apply.html" class="pjax_a">申请一个</a></td>
											</tr>
										</c:when>
										<c:otherwise>
											<tr>
												<td colspan="12"></td>
											</tr>
											<c:forEach items="${page.data }" var="p">

												<tr>
													<!-- 需要用到的参数 值放入hidden -->
													<input type="hidden" name="ordernumhidden"
														value="${p.ordernum }" />
													<input type="hidden" name="premoneyhidden"
														value="${p.premoney }" />
													<input type="hidden" name="remainmoneyhidden"
														value="${p.remainmoney }" />
													<!-- 记录每行id -->
													<input type="hidden" value="${p.projectId }"
														name="projectid" />
													<td>${p.projectname }</td>
													<td>${fn:length(p.projectdesc) > 10 ? 
														fn:replace(p.projectdesc,(fn:substring(p.projectdesc,10,-1)),'...') : p.projectdesc }
														<input type="hidden" id="slhidden"
														value="${p.projectdesc }" />
													</td>
													<td>${p.typetext }</td>
													<td>${p.lantext }</td>
													<td><c:choose>
															<c:when test="${empty p.filepath }">
																无文档
															</c:when>
															<c:otherwise>
																<a title="点击下载"
																	href="user/mine/download/${p.projectId }">${fn:length(p.getFilename()) > 5 ? 
																fn:replace(p.getFilename(),(fn:substring(p.getFilename(),5,-1)),'***') : p.getFilename() }
																</a>
															</c:otherwise>
														</c:choose></td>
													<td>${p.statustext }</td>
													<td><c:choose>
															<c:when test="${p.status == '0' or p.status == '2' }">
																暂定
															</c:when>
															<c:otherwise>
																${p.totalmoney }
															</c:otherwise>
														</c:choose></td>
													<td><c:choose>
															<c:when test="${p.status == '0' or p.status == '2' }">
																暂定
															</c:when>
															<c:otherwise>
																<span id="premoneyspan">${p.premoney }</span>
															</c:otherwise>
														</c:choose></td>
													<td><c:choose>
															<c:when test="${p.status == '0' or p.status == '2' }">
																暂定
															</c:when>
															<c:otherwise>
																<span id="remainmoneyspan">${p.remainmoney }</span>
															</c:otherwise>
														</c:choose></td>
													<td><fmt:formatDate value="${p.committime }"
															pattern="yyyy-MM-dd HH:mm:ss" /></td>
													<td><c:choose>
															<c:when test="${p.status == '0' }">
																<button class='btn btn-small disabled'>付定金</button>
															</c:when>
															<c:when test="${p.status == '1' }">
																<button class='btn btn-small payfirstmonybtn'>付定金</button>
															</c:when>
															<c:when test="${p.status == '2' }">
																<button class='btn btn-small reapplybtn'>重新申请</button>
															</c:when>
															<c:when test="${p.status == '3' }">
																<button class='btn btn-small payremainmoneybtn'>付余款</button>
															</c:when>
															<c:when test="${p.status == '4' and p.iscomment == '0' }">
																<button onclick="goComment(${p.projectId})"
																	class='btn btn-small'>评论</button>
															</c:when>
															<c:when test="${p.status == '4' and p.iscomment == '1' }">
																<button class='btn btn-small'
																	onclick="goComment(${p.projectId})">追评</button>
															</c:when>
														</c:choose></td>
													<td class="actiontd">
														<div class="btn-group">
															<a class="btn btn-small dropdown-toggle"
																data-toggle="dropdown" href="#"> 动作 <span
																class="caret"></span>
															</a>
															<ul class="dropdown-menu pull-right">
																<c:if test="${p.status == '1'  }">
																	<li><a onclick="deleteInfo(${p.projectId})"><i
																			class="icon-trash"></i> 删除</a></li>
																</c:if>
																<c:if test="${p.status == '0' or p.status == '2' }">
																	<li><a
																		href="user/mine/update/${p.projectId }.html"
																		class="pjax_a"><i class="icon-edit"></i> 编辑</a></li>
																	<li><a onclick="deleteInfo(${p.projectId})"><i
																			class="icon-trash"></i> 删除</a></li>
																</c:if>
																<c:if test="${p.status == '4' }">
																	<li><a onclick="deleteInfo(${p.projectId})"><i
																			class="icon-trash"></i> 删除</a></li>
																	<li><a class="pjax_a"
																		href="user/mine/progress/${p.projectId}.html"><i
																			class="icon-trash"></i> 查看进度</a></li>
																</c:if>
																<c:if test="${p.status == '3' }">
																	<li><a class="pjax_a"
																		href="user/mine/progress/${p.projectId}.html"><i
																			class="icon-trash"></i> 查看进度</a></li>
																</c:if>
																<li><a onclick="return lookDetail(${p.projectId})"
																	id="detailbtn"> <i class="icon-trash"></i> 查看详细
																</a></li>
															</ul>
														</div>
													</td>
												</tr>
											</c:forEach>
										</c:otherwise>
									</c:choose>

								</tbody>
							</table>

							<!-- 分页按钮 -->
							<div class="pagebtndiv">${btns }</div>
						</div>
						<!-- /widget-body -->
					</div>
					<!-- /widget -->
				</div>
				<!-- /row-fluid -->

				<script type="text/javascript">
					//为内容中的链接单独设置pjax效果
					pjaxPackage("pjax_a");
					var project = {
						color : "#4BB9DA",
						changeBg : function(divid, clazz, all, color) {
							if (clazz == "")
								$("#" + divid).find("." + all).css("background", project.color);
							else
								$("#" + divid).find("." + clazz).css("background", project.color);
						}
					}
					//选中的参数按钮变色
					var activetype = "${activetype}";
					project.changeBg("typediv", activetype, "alltype", "");
					var activelan = "${activelan}";
					project.changeBg("landiv", activelan, "alllan", "");
				
					//付定金功能
					$(".payfirstmonybtn").click(function() {
						//付款功能咱不能用提示
						//hint($(this));
						//使用付款二维码付钱
						var tobj = $(this).parent().parent();
						var money = tobj.find("input[name=premoneyhidden]").val();
						paycode($(this),money);
						return;
						//按钮文字变
						$(this).text("请稍后..");
						//获取premoney、单号
						var ps = $(this).parent().parent();
						var orderNumber = ps.find("input[name=ordernumhidden]").val();
						var type = "3"; //传入将要改变的类型
						var totalAmount = ps.find("input[name=premoneyhidden]").val();
						var url = "pay/mine/" + orderNumber + "/" + type + "/" + totalAmount;
						payMoney(orderNumber, type, totalAmount, url);
						var s = $(this);
						setInterval(function() {
							s.text("付定金");
						}, 3000)
					});
					//付全款
					$(".payremainmoneybtn").click(function() {
						
						//付款功能暂不能用提示
						//	hint($(this));
						//使用付款二维码付钱
						var tobj = $(this).parent().parent();
						var money = tobj.find("input[name=remainmoneyhidden]").val();
						paycode($(this),money);
						return;
						
						$(this).text("请稍后..");
						var ps = $(this).parent().parent();
						var orderNumber = ps.find("input[name=ordernumhidden]").val();
						var type = "4"; //传入将要改变的类型
						var totalAmount = ps.find("input[name=remainmoneyhidden]").val();
						var url = "pay/mine/" + orderNumber + "/" + type + "/" + totalAmount;
						payMoney(orderNumber, type, totalAmount, url);
						var s = $(this);
						setInterval(function() {
							s.text("付余款");
						}, 3000)
					});
					//二维码返回成功后提示框封装
					function payMoney(orderNumber, type, totalAmount, url) {
						var orderNumber = orderNumber;
						var type = type; //传入将要改变的类型
						var totalAmount = totalAmount;
						var url = url;
						function callbacks(data) {
							if (data.code == "300") {
								alert(data.message);
							} else {
								$("#showmoneylb").html("<font color='green'>付款" + totalAmount + "元</font>");
								$("#paymodal").modal("show");
								$("#alipaycode").attr("src", data.data).show(200);
							}
						}
						util.ajaxNormal(url, "", callbacks);
					}
					//使用付款二维码付钱
					function paycode(obj,money){
						$("#paymodal").modal("show");
						$("#showmoneylb").html("<font color='blue'>付款" + money + "元</font>");
						$("#alipaycode").attr("src", '/static/images/rmoney.jpeg').show(200);
						var copyorder = "<label style='color:red' id='orderlib'></label><button class='btn btn-default btn-sm' id='copyorderbtn'>复制单号</button>&nbsp;&nbsp;";
						$("#copyorderbtn").remove();
						$("#orderlib").remove();
						$("#alipaydiv").append(copyorder);
						//复订单号绑定click时间
						$("#copyorderbtn").on("click",function(){
							var order = obj.parent().parent().find("input[name=ordernumhidden]").val();
							if (!!window.ActiveXObject || "ActiveXObject" in window)  {
								if(window.clipboardData.setData("text",order))
									alert("复制到剪切板！");
								else
									$("#orderlib").text("复制失败，请手工复制单号：\n" + order);
							}else{
								$("#orderlib").text("该浏览器不支持剪切板，请手工复制：\n" + order);
							}
						});
						var contact = "<a id='contacta' class='btn btn-default' href='tencent://message/?uin=1841456435&Site=Sambow&Menu=yes'><font color='#82B9F7'>联系我</font></a>";
						$("#contacta").remove();
						$("#alipaydiv").append(contact);
					}
					
					//不能付款提示框封装
					function hint(obj){
						$("#alipaydiv").html("");
						$("#alipaydiv").append("<label style='font-size:16px;color:green;margin-top:30px;'>付款功能暂不能使用，可以联系我手动转账!</label><br/><label style='color:red' id='orderlib'></label>");
						var copyorder = "<button class='btn btn-default btn-sm' id='copyorderbtn'>复制单号</button>&nbsp;&nbsp;";
						$("#alipaydiv").append(copyorder);
						//复订单号绑定click时间
						$("#copyorderbtn").on("click",function(){
							var order = obj.parent().parent().find("input[name=ordernumhidden]").val();
							if (!!window.ActiveXObject || "ActiveXObject" in window)  {
								if(window.clipboardData.setData("text",order))
									alert("复制到剪切板！");
								else
									$("#orderlib").text("复制失败，请手工复制：\n" + order);
							}else{
								$("#orderlib").text("该浏览器不支持剪切板，请手工复制：\n" + order);
							}
							
							
						});
						var contact = "<a class='btn btn-default' href='tencent://message/?uin=1841456435&Site=Sambow&Menu=yes'><font color='#82B9F7'>联系我</font></a>";
						$("#alipaydiv").append(contact);
						$("#paymodal").modal("show");
					}
					//重新申请
					$(".reapplybtn").click(function() {
						var id = $(this).parent().parent().find("input[name=projectid]").val();
						var url = "user/mine/reapply/" + id;
						function callbacks(data) {
							if (data.code == '200') {
								alert(data.message);
								//刷新
								window.location.href = window.location.href;
							} else {
								alert(data.message);
							}
						}
						util.ajaxNormal(url, "", callbacks);
					});
					//查看详细信息
					function lookDetail(id) {
						//var id = $(this).parent().parent().find("input[name=projectid]").val();
						var url = "user/mine/lookDetail/" + id;
						function callbacks(data) {
							//alert(data.data.projectname);
							//alert(data.code);
							if (data.code == "200" || data.code == null) {
								var obj = data.data;
								$("#pnamespan").text(obj.projectname);
								$("#pdescspan").text(obj.projectdesc);
								$("#ptypespan").text(obj.typetext);
								$("#planspan").text(obj.lantext);
								$("#pstatusspan").text(obj.statustext);
								$("#ptotalspan").text(obj.totalmoney == null ? '暂定' : obj.totalmoney);
								$("#ppremoneyspan").text(obj.premoney == null ? '暂定' : obj.premoney);
								$("#premainspan").text(obj.remainmoney == null ? '暂定' : obj.remainmoney);
								$("#pcommentsspan").text(obj.comments);
								$("#plooksspan").text(obj.look);
								$("#plookobjspan").text(obj.pflag == '0' ? '所有人' : '个人');
								$("#pordernumspan").text(obj.ordernum);
								$("#detailmodal").modal("show");
							} else
								alert(data.message);
						}
						util.ajaxNormal(url, "", callbacks);
						return false;
					}
					//删除功能
					function deleteInfo(id) {
						var f = confirm("删除此信息，将会删除与该记录相关的其他信息，是否继续？");
						if (f) {
							var url = "user/mine/delete/" + id;
							function callbacks(data) {
								if (data.code == '200') {
									alert(data.message);
									//刷新页面
									window.location.href = window.location.href;
								} else
									alert(data.message);
							}
							util.ajaxNormal(url, "", callbacks);
						}
						return false;
					}
					//评论
					function goComment(id) {
						window.open("project/" + id + ".html", "_blank");
					}
				</script>

			</div>
			<!-- /Main window -->

		</div>
		<!--/.fluid-container-->
	</div>
</body>
</html>

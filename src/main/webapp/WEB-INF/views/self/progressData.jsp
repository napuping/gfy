<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
				
				<!-- 引入时间轴样式 -->
				<link rel="stylesheet" type="text/css"
					href="static/time_axis/css/font-awesome.min.css">
				<link rel="stylesheet" href="static/time_axis/css/timeline.css">

				<div class="row-fluid">
					<ul class="breadcrumb">
						<li>项目列表<span class="divider">/</span></li>
						<li>项目进度<span class="divider">/</span></li>
					</ul>
					<h2 class="heading">项目进度</h2>
				</div>
				<!-- /row-fluid -->

				<div class="row-fluid">
					<div class="widget widget-padding span12">
						<div class="widget-header">
							<i class="icon-group"></i>
							<h5>项目进度-${project.projectname }</h5>
							<div class="widget-buttons"> <a href="javascript:void(0)" onclick="backPrev()">返回</a>
							</div>
					</div>
					<div class="widget-body" style="background: #F5F6F7;">

						<!-- 项目信息 -->
						<div class="detailarea panel panel-default"
							style="width:1000px;margin:0 auto;padding:10 10;background: white;border-radius:8px;">
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
										<td>${project.totalmoney }</td>
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
						<!-- /项目信息 -->

						<!-- 进度信息 -->
						<div class="detailarea panel panel-default"
							style="width:1000px;margin:5 auto;padding:10 10;background: white;border-radius:8px;">
							<label><font size="4px;">项目进度</font></label>
							<hr style="margin-top:5px;margin-bottom:4px;" />

							<c:choose>
								<c:when test="${progresss.size() == 0 }">
									<font color="red" style="margin-left:15px;">暂无进度信息！</font>
								</c:when>
								<c:otherwise>

									<div class="timeline timeline-line-dotted">

										<c:forEach items="${progresss }" var="p">
											<span class="timeline-label"> <span
												class="label label-primary"> <fmt:formatDate
														value="${p.createtime }" pattern="yyyy/MM/dd HH:mm:ss" />
											</span>
											</span>
											<div class="timeline-item" style="">
												<div class="timeline-point timeline-point-success">
													<i class="fa fa-money"></i>
												</div>
												<div class="timeline-event" style="background: #F9F9F9">
													<div class="timeline-heading">
														<h5 style="font-weight: bold;cursor: pointer;"
															class="timetitle">${p.title }</h5>
													</div>
													<div class="timeline-body" style="display: none;">
														<p>${p.content }</p>
													</div>
													<div class="timeline-footer">
														<p class="text-right pull-right"
															style="font-weight: bold;">${p.username }</p>
													</div>
												</div>
											</div>

											</span>

										</c:forEach>

									</div>
									<!-- /timeline-line-dotted -->

								</c:otherwise>
							</c:choose>


						</div>
						<!-- /进度信息 -->


					</div>
					<!-- /widget-body -->
				</div>
				<!-- /widget -->
			</div>
			<!-- /row-fluid -->

			<script type="text/javascript">
				function backPrev() {
					history.back();
				}
				$(function() {
					$(".timetitle").click(function() {
						$(this).parent().next().slideToggle(500);
					});
				});
			</script>
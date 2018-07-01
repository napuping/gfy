<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="p_heading">
			
			<div id="typediv">
				<a href="${alltypeurl }" class="alltype btn btn-default btn-xs pjax_a">全部类型</a>
				<c:forEach items="${types }" var="t">
					<a href="${t.url }" class="${t.tcode } btn btn-default btn-xs pjax_a">${t.showtext }</a>
				</c:forEach>
			</div>
			<hr />
			<div id="landiv">
				<a href="${alllanurl }" class="alllan btn btn-default btn-xs pjax_a">全部语言</a>
				<c:forEach items="${lans }" var="l">
					<a href="${l.url }" class="${l.tcode } btn btn-default btn-xs pjax_a">${l.showtext }</a>
				</c:forEach>
			</div>
			<hr />
			<div id="orderdiv">
				<span class="allorder btn btn-default btn-xs">排序</span> <a
					href="${time }" class="committime btn btn-default btn-xs pjax_a">时间</a> <a
					href="${comment }" class="comments btn btn-default btn-xs pjax_a">评论</a> <a
					href="${look }" class="look btn btn-default btn-xs pjax_a">浏览</a>
			</div>
		
		</div>
		<div class="p_content">
			<c:choose>
				<c:when test="${page.data != null and page.data.size()>0 }">
					<c:forEach items="${page.data }" var="p">
						<div class="p_content_detail panel panel-info">
							<div class="panel-heading" style="height:30px;line-height: 30px;padding:0 0;">
								<a class="adetail" href="/project/${p.projectId }.html">${p.projectname}</a>
							</div>
							<div class="panel-body">${p.projectdesc }</div>
							<div class="panel-footer">
								<span class="glyphicon glyphicon-comment"></span> <span class="p_content_item">${p.comments }</span>
								<span class="glyphicon glyphicon-eye-open"></span> <span class="p_content_item">${p.look }</span> 
								<span class="glyphicon glyphicon-user"></span> <span class="p_content_item">
									<c:choose>
										<c:when test="${empty p.username }">匿名</c:when>
										<c:otherwise>${p.username }</c:otherwise>
									</c:choose>
								</span>
								<span class="glyphicon glyphicon-time"></span> <span class="p_content_item"><fmt:formatDate value="${p.committime }"
									pattern="yyyy/MM/dd HH:mm:ss" /></span>
							</div>
						</div>
						<br />
					</c:forEach>
				</c:when>
				<c:otherwise>
					<div class="panel panel-info"><font color="red">资源干涸中。。。</font></div>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="p_pagebtn">
			<ul class="pagination">${btns }</ul>
		</div>
	</div>
	
	<script type="text/javascript">
		
		$(function() {
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
			$(".pjax_a").click(function(){
				var urls = $(this).attr("href");
				/* if(urls.indexOf("?") != -1)
					urls += "&c=" + new Date().getTime();
				else
					urls += "?c=" + new Date().getTime(); */
				$.pjax({
					url:urls,
					container:"#pjax_content",
					cache:false,
				});
				return false;
			});
			//pjax 预加载事件
			var i = 0;//进度条增长基数
			var s;//定时器变量
			$(document).on("pjax:send",function(){
				$("#p_pross").show();
				s = setInterval(function() {
					i += 5;
					$("#p_pross").animate("width",i);
				}, 1000)
			});
			
			//pjax 加载完成之后事件
			$(document).on("pjax:complete",function(){
				clearInterval(s);
				var width = $(window).width();
				//$("#p_pross").css("width",width)
				$("#p_pross").animate({width:width});
				
				$("#p_pross").animate({"width":0},1,function(){
					$("#p_pross").hide();
				});
				
			});
			
		});
			
	</script>

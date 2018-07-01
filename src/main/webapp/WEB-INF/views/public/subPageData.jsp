<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div
	style="border:1px solid #DDDDDD;padding:5 5;
							margin-left:20px;margin-top:5px;border-radius:5px;">
	<c:forEach items="${subPage.data }" var="s">
		<c:choose>
			<c:when test="${s.parentId == parentId }">
				${s.username} ： ${s.content}
				<button class="btn btn-default btn-xs replyshowbtn">回复</button>
				<div style="width:600px;margin-top:5px;padding:5 5;display: none;">
					<textarea class="form-control" style="width:500px;height:150px;"></textarea>
					<input type="hidden" value="${s.commentId }">
					<button style="margin-top:5px;"
						class="btn btn-info btn-sm replybtn">回复</button>
				</div>
				<hr />
			</c:when>
			<c:otherwise>
				${s.username}@${s.username2 } ： ${s.content }
				<button class="btn btn-default btn-xs replyshowbtn replyshowbtn">回复</button>
				<div style="width:600px;margin-top:5px;padding:5 5;display: none;">
					<textarea class="form-control" style="width:500px;height:150px;"></textarea>
					<input type="hidden" value="${s.commentId }">
					<button style="margin-top:5px;"
						class="btn btn-info btn-sm replybtn">回复</button>
				</div>
				<hr />
			</c:otherwise>
		</c:choose>
	</c:forEach>
</div>

<!-- 子评论分页 -->
<div style="margin-left:20px;">
	<ul class="pagination" style="margin-top:5px;margin-bottom:5px;">${subPage.generateButton('')}</ul>
</div>
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
		//解绑再绑
		$(".replyshowbtn").unbind("click");
		$(".replyshowbtn").click(function(){
			$(this).next().toggle(250);
		});
		$(".replybtn").unbind("click");
		$(".replybtn").click(function(){
			//回复
			var projectId = $("#projectIdHidden").val();
			var parentId = $(this).prev().val();
			var content = $(this).prev().prev().val();
			var url = "comment/reply";
			function callbacks(data){
				if(data.code== "200"){
					alert(data.message);
					window.location.href = window.location.href;
				}else
					alert(data.message);
			}
			util.ajaxNormal(url, {projectId:projectId,parentId:parentId,content:content}, callbacks);
			
		});
		
	});
</script>

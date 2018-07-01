<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="base.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'test.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<a href="tencent://message/?uin=1841456435&Site=Sambow&Menu=yes"> </a>
	<button id="test">test</button>
	<a version="1.0" class="qzOpenerDiv" target="_blank" id="share">分享</a>
	<script type="text/javascript">
		$(function() {
			$("#test").click(function() {
				$.ajax({
					url : "test1",
					type : "post",
					success : function(data) {
						alert(data.message);
					}
				});
			});
			var p = {
				url : location.href,
				showcount : '1', /*是否显示分享总数,显示：'1'，不显示：'0' */
				desc : '这是一个测试', /*默认分享理由(可选)*/
				summary : '这是一个测试', /*分享摘要(可选)*/
				title : '测试', /*分享标题(可选)*/
				site : 'dd', /*分享来源 如：腾讯网(可选)*/
				pics : 'dd', /*分享图片的路径(可选)*/
				style : '102',
				width : 145,
				height : 30
			};
			var s = [];
			for (var i in p) {
				s.push(i + '=' + encodeURIComponent(p[i] || ''));
			}
			$("#share").click(function(){
				var url = "http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?" + s.join('&');
				$(this).attr("href",url);
			});
			
		});
	</script>
	<!-- <script type="text/javascript">
		(function() {
			
			document.write([ '<a version="1.0" class="qzOpenerDiv" href="http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?', s.join('&'), '" target="_blank">分享</a>' ].join(''));
		})();
	</script> -->
	<script
		src="http://qzonestyle.gtimg.cn/qzone/app/qzlike/qzopensl.js#jsdate=20111201"
		charset="utf-8"></script>
</body>
</html>

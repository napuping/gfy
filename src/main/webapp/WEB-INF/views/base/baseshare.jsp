<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 分享组件 封装js -->
<script type="text/javascript" src="/static/js/base/third.js"></script>
<style>
#sharediv {
	position: absolute;
	right: 15px;
	top: 300px;
	text-align: center;
}
</style>
<div id="sharediv">
	<a data-toggle="popover" data-placement="left" data-trigger="hover"
		class="btn btn-default" id="share">分享</a>
</div>

<script type="text/javascript">
	$("#sharediv").css("top", (window.screen.height - 100) / 2);
	$(window).scroll(function() {
		$("#sharediv").css({
			"position" : "absolute",
			"top" : $(this).scrollTop() + (window.screen.height - 100) / 2,
			"z-index" : "1"
		});
	});
	//分享弹出框事件
	$("#share").popover({
		html : true,
		title : title(),
		delay : {
			show : 200,
			hide : 1000
		},
		content : function() {
			return content();
		}
	});

	function title() {
		return "";
	}
	function content() {
		var data = "<div style='text-align:center;'><a class='btn btn-default btn-sm' onclick='javascript:qqsharebtn(this)' version='1.0' target='_blank'>QQ分享</a><br/>" +
			"<a class='btn btn-default btn-sm' onclick='weibosharebtn(this)' target='_blank' style='margin-top:5px;'>微博分享</a></div>";
		return data;
	}
	//qq分享按钮click事件
	function qqsharebtn(obj) {
		var url = "http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?" + qqshare();
		$(obj).attr("href", url);
	}
	//微博分享click事件
	function weibosharebtn(obj){
		var url = "http://service.weibo.com/share/share.php?" + weiboshare();
		$(obj).attr("href", url);
	}
</script>
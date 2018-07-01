<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
<style type="text/css">
.base_process {
	border: 1px solid red;
	position: absolute;
	top: 0px;
	width: 0px;
	z-index: 900;
}
</style>

</head>

<body>
	<!-- 进度条 -->
	<div class="base_process" id="base_process"></div>
	<script type="text/javascript">
		function load(){
			var width = $(window).width();
			$("#base_process").show();
			$("#base_process").animate({
				width : width
			}, 300, function() {
				$("#base_process").hide().css("width",0);
			});
		}
		
	</script>
</body>
</html>

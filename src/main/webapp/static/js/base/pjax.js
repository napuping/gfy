function pjaxPackage(clazz){
		$("." + clazz).click(function() {
			var urls = $(this).attr("href");
			$.pjax({
				url : urls,
				container : "#p_content",
				cache : false,
			});
			return false;
		});
		//pjax 预加载事件
		var i = 0; //进度条增长基数
		var s; //定时器变量
		$(document).on("pjax:send", function() {
			$("#p_pross").show();
			s = setInterval(function() {
				i += 5;
				$("#p_pross").animate("width", i);
			}, 1000)
		});
		//pjax 加载完成之后事件
		$(document).on("pjax:complete", function() {
			clearInterval(s);
			var width = $(window).width();
			//$("#p_pross").css("width",width)
			$("#p_pross").animate({
				width : width
			});
			$("#p_pross").animate({
				"width" : 0
			}, 1, function() {
				$("#p_pross").hide();
			});
		});
	}
var util = {
	ajaxNormal : function(url, data, callbacks) {
		$.ajax({
			url : url,
			type : "post",
			data : data,
			dataType:"json",
			success : callbacks,
		});

	},
	ajaxSepical : function(url, data, callbacks) {
		$.ajax({
			url : url,
			type : "post",
			data : data,
			dataType:"json",
			processData : false,
			contentType : false,
			success : callbacks,
		});
	},
	
}
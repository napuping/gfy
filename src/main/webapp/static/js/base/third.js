
function qqshare() {
	var p = {
		url : location.href,
		showcount : '1', /*是否显示分享总数,显示：'1'，不显示：'0' */
		desc : '可以来试一试', /*默认分享理由(可选)*/
		summary : '用心', /*分享摘要(可选)*/
		title : '毕设小站', /*分享标题(可选)*/
		site : '', /*分享来源 如：腾讯网(可选)*/
		pics : '', /*分享图片的路径(可选)*/
		style : '102',
		width : 145,
		height : 30
	};
	var s = [];
	for (var i in p) {
		s.push(i + '=' + encodeURIComponent(p[i] || ''));
	}
	return s.join('&');
}

function weiboshare(){
	var weibo = {
			url:location.href,
			appkey:2023874104,
			title:'可以来试一试',
			searchPic:'false',
			style:'simple'
	}
	var s = [];
	for (var i in weibo) {
		s.push(i + '=' + encodeURIComponent(weibo[i] || ''));
	}
	return s.join('&');
}
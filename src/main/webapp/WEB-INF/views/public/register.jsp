<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../base/base.jsp"%>
<%@include file="../base/process.jsp"%>
<%@include file="../base/header.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>注册-快乐每一天！</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="项目，设计，代理，服务">
<meta http-equiv="description" content="项目信息列表，项目详细信息">
<meta name="robots" content="follow">

<style>
.registerdiv {
	padding: 5 15;
	background: white;
	box-shadow: 0px 0px 1px 1px white;
	border-radius: 5px;
	width: 590px;
	padding-top: 10px;
	margin: 10 auto;
}

.bigtitle {
	font-size: 20px;
	text-align: center;
}

hr {
	margin-top: 5px;
}

.luckdiv {
	width: 590px;
	margin: 10 auto;
	text-align: center;
	font-size: 14px;
	font-family: '宋体';
}
</style>
</head>

<body onload="load()">
	<div class="panel panel-info luckdiv">
		Hello,你 是 第 <font color="green" size="5px;">${nums+1 }</font> 位 幸 运 用
		户!
	</div>

	<div class="registerdiv">
		<div class="bigtitle" style="color:green">注 册</div>
		<hr />
		<form id="registerform">
			<div class="form-group has-feedback">
				<label for="username">用户名</label>
				<div class="input-group">
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-user"></span></span> <input id="username"
						class="form-control citem" placeholder="请输入用户名" maxlength="20" name="username"
						type="text">
				</div>

				<span style="color:red;display: none;" class="tips"></span> <span
					style="display: none;"
					class=" glyphicon glyphicon-remove form-control-feedback" id="username_fail"></span> <span
					style="display: none;"
					class="glyphicon glyphicon-ok form-control-feedback" id="username_ok"></span>
			</div>

			<div class="form-group has-feedback">
				<label for="password">密码</label>
				<div class="input-group">
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-lock"></span></span> <input id="password" 
						data-toggle="tooltip" onmouseover="$(this).tooltip('show')" title="至少1个大写字母，1个小写字母，1个数字，1个特殊字符"
						class="form-control citem" placeholder="请输入密码" maxlength="20" name="password"
						type="password">
				</div>

				<span style="color:red;display: none;" class="tips"></span> <span
					style="display: none;" id="password_fail"
					class="glyphicon glyphicon-remove form-control-feedback"></span> <span
					style="display: none;" id="password_ok"
					class="glyphicon glyphicon-ok form-control-feedback"></span>
			</div>

			<div class="form-group has-feedback">
				<label for="passwordConfirm">确认密码</label>
				<div class="input-group">
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-lock"></span></span> <input
						id="passwordConfirm" class="form-control citem" placeholder="请再次输入密码"
						maxlength="20" type="password">
				</div>
				<span style="color:red;display: none;" class="tips"></span> <span
					style="display: none;" id="passwordconfirm_fail"
					class="glyphicon glyphicon-remove form-control-feedback"></span> <span
					style="display: none;" id="passwordconfirm_ok"
					class="glyphicon glyphicon-ok form-control-feedback"></span>
			</div>

			<!--  <div class="row">
                <div class="col-xs-7">
                    <div class="form-group has-feedback">
                        <label for="idcode-btn">验证码</label>
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-qrcode"></span></span>
                            <input id="idcode-btn" class="form-control" placeholder="请输入验证码" maxlength="4" type="text">
                        </div>
                        <span style="color:red;display: none;" class="tips"></span>
                        <span style="display: none;" class="glyphicon glyphicon-remove form-control-feedback"></span>
                        <span style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span>
                    </div>
                </div>
                <div class="col-xs-5" style="padding-top: 30px">
                    <div id="idcode" style="background: transparent;"></div>
                </div>
            </div> -->

			<div class="form-group has-feedback">
				<label for="phoneNum">手机号码</label>
				<div class="input-group">
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-phone"></span></span> <input id="phoneNum"
						name="phone" class="form-control citem" placeholder="请输入手机号码"
						maxlength="11" type="text">
				</div>
				<span style="color:red;display: none;" class="tips"></span> <span
					style="display: none;"
					class="glyphicon glyphicon-remove form-control-feedback"></span> <span
					style="display: none;"
					class="glyphicon glyphicon-ok form-control-feedback"></span>
			</div>

			<div class="row">
				<div class="col-xs-7">
					<div class="form-group has-feedback">
						<label for="idcode-btn">校验码</label>
						<div class="input-group">
							<span class="input-group-addon"><span
								class="glyphicon glyphicon-qrcode"></span></span> <input
								id="idcode-btn" name="checkcode" class="form-control citem"
								placeholder="请输入校验码" maxlength="6" type="text">
						</div>
						<span style="color:red;display: none;" class="tips"></span> <span
							style="display: none;"
							class="glyphicon glyphicon-remove form-control-feedback"></span>
						<span style="display: none;"
							class="glyphicon glyphicon-ok form-control-feedback"></span>
					</div>
				</div>
				<div class="col-xs-5 text-center" style="padding-top: 26px">
					<button type="button" id="loadingButton" class="btn btn-primary"
						autocomplete="off">获取校验码</button>
				</div>
			</div>

			<div class="form-group">
				<input class="form-control btn btn-primary" id="submit"
					value="立&nbsp;&nbsp;即&nbsp;&nbsp;注&nbsp;&nbsp;册">
			</div>

			<div class="form-group">
				<input value="重置" id="reset" class="form-control btn btn-danger"
					type="reset">
			</div>
		</form>
	</div>
	
	<!-- 跳转页面选择框 -->
	<div class="modal fade" id="jumpModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">提示信息</h4>
				</div>
				<div class="modal-body" id="m_text"></div>
				<div class="modal-footer">
					<a type="button" class="btn btn-default" 
					onmouseover="$(this).tooltip('show')" data-toggle="tooltip" title="默认跳转主页">
					<font id="jumpsec" color="red">5</font>秒后跳转主页</a>
					<a type="button" class="btn btn-default"  href="home/list.html" id="gomainbtn">主页</a>
					<a type="button" class="btn btn-default"  href="user/mine/explain.html" id="goselfbtn">个人中心</a>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>

	<script type="text/javascript">
		$(function() {
			
			$("#username").change(function(){
				var value = $(this).val();
				if(value != ""){
					$.post("user/register/checkUsername",
					{username:value},
					function(data){
						if(data.code == "300"){
							$("#username_fail").show();
							$("#username_ok").hide();
						}else{
							$("#username_ok").show();
							$("#username_fail").hide();
						}
						
					});
				}
			
			});
			
			$("#password").change(function(){
				var pPattern = /^.*(?=.{6,})(?=.*\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$/;
				var value = $(this).val();
				if(value != ""){
					var flg = pPattern.test(value);
					if(!flg){
						$("#password_fail").show();
						$("#password_ok").hide();
					}else{
						$("#password_fail").hide();
						$("#password_ok").show();
					}
						
				}
			});
			
			$("#passwordConfirm").change(function(){
				var value = $(this).val();
				var pvalue = $("#password").val();
				if(pvalue != value){
					$("#passwordconfirm_fail").show();
					$("#passwordconfirm_ok").hide();
					
				}else{
					$("#passwordconfirm_fail").ok();
					$("#passwordconfirm_ok").show();
				}
				
			});
			
			//注册
			$("#submit").click(function() {
				//校验
				var flag = false;
				$(".citem").each(function(){
					if($(this).val() == ""){
						flag = true;
						return;
					}
				});
				if(flag){
					alert("有必填项为空！");
					return;
				}
				//校验密码是否一致
				if($("#password").val() != $("#passwordConfirm").val()){
					alert("密码不一致！");
					return;
				}
				//手机格式是否正确
				var patern = /^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\d{8}$/;
				if(!patern.test($("#phoneNum").val())){
					alert("手机号格式不正确！");
					return;
				}
				var url = "user/register/register";
				var data = new FormData($("#registerform")[0]);
				function callback(data) {
					if(data.code == "200"){
						
						//跳转 需要跳转的界面
						var jumpurl = "${jumpurl}";
						if(jumpurl != ''){
							alert(data.message);
							window.location.href = jumpurl;
							return;
						}
						//注册成功跳转页面
						//弹出框 供选择
						$("#jumpModal #m_text").html("<font color='green'> " + data.message + "</font>");
						$("#jumpModal").modal("show");
						//开始计时 跳转
						jumpSec();
					}else{
						alert(data.message);
					}
				}
				util.ajaxSepical(url, data, callback);
				return false;
			});
			
			//倒数5秒跳转
			function jumpSec(){
				var i = 5;
				setInterval(function() {
					i--;
					if(i >= 0)
						$("#jumpsec").text(i);
					if(i < 0){
						window.location.href="home/list";
					}
				}, 1000)
			}
			
			//获取验证码
			$("#loadingButton").click(function(){
				var phone = $("#phoneNum").val();
				var patern = /^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\d{8}$/;
				if(phone != "" && patern.test(phone)){
					data = {"mobile":phone}
					var url = "user/register/sendCode";
					function callback(data){
						alert(data.message);
					}
					util.ajaxNormal(url, data, callback)
				}else{
					alert("手机号格式不正确！");
				}
			});
			
	
		});
	</script>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="row-fluid">
					<ul class="breadcrumb">
						<li><span class="divider">/</span></li>
						<li>说明 <span class="divider">/</span></li>
					</ul>
					<h2 class="heading">有些话</h2>
				</div>
				<!-- /row-fluid -->

				<div class="row-fluid">
					<div class="widget widget-padding span12">
						<div class="widget-header">
							<i class="icon-group"></i>
							<h5>${notify.notifytitle }</h5>
						</div>
						<div class="widget-body" style="border:1px solid red">
							<%
								request.setAttribute("backs", "\n");
							 %>
							${fn:replace(notify.notifycontent,backs,"<br/>") }
						</div>
						<!-- /widget-body -->
					</div>
					<!-- /widget -->
				</div>
				<!-- /row-fluid -->

			</div>
			<!-- /Main window -->
		</div>
		<!--/.fluid-container-->
	</div>
	
	<!-- 付款提示框 -->
	<!-- <div class="modal fade" id="paymodal" tabindex="-1" role="dialog" 
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content" style="height:500px;">
				
				<div class="modal-body">
					
					tab 标签
					<ul class="nav nav-tabs" role="tablist">    
  						<li role="presentation" class="active"><a href="#alipaydiv" role="tab" data-toggle="tab">支付宝</a></li>
  						<li role="presentation"><a href="#weidiv" role="tab" data-toggle="tab">微信</a></li>
					</ul>    
					<div class="tab-content">   
  
					  <div role="tabpanel" class="tab-pane active" id="alipaydiv"
					  					 style="text-align: center;">
					  		<img alt="" src="static/images/header.jpg" id="alipaycode">	
					  </div>    
					  
					  <div role="tabpanel" class="tab-pane" id="weidiv">
					  			努力开发中。。。
					  </div>   
  
					</div>    
					
				</div>
				
			</div>
			/.modal-content
		</div>
		/.modal
	</div> -->
	
	<!-- wrap ends-->
	<script type="text/javascript">
		$(function(){
			$("#paybtn").click(function(){
				//准备参数 /{orderNumber}/{type}/{totalAmount}
				var orderNumber = "201852821519750";
				var type = "4";//传入将要改变的类型
				var totalAmount = "5.00";
				var url = "pay/" + orderNumber + "/" + type + "/" + totalAmount;
				function callbacks(data){
					if(data.code == "300"){
						alert(data.message);
					}else{
						$("#paymodal").modal("show");
						$("#alipaycode").attr("src",data.data);
					}
				}
				util.ajaxNormal(url, "", callbacks);
			});
		
		});
		
		
		
		
		
		
		
		
	</script>
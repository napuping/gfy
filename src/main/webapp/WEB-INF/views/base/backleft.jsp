<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- Side menu -->
			<div class="sidebar-nav nav-collapse collapse">
				<div class="user_side clearfix">
					<c:choose>
							<c:when test="${(not empty user) and (not empty user.hpath) }">
								<img src="${user.hpath}"
								alt="Odinn god of Thunder"  />
							</c:when>
							<c:otherwise>
								<img src="static/backtemplate/img/odinn.jpg"
								alt="Odinn god of Thunder" />
							</c:otherwise>
					</c:choose>
					<h5 style="margin-top:15px;">${user.username }</h5>
					 <!-- <a href="javascript:void()">&nbsp;<i class="icon-user"></i>
					 </a> -->
				</div>
				<div class="accordion" id="accordion2">
					
					<div class="accordion-group">
						<div class="accordion-heading">
							<a class="accordion-toggle b_F6F1A2" href="home/list"><i
								class="icon-tasks"></i> <span>主页</span></a>
						</div>
					</div>
					
					<div class="accordion-group">
						<div class="accordion-heading  a_explain a_pjax">
							<a class="accordion-toggle b_F6F1A2 a_pjax" href="user/mine/explain.html"><i
								class="icon-tasks"></i> <span>说明</span></a>
						</div>
					</div>

					<div class="accordion-group">
						<div class="accordion-heading">
							<a class="accordion-toggle b_C3F7A7 collapsed"
								data-toggle="collapse" data-parent="#accordion2"
								href="#collapse1"><i class="icon-magic"></i> <span>个人设置</span></a>
						</div>
						<div id="collapse1" class="accordion-body collapse">
							<div class="accordion-inner">
								<a class="accordion-toggle a_info a_pjax" href="user/mine/info.html"><i
									class="icon-star"></i> 个人信息</a>  <a
									class="accordion-toggle a_pset" onmouseover="$(this).tooltip('show')" 
									 title="努力开发中。。。" 
									 href="javascript:void(0)" ><i
									class="icon-table"></i> 个性化设置</a>
							</div>
						</div>
					</div>
					<div class="accordion-group">
						<div class="accordion-heading">
							<a class="accordion-toggle b_9FDDF6 collapsed"
								data-toggle="collapse" data-parent="#accordion2"
								href="#collapse2"><i class="icon-reorder"></i> <span>我的项目</span></a>
						</div>
						<div id="collapse2" class="accordion-body collapse">
							<div class="accordion-inner">
								<a class="accordion-toggle a_plist a_pjax" href="user/mine/project.html"><i
									class="icon-rss"></i> 项目列表</a> <a class="accordion-toggle a_apply a_pjax"
									href="user/mine/project/apply.html"><i class="icon-calendar"></i> 申请项目</a>
							</div>
						</div>
					</div>
					
					
					<div class="accordion-group">
						<div class="accordion-heading">
							<a class="accordion-toggle b_F6F1A2 collapsed" onmouseover="$(this).tooltip('show')" 
							data-toggle="tootip" title="努力开发中。。。" href="javascript:void()"><i
								class="icon-tasks"></i> <span>我的资源</span></a>
						</div>
					</div>
					
					<div class="accordion-group">
						<div class="accordion-heading">
							<a class="accordion-toggle b_C3F7A7 collapsed"
								data-toggle="collapse" data-parent="#accordion2"
								href="#collapse3"><i class="icon-magic"></i> <span>其他</span></a>
						</div>
						<div id="collapse3" class="accordion-body collapse">
							<div class="accordion-inner">
								<a class="accordion-toggle a_advice a_pjax" href="user/mine/advice.html"><i
									class="icon-star"></i> 提点意见</a>  <a
									class="accordion-toggle" href="javascirpt:void(0)"><i
									class="icon-table"></i> 其他</a>
							</div>
						</div>
					</div>
					
				</div>
			</div>
			<!-- /Side menu -->

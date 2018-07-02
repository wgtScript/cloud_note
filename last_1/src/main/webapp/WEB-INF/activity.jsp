<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>活动列表</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="x-pjax-version" content="v173">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="./ico/favico-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="./ico/favico-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="./ico/favico-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="./ico/favico-57-precomposed.png">
        <link rel="shortcut icon" href="./ico/favico.png">
        <link rel="shortcut icon" href="./ico/favico.ico">
        <link rel="stylesheet" href="./styles/icon.css"/>
        <link rel="stylesheet" href="./styles/main.css"/>
        <link rel="stylesheet" href="./styles/prettify.css"/>
        <style type="text/css">
			.title{
				overflow:hidden;
				white-space:nowrap;
				word-break:keep-all;
				text-overflow:ellipsis;
			}        
			.wgt{
				height:0px;
				padding-bottom:15%;
			}
        
        </style>
          <script type="text/javascript" src="./scripts/commons.js"></script>
    </head>
    <body class="animated fadeIn">
        <header class="header">
            <div class="header-brand">
                <a data-pjax=".content-body" href="edit.html">
                    <img class="brand-logo" src="./images/dummy/8986f28e.stilearn-logo.png" alt="Stilearn Admin Sample Logo">
                </a>
            </div>
            <div class="header-profile">
                <div class="profile-nav">
                    <span class="profile-username">奔XX</span>
                    <a  class="dropdown-toggle" data-toggle="dropdown">
                        <span class="fa fa-angle-down"></span>
                    </a>
                    <ul class="dropdown-menu animated flipInX pull-right" role="menu">
                        <li><a href="Change_password.html"><i class="fa fa-user"></i> 修改密码</a></li>
                        <li class="divider"></li>
                        <li><a href="log_in.html"><i class="fa fa-sign-out"></i> 退出登录</a></li>
                    </ul>
                </div>
            </div>
            <ul class="hidden-xs header-menu pull-right">
                <li>
                    <a href="edit.html" title="我的笔记">我的笔记</a>
                </li>
            </ul>
        </header>
		<div class="row" style='padding:0;'>
			<!-- 活动第三列 -->
			<div class="col-sm-12" id='action_part'>
				<aside class="side-right" id='side_right'>
					<div class="module" data-toggle="niceScroll">
						<div class="chat-contact">
							<div class="contact-body clear_margin">
								<h3 class="lead"><i class="fa fa-rss"></i> 近期活动</h3>
									
										<c:forEach items="${activitys}" var="i" varStatus="dd">
										
											<c:if test="${dd.index%3==0 }">
											<div class="row">
											</c:if>
										
										
											<div class="col-sm-4" id='col_${dd.index}'>
													<div class="panel panel-primary">
													<%-- <h3 class="bg-warning wgt"> 活动名称<a  href="#">${i.title}</a></h3>										
													<input type="hidden" value="${i.id}" id="aaa"/>
													<p title="${i.body}" class="title ">活动概述${i.body }</p>
													<p class='tim '>截止日期：${i.endTime }</p> --%>
													<%-- <h1 >${fn:length(activitys)}</h1> --%>
														<div class="panel-heading wgt ">
															<strong>活动名称:</strong><a  href="#">${i.title}</a>
														</div>
														<input type="hidden" value="${i.id}" id="aaa"/>
														 <div class="panel-body">
															${i.body }
														</div>
														<div class="panel-body text-danger">
															截止日期：<span class="tim">${i.endTime }</span>
														</div>
													</div>
											</div>
											
											<c:if test="${dd.index%3==2 }">
											</div>
											</c:if>
									</c:forEach>
							</div>
						</div>
					</div>
				</aside>
			</div>
			<!-- 活动第三列 -->
		</div>
        <footer>
            <p>&copy; 2014 Stilearning</p>
        </footer>
        <script type="text/javascript" src="./scripts/jquery.min.js"></script>
		<!-- Bootstrap框架JS -->
		<script type="text/javascript" src="./scripts/bootstrap.min.js"></script>   
        <script type="text/javascript" src="./scripts/theme-setup.js"></script>
		<!-- 全局变量&&AJAX&&回调函数&&COOKIE -->
		<!-- <script type="text/javascript" src="./scripts/BaseValues.js"></script>
		<script type="text/javascript" src="./scripts/activity/activity.js"></script>
		<script type="text/javascript" src="./scripts/activity/activity_callback.js"></script>
		<script type="text/javascript" src="./scripts/cookie_util.js"></script>
		<script type="text/javascript" src="./scripts/utils.js"></script> -->
		<!-- 页面事件处理JS -->
<!-- 		 <script type="text/javascript" src='./scripts/local.js'></script> -->
		<script type="text/javascript">
			function get_dom(e){
				return document.getElementById(e);
			}
			function set_height(){
				var pc_height=window.innerHeight;
				pc_height=pc_height-100;
				get_dom('side_right').style.height=pc_height+'px';
			}
			set_height();
			window.onresize=function(){
				set_height();
			}
			window.onload=function(){
			/* 	activity_list(); */
			}
		</script> 
		  <script type="text/javascript" src="./scripts/activity.js"></script>
	
    </body>		
</html>
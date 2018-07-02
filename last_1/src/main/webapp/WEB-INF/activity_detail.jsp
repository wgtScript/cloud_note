<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>活动详情</title>
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
		<!-- Google-Code代码高亮CSS -->
        <link rel="stylesheet" href="./styles/prettify.css"/>

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
                        <li><a id="logout" href="#" ><i class="fa fa-sign-out"></i> 退出登录</a></li>
                    </ul>
                </div>
            </div>
            <form role="form" class="form-inline">
                <button type="button" class="btn btn-default btn-expand-search"><i class="fa fa-search"></i></button>
                <div class="toggle-search">
                    <input type="text" class="form-control" placeholder="搜索笔记">    
                    <button type="button" class="btn btn-default btn-collapse-search"><i class="fa fa-times"></i></button>
                </div>
            </form>
            <ul class="hidden-xs header-menu pull-right">
                <li>
                    <a href="activity.do" title="笔记活动">活动</a>
                </li>
            </ul>
        </header>
		<div class="row" style='padding:0;'>
			<!-- alert_background-->
			<div class="opacity_bg"></div>
			<div id="can"></div>
			<!-- alert_like -->
			<div class="modal fade in" id="modalBasic_14" tabindex="-1" role="dialog" aria-labelledby="modalBasicLabel" aria-hidden="false" style="display: none;">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="modalBasicLabel_4">收藏笔记</h4>
						</div>
						<div class="modal-body">
							<div class="form-group">
                               <p> 笔记将被默认收藏至<strong>收藏笔记本</strong>，是否继续收藏？</p>
                            </div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default cancle" data-dismiss="modal">取 消</button>
							<button type="button" class="btn btn-primary sure">收 藏</button>
						</div>
					</div>
				</div>
			</div>
			<!-- alert_like -->
			<!-- join_activity -->
			<div class="modal fade in" id="modalBasic_15" tabindex="-1" role="dialog" aria-labelledby="modalBasicLabel" aria-hidden="false" style='display: none;'>
				<div class="modal-dialog" style='width:50%;margin:5% auto 0;'>
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="modalBasicLabel_5">选择参加活动的笔记</h4>
						</div>
						<div class="modal-body clear_margin">
							<div class="row">
								<!-- 选择笔记本 -->
								<div class="col-xs-5" style='padding:0;border-right:1px solid #E0E4E8;'>
									<aside class="side-right" id='select_notebook'>
										<div class="module" data-toggle="niceScroll">
											<div class="chat-contact">
												<div class="contact-body">
													<ul class="contacts-list" id="booksUl">
														<li class="online"><a ><i class="fa fa-book" title="online" rel="tooltip-bottom"></i> 默认笔记本</a></li>
													</ul>
												</div>
											</div>
										</div>
									</aside>					
								</div>
								<!-- 选择笔记本 -->
								<!-- 选择笔记 -->
								<div class="col-xs-7" style='padding:0;'>
									<aside class="side-right" id='select_note'>
										<div class="module" data-toggle="niceScroll">
											<div class="chat-contact">
												<div class="contact-body">
													<ul class="contacts-list" id="notesUl">
														<li class="online"><a ><i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i> 测试笔记_1</a></li>
													</ul>
												</div>
											</div>
										</div>
									</aside>
								</div>
								<!-- 选择笔记 -->
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default cancle" data-dismiss="modal">取 消</button>
							<button type="button" class="btn btn-primary sure">确 定</button>
						</div>
					</div>
				</div>
			</div>
			<!-- join_activity -->
			<!-- 全部活动笔记 -->
			<div class="col-xs-3" style='padding:0 0 0 15px;' id='action_part_1'>
				<div class="pc_top_first">
					<h3>参加活动笔记</h3>
					<button type="button" class="btn btn-default btn-xs btn_plus" id='join_action' title='参加活动...'><i class="fa fa-plus"></i></button>
				</div>
				<aside class="side-right" id='first_action'>
					<div class="module" data-toggle="niceScroll">
						<div class="chat-contact">
							<div class="contact-body">
								<ul class="contacts-list" id="activityUl">
									<li class="online"><a ><i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i> 测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试<button type="button" class="btn btn-default btn-xs btn_position_3 btn_up"><i class="fa fa-thumbs-o-up"></i></button><button type="button" class="btn btn-default btn-xs btn_position_2 btn_down"><i class="fa fa-thumbs-o-down"></i></button><button type="button" class="btn btn-default btn-xs btn_position btn_like"><i class="fa fa-star-o"></i></button></a></li>
								</ul>
							</div>
						</div>
						<div id='more_activity_note'>更多...</div>
					</div>
				</aside>
			</div>
			<!-- 全部活动笔记 -->
			<!-- 预览笔记 -->
			<div class="col-sm-9" id='pc_part_5' >
				<div class="pc_top_third">
					<div class="row">
						<div class="col-xs-9">
							<h3>预览笔记</h3>
						</div>
					</div>
				</div>
				<aside class="side-right" id='fifth_side_right'>
					<div class="module" data-toggle="niceScroll">
						<div class="chat-contact">
							<div class="contact-body clear_margin" id="content_body">
							<h4><strong>笔记标题: </strong><span>switch多分支结构</span></h4>
								<!-- 填写笔记内容 -->
							<h5 >笔记内容！！！</h5>	
							</div>
						</div>
					</div>
				</aside>
			</div>
			<!-- 预览笔记 -->
		</div>
        <footer>
            <p>&copy; 2014 Stilearning</p>
			<div style='position:absolute;top:5PX;height:30px;right:20px;line-height:26px;border:1px solid #0E7D76;display:none;background:#fff'>
				<strong style='color:#0E7D76;margin:0 10px;'></strong>
			</div>
        </footer>
		<script type="text/javascript">
			//加载DOM之后处理页面高度
			function get_dom(e){
				return document.getElementById(e);
			}
			function set_height(){
				var pc_height=window.innerHeight;
				pc_height=pc_height-131;
				get_dom('first_action').style.height=pc_height+'px';
				get_dom('fifth_side_right').style.height=(pc_height-15)+'px';
			}
			set_height();
			window.onresize=function(){
				set_height();
			}
		</script>
        <script type="text/javascript" src="./scripts/jquery.min.js"></script>
         <script type="text/javascript" src="./scripts/cookie_util.js"></script>
        
		<!-- 全局变量&&AJAX&&回调函数&&COOKIE -->
		<!-- <script type="text/javascript" src="./scripts/BaseValues.js"></script>
        <script type="text/javascript" src="./scripts/cookie_util.js"></script>
		<script type="text/javascript" src="./scripts/login/login.js"></script>
        <script type="text/javascript" src="./scripts/notebook/notebook_callback.js"></script>
        <script type="text/javascript" src="./scripts/notebook/notebook.js"></script>
        <script type="text/javascript" src="./scripts/note/note_callback.js"></script>
        <script type="text/javascript" src="./scripts/note/note.js"></script>
        <script type="text/javascript" src="./scripts/activity/activity_callback.js"></script>
        <script type="text/javascript" src="./scripts/activity/activity.js"></script> -->
		<!-- Bootstrap框架JS -->
        <script type="text/javascript" src="./scripts/bootstrap.min.js"></script>
        <script type="text/javascript" src="./scripts/js-prototype.js"></script>       
        <script type="text/javascript" src="./scripts/theme-setup.js"></script>
		<!-- Google-Code代码高亮JS -->
        <script type="text/javascript" src="./scripts/run_prettify.js"></script>
		<!-- 页面事件处理JS -->
      <!--   <script type="text/javascript" src="./scripts/local.js"></script> -->
        <script type="text/javascript">
			//重写JS原生alert函数
			window.alert=function(e){
				$('#can').load('./alert/alert_error.html',function(){
					$('#error_info').text(' '+e);
					$('.opacity_bg').show();
					
					$('#can').find('button.close,.cancle').click(function(){
						$('#can').empty();
						$('.opacity_bg').hide();
					});
				
				})
			};
			
		
			//获取URL中的活动ID
/*         	var global_ac_id='';
        	window.onload=function(){
        		get_activity_id();
        	};
 */        </script>
  <script type="text/javascript" src="./scripts/acitivity_note.js"></script>
    </body>		
</html>
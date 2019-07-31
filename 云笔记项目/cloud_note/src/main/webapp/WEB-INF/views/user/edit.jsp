﻿<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>我的笔记</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="x-pjax-version" content="v173">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../../../ico/favico-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../../../ico/favico-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../../../ico/favico-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="../../../ico/favico-57-precomposed.png">
        <link rel="shortcut icon" href="../../../ico/favico.png">
        <link rel="shortcut icon" href="../../../ico/favico.ico">
        <link rel="stylesheet" href="../../../styles/icon.css"/>
        <link rel="stylesheet" href="../../../styles/main.css"/>
		<!-- Google-Code代码高亮CSS -->
        <link rel="stylesheet" href="../../../styles/prettify.css"/>
		<!-- Ueditor编辑器CSS -->
		<link href="../../../styles/umeditor.min.css" type="text/css" rel="stylesheet">
    </head>
    <body class="animated fadeIn">
        <header class="header">
            <div class="header-brand">
                <a data-pjax=".content-body" href="edit.jsp">
                    <img class="brand-logo" src="../../../images/dummy/8986f28e.stilearn-logo.png" alt="Stilearn Admin Sample Logo">
                </a>
            </div>
            <div class="header-profile">
                <div class="profile-nav">
                    <span class="profile-username">Leo</span>
                    <a class="dropdown-toggle" data-toggle="dropdown">
                        <span class="fa fa-angle-down"></span>
                    </a>
                    <ul class="dropdown-menu animated flipInX pull-right" role="menu">
                        <li><a href="../../../change_password.html"><i class="fa fa-user"></i> 修改密码</a></li>
                        <li class="divider"></li>
                        <li><a id="logout" href="#" ><i class="fa fa-sign-out"></i> 退出登录</a></li>
                    </ul>
                </div>
            </div>
            <form class="form-inline" onsubmit="return false;">
                <button type="button" class="btn btn-default btn-expand-search"><i class="fa fa-search"></i></button>
                <div class="toggle-search">
                    <input type="text" class="form-control" placeholder="搜索笔记" id='search_note'>
                    <button type="button" class="btn btn-default btn-collapse-search"><i class="fa fa-times"></i></button>
                </div>
            </form>
            <ul class="hidden-xs header-menu pull-right">
                <li>
                    <a href="../../../activity.html" target='_blank' title="笔记活动">活动</a>
                </li>
            </ul>
        </header>
        
        <!-- 全部笔记本 -->
		<div class="row" style='padding:0;' id='center'>
			<!-- alert_background-->
			<div class="opacity_bg" style='display:none'></div>
			<!-- alert_notebook -->
			<div id="can"></div>
			<div class="col-xs-2" style='padding:0;' id='pc_part_1'>
				<!-- side-right -->
				<div class="pc_top_first">
					<h3>全部笔记本</h3>
					<button type="button" class="btn btn-default btn-xs btn_plus" id='add_notebook'><i class="fa fa-plus"></i></button>
				</div>
				<aside class="side-right" id='first_side_right'>
					<div class="module" data-toggle="niceScroll">
						<div class="chat-contact">
							<div class="contact-body">
								<ul class="contacts-list">
									<li class="online">
										<a class='checked'>
											<i class="fa fa-book" title="online" rel="tooltip-bottom"></i> 默认笔记本
										</a>
									</li>
									<!-- 
									<li class="online">
										<a class='unchecked'>
											<i class="fa fa-book" title="笔记本" rel="tooltip-bottom"></i> Spring
											<button type="button" class="btn btn-default btn-xs btn_position btn_delete"><i class="fa fa-times"></i></button>
										</a>
									</li>
									 -->
								</ul>
							</div>
						</div>
					</div>
				</aside>
				<div class="row clear_margin">
					<div class="col-xs-4 click" id='rollback_button' title='回收站'><i class='fa fa-trash-o' style='font-size:20px;line-height:31px;'></i></div>
					<div class="col-xs-4 click" id='like_button' title='收藏笔记本'><i class='fa fa-star' style='font-size:20px;line-height:31px;'></i></div>
					<div class="col-xs-4 click" id='action_button' title='参加活动笔记'><i class='fa fa-users' style='font-size:20px;line-height:30px;'></i></div>
				</div>
			</div>
			
			<!-- 全部笔记 -->
			<div class="col-xs-3" style='padding:0;' id='pc_part_2'>
				<div class="pc_top_second" id='notebookId'>
					<h3>全部笔记</h3>
					<button type="button" class="btn btn-default btn-xs btn_plus" id='add_note'><i class="fa fa-plus"></i></button>
				</div>
				<aside class="side-right" id='second_side_right'>
					<div class="module" data-toggle="niceScroll">
						<div class="chat-contact">
							<div class="contact-body">
								<ul class="contacts-list">
									<!-- 
									<li class="online">
										<a class='checked'>
											<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i> 使用Java操作符<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>
										</a>
										<div class="note_menu" tabindex='-1'>
											<dl>
												<dt><button type="button" class="btn btn-default btn-xs btn_move" title='移动至...'><i class="fa fa-random"></i></button></dt>
												<dt><button type="button" class="btn btn-default btn-xs btn_share" title='分享'><i class="fa fa-sitemap"></i></button></dt>
												<dt><button type="button" class="btn btn-default btn-xs btn_delete" title='删除'><i class="fa fa-times"></i></button></dt>
											</dl>
										</div>
									</li>
									 -->
								</ul>
							</div>
						</div>
					</div>
				</aside>
			</div>
			
			<!-- 回收站笔记 -->
			<div class="col-xs-3" style='padding:0;display:none;' id='pc_part_4'>
				<div class="pc_top_second">
					<h3>回收站笔记</h3>
				</div>
				<aside class="side-right" id='four_side_right'>
					<div class="module" data-toggle="niceScroll">
						<div class="chat-contact">
							<div class="contact-body">
								<ul class="contacts-list">
									<li class="disable"><a ><i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i> 虚假回收站笔记<button type="button" class="btn btn-default btn-xs btn_position btn_delete"><i class="fa fa-times"></i></button><button type="button" class="btn btn-default btn-xs btn_position_2 btn_replay"><i class="fa fa-reply"></i></button></a></li>
								</ul>
							</div>
						</div>
					</div>
				</aside>
			</div>
			
			<!-- 搜索笔记列表 -->
			<div class="col-xs-3" style='padding:0;display:none;' id='pc_part_6'>
				<div class="pc_top_second">
					<h3>搜索结果</h3>
				</div>
				<aside class="side-right" id='sixth_side_right'>
					<div class="module" data-toggle="niceScroll">
						<div class="chat-contact">
							<div class="contact-body">
								<ul class="contacts-list">
									<li class="online">
										<a href="#">
											<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i> 虚假搜索笔记<button type="button" class="btn btn-default btn-xs btn_position btn_like"><i class="fa fa-star-o"></i></button><div class="time"></div>
										</a>
									</li>
								</ul>
							</div>
						</div>
						<div id='more_note'>更多...</div>
					</div>
				</aside>
			</div>
			
			<!-- 收藏笔记列表 -->
			<div class="col-xs-3" style='padding:0;display:none;' id='pc_part_7'>
				<div class="pc_top_second">
					<h3>已收藏笔记</h3>
				</div>
				<aside class="side-right" id='seventh_side_right'>
					<div class="module" data-toggle="niceScroll">
						<div class="chat-contact">
							<div class="contact-body">
								<ul class="contacts-list">
									<!-- <li class="idle"><a ><i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i> switch多分支结构<button type="button" class="btn btn-default btn-xs btn_position btn_delete"><i class="fa fa-times"></i></button></a></li> -->
								</ul>
							</div>
						</div>
					</div>
				</aside>
			</div>
			
			<!-- 参加活动的笔记列表 -->
			<div class="col-xs-3" style='padding:0;display:none;' id='pc_part_8'>
				<div class="pc_top_second">
					<h3>参加活动的笔记</h3>
				</div>
				<aside class="side-right" id='eighth_side_right'>
					<div class="module" data-toggle="niceScroll">
						<div class="chat-contact">
							<div class="contact-body">
								<ul class="contacts-list">
									<!-- 
									<li class="offline"><a ><i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i> 样式用例（点击无效）</a></li>
									 -->
								</ul>
							</div>
						</div>
					</div>
				</aside>
			</div>
			
			<!-- 编辑笔记 -->
			<div class="col-sm-7" id='pc_part_3'>
				<!-- side-right -->
				<div class="pc_top_third">
					<div class="row">
						<div class="col-xs-9">
							<h3>编辑笔记</h3>
						</div>
						<div class="col-xs-3">
							<button type="button" class="btn btn-block btn-sm btn-primary" id='save_note'>保存笔记</button>
						</div>
					</div>
				</div>
				<aside class="side-right" id='third_side_right'>
					<div class="module" data-toggle="niceScroll">
						<div class="chat-contact">
							<div class="contact-body clear_margin">
								<!--- 笔记标题 --->
								<div class="row" >
									<div class="col-xs-8">
										<input type="text" class="form-control" id="input_note_title" placeholder='笔记标题...'>
									</div>
								</div>
								<!--- 笔记标题 --->
								<div class="row">
									<div class="col-sm-12">
										<!--- 输入框 --->
										<script type="text/plain" id="myEditor" style="width:100%;height:400px;">
										</script>
										<!--- 输入框 --->
									</div>
								</div>
							</div>
						</div>
					</div>
				</aside>
			</div>
			
			<!-- 预览笔记 -->
			<div class="col-sm-7" id='pc_part_5' style='display:none;' >
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
							<div class="contact-body clear_margin">
								<h4 id="noput_note_title"></h4>
							</div>
						</div>
					</div>
				</aside>
			</div>
		</div>
        
		<script type="text/javascript">
			//加载DOM之后处理页面高度
			function get_dom(e){
				return document.getElementById(e);
			}
			function set_height(){
				var pc_height=window.innerHeight;
				pc_height=pc_height-132;
				get_dom('first_side_right').style.height=(pc_height-31)+'px';
				get_dom('second_side_right').style.height=pc_height+'px';
				get_dom('four_side_right').style.height=pc_height+'px';
				get_dom('sixth_side_right').style.height=pc_height+'px';
				get_dom('seventh_side_right').style.height=pc_height+'px';
				get_dom('eighth_side_right').style.height=pc_height+'px';
				get_dom('third_side_right').style.height=(pc_height-15)+'px';
				get_dom('fifth_side_right').style.height=(pc_height-15)+'px';
			}
			function myEditorWidth(){
				var dom=get_dom('third_side_right');
				var style=dom.currentStyle||window.getComputedStyle(dom, null);
				get_dom('myEditor').style.width=style.width;
			}
			set_height();
			//改变窗口大小时调整页面尺寸
			window.onresize=function(){
				set_height();
				var width=$('#third_side_right').width()-35;
				$('.edui-container,.edui-editor-body').width(width);
				$('#myEditor').width(width-20);
			};
		</script>
        <script type="text/javascript" src="../../../scripts/common/jquery.min.js"></script>
		<!-- 全局变量&&AJAX&&COOKIE -->
		<script type="text/javascript" src="../../../scripts/base.js"></script>
		<script type="text/javascript" src="../../../scripts/notebook.js"></script>
		<script type="text/javascript" src="../../../scripts/note.js"></script>
		<script type="text/javascript" src="../../../scripts/login.js"></script>
		<script type="text/javascript" src="../../../scripts/cookie.js"></script>
		<!-- Bootstrap框架JS -->
        <script src="../../../scripts/common/bootstrap.min.js"></script>
        <script src="../../../scripts/common/js-prototype.js"></script>
        <script src="../../../scripts/common/theme-setup.js"></script>
		<!-- 页面事件处理JS -->
        <script class="re-execute" src="../../../scripts/local.js"></script>
		<!-- Ueditor编辑器JS -->
		<script type="text/javascript" charset="utf-8" src="../../../scripts/common/ue/umeditor.config.js"></script>
		<script type="text/javascript" charset="utf-8" src="../../../scripts/common/ue/umeditor.min.js"></script>
		<script type="text/javascript" src="../../../scripts/common/ue/lang/zh-cn.js"></script>
		<script type="text/javascript">
			//重写JS原生alert函数
			window.alert=function(e){
				$('#can').load('../../../alert/alert_error.html',function(){
					$('#error_info').text(' '+e);
					$('.opacity_bg').show();
				});
			}
			
			//获取笔记本列表
			get_nb_list();
			//获取特殊笔记本列表
			get_spnb_list();
			//实例化Ueditor编辑器
			var um = UM.getEditor('myEditor');
		</script>
	</body>		
</html>
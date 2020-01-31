<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>在线投稿审稿管理系统</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>   
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />在线投稿审稿管理系统</h1>
  </div>
  <div class="head-l"><a class="button button-little bg-green" href="" target="_blank"><span class="icon-home"></span> 前台首页</a> &nbsp;&nbsp;<a class="button button-little bg-red" href="login.jsp"><span class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>功能列表</strong></div>

  
  <h2><span class="icon-user"></span>个人信息管理</h2>
  <ul style="display:block">
    <li><a href="userInfo?writerId=${writer.writerId}" target="right"><span class="icon-caret-right"></span>查看个人信息</a></li>
  </ul> 
  
  <h2><span class="icon-user"></span>个人稿件管理</h2>
  <ul style="display:block">
    <li>
    	  <li><a href="getArticleInfo?articleWriterId=${writer.writerId}" target="right"><span class="icon-caret-right"></span>查看稿件信息</a></li>	
    </li>
  </ul>
   
  <h2><span class="icon-user"></span>审核记录</h2>
  <ul style="display:block">
    <li><a href="getCheckInfo?writerId=${writer.writerId}" target="right"><span class="icon-caret-right"></span>查看审核记录</a></li>
  </ul> 

  <h2><span class="icon-user"></span>个人账户管理</h2>
  <ul style="display:block">
    <li><a href="getAccountInfo?writerId=${writer.writerId}" target="right"><span class="icon-caret-right"></span>查看个人账户</a></li>
  </ul> 

</div>

<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});


</script>
<ul class="bread">
  <li><a href="##" id="a_leader_txt">网站信息</a></li>
  <li><b>当前用户：</b><span style="color:red;">${writer.getWriterName()}</php></span>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
</ul>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="index.jsp" name="right" width="100%" height="100%"></iframe>
</div>

</body>
</html>
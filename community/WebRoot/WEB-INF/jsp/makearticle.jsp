<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String username = (String)session.getAttribute("username");
String imagedir = (String)session.getAttribute("imagedir");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>community</title>
	<script type="text/javascript" src="./js/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="./js/makearticle.js"></script>
	<script src="./ckeditor/adapters/jquery.js"></script>
	<link rel="stylesheet" type="text/css" href="./css/mycss.css"/>
	<link rel="stylesheet" type="text/css" href="./css/makearticle.css"/>
	<script src="./ckeditor/ckeditor.js"></script>
	</head>
	<body>
	
		<!--统一的div-->
		<div id="top_pane"></div>
		<div id="info_pane"></div>
		<div id="content_pane"></div>
		<div id="photo_pane"><img src="ShowHeadPhotoAction.action" alt="头像" /></div>
		<div id="name_pane">
		    <p style="font-size:24px; color:#CCC"><%=username%></p>
		</div>
		<div id="title_pane"></div>
		<form action="SaveArticleAction.action" method="post">
			<div id="title"><span>标题 <input type="text" name="title" class="text_aleda"/></span><span id="hint_title"></span></div>
			<div id="button_pane">
				<span>
			    	<a href="showarticles_page.action"><button id="submit" type="submit">提交</button></a>
			        <a href="showarticles_page.action"><button id="return ">返回</button></a>
			    </span>
			</div>
			
			<!--文本编辑器的div-->
			<div id="texteditor_pane">
			  <textarea class="ckeditor" name="content">
			  </textarea>
			</div>
		</form>
		
		<!--菜单导航-->
		<div id="content">
			 <div id="nav">
		    	<ul id="supnav">
		     		<li><a id="blog" href="showarticles_page.action" class="a" style="color:#61d7a4">我的博客</a></li>
					<li><a id="photo" href="photowall_page.action" class="a">我的相册</a></li>
					<li><a id="words" href="messageboard_page.action" class="a">我的留言</a></li>
					<li><a id="source" href="uploadfile_page.action" class="a">我的资源</a></li>      
		    	</ul>
		</div>
	</body>
</html>


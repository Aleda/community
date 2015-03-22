<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String username = (String)session.getAttribute("username");
String imagedir = (String)session.getAttribute("imagedir");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'photowall.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="./css/mycss.css">
	<link rel="stylesheet" type="text/css" href="./css/photowall.css">
	<script type="text/javascript" src="./js/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="./js/photowall.js"></script>
	<!--照片插件的引用-->
	<link rel="stylesheet" href="./css/bootstrap.min.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="./css/demo.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="./venobox/venobox.css" type="text/css" media="screen" />
	<script type="text/javascript" src="./venobox/venobox.min.js" ></script>
	
	<style type="text/css">
		#photos_pane {
			position: absolute;
			left: 512px;
			top: 330px;
			width: 680px;
			height: 500px;
			z-index: 11;
			overflow-y:scroll;
			background-color:#62da97;
			
		}
		#photos_pane ul li {
			float:left;
			margin-right:10px;
			margin-left:10px;
			margin-bottom:5px;
		}
		
	</style>
  </head>
  
  <body>
  	<div id="top_pane"></div>
  	<div id="tip"> Welcome: <a><%=username%></a></div>
  	<!--统一的div-->
	<div id="info_pane"></div>
	<div id="content_pane"></div>
	<div id="photo_pane"><img src="ShowHeadPhotoAction.action" alt="头像" /></div>
	<div id="name_pane">
	  <p style="font-size:24px; color:#CCC"><%=username%></p>
	</div>
	<div id="title_pane"></div>
	<div id="title">照片墙</div>
	<div id="button_pane">
		<span>
			<button id="stick">贴照片</button>
			<button id="delete_photos">删除照片</button>
			<a href="main_page.action"><button id="return ">返回</button></a>
		</span>
	</div>

	<!--显示照片的div-->
	<div id="photos_pane" >
		<ul class="thumbs list-unstyled">
		</ul>
	</div>
	
	<!-- 上传文件的div -->
	<div id="uploadphotos">
		<s:form id="photouploadform" action="UploadPhotosAction.action" enctype="multipart/form-data">
	  			<span id="photos">
	  				<input type="file" name="upload"/>
	  				<input type="text" name="photoName" />
	  				<br />
	  			</span>
	  			<button type="button" onclick="addFile()">添加照片</button>
	  			<button type="submit">上传</button>
	  			<button id="nouploadfile" type="button">返回</button>
	  	</s:form>
	</div>
	
  	<!-- 导航的div -->
	<div id="content">
		<div id="nav">
			<ul id="supnav">
				<li><a id="blog" href="showarticles_page.action" class="a">我的博客</a></li>
				<li><a id="photo" href="photowall_page.action" class="a" style="color:#61d7a4">我的相册</a></li>
				<li><a id="words" href="messageboard_page.action" class="a">我的留言</a></li>
				<li><a id="source" href="uploadfile_page.action" class="a">我的资源</a></li>
			</ul>
		</div>
	</div>
  </body>
</html>

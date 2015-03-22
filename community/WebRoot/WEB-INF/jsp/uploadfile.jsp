<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String username = (String)session.getAttribute("username");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'source.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>无标题文档</title>
	<script src="./js/jquery-1.7.2.js"></script>
	<link rel="stylesheet" type="text/css" href="./css/uploadfile.css"/>
	<link rel="stylesheet" type="text/css" href="./css/mycss.css"/>
	<script type="text/javascript" src="./js/uploadfile.js"></script>
	</head>
	
	<body>
		<!--统一的div-->
		<div id="top_pane"></div>
		<div id="info_pane"></div>
		<div id="hint"></div>
		<div id="content_pane"></div>
		<div id="photo_pane"><img src="ShowHeadPhotoAction.action" alt="头像" /></div>
		<div id="name_pane">
		  <p style="font-size:24px; color:#CCC"><%=username%></p>
		</div>
		<div id="tip"> Welcome: <a><%=username%></a></div>
		<div id="title_pane"></div>
		<div id="title">资源库</div>
		<div id="button_pane">
			<span>
		        <a><button id="addfilebutton" style="width:0px">添加资源</button></a>
		        <a><button id="addsitebutton" style="width:0px">添加网站</button></a>
		        <a><button id="deletefilebutton" style="width:0px">删除资源</button></a>
		        <a><button id="deletesitebutton" style="width:0px">删除资源</button></a>
		        <a href="main_page.action"><button id="return">返回</button></a>
		    </span>
		</div>
		
		
		<!--装载已下文件资源的div-->
		<div id="file_pane"></div>
		<!--装载已下网站资源的div-->
		<div id="web_pane"></div>
		
		<!--装文件按钮的div-->
		<div id="file_button_pane">
			<button class="filebutton" onfocus="this.blur()">文件资源</button>
		</div>
		<!--装网地址站按钮的div-->
		<div id="web_button_pane">
			<button class="webbutton" onfocus="this.blur()">网站资源</button>
		</div>
		
		
		<!--装载文件名称的div-->
		<div id="filename_pane">
			<ol id="titleslist">
			</ol>
		</div>
		<!---装载增加文件资源的按钮的div-->
          <!--<div id="file_addbutton_pane">
			<button id="addfilebutton">添加资源</button>
		</div>-->	
		<!---装载删除文件资源的按钮的div-->
		<!--<div id="file_deletebutton_pane">
			<button id="deletefilebutton">删除资源</button>
		</div> -->
		
		
		<!--装载网址名的div-->
		<div id="webname_pane">
			<ol id="siteslist">
			</ol>
		</div>
		<!--装载增加网站资源的div-->
		<!--<div id="web_addbutton_pane">
			<button id="addsitebutton">添加网站</button>
		</div>-->
		<!--装载删除网站资源的div-->
		<!--<div id="web_deletebutton_pane">
			<button id="deletesitebutton">删除资源</button>
		</div> -->
	
		


	<!--菜单导航-->
	
		<div id="content">
			<div id="nav">
				<ul id="supnav">
					<li><a id="blog" href="showarticles_page.action" class="a">我的博客</a></li>
					<li><a id="photo" href="photowall_page.action" class="a">我的相册</a></li>
					<li><a id="words" href="messageboard_page.action" class="a">我的留言</a></li>
					<li><a id="source" href="uploadfile_page.action" class="a" style="color:#61d7a4">我的资源</a></li>
				</ul>
			</div>
		</div>
		<div id="uploadmore">
	  		<s:form id="fileuploadform" action="UploadMoreAction.action" enctype="multipart/form-data">
	  			<span id="files">
	  				<input type="file" name="upload"/>
	  				<br />
	  			</span>
	  			<button type="button" onclick="addFile()">添加文件</button>
	  			<button type="submit" id="submit">上传</button>
	  			<button id="nouploadfile" type="button">返回</button>
	  		</s:form>
	   </div>
	   <div id="savesites">
			<form id="siteuploadform" action="SaveSitesAction.action">
		  			<span id="websites">
		  			</span>
		  			<button type="button" onclick="addSite()">添加网站</button>
		  			<button type="submit" name="submit1" id="submit1" onclick="validateSites()">上传</button>
		  			<button id="nouploadsite" type="button">返回</button>
		  	</form>
		</div>
</body>
</html>
		
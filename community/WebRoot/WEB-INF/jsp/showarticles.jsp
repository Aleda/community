<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    
    <title>My JSP 'showarticles.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="./css/mycss.css"/>
	<script src="./js/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="./js/showarticles.js"></script>
	<script type="text/javascript" src="./js/nav.js"></script>

</head>

<body>
	<!-- 统一的div -->
	<div id="top_pane"></div>
	<div id="info_pane"></div>
	<div id="hint"></div>
	<div id="photo_pane""><img alt="meme" src="ShowHeadPhotoAction.action"></div>
	<div id="name_pane">
	  <p style="font-size:24px; color:#CCC"><%=username%></p>
	</div>
	<div id="title_pane">
	</div>
	<div id="button_pane">
		<a href="makearticle_page.action"><button id="submit">写博客</button></a>
		<button id="delete_articles">删除</button>
        <a href="main_page.action"><button id="return ">返回</button></a>
	</div>
	<div id="tip">welcome: <a><%=username%></a></div>
	<div id="title">我的博客</div>
	<div id="content_pane">
		<ol id="titleslist">
			
		</ol>
	    <!-- 17条记录是一页 -->
	</div>
	<div id="changepage_pane">
		<a href="showarticles_page.action"><button id="prepage">上一页</button></a>
        <a href="showarticles_page.action"><button id="nextpage">下一页</button></a>
	</div>
	
	<!-- 导航div -->
	<div id="content">
		 <div id="nav">
	    <ul id="supnav">
	      <li><a id="blog" href="showarticles_page.action" class="a" style="color:#61d7a4">我的博客</a></li>
	      <li><a id="photo" href="photowall_page.action" class="a">我的相册</a></li>
	      <li><a id="words" href="messageboard_page.action" class="a">我的留言</a></li>
	      <li><a id="source" href="uploadfile_page.action" class="a">我的资源</a></li>      
	    </ul>
	    <!-- <form action="DisplayOneArticle.action" method="post" style="display: none" id="myform">
	    	<input id="title" name="title" type="text" style="display: none"/>
	    </form> -->
	</div>

</body>
</html>



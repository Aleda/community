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
	<link rel="stylesheet" type="text/css" href="./css/mycss.css" />
	<script type="text/javascript" src="./js/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="./js/nav.js"></script>
	<script type="text/javascript" src="./js/main.js"></script>
</head>

<body>
	<div id="top_pane"></div>
	<div id="tip"> Welcome: <a><%=username%></a></div>
	<div id="content">
		<div id="nav">
			<ul id="supnav">
				<li><a id="blog" href="showarticles_page.action" class="a">我的博客</a></li>
				<li><a id="photo" href="photowall_page.action" class="a">我的相册</a></li>
				<li><a id="words" href="messageboard_page.action" class="a">我的留言</a></li>
				<li><a id="source" href="uploadfile_page.action" class="a">我的资源</a></li>
			</ul>
		</div>
	</div>
</body>
</html>

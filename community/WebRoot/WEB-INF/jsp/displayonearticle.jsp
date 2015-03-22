<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
    <title>My JSP 'displayonearticle.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page"> 
	<link rel="stylesheet" type="text/css" href="./css/mycss.css">

</head>

<body bgcolor="#62da97">
	<div id="articlelll">
		<script type="text/javascript">
			$(document).ready(function() {
				var txt = $("#txt").text();
				$("#articalcontent_pane").append(txt);
			});
		</script>
		<div id="aticaltitle_pane"  class="articaltitle_pane"><s:property value="article.title"/></div>
		<div id="articaltime_pane" class="articaltime_pane"><s:property value="article.create_time"/></div>
		<div id="articalcontent_pane" class="articalcontent_pane">
		<textarea id="txt" rows="10" cols="100" style="display: none; color:#000; font-size:18px"> <s:property value="article.content"/></textarea>
		</div>
	</div>
</body>
</html>


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
    
    <title>My JSP 'messageboard.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="./css/mycss.css">
	<link rel="stylesheet" type="text/css" href="./css/messageboard.css">
	<script type="text/javascript" src="./js/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="./js/messageboard.js"></script>
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
	<div id="title">留言贴</div>
	<div id="button_pane">
		<span>
	        <a href="main_page.action"><button id="return ">返回</button></a>
	    </span>
	</div>
  	<div id="top_pane"></div>
	<div id="tip"> welcome: <a><%=username%></a> </div>
	
	<!--装载留言的div-->
	<div id="words_pane">
		<dl id="words_dl">
	    	<dt>    	 
	        </dt>
	    </dl>
	</div>
	<!--装载好友列表的div-->
	<div id="friendslist_pane">
		<div id="friendstitle_pane">会员列表</div>
		<div id="friendscontent_pane" >
			<dl>
		    </dl>
	    </div>
	</div>

	<!--装载“好友列表”按钮的div-->
	<div id="btn_pane"><button id="list_btn" class="btn">会<br>员<br>列<br>表</button></div>
	
	<!--弹出来写留言的div-->
	<div id="show_pane">
	
		<div id="closebtn_pane"><input type="button" id="close_btn" value="X" style="width:35px; height:30px; background-color:#000; color:#CCC; border:0;"></div>
	
		<div id="title_pane">留言内容</div><div id="hint_null"></div>
		<!--装载文本框的div-->
		 <div id="wordscontent_pane"><textarea id="words_content" cols="33" rows="7" class="show_textarea"></textarea><br>
		</div>
	<!--装载发送按钮的div-->
		<div id="sendwords_btn_pane">
			<button id="submit">发送</button>
		</div>
	</div>
	
	<div id="content">
		<div id="nav">
			<ul id="supnav">
				<li><a id="blog" href="showarticles_page.action" class="a">我的博客</a></li>
				<li><a id="photo" href="photowall_page.action" class="a">我的相册</a></li>
				<li><a id="words" href="messageboard_page.action" class="a" style="color:#61d7a4">我的留言</a></li>
				<li><a id="source" href="uploadfile_page.action" class="a">我的资源</a></li>
			</ul>
		</div>
	</div>
  </body>
</html>

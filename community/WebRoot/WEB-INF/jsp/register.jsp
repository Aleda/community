<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

	<title>My JSP 'register.jsp' starting page</title>
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
		<link rel="stylesheet" type="text/css" href="styles.css">
		-->
	<title>注册界面</title>
	
	<link rel="stylesheet" type="text/css" href="./css/register.css">
	<script src="./js/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="./js/js_register.js"></script>
	<script type="text/javascript">
		$("document").ready(function() {
			$("#apDiv3").slideDown(1000);
			$("#apDiv4").slideDown(1000);
			 $("#register1").click(function() {
				 var username = $("#username").val();
				 var name = $("#name").val();
				 var password = $("#password").val();
				 var qq = $("#qq").val();
				 var mail = $("#mail").val();
				 var phone = $("#phone").val();
				 alert("username = " + username);
				 $.post("RegisterAction.action",
						 { "username": username,
						"name": name,
						"password": password,
						"qq": qq,
						"mail": mail,
						"phone": phone },
						function(data) {
							alert(data.result);
							if (data.result == "exists") {
								$("#t_id").text("用户名存在！");
							} else {
								setTimeout(function() {
									alert("Congratulations!\n" + "恭喜您，注册成功，三秒后自动跳转！");
									$("#myForm").submit();
									return;
								}, 3000);
							}
						});
				 /* $.ajax({
					url: "RegisterAction.action",
					data: { "username": username,
							"name": name,
							"password": password,
							"qq": qq,
							"mail": mail,
							"phone": phone },
					success: function(data) {
						alert(data.result);
						if (data.result == "exists") {
							$("#t_id").text("用户名存在！");
						} else {
							$("#myForm").submit();
							setTimeout(function() {
								alert("Congratulations!\n" + "恭喜您，注册成功，三秒后自动跳转！");
								window.location.href="main_page.action";
								return;
							}, 3000);
						}
					}
				 });   */
				
			}); 
		});
	</script>
	

</head>

<body background="./images/background2.jpg">
	
		<div id="apDiv3"></div>
		<!-- <div id="div_img" style="position:absolute;
	height:510px;
	width:550px;
	left:590px;
	top:70px;
	z-index: 3;
	background-color: #630;
	opacity: .3;">asdas</div> -->

		<div id="apDiv4" >
			<s:form action="UploadHeadImgAction.action" method="post" id="myForm" name="myForm" enctype="multipart/form-data">
			
			<table border="0">
				<tr>
					<td class="re_table1"><label style="color:#C00">*</label>账号:</td>
					<td class="re_table2"><input id="username" name="username" type="text"
						class="re_txtfield1" onblur="id_error()" /></td>
					<td class="t_error"><p id="t_id"></p></td>
				</tr>
				<tr>
					<td class="re_table1"><label style="color:#C00">*</label>昵称:</td>
					<td class="re_table2"><input id="name" name="name" type="text"
						class="re_txtfield1" onblur="name_error()" /></td>
					<td class="t_error"><p id="t_name"></p></td>
				</tr>
				<tr>
					<td class="re_table1">&nbsp;QQ:</td>
					<td class="re_table2"><input id="qq" type="text"
						class="re_txtfield1" name="qq" onblur="qq_error()" /></td>
					<td class="t_error"><p id="t_qq"></p></td>
				</tr>
				<tr>
					<td class="re_table1">&nbsp;Email:</td>
					<td class="re_table2"><input id="mail" type="text"
						class="re_txtfield1" name="mail" onblur="email_error()" /></td>
					<td class="t_error"><p id="t_email"></p></td>
				</tr>
				<tr>
					<td class="re_table1">&nbsp;电话:</td>
					<td class="re_table2"><input id="phone" type="text"
						class="re_txtfield1" name="phone" onblur="phone_error()" /></td>
					<td class="t_error"><p id="t_phone"></p></td>
				</tr>
				<tr>
					<td class="re_table1"><label style="color:#C00">*</label>密码:</td>
					<td class="re_table2"><input id="password" type="password"
						class="re_txtfield1" name="password" onblur="password_error()" /></td>
					<td class="t_error"><p id="t_password"></p></td>
				</tr>
				<tr>
					<td class="re_table1"><label style="color:#C00">*</label>确认密码:</td>
					<td class="re_table2"><input  type="password"
						class="re_txtfield1" id="pwd_confirm" onblur="pwd_confirm_error()" /></td>
					<td class="t_error"><p id="t_pwd_confirm"></p></td>
				</tr>
				<tr>
					<td class="re_table1"><label style="color:#C00">*</label>上传头像:</td>
					<td>
						<input type="file" name="upload" class="re_txtfield1" />
					</td>
				</tr>

			</table>
			<p>
				<input type="button" class="button1" id="register1" value="sign up"
					onmouseover="this.style.backgroundColor='#C30'"
					onmouseout="this.style.backgroundColor='#C63'"
					/> <!-- 千万要注意，方法名不要起register，也不知道是为什么，可能是jquery写了吧，写了不行 -->
			</p>
			</s:form>
		</div>
</body>
</html>

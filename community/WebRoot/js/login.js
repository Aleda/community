$("document").ready(function(){
	$("#submit").click(function() {
		var username = $("#username").val();
		var password = $("#password").val();
		var validationCode = $("#validationCode").val();
		$.ajax({
			url : "LoginAction.action",
			type : "POST",
			data : {
				"username" : username,
				"password" : password,
				"validationCode": validationCode
			},
			success : function(data) {
				alert(data.result);
				if (data.result == "codeerror") {
					$("#validatortip").text("验证码错误");
				} else {
					$("validatortip").text("");
					alert(data.result);
					if (data.result == "usernameerror") {
						$("#validatortip").text("用户名或密码错误");
					} else {
						$("#userinfo").submit();
					}
				}
			}
		});
	});
});
// JavaScript Document

String.prototype.trim=function(){
	return this.replace(/(^\s*)|(\s*$)/g, "");
}

function id_error() {
		var error = document.getElementById("username");
		var t = document.getElementById("t_id");
		if(error.value=="") {
			t.innerHTML="不能为空";
		} else {
			t.innerHTML="";
		}		
}
function name_error() {
	var error = document.getElementById("name");
	var t = document.getElementById("t_name");
	if(error.value=="") {
		t.innerHTML="不能为空";
	} else {
		t.innerHTML="";
	}		
}

function password_error() {
	var error = document.getElementById("password");
	var t = document.getElementById("t_password");
	if(error.value=="") {
		t.innerHTML="不能为空";
	} else {
		t.innerHTML="";
	}		
}

function pwd_confirm_error() {
	var error = document.getElementById("pwd_confirm");
	var t = document.getElementById("t_pwd_confirm");
	var t2 = document.getElementById("password");
	if(error.value =="") {
		t.innerHTML="不能为空";
		return;
	} else {
		if ((t2.value) != (error.value)) {
			t.innerHTML="两次密码输入不一致";
			return;
		} else {
			t.innerHTML="";
			return;
		}
	}
	
}

function email_error() {
	var email = document.getElementById("mail");
	var t = document.getElementById("t_email");		
   	var emailPat=/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    var matchArray=email.value.match(emailPat);
	if(matchArray != null) {
		t.innerHTML = "";
	} else if(email.value=="") {
		t.innerHTML="";
	} else {
		t.innerHTML="email无效";
	}
}

function qq_error() {
	var qq = document.getElementById("qq");
	var t = document.getElementById("t_qq");
	if(/^[0-9]{5,10}$/.test(qq.value) || qq.value=="") {
		t.innerHTML="";
	} else {
		t.innerHTML="qq无效";
	}
}

function phone_error() {
	var phone = document.getElementById("phone");
	var t = document.getElementById("t_phone");
	if(/^(0\d{2,3}-?\d{7,8})|(1\d{10})$/.test(phone.value) || phone.value=="") {
		t.innerHTML="";
	} else {
		t.innerHTML="电话无效";
	}
}

function register11() {
	alert("reister!!");
	var myForm = document.getElementById("myForm");
	myForm.action = "RegisterAction.action";
	myForm.submit();
}

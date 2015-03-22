$(document).ready(function() {
	$(".text_aleda").blur(function() {
		var text = $(".text_aleda").val();
		if (text == "") {
			$("#hint_title").text("标题！");
			$("#hint_title").show();
		} else {
			$("#hint_title").hide();
		}
	});
	$(".ckeditor").blur(function() {
		var text = $(".ckeditor").text();
		if (text == "") {
			alert("请写些内容吧！");
		}
	});
});
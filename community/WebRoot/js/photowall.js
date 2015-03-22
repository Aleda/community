$(document).ready(function() {
	$.ajax({
		url: "ShowPhotosAction.action",
		success: function(data) {
			var size = data.size;
			/*alert("size = " + size);*/
			for (var i = 0; i < size; i++) {
				/*var name = data.photos[i].photo_name;
				var username = data.photos[i].user_name;
				var filename = data.photo[i].file_name;
				var small = data.photos[i].small_path;
				var big = data.photos[i].big_path;
				alert("small = " + small);
				alert("big = " + big);
				alert("name = " + name);*/
				var name = data.photos[i].photo_name;
				var username = data.photos[i].user_name;
				var filename = data.photos[i].file_name;
				/*alert("name = " + name);
				alert("username = " + username);
				alert("filename = " + filename);*/
				var str = "<li><p><a class='venobox' data-gall='gall1' href='#'>" + "<img alt='fuckfuck!!' src='ValidationCodeAcion.action'/></a></p>" + "<p>" + name + "</p></li>";
				var str1 = "<li><p><a class='venobox' data-gall='gall1' href='ShowBigAction.action?username=" + username + "&filename=" + filename + 
				"'>" + "<img src='ShowSmallAction.action?username=" + username + "&filename=" + filename + "'/>" 
					+ "</a></p>" + "<p><input type='checkbox' name='photobox' value='" + name + "'>" + name + "</input></p></li>";
				$("#photos_pane ul").append(str1);
			}
			$('.venobox').venobox({
				numeratio: true,
				border: '20px'
			});
			$('.venoboxvid').venobox({
				bgcolor: '#000'
			});
			$('.venoboxframe').venobox({
				border: '6px'
			});
			$('.venoboxinline').venobox({
				framewidth: '300px',
				frameheight: '250px',
				border: '6px',
				bgcolor: '#f46f00'
			});
			$('.venoboxajax').venobox({
				border: '30px;',
				frameheight: '220px'
			});
			return ;
		}
	});
	$("#stick").click(function() {
		$("#uploadphotos").slideDown("slow");
		$("#nouploadfile").click(function() {
			$("#uploadphotos").slideUp("slow");
		});
	});
	$("#delete_photos").click(function() {
		var photosName = "";
		$("[name='photobox']:checked").each(function() {
			photosName += $(this).val() + ", ";
		});
		if (photosName == "") {
			alert("Attention!!~\r\n请选择要删除的照片!~");
		} else {
			$.ajax({
				url: "DeletePhotosAction.action",
				data: {"photosName": photosName},
				success: function(data) {
					alert("Congratulations!!~\n\r删除图片成功！~");
					window.location.href = "photowall_page.action";
					return;
				}
			});
		}
	});
});


function addFile() {
//	添加photo
	var uploadHTML = document.createElement("input");
	uploadHTML.type = "file";
	uploadHTML.name = "upload";
	var uploadHTML1 = document.createElement("input");
	uploadHTML1.type = "text";
	uploadHTML1.name = "photoName";
	var span = document.getElementById("photos");
	span.appendChild(uploadHTML);
	span.appendChild(uploadHTML1);
	uploadHTML = document.createElement("p");
	span.appendChild(uploadHTML);
}
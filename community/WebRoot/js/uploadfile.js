$(document).ready(function(e) {
	$("#addfilebutton").click(function() {
		$("#uploadmore").slideDown("slow");
		$("#nouploadfile").click(function() {
			$("#uploadmore").slideUp("slow");
		});
	});
	$("#addsitebutton").click(function() {
		$("#savesites").slideDown("slow");
		$("#websites").empty();
		$("#nouploadsite").click(function() {
			$("#savesites").slideUp("slow");
		});
	});
	$("#file_button_pane").click(function(e) {
		$("#hint").hide();
		$("#filename_pane").css('display','block');
		$("#file_pane").css('z-index',13);
		$("#web_button_pane").css('z-index',13);
		$("#web_pane").css('z-index',11);
		$("#file_button_pane").css('z-index',12);
		$("#filename_pane").css('z-index',15);
		$("#file_addbutton_pane").css('z-index',15);
		$("#file_deletebutton_pane").css('z-index',15);
		$("#file_addbutton_pane").css('display','block');
		$("#file_deletebutton_pane").css('display','block');
		$("#webname_pane").css('z-index',12);
		$("#web_addbutton_pane").css('z-index',12);
		$("#web_deletebutton_pane").css('z-index',12);
		$("#addfilebutton").css('width', '100px');
		$("#addsitebutton").css('width', '0px');
		$("#deletefilebutton").css('width', '100px');
		$("#deletesitebutton").css('width', '0px');
		
		$("#file_pane").animate({
			width:'714px',
		},1000);
		$("#web_button_pane").animate({
			left:'488px',
		});
		$("#web_pane").animate({
			left:'1202',
			width:'0px',
		},1000);
		$("#title").text("文件资源");
		$("#filename_pane").animate({
			width:'500px',
		},1000);
		
		$("#file_addbutton_pane").animate({
			width:'100px',
		},1000);
		$("#file_deletebutton_pane").animate({
			width:'100px',
		},1000);
		$("#webname_pane").animate({
			left:'1120',
			width:'0px',
		},1000);
		$("#web_addbutton_pane").animate({
			left:'1010',
			width:'0px',
		},1000);
		$("#web_deletebutton_pane").animate({
			left:'1010',
			width:'0px',
		},1000);
		
		$.ajax({
			url: "ShowFileAction.action",
			success: function(data) {
				var size = data.size;
				$("#titleslist").empty();
				for (var i = 0; i < size; i++) {
					var filename = data.filesName[i];
					$("#titleslist").append("<li><input type='checkbox' value='" + filename + "' name='filesbox' >"+ "<a>" + filename
							+ "</a>" + "</input></li>");
				}
				$("#titleslist li a").click(function() {
					var fileName = $(this).text();
					alert("title = " + fileName);
					window.location.href = "DownloadAction.action?fileName=" + fileName;
					encodeURI(fileName)
					/* $("#changepage_pane").hide(); */
					/* $.ajax({
						url: "DownloadAction.action", 
						data: {"fileName": fileName},
						type: "POST",
						dataType : 'json/xml/html',
						success: function(data) {
							alert("???");
							alert("???");
						}
					}); */ 
					/* document.getElementById("title").value = title;
					document.getElementById("myform").submit(); */
					/* 可以使用form的方式进行提交跳转，也可以使用load方式ajax */
				});
			}
		});
		$("#deletefilebutton").click(function () {
			var str = "";
			$("[name='filesbox']:checked").each(function() {
				str += $(this).val() + ", ";
			});
			if (str == "") {
				$("#hint").text("请选择要删除的文件！");
				$("#hint").show();
			} else {
				$.ajax({
					url: "DeleteFileAction.action", 
					data: {"filenames": str},
					type: "GET",
					success: function(data) {
						window.location.href = "uploadfile_page.action";
					}
				});
			}
		});
		$("#webname_pane").hide();
	});
	$("#web_button_pane").click(function(e) {
		$("#hint").hide();
		$("#webname_pane").css('display','block');
		$("#web_pane").css('z-index',13);
		$("#file_button_pane").css('z-index',13);
		$("#file_pane").css('z-index',11);
		$("#web_button_pane").css('z-index',12);
		$("#filename_pane").css('z-index',12);
		$("#file_addbutton_pane").css('z-index',12);
		$("#file_deletebutton_pane").css('z-index',12);
		$("#webname_pane").css('z-index',15);
		$("#web_addbutton_pane").css('z-index',15);
		$("#web_deletebutton_pane").css('z-index',15);
		$("#web_addbutton_pane").css('display','block');
		$("#web_deletebutton_pane").css('display','block');
		$("#addfilebutton").css('width', ' 0px');
		$("#addsitebutton").css('width', '100px');
		$("#deletefilebutton").css('width', '0px');
		$("#deletesitebutton").css('width', '100px');
		
		$("#file_pane").animate({
			width:'0px',
		},1000);
		
		$("#file_button_pane").animate({
			left:'1132px',
		});
		$("#web_pane").animate({
			left:'488',
			width:'714px',
		},1000);
		$("#title").text("网站资源");
		
		$("#webname_pane").animate({
			left:'610px',
			width:'500px',
		},1000);
		$("#web_addbutton_pane").animate({
			left:'710px',
			width:'100px',
		},1000);
		$("#web_deletebutton_pane").animate({
			left:'910px',
			width:'100px',
		},1000);
		$("#filename_pane").animate({
			left:'610',
			width:'0px',
		},1000);
		$("#file_addbutton_pane").animate({
			left:'710',
			width:'0px',
		},1000);
		$("#file_deletebutton_pane").animate({
			left:'910',
			width:'0px',
		},1000);
		$.ajax({
			url: "ShowSitesAction.action",
			success: function(data) {
				var size = data.size;
			//	alert("size = " + size);
				$("#siteslist").empty();
				for (var i = 0; i < size; i++) {
					var site = data.sites[i].website;
					var name = data.sites[i].site_name;
					/*alert("site = " + site);
					alert("name = " + name);*/
					$("#siteslist").append("<li><a target='_blank' " + "href='http://" + site + "'>" + "<input type='checkbox' value='" + site + "' name='sitesbox' >"+ site + 
							"</input></a>------------>" + name + "</li>");
				}
				/*$("#titleslist li a").click(function() {
					var fileName = $(this).text();
					alert("title = " + fileName);
					window.location.href = "DownloadAction.action?fileName=" + fileName;
					encodeURI(fileName)*/
					/* $("#changepage_pane").hide(); */
					/* $.ajax({
						url: "DownloadAction.action", 
						data: {"fileName": fileName},
						type: "POST",
						dataType : 'json/xml/html',
						success: function(data) {
							alert("???");
							alert("???");
						}
					}); */ 
					/* document.getElementById("title").value = title;
					document.getElementById("myform").submit(); */
					/* 可以使用form的方式进行提交跳转，也可以使用load方式ajax */
				/*});*/
			}
		});
		$("#deletesitebutton").click(function () {
			var str = "";
			$("[name='sitesbox']:checked").each(function() {
				str += $(this).val() + ", ";
			});
			if (str == "") {
				$("#hint").text("请选择要删除的网站！");
				$("#hint").show();
			} else {
				$.ajax({
					url: "DeleteSitesAction.action",
					data: {"sitesStr": str},
					type: "GET",
					success: function(data) {
						alert("Congratulations!!~删除成功");
						window.location.href = "uploadfile_page.action";
					}
				});
			}
		});
	});
	
});

function addFile() {
	alert("????");
	var uploadHTML = document.createElement("input");
	uploadHTML.type = "file";
	uploadHTML.name = "upload";
	var span = document.getElementById("files");
	span.appendChild(uploadHTML);
	uploadHTML = document.createElement("p");
	span.appendChild(uploadHTML);
}

function addSite() {
	var uploadHTML = document.createElement("input");
	var uploadHTML1 = document.createElement("input");
	uploadHTML.type = "text";
	uploadHTML.style = "width: 80px";
	uploadHTML.name = "sites";
	uploadHTML.value = "请输入网站";
	uploadHTML1.type = "text";
	uploadHTML1.name = "names";
	uploadHTML.style = "width: 80px";
	uploadHTML1.value = "请输入网站名称";
	var span = document.getElementById("websites");
	span.appendChild(uploadHTML);
	span.appendChild(uploadHTML1);
	uploadHTML = document.createElement("p");
	span.appendChild(uploadHTML);
	$("[name='sites']").focus(function() {
		var val = $(this).attr("value");
		if (val == "请输入网站") {
			$(this).attr("value", "");
		}
	});
	$("[name='sites']").blur(function() {
		var val = $(this).attr("value");
		if (val == "") {
			$(this).attr("value", "请输入网站");
		}
	});
	$("[name='names']").focus(function() {
		var val = $(this).attr("value");
		if (val == "请输入网站名称") {
			$(this).attr("value", "");
		}
	});
	$("[name='names']").blur(function() {
		var val = $(this).attr("value");
		if (val == "") {
			$(this).attr("value", "请输入网站名称");
		}
	});
}

function validateSites() {
	
}
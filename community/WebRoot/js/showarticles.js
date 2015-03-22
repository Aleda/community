$(document).ready(function() {
		$.ajax({
			url: "ShowArticleAction.action",
			success: function(data) {
				var size = data.size;
				for (var i = 0; i < size; i++) {
					var title = data.articles[i].title;
					var create_time = data.articles[i].create_time;
					$("#titleslist").append("<li><input type='checkbox' name='titlebox' value='"
							+ title + "'>" + "</input><a>" + title + "</a>" + "<span>" + create_time + "</span></li>");
				}
				$("#titleslist li a").click(function() {
					var title = $(this).text();
					alert("title = " + title);
					$("#changepage_pane").hide();
					$("#content_pane").load("DisplayOneArticleAction.action?title=" + title);
					/* $.ajax({
						url: "DisplayOneArticle.action", 
						data: {"title": title},
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
		$("#delete_articles").click(function() {
			var articlesName = "";
			$("[name='titlebox']:checked").each(function() {
				var name = $(this).attr("value");
				articlesName += name + ", ";
			});
			if (articlesName == "") {
				$("#hint").text("请选择要删除的文章！");
				$("#hint").show("slow");
			} else {
				$.ajax({
					url: "DeleteArticlesAction.action",
					data: {"articlesName": articlesName},
					success: function(data) {
							alert("delete success!!~");
							window.location.href = "showarticles_page.action";
						}
				});
			}
		});
	});
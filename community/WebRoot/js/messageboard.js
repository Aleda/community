// JavaScript Document

function showwords() {
	
}

$(document).ready(function(e) {
		$.ajax({
			url: "ShowMessagesAction.action",
			success: function (data) {
				var size = data.size;
				if (size != 0) {
					$("#words_pane dl").empty();
					for (var i = 0; i < size; i++) {
						var send_name = data.messages[i].send_name;
						var message = data.messages[i].message;
						var receive_name = data.messages[i].receive_name;
						var create_time = data.messages[i].create_time;
						$("#words_pane dl").append("<dt>"
								+ "<p><a name='message_" + i + "'>" + "你有新的留言!" +"</a><input id = 'msn_delete' type='button' value='删除' name='message_" + i + "' class='button' /></p><br/>"
								+ "<div id='message_" + i + "'>"
								+ "<p>发送者:<span class='send_name'>" + send_name + "</span><span class='create_time'>"
								+ "时间:" + create_time + "</span></p><br/>"
								+ "<p>留言内容:<span class='message'>" + message + "</span></p><br/>"
				                + "<p style='text-align:right'>"
				                + "</p>" + "</div>"
						+ "</dt>");
					}
					$('#words_pane dl dt p a').click(function(e) {
						var val = $(this).val();
						var text = $(this).text();
						var name = $(this).attr("name");
						
				//		alert("message = " + message);
//						alert("text = " + text);
//						alert("name = " + name);
						$("#" + name).slideToggle("slow");

			        });
					$("#words_pane dl p #msn_delete").click(function() {
						var name = $(this).attr("name");
						alert(name);
						var send_name = $("#" + name + " .send_name").text();
						var message = $("#" + name + " .message").text();
						alert("send_name = " + send_name);
						alert("message = " + message);
						$.ajax({
							url: "UpdateMessageAction.action", 
							data: {"send_name": send_name, "message": message},
							success: function() {
								alert("你已经看了哦！！~");
								window.location.href = "messageboard_page.action";
							}
						});
					});
					return;
				}
			}	
		});
		$('#list_btn').click(function(e) {
			$.ajax({
				url: "ShowUsersAction.action",
				success: function(data) {
					var size = data.size;
					$("#friendscontent_pane dl").empty();
					for (var i = 0; i < size; i++) {
						var username = data.users[i].username;
						var name = data.users[i].name;
						$("#friendscontent_pane dl").append("<dt>" + username + "</dt>");
					}
					$('#friendscontent_pane dl dt').click(function(e) {
						$('#words_content').val("");
						var attr = $(this).text();
			            $('#show_pane').show();
			            $("#submit").click(function() {
			            	var message = "";
			            	message = $("#words_content").val();
			            	if (message == "") {
			            		$("#hint_null").text("请输入要留言的内容！");
			            		$("#hint_null").show();
			            	} else {
			            		$.ajax({
				            		url: "SaveMessageAction.action",
				            		data: {"receive_name": attr, "message": message},
				            		success: function(data) {
				            			alert("Congratulations！！~\r\n发送成功!~");
				            			$("#words_content").empty();
				            			$("#show_pane").hide();
				            		}
				            	});
			            	}
			            });
			        });
					return;
				}
			});
			if($('#friendslist_pane').width()==0) {
				$('#friendslist_pane').css('display','block');
				$('#btn_pane').css('display','block');
				$('#friendscontent_pane').css('display','block');
				$('#friendstitle_pane').css('display','block');
            	$('#friendslist_pane').animate({				
					left:'950px',
					width:'252px'
				});
				$('#btn_pane').animate({				
					left:'900px',
				});
				$('#friendscontent_pane').animate({				
					left:'20px',
					width:'200px'
				});
				$('#friendstitle_pane').animate({
					left:'0px',
					width:'252px'
				});
			} else {
				$('#friendslist_pane').animate({				
					left:'1202px',
					width:'0px'
				});
				
				$('#btn_pane').animate({
					left:'1152px',
				});
				$('#friendscontent_pane').animate({
					left:'252px',
					width:'0px'
				});
				$('#friendstitle_pane').animate({
					left:'252px',
					width:'0px'
				});
			}
        });
		
		$('#close_btn').click(function(e) {
            $('#show_pane').hide();
        });
		$('#words_pane dl dt p a').click(function(e) {
			alert("?");
			var val = $(this).val();
			var text = $(this).text();
			var name = $(this).attr("name");
			$("#"+name).slideToggle("slow");
        });
   });
  
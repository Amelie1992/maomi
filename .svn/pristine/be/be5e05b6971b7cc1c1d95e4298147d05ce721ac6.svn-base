function addImg(fileId) {
		$('#' + fileId).trigger("click");
	}
	
	function changeImg(obj, className,moduleName) {
		 // 上传设置  
		var src = '';
		// 将上传的图片显示
		var reader = new FileReader();
		reader.readAsDataURL($(obj)[0].files[0]);
		reader.onload = function(e) {
			var src = this.result;
		}
		// 修改提交name
		var data = new FormData();
		alert($(obj)[0].files);
			$.each($(obj)[0].files, function(i, dom) {
				data.append('csvfile', dom);
			});
		// 上传
		$.ajax({
					url:'./capital/upload',
					type:"POST",
					data:data,
					dataType:'json',
					cache : false,
					contentType : false, // 不可缺
					processData : false, // 不可缺
					error : function(request) {
						alert("系统异常");
					},
					success : function(data) {
						// 将返回的值存到隐藏域中
						var str = '';
						$(data.uploadFile).each(function(index, dom) {
											str +=  '<img src="'
													+ dom
													+ '"  class="pic"  />'
													+ '<input type="hidden" name="'
													+ className
													+ '" value="'
													+ dom
													+ '">' ;
										});
						$('#WXicon').after(str);
						$('.pic').zoomify();
						
						//存储图片
						var WXImg = new Array('');
						$("input[name='WXImg']").each(function(index, dom) {
							WXImg.push($(dom).val());
						});
						$.ajax({
							type : "POST",
							url : 'capital/keepSubjectPic.htm',
							data : {
								WXImg : WXImg
							},// 你的formid
							dataType : 'json',
							async : false,
							error : function(request) {
								alert("系统异常")
							},
							success : function(data) {
								if (data.message == "保存成功") {
									alert("保存成功!");
								} else {
									alert("保存失败!");
								}
							}
						});
					}
				});
	}
	

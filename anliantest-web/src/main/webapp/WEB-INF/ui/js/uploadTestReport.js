function uploadAndSubmit() {
	if (typeof XMLHttpRequest.prototype.sendAsBinary == 'undefined') {
		XMLHttpRequest.prototype.sendAsBinary = function(datastr) {
			var ui8a = new Uint8Array(datastr.length);
			for (var i = 0; i < datastr.length; i++) {
				ui8a[i] = (datastr.charCodeAt(i) & 0xff);
			}
			this.send(ui8a);
		};
	}

	var form = document.forms["demoForm"];

	if (form["file"].files.length > 0) {
		// 寻找表单域中的 <input type="file" ... /> 标签
		var file = form["file"].files[0];
		// try sending 
		var reader = new FileReader();

		reader.onloadend = function() {
			// 这个事件在读取结束后，无论成功或者失败都会触发
			if (reader.error) {
				console.log(reader.error);
			} else {
				// 构造 XMLHttpRequest 对象，发送文件 Binary 数据
				var xhr = new XMLHttpRequest();
				xhr.open(/* method */"POST",
				/* target url */"createTestReportTableFromDoc?fileName=" + file.name
				/*, async, default to true */);
				xhr.overrideMimeType("application/octet-stream");
				xhr.sendAsBinary(reader.result);
				xhr.onreadystatechange = function() {
					if (xhr.readyState == 4) {
						if (xhr.status == 200) {
							$("#process_btn").show();
							$("#result_btn").show();
						}
					}
				};
			}
		};

		reader.readAsBinaryString(file);
	} else {
		alert("请选择文件");
	}
}

$(function(){
	$("#process_btn").hide();
	$("#result_btn").hide();
	$(document).on("click", "#process_btn", function () {	
		$("#process_btn").prop("disabled", true);
		$("#result_btn").prop("disabled", true);
		$("#upload_btn").prop("disabled", true);
	    $.fileDownload("downloadProcessTable", {
	        preparingMessageHtml: "生成中，请等待...",
            successCallback: function(url) {
        		$("#process_btn").prop("disabled", false);
        		$("#result_btn").prop("disabled", false);
        		$("#upload_btn").prop("disabled", false);
            },
	        failMessageHtml: "生成错误，请重试。",
	        httpMethod: "POST",
	    });
	});
	
	$("#result_btn").click(function(){
		$("#process_btn").prop("disabled", true);
		$("#result_btn").prop("disabled", true);
		$("#upload_btn").prop("disabled", true);
	    $.fileDownload("downloadResultTable", {
	        preparingMessageHtml: "生成中，请等待...",
            successCallback: function(url) {
        		$("#process_btn").prop("disabled", false);
        		$("#result_btn").prop("disabled", false);
        		$("#upload_btn").prop("disabled", false);
            },
	        failMessageHtml: "生成错误，请重试。",
	        httpMethod: "POST",
	    });
	});
});
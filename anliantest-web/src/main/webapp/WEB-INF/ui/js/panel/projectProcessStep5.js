$(function(){
	$("#view_edit_record_file_btn").click(function(){
		var anSelected = fnGetSelected( record_file_list );
        var fileType = $.trim($(anSelected.children().get(1)).text());
		if(fileType == '送样收样记录表'){
			window.location.href = "step5/sendReceiveRecord";
		}else if(fileType == '来样接收登记表'){
			window.location.href = "step5/sampleRegestration";
		}else if(fileType == '检测样品异常情况处理单'){
			window.location.href = "step5/testSampleExceptionHandle";
		}else if(fileType == '备样启用申请单'){
			window.location.href = "step5/sampleEnabledApplication";
		}
		else if(fileType == '原始记录交接单'){
			window.location.href = "step5/originalRecord";
		}
		else if(fileType == '样品处理单'){
			window.location.href = "step5/sampleTreatment";
		}
	});
});
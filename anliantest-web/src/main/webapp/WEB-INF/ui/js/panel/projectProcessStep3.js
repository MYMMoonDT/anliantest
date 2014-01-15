$(function(){
	$("#view_edit_record_file_btn").click(function(){
		var anSelected = fnGetSelected( record_file_list );
        var fileType = $.trim($(anSelected.children().get(1)).text());
		if(fileType == '客户资料登记单'){
			window.location.href = "step3/customerInfoRegister";
		}else if(fileType == '类比企业选择登记'){
			window.location.href = "step3/companySelectionRegister";
		}else if(fileType == '类比企业选择审核登记表'){
			window.location.href = "step3/companySelectionCheckRegister";
		}else if(fileType == '现场调查表'){
			window.location.href = "step3/fieldInvestigation";
		}else if(fileType == '检测通知单'){
			window.location.href = "step3/publicTestNotification";
		}else if(fileType == '采样方案'){
			window.location.href = "step3/publicTestSamplePlanAir";
		}
	});
});
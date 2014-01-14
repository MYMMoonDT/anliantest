$(function(){
	$("#view_edit_record_file_btn").click(function(){
		var anSelected = fnGetSelected( record_file_list );
        var fileType = $.trim($(anSelected.children().get(1)).text());
		if(fileType == '公共场所卫生检测技术服务合同'){
			window.location.href = "step1/..";
		}else if(fileType == '委托书'){
			window.location.href = "step1/entrustAgreement";
		}else if(fileType == '合同评审记录'){
			window.location.href = "step1/contractReviewForm";
		}else if(fileType == '合同更改申请单'){
			window.location.href = "step1/contractModifyApplication";
		}
	});
});
$(function(){
	$("#view_edit_record_file_btn").click(function(){
		var anSelected = fnGetSelected( record_file_list );
        var fileType = $.trim($(anSelected.children().get(1)).text());
        if(fileType == '公共场所卫生检测技术服务合同'){
			window.location.href="step1/techServiceContractPublicPlace";
		}else if (fileType == '工作场所职业病危害因素检测与评价技术服务合同') {
			window.location.href="step1/techServiceContractWorkPlace";
		}else if (fileType == '建设项目职业病危害预评价技术服务合同') {
			window.location.href="step1/techServiceContractConstrProjDiseasePreAssess";
		}else if (fileType == '建设项目职业病危害控制效果评价技术服务合同') {
			window.location.href="step1/techServiceContractConstrProjDiseaseCtrlEffect";
		}else if (fileType == '委托书') {
			window.location.href="step1/entrustAgreement";
		}else if(fileType == '合同评审记录'){
			window.location.href="step1/contractReviewForm";
		}else if(fileType == '合同更改申请单'){
			window.location.href="step1/contractModifyApplication";
		}else if(fileType == '合同更改通知单'){
			window.location.href="step1/contractModifyNotification";
		}
	});
});
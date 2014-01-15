$(function(){
	$("#view_edit_record_file_btn").click(function(){
		var anSelected = fnGetSelected( record_file_list );
        var fileType = $.trim($(anSelected.children().get(1)).text());
		if(fileType == '仪器出入库登记'){
			window.location.href = "step4/equipmentWarehouseRecord";
		}else if(fileType == '仪器使用记录'){
			window.location.href = "step4/fieldEquipmentRecord";
		}else if(fileType == '现场记录表'){
			window.location.href = "step4/publicTestSampleRecordAir";
		}
	});
});
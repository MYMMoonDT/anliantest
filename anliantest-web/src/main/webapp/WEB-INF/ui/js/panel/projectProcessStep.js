var record_file_list;
$(function(){
	record_file_list = $("#record_file_list").dataTable();
	
	$("#record_file_list tbody tr").click(function(e){
		if ( $(this).hasClass('row_selected') ) {
            $(this).removeClass('row_selected');
        }
        else {
        	record_file_list.$('tr.row_selected').removeClass('row_selected');
            $(this).addClass('row_selected');
        }
	});
	
	$("#creat_record_file_btn").click(function(){
		
	});
	
	$("#view_edit_record_file_btn").click(function(){
		
	});
	
	$("#delete_record_file_btn").click(function(){
		var anSelected = fnGetSelected( record_file_list );
        if ( anSelected.length !== 0 ) {
        	record_file_list.fnDeleteRow( anSelected[0] );
        }
	});
});

function fnGetSelected( oTableLocal )
{
    return oTableLocal.$('tr.row_selected');
}

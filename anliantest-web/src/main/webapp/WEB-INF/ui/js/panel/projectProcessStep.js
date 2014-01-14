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
});
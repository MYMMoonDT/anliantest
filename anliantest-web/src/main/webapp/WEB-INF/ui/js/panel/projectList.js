var project_list;
$(function(){
	project_list = $("#project_list").dataTable();
	
	$("#project_list tbody tr").click(function(e){
		if ( $(this).hasClass('row_selected') ) {
            $(this).removeClass('row_selected');
        }
        else {
        	project_list.$('tr.row_selected').removeClass('row_selected');
            $(this).addClass('row_selected');
        }
	});
	
	$("#creat_project_btn").click(function(){
		window.location.href = "project/create";
	});
	
	$("#view_edit_project_btn").click(function(){
		window.location.href = "project/edit";
	});
	
	$("#delete_project_btn").click(function(){
		var anSelected = fnGetSelected( project_list );
        if ( anSelected.length !== 0 ) {
        	project_list.fnDeleteRow( anSelected[0] );
        }
	});
	
	
});

function fnGetSelected( oTableLocal )
{
    return oTableLocal.$('tr.row_selected');
}
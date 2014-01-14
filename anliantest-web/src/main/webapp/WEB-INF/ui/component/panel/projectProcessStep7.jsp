<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${context}/ui/plugin/DataTables/media/css/jquery.dataTables.css">
<link rel="stylesheet" href="${context}/ui/plugin/DataTables/media/css/jquery.dataTables_themeroller.css">
<link rel="stylesheet" href="${context}/ui/css/dataTable.css">
<script src="${context}/ui/plugin/DataTables/media/js/jquery.dataTables.js"></script>
<script src="${context}/ui/js/panel/projectProcessStep.js"></script>
<div class="panel panel-default">
	<div class="panel-heading">项目流程-7。报告书编制</div>
	<div class="panel-body">
		<div class="panel panel-default">
			<div class="panel-heading">流程介绍</div>
			<div class="panel-body">
				项目负责人编制报告书——报告书模板生成<br>
				数据库：法律法规、标准、行业模板、文献<br>
				职业卫生管理台账建立
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">记录文件</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-sm-12">
						<button id="creat_record_file_btn" type="button" class="btn btn-primary">创建</button>
						<button id="view_edit_record_file_btn" type="button" class="btn btn-primary">查看/编辑</button>
						<button id="delete_record_file_btn" type="button" class="btn btn-primary">删除</button>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12">
						<table id="record_file_list">
							<thead>
								<tr>
									<th>
										文件名称
									</th>
									<th>
										文件类型
									</th>
									<th>
										当前状态
									</th>
									<th>
										经办人
									</th>
									<th>
									 	创建时间
									</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${context}/ui/plugin/DataTables/media/css/jquery.dataTables.css">
<link rel="stylesheet" href="${context}/ui/plugin/DataTables/media/css/jquery.dataTables_themeroller.css">
<link rel="stylesheet" href="${context}/ui/css/dataTable.css">
<script src="${context}/ui/plugin/DataTables/media/js/jquery.dataTables.js"></script>
<script src="${context}/ui/js/panel/projectProcessStep.js"></script>
<script src="${context}/ui/js/panel/projectProcessStep4.js"></script>
<div class="panel panel-default">
	<div class="panel-heading">项目流程-4.检测环节</div>
	<div class="panel-body">
		<div class="panel panel-default">
			<div class="panel-heading">流程介绍</div>
			<div class="panel-body">
				4.1检测通知单下达采样部（仪器准备、人员安排）、实验室（样品准备）--仪器出入库登记、仪器使用记录<br>
				4.2现场采样--现场采样作业指导书、现场记录表<br>
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
									<td>
										XX公司仪器出入库登记
									</td>
									<td>
										仪器出入库登记
									</td>
									<td>
										未签字
									</td>
									<td>
										XXX
									</td>
									<td>
										2014.1.15
									</td>
								</tr>
								<tr>
									<td>
										XX公司仪器使用记录
									</td>
									<td>
										仪器使用记录
									</td>
									<td>
										完成
									</td>
									<td>
										XXX
									</td>
									<td>
										2014.1.15
									</td>
								</tr>
								<tr>
									<td>
										XX公司现场记录表
									</td>
									<td>
										现场记录表
									</td>
									<td>
										完成
									</td>
									<td>
										XXX
									</td>
									<td>
										2014.1.15
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
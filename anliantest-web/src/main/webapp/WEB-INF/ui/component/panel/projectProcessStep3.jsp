<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${context}/ui/plugin/DataTables/media/css/jquery.dataTables.css">
<link rel="stylesheet" href="${context}/ui/plugin/DataTables/media/css/jquery.dataTables_themeroller.css">
<link rel="stylesheet" href="${context}/ui/css/dataTable.css">
<script src="${context}/ui/plugin/DataTables/media/js/jquery.dataTables.js"></script>
<script src="${context}/ui/js/panel/projectProcessStep.js"></script>
<script src="${context}/ui/js/panel/projectProcessStep3.js"></script>
<div class="panel panel-default">
	<div class="panel-heading">项目流程-3.项目前期准备</div>
	<div class="panel-body">
		<div class="panel panel-default">
			<div class="panel-heading">流程介绍</div>
			<div class="panel-body">
				项目负责人根据作业指导书启动<br>
				3.1项目资料收集--客户资料登记单、类比企业选择登记表、类比企业选择审核登记表<br>
				3.2现场调查--现场调查表<br>
				3.3评价方案--审核登记表<br>
				3.4检测任务下达--检测通知单、采样方案<br>
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
										XX公司客户资料登记单
									</td>
									<td>
										客户资料登记单
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
										XX公司类比企业选择登记
									</td>
									<td>
										类比企业选择登记
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
										XX公司类比企业选择审核登记表
									</td>
									<td>
										类比企业选择审核登记表
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
										XX公司现场调查表
									</td>
									<td>
										现场调查表
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
										XX公司检测通知单
									</td>
									<td>
										检测通知单
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
										XX公司采样方案
									</td>
									<td>
										采样方案
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
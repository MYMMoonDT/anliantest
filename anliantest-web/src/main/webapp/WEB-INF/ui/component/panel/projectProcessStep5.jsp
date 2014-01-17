<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${context}/ui/plugin/DataTables/media/css/jquery.dataTables.css">
<link rel="stylesheet" href="${context}/ui/plugin/DataTables/media/css/jquery.dataTables_themeroller.css">
<link rel="stylesheet" href="${context}/ui/css/dataTable.css">
<script src="${context}/ui/plugin/DataTables/media/js/jquery.dataTables.js"></script>
<script src="${context}/ui/js/panel/projectProcessStep.js"></script>
<script src="${context}/ui/js/panel/projectProcessStep5.js"></script>
<div class="panel panel-default">
	<div class="panel-heading">项目流程-5.实验环节</div>
	<div class="panel-body">
		<div class="panel panel-default">
			<div class="panel-heading">流程介绍</div>
			<div class="panel-body">
				实验室出具数据报告：样品交换、样品分发、（气象、原吸、分光、粉尘、物理因素）、实验数据输出、数据报告生成。
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
										XX公司来样接收登记表
									</td>
									<td>
										来样接收登记表
									</td>
									<td>
										未签字
									</td>
									<td>
										XXX
									</td>
									<td>
										2014.1.4
									</td>
								</tr>
								<tr>
									<td>
										XX公司送样收样记录表
									</td>
									<td>
										送样收样记录表
									</td>
									<td>
										完成
									</td>
									<td>
										XXX
									</td>
									<td>
										2014.1.4
									</td>
								</tr>
								<tr>
									<td>
										XX公司检测样品异常情况处理单
									</td>
									<td>
										检测样品异常情况处理单
									</td>
									<td>
										完成
									</td>
									<td>
										XXX
									</td>
									<td>
										2014.1.4
									</td>
								</tr>
								<tr>
									<td>
										XX公司样品处理单
									</td>
									<td>
										样品处理单
									</td>
									<td>
										完成
									</td>
									<td>
										XXX
									</td>
									<td>
										2014.1.4
									</td>
								</tr>
								<tr>
									<td>
										XX公司备样启用申请单
									</td>
									<td>
										备样启用申请单
									</td>
									<td>
										完成
									</td>
									<td>
										XXX
									</td>
									<td>
										2014.1.4
									</td>
								</tr>
								<tr>
									<td>
										XX公司原始记录交接单
									</td>
									<td>
										原始记录交接单
									</td>
									<td>
										完成
									</td>
									<td>
										XXX
									</td>
									<td>
										2014.1.4
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
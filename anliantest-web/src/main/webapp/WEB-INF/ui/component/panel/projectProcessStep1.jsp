<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${context}/ui/plugin/DataTables/media/css/jquery.dataTables.css">
<link rel="stylesheet" href="${context}/ui/plugin/DataTables/media/css/jquery.dataTables_themeroller.css">
<link rel="stylesheet" href="${context}/ui/css/dataTable.css">
<script src="${context}/ui/plugin/DataTables/media/js/jquery.dataTables.js"></script>
<script src="${context}/ui/js/panel/projectProcessStep.js"></script>
<script src="${context}/ui/js/panel/projectProcessStep1.js"></script>
<div class="panel panel-default">
	<div class="panel-heading">项目流程-1.项目录入</div>
	<div class="panel-body">
		<div class="panel panel-default">
			<div class="panel-heading">流程介绍</div>
			<div class="panel-body">
				质控部信息录入参数：名称、类型、联系人信息、地址、合同额、业务负责人、项目负责人
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
										XX公司委托书
									</td>
									<td>
										委托书
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
										XX公司公共场所卫生检测技术服务合同
									</td>
									<td>
										公共场所卫生检测技术服务合同
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
										XX公司工作场所职业病危害因素检测与评价技术服务合同
									</td>
									<td>
										工作场所职业病危害因素检测与评价技术服务合同
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
										XX公司建设项目职业病危害预评价技术服务合同
									</td>
									<td>
										建设项目职业病危害预评价技术服务合同
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
										XX公司建设项目职业病危害控制效果评价技术服务合同
									</td>
									<td>
										建设项目职业病危害控制效果评价技术服务合同
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
										XX公司合同评审记录
									</td>
									<td>
										合同评审记录
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
										XX公司合同更改申请单
									</td>
									<td>
										合同更改申请单
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
										XX公司合同更改通知单
									</td>
									<td>
										合同更改通知单
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
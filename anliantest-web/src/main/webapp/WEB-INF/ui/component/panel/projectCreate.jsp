<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="panel panel-default">
	<div class="panel-heading">创建项目</div>
	<div class="panel-body">
		<form class="form-horizontal" role="form">
			<div class="row">
				<div class="col-sm-8">
					<div class="form-group">
					    <label for="projectName" class="col-sm-3 control-label">项目名称</label>
					    <div class="col-sm-9">
					    	<input type="text" class="form-control" id="projectName">
					    </div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-8">
					<div class="form-group">
					    <label for="projectType" class="col-sm-3 control-label">项目类型</label>
					    <div class="col-sm-9">
					    	<select class="form-control" id="projectType">
					    		<option>公共场所卫生检测</option>
					    		<option>建设项目职业病危害预评价</option>
					    		<option>建设项目职业病危害控制效果评价</option>
					    		<option>工作场所职业病危害因素检测与评价</option>
					    	</select>
					    </div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-8">
					<div class="form-group">
					    <label for="contactPersonInfo" class="col-sm-3 control-label">联系人信息</label>
					    <div class="col-sm-9">
					    	<textarea id="contactPersonInfo" class="form-control" rows="6"></textarea>
					    </div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-8">
					<div class="form-group">
					    <label for="contractAmount" class="col-sm-3 control-label">合同额</label>
					    <div class="col-sm-9">
					    	<input type="number" id="contractAmount" class="form-control">
					    </div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
					    <label for="businessLeader" class="col-sm-4 control-label">业务负责人</label>
					    <div class="col-sm-8">
					    	<select class="form-control" id="businessLeader">
					    		<option>XXX</option>
					    		<option>XXX</option>
					    		<option>XXX</option>
					    		<option>XXX</option>
					    	</select>
					    </div>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="form-group">
					    <label for="projectLeader" class="col-sm-4 control-label">项目负责人</label>
					    <div class="col-sm-8">
					    	<select class="form-control" id="projectLeader">
					    		<option>XXX</option>
					    		<option>XXX</option>
					    		<option>XXX</option>
					    		<option>XXX</option>
					    	</select>
					    </div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<div class="pull-right">
						<button type="button" class="btn btn-primary">创建</button>
						<button type="button" class="btn btn-default">取消</button>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>
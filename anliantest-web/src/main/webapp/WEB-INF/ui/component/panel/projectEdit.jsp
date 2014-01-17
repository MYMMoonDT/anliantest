<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${context}/ui/plugin/Buttons/css/buttons.css">    
<link rel="stylesheet" href="${context}/ui/css/panel/projectEdit.css">
<script src="${context}/ui/plugin/Buttons/js/buttons.js"></script>
<script src="${context}/ui/js/panel/projectEdit.js"></script>
<div class="panel panel-default">
	<div class="panel-heading">查看/编辑项目</div>
	<div class="panel-body">
		<div class="row">
			<div class="col-sm-12">
				<ul id="project-tab" class="nav-project nav nav-tabs">
				  	<li class="active"><a href="#projectProcess" data-toggle="tab">项目流程</a></li>
				  	<li><a href="#projectInfo" data-toggle="tab">项目信息</a></li>
				</ul>
				
				<div id="project-content" class="tab-content">
				  	<div class="tab-pane active" id="projectProcess">
				  		<div class="row">
				  			<div class="col-sm-2">
				  				<a href="${context}/project/process/step1" class="button button-circle button-3d-action">1.项目录入</a>
				  			</div>
				  			<div class="col-sm-1">
				  				<a href="#" class="button button-3d-action button-pill"></a>
				  			</div>
				  			<div class="col-sm-2">
				  				<a href="#" class="button button-circle button-3d-action">2.项目下达</a>
				  			</div>
				  			<div class="col-sm-1">
				  				<a href="#" class="button button-3d-action button-pill"></a>
				  			</div>
				  			<div class="col-sm-2">
				  				<a href="${context}/project/process/step3" class="button button-circle button-3d-action">3.项目前期准备</a>
				  			</div>
				  			<div class="col-sm-1">
				  				<a href="#" class="button button-3d-action button-pill"></a>
				  			</div>
				  			<div class="col-sm-3">
				  				<a href="${context}/project/process/step4" class="button button-circle button-3d-action">4.检测环节</a>
				  			</div>
				  		</div>
				  		<div class="row">
				  			<div class="col-sm-1">
				  				<a href="#" class="button button-3d-primary button-pill"></a>
				  			</div>
				  			<div class="col-sm-2">
				  				<a href="${context}/project/process/step5" class="button button-circle button-3d-action">5.实验环节</a>
				  			</div>
				  			<div class="col-sm-1">
				  				<a href="#" class="button button-3d button-pill"></a>
				  			</div>
				  			<div class="col-sm-2">
				  				<a href="#" class="button button-3d button-circle">6.数据处理</a>
				  			</div>
				  			<div class="col-sm-1">
				  				<a href="#" class="button button-3d button-pill"></a>
				  			</div>
				  			<div class="col-sm-2">
				  				<a href="${context}/project/process/step7" class="button button-3d button-circle">7.报告书编制</a>
				  			</div>
				  			<div class="col-sm-1">
				  				<a href="#" class="button button-3d button-pill"></a>
				  			</div>
				  		</div>
				  		<div class="row">
				  			<div class="col-sm-2">
				  				<a href="${context}/project/process/step8" class="button button-3d button-circle">8.报告书初审</a>
				  			</div>
				  			<div class="col-sm-1">
				  				<a href="#" class="button button-3d button-pill"></a>
				  			</div>
				  			<div class="col-sm-2">
				  				<a href="#" class="button button-circle button-3d">9.报告书评审</a>
				  			</div>
				  			<div class="col-sm-1">
				  				<a href="#" class="button button-3d button-pill"></a>
				  			</div>
				  			<div class="col-sm-2">
				  				<a href="#" class="button button-circle button-3d">10.报告书发放</a>
				  			</div>
				  			<div class="col-sm-1">
				  				<a href="#" class="button button-3d button-pill"></a>
				  			</div>
				  			<div class="col-sm-2">
				  				<a href="#" class="button button-circle button-3d">11.项目验收</a>
				  			</div>
				  		</div>
				  	</div>
				  	<div class="tab-pane" id="projectInfo">
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
										<button type="button" class="btn btn-primary">保存</button>
									</div>
								</div>
							</div>
						</form>
				  	</div>
				</div>
			</div>
		</div>
	</div>
</div>
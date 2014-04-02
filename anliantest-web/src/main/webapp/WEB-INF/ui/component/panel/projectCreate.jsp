<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<div class="panel panel-default">
	<div class="panel-heading">创建项目</div>
	<div class="panel-body">
		<form class="form-horizontal" role="form"
			action="${context}/project/createProject" method="post">

			<div class="row">
				<div class="col-sm-8">
					<div class="form-group">
						<label for="projectNum" class="col-sm-3 control-label">项目编号</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="projectNum"
								name="projectNum">
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-8">
					<div class="form-group">
						<label for="projectName" class="col-sm-3 control-label">项目名称</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="projectName"
								name="projectName">
						</div>
					</div>
				</div>
			</div>


			<div class="row">
				<div class="col-sm-8">
					<div class="form-group">
						<label for="projectType" class="col-sm-3 control-label">项目类型</label>
						<div class="col-sm-9">
							<select class="form-control" id="projectType" name="projectType">
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
						<label for="companyName" class="col-sm-3 control-label">企业名称</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="companyName"
								name="companyName">
						</div>
					</div>
				</div>
				<div class="col-sm-8">
					<div class="form-group">
						<label for="companyAddress" class="col-sm-3 control-label">企业地址</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="companyAddress"
								name="companyAddress">
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label for="contactPerson" class="col-sm-4 control-label">联系人</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="contactPerson"
								name="contactPerson">
						</div>
					</div>
				</div>


				<div class="col-sm-6">
					<div class="form-group">
						<label for="contactTel" class="col-sm-4 control-label">联系电话</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="contactTel"
								name="contactTel">
						</div>
					</div>
				</div>
			</div>


			<div class="row">
				<div class="col-sm-8">
					<div class="form-group">
						<label for="contractAmount" class="col-sm-3 control-label">合同额</label>
						<div class="col-sm-9">
							<input type="number" id="contractAmount" name="contractAmount"
								class="form-control">
						</div>
					</div>
				</div>
			</div>


			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label for="businessLeader" class="col-sm-4 control-label">业务负责人</label>
						<div class="col-sm-8">
							<select class="form-control" id="businessLeader" name="businessEmployee">
								<c:forEach items="${employeeList}" var="ename">
									<option>${ename}</option>
								</c:forEach>
							</select>

						</div>
					</div>
				</div>


				<div class="col-sm-6">
					<div class="form-group">
						<label for="projectLeader" class="col-sm-4 control-label">项目负责人</label>
						<div class="col-sm-8">
							<select class="form-control" id="projectLeader"
								name="projectEmployee">
								<c:forEach items="${employeeList}" var="ename">
									<option>${ename}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
			</div>


			<div class="row">
				<div class="col-sm-12">
					<div class="pull-right">
						<button type="submit" class="btn btn-primary">创建</button>
						<button type="reset" class="btn btn-default">重置</button>
					</div>
				</div>
			</div>


		</form>
	</div>
</div>
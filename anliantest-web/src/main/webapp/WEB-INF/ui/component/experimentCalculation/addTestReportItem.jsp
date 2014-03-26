<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
    String context = request.getContextPath();
    request.setAttribute("context",context);
%>
<link rel="stylesheet" href="${context}/ui/css/form.css">
<link rel="stylesheet" href="${context}/ui/css/custom-theme/jquery-ui-1.9.2.custom.css">

<script src="${context}/ui/js/jquery-ui-bootstrap/jquery-ui-1.9.2.custom.min.js"></script>
<script src="${context}/ui/js/jquery/jquery.fileDownload.js"></script>
<script src="${context}/ui/js/jquery/jquery.tmpl.min.js"></script>
<script src="${context}/ui/js/experimentCalculation.js"></script>

<div class="panel panel-primary">
	<div class="panel-heading">检测结果输入</div>
	<div class="panel-body">
		<form id="formid" action="${context}/addTestReportItemAndCalc" role="form" method="POST">
			<div class="formContainer">
				<div class="row">
					<div class="col-sm-12 form-group">
						<label>车间/岗位</label> <input name="testWorkshopJob" id="position" type="text" class="form-control" required>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6 form-group">
						<label>危害因素</label>
						<select name="testSubstanceId" id="substance" class="form-control">
						</select>
					</div>
					<div class="col-sm-6 form-group" id="detail" >
						<label>具体信息</label> <input name="testSubstanceDetailedName" type="text" class="form-control">
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12">
						<button type="button" class="btn btn-primary btn-add-date" style="margin-bottom: 10px;">添加日期</button>
					</div>
				</div>
				<div class="dayData">
					<div class="row">
						<div class="col-sm-6 form-group">
							<label>日期</label> <input name="testTime" type="date" class="date form-control" required>
						</div>
						<div class="col-sm-6">
							<button type="button" class="btn btn-primary btn-add-sample" style="margin-top: 25px;">添加样品</button>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-3 form-group">
							<label>样品编号</label>
						</div>
						<div class="col-sm-3 form-group">
							<label>检测结果</label>
						</div>
						<div class="col-sm-3 form-group">
							<label>接触时间</label>
						</div>
						<div class="col-sm-3 form-group">
							<label>采集时间</label>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-3 form-group">
							<input name="testSampleNum[0]" type="text" class="data form-control" required>
						</div>
						<div class="col-sm-3 form-group">
							<input name="testResult[0]" type="text" class="data form-control" required>
						</div>
						<div class="col-sm-3 form-group">
							<input name="testTouchTime[0]" type="text" class="time form-control" required>
						</div>
						<div class="col-sm-3 form-group">
							<input name="testCollectTime[0]" value="15" type="text" class="time form-control" required>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<button type="submit" class="btn btn-primary">继续</button>
				</div>
			</div>
		</form>
		<div class="row">
			<div class="col-sm-12" style="margin-top: 10px;margin-bottom: 10px;">
				<button id="process_btn" type="button" class="btn btn-primary">生成并下载计算结果表</button>
				<button id="result_btn" type="button" class="btn btn-primary">生成并下载结果与评价表</button>
			</div>
		</div>
	</div>

	<div id="preparing-file-modal" title="Preparing report..."
		style="display: none;">
		We are preparing your report, please wait...
	</div>

	<div id="error-modal" title="Error" style="display: none;">There
		was a problem generating your report, please try again.</div>

<script id="addTestDateItem" type="text/x-jquery-tmpl">
<div class="dayData">
	<div class="row">
		<div class="col-sm-6 form-group">
			<label>日期</label> <input name="testTime" type="date" class="date form-control" required>
		</div>
		<div class="col-sm-6">
			<button type="button" class="btn btn-primary btn-add-sample" style="margin-top: 25px;">添加样品</button>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-3 form-group">
			<label>样品编号</label>
		</div>
		<div class="col-sm-3 form-group">
			<label>检测结果</label>
		</div>
		<div class="col-sm-3 form-group">
			<label>接触时间</label>
		</div>
		<div class="col-sm-3 form-group">
			<label>采集时间</label>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-3 form-group">
			<input name="{{html testSampleNum}}" type="text" class="data form-control" required>
		</div>
		<div class="col-sm-3 form-group">
			<input name="{{html testResult}}" type="text" class="data form-control" required>
		</div>
		<div class="col-sm-3 form-group">
			<input name="{{html testTouchTime}}" type="text" class="time form-control" required>
		</div>
		<div class="col-sm-3 form-group">
			<input name="{{html testCollectTime}}" value="15" type="text" class="time form-control" required>
		</div>
	</div>
</div>
</script>

<script id="addTestSampleItem" type="text/x-jquery-tmpl">
<div class="row">
	<div class="col-sm-3 form-group">
		<input name="{{html testSampleNum}}" type="text" class="data form-control" required>
	</div>
	<div class="col-sm-3 form-group">
		<input name="{{html testResult}}" type="text" class="data form-control" required>
	</div>
	<div class="col-sm-3 form-group">
		<input name="{{html testTouchTime}}" type="text" class="time form-control" required>
	</div>
	<div class="col-sm-3 form-group">
		<input name="{{html testCollectTime}}" value="15" type="text" class="time form-control" required>
	</div>
</div>		
</script>
</div>

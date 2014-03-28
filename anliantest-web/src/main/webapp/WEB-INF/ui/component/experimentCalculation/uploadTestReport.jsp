<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String context = request.getContextPath();
	request.setAttribute("context", context);
%>
<link rel="stylesheet" href="${context}/ui/css/form.css">
<link rel="stylesheet" href="${context}/ui/css/custom-theme/jquery-ui-1.9.2.custom.css">

<script src="${context}/ui/js/jquery/jquery.fileDownload.js"></script>
<script src="${context}/ui/js/jquery-ui-bootstrap/jquery-ui-1.9.2.custom.min.js"></script>
<script src="${context}/ui/js/uploadTestReport.js"></script>

<div class="panel panel-default">
	<div class="panel-heading">上传检测报告</div>
	<div class="panel-body">
		<form name="demoForm" id="uploadForm" method="post"
			enctype="multipart/form-data" action="javascript: uploadAndSubmit();">
			<div class="form-group">
<!-- 				<label>File input</label> -->
				<input type="file" name="file" />
			</div>
			<p>
				<input id="upload_btn" type="submit" class="btn btn-default" value="上传"/>
			</p>
		</form>
<!-- 		<div> -->
<!-- 			Progessing (in Bytes): <span id="bytesRead"> </span> / <span -->
<!-- 				id="bytesTotal"></span> -->
<!-- 		</div> -->
		<button id="process_btn" type="button" class="btn btn-primary">生成并下载计算结果表</button>
		<button id="result_btn" type="button" class="btn btn-primary">生成并下载结果与评价表</button>
	</div>
</div>
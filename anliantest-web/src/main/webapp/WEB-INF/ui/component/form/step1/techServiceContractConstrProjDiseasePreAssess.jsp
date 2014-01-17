<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
    String context = request.getContextPath();
    request.setAttribute("context",context);
%>
<link rel="stylesheet" href="${context}/ui/css/form.css">
<!-- 
文件名：                  techServiceContractConstrProjDiseasePreAssess.jsp
本表单对应文件：建设项目职业病危害预评价技术服务合同
表码：                       ALJC/JL07-02-03
 -->

<div class="panel panel-default">
	<div class="panel-heading">建设项目职业病危害预评价技术服务合同</div>
	<div class="panel-body">
		<form>
			<div class="row">
				<div class="col-sm-12 form-group">
					<label>委托方（甲方）</label> <input type="text" class="form-control">
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm-12 form-group">
					<label>联系人</label> <input type="text" class="form-control">
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm-12 form-group">
					<label>联系电话</label> <input type="text" class="form-control">
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm-12 form-group">
					<label>受托方（乙方）</label> <input type="text" value="杭州安联卫生检测技术服务有限公司" class="form-control">
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm-12 form-group">
					<label>联系人</label> <input type="text" class="form-control">
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm-12 form-group">
					<label>联系电话</label> <input type="text" class="form-control">
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm-12 form-group">
					<label>签约地点</label> <input type="text" class="form-control">
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm-12 form-group">
					<label>签约时间</label> <input type="date" class="form-control">
				</div>
			</div>
		</form>
	</div>
</div>
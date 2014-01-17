<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
    String context = request.getContextPath();
    request.setAttribute("context",context);
%>
<link rel="stylesheet" href="${context}/ui/css/form.css">
<!-- 
文件名：                  techServiceContractCover.jsp
说明：                      技术服务合同封面
表码：                       无
 -->

<div class="panel panel-default">
	<div class="panel-heading">技术服务合同封面</div>
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
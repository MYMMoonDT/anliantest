<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
    String context = request.getContextPath();
    request.setAttribute("context",context);
%>
<link rel="stylesheet" href="${context}/ui/css/form.css">
<!-- 
本表单对应文件： 杭州安联卫生检测技术服务有限公司 委托协议书
表码：                       ALJC/JL07-01
 -->

<div class="panel panel-default">
	<div class="panel-heading">委托协议书</div>
	<div class="panel-body">
		<form>
			<div class="row">
				<div class="col-sm-6 form-group">
					<label>受检单位</label> <input type="text" class="form-control">
				</div>
				<div class="col-sm-6 form-group">
					<label>检测类别</label> <input type="text" class="form-control">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6 form-group">
					<label>委托单位</label> <input type="text" class="form-control">
				</div>
				<div class="col-sm-2 form-group">
					<label>联系人</label> <input type="text" class="form-control">
				</div>
				<div class="col-sm-4 form-group">
					<label>电话</label> <input type="text" class="form-control">
				</div>
			</div>

			<div class="row">
				<div class="col-sm-6 form-group">
					<label>检测地址</label> <input type="text" class="form-control">
				</div>
				<div class="col-sm-3 form-group">
					<label>传真</label> <input type="text" class="form-control">
				</div>
				<div class="col-sm-3 form-group">
					<label>邮编</label> <input type="text" class="form-control">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12 form-group">
					<label>检测项目（详见附表）</label>
					<textarea rows="3" class="form-control"></textarea>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6 form-group">
					<label class="control-label">样品来源</label>
					<div class="controls">
						<label class="radio-inline">甲方送样 <input type="radio"
							name="sampleRadios">
						</label> 
						<label class="radio-inline">乙方采样 <input type="radio"
							name="sampleRadios">
						</label>
					</div>
				</div>

				<div class="col-sm-6 form-group">
					<label class="control-label">储存条件</label>
					<div class="controls">
						<label class="radio-inline">常温<input type="radio"
							name="storeRadios">
						</label> <label class="radio-inline">避光<input type="radio"
							name="storeRadios">
						</label> <label class="radio-inline">低温<input type="radio"
							name="storeRadios">
						</label>
						<input type="text" >℃
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm-6 form-group">
					<label>委托方提供资料</label>
					<textarea rows="1" class="form-control"></textarea>
				</div>
				<div class="col-sm-6 form-group">
					<label class="control-label">保密要求</label>
					<div class="controls" >
						<label class="radio-inline">要求保密
						<input type="radio" name="confidenceRadios"></label>
						<label class="radio-inline">无要求保密
						<input type="radio" name="confidenceRadios"></label>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm-6 form-group">
					<label class="control-label">报告交付方式</label>
					<div class="controls">
						
						<label class="radio-inline">领取<input type="radio"
							name="mailRadios">
						</label> <label class="radio-inline">挂号邮寄<input type="radio"
							name="mailRadios">
						</label> 
			
						<label class="radio-inline">特快专递<input type="radio"
							name="mailRadios">
						</label>
						<label class="radio-inline">电子邮件<input type="radio"
							name="mailRadios">
						</label>
					</div>
				</div>
				
				<div class="col-sm-6 form-group">
					<label class="control-label">要求提交报告数量</label>
					<div class="controls">
						<div >
						<label class="radio-inline">中文<input type="radio"
							name="reportLangRadios">
						</label> <label class="radio-inline">英文<input type="radio"
							name="reportLangRadios">
						</label> 
						</div>
						
						
						<div >
						<span style="font-weight:bold">正本</span><input type="text"><span style="font-weight:bold">份</span>
						<span style="font-weight:bold">副本</span><input type="text"><span style="font-weight:bold">份</span>
						</div>
						
					
					</div>
				</div>
			</div>
			
			
			<div class="row">
				<div class="col-sm-6 form-group">
					<label>报告交付日期</label>
					<input type="date" class="form-control"></input>
				</div>
				<div class="col-sm-6 form-group">
					<label class="control-label">报告形式</label>
					<div class="controls" >
						<label class="radio-inline">检测报告
						<input type="radio" name="reportTypeRadios"></label>
						<label class="radio-inline">图谱
						<input type="radio" name="reportTypeRadios"></label>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm-12 form-group">
					<label class="control-label">样品处置</label>
					<div class="controls" >
						<label class="radio-inline">委托方领取
						<input type="radio" name="sampleHandleRadios"></label>
						<label class="radio-inline">由公司封存
						<input type="radio" name="sampleHandleRadios"></label>
						<label class="radio-inline">由公司处理
						<input type="radio" name="sampleHandleRadios"></label>
					</div>
				</div>
			</div>
			
			<div class="row" >
				<div class="well">
					<ol >
					<li ><h5>本协议经双方代表签字生效后，未经双方同意不得单方面更改，若一方需要更改，需经双方协商一致并做出书面说明，作为本协议的补充件。</h5></li>
					<li ><h5>我方保证对所提供的一切资料、信息和实物的真实性负责，并提供必要合作。如果样品不足时，可不保留备存样品，所需检测费用及邮寄费由我方支付。</h5></li>
					</ol>
					<div>
					<label class="checkbox-inline pull-right"><strong>确认</strong><input type="checkbox"
							name="affirmCheckbox">
						</label> 
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm-12 form-group">
					<label class="control-label">付款方式</label>
					<div class="controls" >
						<label class="radio-inline">银行转账
						<input type="radio" name="paymentTypeRadios"></label>
						<label class="radio-inline">现金
						<input type="radio" name="paymentTypeRadios"></label>
						<label class="radio-inline">定期结算
						<input type="radio" name="paymentTypeRadios"></label>
					</div>
				</div>
			</div>
			
			
			
			<div class="row">
				<div class="col-sm-12 form-group">
					<table class="table table-bordered" style="TABLE-LAYOUT: fixed">
					<caption>附表：检测项目表</caption>
						<thead>
							<tr>
								<th>序号</th>
								<th>样品名称</th>
								<th>样品数量</th>
								<th>检测项目</th>
								<th>检测依据</th>
								
							</tr>
						</thead>
						<tbody>
							<tr contenteditable="true">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								
							</tr>
							<tr contenteditable="true">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								
							</tr>
							<tr contenteditable="true">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								
							</tr>
							<tr contenteditable="true">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								
							</tr>
							<tr contenteditable="true">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								
							</tr>
							<tr contenteditable="true">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								
							</tr>
							<tr contenteditable="true">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								
							</tr>
							<tr contenteditable="true">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								
							</tr>
							<tr contenteditable="true">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			
			
		</form>
	</div>
</div>
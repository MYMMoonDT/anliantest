//function Result(mac, twa, stel, limit) {
//	this.mac = mac;
//	this.twa = twa;
//	this.stel = stel;
//	this.limit = limit;
//};
//
//function DayData(date, data, time, result, std) {
//	this.date = date;
//	this.data = data;
//	this.time = time;
//	this.result = result;
//	this.std = std;
//	this.passed = true;
//}
//
//function CalcData(position, item, no, dayData) {
//	this.position = position;
//	this.item = no;
//	this.dayData = dayData;
//};
//
//
//var testData = [];

//$(function(){
//	$("#next_btn").click(function(){
//		$.post("addTestReportItem", {itemId: "1"}, function(){
//			alert("done");
//		});
//		//getDataFromInput();
//		//clearInput();
//	});
//});
//
//$(function(){
//	$("#finish_btn").click(function(){
//		calc();
//		clearInput();
//	});
//});

//function clearInput() {
//	$("#position").val("");
//	$("#item").val("");
//	$("#no").val("");
//	$(".date").val("");
//	$(".data").val("");
//	$(".time").val("");
//};

//function getDataFromInput() {
//	var position = $("#position").val();
//	var item = $("#item").val();
//	var no = $("#no").val();
//	var dayData = [];
//	$(".dayData").each(function(){
//		var date = $(this).find(".date").val();
//		var data = [];
//		$(this).find(".data").each(function(){
//			data.push($(this).val());
//		});
//		var time = [];
//		$(this).find(".time").each(function(){
//			time.push($(this).val());
//		});
//		dayData.push(new DayData(date, data, time, null, null));
//	});
//	testData.push(new CalcData(position, item, no, dayData));
//};
//
//function calc(){
//	testData.forEach(function(calcData){
//		var dayData = calcData.dayData;
//		dayData.forEach(function(entry){
//			// getDataFromDatabase
//			var std = new Result();
//			
//			var result = new Result(-1, 0, -1, -1);
//			//result.mac = ?;
//			for (var i = 0; i < entry.data.length; i++) {
//				result.twa += entry.data[i]*entry.time[i];
//				if (entry.data[i] > result.stel) {
//					result.stel = entry.data[i];
//				}
//			}
//			result.twa /= 8;
//			if (std.twa) {
//				result.limit = result.stel/std.twa;
//			}
//			var passed = true;
//			if (std.mac && result.mac > std.mac) {
//				passed = false;
//			};
//			if (std.twa && result.twa > std.twa) {
//				passed = false;
//			};
//			if (std.stel && result.stel > std.stel) {
//				passed = false;
//			};
//			if (std.limit && result.limit > std.limit) {
//				passed = false;
//			};
//			
//			entry.result = result;
//			entry.std = std;
//			entry.passed = passed;
//		});	
//	});
//};
var ParticlesNotOtherwiseRegulatedId = 461;
var PercentIdList = [439, 440, 441, 442, 443, 444];
function setDetailVisibility() {
	$("#detail").find("input").val("");
	var id = $("#substance").val();
	if (id == ParticlesNotOtherwiseRegulatedId) {
		$("#detail").show();
	} else if (inList(id, PercentIdList)){
		$("#detail").show();
	} else {
		$("#detail").hide();
	}
}

function inList(target, list) {
	var isIn = false;
	for (var i = 0; i < list.length; i++) {
		if (target == list[i]) {
			isIn = true;
		}
	}
	return isIn;
}
$(function loadSelector() {
	$("#substance").bind("change", setDetailVisibility);
	$.post("loadSubstanceList", function(list) {
		var selector = $("#substance");
		list.forEach(function(substance){
			selector.append("<option value='"+ substance.id +"'>"+ substance.name +"</option>");
		});
		setDetailVisibility();
	});
});
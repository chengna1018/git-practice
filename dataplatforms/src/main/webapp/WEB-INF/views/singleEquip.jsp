<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<link rel="stylesheet" href="./resources/css/jquerypage.css">
<link rel="stylesheet" type="text/css" href="./resources/css/equipParame.css" />
<script src="./resources/js/jquery.js"></script>
<script type="text/javascript" src="./resources/js/jquerypage.js"></script>
<script type="text/javascript" src="./resources/js/echarts.min.js"></script>
<script type="text/javascript" src="./resources/js/echartshow.js"></script>
<script type="text/javascript" src="./resources/js/echarts.js"></script>

<title>设备运行状态</title>
</head>
<body>
	<div id="single_equip"></div>            
	
	<script text="text/javascript">
	var singleEquipsStr = '${singleEquipList}';//可以访问模型中的数据
	var singleEquipList = $.parseJSON(singleEquipsStr);
	var content = "";
	for(var i = 0;i<singleEquipList.length;i++){
		var kn=singleEquipList[i].kn;
		var name=singleEquipList[i].ename;
		var max_mohou=singleEquipList[i].max_mohou;
		var min_mohou=singleEquipList[i].min_mohou;
		var ejection_stroke=singleEquipList[i].ejection_stroke;
		var ejection_pressure=singleEquipList[i].ejection_pressure;
		var picture=singleEquipList[i].picture;
		
		
		content = content + "<div class='equip_picture'><img src='./resources/image/"+picture+".png'></div>"
		+"<div id='equip_parameter' class='style3'>"
		+"<p id='table1'>"+name+"</p>"
		
		+"<table><tr id='table'><td>锁模力</td><td>"+kn+"</td></tr>"
		+"<tr id='table'><td>最大模厚</td><td>"+max_mohou+"</td></tr>"
		+"<tr id='table'><td>最小模厚</td><td>"+min_mohou+"</td></tr>"
		+"<tr id='table'><td>注射容量</td><td>"+ejection_stroke+"</td></tr>"
		+"<tr id='table'><td>注射压力</td><td>"+ejection_pressure+"</td></tr></table></div>"
		+"<div class='style4'><hr/></div>"; 
		
		
		
		
		
	}
	$('#single_equip').html(content);
	</script>
	<!-- echart柱状图 -->
    <div id="echart_histogram" style="width:500px;height:350px; position:absolute; left:400px; top:10px" >
    	<script type="text/livescript">
			show_echartHistogram();
		</script>
    </div>
    
    <!--仪表盘-->
    <div id="echart_yibiao" style="width:500px;height:350px; position:absolute; left:950px; top:0px" >
    	<script type="text/javascript">
			show_yibiao();
		</script>
    </div>
    
    <!--第一个折线图-->
    <div id="echart_zhexian_1" style="width:500px;height:400px; position:absolute; left:400px; top:370px" >
    	<script type="text/javascript">
			echart_zhexian_1();
		</script>
    </div>
    
    <!--第二个折线图-->
    <div id="echart_zhexian_2" style="width:550px;height:400px; position:absolute; left:1000px; top:370px" >
    	<script type="text/javascript">
			echart_zhexian_2();
		</script>
    </div>
</body>
</html>
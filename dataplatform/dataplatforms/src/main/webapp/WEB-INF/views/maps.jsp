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
<style type="text/css">
body, html {
	width: 100%;
	height: 100%;
	margin: 0;
	font-family: "微软雅黑";
}

#allmap {
	width: 100%;
	height: 900px;
}

p {
	margin-left: 5px;
	font-size: 14px;
}
</style>
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=UWLUEpYG6WXC9IV0XSSIGiP1TaMhpZuk"></script>
<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
<title>地图样例DEMO</title>
</head>
<body>

	<div id="allmap"></div>
	<p>
		<strong>点击标注点，可查看由工厂信息窗口</strong>
	</p>

</body>
<script type="text/javascript">
    // 百度地图API功能
    // 创建地图所在区域
    map = new BMap.Map("allmap");
    // 设定初始目标GPS点及缩放大小
    map.centerAndZoom(new BMap.Point(120.4260390,36.1352100), 6);
    // 设定鼠标滑轮滚动效果
    map.enableScrollWheelZoom();
    var factoryStr= '${factoryList}'
    	var factoryList = $.parseJSON(factoryStr);
    	var data_info = []
    	for(var i=0;i<factoryList.length;i++){
        	var id = factoryList[i].id;
    		var longitude = factoryList[i].longitude;
    		var latitude = factoryList[i].latitude;
    		
    		var fname = factoryList[i].fname;
    		var picture = factoryList[i].picture;
    		//var tele = factoryList[i].telephone;
    		var address = factoryList[i].address;
    		var desc = factoryList[i].desc;
    		
    		var marker = new BMap.Marker(new BMap.Point(longitude,latitude));
    		var url = '<%=request.getContextPath()%>/equips?id='+id;
    		var content = "<h4 style='margin:0 0 5px 0;padding:0.2em 0'><a href='"+url+"'>"+fname+"</a></h4>"
    		+ "<a href='"+url+"'><img style='float:right;margin:4px' width='139' height='104' title='f1' src='./resources/image/"+picture+".jpg'/></a>"
    		+"<p style='margin:0;line-height:1.5;font-size:13px;text-indent:2em'>"+desc+"</p>";
    		var infoWindow = new BMap.InfoWindow(content);
    		map.addOverlay(marker);
    		addClickHandler(content,marker);
    		
    	}

    var opts = {
        width : 450,     // 信息窗口宽度
        height: 180,     // 信息窗口高度
        enableMessage:true//设置允许信息窗发送短息
    };
    function addClickHandler(content,marker){
        marker.addEventListener("click",function(e){
                    openInfo(content,e)}
        );
    }
    function openInfo(content,e){
        var p = e.target;
        var point = new BMap.Point(p.getPosition().lng, p.getPosition().lat);
        var infoWindow = new BMap.InfoWindow(content,opts);  // 创建信息窗口对象
        map.openInfoWindow(infoWindow,point); //开启信息窗口
    }
    
</script>
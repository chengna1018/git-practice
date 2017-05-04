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
<link rel="stylesheet" href="./resources/css/jquerypage.css"/>
<link rel="stylesheet" type="text/css" href="./resources/css/singleEquipStyle.css" />
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="./resources/js/jquerypage.js"></script>
<title>工厂设备</title>
</head>
<body>
	<div id="all_equips"></div>
	<div id="page"></div>
	<script type="text/javascript">
	var pageNum = '${pageNum}';
	var equipsStr = '${equipList}'
	var equipList = $.parseJSON(equipsStr);
	var content = "";
	
	
	for (var i = 0;i<equipList.length;i++){
		var desc = equipList[i].desc;
		var name = equipList[i].ename;
		var picture = equipList[i].picture;
		var id=equipList[i].id;
		var url = '<%=request.getContextPath()%>/singleEquip?id='+id;
		/* if(i<4){
			
			content = content + "<div class='img'><a href='"+url+"'><img src='./resources/image/"+picture+".png'></a>"+"<h4>名称："+name+"</h4>"
			+"<h5>简介："+desc+"</h5></div>";
		}else{
			content = content + "<div class='img'><a href='"+url+"'><img src='./resources/image/"+picture+".png'></a>"+"<h4>名称："+name+"</h4>"
			+"<h5>简介："+desc+"</h5></div>";
		} */
		content = content + "<div class='img'><a href='"+url+"'><img src='./resources/image/"+picture+".png'></a>"+"<p>名称："+name+"</p>"
			+"<p style='color:gray;font-family:微软雅黑;font-size:13px;text-align:left;'>简介："+desc+"</p></div>";
	}
	$('#all_equips').html(content);
	var url = '/equips/page';
	var id = '${id}';
	function getPage(page){
		$.ajax({
			type:'POST', 
		    dataType:"json",
		    url:url,
		    data:{
				page:page,
				id:id
			},
			success:function(data){
				content = " ";
				for (var i = 0;i<data.length;i++){
					var desc = data[i].desc;
					var name = data[i].ename;
					var picture = data[i].picture;
					var url = '<%=request.getContextPath()%>/singleEquip?id='+id;
					/* if(i<4){
						content = content + "<div class='img'><img src='./resources/image/"+picture+".png'>"+"<h4>名称："+name+"</h4>"
						+"<h5>简介："+desc+"</h5></div>";
					}else{
						content = content + "<div class='img'><img src='./resources/image/"+picture+".png'>"+"<h4>名称："+name+"</h4>"
						+"<h5>简介："+desc+"</h5></div>";
					} */
					if(i<8){
						content = content + "<div class='img'><img src='./resources/image/"+picture+".png'>"+"<h4>名称："+name+"</h4>"
						+"<h5>简介："+desc+"</h5></div>";
					}
				}
				$('#all_equips').empty();
				$('#all_equips').html(content);
				},
			error:function(data){
				alert('查询结果失败');
				}
		});
		
	};

	$(function(){
		$("#page").Page({
	  		totalPages: parseInt(pageNum), 
	  		liNums: 5, 
	  		activeClass: 'activP', 
	  		callBack : function(page){
		  		getPage(page);
	  		}
  		});
	})
</script>

</body>
</html>
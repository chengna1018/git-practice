//刷新时间为2000ms
DELAYTIME = 2000
//产生随机数（min,max）
function GetRandomNum(Min,Max)
{   
	var Range = Max - Min;   
	var Rand = Math.random();   
	return(Min + Math.round(Rand * Range));   
}
//当前时间
function GetTime(){
	var myDate = new Date();
	var mytime=myDate.toLocaleTimeString();  
	return mytime;
}
//柱状图函数
function show_echartHistogram(){
	// 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('echart_histogram'));
	var xAxisData = [];
	var data1 = [];
    xAxisData.push(GetTime());
   	data1.push(GetRandomNum(50,220));

	option0 = {
   		title: {
       		text: '射出压力',
			subtext: '单位：N'
		 },
   		legend: {
       		data: ['压力大小'],
       		align: 'left'
   		},
   		toolbox: {
       		feature: {
           		magicType: {
          			 type: ['stack']
       			},
           		dataView: {},
           		saveAsImage: {
          			 pixelRatio: 2
       			 }
  			}
		},
 		tooltip: {},
  		xAxis: {
     		data: xAxisData,
       		silent: true,
       		splitLine: {
           		show: true
       		}
   		},
   		yAxis: {
   			},
   		series: [{
       		name: '射出压力',
       		type: 'bar',
       		data: data1,
       		animationDelay: function (idx) {
           		return idx * 2;
       		}
   		}],
   		animationEasing: 'elasticOut',
   		animationDelayUpdate: function (idx) {
   			return idx * 2;
   		}
	};
	myChart.setOption(option0);
	//2秒刷新一次数据
	time = 1;
	splits = 50;
	setInterval(function(){
		if(time<splits){
			time += 1;
			xAxisData.push(GetTime());
		   	data1.push(GetRandomNum(50,220));
		}
		else{
			var times = xAxisData.shift();
			var datas = data1.shift();
			xAxisData.push(GetTime());
		   	data1.push(GetRandomNum(50,220));
		}
		option0.series[0].data = data1;
		option0.xAxis.data = xAxisData;
		myChart.setOption(option0);
	},
	DELAYTIME
	)
}
	 
	    
 //仪表盘函数
function show_yibiao(){
		var myChart = echarts.init(document.getElementById('echart_yibiao'));
	
		option1 = {
				tooltip : {
					formatter: "{a} <br/>{b} : {c}m/s"
				},
				toolbox: {
					feature: {
						restore: {},
						saveAsImage: {}
					}
				},
				series: [
						{
						name: '',
						type: 'gauge',
						detail: {formatter:'{value}'},
						data: [{value: 50, name: '注射速度'}]
						}
						]
		};
		
			myChart.setOption(option1);
			setInterval(function(){
				var num = GetRandomNum(40,80);
				option1.series[0].data[0].value = num;
				myChart.setOption(option1);
			},
			DELAYTIME
			)
		}


//第一个折线图
function echart_zhexian_1(){
			
		var myChart = echarts.init(document.getElementById('echart_zhexian_1'));
		option3 = {
			title: {
				text: '温度',
				subtext: '单位：℃'
			},
			tooltip: {
				trigger: 'axis'
			},
			legend: {
				data:['温度']
			},
			toolbox: {
				show: true,
				feature: {
					dataZoom: {
						yAxisIndex: 'none'
					},
					dataView: {readOnly: false},
					magicType: {type: ['line', 'bar']},
					restore: {},
					saveAsImage: {}
				}
			},
			xAxis:  {
				type: 'category',
				boundaryGap: false,
				data: []
			},
			yAxis: {
				type: 'value',
				axisLabel: {
					formatter: '{value} °C'
				}
			},
			series: [
				{
					name:'运行温度',
					type:'line',
					data:[],
					markPoint: {
						data: [
							{type: 'max', name: '实时数据'},
                    
							]
					},
					markLine: {
						data: [
							{type: 'average', name: '平均值'}
							]
					}
				},   
				]
		};
		option3.xAxis.data.push(GetTime());
		option3.series[0].data.push(GetRandomNum(50,120));
        myChart.setOption(option3);
        
        //每秒获取一次，最大显示8段时间
        split = 8 ;
        count = 1 ;
        setInterval(function(){
        	if(count<split)
        	{
        		count += 1;
        		option3.xAxis.data.push(GetTime());
        		option3.series[0].data.push(GetRandomNum(50,120));
        	}
        	else{
        		//删除并返回头元素
        		var start = option3.xAxis.data.shift();
        		option3.xAxis.data.push(GetTime());
        		
        		var startData = option3.series[0].data.shift();
        		option3.series[0].data.push(GetRandomNum(50,120));
        	}
        	myChart.setOption(option3);
        },
        DELAYTIME		
        );
}



//第二个折线图
function echart_zhexian_2(){
	var myChart = echarts.init(document.getElementById('echart_zhexian_2'));
	option4 = {
			title: {
				text: '锁模力',
				subtext: '单位：ton'
			},
			tooltip: {
				trigger: 'axis'
			},
			legend: {
				data:['锁模力']
			},
			toolbox: {
				show: true,
				feature: {
					dataZoom: {
						yAxisIndex: 'none'
					},
					dataView: {readOnly: false},
					magicType: {type: ['line', 'bar']},
					restore: {},
					saveAsImage: {}
				}
			},
			xAxis:  {
				type: 'category',
				boundaryGap: false,
				data: []
			},
			yAxis: {
				type: 'value',
				axisLabel: {
					formatter: '{value} ton'
				}
			},
			series: [
				{
					name:'锁模力',
					lineStyle:{
						normal:{
							color:"#000"
						},
					},
					type:'line',
					data:[],
					markPoint: {
						data: [
							{type: 'max', name: '实时数据'},
                    
							]
					},
					markLine: {
						data: [
							{type: 'average', name: '平均值'}
							]
					}
				},   
				]
		};
		option4.xAxis.data.push(GetTime());
		option4.series[0].data.push(GetRandomNum(80,200));
        myChart.setOption(option4);
        
        //每秒获取一次，最大显示8段时间
        split = 8 ;
        count = 1 ;
        setInterval(function(){
        	if(count<split)
        	{
        		count += 1;
        		option4.xAxis.data.push(GetTime());
        		option4.series[0].data.push(GetRandomNum(50,120));
        	}
        	else{
        		//删除并返回头元素
        		var start = option4.xAxis.data.shift();
        		option4.xAxis.data.push(GetTime());
        		
        		var startData = option4.series[0].data.shift();
        		option4.series[0].data.push(GetRandomNum(50,120));
        	}
        	myChart.setOption(option4);
        },
        DELAYTIME		
        );
}
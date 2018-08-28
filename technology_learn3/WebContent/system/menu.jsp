<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
</head>
<body>
<body> 
	<table id="dg"></table>
	<script type="text/javascript">
		//创建数据表格
		$('#dg').datagrid({ 
			url:'../menu.action',   //数据来源ajax请求， 响应json数据
			columns:[[                 //展示数据
				{field:'id',title:'编号',width:100}, 
				{field:'pId',title:'父编号',width:100}, 
				{field:'name',title:'名称',width:100,align:'right'},
				{field:'page',title:'网页',width:100,align:'right'} 
			]],
			pagination:true,  
			toolbar: [{  	//工具栏	
				  iconCls: 'icon-edit',  	//显示图标样式
				  text:'修改',              //显示文本
				  handler: function(){     //点击事件
					  alert('edit')
				  }  	
				  },{  		
				  iconCls: 'icon-help',
				  text:'帮助',
				  handler: function(){
					  alert('help')
				  }  	
		  }] ,
		  fit : true,
		  striped:true,
		  rownumbers:true,
		  singleSelect:true,
		  pageNumber:1,
		  pageSize:10,
		  pageList:[5,10,20]	
		}); 
	</script>
	
</body> 
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.3.1.min.js"></script>
<style type="text/css">

#tlist li{
    list-style-type:none;
    float:left;
    padding-left: 50px;
}
#ttable{
	width: 1000px;
	height: 100%;
	 font-size:11px;
	  color:#333333;
	}
#ttable td{
     border-width: 1px;
     padding: 8px;
     border-style: solid;
     border-color: #666666;
     background-color: #ffffff;
}	
table{border: 1px;}
</style>
</head>
<body>
   <!-- 主题列表 -->
   <ul id="tlist"></ul><br>
   <hr>
   <!-- 新闻列表 -->
   <table id="ttable">
   
   
   </table>
   <script>
   //加载主题
   loadTopic();
   //加载新闻
  loadNews();
   function loadTopic() {
		$.ajax({
	   		url:"GetTopicsevlet",
	   		tope:"get",
	   		dataType:"json",
	   		success:function(data){
	   			
	   			$(data.topic).each(function (i,item) {
					$("#tlist").append("<li>"+item.tid+"***"+item.tname+"</li>");
				})	
	   		}
	   	})
	   	}
   function loadNews() {
		$.ajax({
	   		url:"Getnewssevlet",
	   		tope:"get",
	   		dataType:"json",
	   		success:function(data){
	   			console.log(data);
	   			$(data.news).each(function (i,item) {
					$("#ttable").append("<tr><td>"+item.ntitle+
							"</td><td>"+item.nsummary+
							"</td><td>"+item.ncontent+
							"</td><td>"+item.nauthor+
							"</td><td>"+item.ncreatedate+
							"</td><td><a href='#'>修改</a>&nbsp;<br>"
							+"<a href='#'>删除</a>"+
							"</td></tr>");
				})	 
	   		}
	   	})
} 
	  
   
   
   </script>
</body>
</html>
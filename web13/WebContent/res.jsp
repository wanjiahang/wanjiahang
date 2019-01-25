<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册2</title>
<script src="js/jquery-3.3.1.min.js"></script>
</head>
<body>
<input type="text" onblur="valName()" id="uname">
    <h2 id="msg"></h2>
   <script type="text/javascript">
   function valName() {
       var uname = $("#uname").val();
       if (uname.length < 1 || uname == null) {
           alert("用户名不能为空")
       } else {
           /* $.ajax({
        	  url:"Reginservlet?name="+uname,
        	  type:"get",
        	  dataType:"text",//指定服务器响应的数据 类型
        	  success:function(data){
        		  if (data=="ok"){
                      $("#msg").text("该账户可用").css("color","green");
                  } else {
                      $("#msg").text("该账户不可用").css("color","red");
                  }
        	  }
        	 }) */
        	 $.get("Reginservlet",{'name':uname},function(data){
        		 if (data=="ok"){
                     $("#msg").text("该账户可用").css("color","green");
                 } else {
                     $("#msg").text("该账户不可用").css("color","red");
                 }        	 })
       }
   }
	
   
   
   
   
   </script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>

<script src="js/jquery-3.3.1.min.js"></script>
</head>
<body>
	<input type="text" onblur="valName()" id="uname">
    <h2 id="msg"></h2>
	<script>
	function valName() {
        var uname = $("#uname").val();
        if (uname.length < 1 || uname == null) {
            alert("用户名不能为空")
        } else {
            //下面用Ajax将uname传到后台判断此人是否存在
            //js版本ajax
            var xmlHttpRequest=new XMLHttpRequest();
            xmlHttpRequest.onreadystatechange =function () {
               //判断返回的状态，并且解析响应里面的数据
                if (xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
                    //解析响应数据
                    var  data=xmlHttpRequest.responseText;
                    if (data=="ok"){
                        $("#msg").text("该账户可用").css("color","green");
                    } else {
                        $("#msg").text("该账户不可用").css("color","red");
                    }
                }
            }
            xmlHttpRequest.open("get","Reginservlet?uname="+uname,"true");//true表示异步，false表示同步
            xmlHttpRequest.send(null);
        }
    }
	
	</script>
</body>
</html>
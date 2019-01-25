<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
     <script src="js/jquery-3.3.1.min.js"></script>
</head>
<body>
		<select id="opt"></select>
		<script type="text/javascript">
		 var dog={name:"小黑",age:5};//json对象
		 var dogs=[{name:"小黑",age:5},
			       {name:"小黑1",age:5},
		 		   {name:"小黑2",age:5},
			       {name:"小黑3",age:5}
			      ]
		$(dogs).each(function (i,item) {
			$("#opt").append("<option>"+item.name+"<option>");
		})
		</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.wh.www.util.DateUtil"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
      <%
    	String s=request.getParameter("name");
        DateUtil sUtil=new DateUtil();
        boolean s1=sUtil.validate(s);
        if(s1==true){
        	out.write("<script>alert('日期格式正确')</script>");
        }else{
        	out.write("<script>alert('日期格式不正确')</script>");
        }
        out.write("<script>location.href='riqi.jsp'</script>");
    %>
    
</body>
</html>
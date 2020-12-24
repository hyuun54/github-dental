<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String imsi = request.getContextPath() + "/tooth?command=main" ;
	//왜 pull이 안나오지 ㅇ
	response.sendRedirect(imsi) ;
%>
</body>
</html>
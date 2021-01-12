<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<%@ include file="../common/header.jsp" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



<!DOCTYPE html>
<html>

<style>
ul{
   list-style:none;
   }
</style>
<head>
 <meta charset="utf-8" />
<title>Insert title here</title>
</head>
<body id="page-side">

	
	 	<div class="quick">
            <ul style="position:absolute; top:35%;right:22px">
                <!--<li><a href="#"><img src="../img/quick_03.png" alt=""></a></li>-->                
                <li ><a href="<%=NoForm%>boCounselList"><img src="../images/tooth01.jpg" alt="" title=""></a></li>
                <li><a href="<%=NoForm%>meInsert"><img src="../images/tooth04.jpg" alt="" title=""></a></li>                
               	<li class="bo"><a href="<%=NoForm%>prList"><img src="../images/tooth03.jpg" alt=""></a></li>
                <li><a href="<%=NoForm%>boDirection"><img src="../images/tooth02.jpg" alt=""></a></li>
               
            </ul>
            
        </div>
	 	

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Third party plugin JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
        <!-- Contact form JS-->
        <script src="${contextPath}/assets/mail/jqBootstrapValidation.js"></script>
        <script src="${contextPath}/assets/mail/contact_me.js"></script>
        <!-- Core theme JS-->
        <script src="${contextPath}/js/scripts.js"></script>
</body>
</html>
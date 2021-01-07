<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<title>의료진 소개</title>
	
	<style type="text/css">
	body{
		color: #495057;
	}
	
	h1, h2{
		color: #212529;
	}
	
	hr{
		background-color: #495057;
		color: #495057;
		display: block;
		margin-top: 0.5em;
		margin-bottom: 0.5em;
	 	margin-left: auto;
		margin-right: auto;
		border-style: inset;
		border-width: 1.5px;
	}
</style>
</head>
<body>
	<br><br><br>
	<section class="page-section bg-light" id="team">
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">의료진 소개</h2>
                    <h3 class="section-subheading text-muted">Today Dental Network Dactor</h3>
                </div>
                <br><br>
                 <hr>
                <br><br><br><br><br>
                <div class="row">
                    <div class="col-lg-4">
                        <div class="team-member">
                            <img class="mx-auto rounded-circle" src="${contextPath}/assets/img/team/one.jpg" alt="" href="doctor_01.png">
                            <h4>강선호 원장</h4><br>
                            <p class="text-muted">대표 원장</p>
                            <a class="btn btn-dark btn-social mx-2" href="void(0);" onclick="alert('준비중입니다!'); return false;"><i class="fab fa-twitter"></i></a>
                            <a class="btn btn-dark btn-social mx-2" href="void(0);" onclick="alert('준비중입니다!'); return false;"><i class="fab fa-facebook-f"></i></a>
                            <a class="btn btn-dark btn-social mx-2" href="void(0);" onclick="alert('준비중입니다!'); return false;"><i class="fab fa-linkedin-in"></i></a>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="team-member">
                            <img class="mx-auto rounded-circle" src="${contextPath}/assets/img/team/two.jpg" alt="" />
                            <h4>이윤희 전문의</h4><br>
                            <p class="text-muted">구강외과 전문의</p>
                            <a class="btn btn-dark btn-social mx-2" href="void(0);" onclick="alert('준비중입니다!'); return false;"><i class="fab fa-twitter"></i></a>
                            <a class="btn btn-dark btn-social mx-2" href="void(0);" onclick="alert('준비중입니다!'); return false;"><i class="fab fa-facebook-f"></i></a>
                            <a class="btn btn-dark btn-social mx-2" href="void(0);" onclick="alert('준비중입니다!'); return false;"><i class="fab fa-linkedin-in"></i></a>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="team-member">
                            <img class="mx-auto rounded-circle" src="${contextPath}/assets/img/team/three.jpg" alt="" />
                            <h4>김범진 전문의</h4><br>
                            <p class="text-muted">교정과&보존과 전문의</p>
                            <a class="btn btn-dark btn-social mx-2" href="void(0);" onclick="alert('준비중입니다!'); return false;"><i class="fab fa-twitter"></i></a>
                            <a class="btn btn-dark btn-social mx-2" href="void(0);" onclick="alert('준비중입니다!'); return false;"><i class="fab fa-facebook-f"></i></a>
                            <a class="btn btn-dark btn-social mx-2" href="void(0);" onclick="alert('준비중입니다!'); return false;"><i class="fab fa-linkedin-in"></i></a>
                        </div>
                    </div>
                </div>
                <br><br>
                <div class="row">
                    <div class="col-lg-8 mx-auto text-center"><p class="large text-muted">고객 한분 한분에게 최선을 다하려고 하는 백년치과,<br>
                    	모든 분들에게 치료 과정 뿐만 아니라 치료 후에도 만족스러울 수 있도록 꾸준히 노력하겠습니다.</p></div>
                </div>
            </div>
        </section>
</body>
</html>
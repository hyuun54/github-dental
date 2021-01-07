<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>병원 소개</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style type="text/css">
	body{
		margin-top: 100px;
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

<body>

		<section class="page-section" id="about">
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">백년 치과</h2>
                    <h3 class="section-subheading text-muted">100년을 이어져온 유서깊은 치과</h3>
                </div>
                <hr>
                <br><br><br>
                <ul class="timeline">
                    <li>
                        <div class="timeline-image"><img class="rounded-circle img-fluid" src="${contextPath}/assets/img/intro/dentist01.jpg" alt="" /></div>
                        <div class="timeline-panel">
                            <div class="timeline-heading">
                                <h4>1920년</h4>
                                <h4 class="subheading">대한민국 최초의 치과</h4>
                            </div>
                            <div class="timeline-body"><p class="text-muted">백년치과의 원장들은 1920년에 미국에서 같은 학교를 다닌 선후배 사이로, 모두 20년 이상의 치과의사 경력을 가지고 있습니다. 대한민국 최초의 치과로 100년 전통의 치과입니다. 분야별 담당의사의 진료를 통해서 환자들에게 보다 나은 서비스를 제공합니다.</p></div>
                        </div>
                    </li>
                    <li class="timeline-inverted">
                        <div class="timeline-image"><img class="rounded-circle img-fluid" src="${contextPath}/assets/img/intro/machine02.jpg" alt="" /></div>
                        <div class="timeline-panel">
                            <div class="timeline-heading">
                                <h4>1999년</h4>
                                <h4 class="subheading">20세기 최고의 치과</h4>
                            </div>
                            <div class="timeline-body"><p class="text-muted">1999년 아시아부문에서 20세기의 최고의 치과에 선정되었습니다. 서비스, 고객만족도 부문에서 1위를 차지하면서 압도적인 1등으로 선정되었습니다. 일본, 중국, 러시아, 몽골, 미국, 필리핀, 싱가폴, 베트남 등 여러 나라에서 백년치과를 찾아오고 있습니다. 의사들은 모두 기본적으로 5개국어를 다루며, 외국인을 위한 통역사도 있습니다.</p></div>
                        </div>
                    </li>
                    <li>
                        <div class="timeline-image"><img class="rounded-circle img-fluid" src="${contextPath}/assets/img/intro/front01.png" alt="" /></div>
                        <div class="timeline-panel">
                            <div class="timeline-heading">
                                <h4>2015년</h4>
                                <h4 class="subheading">미래를 보는 치과</h4>
                            </div>
                            <div class="timeline-body"><p class="text-muted">백년치과는 100년된 노하우를 가지고 있는 반면에, 100년후 미래를 보는 치과를 목표로 하고 있습니다. 최신식 장비와 각 분야별 최고의 전문 의료진들을 갖추고 있어서 환자에게도 최고의 맞춤형 서비스를 제공합니다. 백년치과는 항상 최고의 치과치료를 위해서 노력을 하고 있습니다.</p></div>
                        </div>
                    </li>
                    <li class="timeline-inverted">
                        <div class="timeline-image"><img class="rounded-circle img-fluid" src="${contextPath}/assets/img/intro/doctor01.jpg" alt="" /></div>
                        <div class="timeline-panel">
                            <div class="timeline-heading">
                                <h4>2020년</h4>
                                <h4 class="subheading">환자를 가장 생각하는 치과</h4>
                            </div>
                            <div class="timeline-body"><p class="text-muted">백년치과의 치과는 환자가 필요한 것을 반영합니다. 환자가 원하는 환경, 환자가 원하는 의료서비스등 모든 것은 환자에게 맞춰져 있습니다. 의사들은 바뀌어 가는 시대에 맞춰서 자기 스스로의 관리와 공부도 꾸준히 하며 환자들에게 보다 좋은 서비스를 위해서 노력하고있습니다.</p></div>
                        </div>
                    </li>
                    <li class="timeline-inverted">
                        <div class="timeline-image">
                            <h4>
                              	I'll
                                <br />
                                do
                                <br />
                                my best!
                            </h4>
                        </div>
                    </li>
                </ul>
            </div>
        </section>
		
</body>
</html>
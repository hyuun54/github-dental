<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<title>오시는 길</title>
	<style type="text/css">
	hr{
		background-color: #495057;
		color: #495057;
		display: block;
		margin-top: 0.5em;
		margin-bottom: 0.5em;
	 	margin-left: 0px;
		margin-right: auto;
		border-style: inset;
		border-width: 1.5px;
		width: 80%;
	}
	.map-direction{
		padding-top: 10px;
	}
	.container-align{
		margin-left: 15%;
	}
	</style>
	<script>
		function gotomap(){
			var mywidth = 1000;
			var myheight = 600;
			
			var newwidth = (screen.width - mywidth)/2;
			var newheight = (screen.height - myheight)/2;
			
			var options = 'width=' + mywidth;
			options += ',height=' + myheight;
			options += ',left=' + newwidth;
			options += ',top=' + newheight;

			window.open('https://map.naver.com/v5/entry/place/1540600356?c=14130564.6751390,4516452.0080504,17,0,0,3,dh', 'mytitle', options);
		}
	</script>
</head>
<body>
	<br><br><br>
	<section class="page-section bg-light" id="direction">
	    <div class="container">
	       <div class="text-center">
	           <h2 class="section-heading text-uppercase">오시는 길</h2>
				<br><br>
	       </div>
		</div> 
		
		<div class="container-align">
	        <hr>
			<div class="container" style="text-align:left;">
				<div class="row">
					<div class="col-lg-4">
		            	<div class="detail-direction">
							<ul class="directions-info">
								<li>
									<p class="first">위치</p>
									<p class="second">서강대 정문</p>
								</li>
								<li>
									<p class="first">주소</p>
									<p class="second">서울 마포구 백범로 23 구프라자 3층</p>
								</li>
								<li>
									<p class="first">전화</p>
									<p class="second">02-707-1480</p>
								</li>
								<li>
									<p class="first"><span class="green">7호선</span></p>
									<p class="second">2호선 신촌역 6번출구에서 8분 거리</p>
								</li>
								<li>
									<p class="first"><span class="yellow">분당선</span></p>
									<p class="second">경의중앙선 서강대역 1번출구에서 9분 거리</p>
								</li>
							</ul>
		
						</div> 
					</div> 
					
					<div class="col-lg-4">
				    	<div class="map-direction">
							<img width="503" height="403" src="${contextPath}/assets/img/map.png" class="mx-auto" alt="지도" />
						</div> 
					</div> 
				</div> 
			</div> 
			<div class="container" style="text-align:left;">
				<div class="row">
					<div class="col-lg-4">
		            	<div class="maplink">
							<br>
							<button class="btn btn-primary" type="button" onclick="gotomap();">약도보기</button>
						</div> 
					</div> 
				</div> 
			</div>
			<br><br>
			<div class="container">
		       <div class="text-left">
		           <h4 class="text-uppercase">버스 이용시</h4>
		       </div>
			</div>
			<div class="container" style="text-align:left;">
				<div class="row">
					<div class="col-lg-12">
		            	<div class="maplink">
							서강대학교 정거장에서 내린 후 서강대학교 정문을 기준으로 왼쪽 한블록 건너에 건물이 보입니다.
						</div> 
					</div> 
				</div> 
			</div> 
			<div class="container" style="text-align:left;">
				<div class="row">
					<div class="col-lg-9">
		            	<div class="bustable">
							<table class="table table-bordered">
							<colgroup>
								<col class="station" />
								<col class="bluebus" />
								<col class="bluebus-num" />
								<col class="greenbus" />
								<col class="greenbus-num" /> 
							</colgroup>
							<tbody>
								<tr>
									<th scope="row">서강대학교 앞 정류소</th>
									<td><span class="bluebox">간선</span></td>
									<td>921, 110A, 604, 740, 753</td>
									<td><span class="greenbox">지선</span></td>
									<td>5714, 6712, 7016, 7613</td>
								</tr>
								<tr>
									<th scope="row">신촌로터리 앞 정류소</th>
									<td><span class="bluebox">간선</span></td>
									<td>921, 110A, 604, 740, 753</td>
									<td><span class="greenbox">지선</span></td>
									<td>5714, 6712, 7016, 7613</td>
								</tr>
								<tr>
									<th scope="row">신촌오거리.2호선신촌역</th>
									<td><span class="bluebox">간선</span></td>
									<td>270, 271A, 273, 602, 603, 707, 721</td>
									<td><span class="greenbox">지선</span></td>
									<td>6716, 7011, 7611, 7713</td>
								</tr>
							</tbody>
							</table>
						</div>
					</div> 
				</div> 
			</div> 
		</div>
	</section>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <%@ include file="../common/header.jsp"%>
 
<%
	int offset = 2 ; //오프 셋 
	int content = twelve - 2 * offset ; //12 - 2 * 오프셋	
%>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">	
	<title>BootStrap</title>
	<style type="text/css">
		/*.panel-body{ margin-bottom: -30px;}*/
		div#main_container{
			margin:140px;
		}
		abc{font-weigth : bold;}
	</style>
</head>
<body>
	<div id="main_container"class="container col-md-offset-4 col-md-<%=content%>" align="right">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h1 class="panel-title" align="left">개인정보</h1>
			</div>
			<hr style="border: solid 1px ;">
			<div class="panel-body" align="left">
				<div class="col-md-8">
					<table class="table table-condendes " >
						<tr>
							<td width="35%">이름</td>
							<td width="65%">${bean.name}</td>
						</tr>	
						<tr>
							<td width="35%">아이디</td>
							<td width="65%">${bean.id}</td>
						</tr>	
						<tr>
							<td  width="35%">비밀 번호</td>
							<td width="65%">${bean.password}</td>
						</tr>
						<tr>
							<td width="35%">생년월일</td>
							<td width="65%">${bean.birthdate}</td>
						</tr>
						<tr>
							<td width="35%">성별</td>
							<td width="65%">${bean.gender}</td>
						</tr>
						<tr>
							<td width="35%">전화번호</td>
							<td width="65%">${bean.phone}</td>
						</tr>
						<tr>
							<td width="35%">이메일</td>
							<td width="65%">${bean.email}</td>
						</tr>
						<tr>
							<td width="35%">우편 번호</td>
							<td width="65%">${bean.zipcode}</td>
						</tr>
						<tr>
							<td width="35%">주소</td>
							<td width="65%">${bean.address1}</td>
						</tr>
						<tr>
							<td width="35%">세부 주소</td>
							<td width="65%">${bean.address2}</td>
						</tr>
						<tr>
							<td width="35%">포인트</td>
							<td width="65%">${bean.mpoint}</td>
						</tr>	
					</table>				
				</div>
				<hr>
				<div class="col-md-offset-5 col-md-4">
					<button class="btn btn-primary" onclick="history.back();">돌아 가기</button>
				</div>
			</div><!-- end panel-body -->
		</div>		
	</div>		
</body>
</html>
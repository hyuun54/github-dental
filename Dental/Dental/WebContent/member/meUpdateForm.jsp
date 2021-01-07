<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../common/header.jsp"%>
<%
	int myoffset = 2 ;
	int mywidth = twelve - 2 * myoffset;
	int formleft = 3 ;
	int formright = twelve - formleft ; 
%>
<html>
<head>
	<style type="text/css">
		.form-group{ margin-bottom : 3px; }
	</style>
	<script type="text/javascript">
		function findZipcode( ){ /* 우편 번호 검색 */
			var url='<%=NoForm%>meZipcheck';
			window.open(url, 'mywin',
				'height=600,width=720,status=yes,scrollbars=yes,resizable=no');
		}		
	</script>
</head>
<body>
	<div id="main_container" align="center" 
		class="container col-xs-offset-<%=myoffset%> col-lg-offset-<%=myoffset%> col-xs-<%=mywidth%> col-lg-<%=mywidth%>"> 
		<h2>회원 정보 수정</h2>
		<div class="panel panel-primary sub_container">
			<div class="panel-heading" align="left">
				<font color="red"><b>회원 수정</b></font> 페이지입니다.
			</div>
			<div class="panel-body sub_container">
				<form class="form-horizontal" role="form" name="myform" action="<%=YesForm%>"  method="post">
					<input type="hidden" name="command" value="meUpdate">
					<div class="form-group">
						<label for="id" class="col-xs-<%=formleft%> col-lg-<%=formleft%> control-label">아이디</label>
	        			<div class="col-xs-<%=formright-2%> col-lg-<%=formright-2%>">
	            			
	            			<input type="text" name="fakeid" id="fakeid" class="form-control" 
	            				placeholder="아이디" disabled="disabled" value="${requestScope.bean.id}" > 
	            			
	            			<input type="hidden" name="id" id="id" value="${requestScope.bean.id}" >
	            			
	            			
	            			<span class="err">${errid}</span>
	        			</div>
	        		</div>        		
					<div class="form-group">
						<label for="name" class="col-xs-<%=formleft%> col-lg-<%=formleft%> control-label">이름</label>
	        			<div class="col-xs-<%=formright%> col-lg-<%=formright%>">
	            			<input type="text" name="name" id="name" class="form-control" placeholder="이름" value="${requestScope.bean.name}" >
	            			<span class="err">${errname}</span>
	        			</div>
	        		</div>
					<div class="form-group">
						<label for="password" class="col-xs-<%=formleft%> col-lg-<%=formleft%> control-label">비밀 번호</label>
	        			<div class="col-xs-<%=formright%> col-lg-<%=formright%>">
	            			<input type="password" name="password" id="password" class="form-control" placeholder="비밀 번호를 넣어 주셔요" 
	            				value="" >
	            			<span class="err">${errpassword}</span> 
	        			</div>
	        		</div>
					<div class="form-group">
						<label for=birthdate" class="col-xs-<%=formleft%> col-lg-<%=formleft%> control-label">생년월일</label>
	        			<div class="col-xs-<%=formright%> col-lg-<%=formright%>">
	            			<input type="text" name="birthdate" id="birthdate" class="form-control" placeholder="생년월일" value="${requestScope.bean.birthdate}" >
	            			<span class="err">${errhiredate}</span>
	        			</div>
	        		</div>
					<div class="form-group">
						<label for="gender" class="col-xs-<%=formleft%> col-lg-<%=formleft%> control-label">성별</label>
	        			<div class="col-xs-<%=formright%> col-lg-<%=formright%>" align="left">
	            			<label class="radio-inline"> 
	            			<c:if test="${requestScope.bean.gender == '남자'}">
	            				<input type="radio" name="gender" value="남자" checked="checked">남자
	            			</c:if>
	            			<c:if test="${requestScope.bean.gender != '남자'}">
	            				<input type="radio" name="gender" value="남자">남자
	            			</c:if>
							</label> 
							&nbsp;&nbsp;&nbsp;
							<label class="radio-inline"> 
	            			<c:if test="${requestScope.bean.gender == '여자'}">
	            				<input type="radio" name="gender" value="여자" checked="checked">여자
	            			</c:if>
	            			<c:if test="${requestScope.bean.gender != '여자'}">
	            				<input type="radio" name="gender" value="여자">여자
	            			</c:if> 
							</label>
							<span class="err">${errgender}</span>
	        			</div>
	        		</div>
	        		<div class="form-group">
						<label for="phone" class="col-xs-<%=formleft%> col-lg-<%=formleft%> control-label">전화 번호</label>
	        			<div class="col-xs-<%=formright%> col-lg-<%=formright%>">
	            			<input type="phone" name="phone" id="phone" class="form-control" placeholder="전화번호를 넣어주세요." 
	            				value="" >
	            			<span class="err">${errphone}</span> 
	        			</div>
	        		</div>	    
	        		<div class="form-group">
						<label for="email" class="col-xs-<%=formleft%> col-lg-<%=formleft%> control-label">이메일</label>
	        			<div class="col-xs-<%=formright%> col-lg-<%=formright%>">
	            			<input type="email" name="email" id="email" class="form-control" placeholder="이메일을 넣어 주셔요" 
	            				value="" >
	            			<span class="err">${erremail}</span> 
	        			</div>
	        		</div>  

					<div class="form-group">
						<label for="zipcode" class="col-xs-<%=formleft%> col-lg-<%=formleft%> control-label">우편 번호</label>
	        			<div class="col-xs-<%=formright-2%> col-lg-<%=formright-2%>">
	            			<input type="text" name="fakezipcode" id="fakezipcode" class="form-control" disabled="disabled" placeholder="우편 번호" value="${requestScope.bean.zipcode}" >
	            			<input type="hidden" name="zipcode" id="zipcode" value="${requestScope.bean.zipcode}" >
	            			<span class="err">${errzipcode}</span>
	        			</div>
						<div class="col-xs-<%=2%> col-lg-<%=2%>" align="left">
	            			<input type="button" class="btn btn-info" value="우편 번호 찾기" onclick="findZipcode();"> 
	        			</div>	        			
	        		</div> 
					<div class="form-group">
						<label for="address1" class="col-xs-<%=formleft%> col-lg-<%=formleft%> control-label">주소</label>
	        			<div class="col-xs-<%=formright%> col-lg-<%=formright%>">
	            			<input type="text" name="fakeaddress1" id="fakeaddress1" class="form-control" disabled="disabled" placeholder="주소" value="${requestScope.bean.address1}" >
	            			<input type="hidden" name="address1" id="address1" value="${requestScope.bean.address1}" >
	            			<span class="err">${erraddress1}</span>	            			
	        			</div>
	        		</div>
					<div class="form-group">
						<label for="address2" class="col-xs-<%=formleft%> col-lg-<%=formleft%> control-label">세부 주소</label>
	        			<div class="col-xs-<%=formright%> col-lg-<%=formright%>">
	            			<input type="text" name="address2" id="address2" class="form-control" placeholder="세부 주소" value="${requestScope.bean.address2}" >
	            			<span class="err">${erraddress2}</span>
	        			</div>
	        		</div>
					<div class="form-group">
						<div class="col-xs-<%=twelve%> col-lg-<%=twelve%>" align="center">
							<button type="submit" class="btn btn-default"><b>정보 수정</b></button>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<button type="reset" class="btn btn-default">취소</button>
						</div>
					</div>
				</form>
			</div>
		</div>		
	</div>
</body>
</html>
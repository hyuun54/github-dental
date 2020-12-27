<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
form {
	border: 3px solid #f1f1f1;
	margin-top: 200px;  
}

input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-color: #fed136;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}

.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}


.container {
  padding: 16px;
}

span.psw, span.uid{
  float: right;
  padding-top: 16px;
  padding-left: 16px;
}

.bClass{
	color: #212529;
}

.forgotPassword, .Insert, .forgotId{
	color: #f44336;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw, span.uid{
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
  }
}
</style>
</head>
<body>


<form action="<%=YesForm%>" method="post">
	<input type="hidden" name="command" value="meLogin">
  <div class="container">
    <label for="uid"><b class="bClass">아이디</b></label>
    <input type="text" placeholder="아이디를 입력해주세요." name="uid" required value="${requestScope.id}"
    data-toggle="tooltip" data-placement="top" 
								title="아이디는  4글자 이상 10글자 이하로 입력해 주세요.">
    <span class="err">${errid}</span>

    <label for="psw"><b class="bClass">비밀번호</b></label>
    <input type="password" placeholder="비밀번호를 입력해주세요." name="psw" required value="${requestScope.password}"
    data-toggle="tooltip" data-placement="top" 
								title="비밀번호는  4글자 이상 10글자 이하로 입력해 주세요.">
    <span class="err">${errpassword}</span>
    
    <button type="submit">로그인</button>
    <label>
      <input type="checkbox" checked="checked" name="remember"> 로그인 상태 유지
    </label>
  </div>

  <div class="container" style="background-color:#f1f1f1">
    <button type="button" class="cancelbtn">로그인 취소</button>
    <span class="psw"><a href="#" class="forgotPassword">비밀번호 찾기</a></span>
    <span class="uid"><a href="#" class="forgotId">아이디 찾기</a></span>
    <span class="uid"><a href="<%=NoForm%>meInsert" class="Insert">회원 가입</a></span>
  </div>
</form>

<script>
	$(document).ready(function(){
   		$('[data-toggle="tooltip"]').tooltip();    		
	});
</script>

</body>
</html>


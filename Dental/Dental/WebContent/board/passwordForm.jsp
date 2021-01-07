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
  margin: 0px;
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

.err{
	font-size : 10pt;
	color:red;
	font-weight: bolder;
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
	<input type="hidden" name="command" value="boDetailView">
  <div class="container">
    <label for="psw"><b class="bClass">비밀번호</b></label>
    <input type="password" placeholder="비밀번호를 입력해주세요." name="boPassword" 
    data-toggle="tooltip" data-placement="top" 
								title="비밀번호는  4글자 이상 10글자 이하로 입력해 주세요.">
    <span class="err">${errboPassword}</span>
    <span class="err">${errfail}</span>
    
    <button type="submit">확인</button>
  </div>

  <div class="container" style="background-color:#f1f1f1">
    <button type="button" class="cancelbtn" onclick="gotoBack();">취소</button>
  </div>
</form>

<script>
	$(document).ready(function(){
   		$('[data-toggle="tooltip"]').tooltip();    		
	});
	
	function gotoBack(){
		location.href='<%=NoForm%>boCounselList&${requestScope.parameters}';
	}
</script>

</body>
</html>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>

<!doctype html>
 <%
	int myoffset = 2;
	int mywidth = twelve - 2 * myoffset;
	int formleft = 3;
	int formright = twelve - formleft;
%>
<html>
<head>
  <style type="text/css">
  .cotainer{	
  position: absolute;
  top: 10%;
  width: 50%;
  left: 25%;
  text-align: center;
  }
 </style>
 <script type="text/javascript">
		function checkDuplicateId(  ){
			var id = document.myform.id.v alue ;
			if( id.length == 0 ){
				alert('아이디를 입력해 주세요') ;
				document.myform.id.focus() ; 
				return false ;
			}
			var url='<%=NoForm%>meIdcheck&id=' + id ; 
			window.open(url, 'mywin', 'height=150,width=300') ;
		}
		
		function findZipcode( ){
			var url='<%=NoForm%>meZipcheck';
			window.open(url, 'mywin',
				'height=600,width=720,status=yes,scrollbars=yes,resizable=no');
		}
		
	function isCheckFalse() {
		document.myform.isCheck.value = false;
	}
	function checkForm() {
		var isCheck = document.myform.isCheck.value;
		//alert( isCheck ) ;
		if (isCheck == 'false') {
			alert('아이디 중복 체크를 우선 해주세용.');
			return false;
		}
	}
</script>
</head>
<body>
    <div class="cotainer" >
        <div class="row justify-content-center">
            <div class="col-md-12">
                    <div class="card">
                        <div class="card-header">회원 가입</div>
                        <div class="card-body">
                       		 <form id="myform" name="myform" role="form" action="<%=YesForm%>" method="post">
                       		 		<input type="hidden" name="command" value="meInsert"> <input
										type="hidden" name="isCheck" value="false"> <input
										type="hidden" name="mpoint" value="5">
 	                            <div class="form-group row">
                                    <label for="id" class="col-md-4 col-form-label text-md-right">아이디</label>
                                    <div class="col-md-6">
                                        <input type="text" name="id" id="id" class="form-control"
                                     	 placeholder="최소 3자이상 입력하세요." value="${requestScope.bean.id}"
										 onkeyup="isCheckFalse();"> <span class="err" id="spanid">${errid}</span>
                                    </div>
                                    <div class="col-xs-<%=2%> col-lg-<%=2%>" align="left">
										<input type="button" class="btn btn-info" value="중복 검사" onclick="checkDuplicateId();">
									</div>
                                </div>
                            
                                <div class="form-group row">
                                    <label for="name" class="col-md-4 col-form-label text-md-right">이름</label>
                                    <div class="col-md-6">
                                        <input type="text" id="name" class="form-control" name="name" value="${requestScope.bean.name}"> 
                                       		<span class="err">${errname}</span>
                                    </div>
                                </div>
                      			<div class="form-group row">
                                    <label for="pass_word" class="col-md-4 col-form-label text-md-right">비밀번호</label>
                                    <div class="col-md-6">
                                     	<input type="password" name="password" id="password"
											class="form-control" placeholder="문자 숫자 혼합 6글자이상" value=""> 
										<span class="err">${errpassword}</span>
                                    </div>
                                </div>
     							 <div class="form-group row">
                                    <label for="birthdate" class="col-md-4 col-form-label text-md-right">생년월일</label>
                                    <div class="col-md-6">
                                        <input type="text" id="birthdate" class="form-control" placeholder="YYYY/MM/DD">
                                    </div>
                                    	<span class="err">${errbirthdate}</span>
                                </div>      
                                <div class="form-group row">
                                    <label for="gender" class="col-md-4 col-form-label text-md-right">성별</label>
                                    <div class="col-md-6">
                                   	<label class="radio-inline">                                    	
                                   		<input type="radio" name="gender" id="gender1" value="남자">남자
									</label> &nbsp;&nbsp;<label class="radio-inline"> 
										<input type="radio" name="gender" id="gender2" value="여자">여자
										</label> <span class="form-control-static err">${errgender}</span>
									</div>
								 </div>  
								 
                             
								 <div class="form-group row">
                                    <label for="phone_number" class="col-md-4 col-form-label text-md-right">전화번호</label>
                                    <div class="col-md-5">
                                    	<input type="text" name="phone" id="phone"
											class="form-control" placeholder="숫자만 기입하여 주세요." value=""> 
											<span class="err">${errphone}</span>
                                    </div>
                                </div>                                
                                <div class="form-group row">
                                    <label for="email" class="col-md-4 col-form-label text-md-right">이메일 주소</label>
                                    <div class="col-md-6">
                                        <input type="text" id="email" class="form-control" name="email">
                                    </div>
                                </div>
                                 <div class="form-group row">
                                    <label for="zip_code" class="col-md-4 col-form-label text-md-right">우편번호</label>
                                    <div class="col-md-6">
                                      <input type="text" name="fakezipcode" id="fakezipcode"
										class="form-control" disabled="disabled" placeholder="우편 번호"
										value=""> <input type="hidden" name="zipcode"
										id="zipcode" value="">
                                    </div>
											<div class="col-xs-<%=1%> col-lg-<%=1%>" align="left">
												<input type="button" class="btn btn-info" value="우편 번호 찾기"
													onclick="findZipcode();">
											</div>
											<span class="err">${errzipcode}</span>                                    
                                </div>                         
                                <div class="form-group row">
                                    <label for="present_address" class="col-md-4 col-form-label text-md-right">주소</label>
                                    <div class="col-md-6">
										<input type="text" name="fakeaddress1" id="fakeaddress1"
											class="form-control" disabled="disabled" placeholder="주소"
											value=""> <input type="hidden" name="address1"
											id="address1" value=""> <span class="err">${erraddress1}</span>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="permanent_address" class="col-md-4 col-form-label text-md-right">상세주소</label>
                                    <div class="col-md-6">
                                       			<input type="text" name="address2" id="address2"
													class="form-control" placeholder="세부 주소" value="">
												<span class="err">${erraddress2}</span>
                                    </div>
                                </div>
							


                                 <div class="col-md-6 offset-md-4">
                                        <button type="submit" class="btn btn-primary" onclick="return checkForm();">>
                                        가입하기
                                        </button>                                 
                                 </div>
                                 </form>
                               </div>
                           
                        </div>
                    </div>
            </div>           
        </div>

	<script type="text/javascript">
		$(document).ready(function() {
			//alert('dd') ;
			$(".datepicker").datepicker();
			$("#spanid").addClass('good-result');
		});
	</script>
</body>
</html>
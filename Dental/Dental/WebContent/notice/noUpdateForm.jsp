<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/header.jsp"%>
<%
	int myoffset = 2;
	int mywidth = twelve - 2 * myoffset;
	int formleft = 3 ;
	int formright = twelve - formleft ; 
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>BootStrap Sample</title>
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
	</style>
</head>
<body>
	<br><br><br>
	<br><br><br>
	<div class="container col-sm-offset-<%=myoffset%> col-sm-<%=mywidth%>">
		<div class="panel panel-default panel-primary">
			<div class="panel-heading">
				<h4>공지사항 수정</h4>
				<hr>
			</div>
			<div class="panel-body">
				<form class="form-horizontal" role="form" action="<%=YesForm%>"  method="post">
					<input type="hidden" name="command" value="noUpdate">
					<input type="hidden" name="pageNumber" value="${param.pageNumber}">
					<input type="hidden" name="pageSize" value="${param.pageSize}">
					<input type="hidden" name="mode" value="${param.mode}">
					<input type="hidden" name="keyword" value="${param.keyword}">
					<div class="form-group">
						<div class="col-sm-<%=formright%>">
							<input type="hidden" class="form-control" name="fakeno" id="fakeno"								
								placeholder="글번호" value="${bean.no}" disabled="disabled">
							<input type="hidden" name="no" id="no" value="${bean.no}">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="writer">작성자</label>
						<div class="col-sm-<%=formright%>">
							<input type="text" class="form-control" name="fakewriter" id="fakewriter"								
								placeholder="작성자" value="${bean.writer}" disabled="disabled">
							<input type="hidden" name="writer" id="writer" value="${bean.writer}">
							<span class="err">${errwriter}</span>							 
						</div>
					</div>					
					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="title">제목</label>
						<div class="col-sm-<%=formright%>">
							<input type="text" class="form-control" name="title" id="title"								
								placeholder="제목" value="${bean.title}">
								<span class="err">${errtitle}</span>								
						</div>
					</div>					
					<div class="form-group">
						<div class="col-sm-<%=formright%>">
							<input type="hidden" class="form-control" name="password"
								id="password" placeholder="비밀 번호를 넣어 주셔용^^" value="${bean.password}">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="content">공지 내용</label>
						<div class="col-sm-<%=formright%>">
							<textarea name="content" id="content" rows="5" cols="" 
								placeholder="상담 내용" class="form-control">${bean.content}</textarea>
								<span class="err">${errcontent}</span>								
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-6">
							<button class="btn btn-primary" type="submit">수정하기</button>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<button class="btn btn-primary" type="button" onclick="gotoBack();">취소</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
<script>
function gotoBack(){
	location.href='<%=NoForm%>noList&${requestScope.parameters}';
}
</script>
</body>
</html>
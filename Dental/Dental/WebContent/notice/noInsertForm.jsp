<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/header.jsp"%>
<%
	int myoffset = 2;
	int mywidth = twelve - 2 * myoffset;
	int formleft = 3;
	int formright = twelve - formleft;
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
	 	margin-left: auto;
		margin-right: auto;
		border-style: inset;
		border-width: 1.5px;
	}
	</style>
</head>
<body>
	<br><br><br>
	<br><br><br>
	<div class="container col-sm-offset-<%=myoffset%> col-sm-<%=mywidth%>">
		<div class="panel panel-default panel-primary">
			<div class="panel-heading">
				<h4>공지사항 등록</h4>
			</div>
			<hr>
			<div class="panel-body">
				<form class="form-horizontal" role="form" action="<%=YesForm%>"
					method="post">
					<input type="hidden" name="command" value="noInsert">
					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="writer">작성자</label>
						<div class="col-sm-<%=formright%>">
							<input type="text" class="form-control" name="fakewriter" id="fakewriter"
								placeholder="작성자" value="${sessionScope.loginfo.name}(${sessionScope.loginfo.id})" disabled="disabled">
							<input type="hidden" name="writer" id="writer"
								value="${sessionScope.loginfo.id}">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="title">제목</label>
						<div class="col-sm-<%=formright%>">
							<input type="text" class="form-control" name="title"
								id="title" placeholder="제목" value="${bean.title}"> 
							<span class="err">${errtitle}</span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="content">공지 내용</label>
						<div class="col-sm-<%=formright%>">
							<textarea name="content" id="content" rows="5" cols=""
								placeholder="공지 내용" class="form-control">${bean.content}</textarea>
							<span class="err">${errcontent}</span>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-6">
							<button class="btn btn-primary" type="submit">새글 쓰기</button>
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
</html>
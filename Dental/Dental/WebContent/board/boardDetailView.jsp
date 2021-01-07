<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<%
	int myoffset = 2;
	int mywidth = twelve - 2 * myoffset;
	int formleft = 3;
	int formright = twelve - formleft;
	int mysearch = 2;
	//int label = 3 ; //양식의 왼쪽에 보여지는 라벨의 너비 
	//int content = twelve - label ; //우측의 내용 입력(input, select, textarea)의 너비
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
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
		
		h2{
		  padding-right: 600px;
		}
	</style>
</head>
<body>
	<br><br><br>
	<br><br><br>
	<div class="container col-sm-offset-<%=myoffset%> col-sm-<%=mywidth%>">
		<div class="panel panel-default panel-primary">
			<div class="panel-heading">
				<form class="form-inline" role="form">
					<h2>게시물 목록</h2>
				<div align="right">
					<c:if test="${whologin == 2 && bean.reply == '미완료'}">
						<a href="<%=NoForm%>boReply&no=${bean.no}&${requestScope.parameters}&groupno=${bean.groupno}&orderno=${bean.orderno}&depth=${bean.depth}">
						    <button type="button" class="btn btn-default btn-warning">답변하기</button>
						</a>
					</c:if>
				</div> &nbsp;
				<div align="right">
					<c:if test="${bean.reply == '미완료'}">
						<a href="<%=NoForm%>boUpdate&no=${bean.no}&${requestScope.parameters}">
						    <button type="button" class="btn btn-default btn-warning">수정</button>
						</a>
					</c:if>
				</div> &nbsp;
				<div align="right">
					<c:if test="${bean.reply == '미완료'}">
					<a href="<%=NoForm%>boDelete&no=${bean.no}&${requestScope.parameters}">
					    <button type="button" class="btn btn-default btn-warning">삭제</button>
					</a>
					</c:if>
				</div>
				</form>
			</div>
			<table class="table table-striped table-hover">
					<tr>
						<td>
							<c:if test="${bean.reply == '미완료'}">
								<span class="badge badge-dark">${bean.reply}</span>
							</c:if>
							<c:if test="${bean.reply == '답변 완료'}">
								<span class="badge badge-info">${bean.reply}</span>
							</c:if>
						<td>
							${bean.title}
						</td>
						<td>
							<c:if test="${whologin == 2}">
								<a class="dark" href="#">
									${bean.writer}
								</a>
							</c:if>
							<c:if test="${whologin != 2}">
								<p class="gray">${bean.writer}</p>
							</c:if>
						</td>
						<td>${bean.regdate}</td>
					</tr>
			</table>
		</div>
	</div>
</body>
</html>
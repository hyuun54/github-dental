<%@page import="mypkg.dao.BoardDao"%>
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
	<title>상담 게시판</title>
	<style type="text/css">
		.xxx {
			margin-left: 0px;
		}
		.re{font-size: 11px;}
		.dark{color: #343a40;}
		.gray{color: #6c757d;}
		thead{
			background-color: #6c757d;
			color: #fff;
		}
	</style>
	<script type="text/javascript">
		function writeForm(){
				location.href='<%=NoForm%>boInsert';
		}
		function search(){
			if( $('#mode').val() == 'all' ){ // val() : value속성 읽기
				alert('검색 목록을 선택해주세요') ;
				//$('#mode').focus();
			}else{
				//alert('하하') ;
			}
			//alert( $('#mode').val() );
		}
		function searchAll(){
			//$('#mode').val('-');
			//$('#keyword').val('');
			location.href='<%=NoForm%>boCounselList';
		}
	</script>	
</head>
<body>
	<br><br><br>
	<br><br><br>
	<div class="container col-sm-offset-<%=myoffset%> col-sm-<%=mywidth%>">
		<div class="panel panel-default panel-primary">
			<div class="panel-heading">
				<h2 class="section-heading text-uppercase">온라인 상담</h2>
			</div>
			<table class="table table-hover">
				<thead>
					<tr>
						<th width="10%"></th>
						<th width="60%">제목</th>
						<th width="10%">작성자</th>
						<th width="12%">작성 일자</th>
						<th width="8%">답변</th>
					</tr>
				</thead>
				<tr>
					<td colspan="8" align="center">
						<form class="form-inline" role="form" name="myform" action="<%=YesForm%>" method="get">
							<input type="hidden" name="command" value="boCounselList">
							<div class="form-group">
								<select class="form-control" name="mode" id="mode">
									<option value="all" selected="selected">-- 선택하세요---------
									<option value="writer" >작성자
									<option value="title" >제목									
									<option value="content" >글 내용									
								</select>
							</div>
							<div class="form-group">
								<input type="text" class="form-control btn-xs" name="keyword"
									id="keyword" placeholder="검색 키워드">
							</div>
							<button class="btn btn-default btn-warning" type="submit" onclick="search();">검색</button>
							&nbsp;
							<button class="btn btn-default btn-warning" type="button" onclick="searchAll();">전체 검색</button>
							&nbsp;
							<button class="btn btn-default btn-warning" type="button"
								onclick="writeForm();">글 쓰기</button>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</form>
					</td>
				</tr>				
			<c:forEach var="bean" items="${requestScope.lists}">
				<tr>
					<td>
						<c:if test="${bean.reply == '미완료'}">
							<span class="badge badge-dark">${bean.reply}</span>
						</c:if>
						<c:if test="${bean.reply == '답변 완료'}">
							<span class="badge badge-info">${bean.reply}</span>
						</c:if>
					<td>
						<c:forEach var="cnt" begin="1" end="${bean.depth}">
							<span class="badge btn-secondary">re</span>
						</c:forEach>
						<a class="dark" href="<%=NoForm%>boDetailView&no=${bean.no}&${requestScope.parameters}">
							${bean.title}
						</a>
					</td>
					<td>
						<c:if test="${whologin == 2}">
							<a class="dark" href="<%=NoForm%>meDetailView&id=${bean.writer}">
								${bean.writer}
							</a>
						</c:if>
						<c:if test="${whologin != 2}">
							<p class="gray">${bean.writer}</p>
						</c:if>
					</td>
					<td>${bean.regdate}</td>
					<td>
						<c:if test="${whologin == 2 && bean.reply == '미완료'}">
							<a class="dark" href="<%=NoForm%>boReply&no=${bean.no}&${requestScope.parameters}&groupno=${bean.groupno}&depth=${bean.depth}">
								답변 
							</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
		</div>
			<footer>${requestScope.pagingHtml}</footer>			
	</div>
	<br><br><br><br>
	<script type="text/javascript">
	   /* 방금 전 선택한 콤보 박스를 그대로 보여 주기 */ 
		$('#mode option').each(function (index){
			if( $(this).val() == '${requestScope.mode}' ){
				$(this).attr('selected', 'selected') ;
			}
		});	
		/* 이전에 넣었던 값 그대로 보존 */
		$('#keyword').val( '${requestScope.keyword}' ) ;		
	</script>
</body>
</html>
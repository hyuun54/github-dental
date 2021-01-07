<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>진료 시간 안내</title>
</head>
<body>
	<br><br><br>
	<br><br><br>
		<div align="center">
			<h3>요일별 진료시간 안내</h3>
			<table border="1">
					<colgroup>
						<col class="col-day" />
						<col class="col-morning" />
						<col class="col-afternoon" />
						<col class="col-evening" /> 
					</colgroup>
					<thead>
						<tr>
							<th scope="col">과목</th>
							<th scope="col">보철과</th>
							<th scope="col">교정과</th>
							<th scope="col">보존과</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">월-금</th>
							<td style="text-align: center;">오전 9:30~오후 6:30</td>
							<td style="text-align: center;">오전 10:00~오후 6:30</td>
							<td style="text-align: center;">오전 10:00~오후 6:30</td>
						</tr>
						<tr>
							<th scope="row">토요일</th>
							<td style="text-align: center;">오전 9:30~오후 1:00</td>
							<td style="text-align: center;">오전 9:30~오후 4:00</td>
							<td style="text-align: center;">오전 9:30~오후 4:00</td>
						</tr>
						<tr>
							<th scope="row">점심시간</th>
							<td style="text-align: center;" colspan="3">오후 1:00~오후 2:00</td>
						</tr>
						<tr>
							<th scope="row">야간</th>
							<td style="text-align: center;">진료없음</td>
							<td style="text-align: center;">오후 7:00~오후 9:00</td>
							<td style="text-align: center;">오후 7:00~오후 9:00</td>
						</tr>
						<tr>
							<th scope="row">일요일</th>
							<td style="text-align: center;" colspan="3">휴진</td>
						</tr>
						<tr>
							<th scope="row">공휴일</th>
							<td style="text-align: center;" colspan="3">평일과 동일</td>
						</tr>
					</tbody>
				</table>
		</div>
		<div align="center">
			<h3>의사별 진료시간 안내</h3>
			<table border="1">
						<colgroup>
							<col class="col-speciality">
							<col class="col-specialist">
							<col class="col-mon morning">
							<col class="col-mon afternoon">
							<col class="col-tue morning">
							<col class="col-tue afternoon">
							<col class="col-tue evening">
							<col class="col-wed morning">
							<col class="col-wed afternoon">
							<col class="col-wed evening">
							<col class="col-thu morning">
							<col class="col-thu afternoon">
							<col class="col-thu evening">
							<col class="col-fri morning">
							<col class="col-fri afternoon">
							<col class="col-sat morning">
							<col class="col-sat afternoon">
						</colgroup>
						<thead>
							<tr class="timeWeek">
								<th rowspan="2">진료과</th>
								<th rowspan="2">진료의</th>
								<th colspan="2">월</th>
								<th colspan="3">화</th>
								<th colspan="3">수</th>
								<th colspan="3">목</th>
								<th colspan="2">금</th>
								<th colspan="2">토</th>
							</tr>
							<tr class="timeDay">
								<th>오전</th>
								<th>오후</th>
								<th>오전</th>
								<th>오후</th>
								<th class="evening">야간</th>
								<th>오전</th>
								<th>오후</th>
								<th class="evening">야간</th>
								<th>오전</th>
								<th>오후</th>
								<th class="evening">야간</th>
								<th>오전</th>
								<th>오후</th>
								<th>오전</th>
								<th>오후</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th rowspan="4">치과
								<br>
								보철과</th>
								<td scope="row">이정택 원장</td>
								<td class="work"></td><td class="work"></td><td class="work"></td><td class="work"></td><td class="holiday evening"></td><td class="work"></td><td class="work"></td><td class="holiday evening"></td><td class="work"></td><td class="work"></td><td class="holiday evening"></td><td class=""></td><td class=""></td><td class=""></td><td class=""></td>
							</tr>
							<tr>
								<td scope="row">노현기 원장</td>
								<td class="work"></td><td class="work"></td><td class="work"></td><td class="work"></td><td class="holiday evening"></td><td class="work"></td><td class="work"></td><td class="holiday evening"></td><td class="work"></td><td class="work"></td><td class="holiday evening"></td><td class=""></td><td class=""></td><td class="work"></td><td class=""></td>		</tr>
							<tr>
								<td scope="row">백상현 원장</td>
								<td class="work"></td><td class="work"></td><td class="work"></td><td class="work"></td><td class="holiday evening"></td><td class="work"></td><td class="work"></td><td class="holiday evening"></td><td class="work"></td><td class="work"></td><td class="holiday evening"></td><td class=""></td><td class=""></td><td class=""></td><td class=""></td>		</tr>
							<tr>
								<td scope="row">손병섭 원장</td>
								<td class="work"></td><td class="work"></td><td class="work"></td><td class="work"></td><td class="holiday evening"></td><td class="work"></td><td class="work"></td><td class="holiday evening"></td><td class="work"></td><td class=""></td><td class="holiday evening"></td><td class=""></td><td class=""></td><td class=""></td><td class=""></td>		</tr>
							<tr>
								<th>치과
								<br>
								교정과</th>
								<td scope="row">허재식 원장</td>
								<td class="work"></td><td class="work"></td><td class="work"></td><td class="work"></td><td class="work evening"></td><td class="work"></td><td class="work"></td><td class="holiday evening"></td><td class=""></td><td class="work"></td><td class="work evening"></td><td class=""></td><td class=""></td><td class=""></td><td class=""></td>		</tr>
									<tr>
								<th>치과
								<br>
								보존과</th>
								<td scope="row">이종호 원장</td>
								<td class="work"></td><td class="work"></td><td class="work"></td><td class="work"></td><td class="holiday evening"></td><td class=""></td><td class=""></td><td class="holiday evening"></td><td class="work"></td><td class="work"></td><td class="holiday evening"></td><td class=""></td><td class=""></td><td class=""></td><td class=""></td>		</tr>
						</tbody>
			</table>
		</div>
		<div align="center">
			<h3>대표번호</h3>
			<table border="1">
				<colgroup>
					<col class="col-counsel" />
					<col class="col-fax" /> </colgroup>
				<thead>
					<tr>
						<th>접수/예약/상담</th>
						<th>FAX</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>02) 512-0700</td>
						<td>02) 515-0075</td>
					</tr>
				</tbody>
			</table>
		</div>
</body>
</html>
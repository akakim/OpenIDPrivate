<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 시작.</title>

</head>

<body>
	<h1>MVC 게시판을 위한 초석 . </h1>
	<table style="border: 1px solid #ccc">
		<colgroup>
			<col width="10%"/>
			<col width="*"/>
			<col width="15%"/>
			<col width="20%"/>						
		</colgroup>
		
		<thead>
			<tr>
				<th scope="col">글 번호  </th>
				<th scope="col">제목 </th>
				<th scope="col">조회수 </th>
				<th scope="col">작성일 </th>								
			</tr>
		</thead>
		<tbody>
			<% List<Map<String,Object>> list = (List<Map<String,Object>>)request.getAttribute("sampleBoard"); %>		
			<%-- <c:forEach var="item" itmes="${list}" begin=0 end="${list.size}" varStatus="status">
					<tr>
						<th scope="col">${item.begin }  </th>
						<th scope="col">${begin}</th>
						<th scope="col">조회수 </th>
						<th scope="col">작성일 </th>
					</tr>

			</c:forEach> --%>
			<!--
									<th>${status.count}
			    이름 : ${item.name}
			    나이 : ${item.age}
			    주소 : ${item.addr}  
			-->		
		</tbody>
		
	</table>
	
	
	
</body>
</html>
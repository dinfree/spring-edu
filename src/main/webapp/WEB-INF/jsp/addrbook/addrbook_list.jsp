<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="addrbook_error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<link rel="stylesheet" href="/css/addrbook.css" type="text/css" media="screen" />

<script type="text/javascript">
	function check(ab_id) {
		pwd = prompt('수정/삭제 하려면 비밀번호를 넣으세요');
		document.location.href="/addrbook/edit/"+ab_id;
	}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주소록:목록화면</title>

</head>

<body>
<div align="center"> 
<H2>주소록:목록화면</H2>
<HR>
<form>
<a href="/addrbook/form">주소록 등록</a><P>

		<table border="1">
			<tr><th>번호</th><th>이 름</th><th>전화번호</th><th>생 일</th><th>회 사</th><th>메 모</th></tr>
			<c:forEach items="${page.content}" var="ab">
			  <tr>
			   <td><a href="javascript:check(${ab.ab_id})">${ab.ab_id}</a></td>
				<td>${ab.ab_name}</td>
				<td>${ab.ab_tel}</td>
				<td>${ab.ab_birth}</td>
				<td>${ab.ab_comdept}</td>
				<td>${ab.ab_memo}</td>
			  </tr>
			</c:forEach>
		</table>
</form>
<BR>
<%@include file="/WEB-INF/jsp/addrbook/paginationbar.jsp" %>
</div>
</body>
</html>
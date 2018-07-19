<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="addrbook_error.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<link rel="stylesheet" href="/css/addrbook.css" type="text/css" media="screen" />

<script type="text/javascript">
	function delcheck() {
		result = confirm("정말로 삭제하시겠습니까 ?");
	
		if(result == true){
			location.replace("/addrbook/delete/${addrbook.ab_id}");
		}
		else
			return;
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주소록:수정화면</title>
</head>

<body>
<div align="center">
<H2>주소록:수정화면 </H2>
<HR>
[<a href=/addrbook/>주소록 목록으로</a>] <p>
<form name=form1 method=post action=/addrbook/update>
<table border="1">
  <tr>
    <th>이 름</th>
    <td><input type="text" name="ab_name" value="${addrbook.ab_name}"></td>
  </tr>
  <tr>
    <th>email</th>
    <td><input type="text" name="email" value="${addrbook.email}"></td>
  </tr>
    <tr>
    <th>전화번호</th>
    <td><input type="text" name="tel" value="${addrbook.tel}"></td>
  </tr>
      <tr>
    <th>생 일</th>
    <td><input type="date" name="birth" value="${addrbook.birth}"></td>
  </tr>
  <tr>
    <th>회 사</th>
    <td><input type="text" name="comdept" value="${addrbook.comdept}"></td>
  </tr>
  <tr>
    <th>메 모</th>
    <td><input type="text" name="memo" value="${addrbook.memo}"></td>
  </tr>
  <tr>
    <td colspan=2 align=center><input type=submit value="저장"><input type=reset value="취소"><input type="button" value="삭제" onClick="delcheck()"></td>
</tr>
</table>
</form>

</div>
</body>
</html>
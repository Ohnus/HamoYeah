<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>





<form action="${pageContext.request.contextPath }/review/edit.do" method="post" enctype="multipart/form-data">
<table border="1">
<tr><th>�ۼ���</th><td><input type="text" name="writer" id="member_id" value="${sessionScope.loginId}" readonly></td></tr>
<tr><th>�±�</th><td><input type="text" name="tag" id="tag" value="${tag }"></td></tr>
<tr><th>�۳���</th><td><textarea rows="10" cols="100" name="content" id="${content }"></textarea></td></tr>
<tr><th>�̹���</th>
<td><input type="file" id="imagepath" name="imagepath"> 


</td></tr>
<tr><th>�ۼ�</th><td>
	<input type="submit" value="�����Ϸ�"> <!-- ���崩���� post�� ����-->
	<a href="${pageContext.request.contextPath }/board/participateList.do"><input type="button" value="�������"></a></td></tr>

</table>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
//���� ���ε� �̸�����
function thumbnail(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			document.getElementById('preview').src = e.target.result;
		};
		reader.readAsDataURL(input.files[0]);
	} else {
		document.getElementById('preview').src = e.target.result;
	}
}
function imgReset() {
	document.getElementById('preview').src = "../img/nopic.jpg";
	document.getElementById('imgpath').value = null;
}
</script>
</head>
<body>
<form action="${pageContext.request.contextPath }/review/edit.do" method="post" enctype="multipart/form-data">
<table border="1">
<tr><th>�ۼ���</th><td>
<input type="hidden" value="${vo.reviewNum }" name="reviewNum">
<input type="text" name="writer" id="member_id" value="${sessionScope.loginId}" readonly>
</td></tr>
<tr><th>�±�</th><td><input type="text" name="tag" id="tag" value="${vo.tag }" readonly></td></tr>
<tr><th>�۳���</th><td><textarea rows="10" cols="100" name="content">${vo.content }</textarea></td></tr>
<tr><th>�̹���</th>
<td><input type="file" id="imagepath" name="imagepath" accept="image/jpeg,image/jpg,image/png" onchange="thumbnail(this);">
<img src="${vo.imagepath }" id="preview" style="width: 200px; height: 200px"><br />
<input type="button" value="����" id="del" onclick="imgReset();">
</td></tr>
<tr><th>�ۼ�</th><td>
	<input type="submit" value="�����Ϸ�"> <!-- ���崩���� post�� ����-->
	<input type="button" value="�������" onclick="location.href='${pageContext.request.contextPath }/review/detail.do?reviewNum=${vo.reviewNum}'"></td></tr>

</table>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<%@ include file="/menu/header.jsp"%></div>

	<div>
		<c:if test="${not empty view }">
			<jsp:include page="${view }" />
		</c:if>
	</div>
	<div>
		<%@ include file="/menu/tail.jsp"%></div>
</body>
</html>
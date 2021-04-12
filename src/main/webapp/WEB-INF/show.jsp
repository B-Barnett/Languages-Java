<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
	<body>
		<a href="/languages">HOME</a>
		<h1><c:out value="${language.name}"></c:out></h1>
		<p><c:out value="${language.creator}"></c:out></p>
		<p><c:out value="${language.version}"></c:out></p>
		<a href="/languages/${language.id}/edit">Edit</a>
		<form action="/languages/${lang.id}" method="POST">
			<input type="hidden" name="_method" value="delete">
			<input type="submit" value="Delete">
		</form>
	</body>
</html>
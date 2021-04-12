<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
	<body>
		<h1>All Languages</h1>
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Creator</th>
					<th>Version</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${languages}" var="lang">
				<tr>
					<td><a href="/languages/${lang.id}"><c:out value="${lang.name}"></c:out></a></td>
					<td><c:out value="${lang.creator}"></c:out></td>
					<td><c:out value="${lang.version}"></c:out></td>
					<td>
						<a href="/languages/${lang.id}/edit">Edit</a>
						<br/>
						<form action="/languages/${lang.id}" method="POST">
							<input type="hidden" name="_method" value="delete">
							<input type="submit" value="Delete">
						</form>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<br/>
		<form:form action="/languages" method="POST" modelAttribute="language">
			<p>
				<form:label path="name">Name</form:label>
				<form:errors path="name"/>
				<form:input path="name"/>
			</p>
			<p>
				<form:label path="creator">Creator</form:label>
				<form:errors path="creator"/>
				<form:input path="creator"/>
			</p>
			<p>
				<form:label path="version">Version</form:label>
				<form:errors path="version"/>
				<form:input path="version"/>
			</p>
			<input type="submit" value="Submit"/>
		</form:form>
	</body>
</html>
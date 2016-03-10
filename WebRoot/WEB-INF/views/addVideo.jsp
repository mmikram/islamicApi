<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Add Employee Data</h2>
	<form:form method="GET" action="/IslamicInfoServer/saveVideo.html">
		<table>
			<tr>
				<td><form:label path="vId">Video ID:</form:label></td>
				<td><form:input path="vId" value="${video.vId}" readonly="true" /></td>
			</tr>
			<tr>
				<td><form:label path="vKey">Video Key Name:</form:label></td>
				<td><form:input path="vKey" value="${video.vKey}" /></td>
			</tr>
			<tr>
				<td><form:label path="title">Maulana Name:</form:label></td>
				<td><form:input path="title" value="${video.title}" /></td>
			</tr>
			<tr>
				<td><form:label path="maulanaName">Title:</form:label></td>
				<td><form:input  path="maulanaName" value="${video.title}" /></td>
			</tr>
			
			<tr>
				<td><form:label path="date">Date:</form:label></td>
				<td><form:input path="date" value="<%= new java.util.Date().getTime() %>" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>

	<c:if test="${!empty videos}">
		<h2>List Videos</h2>
		<table align="left" border="1">
			<tr>
				<th>Video ID</th>
				<th>Video Key</th>
				<th>Video Title</th>
				<th>Maulana Name</th>
				<th>Date</th>
			</tr>

			<c:forEach items="${videos}" var="video">
				<tr>
					<td><c:out value="${video.vId}" /></td>
					<td><c:out value="${video.vKey}" /></td>
					<td><c:out value="${video.maulanaName}" /></td>
					<td><c:out value="${video.title}" /></td>
					<td><c:out value="${video.date}" /></td>
					<td align="center"><a href="edit.html?id=${vId.mId}">Edit</a>
						| <a href="delete.html?id=${vId.mId}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
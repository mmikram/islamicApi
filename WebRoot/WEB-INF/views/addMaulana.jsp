<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC Form Handling</title>
</head>
<body>
	<h2>Add Employee Data</h2>
	<form:form method="GET" action="/IslamicInfoServer/save.html">
		<table>
			<tr>
				<td><form:label path="mId">Maulana ID:</form:label></td>
				<td><form:input path="mId" value="${maulana.mId}" readonly="true" /></td>
			</tr>
			<tr>
				<td><form:label path="mName">Maulana Name:</form:label></td>
				<td><form:input path="mName" value="${maulana.mName}" /></td>
			</tr>
			<tr>
				<td><form:label path="imageLink">Image Link:</form:label></td>
				<td><form:input path="imageLink" value="${maulana.imageLink}" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>

	<c:if test="${!empty maulanas}">
		<h2>List Maulana</h2>
		<table align="left" border="1">
			<tr>
				<th>Maulana ID</th>
				<th>Maulana Name</th>
				<th>Image Link</th>
			</tr>

			<c:forEach items="${maulanas}" var="maulana">
				<tr>
					<td><c:out value="${maulana.mId}" /></td>
					<td><c:out value="${maulana.mName}" /></td>
					<td><c:out value="${maulana.imageLink}" /></td>
					<td align="center"><a href="edit.html?id=${maulana.mId}">Edit</a>
						| <a href="delete.html?id=${maulana.mId}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>



<html>
<head>
<style>
table, th, td {
	border: 1px solid black;
}
</style>




</head>
<body>

	<h1>View all contacts</h1>
	<table>
		<caption>
			<a href="/savecontact">+Add Contact</a>
		</caption>

		<thead>
			<tr>
				<th>Sno</th>
				<th>Name</th>
				<th>Mail</th>
				<th>Number</th>
				<th>Action</th>

			</tr>
		</thead>
		<tbody>

			<c:forEach items="${contacts}" var="co" varStatus="count">
				<tr>
					<td>${count.index+1}</td>
					<td>${co.contact_name }</td>
					<td>${co.email }</td>
					<td>${co.mobileNumber}</td>
					<td><a href="/edit?contact_id=${co.contact_id }">EDIT</a> <a
						onclick="return confirm('Are you sure you want to Remove?');"
						 href="/delete?contact_id=${co.contact_id}  ">DELETE</a></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

	<c:if test="${curno>1 }">

		<a href="viewcontacts?pno=${curno-1}">previous</a>

	</c:if>

	<c:forEach begin="1" end="${pno}" var="pageno">
	
	
	<c:choose>
	
	<c:when test="${curno==pageno }"> ${pageno}</c:when>
	<c:otherwise><a href="viewcontacts?pno=${pageno}">${pageno}</a></c:otherwise>
	
	
	
	</c:choose>
		
		
	</c:forEach>
	<c:if test="${curno<pno}">

		<a href="viewcontacts?pno=${curno+1}">next</a>

	</c:if>


</body>
</html>


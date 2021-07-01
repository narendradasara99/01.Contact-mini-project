<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	
</script>
</head>
<h1>Contact Save form</h1>


<body>

	<form:form action="savecontact" modelAttribute="contact" method="POST">
		<table>
			<tr>

				<td><form:hidden path="contact_id" /></td>
			</tr>
			<tr>
				<td>Contact Name</td>
				<td><form:input path="Contact_name" /></td>
			</tr>
			<tr>
				<td>Contact Email</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Contact Number</td>
				<td><form:input path="mobileNumber" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="save" value="Save"></td>
			</tr>


		</table>

		<a href="/viewcontacts">view all contacts</a>

	</form:form>

	${msg}

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
	<tr>
		<th>LUGAR</th>
		<th>DIAS</th>
		<th>KMS</th>
	</tr>
	<tr>
		<form method="post" action="/editarViaje">
			<td><input type="text" name="lugar" value="${viajeedit.lugar }" readonly="readonly"></td>
			<td><input type="number" name="dias" value="${viajeedit.dias }"></td>
			<td><input type="number" name="kms" value="${viajeedit.kms }"></td>
			<td><input type="submit" name="editviaje" value="CAMBIAR"></td>
		</form>
	</tr>
</table>
</body>
</html>
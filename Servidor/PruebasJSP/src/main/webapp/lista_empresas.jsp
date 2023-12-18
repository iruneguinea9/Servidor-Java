<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<c:choose>
	<c:when test="${applicationScope.mapa_empresas==null}" >
		<jsp:forward page="ServletEmpresa?listaempresas"></jsp:forward>
	</c:when>
	<c:otherwise>
		<table>
		<tr><th>Empresa</th><th>Beneficio</th><th>Trabajadores</th>
		<c:forEach items="${applicationScope.mapa_empresas}" var="par">
			<tr>
				<td><c:out value="${par.key}"></c:out></td>
				<td><c:out value="${par.value.beneficio} "></c:out></td>
				<td><c:out value="${par.value.trabajadoresUtiles().size() } trabs"></c:out></td>
				</tr>
		</c:forEach>
		</table>
	
	</c:otherwise>
</c:choose>

	
</body>
</html>
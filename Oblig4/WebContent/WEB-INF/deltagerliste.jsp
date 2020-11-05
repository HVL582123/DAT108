<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Deltagerliste</title>
</head>
<body>
	<h2>Deltagerliste</h2>
	<table class="pure-table">
		<tr bgcolor="#cccccc">
			<th>Kjønn</th>
			<th align="left">Navn</th>
			<th align="left">Mobil</th>
		</tr>
	<c:forEach items="${listePaameldte}" var="p">
		<tr bgcolor=${p.mobilnr == bruker.mobilnr ? "#aaffaa" : "#ffffff"} >
			<td align="center"> 
			${p.kjonn == 'kvinne' ? '&#9792' : '&#9794'}</td>
			<td>${p.fnavn}   ${p.enavn}</td>
			<td>${p.mobilnr}</td>
		</tr>
		</c:forEach>
	</table>
	<p>
		<a href="FerdigServlet">Ferdig</a>
	</p>
</body>
</html>
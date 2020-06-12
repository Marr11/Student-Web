<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/StudentWeb/vezbaBaza/unesiStudenta.jsp" method="post">
Ime: <input type="text" name="ime"></br>
Prezime: <input type="text" name="prezime"></br>
Godina fakulteta : <input type="text" name="godinaFakulteta"></br>
Broj indeksa: <input type="text" name="brojIndeksa"></br>
<input type = "submit" value = "register" />
</form>
</body>
</html>
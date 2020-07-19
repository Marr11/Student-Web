<%@ page language="java" import= "com.skolamaric.model.User"  contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu page</title>
</head>
<body>

<%

	User user = (User)request.getSession().getAttribute("user");
	out.write("Prijavljeni korisnik: "+user.getUsername());


%>

<a href="/StudentWeb/vezbaSecurity/logout.html">LOGOUT</a>
</body>
</html>
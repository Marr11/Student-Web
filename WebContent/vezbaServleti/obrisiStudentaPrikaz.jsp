<%@ page import="java.util.*, com.skolamaric.servis.AdministriranjeStudenata, com.skolamaric.model.Student" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
	String brojIndeksa = request.getParameter("id");
	//brojIndeksa = (String)request.getAttribute("brojIndeksa");	
	out.write("Student je obrisan!");
%>
</body>
</html>
<%@ page import="java.util.*, com.skolamaric.servis.AdministriranjeStudenata, com.skolamaric.model.Student" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean scope="session" id="student" class="com.skolamaric.model.Student"></jsp:useBean>  
<jsp:setProperty property="*" name="student"/> 

<%
	AdministriranjeStudenata administracija = new AdministriranjeStudenata();
	administracija.unesiStudenta(student);
	out.write("Uneli ste novog studenta u bazu.");
%>
</body>
</html>
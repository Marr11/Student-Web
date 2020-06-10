<%@ page import= "java.util.*, com.skolamaric.servis.AdministriranjeStudenata, com.skolamaric.model.Student" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	AdministriranjeStudenata administracija = new AdministriranjeStudenata();
	List<Student> studenti = administracija.dajSveStudente();
	for(Student student : studenti){
		out.write(student.getIme());
		
		out.write(student.getGodinaFakulteta().toString());
		
		out.write(student.getBrojIndeksa());
		out.write("</br>");
	}

	

	




%>
</body>
</html>
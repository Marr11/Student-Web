<%@ page import="java.util.*, com.skolamaric.servis.AdministriranjeStudenata, com.skolamaric.model.Student"  language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
	String brojIndeksa ="";
	brojIndeksa = (String)request.getAttribute("brojIndeksa");
	
	Student student = (Student)request.getAttribute("student");
    String dataTemplate = "<td>%s</td>";
	out.write("Ime: "+student.getIme());
	out.write("</br>");
	out.write("Prezime: "+student.getPrezime());
	out.write("</br>");
	out.write("Broj indeksa: "+student.getBrojIndeksa());
	out.write("</br>");
	String studentLinkTemplateDA = "<a href='/StudentWeb/vezbaServleti/obrisiStudenta.html?brojIndeksa=%s' target=_blank> DA</a>";
	String studentLinkTemplateNE = "<a href='/StudentWeb/vezbaServleti/listajStudente.html?p=1' target=_blank> NE</a>";
	String brojIndeksa1 = student.getBrojIndeksa();
	String studentLinkDA = String.format(studentLinkTemplateDA, brojIndeksa, brojIndeksa);
	String studentLinkNE = String.format(studentLinkTemplateNE, brojIndeksa, brojIndeksa);
	out.write(String.format(dataTemplate, studentLinkDA));
	out.write(String.format(dataTemplate, studentLinkNE));

	

	%>
</body>
</html>
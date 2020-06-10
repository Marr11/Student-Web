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
    String dataTemplate = "<td>%s</td>";
	String brojIndeksa1 ="";
    brojIndeksa1 = request.getParameter("id");
	AdministriranjeStudenata administracija = new AdministriranjeStudenata();
	Student student = administracija.dajStudenta(brojIndeksa1);
	out.write("Ime: "+student.getIme());
	out.write("</br>");
	out.write("Prezime: "+student.getPrezime());
	out.write("</br>");
	out.write("Broj indeksa: "+student.getBrojIndeksa());
	out.write("</br>");
	String studentLinkTemplateDA = "<a href='/StudentWeb/vezbaBaza/obrisiStudenta.jsp?id=%s' target=_blank> DA</a>";
	String studentLinkTemplateNE = "<a href='/StudentWeb/vezbaBaza/listaStudenata.jsp?p=1' target=_blank> NE</a>";
	String brojIndeksa = student.getBrojIndeksa();
	String studentLinkDA = String.format(studentLinkTemplateDA, brojIndeksa, brojIndeksa);
	String studentLinkNE = String.format(studentLinkTemplateNE, brojIndeksa, brojIndeksa);
	out.write(String.format(dataTemplate, studentLinkDA));
	out.write(String.format(dataTemplate, studentLinkNE));

	

	%>
</body>
</html>
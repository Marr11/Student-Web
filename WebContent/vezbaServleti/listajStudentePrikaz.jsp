<%@ page import="java.util.*, com.skolamaric.servis.AdministriranjeStudenata, com.skolamaric.model.Student" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listaj Studente</title>
</head>
<body>
<table border="1">
		<%
		
		int pageNumber = 1;
		try{
			pageNumber = (Integer)request.getAttribute("pageNumber");
		}catch(NumberFormatException e){
			
		}
						
		List<Student> studenti = (List<Student>)request.getAttribute("listaStudenata");
		String dataTemplate = "<td>%s</td>";
		if(studenti.size() > 0) {
			for (Student student : studenti) {
				out.write("<tr>");
				out.write(String.format(dataTemplate, student.getIme()));
				out.write(String.format(dataTemplate, student.getPrezime()));
				out.write(String.format(dataTemplate, student.getGodinaFakulteta().toString()));
				
				String studentLinkTemplate = "<a href='/StudentWeb/vezbaServleti/prikaziStudenta.html?id=%s' target=_blank >%s</a>";
				String brojIndeksa = student.getBrojIndeksa();
				String studentLink = String.format(studentLinkTemplate, brojIndeksa, brojIndeksa);
				out.write(String.format(dataTemplate, studentLink));

				out.write("</tr>");
			}
		} else {
			out.write("Nema rezultata.Vratite se na prethodnu stranu.");
			out.write("</br>");
		}
		%>
		<a href="/StudentWeb/vezbaServleti/listajStudente.html?p=<%=pageNumber - 1%>">  < </a>		
		<div > Strana: <%= pageNumber	%></div>
		<a href="/StudentWeb/vezbaServleti/listajStudente.html?p=<%=pageNumber + 1%>"> > </a>
</table>

</body>
</html>
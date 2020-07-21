<%@ page language="java" import="java.util.*,com.skolamaric.model.Student" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin home page</title>
</head>
<body>
Admin home page
<jsp:include page="menu.jsp"></jsp:include>

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
				String brojIndeksa = student.getBrojIndeksa();
				out.write("</tr>");
			}
		} else {
			out.write("Nema rezultata.Vratite se na prethodnu stranu.");
			out.write("</br>");
		}
		%>
		<a href="/StudentWeb/vezbaSecurity/adminHomeServlet.htmlp=<%=pageNumber - 1%>">  < </a>		
		<div > Strana: <%= pageNumber	%></div>
		<a href="/StudentWeb/vezbaSecurity/adminHomeServlet.htmlp=<%=pageNumber + 1%>"> > </a>
</table>
</body>
</html>
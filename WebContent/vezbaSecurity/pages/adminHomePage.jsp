<%@ page language="java" import="java.util.*,com.skolamaric.model.Student" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="/StudentWeb/vezbaSecurity/assets/css/stilovi.css">
 <script src="/StudentWeb/vezbaSecurity/assets/js/adminHome.js"> </script>
<meta charset="ISO-8859-1">
<title>Admin home page</title>
</head>
<body>

<jsp:include page="menu.jsp"></jsp:include>

 <div class="standardWidth">
	<a href="javascript:setNumberOfRows(10);">10</a>
	<a href="javascript:setNumberOfRows(20);">20</a>
	<a href="javascript:setNumberOfRows(50);">50</a>
 </div>

 <table border="1">
 	<th>Broj indeksa</th>
 	<th>Ime studenta</th>
 	<th>Prezime studenta</th>
 	<th>Godina fakulteta</th>
   
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
				out.write(String.format(dataTemplate, student.getBrojIndeksa()));
				out.write(String.format(dataTemplate, student.getIme()));
				out.write(String.format(dataTemplate, student.getPrezime()));
				out.write(String.format(dataTemplate, student.getGodinaFakulteta().toString()));
							
				out.write("</tr>");
			}
		} else {
			out.write("Nema rezultata.Vratite se na prethodnu stranu.");
			out.write("</br>");
		}
		%>
		
</table>

<jsp:include  page="paginator.jsp"> 
<jsp:param  name="servlet" value="adminHomeServlet"/>
<jsp:param  name="pageNumber" value="<%= pageNumber %>"/> 
</jsp:include>

 <jsp:include page="footer.jsp"></jsp:include>
 

</body>
</html>
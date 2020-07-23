<%@ page language="java" import= "com.skolamaric.model.User"  contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
  <div class="title  standardWidth">Administracija Studenata</div>   
    <div class="menu-header  standardWidth">

      <%
	User user = (User)request.getSession().getAttribute("user");
	out.write("Prijavljeni korisnik: "+user.getUsername());
       %>

      <a href="/StudentWeb/vezbaSecurity/logout.html">LOGOUT</a>
    </div>
  
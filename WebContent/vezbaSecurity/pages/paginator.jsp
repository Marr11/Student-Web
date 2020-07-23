<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<div class="paginator  standardWidth">
<a href="/StudentWeb/vezbaSecurity/${param.servlet}.html?p=${param.pageNumber - 1}">  < </a>		
<div class="space"> Strana: ${param.pageNumber} </div>
<a href="/StudentWeb/vezbaSecurity/${param.servlet}.html?p=${param.pageNumber + 1}"> > </a>

</div>

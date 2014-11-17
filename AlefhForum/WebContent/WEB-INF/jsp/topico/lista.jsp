<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Topicos</title>
</head>
<body>
	<a href="/AlefhForum">[home]</a>
		<form action="<c:url value="/topico/adiciona" />" method="post">
			<textarea name="topico.descricao" cols="20" rows="3"></textarea>	
		<input type="submit" value="Submit Query">
		
		</form>	
		<ol start="1">
	       <c:forEach var="topico" items="${topicoList}" >
	    	 <li><a href="<c:url value="/topico/${topico.id } "/>">${topico.dtCriacao }</a> ${topico.descricao } </li>  
	      </c:forEach>
    	</ol>
	<table>
		<tr>
		<c:forEach var="pagina" items="${paginas }">
			<td><a href="<c:url value="/topico/lista/${pagina } "/>"> ${pagina } </a></td>
		</c:forEach>
		</tr>
	</table>
</body>
<script type="text/javascript" src="<c:url value='/js/jquery-1.6.1.min.js'/>"></script>
<script type="text/javascript">
	//alert("oi");
	$.post("/AlefhForum/topico/json", function( data ) {
		console.log("oi");
		console.log(data);
	});
</script>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Topico - ${topico.descricao}</title>
</head>
<body>
	<input type="hidden" id="idTopico" value="${topico.id }" />

	<div id="listaComentarios">
		<li>${topico.descricao}<input type="submit"
			onclick="escondeExibe('formulario')" value="Responder">
			<div id="formulario" style="display: none;">
				<form action="<c:url value="/comentario/adiciona" />" method="post">
					<input type="hidden" name="comentario.idTopico"
						value="${topico.id }" /> <input type="hidden"
						name="comentario.idComentarioPai"
						value="${resposta.idComentario }" />
					<textarea name="comentario.comentario" cols="20" rows="3"></textarea>

					<input type="submit" value="Submit Query">
				</form>
			</div>
		</li>
	</div>
	<br/>
</body>
<script type="text/javascript"
	src="<c:url value='/js/jquery-1.6.1.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/util.js'/>"></script>
<script type="text/javascript">
	//alert("oi");
	var id = document.getElementById("idTopico").value;
	buscaComentarios(id);
</script>
</html>
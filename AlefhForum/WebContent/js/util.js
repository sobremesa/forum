/**
 * 
 */

function buscaComentarios(id,qtdItem){
	var url = "/AlefhForum/comentario/json/" + id;
	/*console.log("url utilizada: " + url.toString());*/
	
	$.post(url, function( data ) {
		$.each( data.list, function( i, item ) {
	       if(item.idComentarioPai == 0){
	    	   insereComentarioTopico(item);
	       }else{
//	    	   console.log("inserindo pai..");
	    	   insereComentario(item);
	       }
	    });
	});
}

function insereComentarioTopico(data){
	$("#listaComentarios").append(geraFormulario(data));
}

function insereComentario(data) {
	console.log("estou na funcao");
	var div = $("#li"+data.idComentarioPai);
	console.log(div);
	div.append("<ol>" + geraFormulario(data) + "</ol>");
}

function geraFormulario(data) {
	var chave = 'form' + data.idComentario;
	var html = "<li id='li"+data.idComentario+"'>"+ data.comentario +
	"<input type='submit' onclick=escondeExibe('"+chave+"') value='Responder'>" +
	"<div id='form"+data.idComentario+"' style='display:none ;'>" +
	"<form " + "action='/AlefhForum/comentario/adiciona'" + "method="+"post>" + 
	"<input type='hidden' name='comentario.idTopico' value='"+data.idTopico+"' />" +
	 "<input type='hidden' name='comentario.idComentarioPai' value='"+data.idComentario+"' />" +
	"<textarea name='comentario.comentario' cols='20' rows='3'></textarea>" +

	"<input type='submit' value='Submit Query'>" +
	"</form>" +
	"</div>" +
	
	"</li>"
	

	return html;
}

function escondeExibe(nome){
	console.log("nome: " + nome);
	if(document.getElementById(nome).style.display == 'none'){	
		document.getElementById(nome).style.display = '';
	}else{
		document.getElementById(nome).style.display = 'none'
	}
}


package br.com.alefh.controller;


import java.util.ArrayList;
import java.util.List;

import br.com.alefh.dao.ComentarioDAO;
import br.com.alefh.model.Comentario;
import br.com.alefh.model.Palavra;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Resource
public class ComentarioController {
	
	private Result result;
	private ComentarioDAO dao;
	private static final int MAXRESULTADO = 10;
	
	public ComentarioController(ComentarioDAO dao, Result result) {
		this.result = result;
		this.dao = dao;
	}
	
	public String validaComentario(String coment){
		
		List<Palavra> palavras  = dao.findAllPalavras();
		
		for(Palavra palavra : palavras){
			if(coment.indexOf(palavra.getPalavra()) != -1){
				coment = coment.replaceAll(palavra.getPalavra(), "xxxx");
			}
		}
		
		return coment;
	}
	@Post
	public void adiciona(Comentario comentario){
			String temp = comentario.getComentario();
			comentario.setComentario(validaComentario(temp));
			dao.adiciona(comentario);
			result.redirectTo(TopicoController.class).exibe(comentario.getIdTopico());
	}
	
	@Path("/palavra/adiciona")
	public void palavra(Palavra palavra){
		dao.adicionaPalavra(palavra);
		result.include("palavras", dao.findAllPalavras());
		result.redirectTo(PalavraController.class).lista();
		
	}
	
	@Path("/comentario/json/{id}")
	public void exibeComJson(int id){
			List<Comentario> comentarios = new  ArrayList<Comentario>();
			comentarios = dao.findAllById(id);
			result.use(Results.json()).from(comentarios).serialize();	
	}
	
}

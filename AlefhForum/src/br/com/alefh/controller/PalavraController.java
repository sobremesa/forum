package br.com.alefh.controller;

import br.com.alefh.dao.ComentarioDAO;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class PalavraController {

	private Result result;
	private ComentarioDAO dao;
	
	public PalavraController(ComentarioDAO dao, Result result) {
		this.result = result;
		this.dao = dao;
	}
	@Path("/palavra")
	public void lista(){
		result.include("palavras", dao.findAllPalavras());
	}
}

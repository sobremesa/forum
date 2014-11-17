package br.com.alefh.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.alefh.dao.TopicoDAO;
import br.com.alefh.model.Topico;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;


@Resource
public class TopicoController {
	
	private final Result result;
	private final TopicoDAO dao;
	private static final int MAXRESULTADO = 10;
	
	public TopicoController(TopicoDAO dao,Result result) {
		this.result = result;
		this.dao = dao;
	}
	
	public List<Topico> lista(){
		 Long numero =  dao.getTotal()/MAXRESULTADO;
		 
		 System.out.println("numero total do resultado: " + numero);
		 if(numero >= 0){
			 System.out.println("incluido objeto na resposta");
			result.include("paginas",geraNumeroPaginas(numero));
		 }
		 return dao.findAll(1,MAXRESULTADO);	
	}
	
	@Path("/topico/lista/{pagina}")
	public List<Topico> lista(int pagina){
		 System.out.println("numero a ser requisitado: " + pagina);
		 int primeiro = pagina * MAXRESULTADO;
		 Long numero =  dao.getTotal()/MAXRESULTADO;
		 System.out.println("total paginas: " + numero);
		 if(numero > 0){
			result.include("paginas",geraNumeroPaginas(numero));
		 }
		 return dao.findAll(primeiro,MAXRESULTADO);
	}
	
	@Post
	public void adiciona(Topico topico){
			topico.setDtCriacao(new Date());
			dao.adicionaTopico(topico);
			result.redirectTo(this).lista();
	}
	
	
	@Path("/topico/{id}")
	public Topico exibe(int id) {
		return dao.findTopico(id);
	}
	
	
	
	public ArrayList<Integer> geraNumeroPaginas(Long num){
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		
		for(int i=0;i<=num;i++){
			numeros.add(i);
		}
	 return numeros;
	}
	
	
}

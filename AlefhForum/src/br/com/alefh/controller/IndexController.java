package br.com.alefh.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;

@Resource
public class IndexController {
		
	@Path("/")
	public void root() {
		System.out.println("Vraptor está rodando");
	}
}

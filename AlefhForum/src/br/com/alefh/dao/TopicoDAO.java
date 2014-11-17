package br.com.alefh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.alefh.model.Topico;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class TopicoDAO {
	
	private Session session;
	
	public TopicoDAO(Session session) {
		this.session = session;
	}
	
	public List<Topico> findAll(int primeiroResultado, int registroPorPagina)  {  
		return session.createCriteria(Topico.class).setFirstResult(primeiroResultado).setMaxResults(registroPorPagina).list();
	}

	public void adicionaTopico(Topico topico) {
		 Transaction tx = session.beginTransaction();
	     session.save(topico);
	     tx.commit();
	}

	public Topico findTopico(int id) {
		  Query query = session.createQuery("from Topico where id = :id");
		  query.setParameter("id", id);
		  return (Topico) query.uniqueResult();
	}

	public Long getTotal() { 
		Query query = session.createQuery("select count(*) from Topico");
		
		return (Long) query.uniqueResult();
		
	}
}

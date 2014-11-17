package br.com.alefh.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.alefh.model.Comentario;
import br.com.alefh.model.Palavra;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class ComentarioDAO {

	private Session session;

	public ComentarioDAO(Session session) {
		this.session = session;
	}

	public void adiciona(Comentario comentario) {
		Transaction tx = session.beginTransaction();
		session.save(comentario);
		tx.commit();
	}
	
	public void adicionaPalavra(Palavra palavra) {
		Transaction tx = session.beginTransaction();
		session.save(palavra);
		tx.commit();
	}

	public List<Palavra> findAllPalavras() {
		return session.createCriteria(Palavra.class).list();
	}
	
	public List<Comentario> findAllById(int id) {
		//return session.createCriteria(Comentario.class).list();
		Query query = session.createQuery("from Comentario where idTopico = :idTopico");
		query.setParameter("idTopico", id);
		return query.list();
	}
}


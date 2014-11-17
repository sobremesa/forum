package br.com.alefh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Palavra {
	
	@Id @GeneratedValue
	private int idPalavra;
	
	@Column
	private String palavra;

	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}

	public int getIdPalavra() {
		return idPalavra;
	}

	public void setIdPalavra(int idPalavra) {
		this.idPalavra = idPalavra;
	}
}

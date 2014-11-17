package br.com.alefh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Comentario {
	
	@Id @GeneratedValue
	private int idComentario;
	@Column
	private int idTopico;
	@Column
	private int idComentarioPai;
	@Column
	private String comentario;
	
	
	public int getIdComentario() {
		return idComentario;
	}
	
	
	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}
	
	public int getIdTopico() {
		return idTopico;
	}
	
	public void setIdTopico(int idTopico) {
		this.idTopico = idTopico;
	}
	
	public int getIdComentarioPai() {
		return idComentarioPai;
	}
	
	public void setIdComentarioPai(int idComentarioPai) {
		this.idComentarioPai = idComentarioPai;
	}
	
	public String getComentario() {
		return comentario;
	}
	
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
}

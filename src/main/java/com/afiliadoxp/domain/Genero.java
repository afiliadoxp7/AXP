package com.afiliadoxp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "generos")
public class Genero extends AbstractEntity<Long>{

	
	@Column(length = 50, unique = true, nullable = false)
	@NotBlank(message = "Nome da categoria deve ser preenchido, Ex.: Livro, Curso, etc...")
	@Size(min = 3, max = 50, message = "Nome da categoria deve ter entre 3 e 50 letras")
	private String nome;	

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}		
}

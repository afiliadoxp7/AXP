package com.afiliadoxp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "privacidades")
public class Privacidade extends AbstractEntity <Long>{
	
	@Column(name = "privacidade", columnDefinition = "TEXT")
	private String nome;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

		
}

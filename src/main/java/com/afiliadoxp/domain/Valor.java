package com.afiliadoxp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/*
 * @OneToOne - simples
 * @OneToMany - múltiplo
 * @ManyToOne - simples
 * @ManyToMany - múltiplo
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "valores")
public class Valor extends AbstractEntity <Long>{

	@Column(name = "porcento", length = 3)
	private String nome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}


}

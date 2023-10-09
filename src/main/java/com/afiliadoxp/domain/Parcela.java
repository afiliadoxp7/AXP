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
@Table(name = "parcelas")
public class Parcela extends AbstractEntity <Long>{

	@Column(name = "parcela", length = 3)
	private String nome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}


}

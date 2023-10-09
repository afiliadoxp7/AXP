package com.afiliadoxp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "fornecedores")
public class Fornecedor extends AbstractEntity<Long>{
		
	@Column(name = "for_plataforma", nullable = false, unique = true, length = 50)
	@NotBlank(message = "Genero da categoria  deve ser preenchido, Ex.: Hotmart, Braip, etc... ")
	@Size(min = 3, max = 15, message = "No campo Plataforma deve ter entre 3 e 50 letras")
	private String nome;
	
	@NotNull(message = "Link deve ser selecionada")
	@Column(name = "for_link", nullable = false, unique = true)
	private String link;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
		
}

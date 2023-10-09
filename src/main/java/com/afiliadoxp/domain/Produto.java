package com.afiliadoxp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/*
 * @OneToOne - simples
 * @OneToMany - múltiplo
 * @ManyToOne - simples
 * @ManyToMany - múltiplo
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "produtos")
public class Produto extends AbstractEntity <Long>{
	
	@NotBlank(message = "Nome deve ser preenchido")
	@Column( name = "nome")
	private String nome;
	
	@NotNull(message = "Link deve ser selecionada")
	@Column(name = "link", nullable = false, unique = true)
	private String link;
	
	@Lob
	private byte[] imagem;
	
	@DecimalMin(value = "0.01", message = "Preço mínimo: R$ 0,01")
	@Column(name = "preco_avista")
	private double preco;
	
	public double getPrecoParcela() {
		return precoParcela;
	}

	public void setPrecoParcela(double precoParcela) {
		this.precoParcela = precoParcela;
	}

	@DecimalMin(value = "0.01", message = "Preço mínimo: R$ 0,01")
	@Column(name = "preco_parcela")
	private double precoParcela;
	
	//------------------- Muitos para Um ------------------------------
	@ManyToOne
	@NotNull(message = "Categoria deve ser selecionada")
	private Categoria categoria;
	
	@ManyToOne
	@NotNull(message = "Genero deve ser selecionada")
	private Genero genero;
	
	@ManyToOne
	@NotNull(message = "Fornecedor deve ser selecionada")
	private Fornecedor fornecedor;

	@ManyToOne
	@NotNull(message = "Valor deve ser selecionada")
	private Valor valor;
	
	@ManyToOne
	@NotNull(message = "Parcela deve ser selecionada")
	private Parcela parcela;
	//------------------- get e set ------------------------------

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

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Valor getValor() {
		return valor;
	}

	public void setValor(Valor valor) {
		this.valor = valor;
	}

	public Parcela getParcela() {
		return parcela;
	}

	public void setParcela(Parcela parcela) {
		this.parcela = parcela;
	}
	
	
	
}

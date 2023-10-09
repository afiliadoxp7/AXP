package com.afiliadoxp.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.afiliadoxp.domain.Categoria;
import com.afiliadoxp.domain.Fornecedor;
import com.afiliadoxp.domain.Genero;
import com.afiliadoxp.domain.Parcela;
import com.afiliadoxp.domain.Produto;
import com.afiliadoxp.domain.Valor;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	List<Produto> findByNomeContainingIgnoreCase(String nomeProduto, Sort sort);
	
	List<Produto> findByPrecoBetween(double menor, double maior);
	
	// Categoria -----------------------
	Page<Produto> findByCategoriaIsNull(Pageable pageable);
	
	Page<Produto> findByCategoriaInAndPrecoBetweenOrderByPrecoDesc(
			List<Categoria> categorias,
			double precoMin, double precoMax, 
			Pageable pageable);
	
	// Genero -----------------------
	Page<Produto> findByGeneroIsNull(Pageable pageable);
	
	Page<Produto> findByGeneroInAndPrecoBetweenOrderByPrecoDesc(
			List<Genero> generos,
			double precoMin, double precoMax, 
			Pageable pageable);
	
	// Fornecedor -----------------------
	Page<Produto> findByFornecedorIsNull(Pageable pageable);
	
	Page<Produto> findByFornecedorInAndPrecoBetweenOrderByPrecoDesc(
			List<Fornecedor> fornecedores,
			double precoMin, double precoMax, 
			Pageable pageable);
	
	// Valor -----------------------
	Page<Produto> findByValorIsNull(Pageable pageable);
	
	Page<Produto> findByValorInAndPrecoBetweenOrderByPrecoDesc(
			List<Valor> Valores,
			double precoMin, double precoMax, 
			Pageable pageable);
	
	// Parcela -----------------------
		Page<Produto> findByParcelaIsNull(Pageable pageable);
		
		Page<Produto> findByParcelaInAndPrecoBetweenOrderByPrecoDesc(
				List<Parcela> Parcelas,
				double precoMin, double precoMax, 
				Pageable pageable);

}

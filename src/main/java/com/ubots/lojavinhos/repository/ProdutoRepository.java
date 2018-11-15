package com.ubots.lojavinhos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ubots.lojavinhos.entity.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long>{

	List<Produto> findAll();

	@Query(value="select p from Produto p where p.variedade = ?1 and p.produto <> ?2")
	List<Produto> listarProdutosPorVariedade(String variedade, String produto);

	@Query(value="select p from Produto p where p.safra = ?1 and p.produto <> ?2")
	List<Produto> listarProdutosPorSafra(String safra, String produto);
}

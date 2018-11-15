package com.ubots.lojavinhos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ubots.lojavinhos.entity.Compra;

@Repository
public interface CompraRepository  extends CrudRepository<Compra, Long>{

	@Query(value="select c from Compra c join FETCH c.itens i where c.cliente = ?1")
	List<Compra> findAllByCliente(String cpf);
}

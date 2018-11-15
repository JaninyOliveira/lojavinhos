package com.ubots.lojavinhos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ubots.lojavinhos.entity.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>{

	@Query(nativeQuery=true,value="select u.* from Cliente u, Compra c where u.cpf = c.cliente group by u.id order by sum(c.valor_total) desc")
	List<Cliente> listaClientesValorTotal();

	@Query(nativeQuery=true,value="select u.* from Cliente u, Compra c where u.cpf = c.cliente and c.data between to_date('01/01/2016 00:00:00', 'DD/MM/YYYY HH24:MI:SS') and to_date('31/12/2016 23:59:59', 'DD/MM/YYYY HH24:MI:SS') group by u.id, c.valor_total  order by c.valor_total desc")
	List<Cliente> buscaClienteCompraUnicaAno();
	
	@Query(nativeQuery=true,value="select u.* from Cliente u, Compra c where u.cpf = c.cliente group by u.id order by COUNT(c.codigo) desc")
	List<Cliente> listaClienteFieis();
}

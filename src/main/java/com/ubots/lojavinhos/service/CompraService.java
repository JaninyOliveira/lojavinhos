package com.ubots.lojavinhos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubots.lojavinhos.entity.Compra;
import com.ubots.lojavinhos.entity.Produto;
import com.ubots.lojavinhos.repository.CompraRepository;
import com.ubots.lojavinhos.repository.ProdutoRepository;

@Service
public class CompraService {

	@Autowired
	private CompraRepository compraRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public void cadastrarCompras(List<Compra> compras) {
		
		for(Compra compra :compras) {
			List<Produto> pl = compra.getItens();
			produtoRepository.saveAll(pl);
		}
		compraRepository.saveAll(compras);
	}

}

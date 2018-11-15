package com.ubots.lojavinhos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubots.lojavinhos.entity.Cliente;
import com.ubots.lojavinhos.entity.Compra;
import com.ubots.lojavinhos.entity.Produto;
import com.ubots.lojavinhos.repository.ClienteRepository;
import com.ubots.lojavinhos.repository.CompraRepository;
import com.ubots.lojavinhos.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CompraRepository compraRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public Produto recomendarProduto(Long clienteId) {
		Cliente cliente = clienteRepository.findById(clienteId).get();
		List<Compra> compras = compraRepository.findAllByCliente(cliente.getCpf());
		
		Produto produtoFavorito = buscarProdutoFavorito(compras);
		
		List<Produto> produtosSugeridos = produtoRepository.listarProdutosPorVariedade(produtoFavorito.getVariedade(), produtoFavorito.getProduto());
		
		if(produtosSugeridos == null || produtosSugeridos.isEmpty()) {
			produtosSugeridos = produtoRepository.listarProdutosPorSafra(produtoFavorito.getSafra(), produtoFavorito.getProduto());
		}
		
		if(produtosSugeridos == null || produtosSugeridos.isEmpty()) {
			return null; // Nao encontrou nenhuma sugestao
		}
		
		return produtosSugeridos.get(0) ;
	}

	private Produto buscarProdutoFavorito(List<Compra> compras) {
		List<Produto> allProdutos = produtoRepository.findAll();
		List<Produto> allProdutosComprasCliente = getAllProdutosComprasCliente(compras);
		
		Produto produtoFavorito = null;
		Integer countProdutoFavorito = 0;
		
		for(Produto produto : allProdutos) {
			produto = produtoRepository.findById(produto.getId()).get();
			Integer countProduto = 0;
			
			for(Produto produtoCliente : allProdutosComprasCliente) {
				produtoCliente = produtoRepository.findById(produtoCliente.getId()).get();
				if(produto.getProduto().equals(produtoCliente.getProduto())) {
					countProduto++;
				}
			}
			
			if(countProduto > countProdutoFavorito) {
				countProdutoFavorito = countProduto;
				produtoFavorito = produto;
			}
		}
		
		return produtoFavorito;
	}

	private List<Produto> getAllProdutosComprasCliente(List<Compra> compras) {
		List<Produto> produtos = new ArrayList<Produto>();
		for(Compra compra : compras) {
			produtos.addAll(compra.getItens());
		}
		
		return produtos;
	}
}

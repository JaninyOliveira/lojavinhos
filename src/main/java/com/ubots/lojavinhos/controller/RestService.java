package com.ubots.lojavinhos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubots.lojavinhos.entity.Cliente;
import com.ubots.lojavinhos.entity.Produto;
import com.ubots.lojavinhos.service.ClienteService;
import com.ubots.lojavinhos.service.ProdutoService;

@RestController
public class RestService {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping("/listarClientesValorTotal")
	public List<Cliente> listarClientesValorTotal(){
		return clienteService.listaClientesValorTotal();
	}
	
	@RequestMapping("/buscarClienteCompraUnicaAno")
	public Cliente buscarClienteCompraUnicaAno(){
		return clienteService.buscaClienteCompraUnicaAno();
	}
	
	@RequestMapping("/listarClienteFieis")
	public List<Cliente> listarClienteFieis(){
		return clienteService.listaClienteFieis();
	}
	
	@RequestMapping("/recomendarProduto/{clienteId}")
	public Produto recomendarProduto(@PathVariable(value ="clienteId") Long clienteId){
		return produtoService.recomendarProduto(clienteId);
	}
}

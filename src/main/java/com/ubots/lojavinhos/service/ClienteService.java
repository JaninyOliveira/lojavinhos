package com.ubots.lojavinhos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubots.lojavinhos.entity.Cliente;
import com.ubots.lojavinhos.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public void cadastrarClientes(List<Cliente> clientes) {
		clienteRepository.saveAll(clientes);
	}
	
	public List<Cliente> listaClientesValorTotal() {
		return clienteRepository.listaClientesValorTotal();
	}

	public Cliente buscaClienteCompraUnicaAno() {
		List<Cliente> clientes = clienteRepository.buscaClienteCompraUnicaAno();
		return clientes.get(0);
	}

	public List<Cliente> listaClienteFieis() {
		return clienteRepository.listaClienteFieis();
	}

	
}

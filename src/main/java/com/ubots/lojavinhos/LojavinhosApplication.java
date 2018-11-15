package com.ubots.lojavinhos;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.ubots.lojavinhos.entity.Cliente;
import com.ubots.lojavinhos.entity.Compra;
import com.ubots.lojavinhos.properties.LojaProperties;
import com.ubots.lojavinhos.service.ClienteService;
import com.ubots.lojavinhos.service.CompraService;

@SpringBootApplication
public class LojavinhosApplication {


	@Autowired
	private LojaProperties lojaProperties;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private CompraService compraService;
	
		
	public static void main(String[] args) {
		SpringApplication.run(LojavinhosApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			//Cliente quote = restTemplate.getForObject(
				//	lojaProperties.getCadastrourl(), Cliente.class);
			
			ResponseEntity<Cliente[]> clienteResponse = restTemplate.getForEntity(lojaProperties.getCadastrourl(), Cliente[].class);
			List<Cliente> clientes = Arrays.asList(clienteResponse.getBody());
			clienteService.cadastrarClientes(clientes);
			
			
			ResponseEntity<Compra[]> compraResponse = restTemplate.getForEntity(lojaProperties.getHistoricourl(), Compra[].class);
			List<Compra> compras = Arrays.asList(compraResponse.getBody());
			compraService.cadastrarCompras(compras);
		};
	}
}

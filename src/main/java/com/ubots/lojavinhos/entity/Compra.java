package com.ubots.lojavinhos.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ubots.lojavinhos.utils.DateDeserializer;
import com.ubots.lojavinhos.utils.FixIssuesCPFFromJsonDeserializer;

@Entity
public class Compra implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1853255244899143615L;

	@Id
	private String codigo;
	
	@JsonDeserialize(using = DateDeserializer.class)
	private Date data;
	
	@JsonDeserialize(using = FixIssuesCPFFromJsonDeserializer.class)
	private String cliente;
	
	@ManyToMany(cascade=CascadeType.PERSIST )
	private List<Produto> itens;
	
	private Double valorTotal;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getItens() {
		return itens;
	}

	public void setItens(List<Produto> itens) {
		this.itens = itens;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
}

package com.projeto.loja.dto;

import java.time.LocalDate;

import com.projeto.loja.entity.LancamentoVendas;

public class LancamentoVendasRequestDTO {

	private Long id;
	private LocalDate data;
	private Double valor;
	private Long vendedorId;
	
	public Long getVendedorId() {
		return vendedorId;
	}



	public void setVendedorId(Long vendedorId) {
		this.vendedorId = vendedorId;
	}



	public LancamentoVendasRequestDTO(LancamentoVendas lancamento) {
		super();
		this.id = lancamento.getId();
		this.data = lancamento.getData();
		this.valor = lancamento.getValor();
	}
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
}

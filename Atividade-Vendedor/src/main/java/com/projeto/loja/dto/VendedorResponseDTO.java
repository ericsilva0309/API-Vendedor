package com.projeto.loja.dto;

 
import com.projeto.loja.entity.LancamentoVendas;

public class VendedorResponseDTO {
	
	private String data;
	private Double valor;
	private String nomeVendedor;
	
	
	
	public VendedorResponseDTO(LancamentoVendas lancamento) {
		super();
		this.data = lancamento.getData().toString();
		this.valor = lancamento.getValor();
		this.nomeVendedor = lancamento.getVendedor().getNome();
	}



	public String getData() {
		return data;
	}



	public void setData(String data) {
		this.data = data;
	}



	public Double getValor() {
		return valor;
	}



	public void setValor(Double valor) {
		this.valor = valor;
	}



	public String getNomeVendedor() {
		return nomeVendedor;
	}



	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}
	
	

}

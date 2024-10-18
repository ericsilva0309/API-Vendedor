package com.projeto.loja.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.projeto.loja.dto.LancamentoVendasRequestDTO;
import com.projeto.loja.dto.LancamentoVendasResponseDTO;
import com.projeto.loja.entity.LancamentoVendas;
import com.projeto.loja.exception.LancamentoException;
import com.projeto.loja.respository.LancamentoRepository;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository repository;
	
	public List<LancamentoVendasResponseDTO> listar() {
		List<LancamentoVendas> lancamentos = repository.findAll();
		System.out.println(lancamentos);
		List<LancamentoVendasResponseDTO> dtos = new ArrayList<>();
		for (LancamentoVendas lancamento : lancamentos) {
			dtos.add(new LancamentoVendasResponseDTO(lancamento));
		}
		return dtos;
	}
	
	public Optional<LancamentoVendas> listarPorId(Long id){
		return repository.findById(id);
	}
	
//	public LancamentoVendasRequestDTO inserir(LancamentoVendas lancamento) {
//		Optional<LancamentoVendas> lancamentoExistente = repository.findById(lancamento.getId());
//		if(lancamentoExistente.isPresent()) {
//			throw new LancamentoException("Lancamento já existente!");
//		}
//		lancamento = repository.save(lancamento);
//		return new LancamentoVendasRequestDTO(lancamento);	
//	}
	
	public LancamentoVendasRequestDTO inserir(LancamentoVendas lancamento) {
	    if (lancamento.getId() != null) {
	        throw new LancamentoException("ID deve ser nulo para novos lançamentos!");
	    }
	    System.out.println(lancamento);
	    lancamento = repository.save(lancamento);
	    return new LancamentoVendasRequestDTO(lancamento);
	}

	
    public Page<LancamentoVendas> listarPorPagina(Pageable pageable) {
        return repository.findAll(pageable);

    }
	
}

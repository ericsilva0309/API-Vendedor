package com.projeto.loja.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.loja.dto.LancamentoVendasRequestDTO;
import com.projeto.loja.dto.LancamentoVendasResponseDTO;
import com.projeto.loja.entity.LancamentoVendas;
import com.projeto.loja.service.LancamentoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {
	
	@Autowired
	private LancamentoService service;	
	
	@GetMapping
	public ResponseEntity<List<LancamentoVendasResponseDTO>> listar() {
		return ResponseEntity.ok(service.listar());
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<LancamentoVendas> ListarPorId(@PathVariable Long id) {
        Optional<LancamentoVendas> lancamentoOptional = service.listarPorId(id);
        if (lancamentoOptional.isPresent()) {
            return ResponseEntity.ok(lancamentoOptional.get());
        }return ResponseEntity.notFound().build();
    }
	
	@PostMapping
	public ResponseEntity<Object> inserir(@RequestBody LancamentoVendas lancamento){
		LancamentoVendasRequestDTO dto = service.inserir(lancamento);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(lancamento.getId())
				.toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@GetMapping("/paginacao")
	public Page<LancamentoVendas> listar(@PageableDefault(page = 0, size = 10, sort = "valor", direction = Direction.ASC) Pageable pageable){
		return service.listarPorPagina(pageable);
	}

}

//package com.projeto.loja.service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import com.projeto.loja.dto.VendedorRequestDTO;
//import com.projeto.loja.dto.VendedorResponseDTO;
//import com.projeto.loja.entity.Vendedor;
//import com.projeto.loja.exception.VendedorException;
//import com.projeto.loja.respository.VendedorRepository;
//
//@Service
//public class VendedorService {
//
//	@Autowired
//	private VendedorRepository repository;
//	
//	public List<VendedorResponseDTO> listar() {
//		List<Vendedores> vendedor = repository.findAll();
//		List<VendedorResponseDTO> dtos = new ArrayList<>();
//		for (Vendedores vendedor : vendedor) {
//			dtos.add(new VendedorResponseDTO(vendedor));
//		}
//		return dtos;
//	}
//	
//	public Optional<Vendedores> listarPorId(Long id){
//		return repository.findById(id);
//	}
//	
//	public VendedorRequestDTO inserir(Vendedores vendedor) {
//		Optional<Vendedores> vendedorExistente = repository.findById(vendedor.getId());
//		if(vendedorExistente.isPresent()) {
//			throw new VendedorException("Vendedor já existente!");
//		}
//		vendedor = repository.save(vendedor);
//		return new VendedorRequestDTO(vendedor);	
//	}
//	
//    public Page<Vendedores> listarPorPagina(Pageable pageable) {
//        return repository.findAll(pageable);
//
//    }
//	
//}

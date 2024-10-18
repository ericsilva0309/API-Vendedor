package com.projeto.loja.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.loja.entity.Vendedor;
import com.projeto.loja.respository.VendedorRepository;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {

    @Autowired
    private VendedorRepository vendedorRepository;

    @GetMapping
    public List<Vendedor> listar() {
        return vendedorRepository.findAll();
    }

    @PostMapping
    public Vendedor inserir(@RequestBody Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }
    
    @GetMapping("/varios")
    public ResponseEntity<List<Vendedor>> listarVarios() {
        List<Vendedor> vendedores = vendedorRepository.findAll();
        return ResponseEntity.ok(vendedores);
    }
    
    @PostMapping("/varios")
    public ResponseEntity<List<Vendedor>> inserirVarios(@RequestBody List<Vendedor> vendedores) {
        List<Vendedor> vendedoresSalvos = new ArrayList<>();
        for (Vendedor vendedor : vendedores) {
            vendedoresSalvos.add(vendedorRepository.save(vendedor));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(vendedoresSalvos);
    }

}

package com.projeto.loja.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.loja.entity.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
    // Aqui você pode adicionar métodos de consulta personalizados se necessário
}

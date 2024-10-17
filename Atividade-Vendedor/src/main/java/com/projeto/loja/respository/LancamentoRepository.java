package com.projeto.loja.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.loja.entity.LancamentoVendas;

@Repository
public interface LancamentoRepository extends JpaRepository<LancamentoVendas, Long>{

}

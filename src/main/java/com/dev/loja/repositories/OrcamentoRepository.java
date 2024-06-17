package com.dev.loja.repositories;


import com.dev.loja.models.Orcamento;
import com.dev.loja.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrcamentoRepository extends JpaRepository<Orcamento, Integer> {


}
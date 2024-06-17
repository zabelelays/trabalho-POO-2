package com.dev.loja.repositories;


import com.dev.loja.models.Fornecedor;
import com.dev.loja.models.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {


}
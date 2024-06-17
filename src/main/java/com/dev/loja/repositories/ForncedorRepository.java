package com.dev.loja.repositories;


import com.dev.loja.models.Fornecedor;
import com.dev.loja.models.Mercadoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForncedorRepository extends JpaRepository<Fornecedor, Integer> {


}
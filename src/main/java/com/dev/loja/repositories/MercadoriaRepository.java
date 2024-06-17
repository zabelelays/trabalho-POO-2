package com.dev.loja.repositories;


import com.dev.loja.models.Mercadoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MercadoriaRepository extends JpaRepository<Mercadoria, Integer> {


}
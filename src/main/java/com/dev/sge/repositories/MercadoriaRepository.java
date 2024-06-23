package com.dev.sge.repositories;


import com.dev.sge.models.Mercadoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MercadoriaRepository extends JpaRepository<Mercadoria, Integer> {
}
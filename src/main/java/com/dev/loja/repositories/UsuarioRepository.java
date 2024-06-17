package com.dev.loja.repositories;


import com.dev.loja.models.Movimentacao;
import com.dev.loja.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


}
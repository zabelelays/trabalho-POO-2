package com.dev.sge.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@Entity
@Table(name="mercadoria")
public class Mercadoria implements Serializable {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String codigoDeBarras;

    private Double nome;

    private String categoria;

    private String marca;

    private Integer quantidadeEstoque = 0;

    private Double preco;

    @ManyToOne
     private Fornecedor fornecedor;

}
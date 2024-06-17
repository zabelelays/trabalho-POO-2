package com.dev.sge.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "movimentacao")
public class Movimentacao {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String tipo;

    private String data;


    private Integer quantidade;

    @ManyToOne
    private Mercadoria mercadoria;
}

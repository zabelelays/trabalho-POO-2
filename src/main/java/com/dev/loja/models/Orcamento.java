package com.dev.loja.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="orcamento")
public class Orcamento {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Double valorTotal;

    private Double valorLucro;
}

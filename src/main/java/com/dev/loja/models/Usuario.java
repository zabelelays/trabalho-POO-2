package com.dev.loja.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Getter
    @Setter
    private String nome;
    @Getter
    @Setter
    private String cargo;
}
package com.pedidos.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String senha;
    private String endereco;
    private String telefone;

    @OneToMany
    private List<Emprestimo> emprestimos;
}

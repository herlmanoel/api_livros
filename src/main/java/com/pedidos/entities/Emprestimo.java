package com.pedidos.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dataEmprestimo;
    private Date dataDevolucao;

    @ManyToOne
    private Usuario usuario;

}

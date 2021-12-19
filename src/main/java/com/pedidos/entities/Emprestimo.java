package com.pedidos.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class Emprestimo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dataEmprestimo;
    private Date dataDevolucao;

    @ManyToOne
    private Usuario usuario;

}

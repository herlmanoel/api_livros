package com.pedidos.DTOs;

import lombok.Data;

import java.util.Date;

@Data
public class EmprestimoDTO  {

    private Long id;

    private Date dataEmprestimo;
    private Date dataDevolucao;

    private UsuarioDTO usuario;

}

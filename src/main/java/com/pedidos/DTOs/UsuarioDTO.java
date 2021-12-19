package com.pedidos.DTOs;

import java.util.List;

public class UsuarioDTO {

    private Long id;

    private String nome;
    private String senha;
    private String endereco;
    private String telefone;

    private List<EmprestimoDTO> emprestimos;
}

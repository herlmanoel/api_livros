package com.pedidos.DTOs;

import lombok.Data;

@Data
public class LivroDTO  {

    private Long id;

    private String titulo;
    private String autor;

    private SessaoDTO sessao;
}

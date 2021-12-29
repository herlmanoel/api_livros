package com.pedidos.DTOs;

import com.pedidos.entities.Livro;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class LivroDTO  {
    public LivroDTO() {}

    public LivroDTO(Livro livro) {
        BeanUtils.copyProperties(livro, this);
    }

    private Long id;

    private String titulo;
    private String autor;

    private SessaoDTO sessao;
}

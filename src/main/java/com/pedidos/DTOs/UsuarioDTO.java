package com.pedidos.DTOs;

import com.pedidos.entities.Emprestimo;
import com.pedidos.entities.Usuario;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class UsuarioDTO {

    private Long id;

    private String nome;
    private String senha;
    private String endereco;
    private String telefone;

    private List<EmprestimoDTO> emprestimos;
    public UsuarioDTO() {
        this.emprestimos = null;
    }

    public UsuarioDTO(Long id, String nome, String senha, String endereco, String telefone, List<Emprestimo> emprestimos) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.endereco = endereco;
        this.telefone = telefone;

        this.emprestimos = emprestimos.stream().map(emprestimo -> {
            EmprestimoDTO emprestimoDTO = new EmprestimoDTO();
            BeanUtils.copyProperties(emprestimo, emprestimoDTO);
            return emprestimoDTO;
        }).collect(Collectors.toList());
    }

    public Usuario createUsuarioByDTO() {
        if (this.emprestimos == null) {
            return new Usuario(id, nome, senha, endereco, telefone, null);
        }
        var emprestimos = this.emprestimos.stream()
                .map(emprestimoItem -> {
                    Emprestimo emprestimoObject = new Emprestimo();
                    BeanUtils.copyProperties(emprestimoItem, emprestimoObject);
                    return emprestimoObject;
                }).collect(Collectors.toList());

        return new Usuario(id, nome, senha, endereco, telefone, emprestimos);
    }



}

package com.pedidos.entities;

import com.pedidos.DTOs.UsuarioDTO;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@Entity
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String senha;
    private String endereco;
    private String telefone;

    public Usuario() {

    }

    public Usuario(Long id, String nome, String senha, String endereco, String telefone, List<Emprestimo> emprestimos) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.endereco = endereco;
        this.telefone = telefone;
        this.emprestimos = emprestimos;
    }

    public void setAtributos(UsuarioDTO usuarioDTO) {
        this.nome = usuarioDTO.getNome();
        this.senha = usuarioDTO.getNome();
        this.endereco = usuarioDTO.getEndereco();
        this.telefone = usuarioDTO.getTelefone();

        if(usuarioDTO.getEmprestimos() == null) {
            return;
        }

        this.emprestimos = usuarioDTO.getEmprestimos().stream()
                .map(emprestimoItem -> {
                    Emprestimo emprestimoObject = new Emprestimo();
                    BeanUtils.copyProperties(emprestimoItem, emprestimoObject);
                    return emprestimoObject;
                }).collect(Collectors.toList());
    }

    @OneToMany
    @ToString.Exclude
    private List<Emprestimo> emprestimos;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Usuario usuario = (Usuario) o;
        return id != null && Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

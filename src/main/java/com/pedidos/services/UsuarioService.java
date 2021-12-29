package com.pedidos.services;

import com.pedidos.DTOs.UsuarioDTO;
import com.pedidos.entities.Usuario;
import com.pedidos.repositories.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<UsuarioDTO> adicionar(UsuarioDTO usuarioDTO) {
        Usuario usuario =usuarioDTO.createUsuarioByDTO();

        Usuario usuarioCreated = usuarioRepository.save(usuario);

        BeanUtils.copyProperties(usuarioCreated, usuarioDTO);

        return Optional.of(usuarioDTO);
    }

    public List<UsuarioDTO> listarTodos(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map((Usuario u) ->
                        new UsuarioDTO(u.getId(), u.getNome(), u.getSenha(), u.getEndereco(), u.getTelefone(), u.getEmprestimos()))
                .collect(Collectors.toList());
    }

    public Boolean delete(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(!usuario.isPresent()) {
            return false;
        }
        usuarioRepository.delete(usuario.get());
        return true;
    }

    public Optional<UsuarioDTO> buscarUm(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if(!usuario.isPresent()) {
            return Optional.empty();
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        BeanUtils.copyProperties(usuario.get(), usuarioDTO);
        return Optional.of(usuarioDTO);
    }

    public UsuarioDTO editar(Long id, UsuarioDTO usuarioDTO) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        usuario.get().setAtributos(usuarioDTO);
        Usuario usuarioUpdated = usuarioRepository.save(usuario.get());

        return usuarioDTO;
    }

}

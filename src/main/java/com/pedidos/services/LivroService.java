package com.pedidos.services;

import com.pedidos.DTOs.LivroDTO;
import com.pedidos.entities.Livro;
import com.pedidos.entities.Usuario;
import com.pedidos.repositories.LivroRepository;
import com.pedidos.repositories.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public Optional<LivroDTO> adicionar(LivroDTO livroDTO) {

        Livro livro = new Livro();
        BeanUtils.copyProperties(livroDTO, livro);

        Livro livroCreated = livroRepository.save(livro);

        BeanUtils.copyProperties(livroCreated, livroDTO);

        return Optional.of(livroDTO);
    }

    public List<LivroDTO> listarTodos(){
        List<Livro> livros = livroRepository.findAll();

        return livros.stream()
                .map(LivroDTO::new)
                .collect(Collectors.toList());
    }
//
//    public Boolean delete(Long id) {
//        Optional<Usuario> usuario = usuarioRepository.findById(id);
//        if(!usuario.isPresent()) {
//            return false;
//        }
//        usuarioRepository.delete(usuario.get());
//        return true;
//    }
//
//    public Optional<LivroDTO> buscarUm(Long id) {
//        Optional<Usuario> usuario = usuarioRepository.findById(id);
//
//        if(!usuario.isPresent()) {
//            return Optional.empty();
//        }
//
//        LivroDTO usuarioDTO = new LivroDTO();
//        BeanUtils.copyProperties(usuario.get(), usuarioDTO);
//        return Optional.of(usuarioDTO);
//    }
//
//    public LivroDTO editar(Long id, LivroDTO usuarioDTO) {
//        Optional<Usuario> usuario = usuarioRepository.findById(id);
//
//        usuario.get().setAtributos(usuarioDTO);
//        Usuario usuarioUpdated = usuarioRepository.save(usuario.get());
//
//        return usuarioDTO;
//    }

}

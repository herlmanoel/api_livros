package com.pedidos.controllers;

import com.pedidos.DTOs.LivroDTO;
import com.pedidos.DTOs.UsuarioDTO;
import com.pedidos.services.LivroService;
import com.pedidos.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @PostMapping
    public ResponseEntity<Object> adicionar(@RequestBody LivroDTO livroDTO) {
        Optional<LivroDTO> livroCreated = livroService.adicionar(livroDTO);

        if(!livroCreated.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível salvar o Usuário");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(livroDTO);
    }

    @GetMapping
    public ResponseEntity<Object> listarTodos() {
        List<LivroDTO> livrosDTO = livroService.listarTodos();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(livrosDTO);
    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Object> delete(@PathVariable Long id) {
//        Boolean removido = usuarioService.delete(id);
//        return ResponseEntity.status(HttpStatus.OK).body(removido);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Object> buscarUm(@PathVariable Long id) {
//        Optional<UsuarioDTO> usuarioDTO = usuarioService.buscarUm(id);
//        if (usuarioDTO.isPresent()) {
//            return ResponseEntity.ok().body(usuarioDTO);
//        }
//
//        return ResponseEntity.badRequest().body("Erro");
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Object> editar(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
//        return ResponseEntity.ok().body(usuarioService.editar(id, usuarioDTO));
//    }
}

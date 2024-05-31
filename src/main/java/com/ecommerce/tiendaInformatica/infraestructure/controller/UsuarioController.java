package com.ecommerce.tiendaInformatica.infraestructure.controller;

import com.ecommerce.tiendaInformatica.application.service.UsuarioService;
import com.ecommerce.tiendaInformatica.domain.model.Usuario;
import com.ecommerce.tiendaInformatica.infraestructure.dto.UsuarioDTO;
import com.ecommerce.tiendaInformatica.infraestructure.mapper.UsuarioMapper;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;

    public UsuarioController(UsuarioService usuarioService,UsuarioMapper usuarioMapper) {
        this.usuarioService = usuarioService;
        this.usuarioMapper =usuarioMapper;
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> createUsuario(@RequestBody Usuario usuario){
     Usuario createUsuario = usuarioService.crearUsuario(usuario);
     UsuarioDTO createUsuarioDTO=usuarioMapper.toUsuarioDTO(createUsuario);
        return new ResponseEntity<>(createUsuarioDTO, HttpStatus.CREATED);
    }
    @GetMapping("/{usuarioId}")
    public ResponseEntity<UsuarioDTO>getUsuarioById(@PathVariable Long usuarioId){
        return usuarioService.getUsuario(usuarioId)
                .map(usuario->
                    new ResponseEntity<>(usuarioMapper.toUsuarioDTO(usuario),HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping
    public List<UsuarioDTO> getUsuarioAll(){
        List<Usuario> usuarios=usuarioService.getAllUsuarios();
        return usuarios.stream().map(usuarioMapper::toUsuarioDTO)
                .collect(Collectors.toList());

    }
    @PutMapping("/{usuarioId}")
    public ResponseEntity<UsuarioDTO> updateUsuario(@PathVariable Long usuarioId, @RequestBody Usuario usuario) {
        Optional<Usuario> updatedUsuarioOptional = usuarioService.updateUsuario(usuarioId, usuario);
        if (updatedUsuarioOptional.isPresent()) {
            UsuarioDTO updatedUsuarioDTO = usuarioMapper.toUsuarioDTO(updatedUsuarioOptional.get());
            return new ResponseEntity<>(updatedUsuarioDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{usuarioId}")
    public ResponseEntity<Void> deleteUsuarioById(@PathVariable Long usuarioId) {
        if (usuarioService.deleteUsuario(usuarioId)) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}

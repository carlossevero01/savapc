package com.ifsul.sistema.computacional.sistematcc.service;

import java.util.List;


import org.springframework.security.core.userdetails.UserDetailsService;

import com.ifsul.sistema.computacional.sistematcc.model.usuario;
import com.ifsul.sistema.computacional.sistematcc.model.turma;
import com.ifsul.sistema.computacional.sistematcc.web.dto.UsuarioRegistrationDto;




public interface usuarioService extends UserDetailsService{
    List<usuario> findAll();
    usuario findById(Integer id);
    usuario save(UsuarioRegistrationDto registrationDto);
    usuario save(usuario usuarioexistente);
    usuario deleteById(Integer id);
    List<usuario> findByIdentificadorLike(String identificador);
    List<usuario> findByTurmasIn(List<turma> turmas);
    usuario findByUsername(String username);
    List<usuario> findByNomeLike(String nome);
    List<usuario> findByTipoLike(String tipo);
   
    
}


package com.ifsul.savapc.service.serviceImplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ifsul.savapc.model.correcoesUsuario;
import com.ifsul.savapc.model.perguntaTeste;
import com.ifsul.savapc.model.teste;
import com.ifsul.savapc.model.turma;
import com.ifsul.savapc.model.usuario;
import com.ifsul.savapc.repository.correcoesUsuarioRepository;
import com.ifsul.savapc.service.correcoesUsuarioService;

public class correcoesUsuarioServiceImplements implements correcoesUsuarioService{
    @Autowired
    correcoesUsuarioRepository correcoesUsuarioRepository;
    @Override
    public List<correcoesUsuario> findByUsuario(usuario a) {
        return correcoesUsuarioRepository.findByUsuario(a);
    }
    @Override
    public List<correcoesUsuario> findByUsuarioAndTurmaAndTesteAndPerguntaTeste(usuario a, turma t, teste test,
            perguntaTeste perguntaTeste) {
        return correcoesUsuarioRepository.findByUsuarioAndTurmaAndTesteAndPerguntaTeste(a, t, test, perguntaTeste);
    }
    @Override
    public List<correcoesUsuario> findByTurmaOrderByUsuario(turma t) {
        return correcoesUsuarioRepository.findByTurmaOrderByUsuario(t);
    }
    @Override
    public List<correcoesUsuario> findByUsuarioAndTurma(usuario a, turma t) {
        return correcoesUsuarioRepository.findByUsuarioAndTurma(a, t);
    }
    
}

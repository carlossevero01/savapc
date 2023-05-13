package com.ifsul.sistema.computacional.sistematcc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifsul.sistema.computacional.sistematcc.model.opcaoresposta;
import com.ifsul.sistema.computacional.sistematcc.model.perguntaTeste;

public interface opcaorespostaRepository extends JpaRepository<opcaoresposta,Integer>{
    List<opcaoresposta> findByVerdadeira(boolean verdadeira);
    List<opcaoresposta> findOpcaoRespostaIdByPerguntasTesteAndVerdadeira(perguntaTeste p,boolean verdadeira);
}

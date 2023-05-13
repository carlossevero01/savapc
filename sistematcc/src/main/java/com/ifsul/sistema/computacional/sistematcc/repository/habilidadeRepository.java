package com.ifsul.sistema.computacional.sistematcc.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.ifsul.sistema.computacional.sistematcc.model.habilidade;
import java.util.List;
import com.ifsul.sistema.computacional.sistematcc.model.perguntaTeste;


public interface habilidadeRepository extends JpaRepository<habilidade,Integer>{
    List<habilidade> findByPerguntasTeste(perguntaTeste pergunta);
}

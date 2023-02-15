package com.ifsul.sistema.computacional.sistematcc.controller;






import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ifsul.sistema.computacional.sistematcc.model.aluno;
import com.ifsul.sistema.computacional.sistematcc.model.habilidade;
import com.ifsul.sistema.computacional.sistematcc.model.professor;
import com.ifsul.sistema.computacional.sistematcc.model.turma;
import com.ifsul.sistema.computacional.sistematcc.repository.alunoRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.habilidadeRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.professorRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.turmaRepository;

import jakarta.transaction.Transactional;

@Controller
public class controllers {
    @Autowired
    alunoRepository alunoRepository;
    @Autowired
    turmaRepository turmaRepository;
    @Autowired
    professorRepository professorRepository;
    @Autowired
    habilidadeRepository habilidadeRepository;
        @Transactional      // Colocar caso de Cannot Remove em deleteByturnoNome(String)
        @GetMapping (value="/CAT")     //@RequestMapping(value = "/listarCandidatos", method = RequestMethod.GET)
        @ResponseBody                               //@ResponseBody permite retornar um texto
        public List<aluno> teste(){
            List<aluno> laluno= new ArrayList<>();
            System.out.println("cadastrar aluno na turma");
            aluno a = alunoRepository.findById(1).orElseThrow(null);
            laluno.add(a);
            turma t = new turma("turma 2");
            t.setAlunos(laluno);
           turmaRepository.save(t);
           List<aluno> listAlunos = alunoRepository.findAll();
           return listAlunos;
            
        } 
        @Transactional      // Colocar caso de Cannot Remove em deleteByturnoNome(String)
        @GetMapping (value="/CPT")     //@RequestMapping(value = "/listarCandidatos", method = RequestMethod.GET)
        @ResponseBody                               //@ResponseBody permite retornar um texto
        public List<turma> teste2(){
            List<professor> lprofessor= new ArrayList<>();
            System.out.println("cadastrar professor na turma");
            professor p = new professor("professor1") ;
            professorRepository.save(p);
            lprofessor.addAll(professorRepository.findAll());
            turma t = turmaRepository.findById(3).orElseThrow(null);
            t.setProfessores(lprofessor);
           turmaRepository.save(t);
           
           return turmaRepository.findAll();
            
        } 
        @Transactional      // Colocar caso de Cannot Remove em deleteByturnoNome(String)
        @GetMapping (value="/CHA")     //@RequestMapping(value = "/listarCandidatos", method = RequestMethod.GET)
        @ResponseBody                               //@ResponseBody permite retornar um texto
        public List<aluno> setHabilidade(){
            List<habilidade> lhabilidade= new ArrayList<>();
            System.out.println("cadastrar habilidade em alunos");
            habilidade h = new habilidade("habilidade1") ;
            habilidadeRepository.save(h);
            lhabilidade.addAll(habilidadeRepository.findAll());
            aluno a = alunoRepository.findAll().get(0);
            a.setHabilidades(lhabilidade);
           alunoRepository.save(a);
           
           return alunoRepository.findAll();
            
        } 
      //  @Transactional      // Colocar caso de Cannot Remove em deleteByturnoNome(String)
        @GetMapping (value="/listarAlunos")     //@RequestMapping(value = "/listarCandidatos", method = RequestMethod.GET)
        @ResponseBody                               //@ResponseBody permite retornar um texto
        public List<aluno> getAlunos(){
           
            System.out.println("listar alunos ");
        
            return alunoRepository.findAll();
        } 
        @Transactional      // Colocar caso de Cannot Remove em deleteByturnoNome(String)
        @GetMapping (value="/listarTurmas")     //@RequestMapping(value = "/listarCandidatos", method = RequestMethod.GET)
        @ResponseBody                               //@ResponseBody permite retornar um texto
        public List<turma> getTurmas(){
            System.out.println("listar turmas ");
            return turmaRepository.findAll();
        } 
        @Transactional      // Colocar caso de Cannot Remove em deleteByturnoNome(String)
        @GetMapping (value="/listarProfessores")     //@RequestMapping(value = "/listarCandidatos", method = RequestMethod.GET)
        @ResponseBody                               //@ResponseBody permite retornar um texto
        public List<professor> getProfessores(){
            System.out.println("listar professores ");
            return professorRepository.findAll();
        } 
        @GetMapping (value="/listarHabilidades")     //@RequestMapping(value = "/listarCandidatos", method = RequestMethod.GET)
        @ResponseBody                               //@ResponseBody permite retornar um texto
        public List<habilidade> getHabilidades(){
            System.out.println("listar habilidades ");
            return habilidadeRepository.findAll();
        } 
        @RequestMapping(value = "/", method = RequestMethod.GET)    
        public ModelAndView index() {
         ModelAndView mav = new ModelAndView("index");
         mav.addObject("alunos", alunoRepository.findAll());
         return mav;

        

}
}

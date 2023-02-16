package com.ifsul.sistema.computacional.sistematcc.controller;






import java.time.LocalDate;
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
import com.ifsul.sistema.computacional.sistematcc.model.pergunta;
import com.ifsul.sistema.computacional.sistematcc.model.professor;
import com.ifsul.sistema.computacional.sistematcc.model.turma;
import com.ifsul.sistema.computacional.sistematcc.model.teste;
import com.ifsul.sistema.computacional.sistematcc.model.opcaoresposta;
import com.ifsul.sistema.computacional.sistematcc.model.questionarioinicial;
import com.ifsul.sistema.computacional.sistematcc.model.perguntaquestionario;
import com.ifsul.sistema.computacional.sistematcc.repository.alunoRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.habilidadeRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.perguntaRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.professorRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.testeRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.turmaRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.opcaorespostaRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.questionarioinicialRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.perguntaquestionarioRepository;

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
    @Autowired
    perguntaRepository perguntaRepository;
    @Autowired
    testeRepository testeRepository;
    @Autowired
    opcaorespostaRepository opcaorespostaRepository;
    @Autowired
    questionarioinicialRepository questionarioinicialRepository;
    @Autowired
    perguntaquestionarioRepository perguntaquestionarioRepository;

        @Transactional      // Colocar caso de Cannot Remove em deleteByturnoNome(String)
        @GetMapping (value="/CAT")     //@RequestMapping(value = "/listarCandidatos", method = RequestMethod.GET)
        @ResponseBody                               //@ResponseBody permite retornar um texto
        public List<aluno> setAlunoTurma(){
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
        public List<turma> setProfTurma(){
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
        public List<aluno> setHabilidadeAluno(){
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
        @GetMapping (value="/CHP")     //@RequestMapping(value = "/listarCandidatos", method = RequestMethod.GET)
        @ResponseBody                               //@ResponseBody permite retornar um texto
        public List<pergunta> setHabiidadePerguntas(){
            System.out.println("cadastrar perguntas ");
            pergunta p = new pergunta("descricao da pergunta 1");
            p.setHabilidades(habilidadeRepository.findAll());
            perguntaRepository.save(p);
            return perguntaRepository.findAll();
        } 
        @GetMapping (value="/CadPergTest")     //@RequestMapping(value = "/listarCandidatos", method = RequestMethod.GET)
        @ResponseBody                               //@ResponseBody permite retornar um texto
        public List<teste> setPerguntaTestes(){
            System.out.println("cadastrar perguntas nos testes ");
            teste t = new teste(false, LocalDate.of(2020, 1, 8));
            t.setPerguntas(perguntaRepository.findAll());
            testeRepository.save(t);
            return testeRepository.findAll();
        } 
        @GetMapping (value="/CadOpcaoRespostasPergunta")     //@RequestMapping(value = "/listarCandidatos", method = RequestMethod.GET)
        @ResponseBody                               //@ResponseBody permite retornar um texto
        public List<pergunta> setOpcaoRespostaPergunta(){
            System.out.println("cadastrar opcao respotas na pergunta");
            opcaoresposta or = new opcaoresposta("descricao op resposta 1","verdadeira ou falso",false);
            or.setPerguntas(perguntaRepository.findAll());
            
            opcaorespostaRepository.save(or);
            return perguntaRepository.findAll();
        } 
        @GetMapping (value="/CadPerguntasQuestInicial")     //@RequestMapping(value = "/listarCandidatos", method = RequestMethod.GET)
        @ResponseBody                               //@ResponseBody permite retornar um texto
        public List<questionarioinicial> setPerguntasQuestInicial(){
            System.out.println("cadastrar perguntas no questionario inicial");
            perguntaquestionario pq = new perguntaquestionario("pergunta 1 do questionario", "discursiva");
            questionarioinicial qi = new questionarioinicial(LocalDate.of(2022, 8, 10), false, "questionario inicial 1");
            perguntaquestionarioRepository.save(pq);
            qi.setPerguntasQuestionario(perguntaquestionarioRepository.findAll());
            questionarioinicialRepository.save(qi);
            
            return questionarioinicialRepository.findAll();
        } 
        @GetMapping (value="/CadAlunoTeste")     //@RequestMapping(value = "/listarCandidatos", method = RequestMethod.GET)
        @ResponseBody                               //@ResponseBody permite retornar um texto
        public List<teste> setAlunoTeste(){
            System.out.println("cadastrar aluno no teste");
            
            teste t = testeRepository.findAll().get(0);
            t.setAlunos(alunoRepository.findAll());
            testeRepository.save(t);
            return testeRepository.findAll();
        } 
        @GetMapping (value="/CadAlunoQuestionario")     //@RequestMapping(value = "/listarCandidatos", method = RequestMethod.GET)
        @ResponseBody                               //@ResponseBody permite retornar um texto
        public List<questionarioinicial> setAlunoQuestInicial(){
            System.out.println("cadastrar aluno no Questionario inicial");
            
            questionarioinicial qin = questionarioinicialRepository.findAll().get(0);
            qin.setAlunos(alunoRepository.findAll());
            questionarioinicialRepository.save(qin);
            return questionarioinicialRepository.findAll();
        } 
        @RequestMapping(value = "/", method = RequestMethod.GET)    
        public ModelAndView index() {
         ModelAndView mav = new ModelAndView("index");
         mav.addObject("alunos", alunoRepository.findAll());
         return mav;

        

}
}

package com.ifsul.sistema.computacional.sistematcc.controller;






import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifsul.sistema.computacional.sistematcc.model.aluno;
import com.ifsul.sistema.computacional.sistematcc.model.habilidade;
import com.ifsul.sistema.computacional.sistematcc.model.pergunta;
import com.ifsul.sistema.computacional.sistematcc.model.professor;
import com.ifsul.sistema.computacional.sistematcc.model.turma;
import com.ifsul.sistema.computacional.sistematcc.model.teste;
import com.ifsul.sistema.computacional.sistematcc.model.opcaoresposta;
import com.ifsul.sistema.computacional.sistematcc.model.questionarioinicial;
import com.ifsul.sistema.computacional.sistematcc.model.perguntaquestionario;
import com.ifsul.sistema.computacional.sistematcc.model.perguntasForm;
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
import jakarta.validation.Valid;

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
        /*     LOGIN     */
        @GetMapping("/login")
        public String login(){
            return "login";
        }   
        @GetMapping("/")
        public String home(){
            return "redirect:/index/inicial";
        } 
        /*     LOGIN     */
        /*     PAGINA INICIAL(TODOS)     */
        
        @GetMapping(value = "/index/inicial")    
        public String index() {  
         return "index";
        }
        /*     PAGINA INICIAL(TODOS)     */
        
        /*     DELETAR UNIDADE(PROFESSORES/ADMIN)     */
        @GetMapping(value = "/index/deletealuno/{id}")    
        public String deleteAluno(@PathVariable("id") int id, RedirectAttributes attributes) {  
         try {
            alunoRepository.deleteById(id);
            attributes.addFlashAttribute("sucesso","Aluno deletado");
            return "redirect:/index/alunos";
         } catch (Exception e) {
            attributes.addFlashAttribute("erro","id inexistente ou erro desconhecido");
            return "redirect:/index/alunos";
         }   
        }
        
        @GetMapping(value = "/index/deletehabilidade/{id}")    
        public String deleteHabilidade(@PathVariable("id") int id, RedirectAttributes attributes) {  
         try {
            habilidadeRepository.deleteById(id);
            attributes.addFlashAttribute("sucesso","Habilidade deletada");
            return "redirect:/index/habilidades";
         } catch (Exception e) {
            attributes.addFlashAttribute("erro","id inexistente ou erro desconhecido");
            return "redirect:/index/habilidades";
         }   
        }
        
        @GetMapping(value = "/index/deletepergunta/{id}")    
        public String deletePergunta(@PathVariable("id") int id, RedirectAttributes attributes) {  
         try {
            perguntaRepository.deleteById(id);
            attributes.addFlashAttribute("sucesso","Pergunta deletada");
            return "redirect:/index/perguntas";
         } catch (Exception e) {
            attributes.addFlashAttribute("erro","ID inexistente ou erro desconhecido");
            return "redirect:/index/perguntas";
         }   
        }
       
        @GetMapping(value = "/index/deleteprofessor/{id}")    
        public String deleteProfessor(@PathVariable("id") int id, RedirectAttributes attributes) {  
         try {
            professorRepository.deleteById(id);
            attributes.addFlashAttribute("sucesso","Professor deletado");
            return "redirect:/index/professores";
         } catch (Exception e) {
            attributes.addFlashAttribute("erro","ID inexistente ou erro desconhecido");
            return "redirect:/index/professores";
         }   
        }

        @GetMapping(value = "/index/deleteteste/{id}")    
        public String deleteTeste(@PathVariable("id") int id, RedirectAttributes attributes) {  
         try {
            testeRepository.deleteById(id);
            attributes.addFlashAttribute("sucesso","Teste deletado");
            return "redirect:/index/testes";
         } catch (Exception e) {
            attributes.addFlashAttribute("erro","ID inexistente ou erro desconhecido");
            return "redirect:/index/testes";
         }   
        }

        @GetMapping(value = "/index/deleteturma/{id}")    
        public String deleteTurma(@PathVariable("id") int id, RedirectAttributes attributes) {  
         try {
            turmaRepository.deleteById(id);
            attributes.addFlashAttribute("sucesso","Turma deletada");
            return "redirect:/index/turmas";
         } catch (Exception e) {
            attributes.addFlashAttribute("erro","ID inexistente ou erro desconhecido");
            return "redirect:/index/turmas";
         }   
        }
        @GetMapping(value = "/index/pergunta/deleteopcaoresposta/{id}")    
        public String deleteOpcaoResposta(@PathVariable("id") int id, RedirectAttributes attributes) {  
         try {
            opcaorespostaRepository.deleteById(id);
            attributes.addFlashAttribute("sucesso","Opção-Resposta deletada");
            return "redirect:/index/pergunta/opcoesresposta/{id}";
         } catch (Exception e) {
            attributes.addFlashAttribute("erro","ID inexistente ou erro desconhecido");
            return "redirect:/index/pergunta/opcoesresposta/{id}";
         }   
        }
        /*     DELETAR UNIDADE(PROFESSORES/ADMIN)     */

        /*     CADASTRAR UNIDADE(PROFESSORES/ADMIN)     */
        @GetMapping("/index/saveAluno")
        public String getSaveAluno(){
            return "saveAluno";
        }
        @PostMapping("/index/saveAluno")
        public String saveAluno(@Valid aluno a, BindingResult result, RedirectAttributes attributes){
            if(result.hasErrors()){
                attributes.addFlashAttribute("erro","Verifique os campos obrigatórios:"+a.toString());
                return "redirect:/index/saveAluno";
            }
           alunoRepository.save(a);
           attributes.addFlashAttribute("sucesso","Aluno cadastrado");
           return "redirect:/index/alunos";       
        }

        @GetMapping("/index/saveHabilidade")
        public String getSaveHabilidade(){
            return "saveHabilidade";
        }
        @PostMapping("/index/saveHabilidade")
        public String saveHabilidade(@Valid habilidade h, BindingResult result, RedirectAttributes attributes){
            if(result.hasErrors()){
                attributes.addFlashAttribute("erro","Verifique os campos obrigatórios:"+h.toString());
                return "redirect:/index/saveHabilidade";
            }
           habilidadeRepository.save(h);
           attributes.addFlashAttribute("sucesso","Habilidade cadastrada");
           return "redirect:/index/habilidades";       
        }

        @GetMapping("/index/savePergunta")
        public String getSavePergunta(){
            return "savePergunta";
        }
        @PostMapping("/index/savePergunta")
        public String savePergunta(@Valid pergunta p, BindingResult result, RedirectAttributes attributes){
            if(result.hasErrors()){
                attributes.addFlashAttribute("erro","Verifique os campos obrigatórios:"+p.toString());
                return "redirect:/index/savePergunta";
            }
           perguntaRepository.save(p);
           attributes.addFlashAttribute("sucesso","Pergunta cadastrada");
           return "redirect:/index/perguntas";       
        }

        @GetMapping("/index/saveProfessor")
        public String getSaveProfessor(){
            return "saveProfessor";
        }
        @PostMapping("/index/saveProfessor")
        public String saveProfessor(@Valid professor p, BindingResult result, RedirectAttributes attributes){
            if(result.hasErrors()){
                attributes.addFlashAttribute("erro","Verifique os campos obrigatórios:"+p.toString());
                return "redirect:/index/saveProfessor";
            }
           professorRepository.save(p);
           attributes.addFlashAttribute("sucesso","Professor cadastrado");
           return "redirect:/index/professores";       
        }

        @GetMapping("/index/saveTeste")
        public String getSaveTeste(){
            return "saveTeste";
        }
        @PostMapping("/index/saveTeste")
        public String saveTeste(@Valid teste t, BindingResult result, RedirectAttributes attributes){
            if(result.hasErrors()){
                attributes.addFlashAttribute("erro","Verifique os campos obrigatórios:"+t.toString());
                return "redirect:/index/saveTeste";
            }
           testeRepository.save(t);
           attributes.addFlashAttribute("sucesso","Teste cadastrado");
           return "redirect:/index/testes";       
        }

        @GetMapping("/index/saveTurma")
        public String getSaveTurma(){
            return "saveTurma";
        }
        @PostMapping("/index/saveTurma")
        public String saveTurma(@Valid turma t, BindingResult result, RedirectAttributes attributes){
            if(result.hasErrors()){
                attributes.addFlashAttribute("erro","Verifique os campos obrigatórios:"+t.toString());
                return "redirect:/index/saveTurma";
            }
           turmaRepository.save(t);
           attributes.addFlashAttribute("sucesso","Turma cadastrada");
           return "redirect:/index/turmas";       
        }

        @GetMapping("/index/pergunta/saveopcaoresposta/{id}")
        public ModelAndView getSaveOpcaoResposta(@PathVariable("id") int id){
            ModelAndView mv = new ModelAndView("saveOpcaoresposta");
            mv.addObject("perguntaId", id);
            return mv;
        }
        @PostMapping("/index/pergunta/saveopcaoresposta/{id}")
        public String saveOpcaoResposta(@PathVariable("id") int id,@Valid opcaoresposta or, BindingResult result, RedirectAttributes attributes){
            if(result.hasErrors()){
                attributes.addFlashAttribute("erro","Verifique os campos obrigatórios:"+or.toString());
                return "redirect:/index/pergunta/saveopcaoresposta/{id}";
            }
           opcaorespostaRepository.save(or);
           pergunta p = perguntaRepository.findById(id).orElseThrow(null);
           List<opcaoresposta> listOR = p.getOpcoesResposta();
           listOR.add(or);
           p.setOpcoesResposta(listOR);
           perguntaRepository.save(p);
           attributes.addFlashAttribute("sucesso","Turma cadastrada");
           return "redirect:/index/pergunta/opcoesresposta/{id}";       
        }
        /*     CADASTRAR UNIDADE(PROFESSORES/ADMIN)     */

        /*     LISTAR DADOS(PROFESSORES/ADMIN)     */
        @GetMapping(value = "/index/alunos")    
        public ModelAndView listarAlunos() {  
         ModelAndView mv = new ModelAndView("aluno");
         List<aluno> list = alunoRepository.findAll();
         mv.addObject("alunos", list);   
         return mv;
        }
        @GetMapping(value = "/index/habilidades")    
        public ModelAndView listarHabilidades() {  
         ModelAndView mv = new ModelAndView("habilidade");
         List<habilidade> list = habilidadeRepository.findAll();
         mv.addObject("habilidades", list);   
         return mv;
        }
        
        @GetMapping(value = "/index/perguntas")    
        public ModelAndView listarPerguntas() {  
         ModelAndView mv = new ModelAndView("pergunta");
         List<pergunta> list = perguntaRepository.findAll();
         mv.addObject("perguntas", list);   
         return mv;
        }
        @GetMapping(value = "/index/professores")    
        public ModelAndView listarProfessores() {  
         ModelAndView mv = new ModelAndView("professor");
         List<professor> list = professorRepository.findAll();
         mv.addObject("professores", list);   
         return mv;
        }
        @GetMapping(value = "/index/questionarios")    
        public ModelAndView listarQuestionarios() {  
         ModelAndView mv = new ModelAndView("questionarioinicial");
         List<questionarioinicial> list = questionarioinicialRepository.findAll();
         mv.addObject("questionarios", list);   
         return mv;
        }
        @GetMapping(value = "/index/testes")    
        public ModelAndView listarTestes() {  
         ModelAndView mv = new ModelAndView("teste");
         List<teste> list = testeRepository.findAll();
         mv.addObject("testes", list);   
         return mv;
        }
        @GetMapping(value = "/index/turmas")    
        public ModelAndView listarTurmas() {  
         ModelAndView mv = new ModelAndView("turma");
         List<turma> list = turmaRepository.findAll();
         mv.addObject("turmas", list);   
         return mv;
        }

        @GetMapping(value = "/index/pergunta/opcoesresposta/{id}")
        public ModelAndView getOpcoesRespostaPergunta(@PathVariable("id") int id){          
            ModelAndView mv =new ModelAndView("opcaoresposta");
            pergunta p = perguntaRepository.findById(id).orElseThrow(null);
            List<opcaoresposta> opR = p.getOpcoesResposta();
            mv.addObject("opcoesrespostas", opR);
            mv.addObject("perguntaId", p.getPerguntaId());
            return mv;
        }
        /*     DADOS EM LISTA(PROFESSORES/ADMIN)     */
        @GetMapping(value = "/index/aplicacaoteste/{id}")
            public ModelAndView getTesteAplication(@PathVariable("id") int id){
                ModelAndView mv = new ModelAndView("aplicacaoTeste");
               
                    teste t = testeRepository.findById(id).orElseThrow(null);
                    List<pergunta> perguntas = t.getPerguntas();
                    mv.addObject("perguntas",perguntas);
                    mv.addObject("testeNome", t.getNome());
                    mv.addObject("testeId", t.getTesteId());
                    return mv;
               
            }
        @PostMapping(value = "/index/aplicacaoteste/{id}")
            public String setTesteAplication(@ModelAttribute perguntasForm lresp){
                System.out.println(lresp.toString());

                return "redirect:/index/inicial";
            }
       

}

package com.ifsul.sistema.computacional.sistematcc.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifsul.sistema.computacional.sistematcc.model.aluno;
import com.ifsul.sistema.computacional.sistematcc.model.contabilizacao;
import com.ifsul.sistema.computacional.sistematcc.model.correcoesAluno;
import com.ifsul.sistema.computacional.sistematcc.model.habilidade;
import com.ifsul.sistema.computacional.sistematcc.model.habForm;
import com.ifsul.sistema.computacional.sistematcc.model.opcaoresposta;
import com.ifsul.sistema.computacional.sistematcc.model.pergunta;
import com.ifsul.sistema.computacional.sistematcc.model.perguntaquestionario;
import com.ifsul.sistema.computacional.sistematcc.model.perguntasForm;
import com.ifsul.sistema.computacional.sistematcc.model.professor;
import com.ifsul.sistema.computacional.sistematcc.model.questionarioinicial;
import com.ifsul.sistema.computacional.sistematcc.model.registro;
import com.ifsul.sistema.computacional.sistematcc.model.resposta;
import com.ifsul.sistema.computacional.sistematcc.model.teste;
import com.ifsul.sistema.computacional.sistematcc.model.turma;
import com.ifsul.sistema.computacional.sistematcc.repository.alunoRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.habilidadeRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.opcaorespostaRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.perguntaRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.perguntaquestionarioRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.professorRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.questionarioinicialRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.registroRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.respostasRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.testeRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.turmaRepository;

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
    @Autowired
    registroRepository registroRepository;
    @Autowired
    respostasRepository respostasRepository;

    @Transactional // Colocar caso de Cannot Remove em deleteByturnoNome(String)
    @GetMapping(value = "/CAT") // @RequestMapping(value = "/listarCandidatos", method = RequestMethod.GET)
    @ResponseBody // @ResponseBody permite retornar um texto
    public List<aluno> setAlunoTurma() {
        List<aluno> laluno = new ArrayList<>();
        System.out.println("cadastrar aluno na turma");
        aluno a = alunoRepository.findById(1).orElseThrow(null);
        laluno.add(a);
        turma t = new turma("turma 2", false);
        t.setAlunos(laluno);
        turmaRepository.save(t);
        List<aluno> listAlunos = alunoRepository.findAll();
        return listAlunos;

    }

    @Transactional // Colocar caso de Cannot Remove em deleteByturnoNome(String)
    @GetMapping(value = "/CPT") // @RequestMapping(value = "/listarCandidatos", method = RequestMethod.GET)
    @ResponseBody // @ResponseBody permite retornar um texto
    public List<turma> setProfTurma() {
        List<professor> lprofessor = new ArrayList<>();
        System.out.println("cadastrar professor na turma");
        professor p = new professor("professor1");
        professorRepository.save(p);
        lprofessor.addAll(professorRepository.findAll());
        turma t = turmaRepository.findById(3).orElseThrow(null);
        t.setProfessores(lprofessor);
        turmaRepository.save(t);

        return turmaRepository.findAll();

    }

    @Transactional // Colocar caso de Cannot Remove em deleteByturnoNome(String)
    @GetMapping(value = "/CHA") // @RequestMapping(value = "/listarCandidatos", method = RequestMethod.GET)
    @ResponseBody // @ResponseBody permite retornar um texto
    public List<aluno> setHabilidadeAluno() {
        List<habilidade> lhabilidade = new ArrayList<>();
        System.out.println("cadastrar habilidade em alunos");
        habilidade h = new habilidade("habilidade1");
        habilidadeRepository.save(h);
        lhabilidade.addAll(habilidadeRepository.findAll());
        aluno a = alunoRepository.findAll().get(0);
        a.setHabilidades(lhabilidade);
        alunoRepository.save(a);

        return alunoRepository.findAll();

    }

    // @Transactional // Colocar caso de Cannot Remove em deleteByturnoNome(String)
    @GetMapping(value = "/listarAlunos") // @RequestMapping(value = "/listarCandidatos", method = RequestMethod.GET)
    @ResponseBody // @ResponseBody permite retornar um texto
    public List<aluno> getAlunos() {

        System.out.println("listar alunos ");

        return alunoRepository.findAll();
    }

    @Transactional // Colocar caso de Cannot Remove em deleteByturnoNome(String)
    @GetMapping(value = "/listarTurmas") // @RequestMapping(value = "/listarCandidatos", method = RequestMethod.GET)
    @ResponseBody // @ResponseBody permite retornar um texto
    public List<turma> getTurmas() {
        System.out.println("listar turmas ");
        return turmaRepository.findAll();
    }

    @Transactional // Colocar caso de Cannot Remove em deleteByturnoNome(String)
    @GetMapping(value = "/listarProfessores") // @RequestMapping(value = "/listarCandidatos", method =
                                              // RequestMethod.GET)
    @ResponseBody // @ResponseBody permite retornar um texto
    public List<professor> getProfessores() {
        System.out.println("listar professores ");
        return professorRepository.findAll();
    }

    @GetMapping(value = "/listarHabilidades") // @RequestMapping(value = "/listarCandidatos", method =
                                              // RequestMethod.GET)
    @ResponseBody // @ResponseBody permite retornar um texto
    public List<habilidade> getHabilidades() {
        System.out.println("listar habilidades ");
        return habilidadeRepository.findAll();
    }

    @GetMapping(value = "/CadOpcaoRespostasPergunta") // @RequestMapping(value = "/listarCandidatos", method =
                                                      // RequestMethod.GET)
    @ResponseBody // @ResponseBody permite retornar um texto
    public List<pergunta> setOpcaoRespostaPergunta() {
        System.out.println("cadastrar opcao respotas na pergunta");
        opcaoresposta or = new opcaoresposta("descricao op resposta 1", "verdadeira ou falso", false);
        or.setPerguntas(perguntaRepository.findAll());

        opcaorespostaRepository.save(or);
        return perguntaRepository.findAll();
    }

    @GetMapping(value = "/CadPerguntasQuestInicial") // @RequestMapping(value = "/listarCandidatos", method =
                                                     // RequestMethod.GET)
    @ResponseBody // @ResponseBody permite retornar um texto
    public List<questionarioinicial> setPerguntasQuestInicial() {
        System.out.println("cadastrar perguntas no questionario inicial");
        perguntaquestionario pq = new perguntaquestionario("pergunta 1 do questionario", "discursiva");
        questionarioinicial qi = new questionarioinicial(LocalDate.of(2022, 8, 10), false, "questionario inicial 1");
        perguntaquestionarioRepository.save(pq);
        qi.setPerguntasQuestionario(perguntaquestionarioRepository.findAll());
        questionarioinicialRepository.save(qi);

        return questionarioinicialRepository.findAll();
    }

    @GetMapping(value = "/CadAlunoQuestionario") // @RequestMapping(value = "/listarCandidatos", method =
                                                 // RequestMethod.GET)
    @ResponseBody // @ResponseBody permite retornar um texto
    public List<questionarioinicial> setAlunoQuestInicial() {
        System.out.println("cadastrar aluno no Questionario inicial");

        questionarioinicial qin = questionarioinicialRepository.findAll().get(0);
        qin.setAlunos(alunoRepository.findAll());
        questionarioinicialRepository.save(qin);
        return questionarioinicialRepository.findAll();
    }

    /* LOGIN */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/index/inicial";
    }
    /* LOGIN */
    /* PAGINA INICIAL(TODOS) */

    @GetMapping(value = "/index/inicial")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        List<turma> lturma = turmaRepository.findAll();
        mv.addObject("turmas", lturma);
        return mv;
    }
    /* PAGINA INICIAL(TODOS) */

    /* DELETAR UNIDADE(PROFESSORES/ADMIN) */
    @GetMapping(value = "/index/deletealuno/{id}")
    public String deleteAluno(@PathVariable("id") int id, RedirectAttributes attributes) {
        try {
            alunoRepository.deleteById(id);
            attributes.addFlashAttribute("sucesso", "Aluno deletado");
            return "redirect:/index/alunos";
        } catch (Exception e) {
            attributes.addFlashAttribute("erro", "id inexistente ou erro desconhecido");
            return "redirect:/index/alunos";
        }
    }

    @GetMapping(value = "/index/deletehabilidade/{id}")
    public String deleteHabilidade(@PathVariable("id") int id, RedirectAttributes attributes) {
        try {
            habilidadeRepository.deleteById(id);
            attributes.addFlashAttribute("sucesso", "Habilidade deletada");
            return "redirect:/index/habilidades";
        } catch (Exception e) {
            attributes.addFlashAttribute("erro", "id inexistente ou erro desconhecido");
            return "redirect:/index/habilidades";
        }
    }

    @GetMapping(value = "/index/deletepergunta/{id}")
    public String deletePergunta(@PathVariable("id") int id, RedirectAttributes attributes) {
        try {
            perguntaRepository.deleteById(id);
            attributes.addFlashAttribute("sucesso", "Pergunta deletada");
            return "redirect:/index/perguntas";
        } catch (Exception e) {
            attributes.addFlashAttribute("erro", "ID inexistente ou erro desconhecido");
            return "redirect:/index/perguntas";
        }
    }

    @GetMapping(value = "/index/deleteprofessor/{id}")
    public String deleteProfessor(@PathVariable("id") int id, RedirectAttributes attributes) {
        try {
            professorRepository.deleteById(id);
            attributes.addFlashAttribute("sucesso", "Professor deletado");
            return "redirect:/index/professores";
        } catch (Exception e) {
            attributes.addFlashAttribute("erro", "ID inexistente ou erro desconhecido");
            return "redirect:/index/professores";
        }
    }

    @GetMapping(value = "/index/deleteteste/{id}")
    public String deleteTeste(@PathVariable("id") int id, RedirectAttributes attributes) {
        try {
            testeRepository.deleteById(id);
            attributes.addFlashAttribute("sucesso", "Teste deletado");
            return "redirect:/index/testes";
        } catch (Exception e) {
            attributes.addFlashAttribute("erro", "ID inexistente ou erro desconhecido");
            return "redirect:/index/testes";
        }
    }

    @GetMapping(value = "/index/deleteturma/{id}")
    public String deleteTurma(@PathVariable("id") int id, RedirectAttributes attributes) {
        try {
            turmaRepository.deleteById(id);
            attributes.addFlashAttribute("sucesso", "Turma deletada");
            return "redirect:/index/turmas";
        } catch (Exception e) {
            attributes.addFlashAttribute("erro", "ID inexistente ou erro desconhecido");
            return "redirect:/index/turmas";
        }
    }

    @GetMapping(value = "/index/pergunta/deleteopcaoresposta/{id}")
    public String deleteOpcaoResposta(@PathVariable("id") int id, RedirectAttributes attributes) {
        try {
            opcaorespostaRepository.deleteById(id);
            attributes.addFlashAttribute("sucesso", "Opção-Resposta deletada");
            return "redirect:/index/pergunta/opcoesresposta/{id}";
        } catch (Exception e) {
            attributes.addFlashAttribute("erro", "ID inexistente ou erro desconhecido");
            return "redirect:/index/pergunta/opcoesresposta/{id}";
        }
    }
    /* DELETAR UNIDADE(PROFESSORES/ADMIN) */

    /* CADASTRAR UNIDADE(PROFESSORES/ADMIN) */
    @GetMapping("/index/saveAluno")
    public String getSaveAluno() {
        return "saveAluno";
    }

    @PostMapping("/index/saveAluno")
    public String saveAluno(@Valid aluno a, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("erro", "Verifique os campos obrigatórios:" + a.toString());
            return "redirect:/index/saveAluno";
        }
        alunoRepository.save(a);
        attributes.addFlashAttribute("sucesso", "Aluno cadastrado");
        return "redirect:/index/alunos";
    }

    @GetMapping("/index/saveHabilidade")
    public String getSaveHabilidade() {
        return "saveHabilidade";
    }

    @PostMapping("/index/saveHabilidade")
    public String saveHabilidade(@Valid habilidade h, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("erro", "Verifique os campos obrigatórios:" + h.toString());
            return "redirect:/index/saveHabilidade";
        }
        habilidadeRepository.save(h);
        attributes.addFlashAttribute("sucesso", "Habilidade cadastrada");
        return "redirect:/index/habilidades";
    }

    @GetMapping("/index/teste/savePergunta/{id}")
    public ModelAndView getSavePergunta(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("savePergunta");
        mv.addObject("testeId", id);
        return mv;
    }

    @PostMapping("/index/teste/savePergunta/{id}")
    // @Transactional
    public String savePergunta(@PathVariable("id") int testeId, @Valid pergunta pergunta,
            @RequestParam("file") MultipartFile img, RedirectAttributes attributes, BindingResult result) {
        teste t = testeRepository.findById(testeId).orElseThrow(null);
        List<pergunta> lperg = t.getPerguntas();
        System.out.println(pergunta.getDescricao());

        try {
            if (!img.isEmpty()) {
                try {
                    byte[] bytes = img.getBytes();
                    Path caminho = Paths.get("./src/main/resources/static/images/" + img.getOriginalFilename());
                    Files.write(caminho, bytes);
                    pergunta.setImg(img.getOriginalFilename());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                pergunta.setImg(null);
            }

            perguntaRepository.save(pergunta);
            lperg.add(pergunta);
            t.setPerguntas(lperg);
            testeRepository.save(t);
            attributes.addFlashAttribute("sucesso", "Pergunta cadastrada");
            return "redirect:/index/teste/perguntas/{id}";
        } catch (Exception e) {
            attributes.addFlashAttribute("erro", e.toString());
            return "redirect:/index/teste/perguntas/{id}";
        }

    }

    @GetMapping("/index/saveProfessor")
    public String getSaveProfessor() {
        return "saveProfessor";
    }

    @PostMapping("/index/saveProfessor")
    public String saveProfessor(@Valid professor p, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("erro", "Verifique os campos obrigatórios:" + p.toString());
            return "redirect:/index/saveProfessor";
        }
        professorRepository.save(p);
        attributes.addFlashAttribute("sucesso", "Professor cadastrado");
        return "redirect:/index/professores";
    }

    @GetMapping("/index/saveTeste")
    public String getSaveTeste() {
        return "saveTeste";
    }

    @PostMapping("/index/saveTeste")
    public String saveTeste(@Valid teste t, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("erro", "Verifique os campos obrigatórios:" + t.toString());
            return "redirect:/index/saveTeste";
        }
        testeRepository.save(t);
        attributes.addFlashAttribute("sucesso", "Teste cadastrado");
        return "redirect:/index/testes";
    }

    @GetMapping("/index/saveTurma")
    public String getSaveTurma() {
        return "saveTurma";
    }

    @PostMapping("/index/saveTurma")
    public String saveTurma(@Valid turma t, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("erro", "Verifique os campos obrigatórios:" + t.toString());
            return "redirect:/index/saveTurma";
        }
        turmaRepository.save(t);
        attributes.addFlashAttribute("sucesso", "Turma cadastrada");
        return "redirect:/index/turmas";
    }

    @GetMapping("/index/pergunta/saveopcaoresposta/{id}")
    public ModelAndView getSaveOpcaoResposta(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("saveOpcaoresposta");
        mv.addObject("perguntaId", id);
        return mv;
    }

    @PostMapping("/index/pergunta/saveopcaoresposta/{id}")
    public String saveOpcaoResposta(@PathVariable("id") int id, @Valid opcaoresposta or, BindingResult result,
            RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("erro", "Verifique os campos obrigatórios:" + or.toString());
            return "redirect:/index/pergunta/saveopcaoresposta/{id}";
        }
        opcaorespostaRepository.save(or);
        pergunta p = perguntaRepository.findById(id).orElseThrow(null);
        List<opcaoresposta> listOR = p.getOpcoesResposta();
        listOR.add(or);
        p.setOpcoesResposta(listOR);
        perguntaRepository.save(p);
        attributes.addFlashAttribute("sucesso", "Turma cadastrada");
        return "redirect:/index/pergunta/opcoesresposta/{id}";
    }
    /* CADASTRAR UNIDADE(PROFESSORES/ADMIN) */

    /* LISTAR DADOS(PROFESSORES/ADMIN) */
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
    public ModelAndView getOpcoesRespostaPergunta(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("opcaoresposta");
        pergunta p = perguntaRepository.findById(id).orElseThrow(null);
        List<opcaoresposta> opR = p.getOpcoesResposta();
        mv.addObject("opcoesrespostas", opR);
        mv.addObject("perguntaId", p.getPerguntaId());
        return mv;
    }

    /* DADOS EM LISTA(PROFESSORES/ADMIN) */
    @PostMapping("/index/cadAlunoTurma/{id}")
    public String cadAlunoTurma(@PathVariable("id") int turmaId, @RequestParam("matricula") String matricula,
            RedirectAttributes redirectAttributes) {
        if (matricula.equalsIgnoreCase("")) {
            redirectAttributes.addFlashAttribute("erro", "insira a sua matricula");
            return "redirect:/index/inicial";
        } else {
            turma t = turmaRepository.findById(turmaId).orElseThrow(null);
            t.getAlunos().add(alunoRepository.findByMatricula(matricula).get(0));
            turmaRepository.save(t);
            redirectAttributes.addFlashAttribute("sucesso", "Inscrição realizada com sucesso");
            return "redirect:/index/inicial";
        }
    }

    @GetMapping(value = "/index/aplicacaoteste/{id}")
    public ModelAndView getTesteAplication(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("aplicacaoTeste");

        teste t = testeRepository.findById(id).orElseThrow(null);

        List<pergunta> perguntas = t.getPerguntas();
        mv.addObject("perguntas", perguntas);
        mv.addObject("testeNome", t.getNome());
        mv.addObject("testeId", t.getTesteId());
        return mv;

    }

    @PostMapping(value = "/index/aplicacaoteste/{id}")
    public String setTesteAplication(@PathVariable("id") int testeId, @ModelAttribute perguntasForm lresp,
            RedirectAttributes attributes) {
        try {
            teste t = testeRepository.findById(testeId).orElseThrow(null);
        List<resposta> ListRespostas = new ArrayList<>();
        registro reg = new registro();
        if (alunoRepository.findByMatricula(lresp.getMatricula().trim()).size()>0) {
            for (pergunta Pergunta : lresp.getPerguntas()) {
                resposta resposta = new resposta();
                pergunta p = perguntaRepository.findById(Pergunta.getPerguntaId()).orElseThrow(null);
                resposta.setPergunta(p);
                resposta.setOpRespostaId(Integer.valueOf(Pergunta.getOpRespostaId()));
                ListRespostas.add(resposta);
            }
            reg.setAluno(alunoRepository.findByMatricula(lresp.getMatricula()).get(0));
            reg.setTeste(t);
            reg.setRespostas(ListRespostas);
            registroRepository.save(reg);
            attributes.addFlashAttribute("sucesso", "Teste Respondido com sucesso");
            return "redirect:/index/inicial";
        }else{ 
            attributes.addFlashAttribute("erro", "Matricula não encontrada");
            return "redirect:/index/inicial";
        }
        } catch (Exception e) {
            attributes.addFlashAttribute("erro", "Teste não foi respondido com sucesso"+e);
            return "redirect:/index/inicial";
        }
    }

    @GetMapping(value = "/index/resultadosTeste")
    public ModelAndView getResultadosTeste() {
        ModelAndView mv = new ModelAndView("resultTeste");
        List<registro> lreg = registroRepository.findAll();
        System.out.println(lreg.toString());
        mv.addObject("registros", lreg);
        return mv;
    }

    @GetMapping(value = "/index/teste/perguntas/{id}")
    public ModelAndView getPerguntasPorTeste(@PathVariable("id") int testeId) {
        ModelAndView mv = new ModelAndView("pergunta");
        teste t = testeRepository.findById(testeId).orElseThrow(null);
        mv.addObject("testeId", t.getTesteId());
        mv.addObject("testeNome", t.getNome());
        mv.addObject("perguntas", t.getPerguntas());

        return mv;
    }

    @GetMapping("/index/pergunta/habilidades/{perguntaId}/{testeId}")
    @ResponseBody
    public ModelAndView getHabilidadesPergunta(@PathVariable("perguntaId") int perguntaId,
            @PathVariable("testeId") int testeId) {
        ModelAndView mv = new ModelAndView("habilidade");
        List<habilidade> lh = habilidadeRepository.findAll();
        mv.addObject("habilidades", lh);
        mv.addObject("perguntaId", perguntaId);
        mv.addObject("testeId", testeId);
        return mv;
    }

    @PostMapping("/index/pergunta/habilidades/{perguntaId}/{testeId}")
    public String setHabilidadePergunta(@PathVariable("perguntaId") int perguntaId,
            @PathVariable("testeId") int testeId, @ModelAttribute habForm lhab, RedirectAttributes attributes) {
        List<habilidade> Allhabilidades = habilidadeRepository.findAll();
        List<habilidade> ListHabilidade = new ArrayList<>();

        try {
            pergunta p = perguntaRepository.findById(perguntaId).orElseThrow(null);
            System.out.println("PerguntaID: " + p.getPerguntaId());
            System.out.println(lhab.getHabilidades().toString());

            for (habilidade h : lhab.getHabilidades()) {
                for (habilidade hab : Allhabilidades) {
                    if (h.getHabilidadeId() == hab.getHabilidadeId()) {
                        ListHabilidade.add(hab);
                    }

                }
            }
            p.setHabilidades(ListHabilidade);
            perguntaRepository.save(p);

            attributes.addFlashAttribute("sucesso", "habilidade cadastrada");
            return "redirect:/index/teste/perguntas/{testeId}";
        } catch (Exception e) {
            attributes.addFlashAttribute("erro", e.toString());
            return "redirect:/index/teste/perguntas/{testeId}";
        }

    }

    //////////////////////////// IMAGEM /////////////////////////////////////
    @GetMapping("index/imagem/{img}")
    @ResponseBody
    public byte[] getImg(@PathVariable("img") String img) throws IOException {
        File imagemArquivo = new File("./src/main/resources/static/images/" + img);
        if (img != null || img.trim().length() > 0) {

            return Files.readAllBytes(imagemArquivo.toPath());
        }

        return null;
    }

    @GetMapping("/index/teste/perguntas/{id}/imagem/{img}")
    @ResponseBody
    public byte[] getImgPost(@PathVariable("img") String img) throws IOException {
        File imagemArquivo = new File("./src/main/resources/static/images/" + img);
        if (img != null || img.trim().length() > 0) {

            return Files.readAllBytes(imagemArquivo.toPath());
        }

        return null;
    }

    @GetMapping("/index/teste/{id}/imagem/{img}")
    @ResponseBody
    public byte[] getImgTeste(@PathVariable("img") String img) throws IOException {
        File imagemArquivo = new File("./src/main/resources/static/images/" + img);
        if (img != null || img.trim().length() > 0) {

            return Files.readAllBytes(imagemArquivo.toPath());
        }

        return null;
    }
    @GetMapping("/index/aplicacaoteste/{id}/imagem/{img}")
    @ResponseBody
    public byte[] getImgAplicacaoTeste(@PathVariable("img") String img) throws IOException {
        File imagemArquivo = new File("./src/main/resources/static/images/" + img);
        if (img != null || img.trim().length() > 0) {

            return Files.readAllBytes(imagemArquivo.toPath());
        }

        return null;
    }

    //////////////////////////// FIM IMAGEM//////////////////////////////
    //////////////////////////// UPDATE////////////////////////////////////
    @GetMapping("/index/updateteste/{id}")
    @ResponseBody
    public ModelAndView getTesteUpdate(@PathVariable("id") int testeId) {
        ModelAndView mv = new ModelAndView("updateTeste");
        try {
            teste testeExistente = testeRepository.findById(testeId).orElseThrow(null);
            mv.addObject("teste", testeExistente);
        } catch (Exception e) {
            System.out.println("ERRO SISTEMA:" + e);
        }
        return mv;
    }

    @PostMapping("/index/updateteste/{id}")
    public String setTesteUpdate(@PathVariable("id") int testeId, @Valid teste novoteste,
            RedirectAttributes redirectAttributes, BindingResult result) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("erro", "Confira os campos obrigatórios" + result);
            return "redirect:/index/updateteste/{id}";
        }
        try {
            teste testeExistente = testeRepository.findById(testeId).orElseThrow(null);
            testeExistente.setDisponibilidade(novoteste.getDisponibilidade());
            testeExistente.setNome(novoteste.getNome());
            testeExistente.setVisibilidade(novoteste.getVisibilidade());
            testeRepository.save(testeExistente);
            redirectAttributes.addFlashAttribute("sucesso", "Teste alterado com sucesso");
            return "redirect:/index/testes";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Não foi possivel executar" + e);
            return "redirect:/index/testes";
        }
    }

    @GetMapping("/index/updatepergunta/{id}")
    @ResponseBody
    public ModelAndView getPerguntaUpdate(@PathVariable("id") int perguntaId) {
        ModelAndView mv = new ModelAndView("updatePergunta");
        try {
            pergunta perguntaExistente = perguntaRepository.findById(perguntaId).orElseThrow(null);
            mv.addObject("pergunta", perguntaExistente);
        } catch (Exception e) {
            System.out.println("ERRO SISTEMA:" + e);
        }
        return mv;
    }

    @PostMapping("/index/updatepergunta/{id}")
    public String setPerguntaUpdate(@PathVariable("id") int perguntaId, @Valid pergunta novaPergunta,
            RedirectAttributes redirectAttributes, BindingResult result, @RequestParam("file") MultipartFile img) {
        try {
            pergunta perguntaExistente = perguntaRepository.findById(perguntaId).orElseThrow(null);
            perguntaExistente.setDescricao(novaPergunta.getDescricao());

            if (img.isEmpty()) {
                novaPergunta.setImg(null);
            } else {
                byte[] bytes = img.getBytes();
                Path caminho = Paths.get("./src/main/resources/static/images/" + img.getOriginalFilename());
                Files.write(caminho, bytes);
                perguntaExistente.setImg(img.getOriginalFilename());
            }
            perguntaRepository.save(perguntaExistente);
            redirectAttributes.addFlashAttribute("sucesso", "Pergunta Editada com sucesso");
            return "redirect:/index/testes";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Não foi possivel editar" + e);
            return "redirect:/index/testes";

        }
    }

    @GetMapping("/index/updateopcaoresposta/{id}")
    @ResponseBody
    public ModelAndView getOpcaoRespostaUpdate(@PathVariable("id") int opcaoRespostaId) {
        ModelAndView mv = new ModelAndView("updateOpcaoresposta");
        try {
            opcaoresposta op = opcaorespostaRepository.findById(opcaoRespostaId).orElseThrow(null);
            mv.addObject("opcaoresposta", op);
        } catch (Exception e) {
            System.out.println("ERRO:" + e);
        }
        return mv;
    }

    @PostMapping("/index/updateopcaoresposta/{id}")
    public String setOpcaoRespostaUpdate(@PathVariable("id") int opcaoRespostaId,
            @Valid opcaoresposta novaOpcaoresposta, RedirectAttributes redirectAttributes, BindingResult result) {
        try {
            opcaoresposta opcaorespostaExistente = opcaorespostaRepository.findById(opcaoRespostaId).orElseThrow(null);
            opcaorespostaExistente.setTipo(novaOpcaoresposta.getTipo());
            opcaorespostaExistente.setDescricao(novaOpcaoresposta.getDescricao());
            opcaorespostaExistente.setVerdadeira(novaOpcaoresposta.isVerdadeira());
            opcaorespostaRepository.save(opcaorespostaExistente);
            redirectAttributes.addFlashAttribute("sucesso", "OpcaoResposta Editada com sucesso");
            return "redirect:/index/testes";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Não foi possivel editar" + e);
            return "redirect:/index/testes";

        }
    }

    @GetMapping("/index/updatehabilidade/{id}")
    @ResponseBody
    public ModelAndView getHabilidadeUpdate(@PathVariable("id") int habilidadeId) {
        ModelAndView mv = new ModelAndView("updateHabilidade");
        try {
            habilidade hab = habilidadeRepository.findById(habilidadeId).orElseThrow(null);
            mv.addObject("habilidade", hab);
        } catch (Exception e) {
            System.out.println("ERRO" + e);
        }
        return mv;
    }

    @PostMapping("/index/updatehabilidade/{id}")
    public String setHabilidadeUpdate(@PathVariable("id") int habilidadeId, @Valid habilidade novahabilidade,
            RedirectAttributes redirectAttributes, BindingResult result) {
        try {
            habilidade habilidadeExistente = habilidadeRepository.findById(habilidadeId).orElseThrow(null);
            habilidadeExistente.setNome(novahabilidade.getNome());
            habilidadeRepository.save(habilidadeExistente);
            redirectAttributes.addFlashAttribute("sucesso", "Habilidade Editada com sucesso");
            return "redirect:/index/testes";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Não foi possivel editar" + e);
            return "redirect:/index/testes";

        }
    }
    ///////////////////////////// FIM UPDATE//////////////////////////////

    @GetMapping("/index/relatorio")
    @ResponseBody
    public ModelAndView getRelatorio() {
        List<registro> regs = registroRepository.findAll();
        ModelAndView mv = new ModelAndView("relatorioTeste");

        List<correcoesAluno> correcaoList = new ArrayList<>();
        List<contabilizacao> contabilizacaoList = new ArrayList<>();
        int nQcorretas = 0;
        int nQChab1 = 0;
        int nQChab2 = 0;
        int nQChab3 = 0;
        int nQChab4 = 0;
        int nQChab5 = 0;
        int nQ = 0;
        for (registro r : regs) {
            nQcorretas = 0;
            nQChab1 = 0;
            nQChab2 = 0;
            nQChab3 = 0;
            nQChab4 = 0;
            nQChab5 = 0;
            nQ = r.getTeste().getPerguntas().size();
            for (resposta resp : r.getRespostas()) {

                if (resp.getOpRespostaId() == opcaorespostaRepository
                        .findOpcaoRespostaIdByPerguntasAndVerdadeira(resp.getPergunta(), true).get(0)
                        .getOpcaoRespostaId()) {
                    correcoesAluno cA = new correcoesAluno(r.getAluno().getAlunoId(), r.getTeste().getTesteId(),
                            r.getTeste().getNome(), resp.getPergunta().getPerguntaId(), resp.getOpRespostaId(), true);

                    nQcorretas++;
                    for (habilidade h : resp.getPergunta().getHabilidades()) {
                        switch (h.getNome()) {
                            case "compreensao":
                                nQChab1++;
                                break;
                            case "abstracao":
                                nQChab2++;
                                break;
                            case "resolucao de problemas":
                                nQChab3++;
                                break;
                            case "resolucao algoritmica":
                                nQChab4++;
                                break;
                            case "avaliacao":
                                nQChab5++;
                                break;
                            default:
                                break;
                        }
                    }
                    correcaoList.add(cA);
                } else {
                    correcoesAluno cA = new correcoesAluno(r.getAluno().getAlunoId(), r.getTeste().getTesteId(),
                            r.getTeste().getNome(), resp.getPergunta().getPerguntaId(), resp.getOpRespostaId(), false);
                    correcaoList.add(cA);
                }
            }
            var contQH = new contabilizacao(r.getAluno().getAlunoId(), r.getTeste().getTesteId(), nQcorretas, nQChab1,
                    nQChab2, nQChab3, nQChab4, nQChab5, nQ);
            contabilizacaoList.add(contQH);
        }

        mv.addObject("correcaoList", correcaoList);
        mv.addObject("contabilizacoes", contabilizacaoList);

        return mv;
    }
}

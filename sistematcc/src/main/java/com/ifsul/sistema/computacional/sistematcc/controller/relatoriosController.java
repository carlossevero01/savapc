package com.ifsul.sistema.computacional.sistematcc.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifsul.sistema.computacional.sistematcc.model.correcoesUsuario;
import com.ifsul.sistema.computacional.sistematcc.model.notas;
import com.ifsul.sistema.computacional.sistematcc.model.turma;
import com.ifsul.sistema.computacional.sistematcc.repository.correcoesUsuarioRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.notasRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.questionarioinicialRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.regQuestionariosRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.regTestesRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.testeRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.turmaRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.usuarioRepository;
import com.ifsul.sistema.computacional.sistematcc.service.serviceImplements.notasServiceImplements;
import com.ifsul.sistema.computacional.sistematcc.service.serviceImplements.regTestesServiceImplements;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class relatoriosController {
    @Autowired
    regTestesRepository regTestesRepository;
    @Autowired
    regQuestionariosRepository regQuestionariosRepository;
    @Autowired
    testeRepository testeRepository;
    @Autowired
    questionarioinicialRepository questionarioinicialRepository;

    @Autowired
    regTestesServiceImplements regTestesServiceImplements;
    @Autowired
    turmaRepository turmaRepository;
    @Autowired
    usuarioRepository usuarioRepository;

    @Autowired
    notasRepository notasRepository;
    @Autowired
    correcoesUsuarioRepository correcoesUsuarioRepository;

    @Autowired
    notasServiceImplements notasServiceImplements;

    /* Exibir relatorio de Perguntas de uma turma */
    @GetMapping("/index/relatorioPergunta/{turmaId}")
    @ResponseBody
    public ModelAndView getRelatorio(@PathVariable("turmaId") int turmaId) {
        ModelAndView mv = new ModelAndView("relatorioComPerguntas");
        try {
            regTestesServiceImplements.fazerCorrecaoTestes();

        } catch (Exception e) {
            return mv;
        }
        turma t = turmaRepository.findById(turmaId).get();
        List<correcoesUsuario> correcao = correcoesUsuarioRepository.findByTurmaOrderByUsuario(t);
        System.out.println("\n \n asd" + correcao.toString() + "\n Size:" + correcao.size());
        mv.addObject("correcao", correcao);
        mv.addObject("turmaNome", t.getNome());
        return mv;
    }

    /* Atualiza relatório de habilidades e exibe novamente */
    @GetMapping("/atualizarRelatorio/{turmaId}")
    public String setUpdateRelatorio(@PathVariable("turmaId") int turmaId, RedirectAttributes redirectAttributes) {
        turma turma = turmaRepository.findById(turmaId).get();
        try {
            regTestesServiceImplements.fazerCorrecaoTestes();
            notasServiceImplements.SalvarNotas(turma);
            return "redirect:/index/relatorioTeste/{turmaId}";
        } catch (Exception e) {
            return "redirect:/index/relatorioTeste/{turmaId}";
        }

    }

    /* Exibe relatorio de habilidades de uma turma */
    @GetMapping("/index/relatorioTeste/{turmaId}")
    @ResponseBody
    public ModelAndView getRelatorioTurma(@PathVariable("turmaId") int turmaId) {
        ModelAndView mv = new ModelAndView("relatorioTestePorHabilidade");
        turma turma = turmaRepository.findById(turmaId).get();
        try {
            regTestesServiceImplements.fazerCorrecaoTestes();
            List<notas> contabilizacaoListTurma = notasRepository.findByTurma(turma);
            mv.addObject("contabilizacoes", contabilizacaoListTurma);
            mv.addObject("turma", turma);
            mv.addObject("turmaNome", turma.getNome());
            mv.addObject("turmaId", turma.getTurmaId());
            return mv;
        } catch (Exception e) {
            System.out.println("\n \n " + e + "\n \n ");
            return mv;
        }
    }

    @GetMapping("/index/exportarRelatorio/{turmaId}/download")
    public void download(HttpServletResponse response, @PathVariable("turmaId") int turmaId) throws IOException {
        turma turma = turmaRepository.findById(turmaId).get();
        String filename = "relatorio_PensamentoComputacional.csv";

        // Configura o tipo de conteúdo do arquivo de resposta
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");

        // Cria um arquivo CSV
        try (PrintWriter writer = response.getWriter()) {

            writer.write(
                    "Aluno,Turma,nPerguntasCorretas,nPerguntas,H1,H2,H3,H4,H5,NotaProjeto,NotaTestes,NotaFinal,SabeProgramar,Recomendação");
            List<notas> contabilizacaoListTurma = notasRepository.findByTurmaAndDesclassificado(turma, false);
            for (notas cL : contabilizacaoListTurma) {
                String line = String.format("\"%s\",%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
                        cL.getUsuario().getNome(), cL.getTurma().getNome(), cL.getnPerguntasCorretas(),
                        cL.getnPerguntas(), cL.getH1(), cL.getH2(), cL.getH3(), cL.getH4(), cL.getH5(),
                        cL.getNotaProjetoFinal(), cL.getNotaTestes(), cL.getNotaFinal(), cL.getSabeProgramar(),
                        cL.getRecomendacao());
                writer.append('\n');
                writer.write(line);
            }
            response.getWriter().flush();
        }
    }

    /* Exporta Relatório de Habilidades */
    @GetMapping("/index/exportarRelatorio/{turmaId}")
    public String exportRelatorioTurma(@PathVariable("turmaId") int turmaId, RedirectAttributes redirectAttributes) {
        try {
            String csvFilePath = "Reviews-export.csv";
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(csvFilePath));
            fileWriter.write(
                    "Aluno,Turma,nPerguntasCorretas,nPerguntas,H1,H2,H3,H4,H5,NotaProjeto,NotaTestes,NotaFinal,SabeProgramar,Recomendação");

            turma turma = turmaRepository.findById(turmaId).get();
            List<notas> contabilizacaoListTurma = notasRepository.findByTurmaAndDesclassificado(turma, false);
            for (notas cL : contabilizacaoListTurma) {
                String line = String.format("\"%s\",%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
                        cL.getUsuario().getNome(), cL.getTurma().getNome(), cL.getnPerguntasCorretas(),
                        cL.getnPerguntas(), cL.getH1(), cL.getH2(), cL.getH3(), cL.getH4(), cL.getH5(),
                        cL.getNotaProjetoFinal(), cL.getNotaTestes(), cL.getNotaFinal(), cL.getSabeProgramar(),
                        cL.getRecomendacao());

                fileWriter.newLine();
                fileWriter.write(line);

            }
            fileWriter.close();

            redirectAttributes.addFlashAttribute("sucesso", "Dados exportados com sucesso");
            return "redirect:/index/relatorioTeste/{turmaId}";
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("erro", "Não foi possivel exportar os dados");
            return "redirect:/index/relatorioTeste/{turmaId}";
        }
    }

    /* Atualiza nota de um aluno */
    @PostMapping("/index/updatenota/{turmaId}/{notaId}")
    public String setUpdateNota(@PathVariable("turmaId") int turmaId, @PathVariable("notaId") int notaId,
            @RequestParam(value = "elimin", required = false) String desclassificado, @RequestParam("nota") double nota,
            @RequestParam("recomendacao") String recomendacao, RedirectAttributes redirectAttributes) {
        try {

            turma turma = turmaRepository.findById(turmaId).get();

            if (notasRepository.findById(notaId) != null) {
                notas novaNota = notasRepository.findById(notaId).get();
                novaNota.setNotaProjetoFinal(nota);
                novaNota.setRecomendacao(recomendacao);
                if (desclassificado != null) {
                    novaNota.setDesclassificado(true);
                } else {
                    novaNota.setDesclassificado(false);
                }
                notasRepository.save(novaNota);
                notasServiceImplements.SalvarNotas(turma);
                redirectAttributes.addFlashAttribute("sucesso", "Nota editada com sucesso!");
                return "redirect:/index/relatorioTeste/{turmaId}";
            }

            redirectAttributes.addFlashAttribute("erro", "Nota nao encontrada!");
            return "redirect:/index/relatorioTeste/{turmaId}";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Nota não editada com sucesso!");
            return "redirect:/index/relatorioTeste/{turmaId}";
        }
    }

}

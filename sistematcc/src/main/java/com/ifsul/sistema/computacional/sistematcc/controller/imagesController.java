package com.ifsul.sistema.computacional.sistematcc.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class imagesController {


    @ResponseBody
    public byte[] getImg(@PathVariable("img") String img) throws IOException {
        File imagemArquivo = new File("./src/main/resources/static/images/" + img);
        if (img == null || img.length() <= 0) {
             return null;
            
        }
        return Files.readAllBytes(imagemArquivo.toPath());
       
    }

    @GetMapping("/index/teste/perguntas/{id}/imagem/{img}")
    @ResponseBody
    public byte[] getImgPost(@PathVariable("img") String img) throws IOException {
        File imagemArquivo = new File("./src/main/resources/static/images/" + img);
        if (img == null || img.length() <= 0) {
             return null;
            
        }
        return Files.readAllBytes(imagemArquivo.toPath());
    }

    @GetMapping("/index/teste/{id}/imagem/{img}")
    @ResponseBody
    public byte[] getImgTeste(@PathVariable("img") String img) throws IOException {
        File imagemArquivo = new File("./src/main/resources/static/images/" + img);
        if (img == null || img.length() <= 0) {
             return null;
            
        }
        return Files.readAllBytes(imagemArquivo.toPath());
    }
    @GetMapping("/index/aplicacaoteste/{turmaId}/{testeId}/imagem/{img}")
    @ResponseBody
    public byte[] getImgAplicacaoTeste(@PathVariable("img") String img) throws IOException {
        File imagemArquivo = new File("./src/main/resources/static/images/" + img);
        if (img == null || img.length() <= 0) {
             return null;
            
        }
        return Files.readAllBytes(imagemArquivo.toPath());
    }

}

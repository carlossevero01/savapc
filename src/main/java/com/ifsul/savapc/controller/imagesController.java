package com.ifsul.savapc.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class imagesController {

    private String classPath = "/opt/tomcat/webapps/savapc-1/WEB-INF/classes/static/images/";
    /*Mostrar imagem de login pelo thymeleaf*/
    @GetMapping("/images/{img}") // Ou ../static/images/login.jpg
    @ResponseBody
    public byte[] getImg3(@PathVariable("img") String img) throws IOException {
        File imagemArquivo = new File(classPath+img);
        if (img == null || img.length() <= 0) {
            return null;
        }
        return Files.readAllBytes(imagemArquivo.toPath());
    }
    /*Mostrar imagem em perguntaTeste do professor e na aplicação do teste do aluno*/
    @GetMapping("/auth/teste/pergunta/imagem/{img}")
    @ResponseBody
    public byte[] getImgPost(@PathVariable("img") String img) throws IOException {
        File imagemArquivo = new File(classPath+ img);
        if (img == null || img.length() <= 0) {
             return null;
        }
        return Files.readAllBytes(imagemArquivo.toPath());
    }


}

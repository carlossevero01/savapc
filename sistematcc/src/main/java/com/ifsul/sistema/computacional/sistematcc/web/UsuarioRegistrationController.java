package com.ifsul.sistema.computacional.sistematcc.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifsul.sistema.computacional.sistematcc.repository.usuarioRepository;
import com.ifsul.sistema.computacional.sistematcc.service.usuarioService;
import com.ifsul.sistema.computacional.sistematcc.web.dto.UsuarioRegistrationDto;

import jakarta.validation.Valid;



@Controller
public class UsuarioRegistrationController {
    private usuarioService usuarioService;
    @Autowired
    usuarioRepository usuarioRepository;
    public UsuarioRegistrationController(usuarioService usuariosServices) {
        super();
        this.usuarioService = usuariosServices;
    }

    @GetMapping("/registrationAluno")
    public String showRegistrationForm(){
        return "registrationAluno";
    }
    @PostMapping("registrationAluno")
    public String registerUserAccount(@Valid @ModelAttribute("usuario") UsuarioRegistrationDto usuario, @RequestParam("file") MultipartFile img, RedirectAttributes attributes, BindingResult result){
        if(result.hasErrors()){
            attributes.addFlashAttribute("erro","Consulte os campos obrigatórios");
            return "redirect:/registrationAluno?error";
        }
        if(!img.isEmpty()){
            try {
                byte[] bytes = img.getBytes();
                Path caminho = Paths.get("./src/main/resources/static/images/"+img.getOriginalFilename());
                Files.write(caminho,bytes);
                usuario.setImg(img.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            usuario.setImg("não selecionado");
        }
       if(usuarioRepository.findByUsername(usuario.getUsername())==null && usuarioRepository.findByIdentificadorLike(usuario.getIdentificador()).isEmpty()){
        usuarioService.save(usuario);
        attributes.addFlashAttribute("sucesso","Cadastro efetuado!");
        return "redirect:/registrationAluno?success";
       }else{
        attributes.addFlashAttribute("erro","Nome de usuário ou matricula ja existente.");
        return "redirect:/registrationAluno?error";
       }
        
        
    }
}

package com.ifsul.sistema.computacional.sistematcc.service.serviceImplements;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ifsul.sistema.computacional.sistematcc.model.Role;
import com.ifsul.sistema.computacional.sistematcc.model.turma;
import com.ifsul.sistema.computacional.sistematcc.model.usuario;
import com.ifsul.sistema.computacional.sistematcc.repository.roleRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.usuarioRepository;
import com.ifsul.sistema.computacional.sistematcc.service.usuarioService;
import com.ifsul.sistema.computacional.sistematcc.web.dto.UsuarioRegistrationDto;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class usuarioServiceImplements implements usuarioService{
    @Autowired
    usuarioRepository usuarioRepository;
    @Autowired
    roleRepository roleRepository;

    public usuarioServiceImplements(usuarioRepository usuarioRepository) {
        super();
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<usuario> findByIdentificadorLike(String identificador) { return usuarioRepository.findByIdentificadorLike(identificador); }
    
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        usuario user = usuarioRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
         
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    
    }
    @Override
    public List<usuario> findAll() {
        return usuarioRepository.findAll();
    }
    @Override
    public usuario findById(Integer id) {
        return usuarioRepository.findById(id).get();
    }
    @Override
    public usuario save(UsuarioRegistrationDto registrationDto) {
       
       usuario user = new usuario(registrationDto.getNome(),
        registrationDto.getEmail(), registrationDto.getTelefone(),registrationDto.getTipo(),
        registrationDto.getIdentificador(),LocalDate.parse(registrationDto.getDataNascimento()) ,registrationDto.getImg(),
        registrationDto.getUsername(),
        new BCryptPasswordEncoder().encode(registrationDto.getPassword()), Arrays.asList(new Role( "ROLE_ALUNO")));

    if(roleRepository.findByNameLike("ROLE_ALUNO")==null || roleRepository.findByNameLike("ROLE_PROF")==null){
           if(registrationDto.getTipo().equalsIgnoreCase("aluno")){
                user.setRoles(Arrays.asList(new Role("ROLE_ALUNO")));
                return usuarioRepository.save(user);
           }else{
                user.setRoles(Arrays.asList(new Role("ROLE_PROF")));
                return usuarioRepository.save(user);
           }
           
    }else{  
        if(registrationDto.getTipo().equalsIgnoreCase("aluno")){
            user.setRoles(Arrays.asList( roleRepository.findByNameLike("ROLE_ALUNO")));
            return usuarioRepository.save(user);
        }
        else{
            user.setRoles(Arrays.asList( roleRepository.findByNameLike("ROLE_PROF")));
            return usuarioRepository.save(user);
        }
            
    } 
    }
    @Override
    public usuario save(usuario usuarioexistente) {
        
    if(roleRepository.findByNameLike("ROLE_ALUNO")==null || roleRepository.findByNameLike("ROLE_PROF")==null){
            if(usuarioexistente.getTipo().equalsIgnoreCase("aluno")){
                usuarioexistente.setRoles(Arrays.asList(new Role("ROLE_ALUNO")));
                return usuarioRepository.save(usuarioexistente);
            }else{
                usuarioexistente.setRoles(Arrays.asList(new Role("ROLE_PROF")));
                return usuarioRepository.save(usuarioexistente);
            }
            
        
    }else{
        if(usuarioexistente.getTipo().equalsIgnoreCase("aluno")){
            usuarioexistente.setRoles(Arrays.asList( roleRepository.findByNameLike("ROLE_ALUNO")));
            return usuarioRepository.save(usuarioexistente);
        }else{
            usuarioexistente.setRoles(Arrays.asList( roleRepository.findByNameLike("ROLE_PROF")));
            return usuarioRepository.save(usuarioexistente);
        }
            
        
    } 
    }
    @Override
    public usuario findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }
    @Override
    public List<usuario> findByNomeLike(String nome) {
        return usuarioRepository.findByNomeLike(nome);
    }
    
    @Override
    public usuario deleteById(Integer id) { return deleteById(id);}
    
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(Role -> new SimpleGrantedAuthority(Role.getName())).collect(Collectors.toList());
    }

    @Override
    public List<usuario> findByTipoLike(String tipo) {
        return usuarioRepository.findByTipoLike(tipo);
    }

    @Override
    public List<usuario> findByTurmasIn(List<turma> turmas) {
        return usuarioRepository.findByTurmasIn(turmas);
    }
    
}

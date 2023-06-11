package com.ifsul.sistema.computacional.sistematcc.configs.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.ifsul.sistema.computacional.sistematcc.service.usuarioService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  {
    @Autowired
    usuarioService usuarioService;
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        
        .authorizeHttpRequests((requests) -> requests
            .requestMatchers("/login","/", "/index/inicial","/registrationAluno/**","/js/**","/css/**","/images/**").permitAll()
            .requestMatchers("/turmas", "/index/turma/**").hasAnyRole("ALUNO","PROF")
            .requestMatchers(HttpMethod.POST, "index/aplicacaoteste/**/","/index/aplicacaoquest/**").hasAnyRole("ALUNO","PROF")
            .requestMatchers("index/aplicacaoteste/**","/index/aplicacaoquest/**").hasAnyRole("ALUNO","PROF")
            .requestMatchers("index/**").hasRole("PROF")
            .anyRequest().authenticated()
            
        )
        .formLogin((form) -> form
				.loginPage("/login")
				.permitAll()
			)
			.logout((logout) -> logout
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
            .permitAll())
            .userDetailsService(usuarioService);
        
        
        
        
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    

   
    
    

    

    

   
}
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
public class WebSecurityConfig {
    @Autowired
    usuarioService usuarioService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/").permitAll()
                        .requestMatchers(HttpMethod.POST).permitAll()
                        .requestMatchers("/index/inicial", "/login", "/registrationAluno", "/images/**", "/js/**",
                                "/css/**")
                        .permitAll()
                        .requestMatchers("/turmas", "/index/turma/*", "/index/aplicacaoteste/**",
                                "/index/aplicacaoquest/**")
                        .hasAnyRole("ALUNO", "PROF")
                        .requestMatchers("index/**").hasRole("PROF")
                        .anyRequest().authenticated()
                // .and().cors()

                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/index/inicial", true)
                        .permitAll())
                .userDetailsService(usuarioService)
                .logout((logout) -> logout
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login?logout")
                        .permitAll());

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
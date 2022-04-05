package br.com.alura.forum.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  //Configuracoes de autenticacao (login)
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

  }

  //Configuracoes de Autorizacao
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests()
        .antMatchers(HttpMethod.GET,"/topicos").permitAll()
        .antMatchers(HttpMethod.GET,"/topicos/*").permitAll();
  }

  //Configuracoes de recursos estaticos (js, css, imagens, etc.)
  @Override
  public void configure(WebSecurity web) throws Exception {

  }
}

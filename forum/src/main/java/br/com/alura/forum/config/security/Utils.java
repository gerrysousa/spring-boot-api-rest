package br.com.alura.forum.config.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Utils {

  public static void main(String[] args) {
    // Metodo para gerar a senha criptografada
    System.out.println(new BCryptPasswordEncoder().encode("123456"));
  }
}

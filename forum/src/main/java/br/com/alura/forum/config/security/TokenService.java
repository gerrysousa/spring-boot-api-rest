package br.com.alura.forum.config.security;

import br.com.alura.forum.modelo.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

  @Value("${forum.jwt.expiration}")
  private String expiration;

  @Value("${forum.jwt.secret}")
  private String secret;


  public String gerarToken(Authentication authentication) {
    Usuario logado = (Usuario) authentication.getPrincipal();
    Date agora = new Date();
    Date expiracao = new Date(agora.getTime() + Long.parseLong(expiration));

    return Jwts.builder()
        .setIssuer("Api do Forum da Alura")
        .setSubject(logado.getId().toString())
        .setIssuedAt(agora)
        .setExpiration(expiracao)
        .signWith(SignatureAlgorithm.HS256, secret)
        .compact();
  }

  public boolean isTokenValido(String token) {
    try {
      Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}

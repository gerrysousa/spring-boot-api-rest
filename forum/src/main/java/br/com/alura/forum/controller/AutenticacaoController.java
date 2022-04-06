package br.com.alura.forum.controller;


import br.com.alura.forum.controller.form.LoginForm;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

  @PostMapping
  public ResponseEntity<?> autenticar(@RequestBody @Valid LoginForm login) {
    System.out.println(login.getEmail());
    System.out.println(login.getSenha());
    return ResponseEntity.ok().build();
  }
}

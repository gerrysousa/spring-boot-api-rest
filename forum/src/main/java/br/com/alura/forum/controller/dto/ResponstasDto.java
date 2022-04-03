package br.com.alura.forum.controller.dto;

import br.com.alura.forum.modelo.Resposta;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.modelo.Usuario;
import java.time.LocalDateTime;


public class ResponstasDto {

  private Long id;
  private String mensagem;
  private LocalDateTime dataCriacao = LocalDateTime.now();
  private String autor;

  public ResponstasDto(Resposta resposta) {
    this.id = resposta.getId();
    this.mensagem = resposta.getMensagem();
    this.dataCriacao = resposta.getDataCriacao();
    this.autor = resposta.getAutor().getNome();
  }

  public Long getId() {
    return id;
  }

  public String getMensagem() {
    return mensagem;
  }

  public LocalDateTime getDataCriacao() {
    return dataCriacao;
  }

  public String getAutor() {
    return autor;
  }
}

package com.betrybe.sistemadevotacao;

/**
 * Classe abstrata que representa uma pessoa. Serve como base para implementação de classes
 * específicas de pessoas.
 */
public abstract class Pessoa {

  private String nome;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}


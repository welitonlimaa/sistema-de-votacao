package com.betrybe.sistemadevotacao;

/**
 * Classe que representa uma pessoa eleitora. Herda da classe Pessoa.
 */
public class PessoaEleitora extends Pessoa {

  private String cpf;

  /**
   * Construtor da classe PessoaEleitora.
   *
   * @param nome O nome da pessoa eleitora.
   * @param cpf  O CPF da pessoa eleitora.
   */
  public PessoaEleitora(String nome, String cpf) {
    this.nome = nome;
    this.cpf = cpf;
  }

  /**
   * Obtém o nome identificador da pessoa eleitora.
   *
   * @return O nome.
   */
  public String getNome() {
    return nome;
  }

  /**
   * Define o nome identificador da pessoa eleitora.
   *
   * @param nome O nome identificador para voto.
   */
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * Obtém o CPF da pessoa eleitora.
   *
   * @return O CPF da pessoa eleitora.
   */
  public String getCpf() {
    return cpf;
  }

  /**
   * Define o CPF da pessoa eleitora.
   *
   * @param cpf CPF da pessoa eleitora.
   */
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
}

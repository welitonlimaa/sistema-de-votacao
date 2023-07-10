package com.betrybe.sistemadevotacao;


/**
 * Classe que representa uma pessoa candidata. Herda da classe Pessoa.
 */
public class PessoaCandidata extends Pessoa {

  private int numero;
  private int votos;

  /**
   * Construtor da classe PessoaCandidata.
   *
   * @param nome   O nome da pessoa candidata.
   * @param numero O número identificador para voto da pessoa candidata.
   */
  public PessoaCandidata(String nome, int numero) {
    this.setNome(nome);
    this.numero = numero;
    this.votos = 0;
  }

  /**
   * Obtém o número identificador para voto da pessoa candidata.
   *
   * @return O número identificador para voto.
   */
  public int getNumero() {
    return numero;
  }

  /**
   * Define o número identificador para voto da pessoa candidata.
   *
   * @param numero O número identificador para voto.
   */
  public void setNumero(int numero) {
    this.numero = numero;
  }

  /**
   * Obtém a quantidade de votos recebidos pela pessoa candidata.
   *
   * @return A quantidade de votos recebidos.
   */
  public int getVotos() {
    return votos;
  }

  /**
   * Adiciona 1 à quantidade de votos recebidos pela pessoa candidata.
   */
  public void receberVoto() {
    this.votos += 1;
  }
}

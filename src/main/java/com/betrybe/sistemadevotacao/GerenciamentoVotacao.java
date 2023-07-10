package com.betrybe.sistemadevotacao;

import java.util.ArrayList;

/**
 * Classe responsável por gerenciar o processo de votação e o cadastro de pessoas candidatas e
 * eleitoras.
 */
public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {

  private ArrayList<PessoaCandidata> pessoasCandidatas;
  private ArrayList<PessoaEleitora> pessoasEleitoras;
  private ArrayList<String> cpfsComputados;

  /**
   * Construtor da classe GerenciamentoVotacao. Inicializa as listas de pessoas candidatas, pessoas
   * eleitoras e CPFs computados.
   */
  public GerenciamentoVotacao() {
    pessoasCandidatas = new ArrayList<>();
    pessoasEleitoras = new ArrayList<>();
    cpfsComputados = new ArrayList<>();
  }

  /**
   * Método para cadastrar uma pessoa candidata.
   *
   * @param nome   O nome da pessoa candidata.
   * @param numero O número identificador para voto da pessoa candidata.
   */
  public void cadastrarPessoaCandidata(String nome, int numero) {
    boolean cadastroVerify = pessoasCandidatas.stream()
        .anyMatch(candidato -> candidato.getNumero() == numero);
    if (cadastroVerify) {
      System.out.println("Número da pessoa candidata já utilizado!");
    } else {
      PessoaCandidata pessoaCandidata = new PessoaCandidata(nome, numero);
      pessoasCandidatas.add(pessoaCandidata);
    }
  }

  /**
   * Método para cadastrar uma pessoa eleitora.
   *
   * @param nome O nome da pessoa eleitora.
   * @param cpf  O CPF da pessoa eleitora.
   */
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    boolean cpfVerify = pessoasEleitoras.stream()
        .anyMatch(eleitor -> eleitor.getCpf().equals(cpf));
    if (cpfVerify) {
      System.out.println("Pessoa eleitora já cadastrada!");
    } else {
      PessoaEleitora pessoaEleitora = new PessoaEleitora(nome, cpf);
      pessoasEleitoras.add(pessoaEleitora);
    }
  }

  /**
   * Método para registrar o voto de uma pessoa eleitora em uma pessoa candidata.
   *
   * @param cpfPessoaEleitora     O CPF da pessoa eleitora.
   * @param numeroPessoaCandidata O número identificador da pessoa candidata.
   */
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    boolean cpfVerify = cpfsComputados.contains(cpfPessoaEleitora);
    if (cpfVerify) {
      System.out.println("Pessoa eleitora já votou!");
    } else {
      PessoaCandidata candidato = getPessoaCandidataPorNumero(numeroPessoaCandidata);
      if (candidato != null) {
        candidato.receberVoto();
        cpfsComputados.add(cpfPessoaEleitora);
      } else {
        System.out.println("Pessoa candidata não encontrada.");
      }
    }
  }

  /**
   * Método para mostrar o resultado da eleição. Imprime no console o nome de cada pessoa candidata
   * com a quantidade de votos recebidos e o percentual de votos. Imprime também o total de votos
   * computados.
   */
  public void mostrarResultado() {
    int votosTotais = cpfsComputados.size();

    if (votosTotais == 0) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
    } else {
      for (PessoaCandidata candidato : pessoasCandidatas) {
        int votos = candidato.getVotos();
        int percentual = Math.round((float) votos / votosTotais * 100);

        System.out.println(
            "Nome: " + candidato.getNome() + " - " + votos + " votos ( " + percentual);
      }

      System.out.println("Total de votos: " + votosTotais);
    }
  }

  /**
   * Método auxiliar para encontrar uma pessoa candidata pelo número identificador.
   *
   * @param numero O número identificador da pessoa candidata.
   * @return A pessoa candidata encontrada, ou null se não encontrada.
   */
  private PessoaCandidata getPessoaCandidataPorNumero(int numero) {
    for (PessoaCandidata candidato : pessoasCandidatas) {
      if (candidato.getNumero() == numero) {
        return candidato;
      }
    }
    return null;
  }
}



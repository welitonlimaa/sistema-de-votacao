package com.betrybe.sistemadevotacao;

import java.util.Scanner;

public class Principal {

  /**
   * Método principal responsável por iniciar o sistema de votação.
   *
   * @param args Os argumentos de linha de comando (não utilizado neste caso).
   */
  public static void main(String[] args) {
    GerenciamentoVotacao gerenciamentoVotacao = new GerenciamentoVotacao();

    Scanner scanner = new Scanner(System.in);
    int opcao;
    do {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada: ");
      String escolha = scanner.nextLine();
      opcao = Integer.parseInt(escolha);
      if (opcao == 1) {
        System.out.println("Entre com o nome da pessoa candidata: ");
        String nomeCandidato = scanner.nextLine();
        System.out.println("Entre com o número da pessoa candidata: ");
        String numeroCandidato = scanner.nextLine();

        gerenciamentoVotacao.cadastrarPessoaCandidata(nomeCandidato,
            Integer.parseInt(numeroCandidato));
      }
    } while (opcao != 2);

    do {
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada: ");
      String escolha = scanner.nextLine();
      opcao = Integer.parseInt(escolha);

      if (opcao == 1) {
        System.out.println("Entre com o nome da pessoa eleitora: ");
        String nomeEleitor = scanner.nextLine();
        System.out.println("Entre com o CPF da pessoa eleitora: ");
        String cpfEleitor = scanner.nextLine();

        gerenciamentoVotacao.cadastrarPessoaEleitora(nomeEleitor, cpfEleitor);
      }
    } while (opcao != 2);

    do {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar Votação");
      String escolha = scanner.nextLine();
      opcao = Integer.parseInt(escolha);

      switch (opcao) {
        case 1: {
          System.out.println("Entre com o CPF da pessoa eleitora: ");
          String cpfEleitor = scanner.nextLine();
          System.out.println("Entre com o número da pessoa candidata: ");
          String numeroCandidato = scanner.nextLine();
          gerenciamentoVotacao.votar(cpfEleitor, Integer.parseInt(numeroCandidato));
          break;
        }
        case 2: {
          gerenciamentoVotacao.mostrarResultado();
          System.out.println("Entre com o CPF da pessoa eleitora: ");
          String cpfEleitor = scanner.nextLine();
          System.out.println("Entre com o número da pessoa candidata: ");
          String numeroCandidato = scanner.nextLine();
          gerenciamentoVotacao.votar(cpfEleitor, Integer.parseInt(numeroCandidato));
          break;
        }
        case 3: {
          gerenciamentoVotacao.mostrarResultado();
          break;
        }
        default:
          System.out.println("Opção inválida!");
          break;
      }
    } while (opcao != 3);

    scanner.close();
  }
}

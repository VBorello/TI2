package com.meuprojeto.main;

import java.util.List;
import java.util.Scanner;
import com.meuprojeto.dao.XDAO;
import com.meuprojeto.model.X;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        XDAO dao = new XDAO();

        while (true) {
            System.out.println("\nMENU:");
            System.out.println("1 - Listar");
            System.out.println("2 - Inserir");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Excluir");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    List<X> lista = dao.listar();
                    for (X x : lista) {
                        System.out.println(x.getId() + " - " + x.getNome() + " - " + x.getIdade());
                    }
                    break;
                case 2:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idade = scanner.nextInt();
                    dao.inserir(new X(0, nome, idade));
                    break;
                case 3:
                    System.out.print("ID a atualizar: ");
                    int idUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Novo Nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Nova Idade: ");
                    int novaIdade = scanner.nextInt();
                    dao.atualizar(new X(idUpdate, novoNome, novaIdade));
                    break;
                case 4:
                    System.out.print("ID a excluir: ");
                    int idDelete = scanner.nextInt();
                    dao.excluir(idDelete);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}

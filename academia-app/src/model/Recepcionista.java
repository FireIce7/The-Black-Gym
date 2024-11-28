package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Recepcionista extends Usuario {

    public Recepcionista(int id, String nome, String login, String senha) {
        super(id, nome, login, senha, "Recepcionista");
    }

    public Aluno cadastrarAluno(int id, String nome, String login, String senha, Mensalidade mensalidade) {
        Aluno novoAluno = new Aluno(id, nome, login, senha, 0, mensalidade);
        System.out.println("Aluno " + nome + " cadastrado com sucesso.");
        return novoAluno;
    }

    public void cancelarMatricula(ArrayList<Usuario> usuarios, Scanner scanner) {
        System.out.print("Digite o ID do aluno que deseja cancelar a matrícula: ");
        int idAluno = scanner.nextInt();
        scanner.nextLine(); // Consumir o '\n' restante

        Aluno alunoRemover = null;
        for (Usuario u : usuarios) {
            if (u instanceof Aluno && u.getId() == idAluno) {
                alunoRemover = (Aluno) u;
                break;
            }
        }

        if (alunoRemover != null) {
            System.out.print("Tem certeza que deseja cancelar a matrícula de " + alunoRemover.getNome() + "? (S/N): ");
            String confirmacao = scanner.nextLine();
            if (confirmacao.equalsIgnoreCase("S")) {
                usuarios.remove(alunoRemover);
                System.out.println("Matrícula cancelada com sucesso.");
            } else {
                System.out.println("Operação cancelada.");
            }
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public void gerenciarPagamentos(ArrayList<Usuario> usuarios, Scanner scanner) {
        System.out.print("Digite o ID do aluno para processar o pagamento: ");
        int idAluno = scanner.nextInt();
        scanner.nextLine(); // Consumir o '\n' restante

        Aluno aluno = null;
        for (Usuario u : usuarios) {
            if (u instanceof Aluno && u.getId() == idAluno) {
                aluno = (Aluno) u;
                break;
            }
        }

        if (aluno != null) {
            aluno.pagarMensalidade();
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }
}

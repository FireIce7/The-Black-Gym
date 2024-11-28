package model;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Aluno extends Usuario {
    private int frequenciaAtual;
    private Treino treino;
    private Mensalidade mensalidade;
    private ArrayList<Aula> aulasAgendadas;

    public Aluno(int id, String nome, String login, String senha, int frequenciaAtual, Mensalidade mensalidade) {
        super(id, nome, login, senha, "Aluno");
        this.frequenciaAtual = frequenciaAtual;
        this.mensalidade = mensalidade;
        this.treino = null;
        this.aulasAgendadas = new ArrayList<>();
    }

    public void agendarAula(Aula aula) {
        if (aula.adicionarAluno(this)) {
            aulasAgendadas.add(aula);
            System.out.println("Aluno " + getNome() + " agendou a aula " + aula.getNome());
        } else {
            System.out.println("Aula cheia. Não foi possível agendar.");
        }
    }

    public void cancelarAula(Aula aula) {
        if (aulasAgendadas.contains(aula)) {
            aulasAgendadas.remove(aula);
            aula.removerAluno(this);
        } else {
            System.out.println("Você não está matriculado nesta aula.");
        }
    }

    public void consultarTreino() {
        if (treino != null) {
            treino.consultarProgresso();
        } else {
            System.out.println("Nenhum treino atribuído ainda.");
        }
    }

    public void registrarFrequencia() {
        frequenciaAtual++;
        System.out.println("Frequência registrada. Frequência atual: " + frequenciaAtual);
    }

    public void pagarMensalidade() {
        mensalidade.processarPagamento();
    }

    public void alterarPlano(Scanner scanner) {
        LocalDateTime agora = LocalDateTime.now();
        String planoAtual = "";

        if (mensalidade.getValor() == 200.0f) {
            planoAtual = "Mensal";
        } else if (mensalidade.getValor() == 550.0f) {
            planoAtual = "Trimestral";
        } else if (mensalidade.getValor() == 2000.0f) {
            planoAtual = "Anual";
        } else {
            planoAtual = "Desconhecido";
        }

        System.out.println("Seu plano atual é: " + planoAtual + ", que vence em " + mensalidade.getVencimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        if (mensalidade.getVencimento().isAfter(agora)) {
            System.out.println("Só poderá alterar o plano após o término do plano atual.");
        } else {
            System.out.println("Selecione o Novo Plano:");
            System.out.println("1. Mensal - R$200");
            System.out.println("2. Trimestral - R$550");
            System.out.println("3. Anual - R$2000");
            System.out.print("Escolha uma opção: ");
            int planoOpcao = scanner.nextInt();
            scanner.nextLine(); // Consumir o '\n' restante

            float valorMensalidade;
            if (planoOpcao == 1) {
                valorMensalidade = 200.0f;
            } else if (planoOpcao == 2) {
                valorMensalidade = 550.0f;
            } else if (planoOpcao == 3) {
                valorMensalidade = 2000.0f;
            } else {
                System.out.println("Opção inválida. Usando plano mensal por padrão.");
                valorMensalidade = 200.0f;
            }

            mensalidade = new Mensalidade(mensalidade.getId(), valorMensalidade, LocalDateTime.now().plusMonths(1), mensalidade.getTipoPagamento());
            System.out.println("Plano alterado com sucesso! Novo vencimento em " + mensalidade.getVencimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }
    }

    public void setTreino(Treino treino) {
        this.treino = treino;
    }

    public Treino getTreino() {
        return treino;
    }

    public ArrayList<Aula> getAulasAgendadas() {
        return aulasAgendadas;
    }
}

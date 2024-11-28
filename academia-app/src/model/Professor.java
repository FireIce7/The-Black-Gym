package model;

import java.time.LocalDateTime;

public class Professor extends Usuario {
    private String especialidade;

    public Professor(int id, String nome, String login, String senha, String especialidade) {
        super(id, nome, login, senha, "Professor");
        this.especialidade = especialidade;
    }

    public Treino criarTreino(int id, String nome, int frequenciaSemanalMinima, LocalDateTime periodo) {
        return new Treino(id, nome, frequenciaSemanalMinima, periodo);
    }

    public Aula criarAula(int id, String nome, int capacidade, String horario) {
        return new Aula(id, nome, capacidade, horario);
    }

    public void atribuirTreino(Aluno aluno, Treino treino) {
        aluno.setTreino(treino);
        System.out.println("Treino " + treino.getNome() + " atribuído ao aluno " + aluno.getNome() + " pelo professor especializado em " + especialidade);
    }

    // Getter
    public String getEspecialidade() {
        return especialidade;
    }
}

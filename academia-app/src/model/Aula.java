package model;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Aula {
    private int id;
    private String nome;
    private int capacidadeMaxima;
    private LocalDateTime horario;
    private ArrayList<Aluno> alunosMatriculados;

    public Aula(int id, String nome, int capacidadeMaxima, String horarioStr) {
        this.id = id;
        this.nome = nome;
        this.capacidadeMaxima = capacidadeMaxima;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        this.horario = LocalDateTime.parse(horarioStr, formatter);
        this.alunosMatriculados = new ArrayList<>();
    }

    public boolean adicionarAluno(Aluno aluno) {
        if (alunosMatriculados.size() < capacidadeMaxima) {
            alunosMatriculados.add(aluno);
            return true;
        } else {
            return false;
        }
    }

    public void removerAluno(Aluno aluno) {
        alunosMatriculados.remove(aluno);
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getHorario() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return horario.format(formatter);
    }

    public LocalDateTime getHorarioLocalDateTime() {
        return horario;
    }

    public int getId() {
        return id;
    }
}

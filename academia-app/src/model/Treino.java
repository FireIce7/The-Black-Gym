package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Treino {
    private int id;
    private String nome;
    private int frequenciaSemanalMinima;
    private LocalDateTime periodo;
    private ArrayList<Exercicio> exercicios;

    public Treino(int id, String nome, int frequenciaSemanalMinima, LocalDateTime periodo) {
        this.id = id;
        this.nome = nome;
        this.frequenciaSemanalMinima = frequenciaSemanalMinima;
        this.periodo = periodo;
        this.exercicios = new ArrayList<>();
    }

    public void adicionarExercicio(Exercicio exercicio) {
        exercicios.add(exercicio);
    }

    public void consultarProgresso() {
        System.out.println("Treino ID: " + id);
        System.out.println("Treino: " + nome);
        System.out.println("Frequência Semanal Mínima: " + frequenciaSemanalMinima);
        System.out.println("Exercícios:");
        for (Exercicio ex : exercicios) {
            System.out.println("- Máquina: " + ex.getMaquina().getNome() +
                               " | Séries: " + ex.getSeries() +
                               " | Repetições: " + ex.getRepeticoes());
        }
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDateTime getPeriodo() {
        return periodo;
    }
}

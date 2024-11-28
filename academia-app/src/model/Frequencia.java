package model;

import java.time.LocalDateTime;

public class Frequencia {
    private int id;
    private LocalDateTime data;
    private Aluno aluno;
    private String status;

    public Frequencia(int id, LocalDateTime data, Aluno aluno, String status) {
        this.id = id;
        this.data = data;
        this.aluno = aluno;
        this.status = status;
    }

    public void registrarFrequencia() {
        System.out.println("Frequência registrada para o aluno " + aluno.getNome() + " na data: " + data + " com status: " + status);
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }
}

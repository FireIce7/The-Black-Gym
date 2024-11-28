package model;

import java.time.LocalDateTime;

public class Mensalidade {
    private int id;
    private float valor;
    private LocalDateTime vencimento;
    private String tipoPagamento;

    public Mensalidade(int id, float valor, LocalDateTime vencimento, String tipoPagamento) {
        this.id = id;
        this.valor = valor;
        this.vencimento = vencimento;
        this.tipoPagamento = tipoPagamento;
    }

    // Getters
    public int getId() {
        return id;
    }

    public float getValor() {
        return valor;
    }

    public LocalDateTime getVencimento() {
        return vencimento;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    // Setters (se necessário)
    public void setId(int id) {
        this.id = id;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public void setVencimento(LocalDateTime vencimento) {
        this.vencimento = vencimento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public void processarPagamento() {
        System.out.println("Mensalidade paga com sucesso.");
        // Implementação adicional conforme necessário
    }
}

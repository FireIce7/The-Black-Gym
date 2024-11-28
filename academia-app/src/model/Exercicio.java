package model;

public class Exercicio {
    private Maquina maquina;
    private int series;
    private int repeticoes;

    public Exercicio(Maquina maquina, int series, int repeticoes) {
        this.maquina = maquina;
        this.series = series;
        this.repeticoes = repeticoes;
    }

    // Getters
    public Maquina getMaquina() {
        return maquina;
    }

    public int getSeries() {
        return series;
    }

    public int getRepeticoes() {
        return repeticoes;
    }
}

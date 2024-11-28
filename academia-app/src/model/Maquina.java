package model;

public class Maquina {
    private int id;
    private String nome;

    public Maquina(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    // Setter para o nome (necessário para modificar)
    public void setNome(String nome) {
        this.nome = nome;
    }
}

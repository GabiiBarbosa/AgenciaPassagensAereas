package br.com.catolica.Model;

public abstract class Aeronave {

    private String modelo;
    private String registro;
    private int capacidade;

    public Aeronave(String modelo, String registro, int capacidade) {
        this.modelo = modelo;
        this.registro = registro;
        this.capacidade = capacidade;
    }

    public String getModelo() {
        return modelo;
    }

    public String getRegistro() {
        return registro;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    @Override
    public String toString() {
        return String.format("Aeronave:\n" +
                "modelo: %s, registro: %s, capaciade: %d", this.modelo, this.registro, this.capacidade);
    }
}

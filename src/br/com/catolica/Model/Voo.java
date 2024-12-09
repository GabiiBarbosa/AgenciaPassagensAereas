package br.com.catolica.Model;

import br.com.catolica.Enum.StatusVoo;
import br.com.catolica.Enum.TipoVoo;

public abstract class Voo {

    private String codigoVoo;
    private String origem;
    private String destino;
    private String dataPartida;
    private String dataChegada;
    private int capacidade;
    private double preco;
    private String companhia;
    private TipoVoo tipo;
    private StatusVoo status;

    public Voo(String codigoVoo, String origem, String destino, String dataPartida,
               String dataChegada, int capacidade, double preco,  String companhia, TipoVoo tipo) {
        this.codigoVoo = codigoVoo;
        this.origem = origem;
        this.destino = destino;
        this.dataPartida = dataPartida;
        this.dataChegada = dataChegada;
        this.capacidade = capacidade;
        this.preco = preco;
        this.companhia = companhia;
        this.tipo = tipo;
        this.status = StatusVoo.AGENDADO;
    }

    public String getCodigoVoo() {
        return codigoVoo;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public String getDataPartida() {
        return dataPartida;
    }

    public String getDataChegada() {
        return dataChegada;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public double getPreco() {return preco;}

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public StatusVoo getStatus() {
        return status;
    }

    public void setStatus(StatusVoo status) {
        this.status = status;
        System.out.println("Status do voo atualizado para: " + status);
    }

    public void comprarPassagem() {
        if (capacidade > 0) {
            capacidade--;
            System.out.println("Passagem comprada com sucesso. Assentos restantes: " + capacidade);
        } else {
            System.out.println("Voo lotado. Não é possível comprar a passagem.");
        }
    }

    public void cancelarPassagem() {
        capacidade++;
        System.out.println("Passagem cancelada com sucesso. Assentos disponíveis: " + capacidade);
    }

    @Override
    public String toString() {
        return String.format("Voo:\n" +
                        "Codigo: %s\n" +
                        "Origem: %s\n" +
                        "Destino: %s\n" +
                        "Data de Partida: %s\n" +
                        "Data de Chegada: %s\n" +
                        "Capacidade: %d\n" +
                        "Preço: %.2f\n" +
                        "Companhia: %s\n" +
                        "Tipo: %s\n" +
                        "Status: %s",
                this.codigoVoo, this.origem, this.destino,
                this.dataPartida, this.dataChegada, this.capacidade,
                this.preco, this.companhia, this.tipo, this.status);
    }
}

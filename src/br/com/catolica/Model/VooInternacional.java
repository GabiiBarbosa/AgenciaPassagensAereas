package br.com.catolica.Model;

import br.com.catolica.Enum.TipoVoo;

public class VooInternacional extends Voo{
    private Aeronave aeronave;

    public VooInternacional(String codigoVoo, String origem, String destino, String dataPartida, String dataChegada, double preco,
                            Aeronave aeronave) {
        super(codigoVoo, origem, destino, dataPartida, dataChegada, aeronave.getCapacidade(), preco, "Companhia Internacional", TipoVoo.INTERNACIONAL);
        this.aeronave = aeronave;
    }

    public Aeronave getAeronave() {
        return aeronave;
    }

    public void setAeronave(Aeronave aeronave) {
        this.aeronave = aeronave;
    }

    @Override
    public String toString() {
        return String.format("Voo Internacional:" +
                super.toString() + ", aeronave: " + aeronave);
    }

}

package br.com.catolica.Model;

import br.com.catolica.Contracts.IFidelidade;

public class ProgDeFidelidade implements IFidelidade {
    private int saldoMilhas = 100000;

    @Override
    public boolean usarMilhas(int milhas) {
        if (milhas <= saldoMilhas) {
            saldoMilhas -= milhas;
            return true;
        }
        return false;
    }

    @Override
    public int consultarSaldoMilhas() {
        return saldoMilhas;
    }
}
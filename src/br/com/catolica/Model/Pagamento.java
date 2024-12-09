package br.com.catolica.Model;

import br.com.catolica.Contracts.IPagamento;
import br.com.catolica.Enum.StatusPagamento;

public class Pagamento implements IPagamento {
    private StatusPagamento pagamento;

    @Override
    public boolean processarPagamento(double valor) {
        if (valor > 0) {
            this.pagamento = StatusPagamento.PAGO;
            return true;
        }
        this.pagamento = StatusPagamento.PENDENTE;
        return false;
    }

    @Override
    public void emitirRecibo(String detalhes) {
        System.out.println("Recibo emitido: " + detalhes);
    }
}

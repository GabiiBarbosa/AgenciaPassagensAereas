package br.com.catolica.Contracts;

public interface IPagamento {
    boolean processarPagamento(double valor);
    void emitirRecibo(String detalhes);

}

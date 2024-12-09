package br.com.catolica.Contracts;
import br.com.catolica.Model.Cliente;

public interface IGerirVoo {
    void comprarPassagem(String codigoVoo, Cliente cliente);
    void cancelarPassagem(String codigoVoo, String nomeCliente);
}

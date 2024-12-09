package br.com.catolica.Main;

import br.com.catolica.Model.*;
import br.com.catolica.View.*;


public class Main {

    public static void main(String[] args) {
        View view = new View();
        AgenciaAerea agencia = new AgenciaAerea("Católica Airlines", "00.000.000/0001-00");

        Aeronave aeronave = new Aeronave("Boeing 737", "PT-XYZ", 150) {};
        Cliente cliente = new Cliente("João Silva", "12345678900", "joao@gmail.com", "99999-9999",
                "Rua A, 123", "01/01/1990");

        while (true) {
            try {
                int opcao = view.exibirMenuPrincipal();
                switch (opcao) {
                    case 1 -> {
                        view.adicionarVoo(agencia);
                    }
                    case 2 -> view.listarVoos(agencia.getVoos());
                    case 3 -> {
                        Funcionario novoFuncionario = view.solicitarDadosFuncionario();
                        agencia.contratarFuncionario(novoFuncionario);
                        view.exibirMensagem("Funcionário contratado com sucesso!");
                    }
                    case 4 -> {
                        String cpf = view.solicitarCPF();
                        agencia.demitirFuncionario(cpf);
                        view.exibirMensagem("Funcionário demitido com sucesso!");
                    }
                    case 5 -> {
                        String codigoVoo = view.solicitarCodigoVoo();
                        agencia.comprarPassagem(codigoVoo, cliente);
                    }
                    case 6 -> {
                        String codigoVoo = view.solicitarCodigoVoo();
                        String nomeCliente = view.solicitarNomeCliente();
                        agencia.cancelarPassagem(codigoVoo, nomeCliente);
                    }
                    case 7 -> view.exibirMensagem("Saldo de milhas: " + cliente.consultarSaldoMilhas());
                    case 8 -> {
                        view.exibirMensagem("Encerrando o sistema. Obrigado!");
                        return;
                    }
                    default -> view.exibirMensagem("Opção inválida. Tente novamente.");
                }
            } catch (Exception e) {
                view.exibirMensagem("Erro: " + e.getMessage());
            }
        }
    }
}
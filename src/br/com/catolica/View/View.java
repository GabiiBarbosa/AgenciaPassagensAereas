package br.com.catolica.View;

import br.com.catolica.Model.*;
import java.util.List;
import java.util.Scanner;

public class View {

    private final Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);
    }

    public int exibirMenuPrincipal() {
        System.out.println("\n--- Sistema de Gerenciamento da Agência Aérea ---");
        System.out.println("1. Adicionar Voo");
        System.out.println("2. Listar Voos Disponíveis");
        System.out.println("3. Contratar Funcionário");
        System.out.println("4. Demitir Funcionário");
        System.out.println("5. Comprar Passagem");
        System.out.println("6. Cancelar Passagem");
        System.out.println("7. Consultar Saldo de Milhas");
        System.out.println("8. Sair");
        System.out.print("Escolha uma opção: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void adicionarVoo(AgenciaAerea agencia) {
        System.out.println("\nEscolha o tipo de voo:");
        System.out.println("1. Voo Doméstico");
        System.out.println("2. Voo Internacional");
        int tipoVoo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Código do Voo: ");
        String codigo = scanner.nextLine();
        System.out.print("Origem: ");
        String origem = scanner.nextLine();
        System.out.print("Destino: ");
        String destino = scanner.nextLine();
        System.out.print("Data de Partida (dd/MM/yyyy): ");
        String dataPartida = scanner.nextLine();
        System.out.print("Data de Chegada (dd/MM/yyyy): ");
        String dataChegada = scanner.nextLine();
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        if (preco <= 0) {
            System.out.println("Preço inválido. O valor deve ser positivo.");
            return;
        }
        Aeronave aeronave = new Aeronave("A123", "Boeing 737", 150) {};

        if (tipoVoo == 1) {
            agencia.adicionarVooDomestico(codigo, origem, destino, dataPartida, dataChegada, preco, aeronave);
        } else if (tipoVoo == 2) {
            agencia.adicionarVooInternacional(codigo, origem, destino, dataPartida, dataChegada, preco, aeronave);
        } else {
            System.out.println("Tipo de voo inválido!");
        }
    }

    public void listarVoos(List<Voo> voos) {
        if (voos.isEmpty()) {
            System.out.println("Nenhum voo disponível.");
        } else {
            System.out.println("\nVoos disponíveis:");
            for (Voo voo : voos) {
                System.out.println(voo);
            }
        }
    }

    public Funcionario solicitarDadosFuncionario() {
        System.out.print("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF do funcionário: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite o cargo do funcionário: ");
        String cargo = scanner.nextLine();
        System.out.print("Digite o salário do funcionário: ");
        double salario = Double.parseDouble(scanner.nextLine());

        return new Funcionario(nome, cpf, "email@exemplo.com", "00000-0000",
                "Endereço", "01/01/1990", cargo, salario);
    }

    public String solicitarCPF() {
        System.out.print("Digite o CPF do funcionário: ");
        return scanner.nextLine();
    }

    public String solicitarCodigoVoo() {
        System.out.print("Digite o código do voo: ");
        return scanner.nextLine();
    }

    public String solicitarNomeCliente() {
        System.out.print("Digite o nome do cliente: ");
        return scanner.nextLine();
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

}
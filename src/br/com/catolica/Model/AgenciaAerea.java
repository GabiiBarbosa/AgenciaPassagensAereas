package br.com.catolica.Model;

import br.com.catolica.Contracts.IGerirVoo;
import br.com.catolica.Contracts.IVoosDisponiveis;
import br.com.catolica.Contracts.IPagamento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AgenciaAerea implements IVoosDisponiveis, IGerirVoo {

    private String nome;
    private String cnpj;
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Voo> voos;
    private Map<String, List<String>> passagens;
    private ProgDeFidelidade fidelidade;
    private IPagamento pagamento;  // Adiciona a interface de pagamento

    public AgenciaAerea(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.funcionarios = new ArrayList<>();
        this.voos = new ArrayList<>();
        this.passagens = new HashMap<>();
        this.fidelidade = new ProgDeFidelidade();
        this.pagamento = new Pagamento(); // Inicializa a classe de pagamento
    }

    @Override
    public void listarTodos() {
        if (voos.isEmpty()) {
            System.out.println("Nenhum voo disponível.");
        } else {
            System.out.println("\nVoos disponíveis:");
            for (Voo voo : voos) {
                System.out.println(voo);
            }
        }
    }

    @Override
    public void comprarPassagem(String codigoVoo, Cliente cliente) {
        if (voos.isEmpty()) {
            System.out.println("Nenhum voo disponível.");
            return;
        }
        Voo vooEscolhido = null;
        for (Voo voo : voos) {
            if (voo.getCodigoVoo().equals(codigoVoo)) {
                vooEscolhido = voo;
                break;
            }
        }
        if (vooEscolhido == null) {
            System.out.println("Voo não encontrado.");
            return;
        }

        double precoFinal = vooEscolhido.getPreco();
        int milhasNecessarias = (int) (precoFinal / 10);

        if (!fidelidade.usarMilhas(milhasNecessarias)) {
            System.out.println("Compra cancelada: saldo de milhas insuficiente.");
            return;
        }
        precoFinal = (precoFinal - milhasNecessarias);
        System.out.println("Desconto aplicado com sucesso! Preço final: " + precoFinal);

        // Processar o pagamento
        boolean pagamentoProcessado = pagamento.processarPagamento(precoFinal);
        if (!pagamentoProcessado) {
            System.out.println("Pagamento não processado. Tente novamente.");
            return;
        }
        passagens.putIfAbsent(codigoVoo, new ArrayList<>());
        passagens.get(codigoVoo).add(cliente.getNome());
        vooEscolhido.comprarPassagem();
        pagamento.emitirRecibo("Detalhes da compra: Voo " + vooEscolhido.getCodigoVoo() + " para " + cliente.getNome());
        System.out.println("Passagem comprada com sucesso!");
    }

    @Override
    public void cancelarPassagem(String codigoVoo, String nomeCliente) {
        if (!passagens.containsKey(codigoVoo)) {
            System.out.println("Voo não encontrado.");
            return;
        }
        List<String> clientes = passagens.get(codigoVoo);
        if (clientes.remove(nomeCliente)) {
            for (Voo voo : voos) {
                if (voo.getCodigoVoo().equals(codigoVoo)) {
                    voo.cancelarPassagem();
                    break;
                }
            }
            System.out.println("Passagem cancelada com sucesso.");
        } else {
            System.out.println("Cliente não encontrado no voo.");
        }
    }

    public void contratarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        System.out.println("Funcionário " + funcionario.getNome() + " contratado.");
    }

    public void demitirFuncionario(String cpf) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                funcionarios.remove(funcionario);
                System.out.println("Funcionário " + funcionario.getNome() + " demitido.");
                return;
            }
        }
        System.out.println("Funcionário não encontrado.");
    }

    public void adicionarVooDomestico(String codigo, String origem, String destino, String dataPartida,
                                      String dataChegada, double preco, Aeronave aeronave) {
        Voo voo = new VooDomestico(codigo, origem, destino, dataPartida, dataChegada, preco, aeronave);
        voos.add(voo);
        System.out.println("Voo Doméstico adicionado.");
    }

    public void adicionarVooInternacional(String codigo, String origem, String destino, String dataPartida,
                                          String dataChegada, double preco, Aeronave aeronave) {
        Voo voo = new VooInternacional(codigo, origem, destino, dataPartida, dataChegada, preco, aeronave);
        voos.add(voo);
        System.out.println("Voo Internacional adicionado.");
    }

    public ArrayList<Voo> getVoos() {
        return voos;
    }
}

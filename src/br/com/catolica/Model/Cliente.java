package br.com.catolica.Model;

import br.com.catolica.Contracts.IFidelidade;

public class Cliente extends Pessoa {

    private IFidelidade programaFidelidade;

    public Cliente(String nome, String cpf, String email, String telefone, String endereco,
            String dataNascimento) {
        super(nome, cpf, email, telefone, endereco, dataNascimento);
    }


    public void cadastrarProgramaFidelidade() {
        System.out.println("Cliente inscrito no programa de fidelidade."    );
    }

    public int consultarSaldoMilhas() {
        return this.programaFidelidade.consultarSaldoMilhas();
    }

    public IFidelidade getProgramaFidelidade() {
        return programaFidelidade;
    }
}

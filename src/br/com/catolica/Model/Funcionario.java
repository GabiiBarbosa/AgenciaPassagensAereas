package br.com.catolica.Model;

public class Funcionario extends Pessoa{
    private String cargo;
    private double salario;

    public Funcionario(String nome, String cpf, String email, String telefone, String endereco,
                       String dataNascimento, String cargo, double salario) {

        super(nome, cpf, email, telefone, endereco, dataNascimento);
        this.cargo = cargo;
        this.salario = salario;
    }


    public void promover(String novoCargo) {
        this.cargo = novoCargo;
        System.out.printf("Você foi promovido para ", novoCargo);
    }

    public void reajustarSalario(double percentual) {
        this.salario += this.salario * percentual / 100;
        System.out.println(this.salario);
    }

    @Override
    public String toString() {
        return String.format("Funcionário: %s, %s", getNome(), this.cargo);
    }
}


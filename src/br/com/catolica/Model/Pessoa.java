package br.com.catolica.Model;

public abstract class Pessoa {

    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;
    private String dataNascimento;

    public Pessoa(String nome, String cpf, String email, String telefone,
                  String endereco, String dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
    }


    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s\n" +
                "CPF: %s\n" +
                "E-mail: %s\n" +
                "Telefone: %s\n", this.nome, this.cpf, this.email, this.telefone);
    }
}



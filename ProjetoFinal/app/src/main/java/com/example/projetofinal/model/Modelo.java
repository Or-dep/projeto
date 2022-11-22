package com.example.projetofinal.model;

public class Modelo {
    private int id;
    private String Funcionario;
    private String Nomecliente;
    private String Endereco;
    private String Codigo;
    private String Telefone;
    private String Email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFuncionario() {
        return Funcionario;
    }

    public void setFuncionario(String funcionario) {
        Funcionario = funcionario;
    }

    public String getNomecliente() {
        return Nomecliente;
    }

    public void setNomecliente(String nomecliente) {
        Nomecliente = nomecliente;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}

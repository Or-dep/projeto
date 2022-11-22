package com.example.projetofinal.model;

import java.io.Serializable;

public class CriaPedidos implements Serializable{
    private int id;
    private String Funcionario;
    private String Cliente;
    private String Produto1;
    private String Quantidade1;
    private String Produto2;
    private String Quantidade2;
    private String Produto3;
    private String Quantidade3;
    private String Produto4;
    private String Quantidade4;


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

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String cliente) {
        Cliente = cliente;
    }

    public String getProduto1() {
        return Produto1;
    }

    public void setProduto1(String produto1) {
        Produto1 = produto1;
    }

    public String getQuantidade1() {
        return Quantidade1;
    }

    public void setQuantidade1(String quantidade1) {
        Quantidade1 = quantidade1;
    }

    public String getProduto2() {
        return Produto2;
    }

    public void setProduto2(String produto2) {
        Produto2 = produto2;
    }

    public String getQuantidade2() {
        return Quantidade2;
    }

    public void setQuantidade2(String quantidade2) {
        Quantidade2 = quantidade2;
    }

    public String getProduto3() {
        return Produto3;
    }

    public void setProduto3(String produto3) {
        Produto3 = produto3;
    }

    public String getQuantidade3() {
        return Quantidade3;
    }

    public void setQuantidade3(String quantidade3) {
        Quantidade3 = quantidade3;
    }

    public String getProduto4() {
        return Produto4;
    }

    public void setProduto4(String produto4) {
        Produto4 = produto4;
    }

    public String getQuantidade4() {
        return Quantidade4;
    }

    public void setQuantidade4(String quantidade4) {
        Quantidade4 = quantidade4;
    }
}

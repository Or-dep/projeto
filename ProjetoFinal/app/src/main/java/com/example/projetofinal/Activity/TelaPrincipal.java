package com.example.projetofinal.Activity;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.projetofinal.R;
import com.example.projetofinal.helper.BaseDeDados;
import com.example.projetofinal.helper.CaixaDePedidos;
import com.example.projetofinal.model.CriaPedidos;
import com.example.projetofinal.model.Modelo;

//ok
public class TelaPrincipal extends AppCompatActivity {

    private Button Cadastro;
    private Button Pedidos;
    private Button Guia;
    private TextView text1;
    private TextView text2;
    private Modelo objetoCliente;
    private CriaPedidos criaPedidos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        Cadastro = findViewById(R.id.buttonCadastro);

        Pedidos = findViewById(R.id.buttonPedidos);
        Guia = findViewById(R.id.buttonGuia);

        text1 = findViewById(R.id.TextNome);
        text2 = findViewById(R.id.TextFuncao);

        Bundle dados = getIntent().getExtras();
        String nome = dados.getString("Nome");
        String funcao = "Admin";


        String funcionario = dados.getString("Nome");
        String cliente = dados.getString("clien");
        String endere = dados.getString("ende");
        String cep = dados.getString("cep");
        String tell = dados.getString("tell");
        String email = dados.getString("email");


        BaseDeDados banco = new BaseDeDados( this);
        CaixaDePedidos novopedido = new CaixaDePedidos( this);

        objetoCliente = new Modelo();
        objetoCliente.setFuncionario(funcionario);
        objetoCliente.setNomecliente(cliente);
        objetoCliente.setEndereco(endere);
        objetoCliente.setCodigo(cep);
        objetoCliente.setTelefone(tell);
        objetoCliente.setEmail(email);

        banco.insert("Banco_Clientes",objetoCliente);


        String item1 =dados.getString("item1");
        String qt1 =dados.getString("qt1");
        String item2 =dados.getString("item2");
        String qt2 =dados.getString("qt2");
        String item3 =dados.getString("item3");
        String qt3 =dados.getString("qt3");
        String item4 =dados.getString("item4");
        String qt4 =dados.getString("qt4");



        criaPedidos = new CriaPedidos();
        criaPedidos.setFuncionario(funcionario);
        criaPedidos.setCliente(cliente);

        criaPedidos.setProduto1(item1);
        criaPedidos.setQuantidade1(qt1);

        criaPedidos.setProduto2(item2);
        criaPedidos.setQuantidade2(qt2);

        criaPedidos.setProduto3(item3);
        criaPedidos.setQuantidade3(qt3);

        criaPedidos.setProduto4(item4);
        criaPedidos.setQuantidade4(qt4);


        novopedido.insert( "Pedido", criaPedidos);

        text1.setText( nome );
        text2.setText( funcao );

        Intent cadastro = new Intent(getApplicationContext(), CadastroCliente.class);
        cadastro.putExtra("name",nome);

        Cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(cadastro);
                finish();
            }
        });
        Pedidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pedidos = new Intent(getApplicationContext(), Demandas.class);
                pedidos.putExtra("client",cliente);
                pedidos.putExtra("1",item1);
                pedidos.putExtra("1.2",qt1);
                pedidos.putExtra("2",item2);
                pedidos.putExtra("2.2",qt2);
                pedidos.putExtra("3",item3);
                pedidos.putExtra("3.2",qt3);
                pedidos.putExtra("4",item4);
                pedidos.putExtra("4.2",qt4);
                startActivity(pedidos);
            }
        });
    }
    //ok
}
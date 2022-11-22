package com.example.projetofinal.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.projetofinal.R;
import com.example.projetofinal.helper.BaseDeDados;
import com.example.projetofinal.helper.CaixaDePedidos;
import com.example.projetofinal.model.CriaPedidos;
import com.example.projetofinal.model.Modelo;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private Button Botaologin;
    private TextInputEditText nome;
    /*private TextInputEditText senha;
    private Modelo objetoCliente;
    private CriaPedidos criaPedidos;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BaseDeDados baseDeDados = new BaseDeDados(this);

        CaixaDePedidos caixaDePedidos = new CaixaDePedidos(this);

        PedidosInfos pedidosInfos = new PedidosInfos();

        nome = findViewById(R.id.inputTextoUser);
        //senha = findViewById(R.id.inputTextoSenha);
        Botaologin = findViewById(R.id.botaoLogin);

        Botaologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(getApplicationContext(), TelaPrincipal.class);

                String inputnome = nome.getText().toString();


                if (!inputnome.isEmpty()){
                intent.putExtra("Nome", inputnome);
                //intent.putExtra("Função","Admin");
                startActivity(intent);
                finish();
                    Toast.makeText(getApplicationContext(), "Bem Vindo "+ inputnome, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Digite seu nome de Usuario para usar o aplicativo", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
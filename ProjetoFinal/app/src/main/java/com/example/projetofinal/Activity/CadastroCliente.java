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
import com.example.projetofinal.model.Modelo;
import com.google.android.material.textfield.TextInputEditText;

public class CadastroCliente extends AppCompatActivity {

    private TextInputEditText Nome_C;
    private TextInputEditText Endereco_C;
    private TextInputEditText CEP_C;
    private TextInputEditText Tell_C;
    private TextInputEditText Email_C;
    private Button botaoSalvar_C;
    private Modelo objetoCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);

        Nome_C = findViewById(R.id.InputNome);
        Endereco_C = findViewById(R.id.InputEndereço);
        CEP_C = findViewById(R.id.InputCEP);
        Tell_C = findViewById(R.id.InputTelefone);
        Email_C = findViewById(R.id.InputEmail);

        botaoSalvar_C = findViewById(R.id.SalvarDados);
        BaseDeDados banco = new BaseDeDados( this);
        botaoSalvar_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent pedidos = new Intent(getApplicationContext(), PedidosInfos.class);

                Bundle dado = getIntent().getExtras();

                String name = dado.getString("name");

                String input1 = Nome_C.getText().toString();
                String input2 = Endereco_C.getText().toString();
                String input3 = CEP_C.getText().toString();
                String input4 = Tell_C.getText().toString();
                String input5 = Email_C.getText().toString();

                pedidos.putExtra("funci",name);
                pedidos.putExtra("clien",input1);
                pedidos.putExtra("ende",input2);
                pedidos.putExtra("cep",input3);
                pedidos.putExtra("tell",input4);
                pedidos.putExtra("email",input5);
                //Integer input3 = Integer.valueOf(CEP_C.getText().toString());
                //Integer input4 = Integer.valueOf(Tell_C.getText().toString());

                ContentValues cv = new ContentValues();
                cv.put("Funcionario",name);
                cv.put("Nome_do_Cliente",input1);
                cv.put("Endereco",input2);
                cv.put("Codigo_Postal",input3);
                cv.put("Telefone",input4);
                cv.put("Email",input5);


                objetoCliente = new Modelo();
                objetoCliente.setFuncionario(name);
                objetoCliente.setNomecliente(input1);
                objetoCliente.setEndereco(input2);
                objetoCliente.setCodigo(input3);
                objetoCliente.setTelefone(input4);
                objetoCliente.setEmail(input5);

                if (!input1.isEmpty()){

                    if (!input2.isEmpty()){

                        if (!input3.isEmpty()){

                            if (!input4.isEmpty()){

                                if (!input5.isEmpty()){
                                    //banco.insert("Banco_Clientes",objetoCliente);
                                    Toast.makeText(getApplicationContext(), "Monte o pedido", Toast.LENGTH_SHORT).show();
                                    finish();
                                    startActivity(pedidos);
                                }else{
                                    Toast.makeText(getApplicationContext(), "Email está vazio", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(getApplicationContext(), "Telefone está vazio", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(getApplicationContext(), "Código postal está vazio", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Endereço está vazio", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Nome está vazio", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
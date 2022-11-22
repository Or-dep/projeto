package com.example.projetofinal.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.projetofinal.R;
import com.example.projetofinal.helper.BaseDeDados;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class PedidosInfos extends AppCompatActivity {

    private Button start;

    private TextInputEditText item1;
    private TextInputEditText item2;
    private TextInputEditText item3;
    private TextInputEditText item4;

    private TextInputEditText quant1;
    private TextInputEditText quant2;
    private TextInputEditText quant3;
    private TextInputEditText quant4;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos_infos);

        item1 = findViewById(R.id.item1);
        item2 = findViewById(R.id.item2);
        item3 = findViewById(R.id.item3);
        item4 = findViewById(R.id.item4);

        quant1 = findViewById(R.id.total1);
        quant2 = findViewById(R.id.total2);
        quant3 = findViewById(R.id.total3);
        quant4 = findViewById(R.id.total4);

        start = findViewById(R.id.SalvarPedido);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pedidos = new Intent(getApplicationContext(), TelaPrincipal.class);
                BaseDeDados banco = new BaseDeDados( getApplicationContext() );

                String input1_0 = Objects.requireNonNull(item1.getText()).toString();
                String input1_1 = Objects.requireNonNull(quant1.getText()).toString();

                String input2_0 = Objects.requireNonNull(item2.getText()).toString();
                String input2_1 = Objects.requireNonNull(quant2.getText()).toString();

                String input3_0 = Objects.requireNonNull(item3.getText()).toString();
                String input3_1 = Objects.requireNonNull(quant3.getText()).toString();

                String input4_0 = Objects.requireNonNull(item4.getText()).toString();
                String input4_1 = Objects.requireNonNull(quant4.getText()).toString();

                boolean test = false;

                ContentValues cv = new ContentValues();
                cv.put("",input1_0);
                cv.put("",input1_1);
                cv.put("",input2_0);
                cv.put("",input2_1);
                cv.put("",input3_0);
                cv.put("",input3_1);
                cv.put("",input4_0);
                cv.put("",input4_1);

                if (!input1_0.isEmpty()){
                    if (!input1_1.isEmpty()){
                        test = true;
                        pedidos.putExtra("item1",input1_0);
                        pedidos.putExtra("qt1",input1_1);
                    }else{
                        Toast.makeText(getApplicationContext(), "Quantidade está vazia", Toast.LENGTH_SHORT).show();
                        test = false;
                    }
                }
                if (!input1_1.isEmpty()){
                    if (!input1_0.isEmpty()){
                        test = true;
                    }else{
                        Toast.makeText(getApplicationContext(), "Produto está em vazio", Toast.LENGTH_SHORT).show();
                        test = false;
                    }
                }


                if (!input2_0.isEmpty()){
                    if (!input2_1.isEmpty()){
                        pedidos.putExtra("item2",input2_0);
                        pedidos.putExtra("qt2",input2_1);
                        test = true;
                    }else{
                        Toast.makeText(getApplicationContext(), "Quantidade está vazia", Toast.LENGTH_SHORT).show();
                        test = false;
                    }
                }
                if (!input2_1.isEmpty()){
                    if (!input2_0.isEmpty()){
                        test = true;
                    }else{
                        Toast.makeText(getApplicationContext(), "Produto está em vazio", Toast.LENGTH_SHORT).show();
                        test = false;
                    }
                }


                if (!input3_0.isEmpty()){
                    if (!input3_1.isEmpty()){
                        pedidos.putExtra("item3",input3_0);
                        pedidos.putExtra("qt3",input3_1);
                        test = true;
                    }else{
                        Toast.makeText(getApplicationContext(), "Quantidade está vazia", Toast.LENGTH_SHORT).show();
                        test = false;
                    }
                }
                if (!input3_1.isEmpty()){
                    if (!input3_0.isEmpty()){
                        test = true;
                    }else{
                        Toast.makeText(getApplicationContext(), "Produto está em vazio", Toast.LENGTH_SHORT).show();
                        test = false;
                    }
                }


                if (!input4_0.isEmpty()){
                    if (!input4_1.isEmpty()){
                        pedidos.putExtra("item4",input4_0);
                        pedidos.putExtra("qt4",input4_1);
                        test = true;
                    }else{
                        Toast.makeText(getApplicationContext(), "Quantidade está vazia", Toast.LENGTH_SHORT).show();
                        test = false;
                    }
                }
                if (!input4_1.isEmpty()){
                    if (!input4_0.isEmpty()){
                        test = true;
                    }else{
                        Toast.makeText(getApplicationContext(), "Produto está em vazio", Toast.LENGTH_SHORT).show();
                        test = false;
                    }
                }


                /*
                banco.getWritableDatabase().insert("Banco_Clientes",null,cv);
                Toast.makeText(getApplicationContext(), "Salvo com Sucesso", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(pedidos);*/


                Bundle dado = getIntent().getExtras();

                String name = dado.getString("name");
                String input1 = dado.getString("clien");
                String input2 = dado.getString("ende");
                String input3 = dado.getString("cep");
                String input4 = dado.getString("tell");
                String input5 = dado.getString("email");


                pedidos.putExtra("funci",name);
                pedidos.putExtra("clien",input1);
                pedidos.putExtra("ende",input2);
                pedidos.putExtra("cep",input3);
                pedidos.putExtra("tell",input4);
                pedidos.putExtra("email",input5);







                if (test == true) {
                    startActivity(pedidos);
                    finish();
                }
            }
        });
    }
}

package com.example.projetofinal.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.example.projetofinal.R;


public class Demandas extends AppCompatActivity {

    private TextView cli;
    private TextView pr1;
    private TextView q1;
    private TextView pr2;
    private TextView q2;
    private TextView pr3;
    private TextView q3;
    private TextView pr4;
    private TextView q4;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demandas);

        Bundle dados = getIntent().getExtras();
        String cliente = dados.getString("client");
        String item1 =dados.getString("1");
        String qt1 =dados.getString("1.2");
        String item2 =dados.getString("2");
        String qt2 =dados.getString("2.2");
        String item3 =dados.getString("3");
        String qt3 =dados.getString("3.2");
        String item4 =dados.getString("4");
        String qt4 =dados.getString("4.2");
        cli  = findViewById(R.id.clien1);
        pr1 = findViewById(R.id.itenn1);
        pr2 = findViewById(R.id.itenn3);
        pr3 = findViewById(R.id.itenn5);
        pr4 = findViewById(R.id.itenn7);
        q1 = findViewById(R.id.itenn2);
        q2 = findViewById(R.id.itenn4);
        q3 = findViewById(R.id.itenn6);
        q4 = findViewById(R.id.itenn8);

        cli.setText(cliente);
        pr1.setText(item1);
        pr2.setText(item2);
        pr3.setText(item3);
        pr4.setText(item4);
        q1.setText(qt1);
        q2.setText(qt2);
        q3.setText(qt3);
        q4.setText(qt4);

    }
}
package com.example.projetofinal.helper;

import static android.content.Intent.getIntent;
import static android.content.Intent.getIntentOld;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.projetofinal.Activity.CadastroCliente;
import com.example.projetofinal.model.Modelo;

public class BaseDeDados extends SQLiteOpenHelper {

    public static int VERSION = 1;
    public static String NOME_DB = "bancoDdados";
    public static String TABAELA_CLIENTES = "Banco_Clientes";
    SQLiteDatabase db;

    public BaseDeDados(@Nullable Context context) {
        super(context, NOME_DB, null, VERSION);

        db = getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String banco = "CREATE TABLE IF NOT EXISTS " + TABAELA_CLIENTES
                +" (Id  INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                +" Funcionario TEXT,\n"
                +" Nome_do_Cliente TEXT,\n"
                +" Endereco TEXT,\n "
                +" Codigo_Postal TEXT,\n "
                +" Telefone TEXT,\n "
                +" Email TEXT ); ";
        try {

            db.execSQL(banco);
            Log.i("INFO", "Sucesso ao criar a tabela");
        }catch (Exception e){

            Log.i("INFO", "Erro ao criar a tabela" + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insert(String tabela, Modelo criaCliente){

        ContentValues cv = new ContentValues();
        cv.put("Funcionario", criaCliente.getFuncionario());
        cv.put("Nome_do_Cliente",criaCliente.getNomecliente());
        cv.put("Endereco",criaCliente.getEndereco());
        cv.put("Codigo_Postal",criaCliente.getCodigo());
        cv.put("Telefone",criaCliente.getTelefone());
        cv.put("Email",criaCliente.getEmail());

        return db.insert(tabela,null, cv)>0;
    }
}


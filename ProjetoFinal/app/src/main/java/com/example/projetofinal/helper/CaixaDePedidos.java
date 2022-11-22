package com.example.projetofinal.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.projetofinal.model.CriaPedidos;

public class CaixaDePedidos extends SQLiteOpenHelper {

    public static int VERSION = 1;
    public static String BANCO_P = "bancoDpedidos";
    public static String TABAELA_PEDIDOS = "Pedido";

    SQLiteDatabase dbp;


    public CaixaDePedidos(@Nullable Context context) {
        super(context, BANCO_P, null, VERSION);

        dbp = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String banco = "CREATE TABLE IF NOT EXISTS "+ TABAELA_PEDIDOS + ""
                +" (Id  INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                +" Funcionario TEXT ,\n"
                +" Cliente TEXT ,\n"
                +" Produto1 TEXT ,\n"
                +" Quantidade1 TEXT ,\n"
                +" Produto2 TEXT ,\n"
                +" Quantidade2 TEXT ,\n"
                +" Produto3 TEXT ,\n"
                +" Quantidade3 TEXT,\n"
                +" Produto4 TEXT ,\n"
                +" Quantidade4 TEXT);";

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

    public boolean insert(String tabela, CriaPedidos criaPedidos){

        ContentValues values = new ContentValues();
        values.put("Funcionario",criaPedidos.getFuncionario());
        values.put("Cliente",criaPedidos.getCliente());

        values.put("Produto1",criaPedidos.getProduto1());
        values.put("Quantidade1", criaPedidos.getQuantidade1());

        values.put("Produto2",criaPedidos.getProduto2());
        values.put("Quantidade2", criaPedidos.getQuantidade2());

        values.put("Produto3",criaPedidos.getProduto3());
        values.put("Quantidade3", criaPedidos.getQuantidade3());

        values.put("Produto4",criaPedidos.getProduto4());
        values.put("Quantidade4", criaPedidos.getQuantidade4());

        return dbp.insert(tabela,null, values) > 0;
    }
}

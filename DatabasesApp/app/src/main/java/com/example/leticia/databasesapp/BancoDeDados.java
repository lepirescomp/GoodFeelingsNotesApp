package com.example.leticia.databasesapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {
    SQLiteDatabase database;
    List<String> lista = new ArrayList<String>();


    public BancoDeDados(Context context){
        this.database = context.openOrCreateDatabase("database",Context.MODE_PRIVATE,null);
//        database.execSQL("DROP TABLE IF EXISTS notas");
        database.execSQL("CREATE TABLE IF NOT EXISTS notas(id INTEGER PRIMARY KEY AUTOINCREMENT, texto TEXT);");
//        database.execSQL("INSERT INTO notas(texto) VALUES('Exemplo');");
    }

    public void insert(String mensagem){
        database.execSQL("INSERT INTO notas(texto) VALUES ('"+mensagem+"');");
        Log.i("ta no insert", mensagem);
//        lista.add(mensagem);
    }


    public void update(String antiga,String nova){
        database.execSQL("UPDATE notas SET texto='"+nova+"' WHERE texto='"+ antiga+"';");
    }

    public void delete(String antiga){
        database.execSQL("DELETE FROM notas WHERE texto='"+ antiga+"';");
//        lista.remove(i);
    }

    public List<String> getLista(){
        Log.i("ta no get lista", "getLista: ");
        Cursor c = database.rawQuery("SELECT * FROM notas",null);
//        int index =0;
        int index=c.getColumnIndex("texto");


        c.moveToNext();
        while (!c.isAfterLast()) {
            lista.add(c.getString(index));
            c.moveToNext();
        }
        //se lista vazia
//        if(c.isAfterLast()){
//            lista.add("Exemplo");
//        }else {
//            c.moveToFirst();
//            while (!c.isAfterLast()) {
//                lista.add(c.getString(index));
//                c.moveToNext();
//            }
//        }
        Log.i("ta no get lista imprime", lista.toString());
        return lista;
    }
}

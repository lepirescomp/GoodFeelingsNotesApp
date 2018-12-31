package com.example.leticia.databasesapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;
//    public List<String> list;
    public RecyclerAdapter adapter;
    public BancoDeDados bancoDeDados;
    static int indice;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if(item.getItemId()==R.id.add){
            Intent intent = new Intent(getApplicationContext(),Edicao.class);
            startActivity(intent);
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        layoutManager =  new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        bancoDeDados = new BancoDeDados(this);
//        list= bancoDeDados.getLista();
//        list = Arrays.asList("aaa","bbb","cccc");
//        Log.i("lista", list.toString());
        adapter = new RecyclerAdapter(this,bancoDeDados);
//        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);







    }
}

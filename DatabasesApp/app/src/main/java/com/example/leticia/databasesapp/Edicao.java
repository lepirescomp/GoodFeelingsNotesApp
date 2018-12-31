package com.example.leticia.databasesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Edicao extends AppCompatActivity {
    public EditText textView;
    public BancoDeDados bancoDeDados;

    public void funcaoEnvia(View v){
//        textView.setText(getIntent().getStringExtra("id"));

        Log.i("ta no clique", (textView).getText().toString());
        Intent intent = new Intent(this,MainActivity.class);
        if(getIntent().getStringExtra("id")!=null){
            bancoDeDados.update(getIntent().getStringExtra("id"),(textView).getText().toString());
        }
        else{
            bancoDeDados.insert((textView).getText().toString());
        }
        this.startActivity(intent);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicao);
        textView=findViewById(R.id.edicao);
        bancoDeDados = new BancoDeDados(this);
        textView.setText(getIntent().getStringExtra("id"));
//        Log.i("lala", String.valueOf(getIntent().getStringExtra("id")));

    }
}

package com.example.leticia.databasesapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    public List<String> list;
    public Context context;
    public BancoDeDados bancoDeDados;


    public RecyclerAdapter(Context context,BancoDeDados bancoDeDados){
        this.list = bancoDeDados.getLista();
        Log.i("ta no >>>", list.toString());
        this.context = context;
        this.bancoDeDados=bancoDeDados;



    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        TextView textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.text_view_layout,viewGroup,false);
        MyViewHolder myViewHolder = new MyViewHolder(textView,context,bancoDeDados,list);
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                alertDialog.setTitle("Editar sua mensagem");
                alertDialog.setMessage("Deletar ou Modificar?");
                alertDialog.setPositiveButton("Modificar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context,Edicao.class);
                        intent.putExtra("id",((TextView)v).getText());
                        context.startActivity(intent);
                    }
                });
                alertDialog.setNegativeButton("Deletar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        bancoDeDados.delete(((TextView)v).getText().toString());
                        Log.i("lalala", "onClick: lalala ");
                        notifyItemRemoved(which);
                        Intent intent = new Intent(context,MainActivity.class);
                        context.startActivity(intent);
                    }
                });

                AlertDialog dialog = alertDialog.create();
                dialog.show();
            }
        });


        return myViewHolder;
    }



    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int i) {
        viewHolder.versionName.setText(list.get(i));
//        bancoDeDados.insert(list.get(i));
//        viewHolder.versionName.getText();
    }


    @Override
    public int getItemCount() {
        return (null != list ? list.size() : 0);
    }

public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView versionName;
        Context context;
        BancoDeDados bancoDeDados;
        List<String> list;


        public MyViewHolder(TextView itemView,Context context,BancoDeDados bancoDeDados,List<String> lista ) {

        super(itemView);
        versionName = itemView;
        itemView.setOnClickListener(this);
//        itemView.setOnLongClickListener(this);
        this.context=context;
        this.bancoDeDados = bancoDeDados;
        this.list=lista;

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context,Edicao.class);
        intent.putExtra("id",((TextView)v).getText());
        context.startActivity(intent);

        Log.i(">>>>>>>>>", "onClick: too no onclickkk");
    }



}

}


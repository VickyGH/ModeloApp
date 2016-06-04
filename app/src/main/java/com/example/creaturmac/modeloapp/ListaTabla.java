package com.example.creaturmac.modeloapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListaTabla extends AppCompatActivity {

    private Button lista1;
    private Button lista2;
    private Button lista3;
    private Button tabla1;
    private Button tabla2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_tabla);

        lista1 = (Button)findViewById(R.id.Btn1);
        lista2 = (Button)findViewById(R.id.Btn2);
        lista3 = (Button)findViewById(R.id.Btn3);
        tabla1 = (Button)findViewById(R.id.Btn4);

        //Click
        lista1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open = new Intent(ListaTabla.this, Listas.class);
                startActivity(open);
            }
        });

        //--Lista View-- --
        lista2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open = new Intent(ListaTabla.this, ListaView.class);
                startActivity(open);
            }
        });
        //--Lista Optimizacion-- --
        lista3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open = new Intent(ListaTabla.this, ListaOpt.class);
                startActivity(open);
            }
        });
        //--Tablas-- --
        tabla1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open = new Intent(ListaTabla.this, Tablas.class);
                startActivity(open);
            }
        });
    }
}

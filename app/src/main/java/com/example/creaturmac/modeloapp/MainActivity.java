package com.example.creaturmac.modeloapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//-- Importar contenidos -- -- -- -- --//
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    //-- Variables -- -- --//
    private Button boton1;
    private Button boton2;
    private Button boton3;
    private Button boton4;
    private Button boton5;
    private Button boton6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //--Controles de la interfaz -- -- -- -- --//
        boton1 = (Button)findViewById(R.id.boton1);
        boton2 = (Button)findViewById(R.id.boton2);
        boton3 = (Button)findViewById(R.id.boton3);
        boton4 = (Button)findViewById(R.id.boton4);
        boton5 = (Button)findViewById(R.id.boton5);
        boton6 = (Button)findViewById(R.id.boton6);

        //--Abrir otras ventanas-- --//
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open = new Intent(MainActivity.this, Botones.class);
                startActivity(open);
            }
        });
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open = new Intent(MainActivity.this, Botones.class);
                startActivity(open);
            }
        });
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open = new Intent(MainActivity.this, Botones.class);
                startActivity(open);
            }
        });

    }
}

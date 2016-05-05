package com.example.creaturmac.modeloapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.Switch;
import android.widget.ImageButton;

import android.support.design.widget.FloatingActionButton;


public class Botones extends AppCompatActivity {

    private TextView txtCambio;

    private Button btnBotonSimple;
    private ToggleButton toggle;
    private Switch swit;
    private ImageButton imgbtn;
    private Button BtnBotonMasImagen;
    private ToggleButton BtnPersonalizado;
    private ImageButton BtnSinBorde;

    private Button BtnAceptar;
    private Button BtnCancelar;

    private FloatingActionButton fabButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botones);

        //-- --
        txtCambio = (TextView) findViewById(R.id.txtCambio);

        btnBotonSimple = (Button) findViewById(R.id.BtnBotonSimple);
        toggle = (ToggleButton) findViewById(R.id.toggle);
        swit = (Switch) findViewById(R.id.swit);
        imgbtn = (ImageButton) findViewById(R.id.imgbtn);
        BtnBotonMasImagen = (Button) findViewById(R.id.BtnBotonMasImagen);
        BtnPersonalizado = (ToggleButton) findViewById(R.id.BtnPersonalizado);
        BtnSinBorde = (ImageButton) findViewById(R.id.BtnSinBorde);

        BtnAceptar = (Button) findViewById(R.id.BtnAceptar);
        BtnCancelar = (Button) findViewById(R.id.BtnCancelar);

        fabButton = (FloatingActionButton) findViewById(R.id.fab);

        //--Boton simple
        btnBotonSimple.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                txtCambio.setText("Botón Simple pulsado!");
            }
        });
        //--Boton Toggle
        toggle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                if (toggle.isChecked())
                    txtCambio.setText("Botón Toggle: ON");
                else
                    txtCambio.setText("Botón Toggle: OFF");
            }
        });
        //--Boton Switch
        swit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                if (swit.isChecked())
                    txtCambio.setText("Botón Switch: ON");
                else
                    txtCambio.setText("Botón Switch: OFF");
            }
        });
        //--Boton ImageButton
        imgbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                txtCambio.setText("Botón Imagen pulsado!");
            }
        });
        //--Boton + Imagen
        BtnBotonMasImagen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                txtCambio.setText("Botón + Imagen pulsado!");
            }
        });
        //--Boton personalizado
        BtnPersonalizado.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                txtCambio.setText("Botón personalizado pulsado!");
            }
        });
        //--Boton sin Borde
        BtnSinBorde.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                txtCambio.setText("Botón sin borde pulsado!");
            }
        });
        //--Boton simple
        BtnAceptar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                txtCambio.setText("Botón Aceptar en barra pulsado!");
            }
        });
        //--Boton simple
        BtnCancelar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                txtCambio.setText("Botón Cancelar en barra pulsado!");
            }
        });

        fabButton.setBackgroundTintList(getResources().getColorStateList(R.color.fab_color));

        fabButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                txtCambio.setText("Botón Flotante pulsado!");
            }
        });

    }
}

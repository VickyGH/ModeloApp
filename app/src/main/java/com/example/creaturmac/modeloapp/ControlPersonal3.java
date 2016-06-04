package com.example.creaturmac.modeloapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ControlPersonal3 extends AppCompatActivity {

    private Button btnFicha;
    private TresEnRaya terTablero;
    private TextView txtCasilla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_personal3);

        terTablero = (TresEnRaya)findViewById(R.id.tablero);
        btnFicha = (Button)findViewById(R.id.btnFicha);
        txtCasilla = (TextView)findViewById(R.id.txtCasilla);

        btnFicha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                terTablero.alternarFichaActiva();
            }
        });

        terTablero.setOnCasillaSeleccionadaListener(new OnCasillaSeleccionadaListener() {
           @Override
            public void onCasillaSeleccionada(int fila, int columna) {
                txtCasilla.setText("Última casilla seleccionada: " + fila + "." + columna);
            }
        });
    }
}

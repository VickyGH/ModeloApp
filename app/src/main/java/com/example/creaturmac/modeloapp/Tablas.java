package com.example.creaturmac.modeloapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;


public class Tablas extends AppCompatActivity {

    private TextView lblMensaje;
    private GridView grdOpciones;

    private String[] datos = new String[130];
    private GridView grdOpciones1;

    private String[] datos1 = new String[50];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablas);

        for (int i = 1; i <= 130; i++)
            datos[i - 1] = "Dato " + i;

        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);

        lblMensaje = (TextView)findViewById(R.id.lblMensaje);
        grdOpciones = (GridView)findViewById(R.id.GridOpciones);

        grdOpciones.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent,
                                            android.view.View v, int position, long id) {
                        lblMensaje.setText("Opción seleccionada: "
                                + parent.getItemAtPosition(position));
                    }
                });

        grdOpciones.setAdapter(adaptador);

    }
}

package com.example.creaturmac.modeloapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;

import android.widget.TextView;

public class Listas extends AppCompatActivity {

    private Spinner cmbOpciones;
    private Spinner cmbOpciones1;
    private TextView lblMensaje;
    private TextView lblMensaje1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas);

        cmbOpciones = (Spinner) findViewById(R.id.CmbOpciones);
        cmbOpciones1 = (Spinner) findViewById(R.id.CmbOpciones1);

        lblMensaje = (TextView) findViewById(R.id.lblMensaje);
        lblMensaje1 = (TextView) findViewById(R.id.lblMensaje1);

        final String[] datos = new String[]{"Elem1", "Elem2", "Elem3", "Elem4", "Elem5"};

        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datos);

        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        cmbOpciones.setAdapter(adaptador);

        cmbOpciones.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent,
                                               android.view.View v, int position, long id) {
                        lblMensaje.setText("Seleccionado: " + parent.getItemAtPosition(position));
                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                        lblMensaje.setText("");
                    }
                });

        // Segundo Sppinner
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this,
                        R.array.valores_array,
                        android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        cmbOpciones1.setAdapter(adapter);

        cmbOpciones1.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent,
                                               android.view.View v, int position, long id) {
                        lblMensaje1.setText("Seleccionado: " + parent.getItemAtPosition(position));
                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                        lblMensaje1.setText("");
                    }
                });

    }
}

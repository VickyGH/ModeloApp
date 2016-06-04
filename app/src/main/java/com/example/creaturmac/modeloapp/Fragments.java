package com.example.creaturmac.modeloapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Fragments extends AppCompatActivity implements fragment_listado.CorreosListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);

        fragment_listado frgListado
                = (fragment_listado) getSupportFragmentManager()
                .findFragmentById(R.id.FrgListado);

        frgListado.setCorreosListener(this);
    }

    @Override
    public void onCorreoSeleccionado(Correo c) {
        boolean hayDetalle =
                (getSupportFragmentManager().findFragmentById(R.id.FrgDetalle) != null);

        if (hayDetalle) {
            ((fragment_detalle) getSupportFragmentManager()
                    .findFragmentById(R.id.FrgDetalle)).mostrarDetalle(c.getTexto());
        } else {
            Intent i = new Intent(this, /*DetalleActivity*/ fragment_detalle.class);
            i.putExtra(detalle.EXTRA_TEXTO, c.getTexto());
            startActivity(i);
        }
    }

}

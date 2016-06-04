package com.example.creaturmac.modeloapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class detalle extends AppCompatActivity {

    public static final String EXTRA_TEXTO =
            "com.example.creaturmac.modeloapp.EXTRA_TEXTO";
    // net.sgoliver.android.fragments.EXTRA_TEXTO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        fragment_detalle detalle =
                (fragment_detalle)getSupportFragmentManager()
                        .findFragmentById(R.id.FrgDetalle);

        detalle.mostrarDetalle(getIntent().getStringExtra(EXTRA_TEXTO));
    }
}

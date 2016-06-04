package com.example.creaturmac.modeloapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ControlPersonal extends AppCompatActivity {

    private Button cont1;
    private Button cont2;
    private Button cont3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_personal);

        cont1 = (Button)findViewById(R.id.cont1);
        cont2 = (Button)findViewById(R.id.cont2);
        cont3 = (Button)findViewById(R.id.cont3);

        cont1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open = new Intent(ControlPersonal.this, ControlPersonal1.class);
                startActivity(open);
            }
        });
        cont2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open = new Intent(ControlPersonal.this, ControlPersonal2.class);
                startActivity(open);
            }
        });
        cont3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open = new Intent(ControlPersonal.this, ControlPersonal3.class);
                startActivity(open);
            }
        });
    }
}


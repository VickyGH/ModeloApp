package com.example.creaturmac.modeloapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import android.widget.TextView;
import android.widget.RadioButton;

public class CheckRadio extends AppCompatActivity {

    private CheckBox ChkMarcame;
    private CheckBox ChkMarcame1;
    private RadioGroup rg;

    private TextView lblMensaje;
    private RadioButton rbOpcion1;
    private RadioButton rbOpcion2;

    private RadioGroup rgOpciones;
    //private RadioButton rbOpcion;
    //private RadioButton rbOpcion0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_radio);

        ChkMarcame = (CheckBox)findViewById(R.id.ChkMarcame);
        ChkMarcame1 = (CheckBox)findViewById(R.id.ChkMarcame1);
        rg =  (RadioGroup)findViewById(R.id.GrbGrupo1);

        lblMensaje = (TextView)findViewById(R.id.txtCheckRadio);
        rbOpcion1 = (RadioButton)findViewById(R.id.RbOpcion1);
        rbOpcion2 = (RadioButton)findViewById(R.id.RbOpcion2);

        //-- Acciones -- -- -- -- -- -- -- -- -- -- -- -- --//

        //Primera forma de hacer un check
        ChkMarcame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                boolean isChecked = ((CheckBox)view).isChecked();
                if (isChecked) {
                    ChkMarcame.setText("Checkbox marcado!");
                }
                else {
                    ChkMarcame.setText("Checkbox desmarcado!");
                }
            }
        });

        ChkMarcame1.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ChkMarcame1.setText("Checkbox marcado!");
                }
                else {
                    ChkMarcame1.setText("Checkbox desmarcado!");
                }
            }
        });

        //-- Radio Grupo-- --- -- -- -- -- --- -- -- --//
        rg = (RadioGroup)findViewById(R.id.GrbGrupo1);
        rg.clearCheck();
        rg.check(R.id.RbOpcion1);
        int idSeleccionado = rg.getCheckedRadioButtonId();

        //-- -- --
        View.OnClickListener list = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String opcion = "";
                switch(view.getId()) {
                    case R.id.RbOpcion1:
                        opcion = "opción 1";
                        break;
                    case R.id.RbOpcion2:
                        opcion = "opción 2";
                        break;
                }

                lblMensaje.setText("Radio Button 1: " + opcion);
            }
        };

        rbOpcion1.setOnClickListener(list);
        rbOpcion2.setOnClickListener(list);

        //-- CheckBoxes -- --
        rgOpciones = (RadioGroup)findViewById(R.id.GrbGrupo2);

        rgOpciones.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String opcion = "";
                switch(checkedId) {
                    case R.id.RbOpcion:
                        opcion = "opción 1";
                        break;
                    case R.id.RbOpcion0:
                        opcion = "opción 2";
                        break;
                }
                lblMensaje.setText("Radio Button 2: " + opcion);
            }
        });

    }
}

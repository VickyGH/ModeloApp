package com.example.creaturmac.modeloapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.text.Editable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.EditText;

import android.text.Spannable;
import android.text.style.StyleSpan;
import android.text.Html;
import android.widget.TextView.BufferType;
import android.support.design.widget.TextInputLayout;
import android.widget.Button;
import android.view.View;

public class txt_img extends AppCompatActivity {

    private ImageView imgView;
    private TextView lblEtiqueta;
    private EditText txtTexto2;
    private TextInputLayout txtInputLayout;
    private EditText txtInput;
    private Button btnComprobar;

    //private Spannable txtImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_txt_img);

        //-- ImageView -- -- --
        imgView= (ImageView)findViewById(R.id.ImgFoto);
        imgView.setImageResource(R.drawable.ic_estrella);

        //-- Texto (label)-- -- -- -
        final TextView lblEtiqueta = (TextView)findViewById(R.id.lblEtiqueta);
        String texto = lblEtiqueta.getText().toString();
        texto += " -- -- -- 123";
        lblEtiqueta.setText(texto);
        lblEtiqueta.setBackgroundColor(getResources().getColor(R.color.colores));

        //--Cambiar el texto de un editor-- --//
        EditText txtTexto = (EditText)findViewById(R.id.TxtBasico);
        String text = txtTexto.getText().toString();
        txtTexto.setText("Hola mundo!");

        //-- Esto cambia el esrilo del texto --//
        EditText txtTexto1 = (EditText)findViewById(R.id.TxtBasico1);
        //Creamos un nuevo objeto de tipo Editable
        Editable str = Editable.Factory.getInstance().newEditable("Esto es un simulacro.");
        //Marcamos como fuente negrita la palabra "simulacro" (caracteres del 11-19)
        str.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 11, 19, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //Activar el cambio
        txtTexto1.setText(str);

        //-- -- --//
        EditText txtTexto2 = (EditText)findViewById(R.id.TxtBasico2);
        Spannable Text = txtTexto2.getText();
        //txtTexto2.setText("Esto es una prueba");

        int ini = txtTexto2.getSelectionStart();
        int fin = txtTexto2.getSelectionEnd();

        Text.setSpan(
                new StyleSpan(android.graphics.Typeface.BOLD),
                ini, fin,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //Asignar
        //txtTexto2.setText(Text);


        //Obtiene el texto del control con etiquetas de formato HTML
        String aux2 = Html.toHtml(txtTexto.getText());
        //Asigna texto con formato HTML
        txtTexto.setText(
                Html.fromHtml("<p>Esto es <b>un simulacro</b>.</p>"),
                BufferType.SPANNABLE);
        /* */
        //Comprobar
        txtInputLayout = (TextInputLayout)findViewById(R.id.TiLayout);
        txtInputLayout.setErrorEnabled(true);

        txtInput = (EditText)findViewById(R.id.TxtInput);

        btnComprobar = (Button)findViewById(R.id.BtnInputLayout);
        btnComprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = txtInput.getText().toString();

                if(num.isEmpty() || Integer.parseInt(num)%2 != 0)
                    txtInputLayout.setError("Error: No es un número par!");
                else
                    txtInputLayout.setError(null);
            }
        });
    }
}

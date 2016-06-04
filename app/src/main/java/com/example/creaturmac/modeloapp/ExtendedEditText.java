package com.example.creaturmac.modeloapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;

/**
 * Created by creaturmac on 03/06/16.
 */
public class ExtendedEditText extends EditText {
    private Paint p1;
    private Paint p2;
    private float escala;

    public ExtendedEditText(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);

        inicializacion();
    }

    public ExtendedEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        inicializacion();
    }

    public ExtendedEditText(Context context) {
        super(context);

        inicializacion();
    }

    private void inicializacion()
    {
        /* Este es el cuadro*/
        p1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p1.setColor(Color.BLUE);
        p1.setStyle(Paint.Style.FILL);
        /* Este es el numero*/
        p2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p2.setColor(Color.WHITE);
        p2.setTextSize(20);

        escala = getResources().getDisplayMetrics().density;
        Log.v("Vicky", "Escala "+escala);
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        //Llamamos al método de la clase base (EditText)
        super.onDraw(canvas);

        //Dibujamos el fondo negro del contador
        canvas.drawRect(this.getWidth()-30*escala, 5*escala, this.getWidth()-5*escala, 20*escala, p1) ;

        //Dibujamos el número de caracteres sobre el contador
        canvas.drawText("" + this.getText().toString().length(), this.getWidth()-28*escala, 17*escala, p2);
    }
}

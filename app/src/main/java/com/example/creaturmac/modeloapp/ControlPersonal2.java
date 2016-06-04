package com.example.creaturmac.modeloapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ControlPersonal2 extends AppCompatActivity {

    private ControlLogin ctlLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_personal2);
        //-- -- -- -- -- --

        ctlLogin = (ControlLogin)findViewById(R.id.CtlLogin);

        ctlLogin.setOnLoginListener(new ControlLogin.OnLoginListener()
        {
            @Override
            public void onLogin(String usuario, String password)
            {
                //Validamos el usuario y la contraseña
                if (usuario.equals("demo") && password.equals("demo"))
                    ctlLogin.setMensaje("Login correcto!");
                else
                    ctlLogin.setMensaje("Vuelva a intentarlo.");
            }
        });
    }
}

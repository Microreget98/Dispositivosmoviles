package com.example.appcuentoscontarte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class InicioSesion extends AppCompatActivity implements View.OnClickListener {

    Button btnregistro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        btnregistro = (Button) findViewById(R.id.btnregistro);
    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnregistro:
                Toast.makeText(getApplicationContext(), "Se presiono registro", Toast.LENGTH_LONG).show();
        }
    }
}

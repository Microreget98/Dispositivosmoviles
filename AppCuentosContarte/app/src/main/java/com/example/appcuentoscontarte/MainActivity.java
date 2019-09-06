package com.example.appcuentoscontarte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btncomenzar_menu, btnsalir_menu, btninfo_menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btncomenzar_menu = (Button)findViewById(R.id.btncomenzar_menu);

        btncomenzar_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent comenzar= new Intent(MainActivity.this, Inicio.class);
                MainActivity.this.startActivity(comenzar);
                //Toast.makeText(getApplicationContext(), "Se presiono", Toast.LENGTH_LONG).show();
                MainActivity.this.finish();
            }
        });




    }
}

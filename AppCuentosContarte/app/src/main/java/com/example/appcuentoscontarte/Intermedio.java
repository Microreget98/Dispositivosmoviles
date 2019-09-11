package com.example.appcuentoscontarte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Intermedio extends AppCompatActivity {
    Button btncuento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermedio);

        btncuento = findViewById(R.id.btncuento);

        btncuento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cuento = new Intent(Intermedio.this, Lienzo.class);
                Intermedio.this.startActivity(cuento);
                Intermedio.this.finish();
            }
        });
    }

//    private void Creacionmenu(basedatos){
//
//    }
}

package com.example.appcuentoscontarte;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Inicio extends AppCompatActivity {

    MediaPlayer mp;
    Button btnreproducir;
    TextView tvCuento;
    private int current_frase;

    private String[] frases;
    private  String f;

    private String[] audios;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //codigo adicional
       // this.finish();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        /*Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); */

        btnreproducir = (Button)findViewById(R.id.btnreproducir);
        tvCuento = (TextView) findViewById(R.id.tvCuento);

        mp = MediaPlayer.create(this,R.raw.liebretortuga);

        current_frase=0;

        frases = getResources().getStringArray(R.array.cuento1);
        f = frases[current_frase];
        tvCuento.setText(f);

        btnreproducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp!=null){
                    mp.start();
                }

                /*else if(mp.isPlaying()){
                    mp.stop();
                    mp.start();
                }*/


               /* ){

                    mp.start();
                }*/

            }
        });


    }
}
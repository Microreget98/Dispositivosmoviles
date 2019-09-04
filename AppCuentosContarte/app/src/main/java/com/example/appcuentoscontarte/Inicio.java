package com.example.appcuentoscontarte;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Inicio extends AppCompatActivity {

    MediaPlayer mp;
    Button btnreproducir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        btnreproducir = (Button)findViewById(R.id.btnreproducir);

        mp = MediaPlayer.create(this,R.raw.liebretortuga);

        btnreproducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // if(mp!=null){
                    mp.start();
              //  }

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

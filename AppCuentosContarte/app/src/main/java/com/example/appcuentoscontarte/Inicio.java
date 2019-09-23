package com.example.appcuentoscontarte;

import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Inicio extends AppCompatActivity implements View.OnClickListener{


    ImageButton negro, cafe, naranja,rojo, rosa, morado, amarillo,verdelimon, verde,turquesa, celeste, azul;
    MediaPlayer mp,mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15,mp16,mp17,mp18,mp19,mp20,mp21,mp22,mp23;
    ImageButton btnreproducir;
    ImageButton btnsiguiente;
    TextView tvCuento;
    private int current_frase, current_audio;

    private String[] frases;
    private  String f, a;
    int[] sounds;

    int k;

    String cs;
    private String comp;

    Lienzo lienzo;

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


        btnreproducir = (ImageButton) findViewById(R.id.btnreproducir);
        btnsiguiente = (ImageButton)findViewById(R.id.btnsiguiente);
        tvCuento = (TextView) findViewById(R.id.tvCuento);

        negro = (ImageButton)findViewById(R.id.btnnegro);
        cafe = (ImageButton)findViewById(R.id.btncafe);
        naranja = (ImageButton)findViewById(R.id.btnnaranja);
        rojo = (ImageButton)findViewById(R.id.btnrojo);
        rosa= (ImageButton)findViewById(R.id.btnrosa);
        morado = (ImageButton)findViewById(R.id.btnmorado);
        amarillo = (ImageButton)findViewById(R.id.btnamarillo);
        verde = (ImageButton)findViewById(R.id.btnverdefuerte);
        verdelimon = (ImageButton)findViewById(R.id.btnverde);
        turquesa = (ImageButton)findViewById(R.id.btnturquesa);
        celeste = (ImageButton)findViewById(R.id.btnceleste);
        azul = (ImageButton)findViewById(R.id.btnazul);

        lienzo= (Lienzo)findViewById(R.id.lienzo);

        negro.setOnClickListener(this);
        cafe.setOnClickListener(this);
        naranja.setOnClickListener(this);
        rojo.setOnClickListener(this);
        rosa.setOnClickListener(this);
        morado.setOnClickListener(this);
        amarillo.setOnClickListener(this);
        verde.setOnClickListener(this);
        verdelimon.setOnClickListener(this);
        turquesa.setOnClickListener(this);
        celeste.setOnClickListener(this);
        azul.setOnClickListener(this);

        btnsiguiente.setOnClickListener(this);
        btnreproducir.setOnClickListener(this);

        // mp = MediaPlayer.create(this,R.raw.liebretortuga);
        //audios = getResources().getStringArray(R.array.audio1);
        //a = audios[current_audio];

        // mp = MediaPlayer.create(this,R.raw.liebretortuga);
        recibirDato();

        current_frase=0;
        current_audio =0;

        frases = getResources().getStringArray(R.array.cuento1);
        f = frases[current_frase];
        tvCuento.setText(f);

        if(cs.equals("caperucita")){ // Comparación de Cadenas con .equals
            Toast.makeText(getApplicationContext(), "La Caperucita Roja", Toast.LENGTH_LONG).show();
            int[] sounds ={R.raw.caperucita1, R.raw.caperucita2, R.raw.caperucita3,R.raw.caperucita4,R.raw.caperucita5,R.raw.caperucita6,R.raw.caperucita7,R.raw.caperucita8,R.raw.caperucita9,R.raw.caperucita10,R.raw.caperucita11,R.raw.caperucita12,R.raw.caperucita13,R.raw.caperucita14,R.raw.caperucita15,R.raw.caperucita16,R.raw.caperucita17,R.raw.caperucita18,R.raw.caperucita19,R.raw.caperucita20,R.raw.caperucita21,R.raw.caperucita22,R.raw.caperucita23};

            mp = MediaPlayer.create(this, sounds[0]);
            mp1 = MediaPlayer.create(this, sounds[1]);
            mp2 = MediaPlayer.create(this, sounds[2]);
            mp3 = MediaPlayer.create(this, sounds[3]);
            mp4 = MediaPlayer.create(this, sounds[4]);
            mp5 = MediaPlayer.create(this, sounds[5]);
            mp6 = MediaPlayer.create(this, sounds[6]);
            mp7 = MediaPlayer.create(this, sounds[7]);
            mp8 = MediaPlayer.create(this, sounds[8]);
            mp9 = MediaPlayer.create(this, sounds[9]);
            mp10 = MediaPlayer.create(this, sounds[10]);
            mp11 = MediaPlayer.create(this, sounds[11]);
            mp12 = MediaPlayer.create(this, sounds[12]);
            mp13 = MediaPlayer.create(this, sounds[13]);
            mp14 = MediaPlayer.create(this, sounds[14]);
            mp15 = MediaPlayer.create(this, sounds[15]);
            mp16 = MediaPlayer.create(this, sounds[16]);
            mp17 = MediaPlayer.create(this, sounds[17]);
            mp18 = MediaPlayer.create(this, sounds[18]);
            mp19 = MediaPlayer.create(this, sounds[19]);
            mp20 = MediaPlayer.create(this, sounds[20]);
            mp21 = MediaPlayer.create(this, sounds[21]);
            mp22 = MediaPlayer.create(this, sounds[22]);


            //mp.setOnCompletionListener(Inicio);
            mp.start();
        }



    }

    private void reproducirAudio(){
        if(current_audio<sounds.length){
            mp = MediaPlayer.create(this, sounds[1]);
            mp.start();
        }


    }
    private void recibirDato(){
        Bundle extras = getIntent().getExtras();
        cs= extras.getString("cuentoseleccionado");


        //Toast.makeText(getApplicationContext(), cs, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        String color = null;

        switch (v.getId()){
            case R.id.btnsiguiente:
                if(current_frase+1<frases.length){
                    current_frase++;
                    //showQuestion();
                    f = frases[current_frase];
                    tvCuento.setText(f);

                }else {

                    Toast.makeText(getApplicationContext(), "Se termino cuento", Toast.LENGTH_LONG).show();
                }
                current_audio++;

                //String cuenta= String.valueOf(current_audio);
              //  String tamano = String.valueOf(frases.length);
                //Toast.makeText(getApplicationContext(), "Tamaño es "+tamano, Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplicationContext(), "La cuenta es "+cuenta, Toast.LENGTH_LONG).show();


               // Toast.makeText(getApplicationContext(), "La cuenta es "+cuenta, Toast.LENGTH_LONG).show();
                //
                //reproducirAudio();
                switch (current_audio){
                    case 1:
                        mp.stop();
                        mp1.start();
                        break;
                    case 2:
                        mp1.stop();
                        mp2.start();
                        break;
                    case 3:
                        mp2.stop();
                        mp3.start();
                        break;
                    case 4:
                        mp3.stop();
                        mp4.start();
                        break;
                    case 5:
                        mp4.stop();
                        mp5.start();
                        break;
                    case 6:
                        mp5.stop();
                        mp6.start();
                        break;
                    case 7:
                        mp6.stop();
                        mp7.start();
                        break;
                    case 8:
                        mp7.stop();
                        mp8.start();
                        break;
                    case 9:
                        mp8.stop();
                        mp9.start();
                        break;
                    case 10:
                        mp9.stop();
                        mp10.start();
                        break;
                    case 11:
                        mp10.stop();
                        mp11.start();
                        break;
                    case 12:
                        mp11.stop();
                        mp12.start();
                        break;
                    case 13:
                        mp12.stop();
                        mp13.start();
                        break;
                    case 14:
                        mp13.stop();
                        mp14.start();
                       // Toast.makeText(getApplicationContext(), "La cuenta es "+cuenta, Toast.LENGTH_LONG).show();
                        break;
                    case 15:
                        mp14.stop();
                        mp15.start();
                        break;
                    case 16:
                        mp15.stop();
                        mp16.start();
                        break;
                    case 17:
                        mp16.stop();
                        mp17.start();
                        break;
                    case 18:
                        mp17.stop();
                        mp18.start();
                        break;
                    case 19:
                        mp18.stop();
                        mp19.start();
                        break;
                    case 20:
                        mp19.stop();
                        mp20.start();
                        break;
                    case 21:
                        mp20.stop();
                        mp21.start();
                        break;
                    case 22:
                        mp21.stop();
                        mp22.start();
                        break;

                }

                break;

            case R.id.btnnegro:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.btncafe:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.btnnaranja:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.btnrojo:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.btnrosa:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.btnmorado:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.btnamarillo:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.btnverde:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.btnverdefuerte:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.btnturquesa:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.btnceleste:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.btnazul:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            default:
                break;

        }

    }
}
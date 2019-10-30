package com.example.appcuentoscontarte;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.PixelCopy;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;



import org.w3c.dom.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Inicio extends AppCompatActivity implements View.OnClickListener{

    ImageButton negro, cafe, naranja,rojo, rosa, morado, amarillo,verdelimon, verde,turquesa, celeste, azul;
    MediaPlayer mp;
    ImageButton btnreproducir, btnsiguiente,btnborrador, btntrazo, btnhojanueva, btnguardar;
    TextView tvCuento;
    private int current_frase, current_audio, control;

    float ppequeno;
    float pmediano;
    float pgrande;
    float pdefecto;

    private String[] frases;
    private int[] tiempos;
    private  String f, a;
    int sound, i = 0, currentiempo = 0;

    int k;
    int current;

    String cs;
    private String comp;

    Lienzo lienzo;

    private ImageButton currPaint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        btnreproducir = (ImageButton) findViewById(R.id.btnreproducir);
        btnsiguiente = (ImageButton) findViewById(R.id.btnsiguiente);
        btntrazo = (ImageButton)findViewById(R.id.btntrazo);
        btnborrador = (ImageButton)findViewById(R.id.btnborrador);
        btnguardar = (ImageButton)findViewById(R.id.btnguardar);
        btnhojanueva = (ImageButton)findViewById(R.id.btnhojanueva);

        tvCuento = (TextView) findViewById(R.id.tvCuento);

        negro = (ImageButton) findViewById(R.id.btnnegro);
        cafe = (ImageButton) findViewById(R.id.btncafe);
        naranja = (ImageButton) findViewById(R.id.btnnaranja);
        rojo = (ImageButton) findViewById(R.id.btnrojo);
        rosa = (ImageButton) findViewById(R.id.btnrosa);
        morado = (ImageButton) findViewById(R.id.btnmorado);
        amarillo = (ImageButton) findViewById(R.id.btnamarillo);
        verde = (ImageButton) findViewById(R.id.btnverdefuerte);
        verdelimon = (ImageButton) findViewById(R.id.btnverde);
        turquesa = (ImageButton) findViewById(R.id.btnturquesa);
        celeste = (ImageButton) findViewById(R.id.btnceleste);
        azul = (ImageButton) findViewById(R.id.btnazul);

        lienzo = (Lienzo) findViewById(R.id.lienzo);

        ppequeno=10;
        pmediano=20;
        pgrande=30;
        pdefecto = pmediano;

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
        btntrazo.setOnClickListener(this);
        btnborrador.setOnClickListener(this);
        btnhojanueva.setOnClickListener(this);
        btnguardar.setOnClickListener(this);

        recibirDato();

        if (cs.equals("caperucita")) { // Comparación de Cadenas con .equals
            Toast.makeText(getApplicationContext(), "La Caperucita Roja", Toast.LENGTH_LONG).show();
            sound = R.raw.caperucita;
            frases = getResources().getStringArray(R.array.cuento1);
            tiempos = getResources().getIntArray(R.array.caperucita);
            mp = MediaPlayer.create(this, sound);
        }

        control=0;
        current_frase = 0;
        current_audio = 0;
        f = frases[current_frase];
        tvCuento.setText(f);

    }


    private void recibirDato(){
        Bundle extras = getIntent().getExtras();
        cs = extras.getString("cuentoseleccionado");


        //Toast.makeText(getApplicationContext(), cs, Toast.LENGTH_LONG).show();
    }

    public static  Bitmap viewToBitmap(View view,int width, int height){
        Bitmap bitmap = Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        return bitmap;
    }

    public void startSave(){
        FileOutputStream fileOutputStream=null;
        File file=getDisc();
        if(!file.exists() && !file.mkdir()){
            Toast.makeText(getApplicationContext(),"No se puede guardar este directorio",Toast.LENGTH_SHORT).show();
            return;
        }
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyymmsshhmmss");
        String date= simpleDateFormat.format(new Date());
        String name ="Img"+date+".jpg";
        String file_name=file.getAbsolutePath()+"/"+name;
        File new_file=new File(file_name);
        try{
            fileOutputStream=new FileOutputStream(new_file);
            Bitmap bitmap = viewToBitmap(lienzo,lienzo.getWidth(),lienzo.getHeight());
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,fileOutputStream);
            Toast.makeText(getApplicationContext(),"Save image sucess",Toast.LENGTH_SHORT).show();

            fileOutputStream.flush();
            fileOutputStream.close();


        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        refreshGallery(new_file);

    }

    public  void  refreshGallery(File file){
        Intent intent=new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        intent.setData(Uri.fromFile(file));
        sendBroadcast(intent);
    }
    private File getDisc(){
        File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);

        return  new File(file,"Image Demogg");

    }


    public void paintClicked(View view){
        //use chosen color
        Toast.makeText(getApplicationContext(), "¡No entra!", Toast.LENGTH_LONG).show();

        if(view!=currPaint){
            //update color
            ImageButton imgView = (ImageButton)view;
            String color = view.getTag().toString();
            Toast.makeText(getApplicationContext(), "¡Cambiar!", Toast.LENGTH_LONG).show();
        }


    }

    @Override
    public void onClick(View v) {

        String color = null;

        switch (v.getId()) {

            case R.id.btnhojanueva:
                AlertDialog.Builder newDialog = new AlertDialog.Builder(this);
                newDialog.setTitle("Nuevo Dibujo");
                newDialog.setMessage("¿Comenzar un nuevo dibujo? (perderás el dibujo actual");
                newDialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        lienzo.NuevoDibujo();
                        dialog.dismiss();

                    }
                });
                newDialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();

                    }
                });
                newDialog.show();


                break;

            case R.id.btnguardar:

                AlertDialog.Builder salvarDibujo = new AlertDialog.Builder(this);
                salvarDibujo.setTitle("Guardar Dibujo");
                salvarDibujo.setMessage("¿Desea guardar dibujo? ");
                salvarDibujo.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        View v1 = getWindow().getDecorView().getRootView();
                        startSave();
                    }
                });
                salvarDibujo.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();

                    }
                });
                salvarDibujo.show();
                break;

            case R.id.btnborrador: /*Borrador*/
                final Dialog borrarpunto = new Dialog(this);
                borrarpunto.setTitle("Tamaño del borrado: ");
                borrarpunto.setContentView(R.layout.tamano_punto);

                TextView smallBtnBorrar = (TextView) borrarpunto.findViewById(R.id.tpequeno);
                smallBtnBorrar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Lienzo.setBorrado(true);
                        Lienzo.setTamanoPunto(ppequeno);

                        borrarpunto.dismiss();

                    }
                });
                TextView mediumBtnBorrar = (TextView) borrarpunto.findViewById(R.id.tmediano);
                mediumBtnBorrar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Lienzo.setBorrado(true);
                        Lienzo.setTamanoPunto(pmediano);

                        borrarpunto.dismiss();
                    }
                });
                TextView bigBtnBorrar = (TextView) borrarpunto.findViewById(R.id.tgrande);
                bigBtnBorrar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Lienzo.setBorrado(true);
                        Lienzo.setTamanoPunto(pgrande);

                        borrarpunto.dismiss();
                    }
                });
                borrarpunto.show();
                break;

            case R.id.btntrazo: /* Tamaño de punto*/
                final Dialog tamanopunto = new Dialog(this);
                // Toast.makeText(getApplicationContext(), "Presiono trazo", Toast.LENGTH_LONG).show();
                tamanopunto.setTitle("Tamaño del punto: ");
                tamanopunto.setContentView(R.layout.tamano_punto);

                TextView smallBtn = (TextView) tamanopunto.findViewById(R.id.tpequeno);
                smallBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Lienzo.setBorrado(false);
                        Lienzo.setTamanoPunto(ppequeno);

                        tamanopunto.dismiss();

                    }
                });
                TextView mediumBtn = (TextView) tamanopunto.findViewById(R.id.tmediano);
                mediumBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Lienzo.setBorrado(false);
                        Lienzo.setTamanoPunto(pmediano);

                        tamanopunto.dismiss();
                    }
                });
                TextView bigBtn = (TextView) tamanopunto.findViewById(R.id.tgrande);
                bigBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Lienzo.setBorrado(false);
                        Lienzo.setTamanoPunto(pgrande);

                        tamanopunto.dismiss();
                    }
                });
                tamanopunto.show();
                break;
            case R.id.btnreproducir:
                String naudio = String.valueOf(current_audio);
                Toast.makeText(getApplicationContext(), naudio, Toast.LENGTH_LONG).show();
                break;

            case R.id.btnsiguiente:
                if(i == 0){
                    mp.start();
                }
                else{
                    if(!mp.isPlaying() && i > 0){
                        mp.seekTo(tiempos[i-1]);
                        mp.start();
                    }
                }
                while (mp.isPlaying()){
                    currentiempo = mp.getCurrentPosition();
                    if(currentiempo == tiempos[i]){
                        mp.pause();
                        i++;
                    }
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
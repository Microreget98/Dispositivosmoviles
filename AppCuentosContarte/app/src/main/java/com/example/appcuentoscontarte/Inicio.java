package com.example.appcuentoscontarte;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.media.MediaPlayer;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
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
    MediaPlayer mp,mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15,mp16,mp17,mp18,mp19,mp20,mp21,mp22;
    ImageButton btnreproducir, btnsiguiente,btnborrador, btntrazo, btnhojanueva, btnguardar;
    Button btncompr;
    TextView tvCuento;
    private int current_frase, current_audio, control;

    float ppequeno;
    float pmediano;
    float pgrande;
    float pdefecto;

    private String[] frases;
    private  String f, a;
    int[] sounds;

    int k;
    int current;


    LinearLayout paintLayout1;
    LinearLayout paintLayout2;

    String cs;
    private String comp;

    Lienzo lienzo;

    private ImageButton currPaint;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(mp.isPlaying()){
            mp.stop();
        }
        if(mp1.isPlaying()){
            mp1.stop();
        }
        if(mp2.isPlaying()){
            mp2.stop();
        }
        if(mp3.isPlaying()){
            mp3.stop();
        }
        if(mp4.isPlaying()){
            mp4.stop();
        }
        if(mp5.isPlaying()){
            mp5.stop();
        }
        if(mp6.isPlaying()){
            mp6.stop();
        }
        if(mp7.isPlaying()){
            mp7.stop();
        }
        if(mp8.isPlaying()){
            mp8.stop();
        }
        if(mp9.isPlaying()){
            mp9.stop();
        }
        if(mp10.isPlaying()){
            mp10.stop();
        }
        if(mp11.isPlaying()){
            mp11.stop();
        }
        if(mp12.isPlaying()){
            mp12.stop();
        }
        if(mp13.isPlaying()){
            mp13.stop();
        }
        if(mp14.isPlaying()){
            mp14.stop();
        }
        if(mp15.isPlaying()){
            mp15.stop();
        }
        if(mp16.isPlaying()){
            mp16.stop();
        }
        if(mp17.isPlaying()){
            mp17.stop();
        }
        if(mp18.isPlaying()){
            mp18.stop();
        }
        if(mp19.isPlaying()){
            mp19.stop();
        }
        if(mp20.isPlaying()){
            mp20.stop();
        }
        if(mp21.isPlaying()){
            mp21.stop();
        }
        if(mp22.isPlaying()){
            mp22.stop();
        }

        //codigo adicional
        // this.finish();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        /*Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); */

        paintLayout1 = (LinearLayout)findViewById(R.id.paint_colors_1);
       paintLayout2 = (LinearLayout)findViewById(R.id.paint_colors_2);

        currPaint = (ImageButton)paintLayout2.getChildAt(5);
        currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));





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
            int[] sounds = {R.raw.caperucita1, R.raw.caperucita2, R.raw.caperucita3, R.raw.caperucita4, R.raw.caperucita5, R.raw.caperucita6, R.raw.caperucita7, R.raw.caperucita8, R.raw.caperucita9, R.raw.caperucita10, R.raw.caperucita11, R.raw.caperucita12, R.raw.caperucita13, R.raw.caperucita14, R.raw.caperucita15, R.raw.caperucita16, R.raw.caperucita17, R.raw.caperucita18, R.raw.caperucita19, R.raw.caperucita20, R.raw.caperucita21, R.raw.caperucita22, R.raw.caperucita23};

            frases = getResources().getStringArray(R.array.cuento1);

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

        }
        if(cs.equals("pollitocurioso")) {
            Toast.makeText(getApplicationContext(), "El Pollito Curioso", Toast.LENGTH_LONG).show();
            int[] sounds = {R.raw.pollitocurioso1, R.raw.pollitocurioso2, R.raw.pollitocurioso3, R.raw.pollitocurioso4, R.raw.pollitocurioso5,R.raw.pollitocurioso6,R.raw.pollitocurioso7,R.raw.pollitocurioso8};

            frases = getResources().getStringArray(R.array.cuento2);

            mp = MediaPlayer.create(this, sounds[0]);
            mp1 = MediaPlayer.create(this, sounds[1]);
            mp2 = MediaPlayer.create(this, sounds[2]);
            mp3 = MediaPlayer.create(this, sounds[3]);
            mp4 = MediaPlayer.create(this, sounds[4]);
            mp5 = MediaPlayer.create(this, sounds[5]);
            mp6 = MediaPlayer.create(this, sounds[6]);
            mp7 = MediaPlayer.create(this, sounds[7]);
        }

        //***********Inicialización**************

        control=0;
        current_frase = 0;
        current_audio = 0;
        f = frases[current_frase];
        tvCuento.setText(f);
        mp.start();
    }
// BITMAP


    private Bitmap getBitmapFromView(View view) {
        //Define a bitmap with the same size as the view
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(),Bitmap.Config.ARGB_8888);
        //Bind a canvas to it
        Canvas scanvas = new Canvas(returnedBitmap);
        //Get the view's background
        Drawable bgDrawable =view.getBackground();
        if (bgDrawable!=null) {
            //has background drawable, then draw it on the canvas
           //Toast.makeText(getApplicationContext(), " tiene dibujable", Toast.LENGTH_LONG).show();
            bgDrawable.draw(scanvas);
        }   else{
            //does not have background drawable, then draw white background on the canvas
            scanvas.drawColor(Color.WHITE);
        }
        // draw the view on the canvas
        view.draw(scanvas);
        //return the bitmap
        return returnedBitmap;
    }

    private File saveBitMap(Context context, View drawView){

        File pictureFileDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        if (!pictureFileDir.exists()) {
            //Toast.makeText(getApplicationContext(), " NO Sigue", Toast.LENGTH_LONG).show();
            boolean isDirectoryCreated = pictureFileDir.mkdirs();
            if(!isDirectoryCreated)
                 //Toast.makeText(getApplicationContext(), "  No se pudo crear directorio", Toast.LENGTH_LONG).show();
                Log.i("TAG", "Can't create directory to save the image");
            return null;
        }

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyymmsshhmmss");
        String date= simpleDateFormat.format(new Date());
        String name ="Img"+date+".jpg";
        String filename=pictureFileDir.getPath()+"/"+name;
        if(filename!=null){
           // Toast.makeText(getApplicationContext(), "Nombre archivo: "+filename, Toast.LENGTH_LONG).show();
        }

        File pictureFile = new File(filename);
        Bitmap sbitmap =getBitmapFromView(drawView);
        try {
            pictureFile.createNewFile();
           // Toast.makeText(getApplicationContext(), " Se creó imagen 2", Toast.LENGTH_LONG).show();
            FileOutputStream oStream = new FileOutputStream(pictureFile);
            sbitmap.compress(Bitmap.CompressFormat.PNG, 100, oStream);
            oStream.flush();
            oStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            //Toast.makeText(getApplicationContext(), " No se creó imagen", Toast.LENGTH_LONG).show();
            Log.i("TAG", "There was an issue saving the image.");
        }
        scanGallery( context,pictureFile.getAbsolutePath());
        return pictureFile;
    }

    private void scanGallery(Context cntx, String path) {
        try {
            MediaScannerConnection.scanFile(cntx, new String[]{path}, null, new MediaScannerConnection.OnScanCompletedListener() {
                public void onScanCompleted(String path, Uri uri) {
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            Log.i("TAG", "There was an issue scanning gallery.");
        }
    }

    private void recibirDato(){
        Bundle extras = getIntent().getExtras();
        cs = extras.getString("cuentoseleccionado");


        //Toast.makeText(getApplicationContext(), cs, Toast.LENGTH_LONG).show();
    }
/*
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

 */




    @Override
    public void onClick(View v) {

        String color = null;

        switch (v.getId()){

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

                     //   startSave();

                        View savingLayout =(View) findViewById(R.id.lienzo);
                        File file = saveBitMap(Inicio.this, savingLayout);
                        if (file!= null) {
                            Toast.makeText(getApplicationContext(), "¡Dibujo guardado en la galería!", Toast.LENGTH_LONG).show();

                            Log.i("TAG", "Drawing saved to the gallery!");
                        } else {
                            Toast.makeText(getApplicationContext(), "¡ Oops, dibujo  no se ha guardado en la galería!", Toast.LENGTH_LONG).show();

                            Log.i("TAG", "Oops! Image could not be saved.");
                        }

                        //takeScreenShot(v1);
                        // PixelShot.of(v1).setResultListener(this).save();




/*
                        try {
                            lienzo.setDrawingCacheEnabled(true);
                            Bitmap bitmap = lienzo.getDrawingCache();
                            File f = null;
                            if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                                File file = new File(Environment.getExternalStorageDirectory(),"TTImages_cache");
                                if(!file.exists()){
                                    file.mkdirs();
                                }
                                f = new File(file.getAbsolutePath()+file.separator+ "filename"+".png");
                            }
                            FileOutputStream ostream = new FileOutputStream(f);
                            bitmap.compress(Bitmap.CompressFormat.PNG, 10, ostream);
                            Toast.makeText(getApplicationContext(), "¡Dibujo guardado en la galería!", Toast.LENGTH_LONG).show();

                            ostream.close();
                        } catch(Exception e){
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "¡opps!", Toast.LENGTH_LONG).show();
                        } */


                       /* lienzo.setDrawingCacheEnabled(true);

                        String imgSaved = MediaStore.Images.Media.insertImage(
                                getContentResolver(), lienzo.getDrawingCache(),
                                UUID.randomUUID().toString()+"png","drawing");
                        if(imgSaved!=null){
                            Toast.makeText(getApplicationContext(), "¡Dibujo guardado en la galería!", Toast.LENGTH_LONG).show();

                        }
                        else{
                            Toast.makeText(getApplicationContext(), "¡Error!, no se ha guardado correctamente", Toast.LENGTH_LONG).show();

                        }
                        lienzo.destroyDrawingCache(); */

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

            case R.id.btncompr:
                Toast.makeText(getApplicationContext(), "Presiono comp", Toast.LENGTH_LONG).show();
                break;

            case R.id.btnborrador: /*Borrador*/
                final Dialog borrarpunto =  new Dialog(this);
                // Toast.makeText(getApplicationContext(), "Presiono trazo", Toast.LENGTH_LONG).show();
                borrarpunto.setTitle("Tamaño del borrado: ");
                borrarpunto.setContentView(R.layout.tamano_punto);

                TextView smallBtnBorrar = (TextView)borrarpunto.findViewById(R.id.tpequeno);
                smallBtnBorrar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Lienzo.setBorrado(true);
                        Lienzo.setTamanoPunto(ppequeno);

                        borrarpunto.dismiss();

                    }
                });
                TextView mediumBtnBorrar = (TextView)borrarpunto.findViewById(R.id.tmediano);
                mediumBtnBorrar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Lienzo.setBorrado(true);
                        Lienzo.setTamanoPunto(pmediano);

                        borrarpunto.dismiss();
                    }
                });
                TextView bigBtnBorrar = (TextView)borrarpunto.findViewById(R.id.tgrande);
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
                final Dialog tamanopunto =  new Dialog(this);
                // Toast.makeText(getApplicationContext(), "Presiono trazo", Toast.LENGTH_LONG).show();
                tamanopunto.setTitle("Tamaño del punto: ");
                tamanopunto.setContentView(R.layout.tamano_punto);

                TextView smallBtn = (TextView)tamanopunto.findViewById(R.id.tpequeno);
                smallBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Lienzo.setBorrado(false);
                        Lienzo.setTamanoPunto(ppequeno);

                        tamanopunto.dismiss();

                    }
                });
                TextView mediumBtn = (TextView)tamanopunto.findViewById(R.id.tmediano);
                mediumBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Lienzo.setBorrado(false);
                        Lienzo.setTamanoPunto(pmediano);

                        tamanopunto.dismiss();
                    }
                });
                TextView bigBtn = (TextView)tamanopunto.findViewById(R.id.tgrande);
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
                String naudio= String.valueOf(current_audio);
                Toast.makeText(getApplicationContext(), naudio, Toast.LENGTH_LONG).show();

                Intent fin= new Intent(Inicio.this, InicioSesion.class);

                Inicio.this.startActivity(fin);
                Inicio.this.finish();
                break;

            case R.id.btnsiguiente:

                current=0;

                if(control<frases.length){
                    control++;
                    f = frases[control];
                    tvCuento.setText(f);
                    current=1;

                    if(current!=0){

                        switch (control) {
                            case 1:
                                mp.stop();
                                mp1.start();
                                while (mp1.isPlaying()) {
                                    btnsiguiente.setEnabled(false);
                                }
                                break;
                            case 2:
                                mp1.stop();
                                mp2.start();
                                while (mp2.isPlaying()) {
                                    btnsiguiente.setEnabled(false);
                                }
                                break;
                            case 3:
                                mp2.stop();
                                mp3.start();
                                while (mp3.isPlaying()) {
                                    btnsiguiente.setEnabled(false);
                                }
                                break;
                            case 4:
                                mp3.stop();
                                mp4.start();
                                while (mp4.isPlaying()) {
                                    btnsiguiente.setEnabled(false);
                                }
                                break;
                            case 5:
                                mp4.stop();
                                mp5.start();
                                while (mp5.isPlaying()) {
                                    btnsiguiente.setEnabled(false);
                                }
                                break;
                            case 6:
                                mp5.stop();
                                mp6.start();
                                while (mp6.isPlaying()) {
                                    btnsiguiente.setEnabled(false);
                                }
                                break;
                            case 7:
                                mp6.stop();
                                mp7.start();
                                while (mp7.isPlaying()) {
                                    btnsiguiente.setEnabled(false);
                                }
                                break;
                            case 8:
                                mp7.stop();
                                mp8.start();
                                while (mp8.isPlaying()) {
                                    btnsiguiente.setEnabled(false);
                                }
                                break;
                            case 9:
                                mp8.stop();
                                mp9.start();
                                while (mp9.isPlaying()) {
                                    btnsiguiente.setEnabled(false);
                                }
                                break;
                            case 10:
                                mp9.stop();
                                mp10.start();
                                while (mp10.isPlaying()) {
                                    btnsiguiente.setEnabled(false);
                                }
                                break;
                            case 11:
                                mp10.stop();
                                mp11.start();
                                while (mp11.isPlaying()) {
                                    btnsiguiente.setEnabled(false);
                                }
                                break;
                            case 12:
                                mp11.stop();
                                mp12.start();
                                while (mp12.isPlaying()) {
                                    btnsiguiente.setEnabled(false);
                                }
                                break;
                            case 13:
                                mp12.stop();
                                mp13.start();
                                while (mp13.isPlaying()) {
                                    btnsiguiente.setEnabled(false);
                                }
                                break;
                            case 14:
                                mp13.stop();
                                mp14.start();
                                Toast.makeText(getApplicationContext(), "La cuenta es " + control, Toast.LENGTH_LONG).show();

                                while (mp14.isPlaying()) {
                                    btnsiguiente.setEnabled(false);
                                }
                                break;
                            case 15:
                                mp14.stop();
                                mp15.start();
                                Toast.makeText(getApplicationContext(), "La cuenta es " + control, Toast.LENGTH_LONG).show();
                                while (mp15.isPlaying()) {
                                    btnsiguiente.setEnabled(false);
                                }
                                break;
                            case 16:
                                mp15.stop();
                                mp16.start();
                                Toast.makeText(getApplicationContext(), "La cuenta es " + control, Toast.LENGTH_LONG).show();
                                while (mp16.isPlaying()) {
                                    btnsiguiente.setEnabled(false);
                                }
                                break;
                            case 17:
                                mp16.stop();
                                mp17.start();
                                Toast.makeText(getApplicationContext(), "La cuenta es " + control, Toast.LENGTH_LONG).show();
                                while (mp17.isPlaying()) {
                                    btnsiguiente.setEnabled(false);
                                }
                                break;
                            case 18:
                                mp17.stop();
                                mp18.start();
                                Toast.makeText(getApplicationContext(), "La cuenta es " + control, Toast.LENGTH_LONG).show();
                                while (mp18.isPlaying()) {
                                    btnsiguiente.setEnabled(false);
                                }
                                break;
                            case 19:
                                mp18.stop();
                                mp19.start();
                                Toast.makeText(getApplicationContext(), "La cuenta es " + control, Toast.LENGTH_LONG).show();
                                while (mp19.isPlaying()) {
                                    btnsiguiente.setEnabled(false);
                                }
                                break;
                            case 20:
                                mp19.stop();
                                mp20.start();
                                Toast.makeText(getApplicationContext(), "La cuenta es " + control, Toast.LENGTH_LONG).show();
                                while (mp20.isPlaying()) {
                                    btnsiguiente.setEnabled(false);
                                }
                                break;
                            case 21:
                                mp20.stop();
                                mp21.start();
                                Toast.makeText(getApplicationContext(), "La cuenta es " + control, Toast.LENGTH_LONG).show();
                                while (mp21.isPlaying()) {
                                    btnsiguiente.setEnabled(false);
                                }
                                break;
                            case 22:
                                mp21.stop();
                                mp22.start();
                                Toast.makeText(getApplicationContext(), "La cuenta es " + control, Toast.LENGTH_LONG).show();
                                while (mp22.isPlaying()) {
                                    btnsiguiente.setEnabled(false);
                                }
                                break;
                        }
                        break;
                    }
                }
                else {

                    Toast.makeText(getApplicationContext(), "Se termino cuento", Toast.LENGTH_LONG).show();
                }

            case R.id.btnnegro:
                color = v.getTag().toString();
                lienzo.setColor(color);

                if(v!=currPaint) {

                    ImageButton imgView = (ImageButton) v;
                    imgView.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));
                    currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint));
                    currPaint = (ImageButton) v;
                }



                break;
            case R.id.btncafe:
                color = v.getTag().toString();
                lienzo.setColor(color);

                if(v!=currPaint) {

                ImageButton imgView = (ImageButton) v;
                imgView.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));
                currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint));
                currPaint = (ImageButton) v;
            }





                break;
            case R.id.btnnaranja:
                color = v.getTag().toString();
                lienzo.setColor(color);

                if(v!=currPaint) {

                    ImageButton imgView = (ImageButton) v;
                    imgView.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));
                    currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint));
                    currPaint = (ImageButton) v;
                }
                break;
            case R.id.btnrojo:
                color = v.getTag().toString();
                lienzo.setColor(color);

                if(v!=currPaint) {

                    ImageButton imgView = (ImageButton) v;
                    imgView.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));
                    currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint));
                    currPaint = (ImageButton) v;
                }
                break;
            case R.id.btnrosa:
                color = v.getTag().toString();
                lienzo.setColor(color);
                if(v!=currPaint) {

                    ImageButton imgView = (ImageButton) v;
                    imgView.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));
                    currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint));
                    currPaint = (ImageButton) v;
                }
                break;
            case R.id.btnmorado:
                color = v.getTag().toString();
                lienzo.setColor(color);
                if(v!=currPaint) {

                    ImageButton imgView = (ImageButton) v;
                    imgView.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));
                    currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint));
                    currPaint = (ImageButton) v;
                }
                break;
            case R.id.btnamarillo:
                color = v.getTag().toString();
                lienzo.setColor(color);
                if(v!=currPaint) {

                    ImageButton imgView = (ImageButton) v;
                    imgView.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));
                    currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint));
                    currPaint = (ImageButton) v;
                }
                break;
            case R.id.btnverde:
                color = v.getTag().toString();
                lienzo.setColor(color);
                if(v!=currPaint) {

                    ImageButton imgView = (ImageButton) v;
                    imgView.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));
                    currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint));
                    currPaint = (ImageButton) v;
                }
                break;
            case R.id.btnverdefuerte:
                color = v.getTag().toString();
                lienzo.setColor(color);
                if(v!=currPaint) {

                    ImageButton imgView = (ImageButton) v;
                    imgView.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));
                    currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint));
                    currPaint = (ImageButton) v;
                }
                break;
            case R.id.btnturquesa:
                color = v.getTag().toString();
                lienzo.setColor(color);
                if(v!=currPaint) {

                    ImageButton imgView = (ImageButton) v;
                    imgView.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));
                    currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint));
                    currPaint = (ImageButton) v;
                }
                break;
            case R.id.btnceleste:
                color = v.getTag().toString();
                lienzo.setColor(color);
                if(v!=currPaint) {

                    ImageButton imgView = (ImageButton) v;
                    imgView.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));
                    currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint));
                    currPaint = (ImageButton) v;
                }
                break;
            case R.id.btnazul:
                color = v.getTag().toString();
                lienzo.setColor(color);
                if(v!=currPaint) {

                    ImageButton imgView = (ImageButton) v;
                    imgView.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));
                    currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint));
                    currPaint = (ImageButton) v;
                }
                break;
            default:
                break;

        }
        btnsiguiente.setEnabled(true);
    }


}
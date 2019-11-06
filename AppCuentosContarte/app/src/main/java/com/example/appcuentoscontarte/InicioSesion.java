package com.example.appcuentoscontarte;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class InicioSesion extends AppCompatActivity implements View.OnClickListener {

    Button btnregistro,btningresar;
    DatabaseReference databaseReference;
    EditText EdtUsuario;
    String usuario,user,usingresado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        btnregistro = (Button) findViewById(R.id.btnregistro_sesion);
        btningresar = (Button) findViewById(R.id.btningreso_sesion);
        EdtUsuario = (EditText)findViewById(R.id.etUsuario);

        //Hace referencia al nodo principal de BD
        /* databaseReference = FirebaseDatabase.getInstance().getReference();


        databaseReference.child("Usuario").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    if(snapshot.exists()){
                        usuario = snapshot.getValue().toString();
                        //usuario = dataSnapshot.child("usuario").getValue().toString();
                        user = EdtUsuario.getText().toString();
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        }); */

    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnregistro_sesion:
                Toast.makeText(getApplicationContext(), "Se presiono registro", Toast.LENGTH_LONG).show();
                Intent comenzar = new Intent(InicioSesion.this, Registro.class);
                InicioSesion.this.startActivity(comenzar);
                break;
            case R.id.btningreso_sesion:

                databaseReference = FirebaseDatabase.getInstance().getReference();


                databaseReference.child("Usuario").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        usingresado = EdtUsuario.getText().toString();
                        for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                            if(snapshot.exists()){
                                user = snapshot.getValue().toString();
                                if(user==usingresado){
                                    user = usuario;
                                    Ingresar(user,usingresado);
                                }
                                //usuario = dataSnapshot.child("usuario").getValue().toString();

                            }
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                if(usuario==usingresado){
                    Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_LONG).show();
                    Intent iniciar = new Intent(InicioSesion.this, MainActivity.class);
                    InicioSesion.this.startActivity(iniciar);
                }
                else{
                    EdtUsuario.setText("El usuario no existe");
                }
                //Toast.makeText(getApplicationContext(), "Se presiono ingresar", Toast.LENGTH_LONG).show();
        }
    }

    private void Ingresar(String user, String usingresado) {
        Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_LONG).show();
        Intent iniciar = new Intent(InicioSesion.this, MainActivity.class);
        InicioSesion.this.startActivity(iniciar);
    }


}

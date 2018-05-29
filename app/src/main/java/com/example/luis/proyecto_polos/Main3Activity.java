package com.example.luis.proyecto_polos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    private ImageView imageViewR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        imageViewR = findViewById(R.id.imageViewR);
        String urlZ = "https://www.android.com/static/2016/img/home/holiday-hero/android-8-oreo_m.gif";
        Glide.with(this).load(urlZ).into(imageViewR);

        String JsonObjeto = utilidades.ObtenerJsonObjeto(getApplicationContext());
        Gson gson = new Gson();
        Persona objeto = gson.fromJson(JsonObjeto,Persona.class);

        Log.i("gson","ID" + objeto.getId());
        Log.i("gson","Nombre" + objeto.getNombre());
        Log.i("gson","Domicilio" + objeto.getDomicilio());

        String convertObjectToStritoString = gson.toJson(objeto);

        Log.i("gson",convertObjectToStritoString);


        List<Persona>listado = new ArrayList<Persona>();
        listado.add(new Persona(1,"luis","altotrujillo"));
        listado.add(new Persona(2,"Michel"," trujillo"));
        listado.add(new Persona(3,"sntos"," trujillo"));
        listado.add(new Persona(4,"deme"," porvenir"));
        listado.add(new Persona(5,"dante"," caminate"));

        String listaObjetos = gson.toJson(listado);

        Log.i("gson",listaObjetos);

        listado = gson.fromJson(listaObjetos,new TypeToken<List<Persona>>(){}.getType());

        for(Persona fila: listado){
            Log.i("gson","ID: "+fila.getId() + "Nombre :" + fila.getNombre() + "Domicilio: " + fila.getDomicilio());
        }



    }
}

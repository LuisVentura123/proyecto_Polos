package com.example.luis.proyecto_polos;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class utilidades {
   public static String ObtenerJsonObjeto(Context contexto) {
        InputStream resourceReader = contexto.getResources().openRawResource(R.raw.json_file);
        BufferedReader reader = null;
        String Retorno="";
        try{
            reader = new BufferedReader(new InputStreamReader(resourceReader,"UTF-8"));
            Retorno = reader.readLine();
        }catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return Retorno;
    }
}

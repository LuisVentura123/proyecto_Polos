package com.example.luis.proyecto_polos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.et_cantidad_polos) EditText  et_cantidad_polos;
    @BindView(R.id.et_nombre_empresa) EditText  et_nombre_empresa;
    @BindView(R.id.rb_tarjeta_Credito) RadioButton  rb_tarjeta_Credito;
    @BindView(R.id.rb_efectivo) RadioButton  rb_efectivo;
    @BindView(R.id.switch_servicion_transporte) Switch  switch_servicion_transporte;
    @BindView(R.id.check_fin_semana) CheckBox  check_fin_semana;
    @BindView(R.id.spinner_talla_polo) Spinner  spinner_talla_polo;
    @BindView(R.id.tv_resultado) TextView  tv_resultado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ButterKnife.bind(this);


        String []opciones = {"Talla L","Talla M","Talla S"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.spinner_item_opciones_personalizado,opciones);
        spinner_talla_polo.setAdapter(adapter);



    }


    public void calcularVR(View view){

        String cantidad_polos_String = et_cantidad_polos.getText().toString();
        String seleccion = spinner_talla_polo.getSelectedItem().toString();
        int cantidad_polos_int = Integer.parseInt(cantidad_polos_String);

        double valor_polo = 1;double valor_transporte=0;
        if(cantidad_polos_int > 200 && cantidad_polos_int <= 400 && switch_servicion_transporte.isChecked()==true){
               valor_polo = 10;
               valor_transporte = 20;
        } else  if(cantidad_polos_int > 400 && cantidad_polos_int <= 600 && switch_servicion_transporte.isChecked()==true){
            valor_polo = 8;
            valor_transporte = 30;
        } else  if(cantidad_polos_int > 600 && switch_servicion_transporte.isChecked()==true){
            valor_polo = 7;
            valor_transporte = 50;
        }
        else {
            valor_polo = 100;
            valor_transporte = 200;
        }

        if(seleccion.equals("Talla L")){
            valor_polo = valor_polo + 5;
        }else  if(seleccion.equals("Talla M")){
            valor_polo = valor_polo + 3;
        }else if(seleccion.equals("Talla S")){
            valor_polo = valor_polo + 2;
        }

        double total_pagar = 0;
        total_pagar = (valor_polo)*cantidad_polos_int + valor_transporte;

        double descuento = 0;

        if(total_pagar < 6500){
            descuento = total_pagar*0.03;
        }else if(total_pagar > 6500 && total_pagar < 8000){
            descuento = total_pagar*0.02;
        }else if(total_pagar > 8000){
            descuento = total_pagar*0.01;
        }

        double valor_real_pagar = total_pagar - descuento;

        int obsequio=0;
        if(rb_tarjeta_Credito.isChecked()==true && check_fin_semana.isChecked()==true){
            obsequio =  12;
        }else {
            obsequio =  24;
        }
        String valor_transporte_String = String.valueOf(valor_transporte);
        String valor_polo_String = String.valueOf(valor_polo);
        String total_pagar_string = String.valueOf(total_pagar);
        String descuento_String = String.valueOf(descuento);
        String valor_real_pagar_String = String.valueOf(valor_real_pagar);
        String obsequi_string = String.valueOf(obsequio);
        tv_resultado.setText("Precio sin descuentos:" + total_pagar_string + "\n" + "descuento : " + descuento_String + "\n" + "Nuevo Precio :"
        +valor_real_pagar_String + "\n" + "Obsequio: " +obsequi_string + " Polos" + "\n");

    /* + "valor del polo: " + valor_polo_String
                + "\n" + "valor del transporte: " + valor_transporte_String */

    }


    public void verImagenes(View view){
        Intent intento = new Intent(this,Main2Activity.class);
        startActivity(intento);
    }

    public void IrGson(View view){
        Intent intento = new Intent(this,Main3Activity.class);
        startActivity(intento);
    }

}

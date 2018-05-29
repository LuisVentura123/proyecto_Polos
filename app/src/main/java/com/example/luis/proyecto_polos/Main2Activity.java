package com.example.luis.proyecto_polos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class Main2Activity extends AppCompatActivity {
    private ImageView imageView1,imageView2,imageView3;
    private TextView tv_precio1,tv_precio2,tv_precio3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);



        tv_precio1 = findViewById(R.id.tv_precio1);
        tv_precio2 = findViewById(R.id.tv_precio2);
        tv_precio3 = findViewById(R.id.tv_precio3);




        String url1 = "https://http2.mlstatic.com/polos-peru-seleccion-futbol-mundial-2018-D_NQ_NP_985756-MPE26130805797_102017-F.jpg";
        Glide.with(this).load(url1).into(imageView1);
        tv_precio1.setText("200 Soles");


        String url2 = "http://poloscamiseros.net/wp-content/uploads/2018/03/Polos-Camisero-de-Peru-1.jpg";
        Glide.with(this).load(url2).into(imageView2);
        tv_precio2.setText("300 Soles");


        String url3 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSW62fA02NarBXfKWCuu4EpkTBPONgl8aBtobt63x1WgpE_Q4QC";
        Glide.with(this).load(url3).into(imageView3);
        tv_precio3.setText("150 Soles");

    }
    public void atras(View view){
        Intent intento = new Intent(this,MainActivity.class);
        startActivity(intento);
    }
}

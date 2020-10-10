package com.uyu.fundamentosandroid2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class confirmacion extends AppCompatActivity {

    public Button btnback;
    public TextView tvname;
    public String stn;
    public TextView tvfecha;
    public String stf;
    public TextView tvtel;
    public String stt;
    public TextView tvemail;
    public String ste;
    public TextView tvdesc;
    public String std;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        tvname = findViewById(R.id.tvnombre);
        tvfecha = findViewById(R.id.tvfecha);
        tvtel = findViewById(R.id.tvtelefono);
        tvemail = findViewById(R.id.tvemail);
        tvdesc = findViewById(R.id.tvdesc);

        stn = getIntent().getExtras().getString("Value");
        stf = getIntent().getExtras().getString("Value2");
        stt = getIntent().getExtras().getString("Value3");
        ste = getIntent().getExtras().getString("Value4");
        std = getIntent().getExtras().getString("Value5");
        tvname.setText(stn);
        tvfecha.setText(stf);
        tvtel.setText(stt);
        tvemail.setText(ste);
        tvdesc.setText(std);

        btnback = findViewById(R.id.BtnActivityTwo);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MoveToActivityOne();
            }
        });
    }

    private void MoveToActivityOne(){
        Intent intent = new Intent(confirmacion.this, MainActivity.class);
        intent.putExtra("Value",stn);
        intent.putExtra("Value2",stf);
        intent.putExtra("Value3",stt);
        intent.putExtra("Value4",ste);
        intent.putExtra("Value5",std);
        startActivity(intent);
    }

}
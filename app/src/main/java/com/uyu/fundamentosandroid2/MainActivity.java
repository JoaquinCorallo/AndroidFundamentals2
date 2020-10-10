package com.uyu.fundamentosandroid2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    public Button btnMove;
    public EditText etname;
    public String stname;
    public EditText ettel;
    public String sttel;
    public EditText etemail;
    public String stemail;
    public EditText etdesc;
    public String stdesc;
    public Button etfecha;
    public String stfecha;
    static EditText etfechavacia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null){
            stname = savedInstanceState.getString("stname");
            etname.setText(stname);
        }
        else {
        }

        btnMove = findViewById(R.id.BtnActivityOne);
        etname = findViewById(R.id.nombre);
        ettel = findViewById(R.id.telefono);
        etemail = findViewById(R.id.email);
        etdesc = findViewById(R.id.descripcion);
        etfecha = findViewById(R.id.fecha);
        etfechavacia = findViewById(R.id.fechavacia);


        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stname = etname.getText().toString();
                sttel = ettel.getText().toString();
                stemail = etemail.getText().toString();
                stdesc = etdesc.getText().toString();
                stfecha = etfechavacia.getText().toString();
                MoveToActivityTwo();
            }
        });
    }

    private void MoveToActivityTwo(){
        Intent intent = new Intent(MainActivity.this, confirmacion.class);
        intent.putExtra("Value",stname);
        intent.putExtra("Value2",stfecha);
        intent.putExtra("Value3",sttel);
        intent.putExtra("Value4",stemail);
        intent.putExtra("Value5",stdesc);
        startActivity(intent);
    }
    

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            final String selectedDate = day + " / " + (month+1) + " / " + year;
            etfechavacia.setText(selectedDate);
        }
    }
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("stname", stname);
        outState.putString("etname", String.valueOf(etname));
    }

    @Override
    protected void onRestoreInstanceState (Bundle savedInstanceState) {
        stname = savedInstanceState.getString("etname"); //on coming back retrieve all values using key
        etname.setText(stname);
    }

    @Override
    protected void onPause() {
        super.onPause();
        stname = etname.getText().toString();
    }

    @Override
    protected void onResume() {
        super.onResume();
        etname.setText(stname);
    }
}

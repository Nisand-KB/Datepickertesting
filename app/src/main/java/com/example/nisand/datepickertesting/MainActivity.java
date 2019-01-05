package com.example.nisand.datepickertesting;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import static android.view.View.Y;

public class MainActivity extends AppCompatActivity {
TextView tv;
Calendar calender;
int day,month,year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);
        calender = Calendar.getInstance();
        day = calender.get(Calendar.DAY_OF_MONTH);
        month = calender.get(Calendar.MONTH);
        year = calender.get(Calendar.YEAR);
        tv.setText(day+"/"+month+"/"+year);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog  = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                       if((year >= i ) && (month>=i1) && day>=i2 )
                        {
                            tv.setText(i2+"-"+(i1+1)+"-"+i);

                        }else {
                            Toast.makeText(MainActivity.this,"please give past date",Toast.LENGTH_LONG).show();
                        }

                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
    }
}

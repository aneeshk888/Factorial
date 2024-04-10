package com.example.factorial;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText number;
    TextView answer;
    Button calculate;
    AlertDialog.Builder builder;
   int factorial = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        calcFactorial();
        builder = new AlertDialog.Builder(this);
    }

    public void initialize() {
        number = (EditText) findViewById(R.id.et_no);
        answer = (TextView) findViewById(R.id.et_ans);
        calculate = (Button) findViewById(R.id.bt_cal);
        calculate.setOnClickListener(this);
    }

    public void calcFactorial() {
        if (number.getText().toString().equals("")) number.setText("0");
        int num = Integer.parseInt(number.getText().toString());
        for (int i = 1; i <= num; i++) {
            factorial = i * factorial;
        }
    }


    @Override
    public void onClick(View v) {
        calcFactorial();
        //Setting message manually and performing action on button click
        builder.setMessage("Factorial of " + number.getText().toString() + " is : " + factorial)
                .setCancelable(false)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle("FactorialAlertDialogExample");
        alert.show();


        answer.setText("Factorial of " + number.getText().toString() + " is : " + factorial);


    }
}
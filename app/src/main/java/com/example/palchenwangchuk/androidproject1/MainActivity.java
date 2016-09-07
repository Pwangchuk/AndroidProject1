package com.example.palchenwangchuk.androidproject1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get user interface elements
        final EditText number = (EditText)findViewById(R.id.number);
        final EditText radix = (EditText)findViewById(R.id.radix);
        final EditText base = (EditText)findViewById(R.id.new_base);
        final Button enter = (Button)findViewById(R.id.Enter);
        final TextView ans = (TextView) findViewById(R.id.answer);


        enter.setOnClickListener(new View.OnClickListener() {

                                     @Override
                                     public void onClick(View v) {

                                         String digitN = number.getText().toString();
                                         String digitR = radix.getText().toString();
                                         String digitB = base.getText().toString();

                                         if (digitN.isEmpty()) {
                                             Toast.makeText(MainActivity.this, "Please enter a number", Toast.LENGTH_SHORT).show();
                                         } else {
                                             if (digitR.isEmpty()) {
                                                 Toast.makeText(MainActivity.this, "Please enter a proper Radix", Toast.LENGTH_SHORT).show();
                                             } else {
                                                 if (digitB.isEmpty()) {
                                                     Toast.makeText(MainActivity.this, "Please enter a proper new base", Toast.LENGTH_SHORT).show();
                                                 }
                                             }
                                         }

                                         try {
                                             int numb = Integer.parseInt(digitN, Integer.parseInt(digitR));
                                             ans.setText(Integer.toString(numb, Integer.parseInt(digitB)));
                                             ans.setBackgroundColor(getColor(R.color.light_blue));

                                         } catch (NumberFormatException e) {
                                             Toast.makeText(MainActivity.this, "Invalid", Toast.LENGTH_SHORT).show();
                                             ans.setBackgroundColor(getColor(R.color.colorAccent));
                                             ans.setText("Invalid combination");
                                         }
                                     }
                                 }
        );
    }

}

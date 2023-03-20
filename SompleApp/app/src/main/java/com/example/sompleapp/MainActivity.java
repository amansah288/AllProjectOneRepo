package com.example.sompleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.DateIntervalFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView image_input;
    EditText name_input;
    EditText emails_input;
    EditText pass_input;
    Button btn_submit;
    TextView display_info;
    ImageView share_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emails_input = findViewById(R.id.emails_input);
        name_input = findViewById(R.id.name_input);
        pass_input = findViewById(R.id.name_input);
        btn_submit = findViewById(R.id.btn_submit);
        display_info = findViewById(R.id.display_info);
        share_btn = findViewById(R.id.share_btn);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emails_input.getText().toString();
                String name  = name_input.getText().toString();
                String password = pass_input.getText().toString();

                Log.d("FormData", "email - "+email+"name - "+name+"password - "+password);
                display_info.setText("Email - "+email+"\n"+"Name - "+name);
            }
        });

        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, display_info.getText().toString());
                startActivity(Intent.createChooser(sharingIntent,"Choose the application"));
            }
        });

    }
}
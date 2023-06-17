package com.example.fbloginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button SubmitHogya = findViewById(R.id.SubmitHogya);

        SubmitHogya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openacc();
            }
        });


    }

    public void openacc()
    {
        Intent intent = new Intent(RegisterActivity.this,SuPage.class);
        startActivity(intent);
    }
}
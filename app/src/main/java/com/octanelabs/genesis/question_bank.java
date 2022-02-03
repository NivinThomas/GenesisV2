package com.octanelabs.genesis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class question_bank extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_bank);

        ImageView sem1;

        sem1=findViewById(R.id.sem1_img);

        sem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(question_bank.this, "Semester One", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(question_bank.this, com.octanelabs.genesis.sem1.class));
            }
        });

    }
}
package com.octanelabs.genesis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageView questionbank;
        ImageView syllabus;
        ImageView books;
        ImageView records;
        ImageView notes;
        ImageView videos;


        questionbank=findViewById(R.id.qb_img);
        syllabus=findViewById(R.id.sy_img);
        books=findViewById(R.id.rb_img);
        records=findViewById(R.id.lr_img);
        notes=findViewById(R.id.notes_img);
        videos=findViewById(R.id.video_lib_img);


        //Going to QuestionBank Page
        questionbank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(home.this, "Question Bank", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(home.this,question_bank.class));
            }
        });
        //Going to Syllabus view
        syllabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(home.this, "Syllabus", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(home.this,syllabus.class));

            }
        });

    }
}
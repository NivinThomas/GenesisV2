package com.octanelabs.genesis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class syllabus extends AppCompatActivity {

    private TextView text1;
    private PDFView pdfView;
    private FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference mref=database.getReference("url");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);

        text1=(TextView) findViewById(R.id.sy_textview);
        pdfView=(PDFView) findViewById(R.id.pdf_view);

        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String value=snapshot.getValue(String.class);
                text1.setText(value);
                Toast.makeText(syllabus.this, "Database Updated", Toast.LENGTH_SHORT).show();
                String url=text1.getText().toString();
                new RetrivePdfStream().execute(url);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(syllabus.this, "Unable to load content!", Toast.LENGTH_SHORT).show();

            }
        });}
        class RetrivePdfStream extends AsyncTask<String,Void, InputStream>{

            @Override
            protected InputStream doInBackground(String... strings) {

                InputStream inputStream=null;
                try {
                    URL url=new URL(strings[0]);
                    HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                    if (httpURLConnection.getResponseCode()==200){
                        inputStream=new BufferedInputStream(httpURLConnection.getInputStream());
                    }
                }catch (IOException e){
                    return null;
                }
                return inputStream;
            }

            @Override
            protected void onPostExecute(InputStream inputStream) {
                pdfView.fromStream(inputStream).load();
            }
        }
    }

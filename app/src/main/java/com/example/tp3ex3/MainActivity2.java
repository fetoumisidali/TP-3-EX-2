package com.example.tp3ex3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView nom , prenom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        nom = findViewById(R.id.newNom);
        prenom = findViewById(R.id.newPrenom);


        Bundle bundle = getIntent().getExtras();
        String eNom = bundle.getString("nom");
        String ePrenom = bundle.getString("prenom");


        nom.setText(eNom);
        prenom.setText(ePrenom);
    }
}
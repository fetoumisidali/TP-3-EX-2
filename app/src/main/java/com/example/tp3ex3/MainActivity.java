package com.example.tp3ex3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button annulerButton, sauvgarderButton;
    TextView nom ,prenom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        annulerButton = findViewById(R.id.annulesButton);
        sauvgarderButton = findViewById(R.id.sauvgardesButton);


        annulerButton.setOnClickListener(this);
        sauvgarderButton.setOnClickListener(this);

        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == annulerButton.getId()){
            createDialog();
        }
        else if (view.getId() == sauvgarderButton.getId()){
            if (nom.getText().toString().equals("") && prenom.getText().toString().equals("")){
                Toast.makeText(MainActivity.this,"Entrez les information svp",Toast.LENGTH_LONG).show();
            }
            else if (nom.getText().toString().equals("")){
                Toast.makeText(MainActivity.this,"Entrez le nom Svp",Toast.LENGTH_LONG).show();
            }
            else if (prenom.getText().toString().equals("")) {
                Toast.makeText(MainActivity.this, "Entrez le prenom Svp", Toast.LENGTH_SHORT).show();
            }
            else {
                Intent intent = new Intent(this,MainActivity2.class);
                Bundle b = new Bundle();
                b.putString("nom",nom.getText().toString());
                b.putString("prenom",prenom.getText().toString());
                intent.putExtras(b);
                startActivity(intent);
            }

        }
    }

    private void createDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Annules ?").setMessage("Oui ou Non").setPositiveButton("Oui", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                System.exit(1);
            }
        }).setNegativeButton("Non", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).show();
    }
}
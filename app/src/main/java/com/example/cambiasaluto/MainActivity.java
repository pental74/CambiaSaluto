 package com.example.cambiasaluto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Attributo
    // SharedPreferences : Classe che contiene le preferenze dell'utente
    private SharedPreferences myPreferencies;
    private String stringaSaluto;

    // Oncreate - lavoro
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Activity", "onCreate");
        setContentView(R.layout.activity_main);

        // Associazione tasto grafico - codice java
        Button pulsante_cambia = findViewById(R.id.bCambiaSaluto);
        TextView saluto = findViewById(R.id.twSaluto);

        saluto.setText("Ciao Mondo");
        Log.d("set string su onCreate", saluto.getText().toString());



        // evento click
        pulsante_cambia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Casella di testo con saluto da modificare
                TextView saluto = findViewById(R.id.twSaluto);
                saluto.setText("Ciao Mondo");
                Log.d("set string on setClick", saluto.getText().toString());

            }
        });

        // Impostazione delle preferenze iniziali
        myPreferencies = getSharedPreferences("mantieni_scritta", MODE_PRIVATE);
        stringaSaluto = myPreferencies.getString("twSaluto", "Ciao Mondo");

        saluto.setText(stringaSaluto);
        Log.d("set string su onCreate", saluto.getText().toString());
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Activity","Restart");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Activity","Start");

    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Activity","Resume");

    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Activity","Pause");

        // In modalità edit: inserisco nelle mie preferenze il saluto modificato
        SharedPreferences.Editor ed = myPreferencies.edit();
        TextView saluto = findViewById(R.id.twSaluto);
        //Log.d("twSaluto", saluto.getText().toString() );
        ed.putString("twSaluto",saluto.getText().toString());
        Log.d("set string su onCreate", saluto.getText().toString());

        ed.commit(); // applico i cambiamenti alle mie SharedPreferences
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Activity","Stop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Activity","Destroy");
    }
}
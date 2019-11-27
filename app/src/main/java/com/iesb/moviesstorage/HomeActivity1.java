package com.iesb.moviesstorage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;


public class HomeActivity1 extends AppCompatActivity {
    private Button btnFilmes,btnFavoritos,btnMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        incializaComponentes();
        eventoClicks();



    }

    private void incializaComponentes() {

        btnFilmes = (Button) findViewById(R.id.btnfilmesid);
        btnFavoritos = (Button) findViewById(R.id.btnfavoritosid);
        btnMap = (Button) findViewById(R.id.btnmapaid);
    }
    private void eventoClicks() {
        btnFilmes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity1.this,ListaFilmesActivity.class);
                startActivity(i);
            }
        });
        btnFavoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity1.this,FavoritosActivity.class);
                startActivity(i);
            }
        });
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity1.this,MapsActivity.class);
                startActivity(i);
            }
        });
    }



}

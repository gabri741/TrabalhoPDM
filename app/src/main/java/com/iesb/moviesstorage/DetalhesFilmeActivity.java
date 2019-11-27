package com.iesb.moviesstorage;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class DetalhesFilmeActivity extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private DocumentReference movRef = db.document("Notebook/movie");
    private CollectionReference noteBookRef = db.collection("Notebook");
    private Button btnFavoritar ;


    public static final String EXTRA_FILME = "EXTRA_FILME";
    public static final String TAG = "Context_FAVORITE";
    int contador = 0 ;

    private static FirebaseAuth firebaseAuth;
    private static FirebaseAuth.AuthStateListener authStateListener;
    private static FirebaseUser firebaseUser;

    ConexaoFireBase conexaoFireBase = new ConexaoFireBase();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_filme);

        TextView textTituloFilme = findViewById(R.id.text_titulo_filme);
        btnFavoritar = (Button) findViewById(R.id.favoritarbtn);



        final Filme filme = (Filme) getIntent().getSerializableExtra(EXTRA_FILME);

        textTituloFilme.setText(filme.getOverview());
        eventoClicks();


    }

    private void eventoClicks() {

        btnFavoritar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNote(v);

            }

        });

    }

    public void addNote(View v){
        btnFavoritar = (Button) findViewById(R.id.favoritarbtn);

        firebaseUser = conexaoFireBase.getFirebaseUser();

        final Filme filme = (Filme) getIntent().getSerializableExtra(EXTRA_FILME);
        Note note = new Note(filme.getTitulo(),firebaseUser.getUid());


        noteBookRef.add(note);
        Toast.makeText(this, "Filme Adicionado ao Favoritos!", Toast.LENGTH_SHORT).show();

    }
}
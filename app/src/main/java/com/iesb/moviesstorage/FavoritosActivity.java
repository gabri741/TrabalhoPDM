package com.iesb.moviesstorage;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FavoritosActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private DocumentReference movRef = db.document("Notebook/movie");
    private CollectionReference noteBookRef = db.collection("Notebook");
   // private CollectionReference;
   public static final String KEY_TITLE = "filme";

    public static final String TAG = "FAVORITE_Activity";

    private Button btnLoad;
    private TextView textViewData;
    public List<String> dados = new ArrayList<String>();
    private static FirebaseUser firebaseUser;

    ConexaoFireBase conexaoFireBase = new ConexaoFireBase();







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);


    }

    public void loadNote(View v){

       final LinearLayoutManager manager = new LinearLayoutManager(this);
        dados.clear();
        firebaseUser = conexaoFireBase.getFirebaseUser();

        noteBookRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                String data = "";
                for(QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots){

                    Note note = documentSnapshot.toObject(Note.class);
                    if(note.getId().equals(firebaseUser.getUid())) {
                        String title = note.getTitle();
                        data += "Title: " + title + "\n\n";
                        dados.add(title);
                    }


                }
                recyclerView = (RecyclerView) findViewById(R.id.recycler_favoritos);
                recyclerView.setLayoutManager(manager);
                recyclerView.setHasFixedSize(true);
                FavoriteAdapter adapter = new FavoriteAdapter(dados);
                recyclerView.setAdapter(adapter);


            }
        });






    }
}



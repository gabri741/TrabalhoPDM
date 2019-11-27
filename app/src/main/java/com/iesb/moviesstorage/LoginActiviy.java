package com.iesb.moviesstorage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActiviy extends AppCompatActivity {

    private EditText editEmail,editSenha;
    private Button btnLogar, btnNovo;
    private FirebaseAuth auth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inicializaComponentes();
        eventoClicks();
    }

    private void eventoClicks() {
        btnNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),CadastroActivity.class);
                startActivity(i);

            }
        });

        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editEmail.getText().toString().trim();
                String senha = editSenha.getText().toString().trim();
                login(email,senha);
            }
        });
    }

    private void login(String email, String senha) {
        auth.signInWithEmailAndPassword(email,senha).addOnCompleteListener(LoginActiviy.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent i = new Intent(LoginActiviy.this,HomeActivity1.class);
                    startActivity(i);
                }else{
                    alert("E-mail ou Senha Incorretos");
                }
            }
        });

    }

    private void alert(String s) {
        Toast.makeText(LoginActiviy.this,s,Toast.LENGTH_SHORT).show();
    }

    private void inicializaComponentes(){

        editEmail = (EditText) findViewById(R.id.editLoginEmail);
        editSenha = (EditText) findViewById(R.id.editLoginSenha);
        btnLogar = (Button) findViewById(R.id.editLoginLogar);
        btnNovo = (Button) findViewById(R.id.editLoginNovo);

    }

    @Override
    protected void onStart() {
        super.onStart();
        auth = ConexaoFireBase.getFirebaseAuth();
    }
}

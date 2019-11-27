package com.iesb.moviesstorage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CadastroActivity extends AppCompatActivity {

    private EditText editEmail,editSenha;
    private Button btnRegistrar, btnVoltar;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        incializaComponentes();
        eventoClicks();

    }

    private void eventoClicks() {
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editEmail.getText().toString().trim();
                String senha = editSenha.getText().toString().trim();
                criarUsuario(email,senha);
            }
        });
    }

    private void criarUsuario(String email, String senha) {
        auth.createUserWithEmailAndPassword(email,senha).addOnCompleteListener(CadastroActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    alert("Usuário Cadastrado com Sucesso!");
                    Intent i = new Intent(CadastroActivity.this,HomeActivity1.class);
                    startActivity(i);
                    finish();
                }else{
                    alert("Erro de CadastroActivity");
                }
            }
        });
    }

    private void alert(String msg){
        Toast.makeText(CadastroActivity.this,msg,Toast.LENGTH_SHORT).show();
    }

    private void incializaComponentes() {
        editEmail = (EditText) findViewById(R.id.editCadastroEmail);
        editSenha = (EditText) findViewById(R.id.editCadastroSenha);
        btnRegistrar = (Button) findViewById(R.id.editCadastroRegistrar);
        btnVoltar = (Button) findViewById(R.id.editCadastroVoltar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth = ConexaoFireBase.getFirebaseAuth();
    }
}

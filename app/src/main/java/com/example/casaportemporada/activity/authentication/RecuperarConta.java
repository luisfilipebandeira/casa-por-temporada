package com.example.casaportemporada.activity.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.casaportemporada.R;
import com.example.casaportemporada.helper.FirebaseHelper;

public class RecuperarConta extends AppCompatActivity {

    private EditText edit_email;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_conta);

        iniciaComponentes();
        configCliques();
    }

    public void validaDados(View view) {
        String email = edit_email.getText().toString();

        if (!email.isEmpty()) {
            progressBar.setVisibility(View.VISIBLE);

            recuperSenha(email);

        } else {
            edit_email.requestFocus();
            edit_email.setError("Informe seu e-mail");
        }
    }

    private void recuperSenha(String email) {
        FirebaseHelper.getAuth().sendPasswordResetEmail(email)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(this, "E-mail enviado com sucesso", Toast.LENGTH_SHORT).show();
                    } else {
                        String error = task.getException().getMessage();
                        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
                    }
                        progressBar.setVisibility(View.GONE);
                });
    }

    private void configCliques() {
        findViewById(R.id.ib_voltar).setOnClickListener(view -> finish());
    }

    private void iniciaComponentes() {
        TextView textTitulo = findViewById(R.id.text_titulo);
        textTitulo.setText("Recupere sua conta");

        edit_email = findViewById(R.id.edit_email);
        progressBar = findViewById(R.id.progressBar);
    }
}
package com.example.casaportemporada.activity.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.casaportemporada.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.casaportemporada.R.layout.activity_login);

        configCliques();
    }

    private void configCliques() {
        findViewById(R.id.text_criar_conta).setOnClickListener(
            view -> startActivity(new Intent(this, CriarContaActivity.class))
        );

        findViewById(R.id.text_recuperar_conta).setOnClickListener(
            view -> startActivity(new Intent(this, RecuperarConta.class))
        );
    }
}
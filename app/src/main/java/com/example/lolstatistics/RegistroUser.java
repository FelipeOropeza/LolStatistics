package com.example.lolstatistics;

import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistroUser extends AppCompatActivity {

    private Button btnCad;
    private EditText editTextNome, editTextEmail, editTextSenha;
    private TextView txtresult, txtDados;
    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_user);

        editTextNome = findViewById(R.id.editTextNome);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextSenha = findViewById(R.id.editTextSenha);
        btnCad = findViewById(R.id.btnCad);
        txtresult = findViewById(R.id.txtresult);
        txtDados = findViewById(R.id.txtDados);

        btnCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                SharedPreferences.Editor editor = preferences.edit();

                if(editTextNome.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "preencher seu nome", Toast.LENGTH_LONG).show();
                }
                else if(editTextEmail.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "preencher seu email", Toast.LENGTH_LONG).show();
                }
                else if(editTextSenha.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "preencher sua senha", Toast.LENGTH_LONG).show();
                }
                else{
                    String nome = editTextNome.getText().toString();
                    String email = editTextEmail.getText().toString();
                    String senha = editTextSenha.getText().toString();
                    editor.putString("Nome", nome);
                    editor.putString("Email", email);
                    editor.putString("Senha", senha);
                    editor.commit();
                    txtDados.setText("Dados do cadastro:");
                    txtresult.setText("Login: " + nome + "\n" + "Email: " + email + "\n" + "Senha: " + senha);
                }
            }
        });

        SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);

        if(preferences.contains("Nome") && preferences.contains("Email") && preferences.contains("Senha")){
            String nome = preferences.getString("Nome", "Olá, nome do usuário não definido");
            String email = preferences.getString("Email", "Olá, email do usuário não definido");
            String senha = preferences.getString("Senha", "Olá, senha do usuário não definido");
            txtDados.setText("Dados do cadastro:");
            txtresult.setText("Login: " + nome + "\n" + "Email: " + email + "\n" + "Senha: " + senha);
        }
        else{
            txtresult.setText("Olá, usuário não definido");
        }
    }
}
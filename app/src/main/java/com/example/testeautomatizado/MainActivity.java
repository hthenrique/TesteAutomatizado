package com.example.testeautomatizado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUser;
    private EditText editTextPass;
    private TextView ErroEmail;
    private TextView ErroSenha;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextUser = findViewById(R.id.editTextUser);
        final EditText editTextPass = findViewById(R.id.editTextPass);
        final TextView ErroEmail = findViewById(R.id.ErroEmail);
        final TextView ErroSenha = findViewById(R.id.ErroSenha);
        Button btnOk = findViewById(R.id.btnOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextUser.getText().toString().equals("email@teste.com") && (editTextPass.getText().toString().equals("123"))){
                    Intent welcome = new Intent(getApplicationContext(), Main2Activity.class);
                    startActivity(welcome);
                }else if (!editTextUser.getText().toString().equals("email@teste.com")){
                    String erro1 = "E-mail incorreto ou vazio";
                    ErroEmail.setText(erro1);
                    Toast.makeText(MainActivity.this, "Verifique os campos", Toast.LENGTH_SHORT).show();
                }
                if (!editTextPass.getText().toString().equals("123")){
                    String erro2 = "Senha incorreta ou vazia";
                    ErroSenha.setText(erro2);
                }
            }
        });

    }

}

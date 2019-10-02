package com.example.testeautomatizado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

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
                //login permitidos
                if (editTextUser.getText().toString().equals("admin@admin") && (editTextPass.getText().toString().equals("administrador"))
                        || editTextUser.getText().toString().equals("hthenrique@email.com") && (editTextPass.getText().toString().equals("henrique"))){
                    if (editTextUser.getText().toString().equals("admin@admin")){
                        //Tela diferente para administradores
                        Intent welcomeAdmin = new Intent(getApplicationContext(), AdminActivity.class);
                        startActivity(welcomeAdmin);
                    }else {
                        //Tela usuario normal
                        Intent welcome = new Intent(getApplicationContext(), Main2Activity.class);
                        startActivity(welcome);
                    }
                }else
                    //usuario errado
                    if (!editTextUser.getText().toString().equals("admin@admin") || !editTextUser.getText().toString().equals("hthenrique@emaiil.com")){
                    String erro1 = "E-mail incorreto ou vazio";
                    ErroEmail.setText(erro1);
                    Toast.makeText(MainActivity.this, "Verifique os campos", Toast.LENGTH_SHORT).show();
                }
                    //senha errada
                if (!editTextPass.getText().toString().equals("administrador") && !editTextPass.getText().toString().equals("henrique")) {
                    String erro2 = "Senha incorreta";
                    ErroSenha.setText(erro2);
                    Toast.makeText(MainActivity.this, "Verifique os campos", Toast.LENGTH_SHORT).show();
                }
                    //Minimo de caracteres na senha
                if (editTextPass.getText().length() < 6){
                    editTextPass.setError(getString(R.string.senha_invalida));
                }
            }
        });

        InputFilter filter = new InputFilter(){
            //Caracteres perigosos proibidos
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                if (source.toString().contains("<" + ">" + "'" + "%" + "(" + ")" + "&" + "+"))
                    return "";
                else
                    return null;
            }
        };
        editTextPass.setFilters(new InputFilter[] {filter});
    }

}

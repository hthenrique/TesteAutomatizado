package com.example.testeautomatizado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
        getSupportActionBar().setHomeButtonEnabled(true);

        final EditText editTextUser = findViewById(R.id.editTextUser);
        final EditText editTextPass = findViewById(R.id.editTextPass);
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
                        Toast.makeText(MainActivity.this, "Conta de Administrador", Toast.LENGTH_SHORT).show();
                    }else {
                        //Tela usuario normal
                        Intent welcome = new Intent(getApplicationContext(), Main2Activity.class);
                        startActivity(welcome);
                    }
                }
                    //Senha errada
                if (editTextUser.getText().toString().equals("admin@admin") && !editTextPass.getText().toString().equals("administrador")
                        || editTextUser.getText().toString().equals("hthenrique@email.com") && !editTextPass.getText().toString().equals("henrique")){
                    String erro1 = "Usuário e/ou senha incorretos";
                    ErroSenha.setText(erro1);
                    Toast.makeText(MainActivity.this, "Verifique os campos", Toast.LENGTH_SHORT).show();
                }
                    //Usuário errado
                if (!editTextUser.getText().toString().equals("admin@admin") && editTextPass.getText().toString().equals("administrador")
                        || !editTextUser.getText().toString().equals("hthenrique@email.com") && editTextPass.getText().toString().equals("henrique")){
                    String erro3 = "Usuário e/ou senha incorretos";
                    ErroSenha.setText(erro3);
                    Toast.makeText(MainActivity.this, "Verifique os campos", Toast.LENGTH_SHORT).show();
                }
                if (!editTextUser.getText().toString().equals("admin@admin") && !editTextUser.getText().toString().equals("hthenrique@email.com")){
                    String erro1 = "Usuário e/ou senha incorretos";
                    ErroSenha.setText(erro1);
                    Toast.makeText(MainActivity.this, "Verifique os campos", Toast.LENGTH_SHORT).show();
                }
                    //Minimo de caracteres na senha
                if (editTextPass.getText().length() < 6){
                    editTextPass.setError(getString(R.string.senha_invalida));
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_user: {
                Intent welcome = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(welcome);
                return true;
            }
            case R.id.menu_adm:{
                Intent welcomeAdmin = new Intent(getApplicationContext(), AdminActivity.class);
                startActivity(welcomeAdmin);
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu, menu);
    }

}

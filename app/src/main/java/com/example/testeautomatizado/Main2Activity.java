package com.example.testeautomatizado;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;

public class Main2Activity extends AppCompatActivity {

    private WebView myWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        myWebview = (WebView) findViewById(R.id.webview);
        myWebview.getSettings().setJavaScriptEnabled(true);
        myWebview.getSettings().setAppCacheEnabled(true);
        myWebview.loadUrl("https://www.google.com");
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                Intent home = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(home);
                break;
                default:break;
        }
        return true;
    }
}

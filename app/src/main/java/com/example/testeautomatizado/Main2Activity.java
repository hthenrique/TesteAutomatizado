package com.example.testeautomatizado;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

import com.example.testeautomatizado.webview.WebviewClientImpl;

public class Main2Activity extends AppCompatActivity {

    private WebView myWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        //getSupportActionBar().hide();

        myWebview = findViewById(R.id.webview);
        WebviewClientImpl webviewClient = new WebviewClientImpl(this);
        myWebview.setWebViewClient(webviewClient);
        myWebview.getSettings().setJavaScriptEnabled(true);
        myWebview.getSettings().setAppCacheEnabled(true);
        myWebview.loadUrl("https://www.google.com");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebview.canGoBack()){
            myWebview.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.webview_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home: {
                Intent home = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(home);
                break;
            }
            case R.id.action_back:{
                myWebview.goBack();
                return true;
            }
            case R.id.action_forward:{
                myWebview.goForward();
                return true;
            }
            case R.id.action_refresh:{
                myWebview.reload();
                return true;
            }
                default:break;
        }
        return true;
    }

}

package com.example.testeautomatizado;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;

import com.example.testeautomatizado.webview.WebviewClientImpl;

public class OwaspActivity extends AppCompatActivity {

    private WebView myWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owasp);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        //getSupportActionBar().hide();

        myWebview = findViewById(R.id.owasp_webview);
        WebviewClientImpl webviewClient = new WebviewClientImpl(this);
        myWebview.setWebViewClient(webviewClient);
        myWebview.getSettings().setJavaScriptEnabled(true);
        String pdf = "https://www.owasp.org/images/b/b3/OWASP_SCP_v1.3_pt-BR.pdf";
        myWebview.loadUrl("https://docs.google.com/viewer?url=" + pdf);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home: {
                Intent home = new Intent(getApplicationContext(), AdminActivity.class);
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

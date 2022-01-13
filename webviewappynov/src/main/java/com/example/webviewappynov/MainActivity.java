package com.example.webviewappynov;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView wv = findViewById(R.id.webView);
        wv.loadUrl("https://framasoft.org");
        wv.getSettings().setJavaScriptEnabled(true);
    }
}
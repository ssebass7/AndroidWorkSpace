package com.example.map_google3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ActivityWikipedia extends AppCompatActivity {
WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wikipedia);
        Intent i = getIntent();
        String ciudad = i.getStringExtra("ciudad");
        String url = " https://en.wikipedia.org/wiki/" + ciudad;
        wv = findViewById(R.id.wv_wikipedia);
        wv.setWebViewClient(new WebViewClient());
        // Load the webpage
        wv.loadUrl(url);
    }
}
package com.example.bhomu.test4;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class TreeActivity extends AppCompatActivity {
    ProgressBar progressBar;
    WebView webViewtree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree);
        webViewtree=(WebView)findViewById(R.id.Wtree);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        webViewtree.setWebViewClient(new myWebClient());
        WebSettings webSettings=webViewtree.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //webViewtree.setInitialScale(40);
        webViewtree.getSettings().setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setSupportZoom(true);



        webViewtree.loadUrl("http://darklordbhomu.pe.hu/familytree.html");
    }

    public class myWebClient extends WebViewClient
    {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub
            progressBar.setVisibility(View.VISIBLE);
            view.loadUrl(url);
            return true;

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);

            progressBar.setVisibility(View.GONE);
        }
    }

    // To handle "Back" key press event for WebView to go back to previous screen.
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webViewtree.canGoBack()) {
            webViewtree.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

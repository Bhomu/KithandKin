package com.example.bhomu.test4;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;


public class NotificationsFragment extends Fragment {
    WebView webViewtree;
    ProgressBar progressBar;
    TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        textView = (TextView) view.findViewById(R.id.textView);
        textView.setVisibility(View.INVISIBLE);
        webViewtree = (WebView) view.findViewById(R.id.Wtree);
       // webViewtree.getSettings().setAppCacheEnabled(false);
      //  webViewtree.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar3);
        webViewtree.setWebViewClient(new WebViewClient());
        webViewtree.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                progressBar.setVisibility(View.VISIBLE);
                String str = Integer.toString(progress) + "%";
                textView.setText(str);
                textView.setVisibility(View.VISIBLE);
                progressBar.setProgress(progress);
                if (progress == 100) {
                    progressBar.setVisibility(View.GONE);
                    textView.setVisibility(View.INVISIBLE);
                    // Make the bar disappear after URL is loaded
                }
            }
        });

        progressBar.setVisibility(View.VISIBLE);
//        webViewtree.setWebViewClient(new WebViewClient(){
//            public void onPageFinished(WebView view, String url) {
//                if (progress != null)
//                    progress.dismiss();
//            }
//        });
        WebSettings webSettings = webViewtree.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webViewtree.getSettings().setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setSupportZoom(true);
        webViewtree.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    WebView webView = (WebView) v;

                    switch (keyCode) {
                        case KeyEvent.KEYCODE_BACK:
                            if (webView.canGoBack()) {
                                webView.goBack();
                                return true;
                            }
                            break;
                    }
                }

                return false;
            }
        });


        webViewtree.loadUrl("http://vishwakarma.pe.hu/generation2.html");
        return view;
    }

}
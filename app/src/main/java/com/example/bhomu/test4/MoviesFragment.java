package com.example.bhomu.test4;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
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

import static com.example.bhomu.test4.R.id.progressBar;
import static com.example.bhomu.test4.R.id.progressBar3;


public class MoviesFragment extends Fragment {
    WebView webViewtree;
    ProgressBar progressBar;
    private String currentURL;
    private ProgressDialog progress;
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
//      webViewtree.getSettings().setAppCacheEnabled(false);
//      webViewtree.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar3);
//        progress = ProgressDialog.show(getContext(), "Loading...",
//                "Please Wait...", true);
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
       // webViewtree.setInitialScale(50);
//        String str2 = webViewtree.getUrl().toString();
//     if (webViewtree.getUrl().toString()=="vishwakarma.pe.hu/familytree.html") {
//           webViewtree.setInitialScale(100);}
//        else{
//            webViewtree.setInitialScale(200  );
//        }

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


            webViewtree.loadUrl("http://vishwakarma.pe.hu/familytree2.html");
            return view;
        }
    }
    // TODO: Rename method, update argument and hook method into UI event


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

//    public class myWebClient extends WebViewClient
//    {
//        @Override
//        public void onPageStarted(WebView view, String url, Bitmap favicon) {
//            // TODO Auto-generated method stub
//            super.onPageStarted(view, url, favicon);
//        }
//
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            // TODO Auto-generated method stub
//            progressBar.setVisibility(View.VISIBLE);
//            view.loadUrl(url);
//            return true;
//
//        }
//
//        @Override
//        public void onPageFinished(WebView view, String url) {
//            // TODO Auto-generated method stub
//            super.onPageFinished(view, url);
//
//            progressBar.setVisibility(View.GONE);
//        }
//    }

    // To handle "Back" key press event for WebView to go back to previous screen.
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event)
//    {
//        if ((keyCode == KeyEvent.KEYCODE_BACK) && webViewtree.canGoBack()) {
//            webViewtree.goBack();
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }


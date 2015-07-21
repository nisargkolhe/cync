package com.clubcypher.cync;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

/**
 * Created by nisargkolhe on 7/9/15.
 */
public class DecFragment extends Fragment {

    public DecFragment(){

    }

    private WebView webView;
    ProgressBar pd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.webview, container, false);
        //setContentView(R.layout.webview);
        pd = (ProgressBar)rootView.findViewById(R.id.progressbar_Horizontal);

        webView = (WebView) rootView.findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);
        /*webView.setWebChromeClient(new ChromeClient());*/
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        webView.setWebChromeClient(new WebChromeClient() {

            // this will be called on page loading progress

            @Override

            public void onProgressChanged(WebView view, int newProgress) {

                super.onProgressChanged(view, newProgress);


                pd.setProgress(newProgress);
                //loadingTitle.setProgress(newProgress);
                // hide the progress bar if the loading is complete

                if (newProgress == 100) {
                    pd.setVisibility(View.GONE);

                } else{
                    pd.setVisibility(View.VISIBLE);

                }

            }

        });
        webView.loadUrl("http://cync.clubcypher.com/decypher/");
        return rootView;


    }
}

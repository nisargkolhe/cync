package com.clubcypher.cync;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by nisargkolhe on 7/9/15.
 */
public class RegisFragment extends Fragment {

    public RegisFragment(){

    }

    private WebView webView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.webview, container, false);
        //setContentView(R.layout.webview);

        webView = (WebView) rootView.findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://cync.clubcypher.com/");
        return rootView;
    }

}

package com.example.webview;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebViewClient extends WebViewClient {
    private final Activity activity;
    public MyWebViewClient(Activity activity){
        this.activity = activity;
    }
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if(url.indexOf("abelski.com") > -1 ) return false;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        activity.startActivity(intent);
        return true;
    }
}

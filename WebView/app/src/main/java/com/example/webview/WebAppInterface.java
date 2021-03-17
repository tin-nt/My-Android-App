package com.example.webview;

import android.content.Context;
import android.webkit.JavascriptInterface;

public class WebAppInterface {
    Context context;
    WebAppInterface(Context context){
        this.context = context;
    }
    @JavascriptInterface
    public int calculateSum(int num1, int num2){return num1 + num2;}
}

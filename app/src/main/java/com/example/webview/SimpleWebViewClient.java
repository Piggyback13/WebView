package com.example.webview;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SimpleWebViewClient extends WebViewClient {

    private Activity activity = null;

    public SimpleWebViewClient(Activity activity) {
        this.activity = activity;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView webView, String url) {
        if (url.contains("javadevblog.com")) {
            return false;
        }
        // все остальные ссылки будут спрашивать какой браузер открывать
        // механизм для описание одной операции (намерение)
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        activity.startActivity(intent);
        return true;
    }
}

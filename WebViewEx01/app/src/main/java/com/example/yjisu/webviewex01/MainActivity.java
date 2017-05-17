package com.example.yjisu.webviewex01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webView=(WebView)findViewById(R.id.webView);
        // html 만 해석 가능하고 js 는 해석하지 못함!!
        webView.getSettings().setJavaScriptEnabled(true);
       // webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());




      // webView.loadUrl("https://m.naver.com");
StringBuffer htmlData=new StringBuffer();
        htmlData.append("<html>");
        htmlData.append("<head>");
        htmlData.append("<script type='text/javascript'>");

        htmlData.append("alert('Hello javascript');");
        htmlData.append("</script>");
        htmlData.append("</head>");
        htmlData.append("<body>");
        htmlData.append("<h2>난 html!! </h2>");

        htmlData.append("</body>");

        htmlData.append("</html>");


        webView.loadData(htmlData.toString(),"text/html; charset=utf-8",null);

    }
}

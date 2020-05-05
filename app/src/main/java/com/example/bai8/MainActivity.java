package com.example.bai8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    private  EditText edt;
    private Button buttonGo;
    private Button buttonStatic;
    private Button btndelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonGo = (Button) findViewById(R.id.button_go);
        buttonStatic = (Button) findViewById(R.id.button_static);
        btndelete = (Button)findViewById(R.id.btn_delete) ;
        webView = (WebView) findViewById(R.id.webView);
        edt=(EditText)findViewById(R.id.edt);
        handle();
    }
    private void handle() {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.google.com/");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        buttonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              goURL();
            }
        });
        buttonStatic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showStaticContent();
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt.setText("");
            }
        });
    }
    private void goURL(){
        if (TextUtils.isEmpty(edt.getText().toString())) {
            Toast.makeText(MainActivity.this, "Bạn chưa nhập link, mời bạn nhập link!", Toast.LENGTH_SHORT).show();
        } else if (!edt.getText().toString().contains("http") || !edt.getText().toString().contains("https")) {
            Toast.makeText(MainActivity.this, "nhập sai link", Toast.LENGTH_SHORT).show();
        } else {
            webView.loadUrl(edt.getText().toString());
        }

    }
    private void showStaticContent(){
        webView.loadUrl("file:///android_asset/file_3.html");
    }

}

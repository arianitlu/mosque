package com.rrokullia.pluscomputers.mosque;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.TextView;


public class PanoramaActivity extends AppCompatActivity {

//    private GyroscopeObserver gyroscopeObserver;
    private WebView webview;
    private ImageButton backButton;
    private ImageButton back_button;
    private TextView toolbarTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panorama);

        back_button = findViewById(R.id.toolbar_back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        toolbarTxt = findViewById(R.id.tolbar_text_view);
        toolbarTxt.setText("Virtual Tour");

        webview = findViewById(R.id.panorama_image_view);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            w.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        Intent intent = getIntent();

        boolean vlera = intent.getBooleanExtra("kati_pare",true);

        if (vlera){
            webview.setWebViewClient(new WebViewClient());
            webview.getSettings().setJavaScriptEnabled(true);
            webview.getSettings().setDomStorageEnabled(true);
            webview.setOverScrollMode(webview.OVER_SCROLL_NEVER);
            webview.loadUrl("http://moschee-wil.ch/wp-content/3d/EG1.html");

        } else{
            webview.setWebViewClient(new WebViewClient());
            webview.getSettings().setJavaScriptEnabled(true);
            webview.getSettings().setDomStorageEnabled(true);
            webview.setOverScrollMode(webview.OVER_SCROLL_NEVER);
            webview.loadUrl("http://moschee-wil.ch/wp-content/3d2/Moschee.html");
        }




    }
}

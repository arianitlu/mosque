package com.rrokullia.pluscomputers.mosque;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ContactActivity extends AppCompatActivity {

    ImageButton buttonBack;
    ImageView imgFcb,imgInsta,imgYoutube;
    TextView textViewContact1,txtOpenEmail,txtOpenWeb;
    EditText edtName, edtEmail, edtMessage;
    Button btnSend;
    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            w.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        textViewContact1 = findViewById(R.id.textview_contact2);
        txtOpenEmail = findViewById(R.id.txt_open_email);
        txtOpenWeb = findViewById(R.id.txt_openWeb);

        imgFcb = findViewById(R.id.img_facebook);
        imgInsta = findViewById(R.id.img_instagram);
        imgYoutube = findViewById(R.id.img_youtube);

        buttonBack = findViewById(R.id.contact_button_back);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        webview = findViewById(R.id.livestream_web_view);

        webview.setWebViewClient(new WebViewClient());
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setDomStorageEnabled(true);
        webview.setOverScrollMode(webview.OVER_SCROLL_NEVER);
        webview.loadUrl("https://moschee-wil.ch/app-contact/");

//
//        edtName = findViewById(R.id.edt_name);
//        edtEmail = findViewById(R.id.edt_email);
//        edtMessage = findViewById(R.id.edt_message);
//        btnSend = findViewById(R.id.btn_send);
//
//        btnSend.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String name = "" + edtName.getText();
//                String email = "" + edtEmail.getText();
//                String message = "" + edtMessage.getText();
//
//                Intent emailIntent = new Intent(Intent.ACTION_SEND);
//
//                emailIntent.setData(Uri.parse("mailto:"));
//                emailIntent.setType("text/plain");
//                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
//                emailIntent.putExtra(Intent.EXTRA_SUBJECT, name);
//                emailIntent.putExtra(Intent.EXTRA_TEXT, message);
//                emailIntent.setType("message/rfc822");
//
//                try {
//                    startActivity(Intent.createChooser(emailIntent, "Dërgo email..."));
//                    finish();
//                } catch (android.content.ActivityNotFoundException ex) {
//                }
//            }
//        });
//
//        imgInsta.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Uri uri = Uri.parse("https://instagram.com/xhamiawil?utm_source=ig_profile_share&igshid=clo80keg0kle");
//
//                Intent i= new Intent(Intent.ACTION_VIEW,uri);
//
//                i.setPackage("com.instagram.android");
//
//                try {
//                    startActivity(i);
//                } catch (ActivityNotFoundException e) {
//
//                    startActivity(new Intent(Intent.ACTION_VIEW,
//                            Uri.parse("https://instagram.com/xhamiawil?utm_source=ig_profile_share&igshid=clo80keg0kle")));
//                }
//            }
//        });
//
//        imgFcb.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Uri uri = Uri.parse("https://www.facebook.com/XhamiaWil/");
//
//                Intent i= new Intent(Intent.ACTION_VIEW,uri);
//
//                i.setPackage("com.facebook.android");
//
//                try {
//                    startActivity(i);
//                } catch (ActivityNotFoundException e) {
//
//                    startActivity(new Intent(Intent.ACTION_VIEW,
//                            Uri.parse("https://www.facebook.com/XhamiaWil/")));
//                }
//            }
//        });
//
//        txtOpenEmail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                Uri data = Uri.parse("mailto:info@moschee-wil.ch?subject=" + " " + "&body=" + " ");
//                intent.setData(data);
//                startActivity(intent);
//            }
//        });
//
//        textViewContact1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String tel = "tel:+41 58 523 45 45";
//                onCall(tel);
//            }
//        });
//
//        txtOpenWeb.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Uri uri = Uri.parse("https://www.moschee-wil.ch");
//                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                startActivity(intent);
//            }
//        });
//
//
//        imgYoutube.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openWeb();
//            }
//        });
//
//
//    }
//
//
//    public void onCall(String tel) {
//        Intent callIntent = new Intent(Intent.ACTION_CALL);
//        callIntent.setData(Uri.parse(tel));
//
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this,
//                    new String[]{Manifest.permission.CALL_PHONE},
//                    10);
//            return;
//        }else {
//            try{
//                startActivity(callIntent);
//            }
//            catch (android.content.ActivityNotFoundException ex){
//                Toast.makeText(getApplicationContext(),"yourActivity is not founded",Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
//
//
//
//    public void openEmail() {
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        Uri data = Uri.parse("mailto:imam@moschee-wil.ch?subject=" + " " + "&body=" + " ");
//        intent.setData(data);
//        startActivity(intent);
//    }
//
//    public void openWeb() {
//        Uri uri = Uri.parse("https://www.youtube.com/user/XhamiaWil");
//        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//        startActivity(intent);
//    }
    }
}

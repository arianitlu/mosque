package com.rrokullia.pluscomputers.mosque;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ContactActivity extends AppCompatActivity {

    ImageButton buttonBack;
    ImageView imgFcb,imgInsta,imgYoutube;
    TextView textViewContact1,txtEmailContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        txtEmailContact = findViewById(R.id.textview_email_contact);
        textViewContact1 = findViewById(R.id.textview_contact);

        imgFcb = findViewById(R.id.img_facebook);
        imgInsta = findViewById(R.id.img_instagram);
        imgYoutube = findViewById(R.id.img_youtube);

        imgInsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse("https://instagram.com/xhamiawil?utm_source=ig_profile_share&igshid=clo80keg0kle");

                Intent i= new Intent(Intent.ACTION_VIEW,uri);

                i.setPackage("com.instagram.android");

                try {
                    startActivity(i);
                } catch (ActivityNotFoundException e) {

                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://instagram.com/xhamiawil?utm_source=ig_profile_share&igshid=clo80keg0kle")));
                }
            }
        });

        imgFcb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse("https://www.facebook.com/XhamiaWil/");

                Intent i= new Intent(Intent.ACTION_VIEW,uri);

                i.setPackage("com.facebook.android");

                try {
                    startActivity(i);
                } catch (ActivityNotFoundException e) {

                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.facebook.com/XhamiaWil/")));
                }
            }
        });

        textViewContact1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tel = "tel:+41 71 911 59 59";
                onCall(tel);
            }
        });

        buttonBack = findViewById(R.id.contact_button_back);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        txtEmailContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEmail();
            }
        });

        imgYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWeb();
            }
        });


    }


    public void onCall(String tel) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse(tel));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    10);
            return;
        }else {
            try{
                startActivity(callIntent);
            }
            catch (android.content.ActivityNotFoundException ex){
                Toast.makeText(getApplicationContext(),"yourActivity is not founded",Toast.LENGTH_SHORT).show();
            }
        }
    }



    public void openEmail() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri data = Uri.parse("mailto:bekimalimi@gmail.com?subject=" + " " + "&body=" + " ");
        intent.setData(data);
        startActivity(intent);
    }

    public void openWeb() {
        Uri uri = Uri.parse("https://www.youtube.com/user/XhamiaWil");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

}

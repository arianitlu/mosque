package com.example.pluscomputers.mosque;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ContactActivity extends AppCompatActivity {

    ImageButton buttonBack;
    ImageView contactNummer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        overridePendingTransition(0, 0);


        buttonBack = findViewById(R.id.contact_button_back);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        contactNummer = findViewById(R.id.contact_nummer);
        contactNummer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = "0900102010";
                Intent i=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:" + number));
                startActivity(i);
            }
        });

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}

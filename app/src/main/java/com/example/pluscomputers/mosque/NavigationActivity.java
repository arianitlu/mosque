package com.example.pluscomputers.mosque;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.pluscomputers.mosque.model.Lajmi;
import com.onesignal.OneSignal;

public class NavigationActivity extends AppCompatActivity {

    ImageButton btnAbout,btnNjoftimet, btnIslami, btnMeetings, btnPanorama,
    btnArkitektura, btnDonacionet, btnAnetaresia, btnKontakti;

    TextView txtCopyright;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        txtCopyright = findViewById(R.id.nav_copyright_text_view);

        txtCopyright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavigationActivity.this,CopyrightActivity.class);
                startActivity(intent);
            }
        });

        overridePendingTransition(0, 0);

        btnAbout = findViewById(R.id.nav_button_aboutUs);
        btnNjoftimet = findViewById(R.id.nav_button_njoftimet);
        btnIslami = findViewById(R.id.nav_button_islamiNeWil);
        btnMeetings = findViewById(R.id.nav_button_meetings);
        btnPanorama = findViewById(R.id.nav_button_panorama);
        btnArkitektura = findViewById(R.id.nav_button_arkitektura);
        btnDonacionet = findViewById(R.id.nav_button_donacionet);
        btnAnetaresia = findViewById(R.id.nav_button_anetaresia);
        btnKontakti = findViewById(R.id.nav_button_kontakti);

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavigationActivity.this,AboutActivity.class);
                startActivity(intent);
            }
        });
        btnNjoftimet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavigationActivity.this,NewsActivity.class);
                startActivity(intent);
            }
        });
        btnIslami.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavigationActivity.this,IslaminewilActivity.class);
                startActivity(intent);
            }
        });
        btnMeetings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavigationActivity.this,MeetingsActivity.class);
                startActivity(intent);
            }
        });
        btnPanorama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavigationActivity.this,PanoramaHome.class);
                startActivity(intent);
            }
        });
        btnArkitektura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavigationActivity.this,ArchitectureActivity.class);
                startActivity(intent);
            }
        });
        btnDonacionet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavigationActivity.this,DonacionetActivity.class);
                startActivity(intent);
            }
        });
        btnAnetaresia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavigationActivity.this,AnetaresiaActivity.class);
                startActivity(intent);
            }
        });
        btnKontakti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavigationActivity.this,ContactActivity.class);
                startActivity(intent);
            }
        });

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}

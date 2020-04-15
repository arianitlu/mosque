package com.rrokullia.pluscomputers.mosque;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

public class NavigationActivity extends AppCompatActivity {

    ImageButton btnAbout,btnNjoftimet, btnIslami, btnDonacionet, btnAnetaresia, btnKontakti, btnLiveStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            w.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        btnAbout = findViewById(R.id.nav_button_aboutUs); // news
        btnNjoftimet = findViewById(R.id.nav_button_njoftimet); // virtual tour
        btnIslami = findViewById(R.id.nav_button_islamiNeWil); // calendar
        btnDonacionet = findViewById(R.id.nav_button_donacionet);
        btnAnetaresia = findViewById(R.id.nav_button_anetaresia);
        btnKontakti = findViewById(R.id.nav_button_kontakti);

        btnLiveStream = findViewById(R.id.nav_button_meetings);

        btnLiveStream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavigationActivity.this,LiveStreamActivity.class);
                startActivity(intent);
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavigationActivity.this,NewsActivity.class);
                startActivity(intent);
            }
        });
        btnNjoftimet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavigationActivity.this,PanoramaHome.class);
                startActivity(intent);
            }
        });
        btnIslami.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavigationActivity.this,MeetingsActivity.class);
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


    }
}

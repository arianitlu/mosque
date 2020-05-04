package com.rrokullia.pluscomputers.mosque;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class TakvimiSettingsActivity extends AppCompatActivity {

    private ImageButton back_button;
    private ImageView imgAlb, imgDe;
    private TextView txt_12hour, txt_24hour;
    private TextView txt_alb, txt_de;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_takvimi);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            w.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        bindViews();

        SharedPreferences pref = getApplicationContext().getSharedPreferences("info", 0);
        final SharedPreferences.Editor editor = pref.edit();

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TakvimiSettingsActivity.this, TakvimiActivity.class);
                startActivity(intent);
            }
        });


        if (pref.getString("language", "SQ").equals("DE")) {
            imgAlb.setAlpha(0.5f);
            txt_alb.setAlpha(0.5f);
        } else {
            imgDe.setAlpha(0.5f);
            txt_de.setAlpha(0.5f);
        }

        if (pref.getString("hour", "12").equals("24")) {
            txt_12hour.setAlpha(0.5f);
        } else {
            txt_24hour.setAlpha(0.5f);
        }


        imgAlb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imgAlb.setAlpha(1f);
                txt_alb.setAlpha(1f);

                imgDe.setAlpha(0.5f);
                txt_de.setAlpha(0.5f);

                editor.putString("language", "AL");
                editor.commit();
            }
        });

        imgDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imgDe.setAlpha(1f);
                txt_de.setAlpha(1f);

                imgAlb.setAlpha(0.5f);
                txt_alb.setAlpha(0.5f);

                editor.putString("language", "DE");
                editor.commit();
            }
        });

        txt_12hour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_12hour.setAlpha(1f);
                txt_24hour.setAlpha(0.5f);
                editor.putString("hour", "12");
                editor.commit();
            }
        });

        txt_24hour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_24hour.setAlpha(1f);
                txt_12hour.setAlpha(0.5f);
                editor.putString("hour", "24");
                editor.commit();
            }
        });

    }

    public void bindViews() {
        back_button = findViewById(R.id.donacionet_button_back);
        imgAlb = findViewById(R.id.img_alb);
        imgDe = findViewById(R.id.imageView4);
        txt_alb = findViewById(R.id.txt_alb);
        txt_de = findViewById(R.id.textView22);
        txt_12hour = findViewById(R.id.textView23);
        txt_24hour = findViewById(R.id.txt_hour);
    }

}

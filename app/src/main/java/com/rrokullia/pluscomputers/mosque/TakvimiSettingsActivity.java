package com.rrokullia.pluscomputers.mosque;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class TakvimiSettingsActivity extends AppCompatActivity {

    private ImageButton back_button;
    private ImageView imgAlb, imgDe;
    private ImageView imgSwitch;
    private TextView txt_hour;
    private TextView txt_alb, txt_de;
    private ImageView ic_plus, ic_minus;
    private TextView txtMinutes;
    int i = 15;

    boolean clickedAlb = true, clickedDe = true, clickedSwitch = true, hourClicked = true;

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
                Intent intent = new Intent(TakvimiSettingsActivity.this,TakvimiActivity.class);
                startActivity(intent);
            }
        });

        if (pref.getString("language", "SQ").equals("DE")) {
            imgAlb.setImageDrawable(getResources().getDrawable(R.drawable.flag_de));
            clickedAlb = false;
        }

        if (pref.getString("hour", "12").equals("24")) {
            txt_hour.setText("24");
            hourClicked = false;
        }



            imgAlb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickedAlb) {
                    imgAlb.setImageDrawable(getResources().getDrawable(R.drawable.flag_de));
                    txt_alb.setText("DE");
                    editor.putString("language", "DE");
                    editor.commit();
                } else {
                    imgAlb.setImageDrawable(getResources().getDrawable(R.drawable.flag_alb));
                    txt_alb.setText("AL");
                    editor.putString("language", "SQ");
                    editor.commit();
                }
                clickedAlb = !clickedAlb;
            }
        });

        imgSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickedSwitch) {
                    imgSwitch.setImageDrawable(getResources().getDrawable(R.drawable.ic_switch_off));
                } else {
                    imgSwitch.setImageDrawable(getResources().getDrawable(R.drawable.ic_switch_on));
                }
                clickedSwitch = !clickedSwitch;
            }
        });

        txt_hour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hourClicked) {
                    txt_hour.setText("24");
                    editor.putString("hour", "24");
                    editor.commit();
                } else {
                    txt_hour.setText("12");
                    editor.putString("hour", "12");
                    editor.commit();
                }
                hourClicked = !hourClicked;
            }
        });

        ic_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                txtMinutes.setText(String.valueOf(i));
            }
        });

        ic_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i!=0){
                    i--;
                }
                txtMinutes.setText(String.valueOf(i));
            }
        });

    }

    public void bindViews(){
        back_button = findViewById(R.id.donacionet_button_back);
        imgAlb = findViewById(R.id.img_alb);
        txt_alb = findViewById(R.id.txt_alb);
        imgSwitch = findViewById(R.id.img_switch);
        txt_hour = findViewById(R.id.txt_hour);
        ic_plus = findViewById(R.id.img_plus);
        ic_minus = findViewById(R.id.img_minus);
        txtMinutes = findViewById(R.id.txtMinutes);
    }

}

package com.rrokullia.pluscomputers.mosque;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.rrokullia.pluscomputers.mosque.model.takvimi.Welcome;
import com.rrokullia.pluscomputers.mosque.utilities.Helper;

public class MeetingsActivity extends AppCompatActivity {


    private ImageButton back_button;
    private ImageView icSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meetings);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            w.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        back_button = findViewById(R.id.donacionet_button_back);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        icSettings = findViewById(R.id.ic_settings);

    }
}

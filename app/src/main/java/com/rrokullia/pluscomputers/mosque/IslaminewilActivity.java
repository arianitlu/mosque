package com.rrokullia.pluscomputers.mosque;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

public class IslaminewilActivity extends AppCompatActivity {

    private ImageButton buttonBack;
    private TextView toolbarTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_islaminewil);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            w.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        buttonBack = findViewById(R.id.toolbar_back_button);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        toolbarTxt = findViewById(R.id.tolbar_text_view);
        toolbarTxt.setText("Islam in Wil");


    }
}

package com.example.pluscomputers.mosque;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

        buttonBack = findViewById(R.id.toolbar_back_button);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        toolbarTxt = findViewById(R.id.tolbar_text_view);
        toolbarTxt.setText("Islam in Wil");

        overridePendingTransition(0, 0);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}

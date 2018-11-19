package com.example.pluscomputers.mosque;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.pluscomputers.mosque.adapters.MyCustomPagerAdapter;
import com.github.barteksc.pdfviewer.PDFView;

public class ArchitectureActivity extends AppCompatActivity {

    private ImageButton buttonBack;
    private ViewPager viewPager;
    private TextView toolbarTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_architecture);

        buttonBack = findViewById(R.id.toolbar_back_button);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        toolbarTxt = findViewById(R.id.tolbar_text_view);
        toolbarTxt.setText("Architektur");

        overridePendingTransition(0, 0);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        int images[] = {R.drawable.slide_1, R.drawable.slide_2,
                R.drawable.slide_3,R.drawable.slide_4,R.drawable.slide_5,R.drawable.slide_6};

        MyCustomPagerAdapter myCustomPagerAdapter;
            viewPager = findViewById(R.id.image_view_islami_background);

            myCustomPagerAdapter = new MyCustomPagerAdapter(ArchitectureActivity.this, images);
            viewPager.setAdapter(myCustomPagerAdapter);
    }
}

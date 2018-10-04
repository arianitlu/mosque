package com.example.pluscomputers.mosque;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.example.pluscomputers.mosque.adapters.MyCustomPagerAdapter;
import com.github.barteksc.pdfviewer.PDFView;

public class ArchitectureActivity extends AppCompatActivity {

    private ImageButton buttonBack;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_architecture);

        overridePendingTransition(0, 0);


        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        buttonBack = findViewById(R.id.architecture_back_button);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        int images[] = {R.drawable.about_background, R.drawable.don_background,
                R.drawable.islami_background};
        MyCustomPagerAdapter myCustomPagerAdapter;
            viewPager = (ViewPager)findViewById(R.id.image_view_islami_background);

            myCustomPagerAdapter = new MyCustomPagerAdapter(ArchitectureActivity.this, images);
            viewPager.setAdapter(myCustomPagerAdapter);
    }
}

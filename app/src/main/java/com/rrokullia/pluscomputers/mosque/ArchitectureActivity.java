package com.rrokullia.pluscomputers.mosque;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rrokullia.pluscomputers.mosque.adapters.MyCustomPagerAdapter;

public class ArchitectureActivity extends AppCompatActivity {

    private ImageButton buttonBack;
    private ViewPager viewPager;
    private TextView toolbarTxt;

    private LinearLayout dots_layout;
    private ImageView[] dots;
    private int[] layouts = {R.drawable.slide_1, R.drawable.slide_2, R.drawable.slide_3,
            R.drawable.slide_4,R.drawable.slide_6};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_architecture);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        buttonBack = findViewById(R.id.toolbar_back_button);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        toolbarTxt = findViewById(R.id.tolbar_text_view);
        toolbarTxt.setText("Architektur");

        TextView textView = findViewById(R.id.text_view);

        textView.setMovementMethod(new ScrollingMovementMethod());



        int images[] = {R.drawable.slide_1, R.drawable.slide_2,
                R.drawable.slide_3,R.drawable.slide_4,R.drawable.slide_5,R.drawable.slide_6};

        MyCustomPagerAdapter myCustomPagerAdapter;
            viewPager = findViewById(R.id.image_view_islami_background);

            myCustomPagerAdapter = new MyCustomPagerAdapter(ArchitectureActivity.this, images);
            viewPager.setAdapter(myCustomPagerAdapter);

        dots_layout = findViewById(R.id.dotsLayout);

        createDots(0);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                createDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void createDots(int current_position){

        if (dots_layout != null)
            dots_layout.removeAllViews();

        dots = new ImageView[layouts.length];

        for (int i=0 ; i<layouts.length ; i++){
            dots[i] = new ImageView(this);

            if (i==current_position){
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.active_dots_arch));
            }
            else{
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.default_dots_arch));
            }

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(4,0,10,0);

            dots_layout.addView(dots[i],params);
        }

    }
}

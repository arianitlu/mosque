package com.rrokullia.pluscomputers.mosque;

import android.app.FragmentTransaction;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rrokullia.pluscomputers.mosque.adapters.SectionsPagerAdapter;
import com.rrokullia.pluscomputers.mosque.fragments.Fragment1;

public class AnetaresiaActivity extends AppCompatActivity {

    private ImageButton back_button;
    private TextView toolbarTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anetaresia);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            w.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new Fragment1())
                .commit();

        back_button = findViewById(R.id.toolbar_back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        toolbarTxt = findViewById(R.id.tolbar_text_view);
        toolbarTxt.setText("Vorstand");


//        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
//
//        mViewPager = findViewById(R.id.container);
//
//        mViewPager.setAdapter(mSectionsPagerAdapter);

        //dots_layout = findViewById(R.id.dotsLayout);

        //createDots(0);

//        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                createDots(position);
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });

    }

//    private void createDots(int current_position){
//
//        if (dots_layout != null)
//            dots_layout.removeAllViews();
//
//        dots = new ImageView[layouts.length];
//
//        for (int i=0 ; i<layouts.length ; i++){
//            dots[i] = new ImageView(this);
//
//            if (i==current_position){
//                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.active_dots));
//            }
//            else{
//                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.default_dots));
//            }
//
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
//                    ViewGroup.LayoutParams.WRAP_CONTENT);
//            params.setMargins(4,0,10,0);
//
//            dots_layout.addView(dots[i],params);
//        }
//
//    }
}

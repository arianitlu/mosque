package com.rrokullia.pluscomputers.mosque;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class SinglenewsActivity extends AppCompatActivity {

    TextView txtTitle,txtCategory,txtDescription;
    ImageView imgImage,imgColor;
    ImageButton back_button;
    TextView toolbarTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singlenews);

        back_button = findViewById(R.id.toolbar_back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        toolbarTxt = findViewById(R.id.tolbar_text_view);
        toolbarTxt.setText("Single News");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        txtTitle = findViewById(R.id.single_news_text_view_titulli);

        txtDescription = findViewById(R.id.single_news_text_view_description);

        imgImage = findViewById(R.id.single_news_image_main);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            String title = extras.getString("title");
            String describtion = extras.getString("description");

            String image = extras.getString("image");

            txtTitle.setText(title);
            txtDescription.setText(Html.fromHtml(describtion));

            Picasso.get()
                    .load(image)
                    .into(imgImage);
        }
    }
}

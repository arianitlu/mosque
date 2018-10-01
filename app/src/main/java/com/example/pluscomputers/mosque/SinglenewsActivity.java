package com.example.pluscomputers.mosque;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class SinglenewsActivity extends AppCompatActivity {

    TextView txtTitle,txtCategory,txtDescription;
    ImageView imgImage,imgColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singlenews);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        txtTitle = findViewById(R.id.single_news_text_view_titulli);
        txtCategory = findViewById(R.id.single_news_text_view_kategoria);
        txtDescription = findViewById(R.id.single_news_text_view_description);

        imgImage = findViewById(R.id.single_news_image_main);
        imgColor = findViewById(R.id.single_news_image_small);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            String title = extras.getString("title");
            String category = extras.getString("category");
            String describtion = extras.getString("description");

            int image = extras.getInt("image");
            int color = extras.getInt("color");

            txtTitle.setText(title);
            txtCategory.setText(category);
            txtDescription.setText(Html.fromHtml(describtion));

            imgImage.setImageResource(image);
            imgColor.setImageResource(color);
        }
    }
}

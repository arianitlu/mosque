package com.example.pluscomputers.mosque;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

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

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        overridePendingTransition(0, 0);


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

            String image = extras.getString("image");
            int color = extras.getInt("color");

            txtTitle.setText(title);
            txtCategory.setText(category);
            txtDescription.setText(Html.fromHtml(describtion));

            //imgImage.setImageResource(image);
            Picasso.get()
                    .load(image)
                    //.placeholder(R.drawable.news_photo1)
                    //.error(R.drawable.news_photo1)
                    .into(imgImage);
            imgColor.setImageResource(color);
        }
    }
}

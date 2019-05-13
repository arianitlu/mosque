package com.rrokullia.pluscomputers.mosque;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

public class CopyrightActivity extends AppCompatActivity {

    ImageButton back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_copyright);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            w.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        back_button = findViewById(R.id.copyright_button_back);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    public void openEmail(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri data = Uri.parse("mailto:rrokullia@gmail.com?subject=" + " " + "&body=" + " ");
        intent.setData(data);
        startActivity(intent);
    }

    public void openWeb(View view) {
        Uri uri = Uri.parse("http://rrokullia.link/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void openTel2(View view) {

        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:+381621641499"));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    10);
            return;
        }else {
            try{
                startActivity(callIntent);
            }
            catch (android.content.ActivityNotFoundException ex){
                Toast.makeText(getApplicationContext(),"yourActivity is not founded",Toast.LENGTH_SHORT).show();
            }
        }
    }
}

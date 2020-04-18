package com.rrokullia.pluscomputers.mosque;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.rrokullia.pluscomputers.mosque.model.takvimi.Welcome;
import com.rrokullia.pluscomputers.mosque.utilities.Helper;

public class LoginActivity extends AppCompatActivity {

    private ImageButton btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            w.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        btnLogin = findViewById(R.id.login_button);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,NavigationActivity.class);
                startActivity(intent);
            }
        });

        Welcome welcome = Helper.getNamazFromJson(getApplicationContext());

        Log.d("welcome",welcome.toString());

    }
}

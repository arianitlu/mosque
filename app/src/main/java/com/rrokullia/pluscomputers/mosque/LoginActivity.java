package com.rrokullia.pluscomputers.mosque;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;


import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import com.rrokullia.pluscomputers.mosque.workManager.NotifyWorker;

public class LoginActivity extends AppCompatActivity {

    private ImageButton btnLogin;

    WorkManager mWorkManager;
    OneTimeWorkRequest mRequest;


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

        mWorkManager = WorkManager.getInstance(this);
        mRequest = new OneTimeWorkRequest.Builder(NotifyWorker.class).build();

//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mWorkManager.enqueue(mRequest);
//            }
//        });



    }
}

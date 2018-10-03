package com.example.pluscomputers.mosque;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.pluscomputers.mosque.adapters.AnetaresiaAdapter;
import com.example.pluscomputers.mosque.model.Anetaresia;

import java.util.ArrayList;
import java.util.List;

public class MeetingsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Anetaresia> meetingsList = new ArrayList<>();
    private ImageButton back_button;
    private TextView toolbarTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meetings);

        back_button = findViewById(R.id.toolbar_back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        toolbarTxt = findViewById(R.id.tolbar_text_view);
        toolbarTxt.setText("Meetings");

        overridePendingTransition(0, 0);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        recyclerView = findViewById(R.id.meetings_recyclerview);

        AnetaresiaAdapter adapter = new AnetaresiaAdapter(this);

        adapter.setAnetaresia(listMeetings());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }

    public List<Anetaresia> listMeetings() {

        Anetaresia obj1 = new Anetaresia("Monday","12:30",R.mipmap.mosque);
        meetingsList.add(obj1);
        Anetaresia obj2 = new Anetaresia("Tuesday","14:30",R.mipmap.mosque);
        meetingsList.add(obj2);
        Anetaresia obj3 = new Anetaresia("Thursday","10:30",R.mipmap.mosque);
        meetingsList.add(obj3);
        Anetaresia obj4 = new Anetaresia("Saturday","9:30",R.mipmap.mosque);
        meetingsList.add(obj4);

        return meetingsList;
    }
}

package com.example.pluscomputers.mosque;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;

import com.example.pluscomputers.mosque.adapters.AnetaresiaAdapter;
import com.example.pluscomputers.mosque.model.Anetaresia;

import java.util.ArrayList;
import java.util.List;

public class MeetingsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Anetaresia> meetingsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meetings);

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

        Anetaresia obj1 = new Anetaresia("E Hene","12:30",R.mipmap.mosque);
        meetingsList.add(obj1);
        Anetaresia obj2 = new Anetaresia("E Merkure","14:30",R.mipmap.mosque);
        meetingsList.add(obj2);
        Anetaresia obj3 = new Anetaresia("E Enjte","10:30",R.mipmap.mosque);
        meetingsList.add(obj3);
        Anetaresia obj4 = new Anetaresia("E Shtune","9:30",R.mipmap.mosque);
        meetingsList.add(obj4);

        return meetingsList;
    }
}

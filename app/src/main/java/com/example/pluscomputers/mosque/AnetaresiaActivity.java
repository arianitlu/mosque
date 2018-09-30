package com.example.pluscomputers.mosque;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.pluscomputers.mosque.adapters.AnetaresiaAdapter;
import com.example.pluscomputers.mosque.model.Anetaresia;

import java.util.ArrayList;
import java.util.List;

public class AnetaresiaActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Anetaresia> anetaresiaList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anetaresia);

        recyclerView = findViewById(R.id.ant_recyclerview);

        AnetaresiaAdapter adapter = new AnetaresiaAdapter(this);

        adapter.setAnetaresia(listAnetaresia());


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }

    public List<Anetaresia> listAnetaresia() {

        Anetaresia obj1 = new Anetaresia("Arianit","Lubishtani",R.mipmap.mosque);
        anetaresiaList.add(obj1);
        Anetaresia obj2 = new Anetaresia("Xhemajl","Prekorogja",R.mipmap.mosque);
        anetaresiaList.add(obj2);
        Anetaresia obj3 = new Anetaresia("Enis","Jusufi",R.mipmap.mosque);
        anetaresiaList.add(obj3);

        return anetaresiaList;
    }
}

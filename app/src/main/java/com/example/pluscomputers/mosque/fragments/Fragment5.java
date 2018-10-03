package com.example.pluscomputers.mosque.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pluscomputers.mosque.R;
import com.example.pluscomputers.mosque.adapters.AnetaresiaAdapter;
import com.example.pluscomputers.mosque.model.Anetaresia;

import java.util.ArrayList;
import java.util.List;

public class Fragment5 extends Fragment {

    private RecyclerView recyclerView5;
    private List<Anetaresia> anetaresiaList = new ArrayList<>();

    public Fragment5() {
    }

    public static Fragment5 newInstance() {
        Fragment5 fragment = new Fragment5();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main5, container, false);

        recyclerView5 = rootView.findViewById(R.id.recyclerView5);

        AnetaresiaAdapter adapter = new AnetaresiaAdapter(getContext());

        adapter.setAnetaresia(listAnetaresia());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView5.setLayoutManager(layoutManager);
        recyclerView5.setAdapter(adapter);

        return rootView;


    }

    public List<Anetaresia> listAnetaresia() {

        anetaresiaList.clear();

        Anetaresia obj1 = new Anetaresia("Tefik Osmani", "Kommisionsleiter", R.drawable.about_background);
        anetaresiaList.add(obj1);
        Anetaresia obj2 = new Anetaresia("Braim Alili", "Member", R.drawable.news_photo1);
        anetaresiaList.add(obj2);
        Anetaresia obj3 = new Anetaresia("Enes Pidic", "Member", R.drawable.news_photo2);
        anetaresiaList.add(obj3);
        Anetaresia obj4 = new Anetaresia("Cesur Citak", "Member", R.drawable.news_photo2);
        anetaresiaList.add(obj4);

        return anetaresiaList;
    }
}
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

public class Fragment3 extends Fragment {

    private RecyclerView recyclerView3;
    private List<Anetaresia> anetaresiaList = new ArrayList<>();

    public Fragment3() {
    }

    public static Fragment3 newInstance() {
        Fragment3 fragment = new Fragment3();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main3, container, false);

        recyclerView3 = rootView.findViewById(R.id.recyclerView3);

        AnetaresiaAdapter adapter = new AnetaresiaAdapter(getContext());

        adapter.setAnetaresia(listAnetaresia());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView3.setLayoutManager(layoutManager);
        recyclerView3.setAdapter(adapter);

        return rootView;


    }

    public List<Anetaresia> listAnetaresia() {

        anetaresiaList.clear();

        Anetaresia obj1 = new Anetaresia("Bedzet Salai", "Kommisionsleiter", R.drawable.about_background);
        anetaresiaList.add(obj1);
        Anetaresia obj2 = new Anetaresia("Besim Osmani", "Member", R.drawable.news_photo1);
        anetaresiaList.add(obj2);
        Anetaresia obj3 = new Anetaresia("Ejup Ademi", "Member", R.drawable.news_photo2);
        anetaresiaList.add(obj3);
        Anetaresia obj4 = new Anetaresia("Sami Tairi", "Member", R.drawable.news_photo2);
        anetaresiaList.add(obj4);
        Anetaresia obj5 = new Anetaresia("Fikret Xheladini", "Member", R.drawable.news_photo2);
        anetaresiaList.add(obj5);

        return anetaresiaList;
    }
}
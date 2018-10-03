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

public class Fragment2 extends Fragment {

    private RecyclerView recyclerView2;
    private List<Anetaresia> anetaresiaList = new ArrayList<>();

    public Fragment2() {
    }

    public static Fragment2 newInstance() {
        Fragment2 fragment = new Fragment2();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main2, container, false);

        recyclerView2 = rootView.findViewById(R.id.recyclerView2);

        AnetaresiaAdapter adapter = new AnetaresiaAdapter(getContext());

        adapter.setAnetaresia(listAnetaresia());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView2.setLayoutManager(layoutManager);
        recyclerView2.setAdapter(adapter);

        return rootView;


    }

    public List<Anetaresia> listAnetaresia() {

        anetaresiaList.clear();

        Anetaresia obj1 = new Anetaresia("Sami Mustafa", "Kommisionsleiter", R.drawable.about_background);
        anetaresiaList.add(obj1);
        Anetaresia obj2 = new Anetaresia("Xhemasi Abazi", "Member", R.drawable.news_photo1);
        anetaresiaList.add(obj2);
        Anetaresia obj3 = new Anetaresia("Iradet Ramadani", "Member", R.drawable.news_photo2);
        anetaresiaList.add(obj3);
        Anetaresia obj4 = new Anetaresia("Shefik Xheladini", "Member", R.drawable.news_photo2);
        anetaresiaList.add(obj4);
        Anetaresia obj5 = new Anetaresia("Ali Ademi", "Member", R.drawable.news_photo2);
        anetaresiaList.add(obj5);

        return anetaresiaList;
    }
}
package com.rrokullia.pluscomputers.mosque.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rrokullia.pluscomputers.mosque.R;
import com.rrokullia.pluscomputers.mosque.adapters.AnetaresiaAdapter;
import com.rrokullia.pluscomputers.mosque.model.Anetaresia;

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

        Anetaresia obj1 = new Anetaresia("Arben Bejtula", "Mitglied des Rates", R.drawable.anetaresia_nophoto);
        anetaresiaList.add(obj1);
        Anetaresia obj2 = new Anetaresia("Esref Jusufi", "Mitglied des Rates", R.drawable.anetaresia_nophoto);
        anetaresiaList.add(obj2);
        Anetaresia obj3 = new Anetaresia("Shefik Xheladini", "Mitglied des Rates", R.drawable.anetaresia_nophoto);
        anetaresiaList.add(obj3);
        Anetaresia obj4 = new Anetaresia("Aliresat Ismani", "Mitglied des Rates", R.drawable.anetaresia_nophoto);
        anetaresiaList.add(obj4);
        Anetaresia obj5 = new Anetaresia("Muzafer Beluli", "Mitglied des Rates", R.drawable.anetaresia_nophoto);
        anetaresiaList.add(obj5);

        return anetaresiaList;
    }
}
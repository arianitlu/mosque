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

public class Fragment6 extends Fragment {

    private RecyclerView recyclerView6;
    private List<Anetaresia> anetaresiaList = new ArrayList<>();

    public Fragment6() {
    }

    public static Fragment6 newInstance() {
        Fragment6 fragment = new Fragment6();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main6, container, false);

        recyclerView6 = rootView.findViewById(R.id.recyclerView6);

        AnetaresiaAdapter adapter = new AnetaresiaAdapter(getContext());

        adapter.setAnetaresia(listAnetaresia());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView6.setLayoutManager(layoutManager);
        recyclerView6.setAdapter(adapter);

        return rootView;


    }

    public List<Anetaresia> listAnetaresia() {

        Anetaresia obj1 = new Anetaresia("Dzelal Ademi", "Kommisionsleiter", R.drawable.about_background);
        anetaresiaList.add(obj1);
        Anetaresia obj2 = new Anetaresia("Abdildzemil Bajrami", "Member", R.drawable.news_photo1);
        anetaresiaList.add(obj2);
        Anetaresia obj3 = new Anetaresia("Belul Beluli", "Member", R.drawable.news_photo2);
        anetaresiaList.add(obj3);
        Anetaresia obj4 = new Anetaresia("Esref Jusufi", "Member", R.drawable.news_photo2);
        anetaresiaList.add(obj4);
        Anetaresia obj5 = new Anetaresia("Dashmi Aziri", "Member", R.drawable.news_photo2);
        anetaresiaList.add(obj5);

        return anetaresiaList;
    }
}
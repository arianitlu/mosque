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

public class Fragment1 extends Fragment {

    private RecyclerView recyclerView;
    private List<Anetaresia> anetaresiaList = new ArrayList<>();
    AnetaresiaAdapter adapter;

    public Fragment1() {
    }

    public static Fragment1 newInstance() {
        Fragment1 fragment = new Fragment1();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);


        recyclerView = rootView.findViewById(R.id.recyclerView1);

        adapter = new AnetaresiaAdapter(getContext());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setAnetaresia(listAnetaresia());

        return rootView;

    }

    public List<Anetaresia> listAnetaresia() {

        anetaresiaList.clear();

        Anetaresia obj1 = new Anetaresia("Abdulla Mustafa","Präsident",R.drawable.anetaresia_nophoto);
        anetaresiaList.add(obj1);
        Anetaresia obj2 = new Anetaresia("Sami Mustafa","Vizepräsidant",R.drawable.anetaresia_nophoto);
        anetaresiaList.add(obj2);
        Anetaresia obj3 = new Anetaresia("Hikmet Selami","Sekretär",R.drawable.anetaresia_nophoto);
        anetaresiaList.add(obj3);
        Anetaresia obj4 = new Anetaresia("Xhemil Jakupi","Kassier",R.drawable.anetaresia_nophoto);
        anetaresiaList.add(obj4);

        return anetaresiaList;
    }
}
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

public class Fragment4 extends Fragment {

    private RecyclerView recyclerView4;
    private List<Anetaresia> anetaresiaList = new ArrayList<>();

    public Fragment4() {
    }

    public static Fragment4 newInstance() {
        Fragment4 fragment = new Fragment4();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main4, container, false);

        recyclerView4 = rootView.findViewById(R.id.recyclerView4);

        AnetaresiaAdapter adapter = new AnetaresiaAdapter(getContext());

        adapter.setAnetaresia(listAnetaresia());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView4.setLayoutManager(layoutManager);
        recyclerView4.setAdapter(adapter);

        return rootView;


    }

    public List<Anetaresia> listAnetaresia() {

        anetaresiaList.clear();

        Anetaresia obj1 = new Anetaresia("Abi Muhtari", "Kommisionsleiter", R.drawable.anetaresia_nophoto);
        anetaresiaList.add(obj1);
        Anetaresia obj2 = new Anetaresia("Idriz Sheapi", "Member", R.drawable.anetaresia_nophoto);
        anetaresiaList.add(obj2);
        Anetaresia obj3 = new Anetaresia("Bujar Zenuni", "Member", R.drawable.anetaresia_nophoto);
        anetaresiaList.add(obj3);
        Anetaresia obj4 = new Anetaresia("Sulejman Ramadani", "Member", R.drawable.anetaresia_nophoto);
        anetaresiaList.add(obj4);

        return anetaresiaList;
    }
}
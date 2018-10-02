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

public class Fragment1 extends Fragment {

    private RecyclerView recyclerView;
    private List<Anetaresia> anetaresiaList = new ArrayList<>();

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

        AnetaresiaAdapter adapter = new AnetaresiaAdapter(getContext());

        adapter.setAnetaresia(listAnetaresia());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return rootView;


    }

    public List<Anetaresia> listAnetaresia() {

        Anetaresia obj1 = new Anetaresia("Bekim Alimi","Projektmanager",R.mipmap.ic_launcher);
        anetaresiaList.add(obj1);
        Anetaresia obj2 = new Anetaresia("Hashim Selami","Member",R.mipmap.ic_launcher);
        anetaresiaList.add(obj2);
        Anetaresia obj3 = new Anetaresia("Amir Muaremi","Member",R.mipmap.ic_launcher);
        anetaresiaList.add(obj3);
        Anetaresia obj4 = new Anetaresia("Ixhet Rexhepi","Member",R.mipmap.ic_launcher);
        anetaresiaList.add(obj4);
        Anetaresia obj5 = new Anetaresia("Rami Musliu","Member",R.mipmap.ic_launcher);
        anetaresiaList.add(obj5);

        return anetaresiaList;
    }
}